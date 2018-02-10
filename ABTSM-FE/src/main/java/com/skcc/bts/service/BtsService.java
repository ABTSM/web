package com.skcc.bts.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.skcc.bts.vo.Bts;

@Service("btsService")
public class BtsService {
	@Autowired
	private RestTemplate restTemplate;

//	@Value("${api.services.url}")
//	private String serviceUrl="http://localhost:8090";
	@Value("${api.services.url}")
	private String serviceUrl;
	public List<Bts> getBtsByUserId(String userId) {
		return Arrays.asList(restTemplate.getForObject(String.format("%s/bts/d1/my/%s", serviceUrl, userId), Bts[].class));
	}
	
	public List<Bts> CheckByBtsId(String btsId){
		return Arrays.asList(restTemplate.getForObject(String.format("%s/bts/d1/%s", serviceUrl, btsId), Bts[].class));
	}

	public int registBts(Bts bts, String userId){
		String url = String.format("%s/bts/d1/enroll/%s", serviceUrl, userId);
		return restTemplate.postForObject(url, bts, Integer.class);		
	}

	public Bts updateBts(Bts bts){
		String url = String.format("%s/bts/d1/%s", serviceUrl,bts.getSsid());
		System.out.println(url);
		System.out.println(bts);
		restTemplate.put(url, bts, Bts.class);	//조율 필요
		return bts;
	}
	public void deleteBts(String id){
		String url = String.format("%s/bts/d1/%s", serviceUrl,id);
		System.out.println(url);
		restTemplate.delete(url);
	}
	
}
