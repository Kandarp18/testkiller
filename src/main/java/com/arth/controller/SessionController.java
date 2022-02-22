package com.arth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arth.bean.UserBean;
import com.arth.dao.UserDao;

@Controller
public class SessionController {
	@Autowired
	UserDao userDao;

	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	@RequestMapping(value = "signup",method = RequestMethod.GET)
	public String signup() {
		System.out.println("I am from Signup....");
		return "Signup";// this is your view page --> html
	}
		
	@RequestMapping(value = "login",method = RequestMethod.GET)
	public String login() {
	
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
		@PostMapping("/login")
		public String authenticate(UserBean user,Model model) {

			boolean isCorrect = false;
			UserBean dbUser = userDao.getUserByEmail(user.getEmail());
			if (dbUser != null) {

				if (bcryptPasswordEncoder.matches(user.getPassword(), dbUser.getPassword()) == true) {
					isCorrect = true;
				}
			}

			if (isCorrect == true) {
				//admin  AdminDashBoard 
				//project manager 
				//developer 
				
				return "Index";
			}else {
				model.addAttribute("error","Invalid Credentials");
				return "Login";
			}
		}

		@RequestMapping(value="forgotpwd",method = RequestMethod.GET)
		public String  forgotPwd(UserBean user) {
			System.out.println(user.getEmail());
			return "Login";
		}
	
	
}