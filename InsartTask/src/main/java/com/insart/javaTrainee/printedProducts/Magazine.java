package com.insart.javaTrainee.printedProducts;

public class Magazine extends PrintedProduct{
	
	private int numberOfIssue;
	private String type;
	private boolean hasAdditionalGift;
	
	/*
	 * empty constructor
	 */
	public Magazine(){
		super();
		this.numberOfIssue = 0;
		this.type = "none";
		this.hasAdditionalGift = false;
	}
	
	/*
	 * constructor with parameters
	 */
	public Magazine(String name, double price, int numberOfIssue,String type,boolean hasAdditionalGift){
		super(name,price);
		if(numberOfIssue>0){
			this.numberOfIssue = numberOfIssue;
		}
		else{
			this.numberOfIssue = 0;
		}
		this.type = type;
		this.hasAdditionalGift = hasAdditionalGift; 
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append(" numberOfIssue=").append(numberOfIssue)
			.append(", type=").append(type).append(", hasAdditionalGift=")
			.append(hasAdditionalGift).append("]");
		return builder.toString();
	}
	
	public int getNumberOfIssue() {
		return numberOfIssue;
	}
	
	public void setNumberOfIssue(int numberOfIssue) {
		if(numberOfIssue>0){
			this.numberOfIssue = numberOfIssue;
		}
		else{
			this.numberOfIssue = 0;
		}
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean setIfMagazineHasAdditionalGift() {
		return hasAdditionalGift;
	}
	
	public void setIfMagazineHasAdditionalGift(boolean hasAdditionalGift) {
		this.hasAdditionalGift = hasAdditionalGift;
	}
	
	@Override
	public String getDescriptionOfProduct() {
		StringBuilder builder = new StringBuilder();
		builder.append("The name of magazine is ").append(this.getNameOfProduct())
			.append(". The price of magazine is ").append(this.getPrice())
			.append(". The number of issue of ").append(this.type)
			.append(" magazine is ").append(this.numberOfIssue).append(". ");
		if(this.hasAdditionalGift == true){
			builder.append("This number of issue has the additional gift");
		}
		else{
			builder.append("Unfortunately,this number of issue doesn't have the additional gift");
		}
		return builder.toString();
	}
	
}
