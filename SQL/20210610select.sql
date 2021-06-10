-- 2021.06.10

-- 특정 데이터 검색 : 행 검색 -> 컬럼 선택

-- 10번 부서의 사원 리스트를 출력
-- 10번 부서 -> where dept=10
SELECT *
FROM emp
WHERE deptno = 10;

-- 이름이 'SCOTT'인 사원을 출력
SELECT *
FROM EMP
WHERE ENAME='SCOTT';

-- 날짜타입의 데이터 비교시에도 작은 따움표를 이용해야한다!!!
SELECT *
FROM EMP
WHERE HIREDATE = '96/11/17';

-- 논리연산자 : AND, OR, NOT
-- 10번 부서의 관리자(MANAGER)를 찾아 출력
SELECT *
FROM EMP
WHERE DEPTNO=10 AND JOB='MANAGER'; -- 10번부서의 매니저만 검색

--10번 부서의 직원들과 관리자들의 리스트를 출력
SELECT *
FROM EMP
WHERE DEPTNO=10 OR JOB='MANAGER'; -- 10번부서 또는 매니저들 검색

-- 10번 부서의 직원을 제외한 나머지 직원들을 출력
-- 20번 30번 40번
SELECT *
FROM EMP
--WHERE DEPTNO=20 OR DEPTNO=30 OR DEPTNO=40;
WHERE NOT DEPTNO=10; -- 10번 부서직원 빼고 검색

-- 범위 연산을 할 때 -> 논리연산자 이용, BETWEEN A AND B
-- BETWEEN A AND B : A이상 ~ B이하


-- 2000 이상 3000 이하의 급여를 받는 직원의 리스트 검색
SELECT ENAME, JOB, SAL, SAL*1.2 AS UPSAL
FROM EMP
--WHERE SAL >= 2000 AND SAL <=3000;
WHERE SAL BETWEEN 2000 AND 3000; -- 연봉이 2000~ 3000만원인 직원 검색

-- BETWEEN 연산자는 날짜의 연산도 가능
-- 1987년에 입사한 사원들의 리스트를 출력
SELECT *
FROM EMP
--WHERE HIREDATE >= '81/01/01' AND HIREDATE <= '81/12/31'
WHERE HIREDATE BETWEEN '81/01/01' AND '81/12/31' -- 입사날짜가 81년1월1일부터 81년12월31일까지 검색
ORDER BY HIREDATE;

-- 연산자 IN -> 여러개의 OR 연산자 사용시 대체 할수 있다
-- 키미션이 300 또는 500 또는 14000
SELECT *
FROM EMP
-- WHERE COMM=300 OR COMM=500 OR COMM=1400
WHERE COMM IN(300, 500, 1400);

-- 패턴 검색 : 키워드 검색 많이 사용 ( 게시판 )
-- 컬럼 LIKE '%'
-- ENAME LIKE 'F%' -> F로 시작하는 문자열
-- ENAME LIKE '%F' -> F로 끝나는 문자열
-- ENAME LIKE '%F%' -> F를 포함하는 문자열
-- 'JAVA' 단어를 포함하는지 -> TITLE LIKE '%JAVA%' 게시판검색할때 자주쓰는 타이틀

-- F 로시작하는 이름을 가진 사원을 검색
SELECT ENAME
FROM EMP
WHERE ENAME LIKE 'F%';
--WHERE ENAME LIKE '%A%';

-- 자리수 패턴 : 컬럼의 값이 자리수가 저어해져 있고 값에 패턴이 있는 경우
-- 사원이름 중에 두번째 문자에 A를 포함하는 사원의 리스트
SELECT *
FROM EMP
--WHERE ENAME LIKE '_A%';
--WHERE ENAME LIKE '__A%'; -- 세번째 문자가 A인 이름
WHERE ENAME NOT LIKE '__A%'; -- 세번째 문자가 A인 이름 빼고 검색

-- NULL 값을 확인하는 연산자 -> IS NULL, IS NOT NULL
-- 커미션이 등록되어 있지 않은 사원의 리스트
SELECT *
FROM EMP
--WHERE COMM IS NULL; -- NULL 값 검색
WHERE COMM IS NOT NULL -- NULL 값이 아닌 것을 검색
ORDER BY COMM; -- ORDER BY(정렬)는 WHERE의 뒤에 작성해야된다.

-- 결과 행의 정렬 : ORDER BY 컬럼 [ASC|DESC] ASC오름차순|DESC내림차순
-- 급여가 적은 사원부터 출력 : 오름차순 -> ASC
SELECT ENAME, SAL
FROM EMP
--ORDER BY SAL ASC;
ORDER BY SAL; -- 정렬의 기본은 오름차순이다!!

--급여가 큰 사원부터 출력
SELECT ENAME, SAL
FROM EMP
ORDER BY SAL DESC; -- 정렬의 내림차순(DESC사용)

--급여가 큰 사원부터 출력하고 급여가 같은 사원은 이름을 기준으로 오름차순
SELECT *
FROM EMP
ORDER BY SAL DESC, ENAME ASC; --ASC는 생략해도 된다 기본오름차순이기 때문이다.