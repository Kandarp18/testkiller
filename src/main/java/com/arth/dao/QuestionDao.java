package com.arth.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arth.bean.QuestionBean;

@Repository
public class QuestionDao {
	@Autowired
	JdbcTemplate stmt;
	
	public void assignQuestion(QuestionBean question) {
		stmt.update("insert into question (examid,subjectid,question,option1,option2,option3,option4,answer) values (?,?,?,?,?,?,?,?)",question.getExamId(),question.getSubjectId(),question.getQuestion(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4(),question.getAnswer());
	}
	public List<QuestionBean> getAllQuestion() {
		List<QuestionBean> question = stmt.query("select q.*,s.subjectName,e.examName from question q,subject s,exam e where q.subjectid=s.subjectid and q.examid=e.examid ", new BeanPropertyRowMapper<QuestionBean>(QuestionBean.class));
		return question;
	}
	
	public void deleteQuestion(int questionId) {
		stmt.update("delete from question where questionid = ?", questionId);
	}
	public QuestionBean getQuestionById(int questionId) {

		QuestionBean question = stmt.queryForObject("select q.*,e.examName,s.subjectName from question q,exam e,subject s where s.subjectid=q.subjectid and e.examid=q.examid and questionid = ? ", new BeanPropertyRowMapper<QuestionBean>(QuestionBean.class), new Object[] { questionId });

		return question;
	}

	public void updateQuestion(QuestionBean q) {
		stmt.update("update question set question=?,option1=?,option2=?,option3=?,option4=?,answer=? where questionid=?",q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getAnswer(),q.getQuestionId());
	}
}
