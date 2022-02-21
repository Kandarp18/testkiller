package com.arth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arth.bean.UserBean;

@Controller
public class SessionController {

	@RequestMapping(value = "signup",method = RequestMethod.GET)
	public String signup() {
		System.out.println("I am from Signup....");
		return "Signup";// this is your view page --> html
	}
		
	@RequestMapping(value = "login",method = RequestMethod.GET)
	public String login() {
		System.out.println("I am from Login....");
		return "Login";
	}
			
		@RequestMapping(value = "forgotPassword",method = RequestMethod.GET)
		public String forgotPassword() {
			System.out.println("I am from Forgot Password....");
			return "ForgotPassword";
	}
		@RequestMapping(value="signup",method = RequestMethod.POST)
		public String  saveUser(UserBean user) {
			System.out.println(user.getFirstName());
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			return "Login";
		}
		@RequestMapping(value="savelogin",method = RequestMethod.POST)
		public String  saveLogin(UserBean user) {
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			return "Index";
		}
		@RequestMapping(value="forgotpwd",method = RequestMethod.GET)
		public String  forgotPwd(UserBean user) {
			System.out.println(user.getEmail());
			return "Login";
		}
	
	
}