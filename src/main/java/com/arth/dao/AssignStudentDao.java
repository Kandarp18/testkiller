package com.arth.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arth.bean.AssignStudentBean;



@Repository
public class AssignStudentDao {
	@Autowired
	JdbcTemplate stmt;
	public void assignStudent(AssignStudentBean astb) {
		stmt.update("insert into assignstudent (rollno,classid,studentid) values (?,?,?)",astb.getRollNo(),astb.getClassId(),astb.getStudentId());
	}
	
	public List<AssignStudentBean> getAllAssign() {
		List<AssignStudentBean> student = stmt.query("select a.*,c.className,s.studentName from assignstudent a,classes c,student s where a.classid=c.classid and a.studentid=s.studentid", new BeanPropertyRowMapper<AssignStudentBean>(AssignStudentBean.class));
		return student;
	}

	public void deleteAssignStudent(int assignStudentId) {
		stmt.update("delete from assignstudent where assignstudentid = ?", assignStudentId);
	}
	public AssignStudentBean getClassById(int classId) {
		AssignStudentBean dbClass = null;

		try {
			dbClass = stmt.queryForObject("select * from assignstudent where classid = ? ",
					new BeanPropertyRowMapper<AssignStudentBean>(AssignStudentBean.class), new Object[] { classId });
		}catch(Exception e) {
			
		}
		return dbClass;
	}
	public AssignStudentBean getStudentById(int studentId) {
		AssignStudentBean dbStudent = null;

		try {
			dbStudent = stmt.queryForObject("select * from assignstudent where studentid = ? ",
					new BeanPropertyRowMapper<AssignStudentBean>(AssignStudentBean.class), new Object[] { studentId });
		}catch(Exception e) {
			
		}
		return dbStudent;
	}

	public AssignStudentBean getStudentByRollNo(String rollNo) {
		AssignStudentBean dbRollNo = null;

		try {
			dbRollNo = stmt.queryForObject("select * from assignstudent where rollno = ? ",
					new BeanPropertyRowMapper<AssignStudentBean>(AssignStudentBean.class), new Object[] { rollNo });
		}catch(Exception e) {
			
		}
		return dbRollNo;
	}
	public AssignStudentBean getAllStudent(int classId,int studentId,String rollNo) {
		AssignStudentBean dbAssign = null;

		try {
			dbAssign = stmt.queryForObject("select * from assignstudent where classid = ? and studentid = ? and rollno = ? ",
					new BeanPropertyRowMapper<AssignStudentBean>(AssignStudentBean.class), new Object[] { classId,studentId,rollNo });
		}catch(Exception e) {
			
		}
		return dbAssign;
	}
	public void updateAssign(AssignStudentBean asb) {
		stmt.update("update assignstudent set rollno = ?,classid = ?,studentid = ? where assignstudentid = ? ",asb.getRollNo(),asb.getClassId(),asb.getStudentId(),asb.getAssignStudentId());
	}
	public AssignStudentBean getAssignById(int assignStudentId) {

	 AssignStudentBean asb = stmt.queryForObject("select a.*,s.studentName,c.className from assignstudent a,student s,classes c where a.classid=c.classid and s.studentid=a.studentid and assignstudentid = ? ", new BeanPropertyRowMapper<AssignStudentBean>(AssignStudentBean.class), new Object[] { assignStudentId });

		return asb;
	}
	public AssignStudentBean getAssignByStudent(int studentId) {

		 AssignStudentBean asb = stmt.queryForObject("select a.*,s.studentName,c.className from assignstudent a,student s,classes c where a.classid=c.classid and s.studentid=a.studentid and a.studentid = ? ", new BeanPropertyRowMapper<AssignStudentBean>(AssignStudentBean.class), new Object[] { studentId });

			return asb;
		}
}
