-- 문자열 함수


-- 1. 대소문자 변환
--    1) UPPER(칼럼)   : 칼럼의 데이터를 모두 대문자로 변환
--    2) LOWER(칼럼)   : 칼럼의 데이터를 모두 소문자로 변환
--    3) INITCAP(칼럼) : INITIAL CAPITAL, 첫 글자는 대문자 나머지는 소문자로 변환
SELECT
       EMAIL
     , UPPER(EMAIL)
     , LOWER(EMAIL)
     , INITCAP(EMAIL)
  FROM
       EMPLOYEES;

-- FIRST_NAME 칼럼에서 'JAMES' 조회하기
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME
  FROM EMPLOYEES
 WHERE FIRST_NAME = INITCAP('JAMES');


-- 2. 길이
--    1) LENGTH(칼럼)  : 칼럼 데이터의 글자 수 반환
--    2) LENGTHB(칼럼) : 칼럼 데이터의 바이트 수 반환
SELECT
       LENGTH('HELLO'), LENGTHB('HELLO')
     , LENGTH('안녕'),  LENGTHB('안녕')
  FROM
       DUAL;


-- 3. 연결
--    1) || 연산자
--    2) CONCAT(A, B) : A와 B를 연결
--       (1) CONCAT 함수의 인수(arguments)는 2개만 지원
--       (2) A와 B와 C의 연결
--           ① CONCAT(A, B, C)         : 불가능함
--           ② CONCAT(CONCAT(A, B), C) : 가능함
SELECT
       FIRST_NAME || ' ' || LAST_NAME AS FULL_NAME
     , CONCAT(CONCAT(FIRST_NAME, ' '), LAST_NAME) AS FULL_NAME
  FROM
       EMPLOYEES;


-- 4. 일부 반환
--    SUBSTR(칼럼, BEGIN, LENGTH)
--    칼럼 데이터의 BEGIN 위치부터 LENGTH개만큼 반환
--    BEGIN은 인덱스가 아님(BEGIN은 1부터 시작함)
SELECT
       SUBSTR(FIRST_NAME, 1, 3)  -- 1번째 글자부터 3글자를 가져옴
  FROM
       EMPLOYEES;


-- 5. 특정 문자열의 위치 반환
--    INSTR(칼럼, 찾을문자열)
--    반환되는 위치는 인덱스가 아님(1부터 시작함)
--    찾는 문자열이 없으면 0을 반환
SELECT
       INSTR(EMAIL, 'A')  -- 'A'의 위치를 반환
  FROM
       EMPLOYEES;


-- 6. 문자열 채우기(PADDING)
--    1) LPAD(칼럼, 전체폭, 채울문자)
--    2) RPAD(칼럼, 전체폭, 채울문자)
SELECT
       LPAD(DEPARTMENT_ID, 3, 0)  -- 왼쪽에 0을 채워서 3자리로 조회
     , LPAD(NVL(DEPARTMENT_ID, 0), 3, 0)
  FROM
       EMPLOYEES;

SELECT
       RPAD(SUBSTR(EMAIL, 1, 2), 5, '*')  -- 오른쪽에 *를 채워서 5자리로 조회
  FROM
       EMPLOYEES;


-- 7. 공백 제거
--    1) LTRIM(칼럼) : 칼럼 데이터의 왼쪽 공백 제거
--    2) RTRIM(칼럼) : 칼럼 데이터의 오른쪽 공백 제거
--    3) TRIM(칼럼)  : 칼럼 데이터의 양쪽 공백 제거
SELECT
       LENGTH(LTRIM('   HELLO'))
     , LENGTH(RTRIM('HELLO   '))
     , LENGTH(TRIM('   HELLO   '))
  FROM
       DUAL;