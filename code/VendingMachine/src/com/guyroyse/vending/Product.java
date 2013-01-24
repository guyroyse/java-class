package com.guyroyse.vending;

public enum Product {
	
	COLA(100),
	CHIPS(50),
	CANDY(65);

	private long price = 0;
	
	Product(long price) {
		this.price = price;
	}
	
	public long getPrice() {
		return this.price;
	}

}
