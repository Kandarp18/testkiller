package com.arth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.arth.bean.SubjectBean;
import com.arth.dao.ClassDao;
import com.arth.dao.SubjectDao;


@Controller
public class SubjectController {
	@Autowired
	SubjectDao subjectdao;
	@Autowired
	ClassDao classdao;
	
	@GetMapping("/subject")
	public String newSubject(Model model) {
		model.addAttribute("subject", subjectdao.getAllSubject());
		return "NewSubject";
	}
	
	@PostMapping("/newsubject")
	public String newSubject(SubjectBean subject,Model model) {
	subjectdao.insertSubject(subject);
	return "redirect:/subject";
	}
	@GetMapping("/deletesubject/{subjectId}")
	public String deleteSubject(@PathVariable("subjectId") int subjectId) {

		subjectdao.deleteSubject(subjectId);

		return "redirect:/subject";
	}
	@GetMapping("/editsubject")
	public String editSubject(@RequestParam("subjectId") int subjectId, Model model) {	
		
	model.addAttribute("sub", subjectdao.getSubjectById(subjectId));
		
		
		return "redirect:/subject";

	}

	@PostMapping("/updatesubject")
	public String updateSubjectById(SubjectBean subject) {
		subjectdao.updateSubject(subject);
		return "redirect:/class";
	}
	@GetMapping("/assignsubject")
	public String assignSubject(Model model) {
		model.addAttribute("classes", classdao.getAllClasses());
		model.addAttribute("subject",subjectdao.getAllSubject());
		return "AssignSubject";
	}
	
	
	
	
}
