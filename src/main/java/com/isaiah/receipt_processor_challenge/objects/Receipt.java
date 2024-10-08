package com.isaiah.receipt_processor_challenge.objects;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.isaiah.receipt_processor_challenge.objects.Item;

public class Receipt {
	
	private String id;
	private String retailer;
	private LocalDate purchaseDate;
	private LocalTime purchaseTime;
	private ArrayList<Item> items;
	private float total;
	
	
	public Receipt() {
		this("default id", "default retailer", LocalDate.now(), LocalTime.now(), new ArrayList<Item>(), 0.0f);
	}
	
	public Receipt(String id, String retailer, LocalDate purchaseDate, LocalTime purchaseTime, ArrayList<Item> items, float total) {
		super();
		this.id = id;
		this.retailer = retailer;
		this.purchaseDate = purchaseDate;
		this.purchaseTime = purchaseTime;
		this.items = items;
		this.total = total;
	}
	
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
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
	public LocalTime getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(LocalTime purchaseTime) {
		this.purchaseTime = purchaseTime;
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
	
	public void calculateTotal() {
		for(Item i: items) {
			total += i.getPrice();
		} 
	}
	
	
	@Override
	public String toString() {
		return "Receipt [retailer=" + retailer + ", purchaseDate=" + purchaseDate + ", items=" + items + ", total="
				+ total + "]";
	}
	
	

}
