package com.arth.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.arth.bean.QuestionBean;
import com.arth.bean.StudentBean;
import com.arth.bean.SubjectBean;
import com.arth.bean.UserExamAnsBean;
import com.arth.bean.UserExamBean;
import com.arth.dao.AssignExamDao;
import com.arth.dao.AssignStudentDao;
import com.arth.dao.ClassDao;
import com.arth.dao.ExamDao;
import com.arth.dao.ExamQuestionDao;
import com.arth.dao.QuestionDao;
import com.arth.dao.StudentDao;
import com.arth.dao.SubjectDao;
import com.arth.dao.UserExamAnsDao;
import com.arth.dao.UserExamDao;

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
  SubjectDao subjectdao;
  @Autowired
  ExamQuestionDao examquestiondao;
  @Autowired
	Date date;
  @Autowired
  AssignExamDao assignexamdao;
  @Autowired
  AssignStudentDao assignstudentdao;
  @Autowired
  UserExamDao userexamdao;
  @Autowired
  UserExamAnsDao userexamansdao;
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
			model.addAttribute("classes",classdao.getAllClassesByStatus());
			model.addAttribute("exam",examdao.getAllExam());
			model.addAttribute("error","Duplicate Data!");
			model.addAttribute("dy",date.toLocaleString());
		     
		}else {
			examdao.addExam(exam);
			model.addAttribute("exam",examdao.getAllExam());
			model.addAttribute("success","Exam Details Added Successfully!");	
		
		model.addAttribute("dy",date.toLocaleString());
		}
		return "NewExam";
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
			model.addAttribute("classes",classdao.getAllClassesByStatus());
			model.addAttribute("exam",examdao.getExamById(examId));
		      return "EditExam";
		}else {
		examdao.updateExam(exam);
		model.addAttribute("exam",examdao.getAllExam());
		model.addAttribute("success","Exam Details Modified Successfully!");	
		model.addAttribute("classes",classdao.getAllClassesByStatus());
	    model.addAttribute("dy",date.toLocaleString());
		}
		return "NewExam";

	}
	
	@RequestMapping(value = "/getsubjectbyexamid",method = RequestMethod.GET,  produces="application/json")
	@ResponseBody
	public List<AssignExamBean> getSubjectByExam(@RequestParam("examId") int examId) {
		
		return assignexamdao.getAllAssignSubject(examId);
	}
	@GetMapping("/newtest")
   public String newTest(@RequestParam("studentId") int studentId,@RequestParam("examId") int examId,@RequestParam("subjectId") int subjectId,UserExamBean userExam,Model model,HttpSession session) {
		List <QuestionBean> q=examquestiondao.getAllQuestionBySubject(examId, subjectId);
		
		assignexamdao.updateStatus(examId, subjectId);
		examdao.updateExamStatus(examId);
		StudentBean student = (StudentBean)session.getAttribute("student");
		if(student == null) {
			student = new StudentBean();
			student.setStudentId(studentId);
			session.setAttribute("student", student);
		}
		model.addAttribute("q",q);
		model.addAttribute("e", examdao.getExam(examId));
		model.addAttribute("s", subjectdao.getSubjectById(subjectId));
        model.addAttribute("st", studentdao.getStudentById(studentId));       
		model.addAttribute("ast",assignstudentdao.getAssignByStudent(studentId));
		model.addAttribute("studentId",student.getStudentId());
		return "NewTest";
	}
	@GetMapping("/examreport")
	public String examResult(@RequestParam("examId") int examId,@RequestParam("studentId") int studentId,Model model,ExamBean exam) {
		model.addAttribute("result", userexamdao.viewResult(examId, studentId));	
		model.addAttribute("s", studentdao.getStudentById(studentId));
		model.addAttribute("sum",userexamdao.sumMarks(examId, studentId));
		model.addAttribute("ast",assignstudentdao.getAssignByStudent(studentId));
		model.addAttribute("e", examdao.getExam(examId));
		return "ExamResult";
}
	@GetMapping("/examsubjectreport")
	public String examSubjectResult(@RequestParam("examId") int examId,@RequestParam("studentId") int studentId,@RequestParam("subjectId") int subjectId,Model model,ExamBean exam) {
		model.addAttribute("st", subjectdao.getSubjectById(subjectId));
		model.addAttribute("s", studentdao.getStudentById(studentId));
		model.addAttribute("result", userexamdao.viewSubjectResult(examId, studentId, subjectId));
		model.addAttribute("ast",assignstudentdao.getAssignByStudent(studentId));
		model.addAttribute("e", examdao.getExam(examId));
		model.addAttribute("sum",userexamdao.sumMarks(examId, studentId));
		return "ExamSubjectResult";
}
	@GetMapping("/examstudentreport")
	public String examStudentResult(@RequestParam("examId") int examId,Model model,ExamBean exam) {
		model.addAttribute("result",userexamdao.viewStudentResult(examId));
		model.addAttribute("e", examdao.getClassNameByExamId(examId));
		return "ViewStudentResult";
}
	
}
