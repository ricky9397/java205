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