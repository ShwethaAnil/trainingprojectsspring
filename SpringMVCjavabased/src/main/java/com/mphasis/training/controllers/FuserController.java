package com.mphasis.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mphasis.training.entities.Fuser;
import com.mphasis.training.services.FuserService;

@Controller
public class FuserController {

	@Autowired
	FuserService fuserService;

	public void setFuserService(FuserService fuserService) {
		this.fuserService = fuserService;
	}
	
	@RequestMapping("/home")
	public String getPage() {
		return "login";
	}
	
	
	@RequestMapping("/login")
	public ModelAndView getLogin(@RequestParam("email")String email,@RequestParam("pwd")String pwd) {
		ModelAndView mv=new ModelAndView();
		Fuser fuser=fuserService.login(email, pwd);
		if(fuser!=null) {
			mv.setViewName("welcome");
		mv.addObject("message", email);	
		}else {
			mv.setViewName("login");
			mv.addObject("message", "invalid credentials");
		}
		return mv;
		
		
	}
}
