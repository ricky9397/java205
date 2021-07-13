CREATE TABLE members(
                                ID VARCHAR2(20) CONSTRAINT MEMBER_ID_NN PRIMARY key,
                                PW VARCHAR2(20)CONSTRAINT MEMBER_PW_NN NOT NULL,
                                NAME  VARCHAR2(20)CONSTRAINT MEMBER_NAME_NN NOT NULL ,
                                PHONENUM  VARCHAR2(20)CONSTRAINT MEMBER_NUM_NN NOT NULL,
                                EMAIL VARCHAR2(20)CONSTRAINT MEMBER_EMAIL_NN NOT NULL
                              ) ;
                              
                              drop table member;
                              select * from members;
                              
                              commit;