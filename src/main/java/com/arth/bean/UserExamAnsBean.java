package com.arth.bean;

public class UserExamAnsBean {
	private String userAns;
	private int userExamAnsId;
	private int studentId;
	private int examId;
	private int questionId;
	private String ansStatus;
	private int subjectId;
	
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getUserAns() {
		return userAns;
	}
	public void setUserAns(String userAns) {
		this.userAns = userAns;
	}
	public int getUserExamAnsId() {
		return userExamAnsId;
	}
	public void setUserExamAnsId(int userExamAnsId) {
		this.userExamAnsId = userExamAnsId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getAnsStatus() {
		return ansStatus;
	}
	public void setAnsStatus(String ansStatus) {
		this.ansStatus = ansStatus;
	}
	
}
