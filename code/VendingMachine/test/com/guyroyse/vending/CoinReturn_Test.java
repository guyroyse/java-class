package com.guyroyse.vending;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class CoinReturn_Test {
	
	private CoinReturn coinReturn;
	
	@Before
	public void setup() {		
		coinReturn = new CoinReturn();
	}
	
	@Test
	public void itStartsLifeEmpty() {
		assertThat(coinReturn.nextCoin(), is(nullValue()));		
	}
	
	@Test
	public void itAcceptsCoins() {
		coinReturn.add(Coin.PENNY);
		assertThat(coinReturn.nextCoin(), is(Coin.PENNY));
	}

	@Test
	public void itIsEmptyAfterCoinIsTaken() {
		coinReturn.add(Coin.PENNY);
		coinReturn.nextCoin();
		assertThat(coinReturn.nextCoin(), is(nullValue()));
	}
	
	@Test
	public void itHoldsMultipleCoins() {
		coinReturn.add(Coin.PENNY);
		coinReturn.add(Coin.PENNY);
		assertThat(coinReturn.nextCoin(), is(Coin.PENNY));
		assertThat(coinReturn.nextCoin(), is(Coin.PENNY));
	}
	
}

