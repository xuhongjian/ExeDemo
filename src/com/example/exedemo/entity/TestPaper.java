package com.example.exedemo.entity;

import java.util.ArrayList;
import com.lidroid.xutils.db.annotation.Table;

@Table(name = "TestPaper")
public class TestPaper {
	
	public enum TYPE{
		LANGUAGE(0),MATH(1),POLITICS(2),GEOGRAPHY(3);
		
		public int value;
		
		private TYPE(int value){
			this.value = value;
		}
	}
	
	private int id;
	private int testId;
	private int testType;
	private int testTitle;
	private int questionCount;
	private String testTeacher;
	private int totalScore; //试卷总分
	private int longTime; //考试时长
	private int flag; //0考试  1练习
	private ArrayList<Question> questions; //试卷所有的题目
	private String questionIdStrs; //试卷题目id字符串  json格式
	
	public TestPaper(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getTestType() {
		return testType;
	}
	public void setTestType(int testType) {
		this.testType = testType;
	}
	public int getTestTitle() {
		return testTitle;
	}
	public void setTestTitle(int testTitle) {
		this.testTitle = testTitle;
	}
	public int getQuestionCount() {
		return questionCount;
	}
	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}

	public String getTestTeacher() {
		return testTeacher;
	}

	public void setTestTeacher(String testTeacher) {
		this.testTeacher = testTeacher;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getLongTime() {
		return longTime;
	}

	public void setLongTime(int longTime) {
		this.longTime = longTime;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

	public String getQuestionIdStrs() {
		return questionIdStrs;
	}

	public void setQuestionIdStrs(String questionIdStrs) {
		this.questionIdStrs = questionIdStrs;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	
}
