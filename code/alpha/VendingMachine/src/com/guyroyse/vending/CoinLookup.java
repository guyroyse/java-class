package com.guyroyse.vending;

import java.util.HashMap;
import java.util.Map;

public class CoinLookup {

	private static Map<Coin, Long> validCoins = new HashMap<Coin, Long>();
	
	static {
		validCoins.put(Coin.NICKEL, Long.valueOf(5));
		validCoins.put(Coin.DIME, Long.valueOf(10));
		validCoins.put(Coin.QUARTER, Long.valueOf(25));		
	}
	
	public boolean invalid(Coin coin) {
		return !validCoins.containsKey(coin);
	}

	public long value(Coin coin) {
		Long value = validCoins.get(coin);
		return value == null ? 0 : value.longValue();
	}

	public Coin largestCoin(long value) {		
		if (value >= 25) return Coin.QUARTER;
		if (value >= 10) return Coin.DIME;
		if (value >= 5) return Coin.NICKEL;
		return null;
	}
	
}
