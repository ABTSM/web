package com.skcc.bts.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.skcc.bts.vo.Bts;

@Mapper
public interface BtsDao {
	@Select ("select * from bts order by ssid")
	public List<Bts> selectAllBts();
	
	// select List<Bts> by userId Using subquery
	@Select("select * from user_cover_bts A, bts B where A.ssid=B.ssid "
			+ " and  "
			+ " A.userId = #{userId}  ")
	public List<Bts> selectBtsListByUserId(String userId);

	//select by ssid
	@Select ("select * from BTS where ssid=#{ssid}")
	public List<Bts> selectBtsBySsid(String ssid);

	// insert BTS
	@Insert("insert into BTS (ssid, latitude, longitude, altitude, streetAddress, secondaryUnit, enrollDate, modifyDate) "
			+ "VALUES	(#{ssid}, #{latitude}, #{longitude}, #{altitude}, #{streetAddress}, #{secondaryUnit}, #{enrollDate}, #{modifyDate}")
	public int insertBts(Bts bts);

	// update BTS
	@Update("update BTS set latitude = #{latitude},longitude=#{longitude}, streetAddress=#{streetAddress}, "
			+ "secondaryUnit=#{secondaryUnit}, modifyDate=#{modifyDate} where ssid=#{ssid}")
	public int updateBts(Bts bts);

	// delete BTS
	@Delete("delete from BTS where ssid=#{ssid}")
	public int deleteBtsById(String ssid);

}
