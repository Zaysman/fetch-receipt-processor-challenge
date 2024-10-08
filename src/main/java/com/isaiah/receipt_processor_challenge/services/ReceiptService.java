package com.isaiah.receipt_processor_challenge.services;

import org.springframework.stereotype.Service;

import com.isaiah.receipt_processor_challenge.components.ScoreCalculator;
import com.isaiah.receipt_processor_challenge.objects.ReceiptManager;
import com.isaiah.receipt_processor_challenge.objects.Receipt;
import com.isaiah.receipt_processor_challenge.objects.ScoreBreakdown;


@Service
public class ReceiptService {
	
	
	//Creates a new receipt to be stored by the receipt manager. Returns the ID of the receipt that's generated
	public String createReceipt(Receipt receipt) {	
		ReceiptManager.saveReceipt(receipt); //Save the receipt. Receipt manager will handle generating the ID.
		return receipt.getID(); //return the id
	}
	
	
	public int calculateScore(Receipt receipt) {
		ScoreBreakdown scoreBreakdown = ScoreCalculator.calculateReceiptPoints(receipt);
		return scoreBreakdown.getTotalPoints();
	}
	

}
