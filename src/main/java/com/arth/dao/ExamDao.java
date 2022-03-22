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
		return stmt.query("select e.*,c.className from exam e,classes c where e.classid=c.classid ",
				new BeanPropertyRowMapper<ExamBean>(ExamBean.class));
	}
	public void deleteExam(int examId) {
		stmt.update("delete from exam where examid = ?", examId);
	}
	public ExamBean getExamById(int examId) {

		   ExamBean exam = stmt.queryForObject("select * from exam where examid = ? ", new BeanPropertyRowMapper<ExamBean>(ExamBean.class), new Object[] { examId });

			return exam;
		}
	public int countExam(ExamBean exam) {
		return stmt.queryForObject("select count(*) from exam", Integer.class);
	}

	public int countResult(ExamBean result) {
		return stmt.queryForObject("select count(*) from exam where status='Completed'", Integer.class);
	}
	public List<ExamBean> getAllSubject(int examId) {
		return stmt.query("select e.classid,s.subjectName,s.subjectid from exam e,subject s,classes c where e.classid=c.classid and examid=?",
				new BeanPropertyRowMapper<ExamBean>(ExamBean.class),new Object[] {examId});
	}
	public ExamBean getAllById(int classId,String examName) {
	ExamBean dbExam=null;
		try {
			dbExam=stmt.queryForObject("select * from exam where classid= ? and examname=?", new BeanPropertyRowMapper<ExamBean>(ExamBean.class),new Object[]{classId,examName});
		}catch(Exception e) {
			
		}
		return dbExam;
	}
}
