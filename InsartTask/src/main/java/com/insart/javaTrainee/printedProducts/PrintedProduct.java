package com.insart.javaTrainee.printedProducts;

public abstract class PrintedProduct implements Comparable<PrintedProduct>{
	
	private String nameOfProduct;
	private double price;
	private static double priceOfAllProducts;
	private static int countOfProducts;
	
	/*
	 * initialize static fields
	 */
	static{
		priceOfAllProducts = 0;
		countOfProducts = 0;
	}
	/*
	 * empty constructor
	 */
	public PrintedProduct(){
		this.nameOfProduct = "not specified";
		this.price = 0;
	}
	/*
	 * constructor with parameters
	 */
	public PrintedProduct(String nameOfProduct,double price){
		this.nameOfProduct = nameOfProduct;
		if(price>0){
			this.price = price;
		}
		else{
			this.price = 0;
		}
		priceOfAllProducts += this.price;
		countOfProducts++;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nameOfProduct == null) ? 0 : nameOfProduct.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrintedProduct other = (PrintedProduct) obj;
		if (nameOfProduct == null) {
			if (other.nameOfProduct != null)
				return false;
		} else if (!nameOfProduct.equals(other.nameOfProduct))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+ "[nameOfProduct=" + nameOfProduct + ", price="
				+ price + ",";
	}
	
	/*
	 * abstract method to get the description of the product
	 */
	public abstract String getDescriptionOfProduct();
	
	/*
	 * methods to set the values of fields
	 */
	public void setNameOfProduct(String nameOfProduct){
		this.nameOfProduct = nameOfProduct;
	}
	
	public void setPrice(double price){
		if(price>0){
			this.price = price;
		}
		else{
			this.price = 0;
		}
	}
	
	public static void setPriceOfAllProducts(double price){
		if(price>0){
			priceOfAllProducts = price;
		}
		else{
			priceOfAllProducts = 0;
		}
	}
	
	public static void setCountOfProducts(int count){
		if(count>0){
			countOfProducts = count;
		}
		else{
			countOfProducts = 1;
		}
	}
	
	/*
	 * methods to get the values of fields
	 */
	public static double getPriceOfAllProducts(){
		return priceOfAllProducts;
	}
	
	public static int getCountOfProducts(){
		return countOfProducts;
	}
	
	public String getNameOfProduct(){
		return nameOfProduct;
	}
	
	public double getPrice(){
		return price;
	}
	
	/*
	 * method to calculate the average price of products
	 */
	public static double calculateTheAveragePriceOfProducts(){
		double averagePriceOfProducts = priceOfAllProducts/countOfProducts;
		return averagePriceOfProducts;
	}
	
	/*
	 * method to print the average price of products
	 */
	public static void printTheAveragePriceOfProducts(){
		System.out.println("The average price of products = "+calculateTheAveragePriceOfProducts());
	}
	
	/*
	 * method to sort elements by ascending way
	 */
	public int compareTo(PrintedProduct printedProduct) {
		return this.price > printedProduct.getPrice() ? 1 
				: this.price == printedProduct.getPrice() ? 0 : -1;
	}
	
}
