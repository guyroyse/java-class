package com.guyroyse.vending;

@SuppressWarnings("serial")
public class PriceException extends VendingException {
	
	private long price = 0;
	
	public PriceException(long price) {
		this.price = price;
	}

	public long getExpectedPrice() {
		return price;
	}

}
