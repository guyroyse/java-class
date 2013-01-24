package com.guyroyse.vending;

import org.junit.Before;
import org.junit.Test;

public class VendingMachine_WhenSelectingSoldOutProduct_Test extends
		VendingMachine_TestHelper {

	@Before
	public void setup() {
		bootMachine();
		insertOneDollar();
	}
	
	@Test(expected = SoldOutException.class)
	public void itRejectsProductSelection() throws VendingException {
		machine().selectCandy();
	}

}
