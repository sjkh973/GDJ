
DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;

CREATE TABLE DEPARTMENT(
    DEPT_NO   NUMBER, -- PK
    DEPT_NAME VARCHAR2(15 BYTE) NOT NULL,
    LOCATION  VARCHAR2(15 BYTE) NOT NULL
); 

CREATE TABLE EMPLOYEE(
    EMP_NO    NUMBER NOT NULL, --PK
    NAME      VARCHAR2(20 BYTE) NOT NULL,
    DEPART    NUMBER, --FK
    POSITION  VARCHAR2(20 BYTE),
    GENDER    CHAR(2),
    HIRE_DATE DATE,
    SALARY    NUMBER
);


ALTER TABLE DEPARTMENT
    ADD CONSTRAINT PK_DEPARTMENT PRIMARY KEY(DEPT_NO);
    
ALTER TABLE EMPLOYEE
    ADD CONSTRAINT PK_EMPLOYEE PRIMARY KEY(EMP_NO);

-- 외래키    
ALTER TABLE EMPLOYEE
    ADD CONSTRAINT FK_EMPLOYEE_DEPARTMENT FOREIGN KEY(DEPART) REFERENCES DEPARTMENT(DEPT_NO) ON DELETE SET NULL;
    
    
/*
    DML
    1. Data Mainpulation Language
    2. 데이터 조작어
    3. 행(Row, Record, Tuple) 단위 삽입 ,수정, 삭제
    4. 트랙잭션(작업) 완료를 위해 COMMIT이 필요
    5. 트랜잭션(작업) 취소를 위해 ROLLBACK 사용 가능
    6. 종류
        1)INSERT INTO VALUES
        2)UPDATE SET WHERE
        3)DELETE FROM WHERE        
*/
 
/*
    시퀀스
    
    1. SEQUENCE
    2. 일련번호를 생성하는 데이터베이스 객체
    3. 자동으로 증가하는 번호를 생성
    4. 기본키(PK)에서 주로 사용(인공키)
    5. NEXTVAL를 이용하면 새로운 번호가 생성
    6. CURRVAL를 이용하면 현재 번호를 확인
*/
 
 
/*
    시퀀스 생성 형식
    CREATE SEQUENCE 시퀀스_이름
        START WITH 시작값           -- 생략하면 1 , 생성 이후 수정 불가
        INCREMENT BY 증가값         -- 생략하면 1                                                                                                                 MINVALUE 최소값
         MAXVALUE 최대값
        CACHE사용유무               -- NOCACHE 권장
        CYCLE사용유무               -- 생략하면 NOCYCLE, PK에서 사용한다면 NOCYCLE
    
*/
 
 
 
-- 부서 테이블에서 사용할 부서_시퀀스
DROP SEQUENCE DEPARTMENT_SEQ;
CREATE SEQUENCE DEPARTMENT_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1    
    MAXVALUE 1100
    NOCACHE
    NOCYCLE;
 
/*   
 행 삽입
 1. 지정한 칼럼에 삽입
    INSERT INTO 테이블(칼럼1, 칼럼2)VALUES(값1,값2)
 2. 모든 칼럼에 데이터 삽입(칼럼 리스트 생략)
    INSERT INTO 테이블 VALUES(값1,값2)

*/

-- 부서 테이블에 행(Row) 삽입
-- 부모 테이블(관계에서 PK를 가진 테이블)에 먼저 삽입을 해야 함
INSERT INTO DEPARTMENT
    (DEPT_NO,DEPT_NAME,LOCATION) 
VALUES
    (DEPARTMENT_SEQ.NEXTVAL,'영업부', '대구');
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL, '인사부', '서울');
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME,LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL, '총무부', '대구');
INSERT INTO DEPARTMENT
    (DEPT_NO,DEPT_NAME, LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL, '기획부', '서울');    
-- 작업의 완료
COMMIT;

-- 사원 테이블에 행(ROW) 삽입
-- 자식 테이블(관계에서 FK를 가진 테이블)은 참조 무결성에 위배되지 않는 데이터만 삽입 가능
-- 부서(부서번호) - 사원(소속부서) 
-- PK             - FK
-- 1,2,3,4       - 1,2,3,4중 하나만 가능  // FK의 값은 PK값을 벗어나면 안된다.

DROP SEQUENCE EMPLOYEE_SEQ;
CREATE SEQUENCE EMPLOYEE_SEQ
    START WITH 1001
    NOCACHE;


INSERT INTO 
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL, '구창민', 1, '과장', 'M', '95/05/01', 5000000); --date 값은 '' 안에 /나 - 로 입력
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL, '김민서', 1, '사원', 'F', '17/09/01', 2000000);
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL, '이은영', 2, '부장', NULL, '90-09-01', 5500000); --빈값을 넣고 싶으면 NULL을 적어줌
INSERT INTO
    EMPLOYEE
VALUES 
    (EMPLOYEE_SEQ.NEXTVAL, '한성일', 2, '과장', 'M', '93-04-01', 5000000);

-- 오류가 발생하는 INSERT
-- INSERT는 실패하였으나 시퀀스의 번호는 사용했음
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL, '신현준', 5,'대리', 'M', '98-12-01', 3500000);

-- 정상 데이터 다시 INSERT
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL, '신현준', 3,'대리', 'M', '98-12-01', 3500000);

COMMIT;


/*******************************************/

DROP TABLE SAMPLE;

CREATE TABLE SAMPLE(
    NO1 NUMBER,
    NO2 NUMBER

);

DROP SEQUENCE SAMPLE_SEQ;
CREATE SEQUENCE SAMPLE_SEQ NOCACHE;

-- 최초 1번은 NEXTVAL를 사용해야 CURRVAL도 사용 가능함 
INSERT INTO SAMPLE(NO1) VALUES(SAMPLE_SEQ.CURRVAL);

-- NEXTVAL, CURRVAL 함께 사용
INSERT INTO SAMPLE(NO1, NO2) VALUES(SAMPLE_SEQ.NEXTVAL, SAMPLE_SEQ.CURRVAL);

COMMIT;



