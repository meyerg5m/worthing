package com.worthing.model;

import java.math.BigDecimal;

public class Apple implements ScannedItem {
	
	public static final String IDENTIFIER = "a";
	public static final String NAME = "Apple";
	public static final BigDecimal PRICE = new BigDecimal("0.60");
	
	public BigDecimal getPrice() {
		return PRICE;
	}
	
	public String getIdentifier() {
		return IDENTIFIER;
	} 

}
