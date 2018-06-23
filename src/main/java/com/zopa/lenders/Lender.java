package com.zopa.lenders;

public class Lender {

	private String name;
	private double rate;
	private double amount;

	public Lender(String name, double rate, double amount) {
		this.name = name;
		this.rate = rate;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public double getRate() {
		return rate;
	}

	public double getAmount() {
		return amount;
	}
}
