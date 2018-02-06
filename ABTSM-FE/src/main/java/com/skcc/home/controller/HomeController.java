package com.skcc.home.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skcc.user.service.UserService;
import com.skcc.user.vo.User;


@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Value("{api.bff.services}")
	private String serviceUrl;
	
	@Autowired
	private UserService userService;
	
	//main (login check)
	@RequestMapping(value= "/index", method=RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("username")!=null ) {
			session.removeAttribute("username");
			session.removeAttribute("userId");
		}
		
		model.addAttribute("apiconnect", serviceUrl);
		
		return "index";
		
	}

//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public Model login(@RequestBody User user, HttpServletRequest request, Model model) {
//		
//		HttpSession session = request.getSession();
//		String userId = user.getUsername();
//		session.setAttribute("userId", userId);
//		
//		logger.info("===== login profile: " );
//
//		return model;
//		
//	}
//	
//	@RequestMapping(value="/home", method=RequestMethod.GET)
//	public String home(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		if(session.getAttribute("userId") == null || "".equals(session.getAttribute("userId"))){
//			return "redirect:/index";
//		}
//		
//		String userId = (String) session.getAttribute("userId");
//		List<User> user = userService.getUser(userId);
//		
//		return "index";
//	}
//	
}
