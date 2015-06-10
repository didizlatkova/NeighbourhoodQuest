package com.fmi.neighbourhoodquest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class QuestionActivity extends Activity implements OnClickListener {
	
	private final int QUESTIONS_TO_OPEN = 3;

	private DbHelper db = new DbHelper(this);
	private Button opt1Btn;
	private Button opt2Btn;
	private Button opt3Btn;
	private Button opt4Btn;
	private Button forwardBtn;
	private int questionIndex;
	private Question question;
	private Boolean isAnswered = false;
	private MarkerManager manager = new MarkerManager();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);		

		questionIndex = getIntent().getExtras().getInt(("index"));
		question = db.getAllQuestions().get(questionIndex);

		TextView ques = (TextView) findViewById(R.id.ques);
		ques.setTextSize(22);
		ques.setText(question.getQuestion());

		opt1Btn = (Button) findViewById(R.id.opt1);
		opt1Btn.setTextSize(18);
		opt1Btn.setText(question.getOption1());
		opt1Btn.setOnClickListener(this);

		opt2Btn = (Button) findViewById(R.id.opt2);
		opt2Btn.setTextSize(18);
		opt2Btn.setText(question.getOption2());
		opt2Btn.setOnClickListener(this);

		opt3Btn = (Button) findViewById(R.id.opt3);
		opt3Btn.setTextSize(18);
		opt3Btn.setText(question.getOption3());
		opt3Btn.setOnClickListener(this);

		opt4Btn = (Button) findViewById(R.id.opt4);
		opt4Btn.setTextSize(18);
		opt4Btn.setText(question.getOption4());
		opt4Btn.setOnClickListener(this);

		forwardBtn = (Button) findViewById(R.id.forwardBtn);
		forwardBtn.setTextSize(18);
		forwardBtn.setOnClickListener(this);
			
		if (savedInstanceState != null) {
			opt1Btn.setBackgroundResource(savedInstanceState.getInt("opt1DrawableId"));
			opt2Btn.setBackgroundResource(savedInstanceState.getInt("opt2DrawableId"));
			opt3Btn.setBackgroundResource(savedInstanceState.getInt("opt3DrawableId"));
			opt4Btn.setBackgroundResource(savedInstanceState.getInt("opt4DrawableId"));
			
			forwardBtn.setVisibility(savedInstanceState.getInt("forwardVisible"));
			isAnswered = savedInstanceState.getBoolean("isAnswered");
			
			opt1Btn.setTag(savedInstanceState.getInt("opt1DrawableId"));
			opt2Btn.setTag(savedInstanceState.getInt("opt2DrawableId"));
			opt3Btn.setTag(savedInstanceState.getInt("opt3DrawableId"));
			opt4Btn.setTag(savedInstanceState.getInt("opt4DrawableId"));
		}
		else {
			opt1Btn.setTag(R.drawable.button_selector);
			opt2Btn.setTag(R.drawable.button_selector);
			opt3Btn.setTag(R.drawable.button_selector);
			opt4Btn.setTag(R.drawable.button_selector);
		}
	}

	@Override
	public void onClick(View v) {
		if (!isAnswered) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		switch (v.getId()) {
		case R.id.opt1:
		case R.id.opt2:
		case R.id.opt3:
		case R.id.opt4:
			if (!isAnswered) {
				handleAnswerClick(v);
			}
			break;

		case R.id.forwardBtn:
			this.finish();
			Intent i = new Intent(this, StatusActivity.class);
			startActivity(i);
			break;
		}
	}

	private void handleAnswerClick(View v) {
		isAnswered = true;

		// set black background to all buttons
		opt1Btn.setBackgroundResource(R.drawable.black_button);
		opt1Btn.setTag(R.drawable.black_button);
		opt2Btn.setBackgroundResource(R.drawable.black_button);
		opt2Btn.setTag(R.drawable.black_button);
		opt3Btn.setBackgroundResource(R.drawable.black_button);
		opt3Btn.setTag(R.drawable.black_button);
		opt4Btn.setBackgroundResource(R.drawable.black_button);
		opt4Btn.setTag(R.drawable.black_button);

		Button b = (Button) v;

		// show right answer
		if (question.getAnswer().equals(opt1Btn.getText())) {
			opt1Btn.setBackgroundResource(R.drawable.green_button);
			opt1Btn.setTag(R.drawable.green_button);
		} else if (question.getAnswer().equals(opt2Btn.getText())) {
			opt2Btn.setBackgroundResource(R.drawable.green_button);
			opt2Btn.setTag(R.drawable.green_button);
		} else if (question.getAnswer().equals(opt3Btn.getText())) {
			opt3Btn.setBackgroundResource(R.drawable.green_button);
			opt3Btn.setTag(R.drawable.green_button);
		} else if (question.getAnswer().equals(opt4Btn.getText())) {
			opt4Btn.setBackgroundResource(R.drawable.green_button);
			opt4Btn.setTag(R.drawable.green_button);
		}

		if (question.getAnswer().equals(b.getText())) {
			// answer is right
			db.changeQuestionState(question.getID(), QuestionState.ANSWERED_RIGHT);
			
			// make closest 3 questions visible
			Question questionToOpen;
			for (int i = 0; i < QUESTIONS_TO_OPEN; i++) {
				questionToOpen = manager.getClosestInvisibleQuestion(question.getLatitude(), question.getLongitude(), db.getAllQuestions());
				if (questionToOpen != null) {
					db.changeQuestionState(questionToOpen.getID(), QuestionState.OPEN);
				}				
			}		

		} else {
			// answer is wrong
			b.setBackgroundResource(R.drawable.red_button);			
			b.setTag(R.drawable.red_button);
			db.changeQuestionState(question.getID(), QuestionState.ANSWERED_WRONG);
		}

		forwardBtn.setVisibility(View.VISIBLE);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);		

		outState.putInt("opt1DrawableId", (Integer) opt1Btn.getTag());
		outState.putInt("opt2DrawableId", (Integer) opt2Btn.getTag());
		outState.putInt("opt3DrawableId", (Integer) opt3Btn.getTag());
		outState.putInt("opt4DrawableId", (Integer) opt4Btn.getTag());
		
		outState.putInt("forwardVisible", forwardBtn.getVisibility());
		outState.putBoolean("isAnswered", isAnswered);
	}
}
