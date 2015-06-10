package com.fmi.neighbourhoodquest;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AboutActivity extends Activity implements OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);

		Button backBtn = (Button) findViewById(R.id.backBtn);
		backBtn.setOnClickListener(this);
		Typeface type = Typeface.createFromAsset(getAssets(),
				"BUXTONSKETCH.TTF");
		backBtn.setTypeface(type);
		backBtn.setTextSize(18);
	}

	@Override
	public void onClick(View arg0) {
		finish();
	}
}