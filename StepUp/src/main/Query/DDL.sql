create table board(
	no number generated always as identity primary key,
	writer varchar2(30) not null,
	title varchar2(1000),
	content varchar2(4000),
	create_date date default SYSDATE,
	modify_date date,
	hits number default 0
)
;

select *
from board;