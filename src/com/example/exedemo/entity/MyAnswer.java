package com.example.exedemo.entity;

public class MyAnswer {
	private int id;
	private String answer;
	private int questionId;
	private int testPaperId;
	
	public MyAnswer(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getTestPaperId() {
		return testPaperId;
	}

	public void setTestPaperId(int testPaperId) {
		this.testPaperId = testPaperId;
	}
	
	
}
