package com.guyroyse.vending;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachine_WhenSelectingProduct_Test extends VendingMachine_TestHelper {

	@Before
	public void setup() {
		bootMachine();		
		insertOneDollar();
	}

	@Test
	public void itSellsCola() throws PriceException {
		machine().selectCola();
		assertThat(machine().takeProductFromChute(), is(Product.COLA));
	}
	
	@Test
	public void itSellsChips() throws PriceException {
		machine().selectChips();
		assertThat(machine().takeProductFromChute(), is(Product.CHIPS));
	}

	@Test
	public void itSellsCandy() throws PriceException {
		machine().selectCandy();
		assertThat(machine().takeProductFromChute(), is(Product.CANDY));
	}
	
	@Test
	public void itDisplaysThankYou() throws PriceException {
		machine().selectCola();
		assertThat(display(), is("THANK YOU"));
	}

	@Test
	public void itDisplaysInsertCoinsAfterThankYou() throws PriceException {
		machine().selectCola();
		display();
		assertThat(display(), is("INSERT COIN"));
	}
	
}
