package com.isaiah.receipt_processor_challenge.objects;

import java.time.LocalDate;
import java.util.ArrayList;

import com.isaiah.receipt_processor_challenge.objects.Item;

public class Receipt {
	
	private String retailer;
	private LocalDate purchaseDate;
	private ArrayList<Item> items;
	private float total;
	
	
	public Receipt() {
		this("default retailer", LocalDate.now(), new ArrayList<Item>(), 0.0f);
	}
	
	public Receipt(String retailer, LocalDate purchaseDate, ArrayList<Item> items, float total) {
		super();
		this.retailer = retailer;
		this.purchaseDate = purchaseDate;
		this.items = items;
		this.total = total;
	}
	public String getRetailer() {
		return retailer;
	}
	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	
	@Override
	public String toString() {
		return "Receipt [retailer=" + retailer + ", purchaseDate=" + purchaseDate + ", items=" + items + ", total="
				+ total + "]";
	}
	
	

}
