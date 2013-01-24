package com.guyroyse.vending;

import java.util.Stack;

public class ProductChute {
	
	private Stack<Product> stack = new Stack<Product>();
	
	public void add(Product product) {
		stack.push(product);
	}
	
	public Product nextProduct() {
		if (stack.empty()) return null;
		return stack.pop();
	}

}
