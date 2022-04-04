package com.arth.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arth.bean.AssignExamBean;

@Repository
public class AssignExamDao {
	@Autowired
	JdbcTemplate stmt;
	public void assignExam(AssignExamBean aeb) {
		stmt.update("insert into assignexam (examid,subjectid,totalquestion,examdate,rightmark) values (?,?,?,?,?)",aeb.getExamId(),aeb.getSubjectId(),aeb.getTotalQuestion(),aeb.getExamDate(),aeb.getRightMark());
	}
	public List<AssignExamBean> getAllAssign() {
		List<AssignExamBean> exam = stmt.query("select a.*,s.subjectName,e.examName from assignexam a,subject s,exam e where a.subjectid=s.subjectid and a.examid=e.examid ", new BeanPropertyRowMapper<AssignExamBean>(AssignExamBean.class));
		return exam;
	}
	public AssignExamBean getAllById(int subjectId,int examId) {
		AssignExamBean dbExam=null;
			try {
				dbExam=stmt.queryForObject("select * from assignexam where subjectid= ? and examid=?", new BeanPropertyRowMapper<AssignExamBean>(AssignExamBean.class),new Object[]{subjectId,examId});
			}catch(Exception e) {
				
			}
			return dbExam;
		}
	public void deleteAssignExam(int assignExamId) {
		stmt.update("delete from assignexam where assignexamid = ?", assignExamId);
	}
	public List<AssignExamBean> getAllAssignSubject(int examId) {
		List<AssignExamBean> subject = stmt.query("select a.*,s.subjectname from assignexam a ,subject s where a.subjectid=s.subjectid and s.subjectid in (select subjectid from assignexam where examid=?)", new BeanPropertyRowMapper<AssignExamBean>(AssignExamBean.class),new Object[] {examId});
		return subject;
	}
	public AssignExamBean getExamById(int assignExamId) {

		AssignExamBean exam = stmt.queryForObject("select a.*,e.examName,s.subjectName from assignexam a,exam e,subject s where s.subjectid=a.subjectid and e.examid=a.examid and assignexamid = ? ", new BeanPropertyRowMapper<AssignExamBean>(AssignExamBean.class), new Object[] { assignExamId });

		return exam;
	}

	public void updateExam(AssignExamBean exam) {
		stmt.update("update assignexam set totalquestion=?,examdate=?,rightmark=? where assignexamid=? ",exam.getTotalQuestion(),exam.getExamDate(),exam.getRightMark(),exam.getAssignExamId());
	}
	public List<AssignExamBean> getAllExamByStudent() {
		return stmt.query("select a.*,e.examName,s.subjectName,st.statusName from assignexam a ,exam e,subject s,status st where e.examid=a.examid and a.subjectid=s.subjectid and e.statusid=st.statusid and st.statusid=2",
				new BeanPropertyRowMapper<AssignExamBean>(AssignExamBean.class));
	}
}
