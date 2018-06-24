package com.zopa.exceptions;

public class MarketException extends Exception {

	public MarketException(String message) {
		super(message);
	}

	public MarketException(String message, Throwable cause) {
		super(message, cause);
	}

	public MarketException(Throwable cause) {
		super(cause);
	}
}
