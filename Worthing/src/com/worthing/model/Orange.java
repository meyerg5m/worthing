package com.worthing.model;

import java.math.BigDecimal;

public class Orange implements ScannedItem {

	public static final String IDENTIFIER = "o";
	public static final String NAME = "Orange";
	public static final BigDecimal PRICE = new BigDecimal("0.25");
	
	public BigDecimal getPrice() {
		return PRICE;
	}
	
	public String getIdentifier() {
		return IDENTIFIER;
	} 
}
