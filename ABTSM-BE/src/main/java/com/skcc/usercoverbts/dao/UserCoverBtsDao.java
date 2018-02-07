package com.skcc.usercoverbts.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.skcc.usercoverbts.vo.UserCoverBts;

@Mapper
public interface UserCoverBtsDao {
	
	//select
	@Select("select * from USER_COVER_BTS where userId=#{userId}")
	public List<UserCoverBts> selectBtsSsidByUserId(String userId) ;
	
	//insert 
	@Insert("insert into USER_COVER_BTS (userId, ssid) values (#{userId}, #{ssid} )")
	public int insertUserCoverBts(UserCoverBts userCoverBts);
	
}
