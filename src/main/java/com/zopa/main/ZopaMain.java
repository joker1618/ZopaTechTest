package com.zopa.main;

import com.zopa.computer.LoanComputer;
import com.zopa.computer.LoanComputerFactory;
import com.zopa.computer.LoanComputerMethod;
import com.zopa.exceptions.MarketException;
import com.zopa.market.MarketProvider;
import com.zopa.market.MarketProviderFactory;
import com.zopa.model.Loan;

import java.io.IOException;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.zopa.utils.ZopaUtils.display;
import static com.zopa.utils.ZopaUtils.formatDouble;

public class ZopaMain {

	static final String marketPath = "C:\\Users\\f.barbano\\IdeaProjects\\interviews\\ZopaTechTest\\zopa_data\\market.csv";
	static final double pv = 1000;
//	static final double rate = 0.0;
	static final int months = 36;

	public static void main(String[] args) throws IOException, MarketException {

		Path csvMarketPath = Paths.get(marketPath);
		MarketProvider marketProvider = MarketProviderFactory.getMarketProvider(csvMarketPath);

		LoanComputer loanComputer = LoanComputerFactory.getLoanComputer(LoanComputerMethod.FRENCH_FINANCIAL);
		loanComputer.addLenders(marketProvider.getLenderList());
		Loan loan = loanComputer.computeLoan(pv, months);

		if(loan == null) {
			display("Loan not computed");
		} else {
			display("PV: %s", formatDouble(loan.getPv(), 2));
			display("Rate: %s", formatDouble(loan.getAnnualRate()*100, 1, RoundingMode.DOWN));
			display("Monthly repayment: %s", formatDouble(loan.getMonthlyPayment(), 2, RoundingMode.DOWN));
			display("Total repayment: %s", formatDouble(loan.getTotalPayment(), 2, RoundingMode.DOWN));
		}

	}

	public static void mainNew(String[] args) {

	}

	private static UserInput parseUserInput(String[] args) {
		UserInput userInput = null;
		// todo impl
		return userInput;
	}

	private static class UserInput {
		Path csvMarketPath;
		int loanAmount;

		UserInput(Path csvMarketPath, int loanAmount) {
			this.csvMarketPath = csvMarketPath;
			this.loanAmount = loanAmount;
		}
	}
}
