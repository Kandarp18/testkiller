package com.arth.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arth.bean.AssignExamBean;
import com.arth.bean.ExamBean;
import com.arth.dao.AssignExamDao;
import com.arth.dao.ClassDao;
import com.arth.dao.ExamDao;
import com.arth.dao.QuestionDao;
import com.arth.dao.StudentDao;

@Controller
public class ExamController {
  @Autowired
  ExamDao examdao;
  @Autowired
  QuestionDao questiondao;
  @Autowired
  ClassDao classdao;
  @Autowired
  StudentDao studentdao;
  @Autowired
	Date date;
  @Autowired
  AssignExamDao assignexamdao;
	@GetMapping("/exam")
	public String newExam(Model model) {
		model.addAttribute("classes",classdao.getAllClassesByStatus());
		model.addAttribute("exam",examdao.getAllExam());
		model.addAttribute("dy",date.toLocaleString());
		return "NewExam";
	}
	@PostMapping("/exam")
	public String insertClass(ExamBean exam,Model model) {
boolean p=false;
		
		ExamBean dbExam=examdao.getAllById(exam.getClassId(),exam.getExamName());
		if(dbExam!=null) {
		if((exam.getClassId()==dbExam.getClassId())&&((exam.getExamName()).equalsIgnoreCase(dbExam.getExamName()))){
			p=true;
		}
		}
		
		if(p==true) {
			model.addAttribute("error","Duplicate Data!");
		
		}else {
		examdao.addExam(exam);
		}
		return "redirect:/exam";
	}
	@GetMapping("/deleteexam/{examId}")
	public String deleteExam(@PathVariable("examId") int examId) {

		examdao.deleteExam(examId);
		return "redirect:/exam";
	}
	@GetMapping("/editexam")
	public String editExam(@RequestParam("examId") int examId, Model model) {	
		model.addAttribute("classes",classdao.getAllClassesByStatus());
		model.addAttribute("exam",examdao.getExamById(examId));
		return "EditExam";

	}

	@PostMapping("/updateexam")
	public String updateClass(@RequestParam("examId") int examId,ExamBean exam,Model model) {
boolean p=false;
		
		ExamBean dbExam=examdao.getAll(exam.getClassId(),exam.getExamName());
		if(dbExam!=null) {
		if((exam.getClassId()==dbExam.getClassId())&&((exam.getExamName()).equalsIgnoreCase(dbExam.getExamName()))){
			p=true;
		}
		}
		
		if(p==true) {
			model.addAttribute("error","Duplicate Data!");
		      return "redirect:/editexam?examId="+examId;
		}else {
		examdao.updateExam(exam);
		}
		return "redirect:/exam";

	}
	@RequestMapping(value = "/getsubjectbyexamid",method = RequestMethod.GET,  produces="application/json")
	@ResponseBody
	public List<AssignExamBean> getSubjectByExam(@RequestParam("examId") int examId) {
		
		return assignexamdao.getAllAssignSubject(examId);
	}
	@GetMapping("/newtest")
   public String newTest(@RequestParam("examId") int examId,@RequestParam("subjectId") int subjectId,Model model) {
		questiondao.getAll(examId, subjectId);
		
		return "NewTest";
	}
}
