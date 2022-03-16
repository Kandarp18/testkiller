package com.arth.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		model.addAttribute("asb", assignsubjectdao.getAllAssign());
		  Date date=new Date();
		model.addAttribute("dy",date.toLocaleString());
		return "AssignSubject";
	}
	
	@PostMapping("/assignsubject")
	public String addAssign(AssignSubjectBean asb,Model model) {
		boolean p=false;
		AssignSubjectBean dbClass=assignsubjectdao.getClassById(asb.getClassId());
		AssignSubjectBean dbSubject=assignsubjectdao.getSubjectById(asb.getSubjectId());
		if(dbClass!=null && dbSubject!=null) {
		if((asb.getClassId()==dbClass.getClassId())&&(asb.getSubjectId())==dbSubject.getSubjectId()){
			p=true;
		}
		}
		
		if(p==true) {
			model.addAttribute("error","This Subject Name Already Exists in this Class!");
			return "redirect:/assignsubject";
		}else {
		assignsubjectdao.assignSubject(asb);
		}
	return "redirect:/assignsubject";
	}
	@GetMapping("/deleteassignsubject/{assignSubjectId}")
	public String deleteClass(@PathVariable("assignSubjectId") int assignSubjectId) {
       assignsubjectdao.deleteAssignSubject(assignSubjectId);
		return "redirect:/assignsubject";
	}
	
}
