-- 2021.06.15

-- DDL : 데이터 정의어

-- 테이블 생성 : CREATE TABLE
-- 테이블 수정 : ALTER TABER
-- 테이블 삭제 : DROP TABLE

-- CREATE TABLE (
--      컬럼이름 타입(사이즈)), 제약조건 정의,
--      ......
-- )

-- CREATE TABLE (
--      컬럼이름 타입(사이즈)),
--      ......,
--      제약조건 정의,
--      ....
-- )

-- 사원 테이블과 유사한 구조의
-- 사원번호, 사원이름, 급여 3개의 컬럼으로 구성된
-- EMP01 테이블을 생성해 봅시다.
CREATE TABLE EMP01 (
    EMPNO NUMBER(4), -- 사원번호
    ENAME VARCHAR2(20), -- 사원이름
    SAL NUMBER(6,2)
);

-- 서브쿼리를 이용해서 기존 테이블의 구조를 복사하고 해당 튜플도 복사
CREATE TABLE EMP02
AS
SELECT * FROM EMP;

SELECT * FROM EMP02;
-------------------------------------
--CREATE TABLE EMP03
--AS
--SELECT EMPNO, ENAME, SAL FROM EMP;

--SELECT * FROM EMP03;
--------------------------------------
CREATE TABLE EMP04
AS
SELECT * FROM EMP WHERE DEPTNO=30;

SELECT * FROM EMP04;
--------------------------------------
CREATE TABLE EMP05
AS
SELECT * FROM EMP WHERE 1=2;

SELECT * FROM EMP05;

-- 테이블의 변경 : ALTER TABLE
-- ALTER TABLE {테이블이름} ADD 
-- ALTER TABLE {테이블이름} MODIFY
-- ALTER TABLE {테이블이름} DROP

-- EMP01 테이블에 JOB 컬럼을 추가해보자
ALTER TABLE EMP01 
ADD( JOB VARCHAR2(9) );
DESC EMP01;

-- EMP01 테이블의 JOB 컬럼의 사이즈를 수정 9->30
ALTER TABLE EMP01
MODIFY( JOB VARCHAR2(130) NOT NULL );

-- EMP01 테이블의 JOB 컬럼을 삭제
ALTER TABLE EMP01
DROP COLUMN JOB;

-- 테이블 삭제
DROP TABLE EMP02;

-- 새로운 테이블 생성
CREATE TABLE EMP02
AS 
SELECT * FROM EMP;

SELECT * FROM EMP02;

-- 모든 행을 삭제 TRUNCATE : 롤백이 안된다
TRUNCATE TABLE EMP02;

-- 테이블의 이름 변경 -> RENAME 현재 이름 새 새로운 이름
RENAME EMP01 TO TEST;
DESC EMP01;

DROP TABLE EMP02;

CREATE TABLE EMP02
AS
SELECT EMPNO, ENAME, SAL, JOB FROM EMP WHERE 1=0;

-- 컬럼 레벨에서 제약 사항 정의
CREATE TABLE EMP02 (
    EMPNO NUMBER(4) CONSTRAINT EMP02_EMPNO_PK PRIMARY KEY, --NOT NULL UNIQUE,
    ENAME VARCHAR2(20) CONSTRAINT EMP02_ENAME_NN NOT NULL,
    SAL NUMBER(6,2) CONSTRAINT EMP02_SAL_CK CHECK (SAL > 500 AND SAL < 5000),
    JOB VARCHAR(20) DEFAULT '미지정',
    DEPTNO NUMBER CONSTRAINT EMP02_DEPTNO_FK REFERENCES DEPT(DEPTNO) -- (DEPTNO)컬럼 PK
);

DESC DEPT;

DESC EMP02;

INSERT INTO EMP02 (EMPNO, ENAME, SAL, JOB, DEPTNO) VALUES(2000, 'SON', 4000, 'MANAGER', 40);
INSERT INTO EMP02 VALUES(NULL, NULL, 10000, 'MANAGER');

SELECT * FROM EMP02;


-- 테이블 레벨에서 제약 사항 정의
CREATE TABLE EMP03 (
    EMPNO NUMBER(4), -- CONSTRAINT EMP02_EMPNO_PK PRIMARY KEY, --NOT NULL UNIQUE,
    ENAME VARCHAR2(20) CONSTRAINT EMP02_ENAME_NN NOT NULL, -- NOT NULL 제약은 컬럼 레벨에서만 정의 가능
    SAL NUMBER(6,2) CONSTRAINT EMP02_SAL_CK CHECK (SAL > 500 AND SAL < 5000),
    JOB VARCHAR(20), -- DEFAULT '미지정',
    DEPTNO NUMBER, -- CONSTRAINT EMP02_DEPTNO_FK REFERENCES DEPT(DEPTNO),
    ------------------------------------------------------------------------------------
    -- 제약 정의
    CONSTRAINT EMP03_EMPNO_PK PRIMARY KEY (EMPNO), -- PK 제약
    CONSTRAINT EMP03_DEPTNO FOREIGN KEY (DEPTNO) REFERENCES DEPT(DEPTNO)
    
);