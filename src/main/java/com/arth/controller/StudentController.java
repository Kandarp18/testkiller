package com.arth.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.arth.bean.ExamBean;
import com.arth.bean.RoleBean;
import com.arth.bean.StudentBean;
import com.arth.dao.AssignExamDao;
import com.arth.dao.ClassDao;
import com.arth.dao.ExamDao;
import com.arth.dao.ProfileDao;
import com.arth.dao.StudentDao;
import com.arth.dao.UserExamDao;

@Controller
public class StudentController {
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	StudentDao studentdao;
	@Autowired
	ExamDao examdao;
	@Autowired
	AssignExamDao assignexamdao;
	@Autowired
	UserExamDao userexamdao;
	@Autowired
	ClassDao classdao;
	@Autowired
	ProfileDao profiledao;
   @Autowired
   Date date;
	@GetMapping("/studentdashboard")
	public String newStudent(@RequestParam("studentId") int studentId,ExamBean exam,Model model) {
		model.addAttribute("s", studentdao.getStudentById(studentId));
		int e=examdao.countAppearedExam(studentId).size();
		model.addAttribute("count", e);
		model.addAttribute("c",examdao.count(studentId).size());
		 model.addAttribute("cp",userexamdao.countPassResult(studentId).size());
	       model.addAttribute("cw",userexamdao.countFailResult(studentId).size());
		return "StudentDashboard";
	}
	@PostMapping("/studentdashboard")
	public String student(@RequestParam("studentId") int studentId,ExamBean exam,Model model) {
		model.addAttribute("s", studentdao.getStudentById(studentId));
	       int e=examdao.countAppearedExam(studentId).size();
	       model.addAttribute("ca", e);
	       model.addAttribute("c",examdao.count(studentId).size());
	       model.addAttribute("cp",userexamdao.countPassResult(studentId).size());
	       model.addAttribute("cw",userexamdao.countFailResult(studentId).size());
		return "StudentDashboard";
	}
	@GetMapping("/newstudent")
	public String addStudent() {
		return "SignUp";
	}
	@GetMapping("/loginstudent")
	public String login() {
		return "LoginStudent";
	}
	@PostMapping("/savestudent")
	public String saveStudent(StudentBean student,Model model) {
		boolean p=false;
		StudentBean dbStudent=studentdao.getStudentByEmail(student.getEmail());
		if(dbStudent!=null) {
		if((student.getEmail()).equalsIgnoreCase(dbStudent.getEmail())==true){
			p=true;
		}
		}
		
		if(p==true) {
			model.addAttribute("error","Account with this Email Address already exists!");
			return "SignUp";
		}else {
		String plainPassword = student.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(plainPassword);// 10
		student.setPassword(encPassword);
		studentdao.addStudent(student);
		return "redirect:/loginstudent";
		}
	}
	@PostMapping("/loginstudent")
	public String authenticate(ExamBean exam,StudentBean student, Model model,HttpSession session) {

		boolean isCorrect = false;
		StudentBean dbStudent=studentdao.getStudentByEmail(student.getEmail());
		
		if (dbStudent != null ) {

			if (bCryptPasswordEncoder.matches(student.getPassword(), dbStudent.getPassword()) ) {
				isCorrect = true;
				session.setAttribute("s", dbStudent);
				
			}
		}

		if (isCorrect == true) {
	
			 
			return "StudentDashboard";
		}
		else {
			model.addAttribute("error", "Invalid Credentials!");
			return "LoginStudent";
		}
	}
	@GetMapping("/student")
	public String getAllStudent(Model model) {
		List<StudentBean> student = studentdao.getAllStudent();
	   model.addAttribute("student", student);
	 model.addAttribute("dy",date.toLocaleString());
		return "NewStudent";
	}
	@PostMapping("/insertstudent")
	public String listStudent(StudentBean student,Model model) {
		boolean p=false;
		StudentBean dbStudent=studentdao.getStudentByEmail(student.getEmail());
		if(dbStudent!=null) {
		if((student.getEmail()).equalsIgnoreCase(dbStudent.getEmail())==true){
			p=true;
		}
		}
		
		if(p==true) {
			model.addAttribute("dy",date.toLocaleString());
			   model.addAttribute("student", studentdao.getAllStudent());
			model.addAttribute("error","Student Data already exists!");
	
		}else {
		String plainPassword = student.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(plainPassword);// 10
		student.setPassword(encPassword);
		studentdao.addStudent(student);
		model.addAttribute("dy",date.toLocaleString());
	    model.addAttribute("student", studentdao.getAllStudent());
		model.addAttribute("success","Student Data Added!");
		}
		return "NewStudent";

	}
	@GetMapping("/deletestudent/{studentId}")
	public String deleteSubject(@PathVariable("studentId") int studentId) {

		studentdao.deleteStudent(studentId);

		return "redirect:/student";
	}
	@GetMapping("/logoutstudent")
	public String logoutStudent(HttpSession session) {
		session.invalidate();
		return "redirect:/loginstudent";

	}
	@GetMapping("/editstudent")
	public String editStudent(@RequestParam("studentId") int studentId, Model model) {	
		model.addAttribute("student", studentdao.getStudentById(studentId));
		
		return "EditStudent";

	}

	@PostMapping("/updatestudent")
	public String updateStudent(@RequestParam("studentId") int studentId,StudentBean student,Model model) {
		boolean p=false;
		StudentBean dbStudent=studentdao.getStudent(student.getEmail(),student.getStudentId());
		if(dbStudent!=null ) {
			if(student.getEmail().equalsIgnoreCase(dbStudent.getEmail()) && (student.getStudentId()!=dbStudent.getStudentId())) {
			p=true;
		}
		}
		
		if(p==true) {
			model.addAttribute("error","Account with this Email Address already exists!");
			model.addAttribute("student", studentdao.getStudentById(studentId));
			return "EditStudent";
		}else {
		studentdao.updateStudent(student);
		 model.addAttribute("dy",date.toLocaleString());
		model.addAttribute("success","Student Data Changed Successfully!");
		model.addAttribute("student", studentdao.getAllStudent());
		}
		return "NewStudent";
	}
	@GetMapping("/studentprofile")
	public String studentProfile(@RequestParam("studentId") int studentId,Model model) {
		model.addAttribute("s", studentdao.getStudentById(studentId));
		
		return "StudentProfile";
	}
	@PostMapping("/saveprofile")
	public String saveProfile(@RequestParam("profilePic") MultipartFile file, HttpSession session,Model model) {
		StudentBean student = (StudentBean) session.getAttribute("s");
		int studentId = student.getStudentId();
		
		String path = "C:\\Project\\testkiller\\src\\main\\resources\\static\\images\\";
		byte image[] = new byte[(int) file.getSize()];
		try {

			File userFolder = new File(path, studentId + "");// 10 20 30
			userFolder.mkdir(); // create folder if not present else it will not create
			
			profiledao.updateProfile("/images//"+ file.getOriginalFilename(), studentId);
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
		
		
			
			model.addAttribute("s", studentdao.getStudentById(studentId));
			model.addAttribute("success","Profile Photo Updated Successfully!");
		return "UploadProfile";
	}
	@PostMapping("/updateprofile")
	public String updateProfile(@RequestParam("studentId") int studentId,StudentBean student,Model model) {
		studentdao.updateStudent(student);
		
			model.addAttribute("success","Student Data Changed Successfully!");
			model.addAttribute("s", studentdao.getStudentById(studentId));
			
		return "StudentProfile";
	}
	@GetMapping("/uploadprofile")
	public String uploadProfile(@RequestParam("studentId") int studentId,Model model) {
		model.addAttribute("s", studentdao.getStudentById(studentId));
		return "UploadProfile";
	}
	@GetMapping("/listexam")
	public String listExam(@RequestParam("studentId") int studentId,Model model) {
		model.addAttribute("student",studentdao.getStudentById(studentId));
		model.addAttribute("exam", examdao.getAllExamByStudent(studentId));
		model.addAttribute("s", studentdao.getStudentById(studentId));
		return "ListExams";
	}
	@GetMapping("/listexamsubject")
	public String listExamSubject(@RequestParam("examId") int examId,@RequestParam("studentId") int studentId,Model model) {
		model.addAttribute("e",examdao.getExamById(examId));
		model.addAttribute("exam",assignexamdao.getAllExamByStudent(examId));
		model.addAttribute("s", studentdao.getStudentById(studentId));
		return "ListExamSubject";
	}
	@GetMapping("/examresult")
	public String listExamResult(@RequestParam("studentId") int studentId,Model model) {
		model.addAttribute("student",studentdao.getStudentById(studentId));
		model.addAttribute("exam", examdao.getAllExamByStudentId(studentId));
		model.addAttribute("s", studentdao.getStudentById(studentId));
		return "ListCompleteExams";
	}
	@GetMapping("/listexamsubjectresult")
	public String listExamSubjectResult(@RequestParam("examId") int examId,@RequestParam("studentId") int studentId,Model model) {
		model.addAttribute("e",examdao.getExamById(examId));
		model.addAttribute("exam",assignexamdao.getAllExamByStudent(examId));
		model.addAttribute("s", studentdao.getStudentById(studentId));
		return "ListExamSubjectResult";
	}
}
