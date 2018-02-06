package com.skcc.bts.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bts {
	private String ssid;					//기지국 식별번호 
	private double latitude;				//위도 
	private double longitutde;			//경도 
	private int altitude;				//고도 
	private String 	streetAddress;		//기본 도로명 주소 
	private String 	secondaryUnit;		//상세 
	private String   enrollDate;			//기지국 등록일
	private String   modifyDate;			//수정일 
	
	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitutde() {
		return longitutde;
	}
	public void setLongitutde(double longitutde) {
		this.longitutde = longitutde;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getSecondaryUnit() {
		return secondaryUnit;
	}
	public void setSecondaryUnit(String secondaryUnit) {
		this.secondaryUnit = secondaryUnit;
	}
	public int getAltitude() {
		return altitude;
	}
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	
}
