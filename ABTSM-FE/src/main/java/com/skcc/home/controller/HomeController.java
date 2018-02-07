package com.skcc.home.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	
	@Value("{api.bff.services}")
	private String serviceUrl;

	@RequestMapping(value= "/index", method=RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		
		return "index";	
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public Model login(@RequestParam("userId") String userId,@RequestParam("pwd") String pwd, HttpServletRequest request, Model model ) {
		
		HttpSession session = request.getSession();
		System.out.println();
		return model;
		
	}
	@RequestMapping(value= "/home", method=RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		return "home";	
	}
	
//	@RequestMapping(value= "/home", method=RequestMethod.GET)
//	public String home(HttpServletRequest request, Model model) {
//		return "home";	
//	}

	@RequestMapping(value= "/registration", method=RequestMethod.GET)
	public String registration(HttpServletRequest request, Model model) {
		return "registration";	
	}
}
