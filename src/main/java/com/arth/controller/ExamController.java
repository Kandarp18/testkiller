package com.arth.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.arth.bean.ExamBean;
import com.arth.dao.ClassDao;
import com.arth.dao.ExamDao;

@Controller
public class ExamController {
  @Autowired
  ExamDao examdao;
  @Autowired
  ClassDao classdao;
  @Autowired
	Date date;
	@GetMapping("/exam")
	public String newExam(Model model) {
		model.addAttribute("classes",classdao.getAllClassesByStatus());
		model.addAttribute("exam",examdao.getAllExam());
		model.addAttribute("dy",date.toLocaleString());
		return "NewExam";
	}
	@PostMapping("/exam")
	public String insertClass(ExamBean exam) {
		examdao.addExam(exam);
		return "redirect:/exam";
	}
	@GetMapping("/deleteexam/{examId}")
	public String deleteExam(@PathVariable("examId") int examId) {

		examdao.deleteExam(examId);
		return "redirect:/exam";
	}
}
