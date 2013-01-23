package com.guyroyse.vending;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachine_WhenSelectingProduct_Test extends VendingMachine_TestHelper {

	@Before
	public void setup() {
		bootMachine();
		addInventory();
		insertOneDollar();
	}

	@Test
	public void itSellsCola() throws VendingException {
		machine().selectCola();
		assertThat(machine().takeProductFromChute(), is(Product.COLA));
	}
	
	@Test
	public void itSellsChips() throws VendingException {
		machine().selectChips();
		assertThat(machine().takeProductFromChute(), is(Product.CHIPS));
	}

	@Test
	public void itSellsCandy() throws VendingException {
		machine().selectCandy();
		assertThat(machine().takeProductFromChute(), is(Product.CANDY));
	}
	
	@Test
	public void itDisplaysThankYou() throws VendingException {
		machine().selectCola();
		assertThat(display(), is("THANK YOU"));
	}

	@Test
	public void itDisplaysInsertCoinsAfterThankYou() throws VendingException {
		machine().selectCola();
		display();
		assertThat(display(), is("INSERT COIN"));
	}
	
	@Test
	public void itRemovesProductFromInventory() throws VendingException {
		
		Inventory inventoryMock = mock(Inventory.class);
		machine().setInventory(inventoryMock);
		
		machine().selectCola();
		
		verify(inventoryMock).take(Product.COLA);		
	}
	
}
