package com.arth.bean;

import java.sql.Date;

public class StudentBean {
private int StudentId;	
private String StudentName;
private String email;
private String password;
private int otp;
private String gender;
private Date dateOfBirth;
private String status;
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getStudentId() {
	return StudentId;
}
public void setStudentId(int studentId) {
	StudentId = studentId;
}
public String getStudentName() {
	return StudentName;
}
public void setStudentName(String studentName) {
	StudentName = studentName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getOtp() {
	return otp;
}
public void setOtp(int otp) {
	this.otp = otp;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}


}
