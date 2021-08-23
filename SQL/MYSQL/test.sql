create table project.chatroom(
	messageidx int auto_increment,
    chatidx int,
    chatcontent varchar(2048),
    chatdate timestamp default current_timestamp,
    cridx int,
    memidx int,
    constraint chatroom_messageidx_pk primary key(messageidx),
    FOREIGN KEY (`CRIDX`) REFERENCES `CARRY` (`CRIDX`)
);

insert into project.chatroom
(chatidx, chatcontent, cridx, memidx)
 values(1, '안녕하세요 황철순캐리입니다..', 5, 1);



create table project.chatlist(
	chatidx int auto_increment,
    constraint chatlist_chatidx_pk primary key(chatidx)
);

insert into project.chatlist values(2);

select * from chatroom;
select * from chatlist;

delete from project.chatroom where messageidx=3;

create table project.chat(
    chatidx int,
    chatcontent varchar(2048)
);
insert into project.chat values (1, 'aaa');
select * from chat;

create table project.carry(
	cridx int auto_increment,
    crnick varchar(20),
    centername varchar(2048),
    constraint carry_cridx_pk primary key(cridx)
);

select * from carry;
insert into project.carry (crnick,centername) values('김종국', '라이프트휘트니스짐');
delete from project.carry where cridx=3;

select c.crnick, c.centername, m.chatcontent, m.chatdate
from project.carry c, project.chatroom m, project.chatlist l
where c.cridx=m.cridx and m.chatidx=l.chatidx;	

select *
from project.carry c, project.chatroom m, project.chatlist l
where c.cridx=m.cridx and m.chatidx=l.chatidx ;

select * from chatlist where memidx=1;

select *
from project.chatroom m, project.chatlist l
where m.chatidx=l.chatidx;

select m.chatcontent, m.chatdate
from project.chatroom m, project.chatlist l
where l.chatidx=1 and m.chatidx=l.chatidx;

select * from chatroom where chatidx=2;


select chatidx from chatlist;


create table project.center(
	centeridx int auto_increment,
    centername varchar(20),
    centeraddress varchar(100),
    constraint center_centeridx_pk primary key(centeridx)    
);
select * from project.center;
insert into project.center (centername, centeraddress) values ('짐캐리휘트니스','서울서대문구마포구');





CREATE TABLE `MEMBER` (
  `MEMIDX` int NOT NULL AUTO_INCREMENT COMMENT '회원번호',
  `MEMEMAIL` varchar(40) NOT NULL COMMENT '이메일',
  `MEMPW` varchar(30) NOT NULL COMMENT '비밀번호',
  `MEMNAME` varchar(50) NOT NULL COMMENT '이름',
  `MEMNICK` varchar(50) NOT NULL COMMENT '닉네임',
  PRIMARY KEY (`MEMIDX`)
);
insert into member(mememail, mempw, memname, memnick) values();
select * from member;


CREATE TABLE `CARRY` (
  `CRIDX` int NOT NULL AUTO_INCREMENT COMMENT '캐리IDX',
  `CRID` int NOT NULL COMMENT '캐리아이디',
  `CRPW` varchar(30) NOT NULL COMMENT '비밀번호',
  `CRNAME` varchar(50) NOT NULL COMMENT '캐리실명',
  `CRNICK` varchar(50) NOT NULL COMMENT '캐리닉네임',
  `PLACENAME` varchar(255) DEFAULT NULL COMMENT '소속플레이스',
  PRIMARY KEY (`CRIDX`)
)

insert into carry(crid, crpw, crname, crnick, placename) values();
