-- 2021.06.17


-- ????€ : ?«?λ₯? ??±?? κ°μ²΄ 
-- ?€? ? ?΅?΄ ?Ό? ¨λ²νΈλ₯? ??± -> κΈ°λ³Έ?€κ°? ??λ¦¬ν€?Έκ²½μ° ?? €?? κ°μΌλ‘? ?¬?©

-- dept ??΄λΈμ λ³΅μ¬ -> deptno? ?€?΄κ°? ?°?΄?° ?μΏΌμ€ ??± -> insert ??€?Έ
drop table dept03;
create table dept03
as select * from dept where 1=0;

select * from dept03;

-- sequence ??±
create sequence dept_deptno_seq
start with 1
increment by 1;

-- dept03? ???₯
insert into dept03 values (dept_deptno_seq.nextval, 'dev', 'seoul');
select * from dept03;