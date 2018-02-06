package com.skcc.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skcc.user.dao.UserDao;
import com.skcc.user.vo.User;

@Service
public class UserService {
	//	private 
	private UserDao userDao;
	
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<User> getUser(String userId) {
		
		return userDao.selectUser(userId);
	}
	
	
}
