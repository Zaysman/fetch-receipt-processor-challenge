package com.isaiah.receipt_processor_challenge.objects;

import java.util.ArrayList;

import com.isaiah.receipt_processor_challenge.objects.Receipt;

public class ReceiptManager {
	
	private static ArrayList<Receipt> receipts;
	
	public ReceiptManager() {
		this(new ArrayList<>());
	}
	
	public ReceiptManager(ArrayList<Receipt> receipts) {
		this.receipts = receipts;
	}
	
	public static ArrayList<Receipt> getReceipts() {
		return receipts;
	}
	
	public static void setReceipts(ArrayList<Receipt> otherReceipts) {
		receipts = otherReceipts; 
	}
	
	
	public static void saveReceipt(Receipt receipt) {
		receipt.setID(generateID()); //Generate an ID for the receipt so we can look for it later.
		receipts.add(receipt); //Add the receipt to the receipts array list so we can search for it later.
	}
	
	public static Receipt searchReceiptByID(String searchID) {
		Receipt receipt = new Receipt();
		
		for(int i = 0; i < receipts.size(); i++) {
			Receipt searchReceipt = receipts.get(i);
			
			//Check the id.
			if(searchID.compareTo(searchReceipt.getID()) == 0) { //If the ID matches, then we set receipt to the searchReceipt and break the loop.
				receipt = searchReceipt;
				break;
			}
		}
		
		return receipt;
	}
	
	private static String generateID() {
		String receiptID = new String();
		
		
		
		return receiptID;
	}
	
	

}
