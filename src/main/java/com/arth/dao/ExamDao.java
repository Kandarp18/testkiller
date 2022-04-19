package com.arth.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arth.bean.ExamBean;
import com.arth.bean.UserExamAnsBean;


@Repository
public class ExamDao {
	@Autowired
	JdbcTemplate stmt;

	public void addExam(ExamBean exam) {
		stmt.update("insert into exam (examname,duration,classid,statusid) values (?,?,?,?) ", exam.getExamName(),exam.getDuration(),exam.getClassId(),exam.getStatusId());
	}

	public List<ExamBean> getAllExam() {
		return stmt.query("select e.*,c.className,s.statusName from exam e,classes c,status s where e.classid=c.classid and e.statusid=s.statusid",
				new BeanPropertyRowMapper<ExamBean>(ExamBean.class));
	}
	public void deleteExam(int examId) {
		stmt.update("delete from exam where examid = ?", examId);
	}
	public ExamBean getExamById(int examId) {

		   ExamBean exam = stmt.queryForObject("select e.*,c.className,s.statusName from exam e,classes c,status s where e.classid=c.classid and s.statusid=e.statusid and examid = ? ", new BeanPropertyRowMapper<ExamBean>(ExamBean.class), new Object[] { examId });

			return exam;
		}
	public int countExam(ExamBean exam) {
		return stmt.queryForObject("select count(*) from exam", Integer.class);
	}
	public int count(int classId) {
		return stmt.queryForObject("select count(*) from exam where statusid=2",Integer.class );
	}

	public int countResult(ExamBean result) {
		return stmt.queryForObject("select count(*) from exam where statusid=3", Integer.class);
	}
	public List<ExamBean> getAllSubject(int examId) {
		return stmt.query("select e.*,s.subjectName,s.subjectid from exam e,subject s,classes c where e.classid=c.classid and examid=?",
				new BeanPropertyRowMapper<ExamBean>(ExamBean.class),new Object[] {examId});
	}
	public ExamBean getAll(int classId,String examName) {
	ExamBean dbExam=null;
		try {
			dbExam=stmt.queryForObject("select * from exam where duration=? and resultdate=? and statusid = ? and classid= ? and examname=?", new BeanPropertyRowMapper<ExamBean>(ExamBean.class),new Object[]{classId,examName});
		}catch(Exception e) {
			
		}
		return dbExam;
	}
	
	public void updateExam(ExamBean e) {
		stmt.update("update exam set examname=?,duration=?,statusid=?,classid=? where examid=?",e.getExamName(),e.getDuration(),e.getStatusId(),e.getClassId(),e.getExamId());
	}
	public ExamBean getAllById(int classId,String examName) {
		ExamBean dbExam=null;
			try {
				dbExam=stmt.queryForObject("select * from exam where classid= ? and lower(examname) = lower(?)", new BeanPropertyRowMapper<ExamBean>(ExamBean.class),new Object[]{classId,examName});
			}catch(Exception e) {
				
			}
			return dbExam;
		}
	public List<ExamBean> getAllExamByStatus() {
		return stmt.query("select e.*,c.className,s.statusName from exam e,classes c,status s where e.classid=c.classid and e.statusid=s.statusid and s.statusid=1",
				new BeanPropertyRowMapper<ExamBean>(ExamBean.class));
	}
	public List<ExamBean> getAllExamByStudent(int studentId) {
		return stmt.query("select e.*,s.statusName from exam e,classes c,student st,status s,assignstudent a where e.classid=c.classid and a.studentid=st.studentid and e.statusid=s.statusid and s.statusid=2 and a.classid=c.classid and st.studentid=?",
				new BeanPropertyRowMapper<ExamBean>(ExamBean.class),new Object[] {studentId});
	}
	public ExamBean getExam(int examId) {

		   ExamBean exam = stmt.queryForObject("select * from exam where examid = ? ", new BeanPropertyRowMapper<ExamBean>(ExamBean.class), new Object[] { examId });

			return exam;
		}
	public void updateStatus(int examId,int subjectId) {
		stmt.update("update exam set statusid=3 where examid=? and classid in (select classid from assignsubject where subjectid=?)",examId,subjectId);
	}
	public List<ExamBean> getAllExamByStudentId(int studentId) {
		return stmt.query("select e.*,s.statusName from exam e,classes c,student st,status s,assignstudent a where e.classid=c.classid and a.studentid=st.studentid and e.statusid=s.statusid and s.statusid=3 and a.classid=c.classid and st.studentid=?",
				new BeanPropertyRowMapper<ExamBean>(ExamBean.class),new Object[] {studentId});
	}
	public List<UserExamAnsBean> getUserExamAnsByQuestionId(int examId) {
		// TODO Auto-generated method stub
		List<UserExamAnsBean> userexamans = stmt.query("select * from userexamans where examid = ?", 
				new BeanPropertyRowMapper<UserExamAnsBean>(UserExamAnsBean.class), new Object[] { examId });
		return userexamans;
	}
	public List<UserExamAnsBean> getUserExamById(int subjectId) {
		// TODO Auto-generated method stub
		List<UserExamAnsBean> userexamans = stmt.query("select * from userexamans where  subjectid=?", 
				new BeanPropertyRowMapper<UserExamAnsBean>(UserExamAnsBean.class), new Object[] { subjectId });
		return userexamans;
	}
	public ExamBean countAppearedExam(int studentId) {
		ExamBean e= stmt.queryForObject("select count(*) from exam where statusid=3 and classid in (select classid from assignstudent where studentid=?)",new BeanPropertyRowMapper<ExamBean>(ExamBean.class),new Object[] {studentId});
		return e;
	}
	public ExamBean getClassNameByExamId(int examId) {

		   ExamBean exam = stmt.queryForObject("select e.*,c.className from exam e,classes c where e.examid = ? and e.classid=c.classid", new BeanPropertyRowMapper<ExamBean>(ExamBean.class), new Object[] { examId });

			return exam;
		}
}
