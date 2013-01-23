package com.guyroyse.vending;

public class VendingMachine {
	
	private CoinReturn coinReturn = new CoinReturn();
	private ProductChute productChute = new ProductChute();
	
	private InsertedCoins insertedCoins;
	public void setInsertedCoins(InsertedCoins insertedCoins) {
		this.insertedCoins = insertedCoins;
	}

	private Display display;
	public void setDisplay(Display display) {
		this.display = display;
	}

	private CoinLookup coinLookup;
	public void setCoinLookup(CoinLookup coinLookup) {
		this.coinLookup = coinLookup;
	}
	
	private Inventory inventory;
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public String readDisplay() {
		return display.value();
	}

	public void insertCoin(Coin coin) {
		if (coinLookup.invalid(coin))
			coinReturn.add(coin);
		else
			insertedCoins.addCoin(coin);
	}

	public void selectCola() throws VendingException {
		selectProduct(Product.COLA);
	}
	
	public void selectChips() throws VendingException {
		selectProduct(Product.CHIPS);
	}
	
	public void selectCandy() throws VendingException {
		selectProduct(Product.CANDY);
	}

	private void selectProduct(Product product) throws VendingException {
		verifyAmount(product);		
		inventory.take(product);
		productChute.add(product);
		returnChange(product);
		display.thankYou();
		insertedCoins.reset();
	}

	public Coin takeCoinFromReturn() {
		return coinReturn.nextCoin();
	}

	public Product takeProductFromChute() {
		return productChute.nextProduct();
	}

	public void stockProduct(Product product) {
		inventory.stock(product);
	}
	
	private void verifyAmount(Product product) throws PriceException {
		if (insertedCoins.total() < product.getPrice())
			throw new PriceException(product.getPrice());
	}
	
	private void returnChange(Product product) {
		long changeDue = insertedCoins.total() - product.getPrice();
		while (changeDue > 0) changeDue = processChange(changeDue);
	}

	private long processChange(long changeDue) {
		Coin largestCoin = coinLookup.largestCoin(changeDue);
		coinReturn.add(largestCoin);
		return changeDue - coinLookup.value(largestCoin);
	}

}
