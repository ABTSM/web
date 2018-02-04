--user account
DROP TABLE IF EXISTS USER

--No는 순번 
--web상 user id, pw, 사번(SID), 전화번호(TEL), 성함, 관할지역 
CREATE TABLE USER (
	No int(10) not NULL AUTO_INCREMTNT,
	USERID  	VARCHAR (255)		 not null,
	PW 	VARCHAR (255) 			 not null,
	SID int(10)					 not null 	unique,
	TEL VARCHAR (255),
	USERNAME VARCHAR(255) 	 	not null,
	REGION 	VARCHAR(255) 	 
	)

CREATE BTS_INFO (
	SSID 	VARCHAR(255)	 	not null,
	GPS_X	int(10)			not null,
	GPS_Y 	int(10)			not null,
	ADDR1	VARCHAR(255)		not null,
	ADDR2	VARCHAR(255) 	not null,
	enrollDate		VARCHAR(255)	,
	modifyDate		VARCHAR(255)
	)
	
	