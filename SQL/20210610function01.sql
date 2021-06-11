-- 2021.06.10
-- function : 단일행 함수, 집합(다중행)함수
-- 단일행 함수 : 행 하나의 행이 포함하는 톡정 컬럼의 값 하나를 처리하고 반환
-- 다중행(집합) 함수 : 여러행의 특정 컬럼값들을 대상으로 연산하고 반환


-- 숫자 함수
SELECT ABS(10), ABS(-10)
FROM DUAL;

SELECT FLOOR(15.7) -- 소숫점 절단
FROM DUAL;

SELECT ROUND(15.193,2), ROUND(15.193,-2) -- 소숫점 반올림
FROM DUAL;

SELECT TRUNC(15.79,1), TRUNC(15.79) -- 소숫점 절단
FROM DUAL;

SELECT MOD(11,5)  
FROM DUAL;

-- 사원 들의 급여
SELECT SAL, MOD(SAL, 2)
FROM EMP
WHERE MOD(SAL,2) = 1;


-- 문자 함수
-- CONCAT(문자, 문자) -> '' || ''
SELECT CONCAT('ABC', 'EFG'), 'ABC' || 'EFG' -- 문자열을 합친다
FROM DUAL;

-- SUBSTR : 문자열 추출
-- SUBSTR(문자열, 시작 위치, 길이)
SELECT SUBSTR('APPLE', 1, 3) -- 1~3번까지 문자열을 뽑아 낸다
FROM DUAL;

SELECT SUBSTR('APPLE', -3) -- -3을 사용하면 뒤에서 3개 뽑아낼수 있다.
FROM DUAL;

-- REPLACE : 특정 문자열(패턴) 다른 문자열(패턴)으로 변경
SELECT REPLACE('JACK and JUE','J','BL') -- JACK 그리고 JUE , J를 찾아서 BL로 문자열 바꿔줌
FROM DUAL;

SELECT SYSDATE -- 년/월/일 날짜 추출
FROM DUAL;

-----------------------------------------------------------------------------
-- 2021.06.11 
-----------------------------------------------------------------------------

-- 형변환 함수 
-- 날짜 -> 문자
-- to_char(날짜 데이터, 패턴), to_char(숫자, '패턴')
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY.MM.DD. HH24:MI:SS')
FROM DUAL;

SELECT ENAME, HIREDATE, TO_CHAR(HIREDATE, 'YYYY.MM.DD')
FROM EMP;

SELECT *FROM ORDERS;

SELECT ORDERID, ORDERDATE, TO_CHAR(ORDERDATE, 'YYYY.MM.DD')
FROM ORDERS;

-- 숫자 -> 문자
SELECT TO_CHAR(123456, '0000000000'), TO_CHAR(123456, '9999999999')
FROM DUAL;

SELECT EMPNO, ENAME, SAL, TO_CHAR(SAL, 'L999,999,999')
FROM EMP;


-- '1,000,000' + 100000

-- 문자->숫자
-- TO_NUBER(문자열, 패턴)
SELECT TO_NUMBER('1,000,000', '9,999,999'), TO_NUMBER('1,000,000', '9,999,999') + 100000
FROM DUAL;

-- 문자->날짜
-- TO_DATE(문자열, 패턴)
SELECT TO_DATE('2012.05.17', 'YYYY.MM.DD'), TRUNC((SYSDATE-TO_DATE('2012.05.17', 'YYYY.MM.DD'))/365)
FROM DUAL;

-- DECODE 함수 : 분기를 위해 사용 SWITCH-CASE와 유사하다
-- DECODE(컬럼, = 조건1 값, 조건1의 참일때 사용할 값
--          , 조건2 값, 조건2의 참일때 사용할 값
--          ,.....
-- )

-- EMP 테이블에서 부서번호에 맞는 부서이름 출력
SELECT * FROM DEPT;

-- 10 ACCOUNTING
-- 20 RESEARCH
-- 30 SALES
-- 40 OPERATIONS

SELECT ENAME, DEPTNO,
        DECODE(DEPTNO, 10, 'ACCOUNTING',
                        20, 'RESEARCH',
                        30, 'SALES',
                        40, 'OPERATIONS'
                        ) AS DNAME
FROM EMP
ORDER BY DNAME;

-- 8. 직급에 따라 급여를 인상하도록 하자.
-- 직급이 'ANALYST'인 사원은 5%, 'SALESMAN'인 사원은 10%, 'MANAGER'인 사원은 15%, 'CLERK'인 사원은 20% 인상한다.
SELECT ENAME, SAL,
        DECODE(JOB, 'ANALYST', SAL*1.05, -- 5%인상
                    'SALESMAN', SAL*1.1, -- 10% UP
                    'MANAGER', SAL*1.15, -- 15% UP
                    'CLERK', SAL*1.2 -- 20% UP
        )
FROM EMP;

-- CASE 함수도 분기할 때 사용
-- CASE WHEN 조건식 THEN 참일때 값
SELECT ENAME, DEPTNO,
        CASE WHEN DEPTNO=10 THEN 'ACCOUNTING'
             WHEN DEPTNO=20 THEN 'RESEARCH'
             WHEN DEPTNO=30 THEN 'SALES'
             WHEN DEPTNO=40 THEN 'OPERATIONS'
        END AS DEPTNAME
FROM EMP
ORDER BY ENAME;
