package com.arth.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arth.bean.StudentBean;



@Repository
public class StudentDao {
	@Autowired
	JdbcTemplate stmt;
	public void addUser(StudentBean student) {
		stmt.update("insert into student (studentname,email,gender,dateofbirth,password) values (?,?,?,?,?) ", 
				student.getStudentName(),student.getEmail(),student.getGender(),student.getDateOfBirth(),student.getPassword());
	}

	public List<StudentBean> getAllStudent() {
		return stmt.query("select *  from student",
				new BeanPropertyRowMapper<StudentBean>(StudentBean.class));
	}
	public StudentBean getStudentByEmail(String email) {
		StudentBean dbStudent = null;

		try {
			dbStudent = stmt.queryForObject("select * from student where email = ? ",
					new BeanPropertyRowMapper<StudentBean>(StudentBean.class), new Object[] { email });
		} catch (Exception e) {

		}
		return dbStudent;
	}

	public void updatePassword(StudentBean student) {
		stmt.update("update student set password = ? where email = ?", student.getPassword(), student.getEmail());
	}
}
