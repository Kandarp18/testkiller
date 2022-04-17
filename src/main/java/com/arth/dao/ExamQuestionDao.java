package com.arth.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arth.bean.QuestionBean;

@Repository
public class ExamQuestionDao {
@Autowired
JdbcTemplate stmt;

public void mapQuestion(int examId,int questionId,int subjectId) {
	stmt.update("insert into examquestion (examid,questionid,subjectId) values (?,?,?)",examId,questionId,subjectId);
}
public List<QuestionBean> getAllQuestionByExam(int subjectId){
	return stmt.query("select * from question where questionid in (select questionid from examquestion where subjectid=?)",new BeanPropertyRowMapper<QuestionBean>(QuestionBean.class),new Object[] {subjectId});
}
public List<QuestionBean> getAllQuestionBySubject(int examId,int subjectId){
	return stmt.query("select * from question where questionid in (select questionid from examquestion where examid=? and subjectid=?)",new BeanPropertyRowMapper<QuestionBean>(QuestionBean.class),new Object[] {examId,subjectId});
}
public List<QuestionBean> getAllQuestion(int examId){
	return stmt.query("select * from question where questionid in (select questionid from examquestion where examid=?)",new BeanPropertyRowMapper<QuestionBean>(QuestionBean.class),new Object[] {examId});
}
}
