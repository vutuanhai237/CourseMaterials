create 	database jee_chapter3;
use jee_chapter3;

create table USER_ACCOUNT (
	id int primary key auto_increment,
    username varchar(255),
    pass varchar(255),
    firstname varchar(255),
    lastname varchar(255),
    sex varchar(255),
    address text,
    email varchar(255),
    mobile varchar(30),
    groupname varchar(255)
);


insert into USER_ACCOUNT values (null, 'admin', '123', 'ABC', 'EFG', 'aaa', 'aaa', '123@456', '123456789', 'ADMIN');

insert into USER_ACCOUNT values (null, 'user', '123', 'ABC', 'EFG', 'aaa', 'aaa', '123@456', '123456789', 'USER');

update USER_ACCOUNT set username = '789', pass = '101112' where id = 1;

delete from USER_ACCOUNT where id = 1;

select * from USER_ACCOUNT WHERE id = 1;

drop table USER_ACCOUNT;
