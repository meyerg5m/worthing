package com.worthing.model;

import java.math.BigDecimal;

public class Discount {
	
	private String scannedItemIdentifier = null;
	private int quantity = 0;
	private int forThePriceOf = 0;
	private BigDecimal basePrice = null;
	

	public Discount(String scannedItemIdentifier, int quantity, int forThePriceOf, BigDecimal basePrice) {
		this.scannedItemIdentifier = scannedItemIdentifier;
		this.quantity = quantity;
		this.forThePriceOf = forThePriceOf;
		this.basePrice = basePrice;
	}

	public String getScannedItemIdentifier() {
		return scannedItemIdentifier;
	}
	
	public void setScannedItemIdentifier(String scannedItemIdentifier) {
		this.scannedItemIdentifier = scannedItemIdentifier;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getForThePriceOf() {
		return forThePriceOf;
	}
	
	public void setForThePriceOf(int forThePriceOf) {
		this.forThePriceOf = forThePriceOf;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}
	

}
