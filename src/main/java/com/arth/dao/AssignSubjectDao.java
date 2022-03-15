package com.arth.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arth.bean.AssignSubjectBean;



@Repository
public class AssignSubjectDao {
	@Autowired
	JdbcTemplate stmt;
	public void assignSubject(AssignSubjectBean asgb) {
		stmt.update("insert into assignsubject (classid,subjectid) values (?,?)",asgb.getClassId(),asgb.getSubjectId());
	}
	
	

	
	
}
