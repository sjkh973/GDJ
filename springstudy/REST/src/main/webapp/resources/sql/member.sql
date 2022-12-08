
DROP TABLE MEMBER;

CREATE TABLE MEMBER
(
    MEMBER_NO NUMBER NOT NULL,
    ID VARCHAR2(30 BYTE) NOT NULL UNIQUE,
    NAME VARCHAR2(30 BYTE),
    GENDER VARCHAR2(1 BYTE),
	ADDRESS VARCHAR2(30 BYTE)
);

ALTER TABLE MEMBER
    ADD CONSTRAINT PK_MEMBER
        PRIMARY KEY(MEMBER_NO);

DROP SEQUENCE MEMBER_SEQ;
CREATE SEQUENCE MEMBER_SEQ NOCACHE;

