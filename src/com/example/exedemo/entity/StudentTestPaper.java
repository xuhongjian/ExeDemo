package com.example.exedemo.entity;

import java.util.ArrayList;

/**
 * 学生考试用的试卷
 * @author xhj
 * 2015-9-19
 */
public class StudentTestPaper extends TestPaper{
	public enum STATU{
		NOEXAM(0), //未考
		EXAMED(1),  //已考
		PASSTIME(2), //过期
		EXAMING(3);  //考试中
		
		public int value;
		
		private STATU(int value){
			this.value = value;
		}
	}
	
	private String examStartTime; //开考时间
	private String examEndTime; //结束时间
	private int statu;
	private double myScore; //我的得分
	private ArrayList<MyAnswer> myAnswers; //我的答案
	
	public StudentTestPaper(){}

	public int getStatu() {
		return statu;
	}

	public void setStatu(int statu) {
		this.statu = statu;
	}

	public double getMyScore() {
		return myScore;
	}

	public void setMyScore(double myScore) {
		this.myScore = myScore;
	}

	public String getExamStartTime() {
		return examStartTime;
	}

	public void setExamStartTime(String examStartTime) {
		this.examStartTime = examStartTime;
	}

	public String getExamEndTime() {
		return examEndTime;
	}

	public void setExamEndTime(String examEndTime) {
		this.examEndTime = examEndTime;
	}

	public ArrayList<MyAnswer> getMyAnswers() {
		return myAnswers;
	}

	public void setMyAnswers(ArrayList<MyAnswer> myAnswers) {
		this.myAnswers = myAnswers;
	}
}
