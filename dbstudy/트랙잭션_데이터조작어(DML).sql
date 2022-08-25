--데이터 조작어 (DML)

--ROW 데이터 삽입하거나 기존데이터를 갱신 또는 수정 

--INSERT
--INSERT INTO TABLE(COLUMN) VALUES(VALUE);
--UPDATE
--UPDATE TABLE SET CONTENT WHERE CONDITION;
--DELETE
--DELETE FORM TABLE WHERE CONDITION;

INSERT INTO EVENT(E_CODE,E_NAME) VALUES(1,'김주성');

UPDATE EVENT SET E_NAME = 'ㅋㅋㅋ' WHERE E_CODE = 1; --WHERE가 들어가지 않으면 전체를 수정하는것 // SET 칼럼명 = 값1 , 칼럼명2 = 값2

DELETE EVENT WHERE E_CODE = 1; -- WHERE를 생략하면 전체 레코드를 다 지움

COMMIT;

--트랙잭션(TRANSACTION) 관리
--1. 데이터베이스에서 처리디는 여러 SQL 명령들을 하나의 논리적 작업 단위로
--처리하는것이다.
--2. 작업이 시작되면 중간에 멈추지 않고, 반드시 종료해야 하는 작업 단위이다.(은행 이체,프로그램 설치)
--3. 중간에 멈췌 되면 아무 일도 하지 않은 상태로 되돌아간다.
--
--
--트랜잭션 제어 명령
--
--1.COMMIT : 트랙잭션내의 모든 SQL문 실행 결과로 인해 변경된 작업 내용을 디스크에 영구적으로 저장하고 트랙재션 종료
--
--2. ROLLBACK : 트랜잭션내의 모든 SQL 문에 의해 변경된 작업 내용을 모두 취소하고 트랜잭션을 종료한다.
--
--트랜잭션이 필요한 SQL
--
--1. INSERT UPDATE DELETE : COMMIT 이필요하다.
--
--2. CREATE ALTER DROP TRUNCATE SELECT : COMMIT 이 필요하지 않다.

--DDL의 대상 : DB OBJECT (테이블,생성자) 자동커밋
--DML의 대상 : ROW 수동커밋



