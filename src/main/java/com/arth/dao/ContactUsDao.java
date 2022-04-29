package com.arth.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.arth.bean.ContactUsBean;

@Repository
public class ContactUsDao {
	@Autowired
	JdbcTemplate stmt;
public void insertQuery(ContactUsBean cub) {
	stmt.update("insert into contactus (studentid,email,subject,message,name) values (?,?,?,?,?)",cub.getStudentId(),cub.getEmail(),cub.getSubject(),cub.getMessage(),cub.getName());
}
public List<ContactUsBean> getAllQuery() {
	List<ContactUsBean> query = stmt.query("select c.*,s.profilePic from contactus c,student s where s.studentid=c.studentid",
			new BeanPropertyRowMapper<ContactUsBean>(ContactUsBean.class));
	return query;
}

}
