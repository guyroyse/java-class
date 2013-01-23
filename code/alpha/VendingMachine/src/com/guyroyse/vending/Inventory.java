package com.guyroyse.vending;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
	
	private Map<Product, Long> inventory = new HashMap<Product, Long>();

	public long check(Product product) {
		Long amount = inventory.get(product);
		return amount == null ? 0 : amount.longValue();	
	}

	public void stock(Product product) {
		inventory.put(product, check(product) + 1);
	}

	public void take(Product product) throws SoldOutException {
		if (outOfStock(product)) throw new SoldOutException();
		inventory.put(product, check(product) - 1);
	}

	private boolean outOfStock(Product product) {
		return check(product) == 0;
	}

}
