package com.skcc.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	@Value("{api.bff.services}")
	private String serviceUrl;

	@RequestMapping(value= "/index", method=RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		return "index";	
	}

	@RequestMapping(value= "/home", method=RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		return "home";	
	}
	
	@RequestMapping(value= "/registration", method=RequestMethod.GET)
	public String registration(HttpServletRequest request, Model model) {
		return "registration";	
	}
}
