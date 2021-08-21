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

insert into project.chatlist values(1);



select * from chatroom;
select * from chatlist;


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

select c.crnick, c.centername, m.chatcontent
from project.carry c, project.chatroom m, project.chatlist l
where c.cridx=m.cridx and m.chatidx=l.chatidx;	

select c.crnick, c.centername, m.chatcontent
from project.carry c, project.chatroom m
where c.cridx=m.cridx;




