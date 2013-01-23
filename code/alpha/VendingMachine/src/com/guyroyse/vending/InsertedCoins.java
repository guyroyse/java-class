package com.guyroyse.vending;

public class InsertedCoins {
	
	private long currentAmount = 0;
	
	private CoinLookup coinLookup;
	public void setCoinLookup(CoinLookup coinLookup) {
		this.coinLookup = coinLookup;
	}
		
	private Display display;
	public void setDisplay(Display display) {
		this.display = display;
	}

	public void reset() {
		setCurrentAmount(0);
	}
	
	public void addCoin(Coin coin) {
		long coinValue = coinLookup.value(coin);
		setCurrentAmount(currentAmount + coinValue);
	}

	private void setCurrentAmount(long amount) {
		currentAmount = amount;		
		display.setAmount(amount);
	}
	
	public long total() {
		return currentAmount;
	}
	

}
