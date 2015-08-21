package com.insart.javaTrainee.main;

import com.insart.javaTrainee.comparator.SortingByPriceByDescendingWay;
import com.insart.javaTrainee.containerOfProducts.ContainerOfPrintedProducts;
import com.insart.javaTrainee.printedProducts.*;

public class PrintedProductsTest {

	public static void main(String[] args) {
		
		ContainerOfPrintedProducts products = ContainerOfPrintedProducts.getInstance();
		
		PrintedProduct[] arrayOfProducts = new PrintedProduct[4];
		arrayOfProducts[0] = new Book("Core Java",500,"programming","hardcover",2015);
		arrayOfProducts[1] = new Book("Effective Java 2",800,"programming","softcover",2008);
		arrayOfProducts[2] = new Magazine("Dr. Dobb's Journal", 200, 3,"programming",false);
		arrayOfProducts[3] = new Magazine("Java Developer's Journal",300,11,"programming",false);
		
		for(int i=0; i<arrayOfProducts.length;i++){
			products.add(arrayOfProducts[i]);
		}
		
		System.out.println("All products contained in the container: ");
		products.print();
		
		System.out.println("\n"+"Elements in the container are sorted by price by ascending way: ");
		products.sort(null);
		products.print();
		
		System.out.println("\n"+"Elements in the container are sorted by price by descending way: ");
		products.sort(new SortingByPriceByDescendingWay());
		products.print();
	}

}
