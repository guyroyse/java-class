package com.guyroyse.vending;

import java.util.Stack;

public class CoinReturn {

	private Stack<Coin> stack = new Stack<Coin>();
	
	public void add(Coin coin) {
		stack.push(coin);
	}
	
	public Coin nextCoin() {
		if (stack.empty()) return null;
		return stack.pop();
	}

}
