package com.isaiah.receipt_processor_challenge.objects;

import java.util.ArrayList;

import com.isaiah.receipt_processor_challenge.objects.ScoreEntry;

public class ScoreBreakdown {
	
	private ArrayList<ScoreEntry> scores;
	
	public ScoreBreakdown() {
		this(new ArrayList<ScoreEntry>());
	}
	
	public ScoreBreakdown(ArrayList<ScoreEntry> scores) {
		this.scores = scores;	
	}

	public ArrayList<ScoreEntry> getScores() {
		return scores;
	}

	public void setScores(ArrayList<ScoreEntry> scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return "ScoreBreakdown [scores=" + scores + "]";
	}

}
