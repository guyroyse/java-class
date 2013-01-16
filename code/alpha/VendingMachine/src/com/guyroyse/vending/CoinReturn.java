package com.guyroyse.vending;

import java.util.ArrayList;
import java.util.List;

public class CoinReturn {

	private List<Coin> coins = new ArrayList<Coin>();
	
	public void add(Coin coin) {
		coins.add(coin);
	}
	
	public Coin nextCoin() {
		if (coins.isEmpty()) return null;
		return coins.remove(lastCoin());
	}

	private int lastCoin() {
		return coins.size() - 1;
	}

}
