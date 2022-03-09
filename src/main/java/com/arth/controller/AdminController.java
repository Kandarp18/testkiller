package com.arth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/admindashboard")
	public String adminDashboard() {
		return "AdminDashboard";
	}
	@GetMapping("/class")
	public String newClass() {
		return "NewClass";
	}
	@GetMapping("/subject")
	public String newSubject() {
		return "NewSubject";
	}
	@GetMapping("/assignsubject")
	public String assignSubject() {
		return "AssignSubject";
	}

	@GetMapping("/student")
	public String newStudent() {
		return "NewStudent";
	}
	@GetMapping("/assignstudent")
	public String assignStudent() {
		return "AssignStudent";
	}

	@GetMapping("/exam")
	public String newExam() {
		return "NewExam";
	}
	@GetMapping("/examsubject")
	public String assignExamSubject() {
		return "AssignExamSubject";
	}
	@GetMapping("/examsubjectquestion")
	public String assignExamQuestion() {
		return "AssignExamQuestion";
	}

	@GetMapping("/users")
	public String createUser() {
		return "User";
	}
	@GetMapping("/profile")
	public String Profile() {
		return "EditProfile";
	}

}