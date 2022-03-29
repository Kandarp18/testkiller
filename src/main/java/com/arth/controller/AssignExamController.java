package com.arth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.arth.bean.AssignExamBean;
import com.arth.bean.ExamBean;
import com.arth.dao.AssignExamDao;
import com.arth.dao.ExamDao;

@Controller
public class AssignExamController {
	@Autowired
	ExamDao examdao;
	@Autowired
	AssignExamDao assignexamdao;
	@GetMapping("/examsubject")
	public String assignExamSubject(ExamBean exam,Model model) {
		
		model.addAttribute("exam", examdao.getAllExamByStatus());
        model.addAttribute("e",assignexamdao.getAllAssign());
	    return "AssignExamSubject";

}
	@PostMapping("/examsubject")
	public String insertExam(AssignExamBean exam,Model model) {
       boolean p=false;
		
		AssignExamBean dbExam=assignexamdao.getAllById(exam.getSubjectId(),exam.getExamId());
		if(dbExam!=null) {
		if((exam.getSubjectId()==dbExam.getSubjectId())&&((exam.getExamId())==dbExam.getExamId())){
			p=true;
		}
		}
		
		if(p==true) {
			model.addAttribute("error","Duplicate Data!");
		
		}else {
		assignexamdao.assignExam(exam);
		}
		return "redirect:/examsubject";
	}
	@GetMapping("/deleteassignexam/{assignExamId}")
	public String deleteExam(@PathVariable("assignExamId") int assignExamId) {
       assignexamdao.deleteAssignExam(assignExamId);
		return "redirect:/examsubject";
	}
}

