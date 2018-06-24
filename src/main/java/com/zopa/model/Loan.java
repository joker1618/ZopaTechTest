package com.zopa.model;

import java.math.BigDecimal;

public class Loan {

	private double pv;
	private double annualRate;
	private int monthsDuration;
	private double monthlyPayment;

	public Loan(double pv, double annualRate, int monthsDuration, double monthlyPayment) {
		this.pv = pv;
		this.annualRate = annualRate;
		this.monthsDuration = monthsDuration;
		this.monthlyPayment = monthlyPayment;
	}

	public double getPv() {
		return pv;
	}

	public double getAnnualRate() {
		return annualRate;
	}

	public int getMonthsDuration() {
		return monthsDuration;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public double getTotalPayment() {
		return monthlyPayment * monthsDuration;
	}
}
