package com.guyroyse.vending;

public class VendingMachine_TestHelper {

	private VendingMachine machine;
	
	protected void bootMachine() {
		machine = new VendingMachine();
	}
	
	protected VendingMachine machine() {
		return machine;
	}
	
	protected void insertPenny() {
		machine().insertCoin(Coin.PENNY);
	}

	protected void insertNickel() {
		machine().insertCoin(Coin.NICKEL);
	}

	protected void insertDime() {
		machine().insertCoin(Coin.DIME);
	}

	protected void insertQuarter() {
		machine().insertCoin(Coin.QUARTER);
	}

	protected void insertOneDollar() {
		insertQuarter();
		insertQuarter();
		insertQuarter();
		insertQuarter();
	}

	protected String display() {
		return machine().getDisplay();
	}

}
