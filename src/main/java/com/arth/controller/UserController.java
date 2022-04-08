package com.arth.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	 @Autowired
	   Date date;

	@GetMapping("/newuser")
	public String newUser(Model model) {

		List<RoleBean> roles = roleDao.getAllRoles();
		model.addAttribute("roles", roles);
		return "NewUser";
	}
	@GetMapping("/users")
	public String createUser(Model model) {
		List<RoleBean> role = roleDao.getAllRoles();
		model.addAttribute("role", role);
		model.addAttribute("users", userDao.getAllUsers());
		 model.addAttribute("dy",date.toLocaleString());
		return "User";
	}
	@PostMapping("/listuser")
	public String listUser(UserBean user,Model model) {
		boolean p=false;
		UserBean dbUser=userDao.getUserByEmail(user.getEmail());
		if(dbUser!=null) {
		if((user.getEmail()).equalsIgnoreCase(dbUser.getEmail())==true){
			p=true;
		}
		}
		
		if(p==true) {
			model.addAttribute("error","User Data already exists!");
			List<RoleBean> role = roleDao.getAllRoles();
			model.addAttribute("role", role);
			model.addAttribute("users", userDao.getAllUsers());
			 model.addAttribute("dy",date.toLocaleString());
			
		}else {
		String plainPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(plainPassword);
		user.setPassword(encPassword);
		userDao.addUser(user);
		List<RoleBean> role = roleDao.getAllRoles();
		model.addAttribute("role", role);
		model.addAttribute("users", userDao.getAllUsers());
		 model.addAttribute("dy",date.toLocaleString());
		
		}
		return "User";
	}


	@PostMapping("/saveuser")
	public String saveUser(UserBean user,Model model) {
		boolean p=false;
		UserBean dbUser=userDao.getUserByEmail(user.getEmail());
		if(dbUser!=null) {
		if((user.getEmail()).equalsIgnoreCase(dbUser.getEmail())==true){
			p=true;
		}
		}
		
		if(p==true) {
			model.addAttribute("error","Account with this Email Address already exists!");
			return "NewUser";
		}else {
		String plainPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(plainPassword);
		user.setPassword(encPassword);
		userDao.addUser(user);
		return "redirect:/login";
		}
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

		return "redirect:/users";
	}
	@GetMapping("/edituser")
	public String editStudent(@RequestParam("userId") int userId, Model model) {	
		model.addAttribute("user", userDao.getUserById(userId));
		List<RoleBean> role = roleDao.getAllRoles();
		model.addAttribute("role", role);
		return "EditUser";

	}

	@PostMapping("/updateuser")
	public String updateStudent(@RequestParam("userId") int userId,UserBean user,Model model) {
		boolean p=false;
		UserBean dbUser=userDao.getUser(user.getEmail(),user.getUserId());
		if(dbUser!=null) {
		if((user.getEmail()).equalsIgnoreCase(dbUser.getEmail())&&(user.getUserId()!=dbUser.getUserId())){
			p=true;
		}
		}
		
		if(p==true) {
			model.addAttribute("error","User Data already exists!");
			model.addAttribute("user", userDao.getUserById(userId));
			List<RoleBean> role = roleDao.getAllRoles();
			model.addAttribute("role", role);
			model.addAttribute("users", userDao.getAllUsers());
			 model.addAttribute("dy",date.toLocaleString());
			return "EditUser";
		}else {
		userDao.updateUser(user);
		model.addAttribute("success","User Data Modified Successfully!");
		model.addAttribute("user", userDao.getUserById(userId));
		List<RoleBean> role = roleDao.getAllRoles();
		model.addAttribute("role", role);
		model.addAttribute("users", userDao.getAllUsers());
		 model.addAttribute("dy",date.toLocaleString());
		}
		return "User";
	}
	
}
