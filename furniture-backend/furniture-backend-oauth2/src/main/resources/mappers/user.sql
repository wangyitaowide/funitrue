create table user(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	name varchar(200),
	password varchar(200),
	role varchar(200)
)engine=INNODB;