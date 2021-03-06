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
	public int registration(HttpServletRequest request){
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		Double latitude = Double.parseDouble(request.getParameter("lat"));
		Double longitude = Double.parseDouble(request.getParameter("lng"));
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("address_detail");
		Bts bts= new Bts();
		bts.setSsid(id);
		bts.setStreetAddress(address);
		bts.setSecondaryUnit(addressDetail);
		bts.setLatitude(latitude);
		bts.setLongitude(longitude);
		return btsService.registBts(bts, (String)session.getAttribute("userId") );
	}

	@RequestMapping(path="/bts/update", method = RequestMethod.POST, name="update")
	public Bts update(HttpServletRequest request){
		String id = request.getParameter("id");
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("address_detail");
		String longitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");
		Bts bts= new Bts();
		bts.setSsid(id);
		bts.setStreetAddress(address);
		bts.setSecondaryUnit(addressDetail);
		bts.setLongitude(Double.parseDouble(longitude));
		bts.setLatitude(Double.parseDouble(latitude));
		return btsService.updateBts(bts);
	}

	@RequestMapping(path="/bts/delete/{btsId}", method = RequestMethod.GET, name="deleteBts")
	public void deleteBts(@PathVariable(name="btsId") String btsId){
		System.out.println(btsId);
		btsService.deleteBts(btsId);
	}
	
}
