package com.arth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arth.bean.UserExamAnsBean;
import com.arth.dao.UserExamAnsDao;

@Controller
public class UserExamAnsController {
	@Autowired
	UserExamAnsDao userexamansdao;
	

	@RequestMapping(value = "/saveuserexamans", method = RequestMethod.POST, produces = "application/json")
	public String saveUserExamAns(UserExamAnsBean userexamans) {
//		userExamAnsDao.adduserans(userexamans);
		
		
		
		return "done";
}
}
