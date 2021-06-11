-- 2021.06.11

-- 그룹함수
-- 여러행을 묶어 처리하는 함수
-- sum, avg, count, max, min

-- 사원 테이블에서 
-- 1. 사원의 수
-- 2. 사원의 급여 총합
-- 3. 급여 평균
-- 4. 최대 급여
-- 5. 최소 급여
SELECT COUNT(*) AS "사원의 수", 
       SUM(SAL) AS "급여의 총합",
       ROUND(AVG(SAL), 2) AS "급여 평균",
       MAX(SAL) AS "최대 급여",
       MIN(SAL) AS "최저 급여",
       SUM(COMM) AS "커미션의 총합", -- 그룹함수는 NULL 값을 제외하고 연산
       AVG(COMM) AS "커미션의 평균",
       COUNT(COMM) AS "커미션 받는 사원의 수"
FROM EMP;

SELECT DISTINCT JOB -- DISTINCT 중복제거
FROM EMP;

SELECT COUNT(DISTINCT JOB) -- COUNT 중복제거후 남은 총수
FROM EMP;

-- 마당서적 BOOK 테이블에 책 총수
SELECT COUNT(DISTINCT PUBLISHER)
FROM BOOK
ORDER BY PUBLISHER;

-- 특정 컬럼을 이용해서 그룹핑하기 -> GROUP BY
-- SELECT 그룹핑할 기준의 컬럼, 그룹함수
-- FROM 테이블
-- WHERE 
-- GROUP BY 그룹핑할 기준의 컬럼

-- 부서별 급여 평균을 구해보자
select avg(sal) from emp where deptno=10;
select avg(sal) from emp where deptno=10;
select avg(sal) from emp where deptno=10;

SELECT DEPTNO, COUNT(*) AS "부서 인원", SUM(SAL) AS "부서의 급여 총합",
                TRUNC(AVG(SAL)) AS "부서의 급여 평균", MAX(SAL) AS "부서의 최대 금여액", MIN(SAL) AS "부서의 최소 금여액"
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

SELECT * FROM EMP ORDER BY DEPTNO;

-- 직급별
SELECT DISTINCT JOB
FROM EMP;

SELECT JOB, COUNT(*)
FROM EMP
GROUP BY JOB
ORDER BY JOB;

-- 다음은 부서별로 사원 수와 커미션을 받는 사원들의 수를 계산해서 출력
SELECT DEPTNO, COUNT(*), COUNT(COMM)
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

SELECT COUNT(*), COUNT(COMM)
FROM EMP
WHERE DEPTNO=10;


-- GRUP BY 의 그룹함수의 결과를 비교 시에는 HAVING 절 사용
-- SELECT
-- FROM
-- WHERE
-- GROUP BY
-- HAVING 그룹함수 연산자 값 (= != > < >= <=)

-- 부서별 평균 급여가 2000 이상인(HAVING)
-- 부서번호와 부서별 평균 급여를 출력
SELECT DEPTNO, AVG(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING AVG(SAL)>=2000;

-- 부서의 급여의 최대값과 최소값을 구하되 
-- 최대 급여가 2900이상인 부서만 출력합니다.
SELECT DEPTNO, MAX(SAL), MIN(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING MAX(SAL)>=2900
ORDER BY DEPTNO;

