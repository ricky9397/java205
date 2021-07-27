create table project.guestbook_message(
	messageid int not null auto_increment primary key,
    guestname varchar(20) not null,
    password varchar(20) not null,
    message text not null,
    regdate timestamp default current_timestamp
);

-- select
select * from guestbook_message order by regdate desc;

-- limit index, count(페이징처리)
select * from guestbook_message limit 0, 3;  
-- 전체 게시물의 개수
select count(*) from project.guestbook_message;

-- insert
insert into project.guestbook_message (guestname, password, message) values ('king', '1111', 'Hello');

-- update
update project.guestbook_message 
set guestname='scott', password='0000', message='안녕하세요' 
where messageid=1;

-- delete
delete from project.guestbook_message where messageid=1;

-- drop
drop table guestbook_message;