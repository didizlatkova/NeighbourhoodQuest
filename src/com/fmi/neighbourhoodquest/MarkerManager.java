package com.fmi.neighbourhoodquest;

import java.util.ArrayList;

import android.location.Location;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

public class MarkerManager {

	private final float MAX_DISTANCE_TO_QUESTION = 100.0f;

	public void SetMarker(Marker marker, QuestionState state, double latitude,
			double longitude) {
		switch (state) {
		case INVISIBLE:
			marker.setVisible(false);
			break;

		case OPEN:
			marker.setPosition(new LatLng(latitude, longitude));
			marker.setVisible(true);
			marker.setIcon(BitmapDescriptorFactory
					.fromResource(R.drawable.blue_mark));
			break;

		case CLOSED:
			marker.setPosition(new LatLng(latitude, longitude));
			marker.setVisible(true);
			marker.setIcon(BitmapDescriptorFactory
					.fromResource(R.drawable.gray_mark));
			marker.setTitle("Този въпрос не е открит!");
			marker.setSnippet("Приближете се, за да го откриете.");
			break;

		case ANSWERED_WRONG:
			marker.setPosition(new LatLng(latitude, longitude));
			marker.setVisible(true);
			marker.setIcon(BitmapDescriptorFactory
					.fromResource(R.drawable.red_mark));
			marker.setTitle("Вече сте отговорили на този въпрос!");
			marker.setSnippet("Отговорът е бил грешен.");
			break;

		case ANSWERED_RIGHT:
			marker.setPosition(new LatLng(latitude, longitude));
			marker.setVisible(true);
			marker.setIcon(BitmapDescriptorFactory
					.fromResource(R.drawable.green_mark));
			marker.setTitle("Вече сте отговорили на този въпрос!");
			marker.setSnippet("Отговорът е бил верен.");
			break;

		default:
			break;
		}
	}

	public Question getClosestInvisibleQuestion(double latitude,
			double longitude, ArrayList<Question> questions) {
		float bestDistance = Float.MAX_VALUE;
		Question closestQuestion = null;

		for (Question question : questions) {
			Location loc1 = new Location("");
			loc1.setLatitude(latitude);
			loc1.setLongitude(longitude);

			Location loc2 = new Location("");
			loc2.setLatitude(question.getLatitude());
			loc2.setLongitude(question.getLongitude());
			if (question.getState() == QuestionState.INVISIBLE
					&& loc1.distanceTo(loc2) < bestDistance) {
				bestDistance = loc1.distanceTo(loc2);
				closestQuestion = question;
			}
		}

		return closestQuestion;
	}

	public ArrayList<Question> getQuestionsToClose(double currentLatitude,
			double currentLongitude, ArrayList<Question> questions) {
		ArrayList<Question> list = new ArrayList<Question>();
		for (Question question : questions) {
			Location loc1 = new Location("");
			loc1.setLatitude(currentLatitude);
			loc1.setLongitude(currentLongitude);

			Location loc2 = new Location("");
			loc2.setLatitude(question.getLatitude());
			loc2.setLongitude(question.getLongitude());

			if (question.getState() == QuestionState.OPEN
					&& loc1.distanceTo(loc2) > MAX_DISTANCE_TO_QUESTION) {
				// question is >40m away => close it
				list.add(question);
			}
		}

		return list;
	}

	public ArrayList<Question> getQuestionsToOpen(double currentLatitude,
			double currentLongitude, ArrayList<Question> questions) {
		ArrayList<Question> list = new ArrayList<Question>();

		for (Question question : questions) {
			Location loc1 = new Location("");
			loc1.setLatitude(currentLatitude);
			loc1.setLongitude(currentLongitude);

			Location loc2 = new Location("");
			loc2.setLatitude(question.getLatitude());
			loc2.setLongitude(question.getLongitude());

			if (question.getState() == QuestionState.CLOSED
					&& loc1.distanceTo(loc2) <= MAX_DISTANCE_TO_QUESTION) {
				// question is <=40m away => open it
				list.add(question);
			}
		}

		return list;
	}
}
