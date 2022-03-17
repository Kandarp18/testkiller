package com.arth.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arth.bean.ExamBean;


@Repository
public class ExamDao {
	@Autowired
	JdbcTemplate stmt;

	public void addExam(ExamBean exam) {
		stmt.update("insert into exam (examname,resultdate,duration,status,classid) values (?,?,?,?,?) ", exam.getExamName(),exam.getResultDate(),exam.getDuration(),exam.getStatus(),exam.getClassId());
	}

	public List<ExamBean> getAllExam() {
		return stmt.query("select e.*,c.className  from exam e,classes c where e.classid=c.classid ",
				new BeanPropertyRowMapper<ExamBean>(ExamBean.class));
	}
	public void deleteExam(int examId) {
		stmt.update("delete from exam where examid = ?", examId);
	}

}
