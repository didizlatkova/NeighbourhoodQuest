package com.example.fragmentshw;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);

		View view = inflater.inflate(R.layout.register, container, false);		
		
		Button buttonRegister = (Button) view.findViewById(R.id.register);
		buttonRegister.setOnClickListener(mRegisterClickListener);
		
		// Inflate the layout for this fragment
		return view;
	}
	
	private OnClickListener mRegisterClickListener = new OnClickListener() {

		public void onClick(View view) {
			
			String username = ((EditText) getActivity().findViewById(R.id.name))
					.getText().toString();
			
			String specialty = ((EditText) getActivity().findViewById(R.id.specialty))
					.getText().toString();
			
			String course = ((EditText) getActivity().findViewById(R.id.course))
					.getText().toString();
			
			String facultyNum = ((EditText) getActivity().findViewById(R.id.facultyNum))
					.getText().toString();
			
			SharedPreferences sharedPreferences = getActivity().getPreferences(0);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("name", username);
            editor.putString("specialty", specialty);
            editor.putString("course", course);
            editor.putString("facultyNum", facultyNum);
            editor.commit();
			
            WelcomeFragment welcomeFragment = new WelcomeFragment();			
			welcomeFragment.setRetainInstance(false);			
			FragmentManager manager = getActivity().getSupportFragmentManager();
			FragmentTransaction fragmentTransaction = manager.beginTransaction();					
			fragmentTransaction.replace(R.id.container, welcomeFragment);			
			fragmentTransaction.commit();
		}
	};
}
