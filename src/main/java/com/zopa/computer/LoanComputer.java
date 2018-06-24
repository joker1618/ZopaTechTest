package com.zopa.computer;

import com.zopa.model.Lender;
import com.zopa.model.Loan;

import java.math.BigDecimal;
import java.util.List;

public interface LoanComputer {

	void addLenders(List<Lender> lenders);

	Loan computeLoan(double pv, int monthsDuration);

}
