package com.isaiah.receipt_processor_challenge.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.isaiah.receipt_processor_challenge.objects.Receipt;
import com.isaiah.receipt_processor_challenge.objects.ReceiptManager;
import com.isaiah.receipt_processor_challenge.services.ReceiptService;

import com.isaiah.receipt_processor_challenge.objects.responseobjects.*;


@RestController
@RequestMapping("receipts")
public class ReceiptRestController {
	
	@Autowired
	private ReceiptService receiptService;
	
	
	//POST Mapping to create Receipt. Returns the ID of the receipt.
	@PostMapping(value= "/process", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "*")
	public IDResponseObject createReceipt(@RequestBody Receipt receipt) {
		String receiptID = receiptService.createReceipt(receipt);
		IDResponseObject response = new IDResponseObject(receiptID);
		return response;
		
	}
	
	
	//GET Mapping to get the score for a receipt. Returns the score of the receipt.
	@GetMapping(value = "/{id}/points", produces = "application/json")
	@CrossOrigin(origins = "*")
	public PointsResponseObject calculateReceiptPoints(@PathVariable String id) {
		Receipt receipt = ReceiptManager.searchReceiptByID(id);
		int points = receiptService.calculateScore(receipt);
		PointsResponseObject response = new PointsResponseObject(points);
		return response;
	}
	
	
}
