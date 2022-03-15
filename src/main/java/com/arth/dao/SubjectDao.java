package com.arth.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arth.bean.SubjectBean;


@Repository
public class SubjectDao {
	@Autowired
	JdbcTemplate stmt;
	
	public void insertSubject(SubjectBean subject) {
		stmt.update("insert into subject (subjectname,status) values (?,?)", subject.getSubjectName(), subject.getStatus());
	}

	public List<SubjectBean> getAllSubject() {
		List<SubjectBean> classes = stmt.query("select * from subject", new BeanPropertyRowMapper<SubjectBean>(SubjectBean.class));
		return classes;
	}
	public void deleteSubject(int subjectId) {
		stmt.update("delete from subject where subjectid = ?", subjectId);
	}
	
	public SubjectBean getSubjectById(int subjectId) {

	   SubjectBean subject = stmt.queryForObject("select * from subject where subjectid = ? ", new BeanPropertyRowMapper<SubjectBean>(SubjectBean.class), new Object[] { subjectId });

		return subject;
	}

	public void updateSubject(SubjectBean subject) {
		stmt.update("update subject set subjectname = ? where subjectid = ? ", subject.getSubjectName(), subject.getSubjectId());
	}
	public int countSubject(SubjectBean subject) {
		return stmt.queryForObject("select count(*) from subject where status='Active'", Integer.class);
	}
	public SubjectBean getSubjectByName(String subjectName) {
		SubjectBean dbSubject = null;

		try {
			dbSubject = stmt.queryForObject("select * from subject where subjectname = ? ",
					new BeanPropertyRowMapper<SubjectBean>(SubjectBean.class), new Object[] { subjectName });
		}catch(Exception e) {
			
		}
		return dbSubject;
	}

	public List<SubjectBean> getAllSubjectByStatus() {
		List<SubjectBean> classes = stmt.query("select * from subject where status='Active'", new BeanPropertyRowMapper<SubjectBean>(SubjectBean.class));
		return classes;
	}
	
}
