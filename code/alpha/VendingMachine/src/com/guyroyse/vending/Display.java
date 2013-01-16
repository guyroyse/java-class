package com.guyroyse.vending;

public class Display {

	private String display = "";
	
	public String getValue() {
		return display;
	}
	
	public void thankYou() {
		display = "THANK YOU";
	}
	
	public void amount(long amount) {
		display = amount == 0 ? "INSERT COIN" : formatAmount(amount);		
	}
	
	private String formatAmount(long amount) {
		return String.format("%4.2f", amount / 100.00);
	}
	

}
