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
 values(2, '반갑습니다.', 6, 2);



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

select m.chatcontent, m.chatdate
from project.chatroom m, project.chatlist l
where l.chatidx=1 and m.chatidx=l.chatidx;

select chatidx from chatlist;


create table project.center(
	centeridx int auto_increment,
    centername varchar(20),
    centeraddress varchar(100),
    constraint center_centeridx_pk primary key(centeridx)    
);
select * from project.center;
insert into project.center (centername, centeraddress) values ('짐캐리휘트니스','서울서대문구마포구');

-- select c.rnick, c.centername, t.centeraddress
-- from project.carry c, project.center t
-- where c.
