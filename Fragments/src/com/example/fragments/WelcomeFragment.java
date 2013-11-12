package com.example.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WelcomeFragment extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		Bundle bundle = getArguments(); 
		TextView view = (TextView) getView().findViewById(R.id.welcomeMessage);
		view.setText("Welcome, " + bundle.getString("username") + "!");
		
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.welcome, container, false);
    }
}
