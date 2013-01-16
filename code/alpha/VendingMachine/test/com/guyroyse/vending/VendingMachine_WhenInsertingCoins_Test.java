package com.guyroyse.vending;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachine_WhenInsertingCoins_Test extends VendingMachine_TestHelper {
	
	@Before
	public void setup() {
		bootMachine();
	}

	@Test
	public void itDisplaysFiveCentsWhenNickleIsInserted() {
		insertNickel();
		assertThat(display(), is("0.05"));
	}

	@Test
	public void itDisplaysTenCentsWhenDimeIsInserted() {
		insertDime();
		assertThat(display(), is("0.10"));
	}

	@Test
	public void itDisplaysTwentyFiveCentsWhenQuarterIsInserted() {
		insertQuarter();
		assertThat(display(), is("0.25"));
	}
	
	@Test
	public void itDisplaysTotalWhenMultipleCoinsAreInserted() {
		insertNickel();
		insertDime();
		insertQuarter();
		assertThat(display(), is("0.40"));
	}
	
	@Test
	public void itDoesntPutCoinInCoinReturn() {
		insertNickel();
		assertThat(machine().takeCoinFromReturn(), is(nullValue()));
	}

}
