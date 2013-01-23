package com.guyroyse.vending;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Inventory_Test {
	
	Inventory inventory;
	
	@Before
	public void setup() {
		ApplicationContext context = new ClassPathXmlApplicationContext("vending-machine-context.xml");
		inventory = (Inventory) context.getBean("inventory");
	}

	@Test
	public void itStartsWithAnInventoryOfZero() {
		assertEquals(0, inventory.check(Product.COLA));
	}

	@Test
	public void itIncreasesInventoryWhenProductIsStocked() {
		stockTwoColas();
		assertEquals(2, inventory.check(Product.COLA));
	}
	
	@Test
	public void itReducesInventoryWhenProductIsRemoved() throws SoldOutException {
		stockTwoColas();
		inventory.take(Product.COLA);
		assertEquals(1, inventory.check(Product.COLA));
	}
	
	@Test(expected = SoldOutException.class)
	public void itComplainsWhenTakingProductWithInventoryOfZero() throws SoldOutException {
		inventory.take(Product.COLA);		
	}

	private void stockTwoColas() {
		inventory.stock(Product.COLA);
		inventory.stock(Product.COLA);
	}

}
