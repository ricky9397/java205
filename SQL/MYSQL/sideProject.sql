-- members 테이블
CREATE TABLE  project.members (
                                ID VARCHAR(20),
                                PW VARCHAR(20) NOT NULL,
                                NAME  VARCHAR(20) NOT NULL ,
                                POST int NOT NULL,
                                ADDRESS VARCHAR(100) NOT NULL,
                                ADDRESSS VARCHAR(100) NOT NULL,
                                PHONENUM  VARCHAR(40) NOT NULL,
                                EMAIL VARCHAR(100) NOT NULL,
                                constraint members_id_pk primary key(id)
                              ) ;
-- 상품 테이블          
CREATE TABLE  project.product (
							icode int,
							INAME  VARCHAR(50) NOT NULL ,
							IPRICE  int not null, 
							COUNT int not null,
							IPHOTO VARCHAR(50) DEFAULT 'photo.png',
							CONTENT1 VARCHAR(100) not null,
							CONTENT2 VARCHAR(100) not null,
							CONTENT3 VARCHAR(100) not null,
                            constraint product_icode_pk primary key(icode)
                              ) ;                                        
 -- 주문테이블
 CREATE TABLE project.iorder (           oidx int auto_increment,
                                ICODE int NOT NULL,
                                ID VARCHAR(40) NOT NULL,
                                ONAME  VARCHAR(50) NOT NULL ,
                                OPRICE  int ,
                                OPHOTO VARCHAR(50) DEFAULT 'photo.png',
                                ODATE  timestamp default current_timestamp,
                                count int,
                                constraint iorder_oidx_pk primary key(oidx)
                              ) ;
delete from project.iorder where icode=1 and id='test';
select * from bbs where id='test' order by bbsnum;

                              
-- 게시판 테이블                              
CREATE TABLE project.BBS(
    BBSNUM int,
    BBSTITLE VARCHAR(100) not null,
    ID VARCHAR(20) not null,
    BBSDATE timestamp default current_timestamp,
    BBSHIT int,
    BBSCONTENT VARCHAR(2048) not null,
    PHOTO VARCHAR(50) DEFAULT 'photo.png',
    constraint bbs_bbsnum_pk primary key(bbsnum)
);    
insert into project.bbs (BBSNUM, BBSTITLE, ID, BBSHIT, BBSCONTENT)  values(1, '안녕', 'test',0,'내용입니다');
select * from bbs where bbstitle like '%ㄴ%' order by bbsdate desc;
select * from project.bbs order by bbsdate desc limit 1, 5;

-- 댓글 테이블
CREATE TABLE project.COMMENTS(
    CNUM int auto_increment,
    CBBSNUM int not null,
    COMMENTID VARCHAR(20) not null,
    COMMENTDATE timestamp default current_timestamp,
    COMMENTCONTENT VARCHAR(2048) not null,
    constraint comments_cnum_pk primary key(cnum)
); 
insert into project.comments (CBBSNUM, COMMENTID ,COMMENTCONTENT) values (1, 'test', '안녕하세요');
                            
                              
-- select
select * from project.members;
select * from project.product;
select * from project.iorder;
select * from project.bbs;
select * from project.comments;



-- drop
drop table project.members;                              
drop table project.product;
drop table project.iorder;
drop table project.bbs;
drop table project.comments;


