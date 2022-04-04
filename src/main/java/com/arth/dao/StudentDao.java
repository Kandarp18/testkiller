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
	public void addStudent(StudentBean student) {
		stmt.update("insert into student (studentname,email,gender,dateofbirth,password,status) values (?,?,?,?,?,?) ", 
				student.getStudentName(),student.getEmail(),student.getGender(),student.getDateOfBirth(),student.getPassword(),student.getStatus());
	}

	public List<StudentBean> getAllStudent() {
		return stmt.query("select * from student",
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
	public int countStudent(StudentBean student) {
		return stmt.queryForObject("select count(*) from student where status='Active'", Integer.class);
	}
	public void deleteStudent(int studentId) {
		stmt.update("delete from student where studentid = ?", studentId);
	}
	public List<StudentBean> getAllStudentByStatus() {
		List<StudentBean> student = stmt.query("select * from student where status='Active'", new BeanPropertyRowMapper<StudentBean>(StudentBean.class));
		return student;
	}
	public StudentBean getStudentById(int studentId) {

		StudentBean student = stmt.queryForObject("select * from student where studentid = ? ", new BeanPropertyRowMapper<StudentBean>(StudentBean.class), new Object[] { studentId });

		return student;
	}

	public void updateStudent(StudentBean student) {
		stmt.update("update student set studentname = ?,email = ?,gender = ?,dateofbirth = ?,status = ? where studentid = ?",student.getStudentName(),student.getEmail(),student.getGender(),student.getDateOfBirth(),student.getStatus(),student.getStudentId());
	}
	public StudentBean getStudent(String email,int studentId) {
		StudentBean dbStudent = null;

		try {
			dbStudent = stmt.queryForObject("select * from student where email = ? and studentid = ? ",
					new BeanPropertyRowMapper<StudentBean>(StudentBean.class), new Object[] {email,studentId});
		} catch (Exception e) {

		}
		return dbStudent;
	}
}
