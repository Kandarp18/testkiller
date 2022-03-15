package com.arth.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arth.bean.ClassBean;
import com.arth.bean.StudentBean;
import com.arth.bean.SubjectBean;
import com.arth.bean.UserBean;
import com.arth.dao.ClassDao;
import com.arth.dao.StudentDao;
import com.arth.dao.SubjectDao;
import com.arth.dao.UserDao;

@Controller
public class SessionController {
	@Autowired
	UserDao userDao;
	@Autowired
	ClassDao classdao;
	@Autowired
	SubjectDao subjectdao;
	@Autowired
	StudentDao studentdao;

	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "Login";
	}

	@GetMapping("/forgotpassword")
	public String forgotPassword() {
		return "ForgotPassword";
	}



	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login2() {
		return "redirect:/login";
	}

	@PostMapping("/forgotpassword")
	public String forgetPassword(StudentBean student, Model model, HttpSession session) {
		StudentBean dbStudent = studentdao.getStudentByEmail(student.getEmail());
            
		if (dbStudent == null ) {
			model.addAttribute("error", "Please Enter Valid Email");
			return "ForgotPassword";

		} else {
			int otp = (int) (Math.random() * 1000000); // 0325842.15621 * 1000000
			session.setAttribute("otp", otp);
			session.setAttribute("email", student.getEmail());
			
			model.addAttribute("msg", "Otp is generated and sent to your email!!!");
			System.out.println("your otp is => " + otp);
			/// send email to user

			return "NewPassword";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";

	}

	@PostMapping("/login")
	public String authenticate(UserBean user, Model model,HttpSession session,ClassBean classes,SubjectBean subject,StudentBean student) {

		boolean isCorrect = false;
		UserBean dbUser = userDao.getUserByEmail(user.getEmail());
		
		if (dbUser != null ) {

			if (bcryptPasswordEncoder.matches(user.getPassword(), dbUser.getPassword()) ) {
				isCorrect = true;
				session.setAttribute("user", dbUser);
				
			}
		}

		if (isCorrect == true) {
			int count=classdao.countClass(classes);
			int countsub=subjectdao.countSubject(subject);
			int countstd=studentdao.countStudent(student);
			model.addAttribute("cc",count);
			model.addAttribute("cs",countsub);
			model.addAttribute("cst",countstd);

			return "AdminDashboard";
		}
		else {
			model.addAttribute("error", "Invalid Credentials!");
			return "Login";
		}
	}

	@PostMapping("/updatepassword")
	public String updatePassword(StudentBean student, HttpSession session, Model model) {
		int otp = (int) session.getAttribute("otp");
		String email = (String) session.getAttribute("email");

		if (otp == student.getOtp() && email.equalsIgnoreCase(student.getEmail())) {

			String encPassword = bcryptPasswordEncoder.encode(student.getPassword());
			student.setPassword(encPassword);

			studentdao.updatePassword(student);

			model.addAttribute("msg", "Password Modified Please Login");
			return "LoginStudent";
		} else {
			model.addAttribute("error", "You data mismatch with our records!!!");
			return "NewPassword";
		}
	}

}