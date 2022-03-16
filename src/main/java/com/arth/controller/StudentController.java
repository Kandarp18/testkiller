package com.arth.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.arth.bean.StudentBean;
import com.arth.dao.StudentDao;

@Controller
public class StudentController {
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	StudentDao studentdao;
   @Autowired
   Date date;
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
		studentdao.addStudent(student);
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
	@GetMapping("/student")
	public String getAllStudent(Model model) {
		List<StudentBean> student = studentdao.getAllStudent();
	   model.addAttribute("student", student);
	   
		
	
	 model.addAttribute("dy",date.toLocaleString());
		return "NewStudent";
	}
	@PostMapping("/insertstudent")
	public String listStudent(StudentBean student) {
		String plainPassword = student.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(plainPassword);// 10
		student.setPassword(encPassword);
		studentdao.addStudent(student);
		return "redirect:/student";
	}
	@GetMapping("/deletestudent/{studentId}")
	public String deleteSubject(@PathVariable("studentId") int studentId) {

		studentdao.deleteStudent(studentId);

		return "redirect:/student";
	}


}
