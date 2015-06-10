package com.fmi.neighbourhoodquest;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class StatusActivity extends Activity implements OnClickListener {
	
	private DbHelper db = new DbHelper(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_status);

		// finish button
		Button backBtn = (Button) findViewById(R.id.backBtn);
		backBtn.setOnClickListener(this);
		Typeface type = Typeface.createFromAsset(getAssets(),"BUXTONSKETCH.TTF"); 
		backBtn.setTypeface(type);
		backBtn.setTextSize(18);
		
		TextView progressText = (TextView) findViewById(R.id.progressText);
		progressText.setTextSize(18);
		TextView progressValue = (TextView) findViewById(R.id.progressValue);
		progressValue.setTextSize(18);
		TextView openText = (TextView) findViewById(R.id.openText);
		openText.setTextSize(18);
		TextView openValue = (TextView) findViewById(R.id.openValue);
		openValue.setTextSize(18);
		TextView rightText = (TextView) findViewById(R.id.rightText);
		rightText.setTextSize(18);
		TextView rightValue = (TextView) findViewById(R.id.rightValue);
		rightValue.setTextSize(18);
		TextView wrongText = (TextView) findViewById(R.id.wrongText);
		wrongText.setTextSize(18);
		TextView wrongValue = (TextView) findViewById(R.id.wrongValue);
		wrongValue.setTextSize(18);
		
		int countAll = db.rowcount();
		int countRight = 0;
		int countWrong = 0;
		int countInvisible = 0;
		
		ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
		progressBar.setMax(countAll);		
		
		ArrayList<Question> list = db.getAllQuestions(); 
		for (Question question : list) {
			if (question.getState() == QuestionState.ANSWERED_RIGHT) {
				countRight++;
			}
			else if (question.getState() == QuestionState.ANSWERED_WRONG) {
				countWrong++;
			}
			else if (question.getState() == QuestionState.INVISIBLE) {
				countInvisible++;
			}
		}
		
		progressBar.setProgress(countRight);
		progressValue.setText(countRight*100/countAll + "%");
		
		openValue.setText(countAll-countInvisible + " от " + countAll);
		rightValue.setText(countRight + " от " + (countRight + countWrong));
		wrongValue.setText(countWrong + " от " + (countRight + countWrong));
	}
	
	@Override
	public void onClick(View arg0) {
		finish();
	}
}
