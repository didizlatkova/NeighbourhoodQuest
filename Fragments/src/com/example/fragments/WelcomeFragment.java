package com.example.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WelcomeFragment extends Fragment {

	@Override
	public void onStart() {
		super.onStart();		
		SharedPreferences sharedPreferences = getActivity().getPreferences(0);
		TextView textView = (TextView) getView().findViewById(R.id.welcomeMessage);
        
		textView.setText("Welcome, " + sharedPreferences.getString("username", null) + "!");
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		


	
		View view= inflater.inflate(R.layout.welcome, container, false);

         
        // Inflate the layout for this fragment
        return view;
    }
}
