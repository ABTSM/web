package com.skcc.bts.RestController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@RequestMapping(path = "/bts/d1", method=RequestMethod.GET)
	public List<Bts> getAllBts(){
		return btsService.getAllBts();
	}
	
	// enroll 기지국 신규 등록 
	@PostMapping(path = "/bts/d1/enroll/{id}")
	public int insertBts( @PathVariable(name="id") String userId, @RequestBody Bts bts ) {
		String btsSsid = bts.getSsid();
		UserCoverBts ucb = new UserCoverBts();
		ucb.setSsid(btsSsid);
		ucb.setUserId(userId);
		if(btsService.createBts(bts)<1) {
			return 0;
		}
		if(btsService.createUserCoverBts(ucb)<1) {
			return 0;
		}
		return 1;
	}

	// userId에 따른 기지국 조회  
	@RequestMapping(path = "/bts/d1/my/{userId}", method = RequestMethod.GET)
	public List<Bts> getBtsByUserId(@PathVariable(name = "userId") String userId) {
		return btsService.getBtsById(userId);
	}
	// ssid에 따른 기지국 조회 
	@RequestMapping(path = "/bts/d1/{ssid}", method = RequestMethod.GET)
	public List<Bts> getBtsBySsid(@PathVariable(name = "ssid") String ssid) {
		return btsService.getBtsBySsid(ssid);
	}
	// BTS update 
	@RequestMapping(path = "/bts/d1/{ssid}", method = RequestMethod.PUT)
	public int updateContent(@PathVariable(name = "ssid") String ssid, @RequestBody Bts bts) {
		bts.setSsid(ssid);
		return btsService.updateBts(bts);
	}
	// ssid에 따른 기지국 삭제
	@RequestMapping(path = "/bts/d1/{ssid}", method = RequestMethod.DELETE)
	public int deleteBtsBySsid(@PathVariable(name = "ssid") String ssid) {
		return btsService.deleteBts(ssid);
	}
	

}
