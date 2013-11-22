package com.example.fragmentshw;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeFragment extends Fragment {
	@Override
	public void onStart() {
		super.onStart();
		SharedPreferences sharedPreferences = getActivity().getPreferences(0);
		
		TextView nameView = (TextView) getView().findViewById(
				R.id.name);
		nameView.setText(sharedPreferences.getString("name", null));
		
		TextView specialtyView = (TextView) getView().findViewById(
				R.id.specialty);
		specialtyView.setText(sharedPreferences.getString("specialty", null));
		
		TextView courseView = (TextView) getView().findViewById(
				R.id.course);
		courseView.setText(sharedPreferences.getString("course", null));
		
		TextView facView = (TextView) getView().findViewById(
				R.id.facultyNum);
		facView.setText(sharedPreferences.getString("facultyNum", null));
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.welcome, container, false);
	}

}
