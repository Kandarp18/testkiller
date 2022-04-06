package com.arth.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arth.bean.AssignExamBean;
import com.arth.bean.ExamBean;
import com.arth.bean.QuestionBean;
import com.arth.dao.AssignExamDao;
import com.arth.dao.ExamDao;
import com.arth.dao.ExamQuestionDao;
import com.arth.dao.QuestionDao;

@Controller
public class AssignExamController {
	@Autowired
	ExamDao examdao;
	@Autowired
	AssignExamDao assignexamdao;
	@Autowired
ExamQuestionDao examquestiondao;
	@Autowired
	QuestionDao questiondao;
	@GetMapping("/examsubject")
	public String assignExamSubject(ExamBean exam,Model model) {
		
		model.addAttribute("exam", examdao.getAllExamByStatus());
        model.addAttribute("e",assignexamdao.getAllAssign());
	    return "AssignExamSubject";

}
	public int getRandomNumberUsingNextInt(int min,int max) {
		Random random=new Random();
		return random.nextInt(max - min) + min;
	}
	@GetMapping("/generatequestion")
	public String generateQuestion(@RequestParam("examId") int examId,@RequestParam("subjectId") int subjectId,Model model) {
		AssignExamBean exam=assignexamdao.getAssignExamById(examId,subjectId);
		
				int subId=exam.getSubjectId();
				
			int totalQuestion=exam.getTotalQuestion();
			int questionId=0;
		List<QuestionBean> question=questiondao.getQuestionBySubject(subjectId);
		
	      if(question.size()>=totalQuestion) {
	    	  int totalFound=1;
	    	  ArrayList<Integer> randomQ=new ArrayList<>();
	    	  while(totalFound <= totalQuestion) {
	    		  int random=getRandomNumberUsingNextInt(0, question.size()-1);
	    		  if(!randomQ.contains(random)) {
	    			  randomQ.add(random);
	    			  totalFound++;
	    		  }
	    	  }
	      
	    	  for(int i: randomQ) {
	    		  examquestiondao.mapQuestion(examId, question.get(i).getQuestionId());
	    	  }
	      
	    	  return "redirect:/assignexamquestion";
	      }
		
	      else {
	    	  model.addAttribute("error","Please Add Sufficient Questions!");
	    	  return "redirect:/examsubject";
	      }
		
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
	@GetMapping("/editassignexam")
	public String editSubject(@RequestParam("assignExamId") int assignExamId, Model model) {	
		model.addAttribute("e", examdao.getAllExamByStatus());
		model.addAttribute("ae", assignexamdao.getExamById(assignExamId));
		return "EditAssignExam";

	}
	@PostMapping("/updateassignexam")
	public String updateExam(@RequestParam("assignExamId") int assignExamId,AssignExamBean exam,Model model) {
		assignexamdao.updateExam(exam);
		return "redirect:/examsubject";

	}
}

