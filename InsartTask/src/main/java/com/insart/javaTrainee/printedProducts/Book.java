package com.insart.javaTrainee.printedProducts;

public class Book extends PrintedProduct{

	private String genre;
	private String coverType;
	private int theYearOfPublishing;
	
	/*
	 * empty constructor
	 */
	public Book(){
		super();
		this.genre = "none";
		this.coverType = "none";
		this.theYearOfPublishing = 0;
	}
	
	/*
	 * constructor with parameters
	 */
	public Book(String name, double price, String genre, String coverType, int theYearOfPublishing){
		super(name,price);
		this.genre = genre;
		this.coverType = coverType;
		
		if(theYearOfPublishing>0){
			this.theYearOfPublishing = theYearOfPublishing;
		}
		else{
			this.theYearOfPublishing = 0;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append(" genre=").append(genre).append(", coverType=")
				.append(coverType).append(", theYearOfPublishing=")
				.append(theYearOfPublishing).append("]");
		return builder.toString();
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getCoverType() {
		return coverType;
	}
	
	public void setCoverType(String coverType) {
		this.coverType = coverType;
	}
	
	public int getTheYearOfPublishing() {
		return theYearOfPublishing;
	}
	
	public void setTheYearOfPublishing(int theYearOfPublishing) {
		if(theYearOfPublishing>0){
			this.theYearOfPublishing = theYearOfPublishing;
		}
		else{
			this.theYearOfPublishing = 0;
		}
	}
	
	@Override
	public String getDescriptionOfProduct() {
		StringBuilder builder = new StringBuilder();
		builder.append("The name of book is "); builder.append(this.getNameOfProduct());
		builder.append(". The price of book is "); builder.append(this.getPrice());
		builder.append(". The name of genre of book is "); builder.append(this.genre);
		builder.append(". This book has a "); builder.append(this.coverType);
		builder.append(". The year of publishing of this book is "); builder.append(this.theYearOfPublishing);
		builder.append(". ");
		return builder.toString();
	}

}
