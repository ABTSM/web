package com.skcc.bts.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.bts.service.BtsService;
import com.skcc.bts.vo.Bts;

@RestController
public class BtsController {
	
	@Autowired
	private BtsService btsService;
	
	@RequestMapping(path="/bts/my", method = RequestMethod.GET, name="getBtsByUserId")
	public List<Bts> getBtsByUserId(HttpSession session ){
		String userId = (String) session.getAttribute("userId");
		List<Bts> list = new ArrayList<>(btsService.getBtsByUserId(userId));

		return list;
	}

	@RequestMapping(path="/bts/chkBtsId/{btsId}", method = RequestMethod.GET, name="checkBtsId")
	public List<Bts> checkBtsId(@PathVariable(name="btsId") String btsId){
		return btsService.CheckByBtsId(btsId);
	}
	

	@RequestMapping(path="/bts/registration", method = RequestMethod.POST, name="registration")
	public Bts registration(HttpServletRequest request){
		String id = request.getParameter("");
		return new Bts();
	}
}
