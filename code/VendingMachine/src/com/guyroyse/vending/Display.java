package com.guyroyse.vending;

public class Display {
	
	private boolean displayMessage = false;
	private String message = "";
	private long amount = 0;

	public String value() {
		if (!displayMessage) return formatAmount();
		displayMessage = false;
		return message;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	public void thankYou() {
		displayMessage("THANK YOU");
	}
	
	private void displayMessage(String message) {
		displayMessage = true;
		this.message = message;
	}

	private String formatAmount() {
		return amount == 0 ? "INSERT COIN" : formatDollarAmount(amount);
	}
	
	private String formatDollarAmount(long amount) {
		return String.format("%4.2f", amount / 100.00);
	}
	
}
