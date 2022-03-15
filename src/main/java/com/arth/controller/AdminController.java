package com.arth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.arth.bean.ClassBean;
import com.arth.bean.SubjectBean;
import com.arth.dao.ClassDao;
import com.arth.dao.SubjectDao;


@Controller
public class AdminController {
	@Autowired
	ClassDao classdao;
	@Autowired
	SubjectDao subjectdao;
	
	

	@GetMapping("/admindashboard")
	public String adminDashboard(ClassBean classes,Model model,SubjectBean subject) {
		int count=classdao.countClass(classes);
		int countsub=subjectdao.countSubject(subject);
		model.addAttribute("cc",count);
		model.addAttribute("cs",countsub);
		return "AdminDashboard";
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