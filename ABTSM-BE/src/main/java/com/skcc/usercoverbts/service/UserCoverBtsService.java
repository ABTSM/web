package com.skcc.usercoverbts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skcc.usercoverbts.dao.UserCoverBtsDao;
import com.skcc.usercoverbts.vo.UserCoverBts;

@Service
public class UserCoverBtsService {
	private UserCoverBtsDao userCoverBtsDao;
	
	public UserCoverBtsService(UserCoverBtsDao userCoverBtsDao) {
		this.userCoverBtsDao = userCoverBtsDao;
	}

	public List<UserCoverBts> getBtsByUserId(String userId) {
		return userCoverBtsDao.selectBtsSsidByUserId(userId);
	}
}
