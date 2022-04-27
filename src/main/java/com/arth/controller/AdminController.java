package com.arth.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.arth.bean.ClassBean;
import com.arth.bean.ExamBean;
import com.arth.bean.RoleBean;
import com.arth.bean.StudentBean;
import com.arth.bean.SubjectBean;
import com.arth.bean.UserBean;
import com.arth.dao.ClassDao;
import com.arth.dao.ExamDao;
import com.arth.dao.ProfileDao;
import com.arth.dao.RoleDao;
import com.arth.dao.StudentDao;
import com.arth.dao.SubjectDao;
import com.arth.dao.UserDao;


@Controller
public class AdminController {
	@Autowired
	ClassDao classdao;
	@Autowired
	SubjectDao subjectdao;
	@Autowired
	StudentDao studentdao;
	@Autowired
	ExamDao examdao;
	@Autowired
	RoleDao roledao;
	@Autowired
    UserDao userdao;
	@Autowired
	ProfileDao profiledao;
	

	@GetMapping("/admindashboard")
	public String adminDashboard(ClassBean classes,Model model,SubjectBean subject,StudentBean student,ExamBean exam) {
		int count=classdao.countClass(classes);
		int countsub=subjectdao.countSubject(subject);
		int countstd=studentdao.countStudent(student);
		int countexam=examdao.countExam(exam);
		int countresult=examdao.countResult(exam);
		model.addAttribute("cc",count);
		model.addAttribute("cs",countsub);
		model.addAttribute("cst", countstd);
		model.addAttribute("ce", countexam);
		model.addAttribute("cr",countresult);
		return "AdminDashboard";
	}

	@GetMapping("/profile")
	public String profile(@RequestParam("userId") int userId,Model model) {
		model.addAttribute("u", userdao.getUserById(userId));
		List<RoleBean> role = roledao.getAllRoles();
		model.addAttribute("role", role);	
		
	return "EditProfile";
	}
      
	@GetMapping("/uploadprofilephoto")
	public String uploadProfile(@RequestParam("userId") int userId,Model model) {
		model.addAttribute("user", userdao.getUserById(userId));                  
		return "UploadProfilePhoto";
	}

	@PostMapping("/saveprofilephoto")
	public String saveProfile(@RequestParam("profilePic") MultipartFile file, HttpSession session,Model model) {

		

		UserBean user = (UserBean) session.getAttribute("user");
		int userId = user.getUserId();

		String path = "C:\\Project\\testkiller\\src\\main\\resources\\static\\images\\";

		byte image[] = new byte[(int) file.getSize()];

		try {

			File userFolder = new File(path, userId + "");// 10 20 30
			userFolder.mkdir(); // create folder if not present else it will not create

			profiledao.updateProfilePhoto("/images//" + file.getOriginalFilename(), userId);
			// images/1/a.jpg

			image = file.getBytes();
			File f = new File(userFolder, file.getOriginalFilename());
			f.createNewFile();
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(image);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("user", userdao.getUserById(userId));  
		model.addAttribute("success","Profile Photo Updated Successfully!");
		return "UploadProfilePhoto";
	}
  	}
	
