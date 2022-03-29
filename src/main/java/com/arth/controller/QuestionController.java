package com.arth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arth.bean.AssignExamBean;
import com.arth.bean.QuestionBean;
import com.arth.dao.ExamDao;
import com.arth.dao.QuestionDao;

@Controller
public class QuestionController {
	@Autowired
	ExamDao examdao;
	@Autowired
	QuestionDao questiondao;
	
	@GetMapping("/examsubjectquestion")
	public String assignExamQuestion(Model model) {
		
		model.addAttribute("exam", examdao.getAllExamByStatus());
        model.addAttribute("q", questiondao.getAllQuestion());

		return "AssignExamQuestion";
	}
	@PostMapping("/examsubjectquestion")
	public String insertExam(QuestionBean question) {
          questiondao.assignQuestion(question);
		
		return "redirect:/examsubjectquestion";
	}
	@GetMapping("/deletequestion/{questionId}")
	public String deleteExam(@PathVariable("questionId") int questionId) {
       questiondao.deleteQuestion(questionId);
		return "redirect:/examsubjectquestion";
	}
	
	@GetMapping("/editquestion")
	public String editQuestion(@RequestParam("questionId") int questionId, Model model) {	
		model.addAttribute("q", questiondao.getQuestionById(questionId));
		return "EditQuestion";

	}
	@PostMapping("/updatequestion")
	public String updateQuestion(@RequestParam("questionId") int questionId,QuestionBean question,Model model) {
		questiondao.updateQuestion(question);
		return "redirect:/examsubjectquestion";

	}
}
