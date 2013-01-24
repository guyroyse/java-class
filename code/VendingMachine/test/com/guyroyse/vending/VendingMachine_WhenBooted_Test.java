package com.guyroyse.vending;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachine_WhenBooted_Test extends VendingMachine_TestHelper {
	
	@Before
	public void setup() {
		bootMachine();
	}

	@Test
	public void itDisplaysInsertCoin() {
		assertThat(display(), is("INSERT COIN"));
	}
	
	@Test
	public void itHasAnEmptyCoinsReturn() {
		assertThat(machine().takeCoinFromReturn(), is(nullValue()));
	}

	@Test
	public void itHasAnEmptyProductChute() {
		assertThat(machine().takeProductFromChute(), is(nullValue()));
	}
	
}


