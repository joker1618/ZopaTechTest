package com.zopa.computer;

public class LoanComputerFactory {

	public static LoanComputer getLoanComputer(LoanComputerMethod computerType) {
		LoanComputer computer;

		switch (computerType) {
			case FRENCH_FINANCIAL:
				computer = new LoanComputerFrench();
				break;
			default:
				throw new IllegalArgumentException("No loan computer found for method " + computerType.name());
		}

		return computer;
	}
}
