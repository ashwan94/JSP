create table member (
		id varchar(30) not null,
		name varchar(30) not null,
		password varchar(256) not null,
		email varchar(50) not null,
		create_date date default sysdate,
		modify_date date
);

alter table member add constraint pk_member primary key (id);

select *
from member;

select *
from board;