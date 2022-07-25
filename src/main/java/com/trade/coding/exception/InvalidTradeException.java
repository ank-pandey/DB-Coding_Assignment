package com.trade.coding.exception;

public class InvalidTradeException extends Exception{

	private final String id;
	
	public InvalidTradeException(final String id) {
		super("Invalid Trade Id is :: " + id);
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
}
