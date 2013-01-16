package com.guyroyse.vending;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachine_WhenSelectingProductAndChangeIsDue_Test extends VendingMachine_TestHelper {

	@Before
	public void setup() {
		bootMachine();
	}

	@Test
	public void itReturnsNickels() throws PriceException {
		insertFiftyFiveCents();		
		machine().selectChips();
		assertThat(machine().takeCoinFromReturn(), is(Coin.NICKEL));
	}

	@Test
	public void itReturnsDimes() throws PriceException {
		insertSixtyCents();		
		machine().selectChips();
		assertThat(machine().takeCoinFromReturn(), is(Coin.DIME));
	}

	@Test
	public void itReturnsQuarters() throws PriceException {
		insertSeventyFiveCents();		
		machine().selectChips();
		assertThat(machine().takeCoinFromReturn(), is(Coin.QUARTER));
	}

	@Test
	public void itReturnsFortyCentsAsQuarterDimeAndNickel() throws PriceException {
		insertNinetyCents();		
		machine().selectChips();
		assertThat(machine().takeCoinFromReturn(), is(Coin.NICKEL));
		assertThat(machine().takeCoinFromReturn(), is(Coin.DIME));
		assertThat(machine().takeCoinFromReturn(), is(Coin.QUARTER));
	}

	@Test
	public void itReturnsTwentyCentsAsTwoDimes() throws PriceException {
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
