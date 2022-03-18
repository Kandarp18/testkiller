package com.arth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.arth.bean.ExamBean;
import com.arth.dao.AssignSubjectDao;
import com.arth.dao.ExamDao;

@Controller
public class AssignExamController {
	@Autowired
	ExamDao examdao;
	@Autowired
	AssignSubjectDao assignsubjectdao;
	@GetMapping("/examsubject")
	public String assignExamSubject(ExamBean exam,Model model) {
		model.addAttribute("exam", examdao.getAllExam());
	
			model.addAttribute("subject",assignsubjectdao.getAllAssignSubject(exam.getExamId()));
	
	return "AssignExamSubject";
}
}

