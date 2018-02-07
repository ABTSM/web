package com.skcc.bts.RestController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.user.service.UserService;
import com.skcc.user.vo.User;

@RestController
public class UserRestController {
	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

	private UserService userService;
	
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(path="/u1/{userId}", method=RequestMethod.GET)
	public List<User> getUser(@PathVariable(name="userId") String userId){
		logger.info("====="+userId+"======");
		return userService.getUser(userId);
		
	}
	
}