package com.insart.javaTrainee.containerOfProducts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.insart.javaTrainee.printedProducts.PrintedProduct;

public class ContainerOfPrintedProducts {
	private static ContainerOfPrintedProducts uniqueInstance;
	private final ArrayList<PrintedProduct> containerOfProducts; 
	
	private ContainerOfPrintedProducts(){
		this.containerOfProducts = new ArrayList<PrintedProduct>();
	}
	
	/*
	 * method to return uniqueInstance of class 
	 */
	public static ContainerOfPrintedProducts getInstance() {
			if (uniqueInstance == null) {
				uniqueInstance = new ContainerOfPrintedProducts();
			}
			return uniqueInstance;
	}
	
	/*
	 * method for adding items to the container 
	 */
	public void add(PrintedProduct product){
		containerOfProducts.add(product);
	}
	
	/*
	 * method to get the count of items in the container
	 */
	public int count(){
		return containerOfProducts.size();
	}
	
	/*
	 * method to get element by index
	 */
	public PrintedProduct getElementByIndex(int index){
		return containerOfProducts.get(index);
	}
	
	/*
	 * method to sort elements in the container. 
	 * If value of comparator is null - use standard method of sorting
	 * that contained in the basic class. Otherwise - used comparator
	 */
	public void sort(Comparator<PrintedProduct> comparator){
		if(comparator == null){
			Collections.sort(containerOfProducts);
		}
		else{
			containerOfProducts.sort(comparator);
		}
	}
	
	/*
	 * method to print all items in the container
	 */
	public void print(){
		for(PrintedProduct product : containerOfProducts){
			System.out.println(product);
		}
	}
	
	/*
	 * method to clear all items in the container, used for tests
	 */
	public void clear(){
		containerOfProducts.clear();
	}
}
