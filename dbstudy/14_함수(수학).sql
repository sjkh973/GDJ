-- 숫자 함수

/*
    1. 제곱
        POWER(A,B) A의 B제곱
*/
SELECT POWER(2,10) FROM DUAL;

-- 2. 제곱근(루트)
--    SQRT(A) : 루트 A
SELECT SQRT(25) FROM DUAL;

-- 3. 절대값
--    ABS(A) : A의 절대값
SELECT ABS(5), ABS(-5) FROM DUAL;

-- 4. 나머지
--    MOD(A,B) : A를 B로 나눈 나머지
SELECT MOD(7,2) FROM DUAL;

-- 5. 부호 판별
-- SIGN(A) : A가 양수면 1, 음수면 -1, 0이면 0을 반환
SELECT SIGN(5), SIGN(-5), SIGN(0) FROM DUAL;

--6. 정수로 올림
--     CEIL(A) : 실수 A를 정수로 올림
SELECT CEIL(1.1), CEIL(-1.1) FROM DUAL;

-- 7. 정수로 내림
--    FLOOR(A) : 실수 A를 정수로 내림
SELECT FLOOR(1.1), FLOOR(-1.1) FROM DUAL;

-- 8. 원하는 자릿수로 절사
--    TRUNC(A, [DIGIT]) : 실수 A를 DIGIT 자릿수로 절사, DIGIT 생략하면 정수로 절사, DIGIT 생략하면 정수로 절사
SELECT
    TRUNC(1.9999)   --1
   ,TRUNC(1.9999, 1)   --1.9
   ,TRUNC(1.9999, 2)  -- 1.99
 FROM 
      DUAL;
      
SELECT
        TRUNC(9999, -1) -- 9990 (원 단위 절사)
       ,TRUNC(9999, -2) -- 9900 
   FROM 
        DUAL;
-- 9. 원하는 자릿수로 반올림
--    ROUND(A, [DIGIT]) : 실수 A를 DIGIT 자릿수로 반올림, DIGIT 생략하면 정수로 절사, DIGIT 생략하면 정수로 반올림
SELECT
       ROUND(145.45), --45
       ROUND(145.45, 1), --145.5
       ROUND(145.45, -1) --150
  FROM
    DUAL;

-- 문제 발생

-- 1. 원하는 자릿수로 올림 
--                                            DIGIT
--    1) 소수 1자리 : CEIL(값 * 10)   / 10      1
--    2) 소수 2자리 : CEIL(값 * 100)  / 100     2
--    3) 소수 3자리 : CEIL(값 * 1000) / 1000    3
--    4) 정수       : CEIL(값 * 1)    /1        0
--    5) 일의자리   : CEIL(값 * 0.1)  /0.1      -1
--    6) 십의자리   : CEIL(값 * 0.01) /0.01     -2
--    7) 백의자리   : CEIL(값 * 0.001) /0.001   -3 
--    일반화        : CEIL(값 * POWER(10,DIGIT)) / POWER(10,DIGIT)
SELECT
        CEIL(1.111 * POWER(10,1))  / POWER(10, 1)   -- 1.2
       ,CEIL(1.111 * POWER(10,2))  / POWER(10, 2)   -- 1.12
       ,CEIL(11111 * POWER(10,-1)) / POWER(10, -1) -- 11120
       ,CEIL(11111 * POWER(10,-2)) / POWER(10, -2) -- 11200
  FROM 
       DUAL;
-- 2. 원하는 자릿수로 내림
-- CEIL 대신 FLOOR 함수를 사용하면 됨
