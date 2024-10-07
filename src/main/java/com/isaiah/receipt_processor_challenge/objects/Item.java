package com.isaiah.receipt_processor_challenge.objects;

public class Item {
	
	private String shortDescription; //The Short Product Description for the item
	private float price; // The total price payed for this item
	
	public Item() {
		this("default description", 0.0f);
	}
	
	public Item(String shortDescription, float price) {
		
	}
	
	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [shortDescription=" + shortDescription + ", price=" + price + "]";
	}

}
