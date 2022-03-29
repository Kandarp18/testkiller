package com.arth.bean;

import java.sql.Date;

public class AssignExamBean {
private int assignExamId;
private int examId;
private String examName;
private int subjectId;
private String subjectName;
private Date examDate;
private int totalQuestion;
private int rightMark;


public int getAssignExamId() {
	return assignExamId;
}
public void setAssignExamId(int assignExamId) {
	this.assignExamId = assignExamId;
}
public int getExamId() {
	return examId;
}
public void setExamId(int examId) {
	this.examId = examId;
}
public String getExamName() {
	return examName;
}
public void setExamName(String examName) {
	this.examName = examName;
}
public int getSubjectId() {
	return subjectId;
}
public void setSubjectId(int subjectId) {
	this.subjectId = subjectId;
}
public String getSubjectName() {
	return subjectName;
}
public void setSubjectName(String subjectName) {
	this.subjectName = subjectName;
}

public Date getExamDate() {
	return examDate;
}
public void setExamDate(Date examDate) {
	this.examDate = examDate;
}
public int getTotalQuestion() {
	return totalQuestion;
}
public void setTotalQuestion(int totalQuestion) {
	this.totalQuestion = totalQuestion;
}
public int getRightMark() {
	return rightMark;
}
public void setRightMark(int rightMark) {
	this.rightMark = rightMark;
}

}
