package com.arth.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arth.bean.AssignExamBean;
import com.arth.bean.QuestionBean;
import com.arth.bean.UserExamAnsBean;
import com.arth.bean.UserExamBean;
import com.arth.dao.AssignExamDao;
import com.arth.dao.ExamDao;
import com.arth.dao.ExamQuestionDao;
import com.arth.dao.QuestionDao;
import com.arth.dao.UserExamAnsDao;
import com.arth.dao.UserExamDao;

@RestController
public class UserExamAnsController {
	@Autowired
	UserExamAnsDao userexamansdao;
	@Autowired
	ExamQuestionDao examquestiondao;
	@Autowired
	ExamDao examdao;
	@Autowired
	AssignExamDao assignexamdao;
	@Autowired
	UserExamDao userexamdao;
	@Autowired
	QuestionDao questionDao;

	@RequestMapping(value = "/saveuserexamans", method = RequestMethod.POST, produces = "application/json")
	public String saveUserExamAns(UserExamAnsBean userexamans) {
//		userExamAnsDao.adduserans(userexamans);

		int questionId = userexamans.getQuestionId();
		QuestionBean question = questionDao.getQuestionById(questionId);
		if (question.getAnswer().equals(userexamans.getUserAns())) {
			userexamans.setAnsStatus("correct");
		} else {
			userexamans.setAnsStatus("wrong");
		}
		userexamansdao.adduserAns(userexamans);

		return "done";
	}

	@RequestMapping(value = "/generateResult", method = RequestMethod.GET, produces = "application/json")
	public String generateResult(@RequestParam("studentId") int studentId,@RequestParam("subjectId") int subjectId,@RequestParam("examId") int examId,HttpSession session,AssignExamBean aeb) {
		int totalCorrect = 0;

		List<UserExamAnsBean> userexamans = examdao.getUserExamById(examId,subjectId);
      System.out.println(userexamans.size());
		for (int i = 0; i < userexamans.size(); i++) {
			if (userexamans.get(i).getAnsStatus().equals("correct")) {
				totalCorrect++;
			}
		}
	AssignExamBean exam=assignexamdao.getAssignExam(examId);
		//now we need to store correct ans and marks for student 
		//we cancreate result table with column , examid , studentid, obtainmarks,
		System.out.println(totalCorrect);
		int totalObtainMarks=totalCorrect*exam.getRightMark();
		UserExamBean userExam= new UserExamBean();
		userExam.setExamId(examId);
		userExam.setObtainMarks(totalObtainMarks);
		userExam.setSubjectId(subjectId);
		userExam.setStudentId(studentId);
		userexamdao.insertUserExam(userExam);
		return "generated";
	}
}
