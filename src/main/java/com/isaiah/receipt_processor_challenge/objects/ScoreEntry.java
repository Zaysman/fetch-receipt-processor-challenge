package com.isaiah.receipt_processor_challenge.objects;

public class ScoreEntry {
	
	private int scoreValue;
	private String scoreExplanation;
	
	
	public ScoreEntry() {
		this(0, "default Score Explanation");
	}
	
	public ScoreEntry(int scoreValue, String scoreExplanation) {
		super();
		this.scoreValue = scoreValue;
		this.scoreExplanation = scoreExplanation;
	}

	public int getScoreValue() {
		return scoreValue;
	}

	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}

	public String getScoreExplanation() {
		return scoreExplanation;
	}

	public void setScoreExplanation(String scoreExplanation) {
		this.scoreExplanation = scoreExplanation;
	}

	@Override
	public String toString() {
		return "ScoreEntry [scoreValue=" + scoreValue + ", scoreExplanation=" + scoreExplanation + "]";
	}
	
	

}
