package com.arth.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arth.bean.ClassBean;
import com.arth.bean.ExamBean;
import com.arth.bean.RoleBean;
import com.arth.bean.StudentBean;
import com.arth.bean.SubjectBean;
import com.arth.dao.ClassDao;
import com.arth.dao.ExamDao;
import com.arth.dao.RoleDao;
import com.arth.dao.StudentDao;
import com.arth.dao.SubjectDao;
import com.arth.dao.UserDao;


@Controller
public class AdminController {
	@Autowired
	ClassDao classdao;
	@Autowired
	SubjectDao subjectdao;
	@Autowired
	StudentDao studentdao;
	@Autowired
	ExamDao examdao;
	@Autowired
	RoleDao roledao;
	@Autowired
    UserDao userdao;
	

	@GetMapping("/admindashboard")
	public String adminDashboard(ClassBean classes,Model model,SubjectBean subject,StudentBean student,ExamBean exam) {
		int count=classdao.countClass(classes);
		int countsub=subjectdao.countSubject(subject);
		int countstd=studentdao.countStudent(student);
		int countexam=examdao.countExam(exam);
		int countresult=examdao.countResult(exam);
		model.addAttribute("cc",count);
		model.addAttribute("cs",countsub);
		model.addAttribute("cst", countstd);
		model.addAttribute("ce", countexam);
		model.addAttribute("cr",countresult);
		return "AdminDashboard";
	}

	@GetMapping("/profile")
	public String profile(@RequestParam("userId") int userId,Model model) {
		model.addAttribute("u", userdao.getUserById(userId));
		List<RoleBean> role = roledao.getAllRoles();
		model.addAttribute("role", role);	
	return "EditProfile";
	}
      
     
  	}
	
