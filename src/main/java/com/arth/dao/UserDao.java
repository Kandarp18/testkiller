package com.arth.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arth.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public void addUser(UserBean user) {
		stmt.update("insert into users (username,email,password,gender,contactno,status,roleid) values (?,?,?,?,?,?,?) ", user.getUserName(),
				user.getEmail(), user.getPassword(),user.getGender(),user.getContactNo(),user.getStatus(), user.getRoleId());
	}

	public List<UserBean> getAllUsers() {
		return stmt.query("select u.*,r.roleName from users u,role r where u.roleid = r.roleid ",
				new BeanPropertyRowMapper<UserBean>(UserBean.class));
	}

	public void deleteUser(int userId) {
		stmt.update("delete from users where userid = ?", userId);
	}

	public UserBean getUserByEmail(String email) {
		UserBean dbUser = null;

		try {
			dbUser = stmt.queryForObject("select * from users where email = ? ",
					new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[] { email });
		} catch (Exception e) {

		}
		return dbUser;
	}

	public void updatePassword(UserBean user) {
		stmt.update("update users set password = ? where email = ?", user.getPassword(), user.getEmail());
	}
	public UserBean getUserById(int userId) {

		UserBean user = stmt.queryForObject("select u.*,r.roleName from users u,role r where u.roleid = r.roleid and userid = ? ", new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[] { userId });

		return user;
	}

	public void updateUser(UserBean user) {
		stmt.update("update users set username = ?,email = ?,gender = ?,contactno = ?,roleid=?,status=? where userid = ? ",user.getUserName(),user.getEmail(),user.getGender(),user.getContactNo(),user.getStatus(),user.getRoleId(),user.getUserId());
	}
}
