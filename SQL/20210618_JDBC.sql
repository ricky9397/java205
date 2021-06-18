-- 2021.06.18

-- JDBC
select * from dept01;

insert into dept01 values (dept01_deptno_seq.nextval, 'dev', 'SEOUL');

-- dept01 deptno 에 입력할 일련 번호 -> sequence
create sequence dept01_deptno_seq
start with 10
increment by 10;