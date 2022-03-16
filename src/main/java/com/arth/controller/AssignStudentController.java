package com.arth.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.arth.bean.AssignStudentBean;
import com.arth.dao.AssignStudentDao;
import com.arth.dao.ClassDao;
import com.arth.dao.StudentDao;


@Controller
public class AssignStudentController {
	@Autowired
	AssignStudentDao assignstudentdao;
	@Autowired
	ClassDao classdao;
	@Autowired
	Date date;
	@Autowired
	StudentDao studentdao;
	@GetMapping("/assignstudent")
	public String assignStudent(Model model) {
		model.addAttribute("classes",classdao.getAllClassesByStatus());
		model.addAttribute("student", studentdao.getAllStudentByStatus());
		model.addAttribute("ast", assignstudentdao.getAllAssign());
		 
		 model.addAttribute("dy",date.toLocaleString());
		return "AssignStudent";
	}
	@PostMapping("/assignstudent")
	public String addAssign(AssignStudentBean asb,Model model) {
		boolean p=false;
		AssignStudentBean dbClass=assignstudentdao.getClassById(asb.getClassId());
		AssignStudentBean dbStudent=assignstudentdao.getStudentById(asb.getStudentId());
		AssignStudentBean dbRollNo=assignstudentdao.getStudentByRollNo(asb.getRollNo());
		if(dbClass!=null && dbStudent!=null && dbRollNo!=null) {
		if((asb.getClassId()==dbClass.getClassId())&&(asb.getStudentId()==dbStudent.getStudentId())&&(asb.getRollNo().equalsIgnoreCase(dbRollNo.getRollNo()))){
			p=true;
		}
		}
		
		if(p==true) {
			model.addAttribute("error","Duplicate Data!");
			return "redirect:/assignstudent";
		}else {
			 
		assignstudentdao.assignStudent(asb);
		}
	return "redirect:/assignstudent";
	}
	@GetMapping("/deleteassignstudent/{assignStudentId}")
	public String deleteClass(@PathVariable("assignStudentId") int assignStudentId) {
      assignstudentdao.deleteAssignStudent(assignStudentId);
		return "redirect:/assignstudent";
	}
}
