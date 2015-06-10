package com.fmi.neighbourhoodquest;

public class Question {
	private int ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

	private String question;
	private String answer;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private QuestionState state;
	private double latitude;
	private double longitude;
	
	
	public double getLatitude() {
		return latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public Question(String question, String answer, String option1, String option2, String option3, String option4, QuestionState state, double latitude, double longitude){
		this.question = question;
		this.answer = answer;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.state = state;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public Question() {
		
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public void setState(QuestionState state) {
		this.state = state;
	}
	public String getAnswer() {
		return answer;
	}
	
	public String getOption1() {
		return option1;
	}
	
	public String getOption2() {
		return option2;
	}
	
	public String getOption3() {
		return option3;
	}
	
	public String getOption4() {
		return option4;
	}
	
	public QuestionState getState() {
		return state;
	}
}
