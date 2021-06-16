-- 2021.06.16

--  DML


-- 테스트 테이블 생성
create table dept01
as 
select * from dept where 1=0;


-- 데이터 입력 : 행단위 입력
-- insert into 테이블명 (컬럼명,...) values (데이터, 데이터,...)
-- 입력하고자하는 커럼과 입력데이터의 개수는 일치
-- 컬럼의 도메인과 입력데이터의 타입이 일치
-- 기본키와 같이 not null 인경우 컬럼을 생략하면 안됨

desc dept01;
select * from dept01;
-- 1번부서 개발팀 서울 위치
insert into dept01 (deptno, dname, loc)
            values (10, '개발팀', '서울')
;

insert into dept01 (deptno, dname, loc)
            values ('삼십', '개발팀', '서울')
;

insert into dept (dname, loc)
            values ('개발팀', '서울')
;


-- 데이터 저장할 컬럼기술을 생략 가능!
-- 모든 컬럼의 데이터를 입력할 때
-- values 절의 데이터의 순서 : 테이블이 생성될때 저의된 커럼의 순서 -> desc 테이블명
desc dept01;

insert into dept01 values (20, '마케팅', '부산');

DESC EMP;

INSERT INTO EMP (EMPNO, DEPTNO) VALUES (7777, 60);

SELECT * FROM EMP;

-- 잘못입력하면 롤백 해주면 그전 작업으로 돌아감
ROLLBACK;

DESC ORDERS;

INSERT INTO ORDERS (ORDERID, CUSTID, BOOKID) VALUES (11, 6, 11);

-- 서브 쿼리를 이용해서 데이터 입력
DROP TABLE DEPT02;

CREATE TABLE DEPT02
AS SELECT * FROM DEPT WHERE 1=0;

SELECT * FROM DEPT02;

-- 데이터 입력
INSERT INTO DEPT02
SELECT * FROM DEPT;

INSERT INTO DEPT02
SELECT * FROM DEPT02;

-- 데이터를 변경 : 행단위로 선택하고 변경하고자하는 컬럼을 기술
-- UPDATE 테이블 명 SET 컬럼이름=새로운 데이터, 커럼이름=새로운 데이터 WHERE 행을 선택하는 조건
CREATE TABLE DEPT03
AS SELECT * FROM DEPT;

SELECT * FROM DEPT03;

-- 모든 부서의 위치를 SEOUL 로 이동
UPDATE DEPT03
SET LOC='SEOUL';

-- WHERE
-- 10번 부서의 위치를 BUSAN이동, 부서이름도 DEV 변경
UPDATE DEPT03
SET LOC='BUSAN', DNAME='DEV'
WHERE DEPTNO=10;

-- EMP01 새롭게 생성하고 UPDATE 
DROP TABLE EMP01;
CREATE TABLE EMP01
AS SELECT * FROM EMP;

SELECT * FROM EMP01;

-- 모든사원의 부서번호를 30번으로 수정합시다.
UPDATE EMP01
SET DEPTNO=30;

-- 이번엔 모든 사원의 급여를 10% 인상시키는 UPDATE 문.
UPDATE EMP01
SET SAL=SAL*1.1;

-- 모든 사원의 입사일을 오늘로 수정.
UPDATE EMP01
SET HIREDATE=SYSDATE; -- SYSDATE 현재날짜를 가져옴
ROLLBACK;
SELECT * FROM EMP01;

-- 부서번호가 10번인 사원의 부서번호를 30번으로 수정합시다.
UPDATE EMP01
SET DEPTNO=30
WHERE DEPTNO=10;


-- 급여가 3000 이상인 사원만 급여를 10% 인상합시다.
UPDATE EMP01
SET SAL=SAL*1.1
WHERE SAL>=3000;

-- 1987년에 입사한 사원의 입사일이 오늘로 수정합시다.
UPDATE EMP01
SET HIREDATE=SYSDATE
WHERE SUBSTR(HIREDATE, 1, 2)=81;

-- SCOTT 사원의 부서번호는 20번으로, 직급은 MANAGER로 한꺼번에 수정하도록 합시다.
UPDATE EMP01
SET DEPTNO=30, JOB='MANAGER'
WHERE ENAME='SCOTT';

-- SCOTT 사원의 입사일자는 오늘로, 급여를 50으로 커미션을 4000으로 수정합시다.
UPDATE EMP01
SET HIREDATE=SYSDATE, SAL=50, COMM=4000
WHERE ENAME='SCOTT';

-- 20번 부서의 지역명을
-- 40번 부서의 지역명으로 변경하기 위해서 서브 쿼리문을 사용해 봅시다.

INSERT INTO DEPT01
SELECT * FROM DEPT;

SELECT LOC FROM DEPT01 WHERE DEPTNO=40;

UPDATE DEPT01
SET LOC='BOSTON'
WHERE DEPTNO=20;

SELECT * FROM DEPT01;

-- 서브 쿼리를 이용해서
-- 부서번호가 20인 부서의 부서명과 지역명을
-- 부서 번호가 10번인 부서와 동일하게 변경하도록 해 봅시다.
SELECT * FROM DEPT01 WHERE DEPTNO=10;
SELECT * FROM DEPT01 WHERE DEPTNO=20;

UPDATE DEPT01
SET (DNAME, LOC) = (SELECT DNAME, LOC FROM DEPT01 WHERE DEPTNO=10)
WHERE DEPTNO=20;

-- 데이터의 삭제 : 행단위 삭제
-- DELETE FROM 테이블 이름 WHERE 조건

-- DEPT01 테이블의 모든 데이터를 삭제 하자
DELETE FROM DEPT01;

-- 이름이 SCOTT인 사원을 삭제
DELETE FROM EMP01 WHERE ENAME='SCOTT';
SELECT * FROM EMP01;

-- 사원 테이블에서 부서명이 SALES인 사원을 모두 삭제해봅시다.
SELECT DEPTNO FROM DEPT WHERE DNAME='SALES';

DELETE FROM EMP01
WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');
