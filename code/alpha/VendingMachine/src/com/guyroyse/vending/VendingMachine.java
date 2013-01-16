package com.guyroyse.vending;

public class VendingMachine {
	
	private Display display = new Display();
	private CoinLookup coinLookup = new CoinLookup();
	private CoinReturn coinReturn = new CoinReturn();
	private ProductChute productChute = new ProductChute();
	
	private long currentAmount = 0;
	private boolean productJustPurchased = false;
	
	public String getDisplay() {
		
		if (productJustPurchased) {
			reset();
			display.thankYou();
		} else {
			display.amount(currentAmount);
		}
		
		return display.getValue();
	}

	public void insertCoin(Coin coin) {
		if (coinLookup.invalid(coin)) coinReturn.add(coin);
		currentAmount += coinLookup.value(coin);
	}

	public void selectCola() throws PriceException {
		selectProduct(Product.COLA);
	}
	
	public void selectChips() throws PriceException {
		selectProduct(Product.CHIPS);
	}
	
	public void selectCandy() throws PriceException {
		selectProduct(Product.CANDY);
	}

	public Coin takeCoinFromReturn() {
		return coinReturn.nextCoin();
	}

	public Product takeProductFromChute() {
		return productChute.nextProduct();
	}

	private void reset() {
		currentAmount = 0;
		productJustPurchased = false;
	}
	
	private void selectProduct(Product product) throws PriceException {
		verifyAmount(product);		
		dispenseProduct(product);
		returnChange(product);
	}

	private void verifyAmount(Product product) throws PriceException {
		if (currentAmount < product.getPrice()) throw new PriceException(product.getPrice());
	}

	private void dispenseProduct(Product product) {
		productJustPurchased = true;
		productChute.add(product);
	}

	private void returnChange(Product product) {
		long changeDue = currentAmount - product.getPrice();
		
		while (changeDue > 0) {
			Coin largestCoin = coinLookup.largestCoin(changeDue);
			changeDue -= coinLookup.value(largestCoin);
			coinReturn.add(largestCoin);
		}
		
	}
	
}