package com.skcc.bts.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.bts.service.BtsService;
import com.skcc.bts.vo.Bts;
import com.skcc.user.service.UserService;

@RestController
public class BtsController {
	private static final Logger logger = LoggerFactory.getLogger(BtsController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private BtsService btsService;
	
	@RequestMapping(path="/bts/my", method = RequestMethod.GET, name="getBtsByUserId")
	public List<Bts> getBtsByUserId(HttpSession session ){
		String userId = (String) session.getAttribute("userId");
		List<Bts> list = new ArrayList<>(btsService.getBtsByUserId(userId));

		return list;
	}
}
