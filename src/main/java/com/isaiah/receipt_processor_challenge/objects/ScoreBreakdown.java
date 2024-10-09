package com.isaiah.receipt_processor_challenge.objects;

import java.util.ArrayList;

import com.isaiah.receipt_processor_challenge.objects.ScoreEntry;

public class ScoreBreakdown {
	
	private ArrayList<ScoreEntry> scores;
	private int totalPoints;
	
	public ScoreBreakdown() {
		this(new ArrayList<ScoreEntry>(), 0);
	}
	
	public ScoreBreakdown(ArrayList<ScoreEntry> scores, int totalPoints) {
		this.scores = scores;	
		this.totalPoints = totalPoints;
	}

	public ArrayList<ScoreEntry> getScores() {
		return scores;
	}

	public void setScores(ArrayList<ScoreEntry> scores) {
		this.scores = scores;
	}
	
	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public void addScoreEntry(ScoreEntry scoreEntry) {
		//null check
		if(scoreEntry == null) {
			System.out.println("scoreEntry is null. Scores and total points will not be updated.");
			return;
		}
		
		this.scores.add(scoreEntry);
		this.totalPoints += scoreEntry.getScoreValue();
		
	}
	

	@Override
	public String toString() {
		return "ScoreBreakdown [scores=" + scores + "]";
	}

}
