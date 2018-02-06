package com.skcc.bts.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skcc.bts.dao.BtsDao;
import com.skcc.bts.vo.Bts;
import com.skcc.usercoverbts.dao.UserCoverBtsDao;
import com.skcc.usercoverbts.vo.UserCoverBts;

@Service
public class BtsService {
	private BtsDao btsDao;
	private UserCoverBtsDao userCoverBtsDao;
	
	public BtsService (BtsDao btsDao, UserCoverBtsDao userCoverBtsDao) {
		this.btsDao = btsDao;
		this.userCoverBtsDao = userCoverBtsDao;
	}
	public List<Bts> getAllBts(){
		return btsDao.selectAllBts();
	}
	// select bts by userId
	public List<Bts> getBtsById(String userId) {
		return btsDao.selectBtsListByUserId(userId);
	}

	// ssid로 조회
	public List<Bts> getBtsBySsid(String ssid) {
		return btsDao.selectBtsBySsid(ssid);
	}

	// insert bts
	public int createBts(Bts bts) {
		String day = createDate();
		bts.setEnrollDate(day);
		bts.setModifyDate(day);
		return btsDao.insertBts(bts);
	}
	public int createUserCoverBts(UserCoverBts userCoverBts) {
		return userCoverBtsDao.insertUserCoverBts(userCoverBts);
	}
	// update bts
	public int updateBts(Bts bts) {
		bts.setModifyDate(createDate());
		return btsDao.updateBts(bts);
	}

	private String createDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

}
