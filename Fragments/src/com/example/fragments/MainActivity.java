package com.example.fragments;

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
			Bundle bundle=new Bundle();
			bundle.putString("username", username);
			welcomeFragment.setArguments(bundle);
			FragmentManager manager = getSupportFragmentManager();
			FragmentTransaction fragmentTransaction = manager.beginTransaction();			
			fragmentTransaction.replace(R.id.fragment_container, welcomeFragment);
			fragmentTransaction.commit();
		}
	};

}
