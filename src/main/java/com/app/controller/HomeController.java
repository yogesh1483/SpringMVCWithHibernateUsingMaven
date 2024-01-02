package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Student;
import com.app.servicei.HomeService;

@Controller
public class HomeController {

	@Autowired
	HomeService hs;

	@RequestMapping("/")
	public String preogin() {
		return "login";
	}

	@RequestMapping("/registration")
	public String preReg() {
		return "registration";
	}

	@RequestMapping("/reg")
	public String regData(@ModelAttribute Student s) {
		System.out.println(s.getUid());
		hs.saveData(s);

		return "login";
	}

	@RequestMapping("/login")
	public String loginCheck(@RequestParam("uname") String un, @RequestParam("upass") String ps, Model m) {

		int i = hs.loginCheck(un, ps);

		List st1 = hs.displayAllData();
		m.addAttribute("data", st1);
		return "success";
	}
	
	@RequestMapping("/edit")
	public String editData(@ModelAttribute Student s, Model m) {
		
		Student stu = hs.editData(s);
		m.addAttribute("data", stu);
		return "edit";
	}
	
	@RequestMapping("/update")
	public String updateData(@ModelAttribute Student s, Model m) {
		hs.updateData(s);
		List st1 = hs.displayAllData();
		m.addAttribute("data", st1);
		return "success";
	}
	
	@RequestMapping("/delete")
	public String deleteData(@RequestParam("uid") int uid, Model m) {
		hs.deleteData(uid);
		List st1 = hs.displayAllData();
		m.addAttribute("data", st1);
		return "success";
	}

}
