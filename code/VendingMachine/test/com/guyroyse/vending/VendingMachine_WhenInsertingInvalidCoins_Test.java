package com.guyroyse.vending;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachine_WhenInsertingInvalidCoins_Test extends VendingMachine_TestHelper {
	
	@Before
	public void setup() {
		bootMachine();		
	}

	@Test
	public void itPlacesCoinInCoinReturn() {
		insertPenny();
		assertThat(machine().takeCoinFromReturn(), is(Coin.PENNY));
	}

}

