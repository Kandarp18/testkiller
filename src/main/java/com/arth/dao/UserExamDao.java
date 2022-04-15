package com.arth.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arth.bean.UserExamBean;

@Repository
public class UserExamDao {
	@Autowired
	JdbcTemplate stmt;
	public void insertUserExam(UserExamBean userExam) {
		// TODO Auto-generated method stub
		stmt.update("insert into userexam (examid,studentid,subjectid,status) values (?,?,?,'Started')", 
				 userExam.getExamId(), userExam.getStudentId(),userExam.getSubjectId());
	
	}
}
