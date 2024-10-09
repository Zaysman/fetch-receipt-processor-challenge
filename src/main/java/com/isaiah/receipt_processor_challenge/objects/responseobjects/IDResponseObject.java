package com.isaiah.receipt_processor_challenge.objects.responseobjects;

public class IDResponseObject {
	
	private String ID;
	
	public IDResponseObject() {
		this("Default Response ID");
	}
	
	public IDResponseObject(String ID) {
		this.ID = ID;
	}
	
	public String getID() {
		return this.ID;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}

	@Override
	public String toString() {
		return "IDResponseObject [ID=" + ID + "]";
	}
	
}
