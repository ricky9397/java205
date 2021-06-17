-- PhoneBook DDL : 테이블 정의서 를 참고 해서 DDL 장성한다.
CREATE table phoneInfo_basic (
    idx number(6) constraint pi_basic_idx_PK primary key,
    fr_name VARCHAR2(20) not null,
    fr_phonenumber varchar2(20) not null,
    fr_email varchar2(20) ,
    fr_address varchar2(20),
    fr_regdate date default sysdate
);

-- INSERT : CREATE
DESC phoneinfo_basic;
insert into phoneinfo_basic
values (PI_IDX_PK.nextval, 'KING', '010-0000-0000', 'king@gmail.com', 'KOREA', sysdate)
;
insert into phoneinfo_basic (idx, fr_name, fr_phonenumber)
values (PI_IDX_PK.nextval, 'SCOTT', '010-9999-9999')
;

-- SELECT : READ
select * from phoneinfo_basic;
select * from phoneinfo_basic where idx=2;

-- UPDATE : UPDATE
-- SCOTT의 이메일을 업데이트, 주소도 업데이트
-- SCOTT 의 idx -> 2
 update phoneinfo_basic
 set fr_email='scott@naver.com', fr_address='서울'
 where idx=2 --fr_name='SCOTT'
;

-- DELETE : DELETE
delete from phoneinfo_basic
where idx=1
;


create table phoneinfo_univ (
    idx number(6),
    fr_u_major VARCHAR2(20) default 'N' not null,
    fr_u_year number(1) default 1  not null, --check (fr_u_year between 1 and 4),
    fr_ref number(6) not null,
    constraint pi_univ_idx_PK primary key (idx),
    constraint chk check (fr_u_year between 1 and 4), -- 테이블 레벨에서 check  제약 설정 
    constraint pi_univ_ref_FK FOREIGN KEY (fr_ref) REFERENCES phoneInfo_basic (idx)
);

-- INSERT : CREATE 데이터 생성
-- 대학친구의 정보를 입력
-- 1 basic 정보 입력
insert into phoneinfo_basic
values (PI_IDX_PK.nextval, 'SON', '010-1111-1111', 'son@gmail.com', 'KOREA', sysdate)
;
-- 2. univ 정보 입력
insert into phoneinfo_univ
values (PI_U_IDX_PK.nextval, 'COMPUTER', 4, pi_idx_pk.currval)
;

-- SELECT : READ   데이터 검색
select pb.idx, pu.idx, fr_name, pu.fr_u_major, pu.fr_u_year
from phoneinfo_basic pb , phoneinfo_univ pu
where pb.idx=pu.fr_ref
;

-- UPDATE : UPDATE 데이터 수정
-- 전공과 학년을 수정, idx 또는 외래키
update phoneinfo_univ
set fr_u_major='KOR', fr_u_year=1
where idx=1
;

-- DELETE : DELETE 데이터 삭제
delete from phoneinfo_univ
where idx=1
;
delete from phoneinfo_basic
where idx=3
;



-- phoneinfo_com
create table phoneinfo_com (
    idx number(6) constraint pi_com_idx_PK primary key,
    fr_c_company VARCHAR2(20) default 'N' not null,
    fr_ref number(6) not null constraint pi_com_ref_FK REFERENCES phoneinfo_basic (idx)
);

-- INSERT : CREATE
insert into phoneinfo_basic
values (pi_idx_pk.nextval, 'PARK', '010-7777-7777', 'park@gmail.com', 'LONDON', sysdate)
;
insert into phoneinfo_com values (PI_C_IDX_PK.nextval, 'NAVER', pi_idx_pk.currval);

-- SELECT : READ
select pb.idx, pc.idx, fr_name, pb.fr_phonenumber, pb.fr_email, pb.fr_address, pc.fr_c_company
from phoneinfo_basic pb , phoneinfo_com pc
where pb.idx=pc.fr_ref
;

-- UPDATE : UPDATE
-- 회사정보를 수정
update phoneinfo_com
set fr_c_company='GOOGLE'
where idx=1
;

-- DELETE : DELETE
delete from phoneinfo_com
where idx=1
;
delete from phoneinfo_basic
where idx=4
;

-- 전체 친구 정보
select *
from phoneinfo_basic pb , phoneinfo_univ pu, phoneinfo_com pc
where pb.idx=pu.fr_ref(+) and pb.idx=pc.fr_ref(+)
;

-- 대학친구, 회사 친구 테이블 -> 기본키(대리키) -> sequence 생성 -> insert 개선

-- sequence : 번호 재생기
create sequence pi_idx_pk;
create sequence pi_u_idx_pk start with 5 INCREMENT by 1;
create sequence pi_c_idx_pk start with 5 INCREMENT by 1;