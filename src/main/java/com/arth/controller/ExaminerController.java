package com.arth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExaminerController {

	@GetMapping("/examinerdashboard")
	public String developerDashboard() {
		return "ExaminerDashboard";
	}
}