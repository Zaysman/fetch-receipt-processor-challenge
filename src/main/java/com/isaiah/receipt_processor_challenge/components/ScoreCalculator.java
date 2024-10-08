package com.isaiah.receipt_processor_challenge.components;

//Java imports
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

//My objects
import com.isaiah.receipt_processor_challenge.objects.*;



	

@Component
public class ScoreCalculator {

	public static ScoreBreakdown scoreBreakdown;
	
	
	public static ScoreBreakdown calculateReceiptPoints(Receipt receipt) {
		scoreBreakdown = new ScoreBreakdown(); //Create a new scoreBreakdown object to keep track of the points for the passed receipt
		
		//Run the receipt through each of the conditions to calculate the points.
		retailerNamePoints(receipt.getRetailer());
		roundDollarAmountPoints(receipt.getTotal());
		multipleOf25Points(receipt.getTotal());
		itemAmountPoints(receipt.getItems());
		trimmedItemLengthPoints(receipt.getItems());
		purchaseDatePoints(receipt.getPurchaseDate());
		purchaseTimePoints(receipt.getPurchaseTime());
		
		
		return scoreBreakdown;
	}
	
	private static void retailerNamePoints(String retailerName) {
		int alphanumericCount = 0;
		
		//Iterate over each character in the retailerName
		for(int i = 0; i < retailerName.length(); i++) {
			char c = retailerName.charAt(i);
			
			//Check if the character is a letter or digit
			if(Character.isLetterOrDigit(c)) {
				alphanumericCount++;
			}
		}
		
		ScoreEntry scoreEntry = new ScoreEntry(alphanumericCount, "Retailer name has " + alphanumericCount + " alphanumeric characters.");
		scoreBreakdown.addScoreEntry(scoreEntry);
	}
	
	private static void roundDollarAmountPoints(float receiptTotal) {
		//If the total is a round dollar, earns 50 points
		if(receiptTotal % 1.0f == 0.0f) {
			ScoreEntry scoreEntry = new ScoreEntry(50, "Total is a round dollar");
			scoreBreakdown.addScoreEntry(scoreEntry);
		}
		
		
	}
	
	private static void multipleOf25Points(float receiptTotal) {
		//If the total is a multiple of .25, ears 25 points.
		if(receiptTotal % .25f == 0.0f) {
			ScoreEntry scoreEntry = new ScoreEntry(25, "Total is a multiple of .25");
			scoreBreakdown.addScoreEntry(scoreEntry);
		}
		
		
	}
	
	private static void itemAmountPoints(ArrayList<Item> items) {
		//For every two points on the receipt, 5 points are awarded.
		int itemAmount = items.size();
		int pointsMultiplier = Math.floorDiv(itemAmount, 2);
		
		if(pointsMultiplier > 0) {
			ScoreEntry scoreEntry = new ScoreEntry(5 * pointsMultiplier, "" + itemAmount + " items (" + pointsMultiplier + ") pairs @ 5 points each");
			scoreBreakdown.addScoreEntry(scoreEntry);
		}
		
		
	}
	
	private static void trimmedItemLengthPoints(ArrayList<Item> items) {
		//For each item description, if its trimmed length is a multiple of 3, multiply the length of the description by .2 and round up to the nearest int. That will be the points added.
		for(Item item: items) {
			String desc = item.getShortDescription().trim(); //get trimmed string
			
			//Check length of description
			if(desc.length() % 3 == 0) {
				//if
				int points = (int) Math.ceil((float) item.getPrice() * .2f); //Calculate the points
				ScoreEntry scoreEntry = new ScoreEntry(points, "\"" + desc + "\" is " + desc.length() + " characters (a multiple of 3)\n" + "item price of " + item.getPrice() + " * 0.2 = " + (item.getPrice() * 0.2f) + ", rounded up to " + points + " points");
				scoreBreakdown.addScoreEntry(scoreEntry);
			}
			
		}
	}
	
	private static void purchaseDatePoints(LocalDate purchaseDate) {
		
	}
	
	private static void purchaseTimePoints(LocalTime purchaseTime) {
		
	}
	
	
	
}
