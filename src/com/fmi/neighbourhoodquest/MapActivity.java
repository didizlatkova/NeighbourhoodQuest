package com.fmi.neighbourhoodquest;

import java.util.ArrayList;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements
		ConnectionCallbacks, OnConnectionFailedListener, LocationListener,
		OnMarkerClickListener {
	private GoogleMap mMap;

	private LocationClient mLocationClient;
	private MarkerManager manager = new MarkerManager();
	private DbHelper db = new DbHelper(this);
	private ArrayList<Marker> markers = new ArrayList<Marker>();
	private ArrayList<Question> questions;

	private static final LocationRequest REQUEST = LocationRequest.create()
			.setInterval(5000) // 5 seconds
			.setFastestInterval(16) // 16ms = 60fps
			.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);		
	}
	
	@Override
	protected void onResume() {
		this.questions = db.getAllQuestions();
		
		super.onResume();
		setUpMapIfNeeded();
		setUpLocationClientIfNeeded();
		mLocationClient.connect();
	}

	@Override
	public void onPause() {
		super.onPause();
		if (mLocationClient != null) {
			mLocationClient.disconnect();
		}
	}

	private void setUpMapIfNeeded() {
		if (mMap == null) {
			mMap = ((SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.map)).getMap();
			if (mMap != null) {
				mMap.setMyLocationEnabled(true);
				mMap.setOnMarkerClickListener((OnMarkerClickListener) this);

				for (int i = 0; i < questions.size(); i++) {
					Marker marker = mMap.addMarker(new MarkerOptions().visible(false).position(new LatLng(0, 0)));
					this.markers.add(marker);
				}			
			}
		}
	}

	private void setUpLocationClientIfNeeded() {
		if (mLocationClient == null) {
			mLocationClient = new LocationClient(getApplicationContext(), this, this);
		}
	}

	@Override
	public void onLocationChanged(Location location) {		
		ArrayList<Question> questionsToClose = manager.getQuestionsToClose(location.getLatitude(), location.getLongitude(), questions);
		for (Question question : questionsToClose) {
			db.changeQuestionState(question.getID(), QuestionState.CLOSED);
		}
		
		ArrayList<Question> questionsToOpen = manager.getQuestionsToOpen(location.getLatitude(), location.getLongitude(), questions);
		for (Question question : questionsToOpen) {
			db.changeQuestionState(question.getID(), QuestionState.OPEN);
		}
		
		questions = db.getAllQuestions();
		
		for (int i = 0; i < markers.size(); i++) {
			manager.SetMarker(markers.get(i), questions.get(i).getState(),
					questions.get(i).getLatitude(), questions.get(i)
							.getLongitude());			
		}
	}

	@Override
	public void onConnected(Bundle connectionHint) {
		mLocationClient.requestLocationUpdates(REQUEST, this);
		
		try {
			Location location = mLocationClient.getLastLocation();
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 14.0f));
		} catch (Exception e) {
			Toast.makeText(this, "Sorry! Cannot get your location!", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void onDisconnected() {
		// do nothing
	}

	@Override
	public void onConnectionFailed(ConnectionResult arg0) {
		// do nothing
	}

	@Override
	public boolean onMarkerClick(Marker marker) {
		int index = markers.indexOf(marker);
		if (questions.get(index).getState() == QuestionState.OPEN) {
			Intent i = new Intent(this, QuestionActivity.class);
			i.putExtra("index", index);
			startActivity(i);
			return true;
		}
		
		return false;
	}
}