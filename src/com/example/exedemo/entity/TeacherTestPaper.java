package com.example.exedemo.entity;
/**
 * 老师管理的试卷
 * @author xhj
 * 2015-9-19
 */
public class TeacherTestPaper extends TestPaper {
	private int examCount; //考试过多少次
	private int practiceCount;  //联系过多少次
	
	public TeacherTestPaper(){}

	public int getExamCount() {
		return examCount;
	}

	public void setExamCount(int examCount) {
		this.examCount = examCount;
	}

	public int getPracticeCount() {
		return practiceCount;
	}

	public void setPracticeCount(int practiceCount) {
		this.practiceCount = practiceCount;
	}
	
	
}
