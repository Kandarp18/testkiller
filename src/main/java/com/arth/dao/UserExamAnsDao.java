package com.arth.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arth.bean.UserExamAnsBean;

@Repository
public class UserExamAnsDao {
	@Autowired
	JdbcTemplate stmt;
	public void adduserAns(UserExamAnsBean userexamans) {
		// TODO Auto-generated method stub
		stmt.update("insert into userexamans (userans,studentid,questionid,examid) values (?,?,?,?) ", userexamans.getUserAns(), 
				 userexamans.getStudentId(), userexamans.getQuestionId(), userexamans.getExamId());
		System.out.println("done...");
	}
	public void updateAnsStatus(int examId) {
		stmt.update("update userexamans set ansstatus=1 where questionid in (select questionid from examquestion where examid=?)",examId);
	}
	public void updateWrongAnsStatus(int examId) {
		stmt.update("update userexamans set ansstatus=0 where questionid in (select questionid from examquestion where examid=?)",examId);
	}
}
