CREATE DATABASE myftp;
CREATE TABLE teacherInfo(
       id int AUTO_INCREMENT,
       url varchar(255),
       userName varchar(255),
       passwd varchar(255),
       teacherName varchar(255),
       teacherID varchar(255),
       PRIMARY KEY(id)
)ENGINE=InnoDB default charset=utf8;

insert into teacherinfo values(null,'172.16.3.241','upload_0351','upload_0351','chenyan','0351')