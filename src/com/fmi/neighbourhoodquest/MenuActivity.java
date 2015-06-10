package com.fmi.neighbourhoodquest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

		Button playBtn = (Button) findViewById(R.id.playBtn);
		playBtn.setOnClickListener(this);
		Button statusBtn = (Button) findViewById(R.id.statusBtn);
		statusBtn.setOnClickListener(this);
		Button aboutBtn = (Button) findViewById(R.id.aboutBtn);
		aboutBtn.setOnClickListener(this);
		Button exitBtn = (Button) findViewById(R.id.exitBtn);
		exitBtn.setOnClickListener(this);

		Typeface type = Typeface.createFromAsset(getAssets(),
				"BUXTONSKETCH.TTF");
		playBtn.setTypeface(type);
		playBtn.setTextSize(24);
		statusBtn.setTypeface(type);
		statusBtn.setTextSize(24);
		aboutBtn.setTypeface(type);
		aboutBtn.setTextSize(24);
		exitBtn.setTypeface(type);
		exitBtn.setTextSize(24);
	}

	@Override
	public void onClick(View v) {
		Intent i;

		switch (v.getId()) {
		case R.id.playBtn:
			i = new Intent(this, MapActivity.class);
			startActivity(i);
			break;

		case R.id.aboutBtn:
			i = new Intent(this, AboutActivity.class);
			startActivity(i);
			break;

		case R.id.statusBtn:
			i = new Intent(this, StatusActivity.class);
			startActivity(i);
			break;

		case R.id.exitBtn:
			finish();
			break;
		}
	}
}
