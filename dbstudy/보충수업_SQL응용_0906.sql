/*************************************************************************
* 기존에 저장되어 있는 STUDENT(학생), PROFESSOR(교수), DEPARTMENT(학과) 테이블 삭제
*************************************************************************/
DROP TABLE STUDENT;
DROP TABLE PROFESSOR;
DROP TABLE DEPARTMENT;
/*************************************************************************
*                         STUDNET 테이블 생성
*************************************************************************/
CREATE TABLE STUDENT
        (STUDNO NUMBER(5) NOT NULL,
         NAME VARCHAR2(20 BYTE),
         USERID VARCHAR2(10 BYTE),
         GRADE VARCHAR2(1 BYTE),
         IDNUM VARCHAR2(13 BYTE),
         BIRTHDATE DATE,
         TEL VARCHAR2(13 BYTE),
         HEIGHT NUMBER(5,2),
         WEIGHT NUMBER(5,2),
         DEPTNO NUMBER(4),
         PROFNO NUMBER(4));
/*************************************************************************
*                        STUDNET 테이블 데이터 입력
********************************************************************          *****/
INSERT INTO STUDENT VALUES
        (10101, '전인하', 'jun123', '4', '7907021369824',
        TO_DATE('02-01-1979','DD-MM-YYYY'), '051)781-2158', 176, 72, '101',9903);
INSERT INTO STUDENT VALUES
        (20101, '이동훈', 'Dals', '1', '8312101128467',
         TO_DATE('10-12-1983','DD-MM-YYYY'), '055)426-1752', 172, 64, '201',NULL);
INSERT INTO STUDENT VALUES
        (10102, '박미경', 'ansel414', '1', '8405162123648',
        TO_DATE('16-05-1984','DD-MM-YYYY'), '055)261-8947', 168, 52, '101',NULL);
INSERT INTO STUDENT VALUES
        (10103, '김영균', 'mandu', '3', '8103211063421',
        TO_DATE('11-01-1981','DD-MM-YYYY'), '051)824-9637', 170, 88 ,'101',9906);
INSERT INTO STUDENT VALUES
        (20102, '박동진', 'Ping2', '1', '8511241639826',
        TO_DATE('24-11-1985','DD-MM-YYYY'), '051)742-6384', 182, 70, '201',NULL);
INSERT INTO STUDENT VALUES
        (10201, '김진영', 'simply', '2', '8206062186327',
        TO_DATE('06-06-1982','DD-MM-YYYY'), '055)419-6328', 164, 48, '102',9905);
INSERT INTO STUDENT VALUES
        (10104, '지은경', 'Gomo00', '2', '8004122298371',
        TO_DATE('12-04-1980','DD-MM-YYYY'), '055)418-9627', 161, 42, '101',9907);
INSERT INTO STUDENT VALUES
        (10202, '오유석', 'yousuk', '4', '7709121128379',
        TO_DATE('12-10-1977','DD-MM-YYYY'), '051)724-9618', 177, 92, '102',9905);
INSERT INTO STUDENT VALUES
        (10203, '하나리', 'hanal', '1', '8501092378641',
        TO_DATE('18-12-1984','DD-MM-YYYY'), '055)296-3784', 160, 68, '102',NULL);
INSERT INTO STUDENT VALUES
        (10105, '임유진', 'YouJin12', '2', '8301212196482',
        TO_DATE('21-01-1983','DD-MM-YYYY'), '02)312-9838', 171, 54, '101',9907);
INSERT INTO STUDENT VALUES
        (10106, '서재진', 'seolly', '1', '8511291186273',
        TO_DATE('29-11-1985','DD-MM-YYYY'), '051)239-4861', 186, 72, '101',NULL);
INSERT INTO STUDENT VALUES
        (10204, '윤진욱', 'Samba7', '3', '7904021358671',
        TO_DATE('02-04-1979','DD-MM-YYYY'), '053)487-2698', 171, 70, '102',9905);
INSERT INTO STUDENT VALUES
        (10107, '이광훈', 'huriky', '4', '8109131276431',
        TO_DATE('13-10-1981','DD-MM-YYYY'), '055)736-4981', 175, 92, '101',9903);
INSERT INTO STUDENT VALUES
        (20103, '김진경', 'lovely', '2', '8302282169387',
        TO_DATE('28-02-1983','DD-MM-YYYY'), '052)175-3941', 166, 51, '201',9902);
INSERT INTO STUDENT VALUES
        (20104, '조명훈', 'Rader214', '1', '8412141254963',
        TO_DATE('16-09-1984','DD-MM-YYYY'), '02)785-6984', 184, 62, '201',NULL);
INSERT INTO STUDENT VALUES
        (10108, '류민정', 'cleanSky', '2', '8108192157498',
        TO_DATE('19-08-1981','DD-MM-YYYY'), '055)248-3679', 162, 72, '101',9907);
/*************************************************************************
*                         PROFESSOR 테이블 생성
*************************************************************************/
CREATE TABLE PROFESSOR
        (PROFNO NUMBER(4) NOT NULL,
         NAME VARCHAR2(10 BYTE),
         USERID VARCHAR2(10 BYTE),
         POSITION VARCHAR2(20 BYTE),
         SAL NUMBER(10),
         HIREDATE DATE,
         COMM NUMBER(2),
         DEPTNO NUMBER(4));
/*************************************************************************
*                        PROFESSOR 테이블 데이터 입력
*************************************************************************/
INSERT INTO PROFESSOR VALUES
        (9901, '김도훈', 'capool', '교수', 500,
        TO_DATE('24-01-1982','DD-MM-YYYY'), 20, 101);
INSERT INTO PROFESSOR VALUES
        (9902, '이재우', 'sweat413', '조교수', 320,
        TO_DATE('12-04-1995','DD-MM-YYYY'), NULL, 201);
INSERT INTO PROFESSOR VALUES
        (9903, '성연희', 'Pascal', '조교수', 360,
        TO_DATE('17-05-1993','DD-MM-YYYY'), 15, 101);
INSERT INTO PROFESSOR VALUES
        (9904, '염일웅', 'Blue77', '전임강사', 240,
        TO_DATE('02-12-1998','DD-MM-YYYY'), NULL, 102);
INSERT INTO PROFESSOR VALUES
        (9905, '권혁일', 'Refresh', '교수', 450,
        TO_DATE('08-01-1986','DD-MM-YYYY'), 25, 102);
INSERT INTO PROFESSOR VALUES
        (9906, '이만식', 'Pocari', '부교수', 420,
        TO_DATE('13-09-1988','DD-MM-YYYY'), NULL, 101);
INSERT INTO PROFESSOR VALUES
        (9907, '전은지', 'Totoro', '전임강사', 210,
        TO_DATE('01-06-2001','DD-MM-YYYY'), NULL, 101);
INSERT INTO PROFESSOR VALUES
        (9908, '남은혁', 'Bird13', '부교수', 400,
        TO_DATE('18-11-1990','DD-MM-YYYY'), 17, 202);
/*************************************************************************
*                          DEPARTMENT 테이블 생성
*************************************************************************/
CREATE TABLE DEPARTMENT
        (DEPTNO NUMBER(4),
         DNAME VARCHAR2(30 BYTE),
         COLLEGE NUMBER(4),
         LOC VARCHAR2(10 BYTE));
/*************************************************************************
*                        DEPARTMENT 테이블 데이터 입력
*************************************************************************/
INSERT INTO DEPARTMENT VALUES
        (101, '컴퓨터공학과', 100, '1호관');
INSERT INTO DEPARTMENT VALUES
        (102, '멀티미디어학과', 100, '2호관');
INSERT INTO DEPARTMENT VALUES
        (201, '전자공학과', 200, '3호관');
INSERT INTO DEPARTMENT VALUES
        (202, '기계공학과', 200, '4호관');
INSERT INTO DEPARTMENT VALUES
        (100, '정보미디어학부', 10, NULL);
INSERT INTO DEPARTMENT VALUES
        (200, '메카트로닉스학부', 10, NULL);
INSERT INTO DEPARTMENT VALUES
        (10, '공과대학', NULL, NULL);
/*************************************************************************
*                        기본키, 외래키 제약조건
*************************************************************************/
ALTER TABLE STUDENT ADD CONSTRAINT PK_STUDENT PRIMARY KEY(STUDNO);
ALTER TABLE PROFESSOR ADD CONSTRAINT PK_PROFESSOR PRIMARY KEY(PROFNO);
ALTER TABLE DEPARTMENT ADD CONSTRAINT PK_DEPARTMENT PRIMARY KEY(DEPTNO);
ALTER TABLE STUDENT ADD CONSTRAINT FK_STUDENT_PROFESSOR FOREIGN KEY(PROFNO) REFERENCES PROFESSOR(PROFNO);
ALTER TABLE STUDENT ADD CONSTRAINT FK_STUDENT_DEPARTMENT FOREIGN KEY(DEPTNO) REFERENCES DEPARTMENT(DEPTNO);
ALTER TABLE PROFESSOR ADD CONSTRAINT FK_PROFESSOR_DEPARTMENT FOREIGN KEY(DEPTNO) REFERENCES DEPARTMENT(DEPTNO);


-- 프로시저 작성
-- 학과번호(DEPTNO) 전달하면 소속 학생, 교수, 학과 모두 제거하는 프로시저
-- 프로시저 실행은 학과번호=101번인 학과를 대상으로 실행
-- 프로시저 이름은 MY_PROC
-- 예외 발생 시 예외코드 + 예외메시지 출력 + ROLLBACK

SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE MY_PROC(DNO IN DEPARTMENT.DEPTNO%TYPE)
IS
BEGIN
    DELETE FROM STUDENT WHERE DEPTNO = DNO;
    DELETE FROM PROFESSOR WHERE DEPTNO = DNO;
    DELETE FROM DEPARTMENT WHERE DEPTNO = DNO;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE (SQLCODE);
        DBMS_OUTPUT.PUT_LINE (SQLERRM);
    
END MY_PROC;

EXECUTE MY_PROC(101);

-- 사용자 함수
-- 학생 아이디를 전달하면 해당 학생의 학번을 반환하는 함수 만들기
-- 아이디 'jun123'을 전달하면 학번 '10101'이 반환되는지 확인
-- GET_STUDENT
CREATE OR REPLACE FUNCTION GET_STUDENT(U_ID IN STUDENT.USERID%TYPE)
RETURN NUMBER -- 반환하는 학번의 타입이 NUMBER(5)이므로
IS
    SNO STUDENT.STUDNO%TYPE;
BEGIN
    SELECT STUDNO
      INTO SNO
      FROM STUDENT
     WHERE USERID = U_ID; 
     RETURN SNO;
END GET_STUDENT;

-- 함수
SELECT GET_STUDENT(USERID)
  FROM STUDENT
 WHERE USERID= 'Dals';

SELECT DISTINCT GET_STUDENT('Dals')
  FROM STUDENT;

-- 트리거
-- SAMPLE 테이블의 행을 갱신, 삭제 이후 'SampleTrg 동작' 서버메시지 출력하기
CREATE OR REPLACE TRIGGER SampleTrg
    AFTER
    UPDATE OR DELETE
    ON SAMPLE 
    FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('SampleTrg 동작');
END;    

-- 학생명, 학과명, 담당교수명 조회하기 (쿼리문제)
-- STUDENT  DEPARTMENT     PROFESSOR
-- DEPTNO    DEPTNO  DEPTNO

-- ANSI (JOIN)
SELECT S.NAME 
      ,P.NAME
      ,D.DNAME
  FROM STUDENT S INNER JOIN DEPARTMENT D 
    ON S.DEPTNO = D.DEPTNO INNER JOIN PROFESSOR P
    ON P.DEPTNO = D.DEPTNO;
    
-- ORACLE (콤마)    
SELECT S.NAME 
      ,P.NAME
      ,D.DNAME
  FROM STUDENT S, DEPARTMENT D, PROFESSOR P
 WHERE S.DEPTNO = D.DEPTNO
   AND P.DEPTNO = D.DEPTNO;



