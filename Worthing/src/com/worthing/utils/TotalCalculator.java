package com.worthing.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

import com.worthing.model.Discount;
import com.worthing.model.ScannedItem;

public class TotalCalculator {
	
	private TotalCalculator() {
		
	}
	
	public static BigDecimal getTotal(ArrayList<ScannedItem> cart) {
		Iterator<ScannedItem> it = cart.iterator();
		BigDecimal total = new BigDecimal("0.00");
		while (it.hasNext()) {
			total = total.add(it.next().getPrice());
		}
		return total;
	}

}
