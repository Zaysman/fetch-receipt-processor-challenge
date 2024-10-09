package com.isaiah.receipt_processor_challenge.objects.responseobjects;

public class PointsResponseObject {
	
	private int points;

	public PointsResponseObject() {
		this(0);
	}
	
	public PointsResponseObject(int points) {
		this.points = points;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "PointsResponseObject [points=" + points + "]";
	}

}
