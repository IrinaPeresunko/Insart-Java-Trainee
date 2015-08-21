package com.insart.javaTrainee.comparator;

import java.util.Comparator;

import com.insart.javaTrainee.printedProducts.PrintedProduct;

public class SortingByPriceByDescendingWay implements Comparator<PrintedProduct>{
	/*
	 * method to sort element by price by descending way
	 */
	public int compare(PrintedProduct product1, PrintedProduct product2) {
		return product1.getPrice() > product2.getPrice() ? -1 
				: product1.getPrice() == product2.getPrice() ? 0 : 1;
	}
}
