package com.arth.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arth.bean.AssignSubjectBean;



@Repository
public class AssignSubjectDao {
	@Autowired
	JdbcTemplate stmt;
	public void assignSubject(AssignSubjectBean asgb) {
		stmt.update("insert into assignsubject (classname,subjectname) values (?,?)",asgb.getClassName(),asgb.getSubjectName());
	}
	
	public List<AssignSubjectBean> getAllAssign() {
		List<AssignSubjectBean> roles = stmt.query("select * from assignsubject", new BeanPropertyRowMapper<AssignSubjectBean>(AssignSubjectBean.class));
		return roles;
	}

	public void deleteAssignSubject(int assignSubjectId) {
		stmt.update("delete from assignsubject where assignsubjectid = ?", assignSubjectId);
	}
	public AssignSubjectBean getClassByName(String className) {
		AssignSubjectBean dbClass = null;

		try {
			dbClass = stmt.queryForObject("select * from assignsubject where classname = ? ",
					new BeanPropertyRowMapper<AssignSubjectBean>(AssignSubjectBean.class), new Object[] { className });
		}catch(Exception e) {
			
		}
		return dbClass;
	}
	public AssignSubjectBean getSubjectByName(String subjectName) {
		AssignSubjectBean dbSubject = null;

		try {
			dbSubject = stmt.queryForObject("select * from assignsubject where subjectname = ? ",
					new BeanPropertyRowMapper<AssignSubjectBean>(AssignSubjectBean.class), new Object[] { subjectName });
		}catch(Exception e) {
			
		}
		return dbSubject;
	}

	
	
}
