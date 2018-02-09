-- user account
DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS BTS;
DROP TABLE IF EXISTS USER_COVER_BTS;

-- NUM는 순번 
-- user id, pwd, 사번(SID), 성함


CREATE TABLE IF NOT EXISTS USER (
	userId  	VARCHAR (255)		 	not null unique,
	pwd 		VARCHAR (255) 			not null,
	username VARCHAR(255) 	 		not null,
	);

CREATE TABLE IF NOT EXISTS BTS (
	ssid 			VARCHAR(255)	 	not null primary key,
	latitude 		double			not null,
	longitude 		double			not null,
	altitude 		int(5)			not null,
	streetaddress	VARCHAR(255)		not null,
	secondaryunit	VARCHAR(255) 	not null,
	enrollDate		VARCHAR(255)	,
	modifyDate		VARCHAR(255)
	);
	
 CREATE TABLE USER_COVER_BTS (
	userId 		VARCHAR(255) 	not null,
	ssid			VARCHAR(255) 	not null unique
	);
	
	
	