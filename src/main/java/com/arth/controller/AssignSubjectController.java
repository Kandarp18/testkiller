package com.arth.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arth.bean.AssignSubjectBean;
import com.arth.bean.SubjectBean;
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
	@Autowired
	Date date;
	@GetMapping("/assignsubject")
	public String assignSubject(Model model) {
		model.addAttribute("classes", classdao.getAllClassesByStatus());
		model.addAttribute("subject",subjectdao.getAllSubjectByStatus());
		model.addAttribute("asb", assignsubjectdao.getAllAssign());
		 
		model.addAttribute("dy",date.toLocaleString());
		return "AssignSubject";
	}
	
	@PostMapping("/assignsubject")
	public String addAssign(AssignSubjectBean asb,Model model,SubjectBean subject) {
		boolean p=false;
		  AssignSubjectBean dbAssign=assignsubjectdao.getAllById(asb.getClassId(), asb.getSubjectId());
		   if(dbAssign!=null) {
			   if((dbAssign.getClassId()==asb.getClassId()) && (dbAssign.getSubjectId()==asb.getSubjectId())) {
				   p=true;
			   }
		   }
		
		
		
		if(p==true) {
			model.addAttribute("classes", classdao.getAllClassesByStatus());
			model.addAttribute("subject",subjectdao.getAllSubjectByStatus());
			model.addAttribute("error","This Subject Name Already Exists in this Class!");
			model.addAttribute("asb", assignsubjectdao.getAllAssign());
		}else {
			assignsubjectdao.assignSubject(asb);
			model.addAttribute("classes", classdao.getAllClassesByStatus());
			model.addAttribute("subject",subjectdao.getAllSubjectByStatus());
		
		model.addAttribute("success","Subject Assigned Successfully!");
		model.addAttribute("asb", assignsubjectdao.getAllAssign());
		model.addAttribute("dy",date.toLocaleString());
		}
	return "AssignSubject";
	}
	@GetMapping("/deleteassignsubject/{assignSubjectId}")
	public String deleteClass(@PathVariable("assignSubjectId") int assignSubjectId) {
       assignsubjectdao.deleteAssignSubject(assignSubjectId);
		return "redirect:/assignsubject";
	}
	@GetMapping("/editassignsubject")
	public String editSubject(@RequestParam("assignSubjectId") int assignSubjectId, Model model) {	
		model.addAttribute("classes", classdao.getAllClassesByStatus());

		model.addAttribute("subject",subjectdao.getAllSubjectByStatus());

		model.addAttribute("sub", assignsubjectdao.getAssignById(assignSubjectId));
		
		return "EditAssignSubject";

	}

	@PostMapping("/updateassignsubject")
	public String updateAssignSubjectById(@RequestParam("assignSubjectId") int assignSubjectId,AssignSubjectBean asb,Model model) {
		boolean p=false;
		  AssignSubjectBean dbAssign=assignsubjectdao.getAllById(asb.getClassId(), asb.getSubjectId());
		   if(dbAssign!=null) {
			   if((dbAssign.getClassId()==asb.getClassId()) && (dbAssign.getSubjectId()==asb.getSubjectId())) {
				   p=true;
			   }
		   }
		
		
		
		if(p==true) {
			model.addAttribute("classes", classdao.getAllClassesByStatus());
			model.addAttribute("subject",subjectdao.getAllSubjectByStatus());
			model.addAttribute("sub", assignsubjectdao.getAssignById(assignSubjectId));
			model.addAttribute("error","This Subject Name Already Exists in this Class!");
			return "EditAssignSubject";

		}else {
			assignsubjectdao.updateAssign(asb);
			model.addAttribute("dy",date.toLocaleString());
			model.addAttribute("asb", assignsubjectdao.getAllAssign());
			model.addAttribute("success","Subject Assignment Modified Successfully!");
			
		
		}
		return "AssignSubject";
	}
	
	
}
