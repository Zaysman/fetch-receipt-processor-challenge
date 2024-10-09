package com.isaiah.receipt_processor_challenge.objects;

import java.util.ArrayList;
import java.util.Random;

import com.isaiah.receipt_processor_challenge.objects.Receipt;

public class ReceiptManager {

	// Pool of alphanumeric characters
	private static final String ALPHANUMERIC_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static final Random random = new Random();


	private static ArrayList<Receipt> receipts = new ArrayList<>();

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
		//Perform null check
		if(receipt == null) {
			System.out.println("Attempted to save a null reference to ReceiptManager.");
			return;
		}
		
		receipt.setID(generateID()); //Generate an ID for the receipt so we can look for it later.
		receipts.add(receipt); //Add the receipt to the receipts array list so we can search for it later.
	}

	public static Receipt searchReceiptByID(String searchID) {
		//perform null check
		if(searchID == null) {
			System.out.println("searchID is null. Returning null value.");
			return null;
		}
		
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
		StringBuilder strBuilder = new StringBuilder();

		//Generate the 1st part of the id string
		strBuilder.append(generateString(8));
		//Add the 1st dash
		strBuilder.append("-");
		//Generate the 2nd part of the id string
		strBuilder.append(generateString(4));
		//Add the 2nd dash
		strBuilder.append("-");
		//generate the 3rd part of the id string
		strBuilder.append(generateString(4));
		//add the 3rd dash
		strBuilder.append("-");
		//generate the 4th part of the id string
		strBuilder.append(generateString(4));
		//add the final dash
		strBuilder.append("-");
		//generate the final part of the id string
		strBuilder.append(generateString(12));


		return strBuilder.toString();
	}

	private static String generateString(int length) {
		//perform input check: If length is negative, then print error message and 
		if(length < 0) {
			System.out.println("Length of " + length + " is invalid. Please pass a positive integer to generateString method. Returning empty string.");
			return new String();
		}
		
		//Perform input check: If length is zero
		if(length == 0) {
			System.out.println("Length is zero. Returning empty string.");
			return new String();
		}
		
		StringBuilder strBuilder = new StringBuilder(length);

		//Loop through the desired length and add random characters from the pool
		for(int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(ALPHANUMERIC_CHARACTERS.length());
			char randomChar = ALPHANUMERIC_CHARACTERS.charAt(randomIndex);
			strBuilder.append(randomChar);
		}

		return strBuilder.toString();
	}
	
	
	public static void listReceiptIDs() {
		for(int i = 0; i < receipts.size(); i++) {
			System.out.println("index " + i + ": " + receipts.get(i).getID());
		}
	}



}
