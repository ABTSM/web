package com.skcc.bts.RestController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.bts.service.BtsService;
import com.skcc.bts.vo.Bts;
import com.skcc.user.service.UserService;
import com.skcc.usercoverbts.vo.UserCoverBts;

@RestController
public class BtsRestController {
	private static final Logger logger = LoggerFactory.getLogger(BtsRestController.class);

	private UserService userService;
	private BtsService btsService;

	//생성자 
	public BtsRestController(UserService userService, BtsService btsService) {
		this.userService = userService;
		this.btsService = btsService;
	}
	
	@RequestMapping(path = "/bts", method=RequestMethod.GET)
	public List<Bts> getAllBts(){
		return btsService.getAllBts();
	}
	
	// enroll 기지국 신규 등록 
	@RequestMapping(path = "/bts/my/{userId}", method = RequestMethod.POST)
	public int insertBts(@RequestBody Bts bts, @PathVariable(name="userId") String userId) {
		logger.info("====="+userId+"====");
		String btsSsid = bts.getSsid();
		UserCoverBts ucb = new UserCoverBts();
		ucb.setSsid(btsSsid);
		ucb.setUserId(userId);
		btsService.createUserCoverBts(ucb);
		return btsService.createBts(bts);
	}

	// userId에 따른 기지국 조회  
	@RequestMapping(path = "/bts/my/{userId}", method = RequestMethod.GET)
	public List<Bts> getBtsByUserId(@PathVariable(name = "userId") String userId) {
		return btsService.getBtsById(userId);
	}
	// ssid에 따른 기지국 조회 
	@RequestMapping(path = "/bts/{ssid}", method = RequestMethod.GET)
	public List<Bts> getBtsBySsid(@PathVariable(name = "ssid") String ssid) {
		return btsService.getBtsBySsid(ssid);
	}
	// BTS update 
	@RequestMapping(path = "/bts/{ssid}", method = RequestMethod.PUT)
	public int updateContent(@PathVariable(name = "ssid") String ssid, @RequestBody Bts bts) {
		bts.setSsid(ssid);
		return btsService.updateBts(bts);
	}
	
	

}
