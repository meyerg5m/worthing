package com.worthing.utils;

import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.worthing.model.Apple;
import com.worthing.model.Discount;
import com.worthing.model.Orange;
import com.worthing.model.ScannedItem;

public class DiscountCalculator {
	
	private DiscountCalculator() {
		
	}
	
	public static BigDecimal calculateDiscount(ArrayList<ScannedItem> cart, Map<String, Discount> discounts) {
		BigDecimal totalDiscount = new BigDecimal("0.00");
		if (discounts == null || discounts.isEmpty()) {
			return totalDiscount;
		}
		
		for (Entry<String, Discount> entry : discounts.entrySet())
		{
		    int qty = countProduct(entry.getKey(), cart);
		    totalDiscount = totalDiscount.add(getItemDiscount(qty, entry.getValue()));
		}
		
		
		return totalDiscount;
	}
	
	private static int countProduct(String identifier, ArrayList<ScannedItem> cart) {
		Iterator<ScannedItem> it = cart.iterator();
		int qty = 0;
		while(it.hasNext()) {
			ScannedItem item = it.next();
			if (item.getIdentifier().equals(identifier)) {
				qty++;
			}
		}
		return qty;
	}

	private static BigDecimal getItemDiscount(int qtyItems, Discount discount) {
		int qtyFree = (qtyItems/discount.getQuantity()) * (discount.getQuantity() - discount.getForThePriceOf());
		return discount.getBasePrice().multiply(BigDecimal.valueOf(qtyFree));
	}
	
	
}
