package com.skcc.user.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.skcc.user.vo.User;



@Service("userService")
public class UserService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${api.services.url}")
	private String serviceUrl;
	
	public  List<User> getUser(String userId){
		return Arrays.asList(restTemplate.getForObject(String.format("%s/u1/%s", serviceUrl, userId), User[].class));
	}

	public User getUserByIdPwd(User loginUser) {
		String userId = loginUser.getUserId();
		String pwd = loginUser.getPwd();
		return restTemplate.getForObject(String.format("%s/u1/%s/pw/%s", serviceUrl, userId, pwd ), User.class);
	}
}
