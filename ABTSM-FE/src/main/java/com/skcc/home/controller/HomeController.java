package com.skcc.home.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skcc.user.service.UserService;
import com.skcc.user.vo.User;


@Controller
public class HomeController {
	
//	@Value("{api.bff.services}")
	@Value("{rest.addreess}")
	private String serviceUrl;
	@Autowired
	private UserService userService;
	
	public HomeController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(HttpServletRequest request, HttpSession session, HttpServletResponse response, Model model) {
		if(session.getAttribute("userId")==null) {
			return "login";
		}else {
			return "home";	
		}
	}


	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("userId") String userId,@RequestParam("pwd") String pwd, HttpServletRequest request ) {
		HttpSession session = request.getSession();
		
		System.out.println("-----user info----"+userId+" / "+pwd);
		User loginUser = new User();
		loginUser.setUserId(userId);
		loginUser.setPwd(pwd);
		User confirmUser = userService.getUserByIdPwd(loginUser);
		if(confirmUser ==null) {
			return "redirect:/home";
		}else {
			System.out.println("confirmUser :"+confirmUser.getUserId());
//			request.setAttribute("userId", confirmUser.getUserId());
			session.setAttribute("userId", confirmUser.getUserId());
		}
		return "redirect:/home";
	}
	
	@RequestMapping(value= "/home", method=RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		return "home";	
	}

	@RequestMapping(value= "/registration", method=RequestMethod.GET)
	public String registration(HttpServletRequest request, Model model) {
		return "registration";	
	}
	@RequestMapping(value= "/chatbot", method=RequestMethod.GET)
	public String chatbot(HttpServletRequest request, Model model) {
		return "chatbot";	
	}
	@RequestMapping(value= "/about", method=RequestMethod.GET)
	public String about(HttpServletRequest request, Model model) {
		return "about";	
	}
}
