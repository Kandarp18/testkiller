package com.arth.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arth.bean.ClassBean;

import com.arth.dao.ClassDao;



@Controller
public class ClassController {
	@Autowired
	ClassDao classdao;
	
	
	@GetMapping("/class")
	public String newClass(Model model) {
	     
		model.addAttribute("classes", classdao.getAllClasses());	
		
		return "NewClass";
	}
	
	
	
	@PostMapping("/newclass")
	public String addClass(ClassBean classes,Model model) {
		boolean p=false;
		ClassBean dbClass=classdao.getClassByName(classes.getClassName());
	    if(dbClass!=null) {
		if((classes.getClassName()).equalsIgnoreCase(dbClass.getClassName())){
			p=true;
		}
		}
		
		if(p==true) {
			model.addAttribute("error","This Class Name Already Exists!");
			return "redirect:/class";
		}else {
			classdao.insertClass(classes);
		}
		return "redirect:/class";
		}
	
	
	
	@GetMapping("/deleteclass/{classId}")
	public String deleteClass(@PathVariable("classId") int classId) {

		classdao.deleteClass(classId);

		return "redirect:/class";
	}
	


@GetMapping("/editclass")
public String editClass(@RequestParam("classId") int classId, Model model) {	
	ClassBean classes=classdao.getClassById(classId);
	model.addAttribute("c", classes);
	
	return "EditClass";

}

@PostMapping("/updateclass")
public String updateClass(ClassBean classes) {
	classdao.updateClass(classes);
	return "redirect:/class";
}

}