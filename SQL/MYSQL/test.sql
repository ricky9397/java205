create table project.chatroom(
	messageidx int auto_increment,
    chatidx int,
    chatcontent varchar(2048),
    chatdate timestamp default current_timestamp,
    cridx int,
    memidx int,
    constraint chatroom_messageidx_pk primary key(messageidx)
);

create table project.chatlist(
	chatidx int auto_increment,
    constraint chatlist_chatidx_pk primary key(chatidx)
);