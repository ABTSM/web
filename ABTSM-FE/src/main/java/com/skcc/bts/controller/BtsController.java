package com.skcc.bts.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(path="/bts/{id}", method = RequestMethod.GET, name="getBtsByUserId")
	public List<Bts> getBtsByUserId(@PathVariable(value="id") String id ){
		
		return btsService.getBtsByUserId(id);
	}
}
