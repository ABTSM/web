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

	@Value("${api.services.url}")
	private String serviceUrl;
	
	public List<Bts> getBtsByUserId(String id) {
		return Arrays.asList(restTemplate.getForObject(String.format("%s", serviceUrl, id), Bts[].class));
	}

}
