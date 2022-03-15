package com.arth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.arth.bean.AssignSubjectBean;
import com.arth.dao.AssignSubjectDao;
import com.arth.dao.ClassDao;
import com.arth.dao.SubjectDao;

@Controller
public class AssignSubjectController {
	@Autowired
	ClassDao classdao;
	@Autowired
	SubjectDao subjectdao;
	@Autowired
	AssignSubjectDao assignsubjectdao;
	@GetMapping("/assignsubject")
	public String assignSubject(Model model) {
		model.addAttribute("classes", classdao.getAllClassesByStatus());
		model.addAttribute("subject",subjectdao.getAllSubjectByStatus());
		
		return "AssignSubject";
	}
	
	@PostMapping("/assignsubject")
	public String addAssign(AssignSubjectBean asb,Model model) {
		
	return "redirect:/assignsubject";
	}
	
}
