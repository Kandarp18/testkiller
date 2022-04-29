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

import com.arth.bean.AssignSubjectBean;
import com.arth.bean.SubjectBean;
import com.arth.dao.AssignSubjectDao;
import com.arth.dao.ClassDao;
import com.arth.dao.SubjectDao;


@Controller
public class SubjectController {
	@Autowired
	SubjectDao subjectdao;
	@Autowired
	ClassDao classdao;
	
	@Autowired
	 AssignSubjectDao assignsubjectdao;
	
	
	@SuppressWarnings("deprecation")
	@GetMapping("/subject")
	public String newSubject(Model model) {
		Date date=new Date();
		model.addAttribute("subject", subjectdao.getAllSubject());
	
	    model.addAttribute("dy",date.toLocaleString());
	
		return "NewSubject";
	}
	
	@PostMapping("/newsubject")
	public String newSubject(SubjectBean subject,Model model) {
		boolean p=false;
		Date date=new Date();
	   SubjectBean dbSubject=subjectdao.getSubjectByName(subject.getSubjectName());
		if(dbSubject!=null) {
		if((subject.getSubjectName()).equalsIgnoreCase(dbSubject.getSubjectName())==true){
			p=true;
		
		}
		}
		if(p==true) {
			
			model.addAttribute("error","This Subject Name Already Exists!");
			model.addAttribute("subject", subjectdao.getAllSubject());
			model.addAttribute("dy",date.toLocaleString());
		}else {
			
			model.addAttribute("dy",date.toLocaleString());
			subjectdao.insertSubject(subject);
			model.addAttribute("success","Subject Added Successfully!");
			model.addAttribute("subject", subjectdao.getAllSubject());
		}
	return "NewSubject";
	}
	@GetMapping("/deletesubject/{subjectId}")
	public String deleteSubject(@PathVariable("subjectId") int subjectId) {

		subjectdao.deleteSubject(subjectId);

		return "redirect:/subject";
	}
	@GetMapping("/editsubject")
	public String editSubject(@RequestParam("subjectId") int subjectId, Model model) {	
		
	
		model.addAttribute("sub", subjectdao.getSubjectById(subjectId));
		return "EditSubject";

	}

	@PostMapping("/updatesubject")
	public String updateSubjectById(@RequestParam("subjectId") int subjectId,SubjectBean subject,Model model) {
		boolean p=false;
		
		   SubjectBean dbSubject=subjectdao.getAllById(subject.getSubjectName(),subject.getStatus());
		   if(dbSubject!=null) {
				if((subject.getSubjectName()).equalsIgnoreCase(dbSubject.getSubjectName())&&(subject.getStatus().equals(dbSubject.getStatus()))){
					p=true;
				
				}
				}
			
			if(p==true) {
				model.addAttribute("error","This Subject Name Already Exists!");
				model.addAttribute("sub", subjectdao.getSubjectById(subjectId));
				return "EditSubject";
			}else {
		subjectdao.updateSubject(subject);
		model.addAttribute("success","Subject Name Modified Successfully!");
		model.addAttribute("subject", subjectdao.getAllSubject());
		model.addAttribute("dy",date.toLocaleString());
			}
		return "NewSubject";
	}
	@RequestMapping(value = "/getsubjectbyexam",method = RequestMethod.GET,  produces="application/json")
	@ResponseBody
	public List<AssignSubjectBean> getSubjectByExam(@RequestParam("examId") int examId) {
		
		return assignsubjectdao.getAllAssignSubject(examId);
	}
	
	
}
