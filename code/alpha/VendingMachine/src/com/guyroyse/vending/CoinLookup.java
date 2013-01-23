package com.guyroyse.vending;

import java.util.Map;
import java.util.SortedMap;

public class CoinLookup {
	
	private SortedMap<Coin, Long> coinsToValues;

	public void setCoinsToValues(SortedMap<Coin, Long> validCoins) {
		this.coinsToValues = validCoins;
	}
	
	public boolean invalid(Coin coin) {
		return !coinsToValues.containsKey(coin);
	}

	public long value(Coin coin) {
		Long value = coinsToValues.get(coin);
		return value == null ? 0 : value.longValue();
	}

	public Coin largestCoin(long value) {
		Coin coin = null;
		for (Map.Entry<Coin, Long> entry : coinsToValues.entrySet()) {
			if (value >= entry.getValue()) {
				coin = entry.getKey();
				break;
			}
		}
		return coin;
	}
	
}
