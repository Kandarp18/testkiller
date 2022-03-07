package com.arth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.arth.bean.RoleBean;
import com.arth.bean.UserBean;
import com.arth.dao.RoleDao;
import com.arth.dao.UserDao;

@Controller
public class UserController {

	@Autowired
	RoleDao roleDao;
	@Autowired
	UserDao userDao;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/newuser")
	public String newUser(Model model) {

		List<RoleBean> roles = roleDao.getAllRoles();
		model.addAttribute("roles", roles);
		return "NewUser";
	}

	@PostMapping("/saveuser")
	public String saveUser(UserBean user) {
		String plainPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(plainPassword);// 10
		user.setPassword(encPassword);
		userDao.addUser(user);
		return "redirect:/getallusers";
	}

	@GetMapping("/getallusers")
	public String getAllUsers(Model model) {
		List<UserBean> users = userDao.getAllUsers();
		model.addAttribute("users", users);
		return "ListUsers";
	}

	@GetMapping("/deleteuser/{userId}")
	public String deleteUser(@PathVariable("userId") int userId) {

		userDao.deleteUser(userId);

		return "redirect:/getallusers";
	}

}
