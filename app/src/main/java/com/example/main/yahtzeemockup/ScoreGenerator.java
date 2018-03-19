package com.example.main.yahtzeemockup;

import android.util.Log;

import java.util.Arrays;

/**
 * Created by Main on 12/3/2017.
 */

/**
 * 		String rolls = String.valueOf(rollValues[0]) + String.valueOf(rollValues[1]) + String.valueOf(rollValues[2]) +
 String.valueOf(rollValues[3]) + String.valueOf(rollValues[4] + String.valueOf(rollValues[5]));
 Log.i("Rolls:", rolls);
 */

public class ScoreGenerator {
	private int rollValues[] = {0, 0, 0, 0, 0, 0};
	private int upperTotal = 0;
	private int lowerTotal = 0;
	private int combinedTotal = 0;
	public boolean gotYahtzee = false; //maybe poorly named, this checks if player tried to score a yahtzee and is used for allotting bonuses


	public ScoreGenerator(){

	}

	public void updateRollValues(Dice[] dieArray){
		Arrays.fill(rollValues, 0);
		for(int i = 0; i<=4; i++){
				rollValues[dieArray[i].face] += 1;

		}
	}

	public int threeOfAKindCheck(){
		int threeOfKindScore = 0;
		boolean has3OfKind = false;
		for(int rollAmt : rollValues){
			if(rollAmt >= 3){
				has3OfKind = true;
			}
		}

		if(has3OfKind){
			int rollValueAmt = 1; //This is to turn the numbers in rollValues into the value of the dice instead of amount present
			for(int i = 0; i <= 5; i++){
				threeOfKindScore += (rollValues[i] * rollValueAmt);
				rollValueAmt++;
			}
		}
		return threeOfKindScore;
	}

	public int fourOfAKindCheck(){
		int fourOfKindScore = 0;
		boolean has4OfKind = false;
		for(int rollAmt : rollValues){
			if(rollAmt >= 4){
				has4OfKind = true;
			}
		}

		if(has4OfKind){
			int rollValueAmt = 1; //This is to turn the numbers in rollValues into the value of the dice instead of amount present
			for(int i = 0; i <= 5; i++){
				fourOfKindScore += (rollValues[i] * rollValueAmt);
				rollValueAmt++;
			}
		}
		return fourOfKindScore;
	}

	public boolean fullHouseCheck(){
		boolean has2 = false, has3 = false; //become true if a rollValue[i] is >= 2, 3

		for(int values : rollValues){
			if(values == 2){
				has2 = true;
			}
			if(values == 3){
				has3 = true;
			}
		}
		if(has2 && has3){
			return true;
		}
		else return false;
	}

	public boolean smStraightCheck(){

		for(int i = 0; i <= 3; i++){
			if(rollValues[i] >= 1 && rollValues[i+1] >= 1 && rollValues[i+2] >= 1 && rollValues[i+3] >= 1){
				return true;
			}
		}
		return false;
	}

	public boolean lgStraightCheck(){

		for(int i = 0; i <= 1; i++){
			if(rollValues[i] >= 1 && rollValues[i+1] >= 1 && rollValues[i+2] >= 1 && rollValues[i+3] >= 1 && rollValues[i+4] >= 1){
				return true;
			}
		}
		return false;
	}

	public boolean yahtzeeCheck(){
		gotYahtzee = true;
		for(int values : rollValues){
			if(values == 5){
				return true;
			}
		}
		return false;

	}

	public int calculateChanceScore(){
		int chanceScore = 0;
		int rollValueAmt = 1; //This is to turn the numbers in rollValues into the value of the dice instead of amount present
		for(int values: rollValues){
			chanceScore += (values * rollValueAmt);
			rollValueAmt++;
		}
		return chanceScore;
	}

	public int calculateUpperScoreSection(int numToScore){
		int score = rollValues[numToScore-1] * numToScore;

		return score;
	}

	public int getUpperTotal(int[] upperScores){
		upperTotal = 0;

		for (int score: upperScores) {
			upperTotal += score;
			Log.i("For loop SCORE:", String.valueOf(score));
		}
		Log.i("getUpperTotal:", String.valueOf(upperTotal));
		return upperTotal;
	}

}
