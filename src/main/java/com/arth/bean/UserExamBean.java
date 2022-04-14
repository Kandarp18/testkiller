package com.arth.bean;

public class UserExamBean {
	private int userExamId;
	private int examId;
	private int studentId;
	private String status;
	private int obtainMarks;
	public int getUserExamId() {
		return userExamId;
	}
	public void setUserExamId(int userExamId) {
		this.userExamId = userExamId;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getObtainMarks() {
		return obtainMarks;
	}
	public void setObtainMarks(int obtainMarks) {
		this.obtainMarks = obtainMarks;
	}
	
}
