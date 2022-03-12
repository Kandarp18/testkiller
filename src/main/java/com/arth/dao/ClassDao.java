package com.arth.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arth.bean.ClassBean;



@Repository
public class ClassDao {

	@Autowired
	JdbcTemplate stmt;
	
	public void insertClass(ClassBean classes) {
		stmt.update("insert into classes (classname) values (?)", classes.getClassName());
	}

	public List<ClassBean> getAllClasses() {
		List<ClassBean> classes = stmt.query("select * from classes", new BeanPropertyRowMapper<ClassBean>(ClassBean.class));
		return classes;
	}
	public void deleteClass(int classId) {
		stmt.update("delete from classes where classid = ?", classId);
	}
	public ClassBean getClassById(int classId) {

		ClassBean classes = stmt.queryForObject("select * from classes where classid = ? ", new BeanPropertyRowMapper<ClassBean>(ClassBean.class), new Object[] { classId });

		return classes;
	}

	public void updateClass(ClassBean c) {
		stmt.update("update classes set classname = ? where classid = ? ",c.getClassName(), c.getClassId());
	}
	public ClassBean getClassByName(String className) {
		ClassBean dbClass = null;

		try {
			dbClass = stmt.queryForObject("select * from classes where classname = ? ",
					new BeanPropertyRowMapper<ClassBean>(ClassBean.class), new Object[] { className });
		}catch(Exception e) {
			
		}
		return dbClass;
	}


}
