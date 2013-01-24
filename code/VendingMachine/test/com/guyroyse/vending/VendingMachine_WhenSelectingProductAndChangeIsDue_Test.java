package com.guyroyse.vending;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachine_WhenSelectingProductAndChangeIsDue_Test extends VendingMachine_TestHelper {

	@Before
	public void setup() {
		bootMachine();
		addInventory();
	}

	@Test
	public void itReturnsNickels() throws VendingException {
		insertFiftyFiveCents();		
		machine().selectChips();
		assertThat(machine().takeCoinFromReturn(), is(Coin.NICKEL));
	}

	@Test
	public void itReturnsDimes() throws VendingException {
		insertSixtyCents();		
		machine().selectChips();
		assertThat(machine().takeCoinFromReturn(), is(Coin.DIME));
	}

	@Test
	public void itReturnsQuarters() throws VendingException {
		insertSeventyFiveCents();		
		machine().selectChips();
		assertThat(machine().takeCoinFromReturn(), is(Coin.QUARTER));
	}

	@Test
	public void itReturnsFortyCentsAsQuarterDimeAndNickel() throws VendingException {
		insertNinetyCents();		
		machine().selectChips();
		assertThat(machine().takeCoinFromReturn(), is(Coin.NICKEL));
		assertThat(machine().takeCoinFromReturn(), is(Coin.DIME));
		assertThat(machine().takeCoinFromReturn(), is(Coin.QUARTER));
	}

	@Test
	public void itReturnsTwentyCentsAsTwoDimes() throws VendingException {
		insertNinetyCents();		
		machine().selectChips();
		assertThat(machine().takeCoinFromReturn(), is(Coin.NICKEL));
		assertThat(machine().takeCoinFromReturn(), is(Coin.DIME));
		assertThat(machine().takeCoinFromReturn(), is(Coin.QUARTER));
	}

	private void insertFiftyFiveCents() {
		insertQuarter();
		insertQuarter();
		insertNickel();
	}
	
	private void insertSixtyCents() {
		insertQuarter();
		insertQuarter();
		insertDime();
	}
	
	private void insertSeventyFiveCents() {
		insertQuarter();
		insertQuarter();
		insertQuarter();
	}
	
	private void insertNinetyCents() {
		insertQuarter();
		insertQuarter();
		insertQuarter();
		insertDime();
		insertNickel();
	}
	
}
