CREATE TABLE MEMBERS(
    ID VARCHAR2(20),
    PW VARCHAR2(20),
    NAME VARCHAR2(20),
    TIMES DATE DEFAULT SYSDATE
);
commit;