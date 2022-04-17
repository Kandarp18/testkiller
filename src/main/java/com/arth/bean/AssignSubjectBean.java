package com.arth.bean;

public class AssignSubjectBean {
	private int assignSubjectId;
	private int classId;
	private int subjectId;
	private String className;
	private String subjectName;
	public int getAssignSubjectId() {
		return assignSubjectId;
	}
	
	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public void setAssignSubjectId(int assignSubjectId) {
		this.assignSubjectId = assignSubjectId;
	}
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
}
