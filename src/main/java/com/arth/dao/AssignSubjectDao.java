package com.arth.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arth.bean.AssignSubjectBean;
import com.arth.bean.ClassBean;
import com.arth.bean.SubjectBean;


@Repository
public class AssignSubjectDao {
	@Autowired
	JdbcTemplate stmt;
	public void assignSubject(AssignSubjectBean asgb,ClassBean classes,SubjectBean subject) {
		stmt.update("insert into assignsubject (classid,subjectid) values (?,?)",classes.getClassId(),subject.getSubjectId());
	}
	
	

	
	
}
