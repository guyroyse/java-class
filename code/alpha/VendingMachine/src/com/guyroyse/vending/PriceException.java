package com.guyroyse.vending;

@SuppressWarnings("serial")
public class PriceException extends Exception {
	
	private long price = 0;
	
	public PriceException(long price) {
		this.price = price;
	}

	public long getExpectedPrice() {
		return price;
	}

}
