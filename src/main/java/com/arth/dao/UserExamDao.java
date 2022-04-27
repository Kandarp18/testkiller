package com.arth.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arth.bean.UserExamBean;

@Repository
public class UserExamDao {
	@Autowired
	JdbcTemplate stmt;
	public void insertUserExam(UserExamBean userExam) {
		// TODO Auto-generated method stub
		stmt.update("insert into userexam (examid,studentid,subjectid,obtainmarks) values (?,?,?,?)", 
				 userExam.getExamId(), userExam.getStudentId(),userExam.getSubjectId(),userExam.getObtainMarks());
	
	}
	public void updateMarks(UserExamBean userExam) {
		stmt.update("update userexam set obtainmarks=? where examid=? and subjectid=?",userExam.getObtainMarks(),userExam.getExamId(),userExam.getSubjectId() );
	}
	public List<UserExamBean> viewResult(int examId,int studentId){
		List<UserExamBean> result=stmt.query("select st.profilePic,s.subjectName,u.*,a.totalQuestion,a.rightMark from student st,subject s,userexam u,assignexam a where u.studentid=st.studentid and u.examid=? and u.studentid=? and a.examid=u.examid and s.subjectid=u.subjectid",new BeanPropertyRowMapper<UserExamBean>(UserExamBean.class),new Object[] {examId,studentId});
		return result;
	}
	public UserExamBean sumMarks(int examId,int studentId) {
		UserExamBean sum=stmt.queryForObject("select (obtainmarks) from userexam where examid=? and studentid=?",new BeanPropertyRowMapper<UserExamBean>(UserExamBean.class),new Object[] {examId,studentId});
	return sum;
	}
	public List<UserExamBean> viewSubjectResult(int examId,int studentId,int subjectId){
		List<UserExamBean> result=stmt.query("select q.question,u.userans,q.answer,u.ansstatus,ae.rightMark from question q,userexamans u,exam e,student s,subject st,assignexam ae where u.questionid=q.questionid and u.examid=e.examid and s.studentid=u.studentid and st.subjectid=u.subjectid and e.examid=? and s.studentid=? and st.subjectid=? and e.examid=ae.examid",new BeanPropertyRowMapper<UserExamBean>(UserExamBean.class),new Object[] {examId,studentId,subjectId});
		return result;
	}
	public List<UserExamBean> viewStudentResult(int examId){
		List<UserExamBean> result=stmt.query("select s.profilePic,c.className,s.studentName,a.*,e.totalQuestion,u.*,e.rightMark from classes c,student s,assignstudent a,assignexam e,userexam u where e.examid=? and a.studentid=u.studentid and e.examid=u.examid and e.subjectid=u.subjectid and s.studentid=a.studentid and a.classid=c.classid",new BeanPropertyRowMapper<UserExamBean>(UserExamBean.class),new Object[] {examId});
		return result;
	}
	public List<UserExamBean> countFailResult(int studentId){
		List<UserExamBean> result=stmt.query("select * from userexam where studentid=? and obtainmarks<5",new BeanPropertyRowMapper<UserExamBean>(UserExamBean.class),new Object[] {studentId});
		return result;
	}
	public List<UserExamBean> countPassResult(int studentId){
		List<UserExamBean> result=stmt.query("select * from userexam where studentid=? and obtainmarks>=5",new BeanPropertyRowMapper<UserExamBean>(UserExamBean.class),new Object[] {studentId});
		return result;
	}
}
