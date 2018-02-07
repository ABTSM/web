package com.skcc.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.skcc.user.vo.User;

@Mapper
public interface UserDao {

	@Select("select * from user where userId = #{userId} and pwd=#{pwd}")
	public User selectUser(User user) ;
	
}
