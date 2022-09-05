/*
    사용자 함수
  
    1. Function
    2. 어떤 값을 반환할 때 사용
    3. 사용자가 만든 함수의 개념
    4. 값을 반환할 때 RETURN을 사용
    5. 입력 파라미터 사용 가능(출력 파라미터 사용 안함)
    6. 값을 확인할 수 있도록 SELECT문과 같은 쿼리문에서 호출
    7. 형식
        CREATE [OR REPLACE] FUNCTION 함수_이름[(매개변수)]
        RETURN 반환타입
        IS
            변수선언
        BEGIN
            함수본문
         [EXCEPTION]
        END [함수_이름]; 
*/    


-- 함수 FUNC1 정의
CREATE OR REPLACE FUNCTION FUNC1
RETURN VARCHAR2 -- 반환타입에서는 크기를 명시하지 않음
IS
BEGIN
    RETURN 'HELLO WORLD'; -- 반환값
END FUNC1;    

-- 함수 FUNC1 호출


SELECT FUNC1
  FROM DUAL;  




-- 함수 FUNC2 정의
-- 사원번호를 전달하면 해당 사원의 FULL_NAME이 반환되는 함수
CREATE OR REPLACE FUNCTION FUNC2(EMP_ID EMPLOYEES.EMPLOYEE_ID%TYPE)
RETURN VARCHAR2
IS
    FNAME EMPLOYEES.FIRST_NAME%TYPE;
    LNAME EMPLOYEES.LAST_NAME%TYPE;
BEGIN
    SELECT FIRST_NAME, LAST_NAME
      INTO FNAME, LNAME
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = EMP_ID;
     RETURN FNAME || ' ' || LNAME;
END FUNC2;     
    
-- 함수 FUNC2 호출
SELECT FUNC2(EMPLOYEE_ID) AS FULL_NAME
  FROM EMPLOYEES;


-- 함수 FUNC3 정의
-- 연봉을 전달하면 'A그룹', 'B그룹', 'C그룹'을 반환하는 함수
-- 15000 이상 : A그룹
-- 8000 이상  : B그룹
-- 나머지     : C그룹
CREATE OR REPLACE FUNCTION FUNC3(SAL EMPLOYEES.SALARY%TYPE)
RETURN VARCHAR2
IS
     RESULT VARCHAR2(10 BYTE);
BEGIN
        IF SAL >= 15000 THEN
         RESULT:= 'A그룹';
        ELSIF SAL >= 8000 THEN
            RESULT := 'B그룹';
        ELSE
            RESULT := 'C그룹';
        END IF;
RETURN RESULT;        
END;        


-- 함수 FUNC3 호출
SELECT EMPLOYEE_ID
      ,FIRST_NAME
      ,LAST_NAME
      ,SALARY
      ,FUNC3(SALARY)
  FROM EMPLOYEES;    



-- 함수 MY_CEIL 정의
CREATE OR REPLACE FUNCTION MY_CEIL(N NUMBER, DIGIT NUMBER)
RETURN NUMBER
IS
BEGIN
     
    RETURN CEIL(N * POWER(10, DIGIT)) / POWER(10, DIGIT);
END MY_CEIL;    
    
-- 함수 MY_CEIL 호출

SELECT CEIL(1.123) -- 정수로 올림
      ,MY_CEIL(1.123, 2)  -- 소수2자리 올림
      ,MY_CEIL(1.123, 1)  -- 소수1자리 올림
      ,MY_CEIL(1.123, 0)  -- 정수로 올림
      ,MY_CEIL(1.123, 1)  -- 일의자리 올림
      ,MY_CEIL(1.123, 0)  -- 십의자리 올림
  FROM DUAL;    
    
    
    
-- 함수 MY_FLOOR 정의
CREATE OR REPLACE FUNCTION MY_FLOOR(N NUMBER, DIGIT NUMBER)
RETURN NUMBER
IS
BEGIN
    RETURN FLOOR(N * POWER(10, DIGIT)) / POWER(10, DIGIT);
END MY_FLOOR;

-- 함수 MY_FLOOR 호출
SELECT FLOOR(1.123)        -- 정수로 내림
     , MY_FLOOR(1.123, 2)  -- 소수2자리 내림
     , MY_FLOOR(1.123, 1)  -- 소수1자리 내림
     , MY_FLOOR(1.123, 0)  -- 정수로 내림
     , MY_FLOOR(1234, -1)  -- 일의자리 내림
     , MY_FLOOR(1234, -2)  -- 십의자리 내림
  FROM DUAL;


