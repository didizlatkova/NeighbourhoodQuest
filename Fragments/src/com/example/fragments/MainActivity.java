package com.example.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends FragmentActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button buttonRegister = (Button) findViewById(R.id.register);
		buttonRegister.setOnClickListener(mRegisterClickListener);
	}


	private OnClickListener mRegisterClickListener = new OnClickListener() {

		public void onClick(View view) {
			
			String username = ((EditText) findViewById(R.id.username))
					.getText().toString();
			
			WelcomeFragment welcomeFragment = new WelcomeFragment();
			welcomeFragment.setRetainInstance(false);
			
			SharedPreferences sharedPreferences = getPreferences(0);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", username);
            editor.commit();
			
			FragmentManager manager = getSupportFragmentManager();
			FragmentTransaction fragmentTransaction = manager.beginTransaction();			
			fragmentTransaction.add(welcomeFragment, null);
			fragmentTransaction.commit();
		}
	};

}
