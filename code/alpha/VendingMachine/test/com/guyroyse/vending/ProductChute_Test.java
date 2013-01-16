package com.guyroyse.vending;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class ProductChute_Test {
	
	private ProductChute productChute;
	
	@Before
	public void setup() {		
		productChute = new ProductChute();
	}
	
	@Test
	public void itStartsLifeEmpty() {
		assertThat(productChute.nextProduct(), is(nullValue()));		
	}
	
	@Test
	public void itAcceptsCoins() {
		productChute.add(Product.COLA);
		assertThat(productChute.nextProduct(), is(Product.COLA));
	}

	@Test
	public void itIsEmptyAfterCoinIsTaken() {
		productChute.add(Product.COLA);
		productChute.nextProduct();
		assertThat(productChute.nextProduct(), is(nullValue()));
	}
	
	@Test
	public void itHoldsMultipleCoins() {
		productChute.add(Product.COLA);
		productChute.add(Product.COLA);
		assertThat(productChute.nextProduct(), is(Product.COLA));
		assertThat(productChute.nextProduct(), is(Product.COLA));
	}
	
}

