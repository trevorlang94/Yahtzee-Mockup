package com.example.main.yahtzeemockup;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
	Button rollBtn, dice1, dice2, dice3, dice4, dice5;
	TextView smStraightScore, upperScore;
	Dice die1 = new Dice(dice1);
	Dice die2 = new Dice(dice2);
	Dice die3 = new Dice(dice3);
	Dice die4 = new Dice(dice4);
	Dice die5 = new Dice(dice5);
	Dice dieArray[] = {die1, die2, die3, die4, die5};
	int rollArray[] = new int[5]; //holds the randomly generated rolls
	boolean diceChk[] = {false, false, false, false, false}; //Determines whether or not a die has been marked for keeping
	int diceIcons[] = {R.drawable.diceone, R.drawable.dicetwo, R.drawable.dicethree,
			R.drawable.dicefour, R.drawable.dicefive, R.drawable.dicesix};
	int diceIconsClicked[] = {R.drawable.diceonedark, R.drawable.dicetwodark, R.drawable.dicethreedark,
			R.drawable.dicefourdark, R.drawable.dicefivedark, R.drawable.dicesixdark};


	ScoreGenerator scoreKeeper = new ScoreGenerator();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Button rollBtn = (Button) findViewById(R.id.rollBtn);
		LayoutInflater inflater = getLayoutInflater();
		final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.activity_main, null, false);
		final Button dice1 = (Button) findViewById(R.id.dice1);
		final Button dice2 = (Button) findViewById(R.id.dice2);
		final Button dice3 = (Button) findViewById(R.id.dice3);
		final Button dice4 = (Button) findViewById(R.id.dice4);
		final Button dice5 = (Button) findViewById(R.id.dice5);
		final int diceIDArray[] = {R.id.dice1, R.id.dice2, R.id.dice3, R.id.dice4, R.id.dice5}; //holds the ID of the dice
		final TextView ones = (TextView) findViewById(R.id.acesScore);
		final TextView twos = (TextView) findViewById(R.id.twosScore);
		final TextView threes = (TextView) findViewById(R.id.threesScore);
		final TextView fours = (TextView) findViewById(R.id.foursScore);
		final TextView fives = (TextView) findViewById(R.id.fivesScore);
		final TextView sixes = (TextView) findViewById(R.id.sixesScore);
		final TextView threeOfAKindScore = (TextView) findViewById(R.id.threeofkindScore);
		final TextView fourOfAKindScore = (TextView) findViewById(R.id.fourofakindScore);
		final TextView fullHouseScore = (TextView) findViewById(R.id.fullhouseScore);
		final TextView smStraightScore = (TextView) findViewById(R.id.smstraightScore);
		final TextView lgStraightScore = (TextView) findViewById(R.id.lgStraightScore);
		final TextView yahtzeeScore = (TextView) findViewById(R.id.yahtzeeScore);
		final TextView chanceScore = (TextView) findViewById(R.id.chanceScore);
		final TextView upperScore = (TextView) findViewById(R.id.upperScore);
		final TextView bonusScore = (TextView) findViewById(R.id.bonusScore);
		final int upperScores[] = {0,0,0,0,0,0};
		final int lowerScores[] = {0,0,0,0,0,0,0};
		int upperTotal = 0;
		int rollsRemaining = 3;

		rollBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Random r = new Random();
				for(int i = 0; i <= 4; i++){
					int a = r.nextInt((6-1)+ 1) + 1;
					rollArray[i] = a; //populates roll array
				}

				for(int i = 0; i <=4; i++){
					//if dice isn't checked, replace it's text with new roll
					if(!diceChk[i]){
						diceIconSort tester = new diceIconSort();
						Button diceChange = (Button)findViewById(diceIDArray[i]);
						diceChange.setBackground(getDrawable(tester.diceIconAssigner(rollArray[i], diceIcons)));
						dieArray[i].face=rollArray[i] - 1; //This face variable is used for cycling between dice clicked icons
					}
				}
				scoreKeeper.updateRollValues(dieArray);

			}
		});

		rollBtn.performClick();

		//LISTENERS FOR DICE
		//Clicking on the die toggles them between keeping and not keeping
		dice1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if(!diceChk[0]) {
					diceChk[0] = true;
					dice1.setBackground(assignDiceClickedIcon(dieArray[0].face));
				}

				else {
					diceChk[0] = false;
					dice1.setBackground(assignDiceUnclickedIcon(dieArray[0].face));

				}
			}
		});


		dice2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if(!diceChk[1]) {
					diceChk[1] = true;
					dice2.setBackground(assignDiceClickedIcon(dieArray[1].face));
				}

				else {
					diceChk[1] = false;
					dice2.setBackground(assignDiceUnclickedIcon(dieArray[1].face));

				}
			}
		});

		dice3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if(!diceChk[2]) {
					diceChk[2] = true;
					dice3.setBackground(assignDiceClickedIcon(dieArray[2].face));
				}

				else {
					diceChk[2] = false;
					dice3.setBackground(assignDiceUnclickedIcon(dieArray[2].face));

				}
			}
		});

		dice4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if(!diceChk[3]) {
					diceChk[3] = true;
					dice4.setBackground(assignDiceClickedIcon(dieArray[3].face));
				}

				else {
					diceChk[3] = false;
					dice4.setBackground(assignDiceUnclickedIcon(dieArray[3].face));

				}
			}
		});

		dice5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if(!diceChk[4]) {
					diceChk[4] = true;
					dice5.setBackground(assignDiceClickedIcon(dieArray[4].face));
				}

				else {
					diceChk[4] = false;
					dice5.setBackground(assignDiceUnclickedIcon(dieArray[4].face));

				}
			}
		});

		//LISTENERS FOR SCORE CHOICES

		ones.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				int score1 = scoreKeeper.calculateUpperScoreSection(1);
				ones.setText(String.valueOf(score1));
				upperScores[0] = score1;
				int totalUpper = updateUpperScores(upperScores);
				upperScore.setText(String.valueOf(totalUpper));

			}
		});

		twos.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				int score2 = scoreKeeper.calculateUpperScoreSection(2);
				twos.setText(String.valueOf(score2));
				upperScores[1] = score2;
				int totalUpper = updateUpperScores(upperScores);
				upperScore.setText(String.valueOf(totalUpper));
			}
		});

		threes.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				int score3 = scoreKeeper.calculateUpperScoreSection(3);
				threes.setText(String.valueOf(score3));
				upperScores[2] = score3;
				int totalUpper = updateUpperScores(upperScores);
				upperScore.setText(String.valueOf(totalUpper));
			}
		});

		fours.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				int score4 = scoreKeeper.calculateUpperScoreSection(4);
				fours.setText(String.valueOf(score4));
				upperScores[3] = score4;
				int totalUpper = updateUpperScores(upperScores);
				upperScore.setText(String.valueOf(totalUpper));
			}
		});

		fives.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				int score5 = scoreKeeper.calculateUpperScoreSection(5);
				fives.setText(String.valueOf(score5));
				upperScores[4] = score5;
				int totalUpper = updateUpperScores(upperScores);
				upperScore.setText(String.valueOf(totalUpper));
			}
		});

		sixes.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				int score6 = scoreKeeper.calculateUpperScoreSection(6);
				sixes.setText(String.valueOf(score6));
				upperScores[5] = score6;
				int totalUpper = updateUpperScores(upperScores);
				upperScore.setText(String.valueOf(totalUpper));
			}
		});


		threeOfAKindScore.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				int threeOfKindScore = scoreKeeper.threeOfAKindCheck();
				threeOfAKindScore.setText(String.valueOf(threeOfKindScore));
				lowerScores[0] = threeOfKindScore;
			}
		});

		fourOfAKindScore.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				int fourOfKindScore = scoreKeeper.fourOfAKindCheck();
				fourOfAKindScore.setText(String.valueOf(fourOfKindScore));
				lowerScores[1] = fourOfKindScore;
			}
		});

		fullHouseScore.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if(scoreKeeper.fullHouseCheck()){
					fullHouseScore.setText("25");
					lowerScores[2] = 25;
				}

			}
		});

		smStraightScore.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if(scoreKeeper.smStraightCheck()){
					smStraightScore.setText("30");
					lowerScores[3] = 30;
				}
				else{
					smStraightScore.setText("0");
					lowerScores[3] = 0;
				}
			}
		});

		lgStraightScore.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if(scoreKeeper.lgStraightCheck()){
					lgStraightScore.setText("40");
					lowerScores[4] = 40;
				}

				else{
					lgStraightScore.setText("0");
					lowerScores[4] = 0;
				}
			}
		});

		yahtzeeScore.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if(scoreKeeper.yahtzeeCheck() && !scoreKeeper.gotYahtzee){
					yahtzeeScore.setText("50");
					lowerScores[5] = 50;
				}
				if(!scoreKeeper.yahtzeeCheck() && scoreKeeper.gotYahtzee){
					if(lowerScores[5] == 0){
						Toast noYahtzeeToast = new Toast(getApplicationContext());
						noYahtzeeToast.setView(rollBtn);
						noYahtzeeToast.makeText(MainActivity.this, "You cannot receive a yahtzee.",Toast.LENGTH_LONG).show();
						noYahtzeeToast.show();
					}

				}
				if(scoreKeeper.yahtzeeCheck() && scoreKeeper.gotYahtzee){
					lowerScores[5] += 100;
					yahtzeeScore.setText(String.valueOf((Integer.parseInt(yahtzeeScore.getText().toString())) + 100));
				}
			}
		});

		chanceScore.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				int chanceAmt = scoreKeeper.calculateChanceScore();
				chanceScore.setText(String.valueOf(chanceAmt));
			}
		});

		upperScore.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
				int scoreTxt = Integer.parseInt(upperScore.getText().toString());
				if (scoreTxt >= 63) {
					bonusScore.setText("35");
				}
				else {bonusScore.setText("0");}
			}

			@Override
			public void afterTextChanged(Editable editable) {


			}
		});



	} //end of onCreate

	//Methods for handling dice selected and unselected icons
	public Drawable assignDiceClickedIcon(int iconNum){
		return getDrawable(diceIconsClicked[iconNum]);
	}

	public Drawable assignDiceUnclickedIcon(int iconNum){
		return getDrawable(diceIcons[iconNum]);
	}

	public int updateUpperScores(int[] scoreArray){
		int scoreSum = 0;
		for(int i = 0; i <=5; i++){
			scoreSum = scoreSum + scoreArray[i];
		}
		return scoreSum;
	}


}



