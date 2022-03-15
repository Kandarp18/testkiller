package com.arth.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.arth.bean.StudentBean;

import com.arth.dao.StudentDao;

@Controller
public class StudentController {
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	StudentDao studentdao;

	@GetMapping("/studentdashboard")
	public String newStudent() {
		return "StudentDashboard";
	}
	@GetMapping("/newstudent")
	public String addStudent() {
		return "SignUp";
	}
	@GetMapping("/loginstudent")
	public String login() {
		return "LoginStudent";
	}
	@PostMapping("/savestudent")
	public String saveStudent(StudentBean student) {
		String plainPassword = student.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(plainPassword);// 10
		student.setPassword(encPassword);
		studentdao.addUser(student);
		return "redirect:/loginstudent";
	}
	@PostMapping("/loginstudent")
	public String authenticate(StudentBean student, Model model,HttpSession session) {

		boolean isCorrect = false;
		StudentBean dbStudent=studentdao.getStudentByEmail(student.getEmail());
		
		if (dbStudent != null ) {

			if (bCryptPasswordEncoder.matches(student.getPassword(), dbStudent.getPassword()) ) {
				isCorrect = true;
				session.setAttribute("student", dbStudent);
				
			}
		}

		if (isCorrect == true) {
			

			return "StudentDashboard";
		}
		else {
			model.addAttribute("error", "Invalid Credentials!");
			return "Login";
		}
	}

}
