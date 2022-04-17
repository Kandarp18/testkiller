package com.arth.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arth.bean.UserExamAnsBean;

@Repository
public class UserExamAnsDao {
	@Autowired
	JdbcTemplate stmt;
	public void adduserAns(UserExamAnsBean userexamans) {
		// TODO Auto-generated method stub
		stmt.update("insert into userexamans (userans,studentid,questionid,examid,subjectid,ansstatus) values (?,?,?,?,?,?) ", userexamans.getUserAns(), 
				 userexamans.getStudentId(), userexamans.getQuestionId(), userexamans.getExamId(),userexamans.getSubjectId(),userexamans.getAnsStatus());
		
	}
	public void updateAnsStatus(int examId,int questionId) {
		stmt.update("update userexamans set ansstatus=1 where examId=? and questionid=?",examId,questionId);
	}
	public void updateWrongAnsStatus(int examId,int questionId) {
		stmt.update("update userexamans set ansstatus=0 where examId=? and questionid=?",examId,questionId);
	}
}
