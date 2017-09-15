package com.worthing;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.worthing.model.Apple;
import com.worthing.model.Discount;
import com.worthing.model.Orange;
import com.worthing.model.ScannedItem;
import com.worthing.utils.DiscountCalculator;
import com.worthing.utils.TotalCalculator;

public class Worthing {
	
	private static final String INSTRUCTIONS = "Scan an item. (Enter 'a' for apple, 'o' for 'orange', 'r' to restart, 'q' to quit, 'h' for help).\nPress enter after a command.";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<ScannedItem> cart = new ArrayList<ScannedItem>();
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		Map<String, Discount> discounts = new HashMap<String, Discount>(2);
		discounts.put(Apple.IDENTIFIER, new Discount(Apple.IDENTIFIER, 2, 1, Apple.PRICE));
		discounts.put(Orange.IDENTIFIER, new Discount(Orange.IDENTIFIER, 3, 2, Orange.PRICE));
		
		System.out.println(INSTRUCTIONS);
		while(true) {
			switch (scanner.next()) {
				case "h":
					System.out.println(INSTRUCTIONS);
					break;
				case "a":
					System.out.println(Apple.NAME + " " + currencyFormatter.format(Apple.PRICE));
					cart.add(new Apple());
					displayTotal(cart, discounts, currencyFormatter);
					break;
				case "o":
					System.out.println(Orange.NAME + " " + currencyFormatter.format(Orange.PRICE));
					cart.add(new Orange());
					displayTotal(cart, discounts, currencyFormatter);
					break;	
				case "r":
					System.out.println("Cart emptied");
					System.out.println(INSTRUCTIONS);
					cart.clear();
					break;
				case "q":
					return;
			}	
		}
		
		
	}
	
	private static void displayTotal(ArrayList<ScannedItem> cart, Map<String, Discount> discounts, NumberFormat currencyFormatter) {
		BigDecimal total = TotalCalculator.getTotal(cart);
		BigDecimal discount = DiscountCalculator.calculateDiscount(cart, discounts);
		System.out.println("Total: " + currencyFormatter.format(total));
		System.out.println("Total after discounts: " + currencyFormatter.format(total.subtract(discount)));
		System.out.println("You have saved: " + currencyFormatter.format(discount));
		System.out.println("Scan next item or enter 'h' for help.");
	}

}
