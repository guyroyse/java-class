package com.guyroyse.vending;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VendingMachine_TestHelper {

	private VendingMachine machine;
	
	protected void bootMachine() {
		ApplicationContext context = new ClassPathXmlApplicationContext("vending-machine-context.xml");
		machine = (VendingMachine) context.getBean("vendingMachine");
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
		return machine().readDisplay();
	}

	protected void addInventory() {
		addCola();
		addCandy();
		addChips();
	}
	
	protected void addCola() {
		addProduct(Product.COLA);
	}

	protected void addCandy() {
		addProduct(Product.CANDY);
	}

	protected void addChips() {
		addProduct(Product.CHIPS);
	}

	private void addProduct(Product product) {
		machine().stockProduct(product);
	}
}

