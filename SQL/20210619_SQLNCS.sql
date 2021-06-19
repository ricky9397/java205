-- 2021.06.19

-- SQL활용
--1. 아래 조건에 맞는 DDL을 작성하시오.
--===== 전화번호 부( 테이블 이름 : Contact )
------ 기본정보(not null)
-- 대리키 : 일련번호 -> pIdx 기본키로 설정
-- 이름, 전화번호, 주소, 이메일
-- 주소값과 이메일은 입력이 없을 때 기본값 입력
-- 친구의 타입 (카테고리) : univ, com, cafe 세가지 값만 저장 가능
------ 선택 정보
-- 전공, 학년
-- 회사이름, 부서이름, 직급
-- 모임이름, 닉네임
=============================
CREATE TABLE CONTACT(
    PIDX NUMBER(6) CONSTRAINT CONTACT_PIDX_PX PRIMARY KEY,
    NAME VARCHAR2(20) CONSTRAINT CONTACT_NAME_NN NOT NULL,
    PHONE VARCHAR2(20) CONSTRAINT CONTACT_PHONE_NN NOT NULL,
    ADDRESS VARCHAR2(20) DEFAULT 'N' CONSTRAINT CONTACT_ADDRESS_NN NOT NULL,
    EMAIL VARCHAR2(20) DEFAULT 'N' CONSTRAINT CONTACT_EMAIL_NN NOT NULL,
    TYPE VARCHAR2(4) CONSTRAINT CONTACT_TYPE_CK CHECK(TYPE IN('UNIV', 'COM', 'CAFE')) NOT NULL,

    MAJOR VARCHAR2(20),
    GRADE NUMBER(1),
    COMPANYNAME VARCHAR2(20),
    DEPTNAME VARCHAR2(20),
    POSITION VARCHAR2(20),
    GROUPNAME VARCHAR2(20),
    NICKNAME VARCHAR2(20)
);

SELECT * FROM DEPT;
--2. DEPT 테이블에 데이터를 삽입하는 SQL을 작성하시오. 입력 데이터는 임의로 작성하시오.

INSERT INTO DEPT(DEPTNO, DNAME, LOC) VALUES(50, 'DESIGN', 'LA');
--3. DEPT 테이블에 위에서 삽입한 데이터의 dname, loc 데이터를 변경하는 SQL을 작성하시오.
--   입력 데이터는 임의로 작성하시오.

UPDATE DEPT SET DNAME='DEVELOPER', LOC='HAWAII' WHERE DEPTNO=50;
--4. DEPT 테이블에 위에서 삽입한 데이터를 deptno 컬럼의 값을 기반으로 삭제하는 SQL을 작성하시오.

DELETE FROM DEPT WHERE DEPTNO=50;
--5. 사용자가 보유한 테이블 목록을 확인하는 SQL문을 작성하시오.

SELECT * FROM TAB;
--6. EMP 테이블의 구조를 확인하는 SQL을 작성하시오.
DESC EMP;

--7. 사용자가 정의한 제약조건들을 확인하는 SQL문을 작성하시오.
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME='테이블명';

--#2 아래 요구사항에 맞도록 고급 SQL 문을 작성하시오.
--1. EMP 테이블의 ename 컬럼에 인덱스를 생성하는 SQL을 작성하시오. 인덱스의 이름은 emp_index
CREATE INDEX EMP_INDEX ON EMP(ENAME);

--2. EMP 테이블과 DEPT 테이블을 조인하는 SQL을 기반으로 view 객체를 생성하는 SQL을 작성하시오.
--   view 의 이름은 emp_view 로 하시오.
CREATE VIEW EMP_VIEW AS
SELECT *
FROM EMP E , DEPT D
WHERE E.EMPNO=D.EMPNO;

--3. EMP 테이블에서 모든 사원의 부서번호를 이름이 'SCOTT'인 사원의 부서번호로 변경하는 SQL을 작성하시오.
UPDATE EMP DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT');