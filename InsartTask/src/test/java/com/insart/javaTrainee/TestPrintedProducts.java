package com.insart.javaTrainee;

import org.junit.Test;

import com.insart.javaTrainee.comparator.SortingByPriceByDescendingWay;
import com.insart.javaTrainee.containerOfProducts.ContainerOfPrintedProducts;
import com.insart.javaTrainee.printedProducts.*;

import junit.framework.TestCase;

public class TestPrintedProducts extends TestCase{
	
	/*
	 * test to verify that the value of price field is correct
	 */
	@Test
	public void testSetPrice(){
		PrintedProduct product = new Book();
		
		product.setPrice(10);
		double valueOfPrice = product.getPrice();
		assertEquals("the answer should be 10",10.0,valueOfPrice);
		
		product.setPrice(-10);
		valueOfPrice = product.getPrice();
		assertEquals("the answer should be 0",0.0,valueOfPrice);
		
		product.setPrice(0);
		valueOfPrice = product.getPrice();
		assertEquals("the answer should be 0",0.0,valueOfPrice);
	}
	
	/*
	 * test to check that the average price of product calculated correctly
	 */
	@Test
	public void testCalculateTheAveragePriceOfProducts(){
		PrintedProduct.setPriceOfAllProducts(1000);
		PrintedProduct.setCountOfProducts(5);
		double theAveragePriceOfProducts = PrintedProduct.calculateTheAveragePriceOfProducts();
		assertEquals("the answer should be 200",200.0,theAveragePriceOfProducts);
		
		PrintedProduct.setPriceOfAllProducts(1000);
		PrintedProduct.setCountOfProducts(-5);
		theAveragePriceOfProducts = PrintedProduct.calculateTheAveragePriceOfProducts();
		assertEquals("the answer should be 1000",1000.0,theAveragePriceOfProducts);
		
		PrintedProduct.setPriceOfAllProducts(-1000);
		PrintedProduct.setCountOfProducts(5);
		theAveragePriceOfProducts = PrintedProduct.calculateTheAveragePriceOfProducts();
		assertEquals("the answer should be 0",0.0,theAveragePriceOfProducts);
	}
	
	/*
	 * test to check that there is only one instance of class ContainerOfPrintedProducts 
	 */
	@Test
	public void testSingleToneOfContainer(){
		ContainerOfPrintedProducts container = ContainerOfPrintedProducts.getInstance();
		ContainerOfPrintedProducts container2 = ContainerOfPrintedProducts.getInstance();
		
		assertEquals(container,container2);
	}
	
	/*
	 * test to check that method of getting count of items in the container works correctly
	 */
	@Test
	public void testCount(){
		ContainerOfPrintedProducts container = ContainerOfPrintedProducts.getInstance();
		int count = container.count();
		
		assertEquals("the answer should be 0",0,count);
		
		container.add(new Book());
		container.add(new Magazine());
		count = container.count();
		assertEquals("the answer should be 2",2,count);	
	}
	
	/*
	 * test to check that method of getting elements by index works correctly
	 */
	@Test
	public void testGetElementByIndex(){
		ContainerOfPrintedProducts container = ContainerOfPrintedProducts.getInstance();
		PrintedProduct book = new Book();
		PrintedProduct magazine = new Magazine();
		container.add(book);
		container.add(magazine);
		
		PrintedProduct product = container.getElementByIndex(1);
		assertEquals(magazine,product);	
		
		container.clear();
	}
	
	/*
	 * test to check that method of sorting elements by ascending,
	 * that contained in the basic class, works correctly 
	 */
	@Test
	public void testSortByAscending(){
		
		ContainerOfPrintedProducts container = ContainerOfPrintedProducts.getInstance();
		container.clear();
		
		PrintedProduct[] arrayOfProducts = new PrintedProduct[4];
		arrayOfProducts[0] = new Book("Core Java",500,"programming","hardcover",2015);
		arrayOfProducts[1] = new Book("Effective Java 2",800,"programming","softcover",2008);
		arrayOfProducts[2] = new Magazine("Dr. Dobb's Journal", 200, 3,"programming",false);
		arrayOfProducts[3] = new Magazine("Java Developer's Journal",300,11,"programming",false);
		
		for(int i=0; i<arrayOfProducts.length;i++){
			container.add(arrayOfProducts[i]);
		}
		
		container.sort(null);
		
		PrintedProduct[] expectedPositionOfElement = {
				arrayOfProducts[2],arrayOfProducts[3],arrayOfProducts[0],arrayOfProducts[1]
		};
		PrintedProduct[] positionOfElementAfterSorting = new PrintedProduct[arrayOfProducts.length];
		for(int i=0;i<arrayOfProducts.length;i++){
			positionOfElementAfterSorting[i] = container.getElementByIndex(i);
		}
		assertTrue("Arrays are equal", java.util.Arrays
				.equals(expectedPositionOfElement,positionOfElementAfterSorting));
		
		container.clear();
	}
	
	/*
	 * test to check that method of sorting elements by descending,
	 * using comparator, works correctly 
	 */
	@Test
	public void testSortByDescending(){
		
		ContainerOfPrintedProducts container = ContainerOfPrintedProducts.getInstance();
		container.clear();
		
		PrintedProduct[] arrayOfProducts = new PrintedProduct[4];
		arrayOfProducts[0] = new Book("Core Java",500,"programming","hardcover",2015);
		arrayOfProducts[1] = new Book("Effective Java 2",800,"programming","softcover",2008);
		arrayOfProducts[2] = new Magazine("Dr. Dobb's Journal", 200, 3,"programming",false);
		arrayOfProducts[3] = new Magazine("Java Developer's Journal",300,11,"programming",false);
		
		for(int i=0; i<arrayOfProducts.length;i++){
			container.add(arrayOfProducts[i]);
		}
		
		container.sort(new SortingByPriceByDescendingWay());
		
		PrintedProduct[] expectedPositionOfElement = {
				arrayOfProducts[1],arrayOfProducts[0],arrayOfProducts[3],arrayOfProducts[2]
		};
		PrintedProduct[] positionOfElementAfterSorting = new PrintedProduct[arrayOfProducts.length];
		for(int i=0;i<arrayOfProducts.length;i++){
			positionOfElementAfterSorting[i] = container.getElementByIndex(i);
		}
		assertTrue("Arrays are equal", java.util.Arrays
				.equals(expectedPositionOfElement,positionOfElementAfterSorting));
		
		container.clear();
	}
}
