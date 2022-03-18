package com.arth.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arth.bean.AssignExamBean;

@Repository
public class AssignExamDao {
	@Autowired
	JdbcTemplate stmt;
	public void assignExam(AssignExamBean aeb) {
		stmt.update("insert into assignexam (examid,subjectid,totalquestion,examdate,rightmark) values (?,?,?,?,?)",aeb.getExamid(),aeb.getSubjectId(),aeb.getTotalQuestion(),aeb.getExamDate(),aeb.getRightMark());
	}
	public List<AssignExamBean> getAllAssign() {
		List<AssignExamBean> student = stmt.query("select a.*,s.studentName,e.examName from assignexam a,student s,exam e where a.studentid=s.studentid and a.examid=e.examid ", new BeanPropertyRowMapper<AssignExamBean>(AssignExamBean.class));
		return student;
	}
}
