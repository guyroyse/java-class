package com.guyroyse.vending;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachine_WhenSelectingProductWithoutEnoughMoney_Test extends VendingMachine_TestHelper {

	@Before
	public void setup() {
		bootMachine();		
		insertQuarter();
	}

	@Test(expected = PriceException.class)
	public void itRejectsProductSelection() throws PriceException {
		machine().selectCola();
	}
	
	@Test
	public void itExpectsOneDollarForCola() {
		try {
			machine().selectCola();
			fail("PriceException expected");
		} catch (PriceException ex) {
			assertEquals(ex.getExpectedPrice(), 100);
		}		
	}
	
	@Test
	public void itExpectsFiftyCentsForChips() {
		try {
			machine().selectChips();
			fail("PriceException expected");
		} catch (PriceException ex) {
			assertEquals(ex.getExpectedPrice(), 50);
		}		
	}

	@Test
	public void itExpectsSixtyFiveCentsForCandy() {
		try {
			machine().selectCandy();
			fail("PriceException expected");
		} catch (PriceException ex) {
			assertEquals(ex.getExpectedPrice(), 65);
		}		
	}

	@Test
	public void itDisplaysCurrentAmountAfterRejection() {
		try {
			machine().selectCola();
		} catch (PriceException ex) {
		}
		assertThat(display(), is("0.25"));
	}
	
}
