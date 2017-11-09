SET SESSION FOREIGN_KEY_CHECKS=0;

create database multibrunch_db;

insert into menu values(1,"Burger",5000,"","",1,"kor");
insert into menu values(2,"Pizza",15000,"","",1,"ch");
insert into menu values(3,"HotPizza",17000,"","",1,"jp");
insert into menu values(4,"Burger",17000,"","",2,"kor");
insert into menu values(5,"HotPizza",17000,"","",2,"jp");
insert into menu values(6,"Burger",17000,"","",3,"ch");
insert into menu values(7,"HotPizza",17000,"","",3,"wf");

insert into restaurant values(1,"test1","seoul",100,"3:00~4:00","02-7892-1234",3,"kor");
insert into restaurant values(2,"test2","seoul",100,"3:00~4:00","02-7892-1234",3,"jp");
insert into restaurant values(3,"test3","seoul",300,"3:00~4:00","02-7892-1234",3,"ch");
insert into restaurant values(4,"test4","seoul",300,"3:00~4:00","02-7892-1234",3,"wf");

insert into user values(1,"minu","minu8163@gmail.com","1234","m",35,"kor");
insert into user values(2,"jian","jian8163@gmail.com","2341","m",3,"ch");
insert into user values(3,"mj","fate831@gmail.com","3412","f",35,"jp");
insert into user values(4,"dohyung","chocomilk@gmail.com","4123","m",26,"wf");


/* Drop Tables */

DROP TABLE IF EXISTS Comment;
DROP TABLE IF EXISTS Menu;
DROP TABLE IF EXISTS Restaurant;
DROP TABLE IF EXISTS User;




/* Create Tables */

CREATE TABLE Comment
(
	cId int NOT NULL AUTO_INCREMENT,
	cContents varchar(300) NOT NULL,
	cRate int(10) NOT NULL,
	uId int DEFAULT 1 NOT NULL,
	rId int NOT NULL,
	PRIMARY KEY (cId),
	UNIQUE (cId)
);


CREATE TABLE Menu
(
	mId int NOT NULL AUTO_INCREMENT,
	mName varchar(20) NOT NULL,
	mPrice int(10) NOT NULL,
	mPicture1 varchar(300),
	mPicture2 varchar(300),
	rId int NOT NULL,
	PRIMARY KEY (mId),
	UNIQUE (mId)
);


CREATE TABLE Restaurant
(
	rId int NOT NULL AUTO_INCREMENT,
	rName varchar(20),
	rAddress varchar(100) NOT NULL,
	rDistance int(20) NOT NULL,
	rOpenHours varchar(40),
	rTel varchar(20),
	rRate int(10) NOT NULL,
	rCategory varchar(10) NOT NULL,
	PRIMARY KEY (rId),
	UNIQUE (rId)
);


CREATE TABLE User
(
	uId int NOT NULL AUTO_INCREMENT,
	uName varchar(20) NOT NULL,
	uEmail varchar(50) NOT NULL,
	uPassword varchar(15) NOT NULL,
	uGender char(3) NOT NULL,
	uAge int(4) NOT NULL,
	uPreference varchar(8) NOT NULL,
	PRIMARY KEY (uId),
	UNIQUE (uId),
	UNIQUE (uEmail)
);



/* Create Foreign Keys */

ALTER TABLE Comment
	ADD FOREIGN KEY (rId)
	REFERENCES Restaurant (rId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Menu
	ADD FOREIGN KEY (rId)
	REFERENCES Restaurant (rId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Comment
	ADD FOREIGN KEY (uId)
	REFERENCES User (uId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



