package com.zopa.computer;

import com.zopa.model.Lender;
import com.zopa.model.Loan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class LoanComputerFrench implements LoanComputer {

	private static final Logger logger = LoggerFactory.getLogger(LoanComputerFrench.class);

	private List<Lender> lenderList;

	public LoanComputerFrench() {
		this.lenderList = new ArrayList<>();
	}


	@Override
	public void addLenders(List<Lender> lenders) {
		this.lenderList.addAll(lenders);
	}

	@Override
	public Loan computeLoan(double pv, int monthsDuration) {
		lenderList.sort(Comparator.comparingDouble(Lender::getRate));

		double remaining = pv;
		double actualRate = 0d;
		for(int i = 0; i < lenderList.size() && remaining > 0d; i++) {
			Lender l = lenderList.get(i);
			double amount = Math.min(l.getAmount(), remaining);
			double ratePart = l.getRate() * amount / pv;
			actualRate += ratePart;
			remaining -= amount;
			logger.debug("GET from {}\t{}({})\t{}/{}\t{}\t{}\t{}",
				l.getName(),
				amount,
				l.getAmount(),
				pv-remaining,
				pv,
				l.getRate(),
				ratePart,
				actualRate
			);
		}

		Loan loan = null;

		if(remaining == 0d) {
//			double iBanking = actualRate / 12;
			double iFinance = Math.pow(1.0 + actualRate, 1d / 12) - 1;
			double mpay = (pv * iFinance) / (1.0 - Math.pow(1 + iFinance, -1 * monthsDuration));
			loan = new Loan(pv, actualRate, monthsDuration, mpay);
			logger.debug("Computed loan: rate={}, mpay={}, tpay={}", actualRate, mpay, loan.getTotalPayment());
		}

		return loan;
	}
}
