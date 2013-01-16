package com.guyroyse.vending;

import java.util.ArrayList;
import java.util.List;

public class ProductChute {

	private List<Product> products = new ArrayList<Product>();
	
	public void add(Product product) {
		products.add(product);
	}
	
	public Product nextProduct() {
		if (products.isEmpty()) return null;
		return products.remove(lastProduct());
	}

	private int lastProduct() {
		return products.size() - 1;
	}

}
