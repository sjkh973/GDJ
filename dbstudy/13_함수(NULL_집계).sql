-- 함수 확인용 기초데이터
DROP TABLE SAMPLE;
CREATE TABLE SAMPLE(
    NAME VARCHAR2(20 BYTE),
    KOR NUMBER(3),
    ENG NUMBER(3),
    MATH NUMBER(3)
);
INSERT INTO SAMPLE(NAME,KOR,ENG,MATH) VALUES(NULL, 100, 100, 100);
INSERT INTO SAMPLE(NAME, KOR ,ENG, MATH) VALUES('영숙', NULL, 100, 100);
INSERT INTO SAMPLE(NAME, KOR, ENG, MATH) VALUES('정수', 100, NULL, 100);
INSERT INTO SAMPLE(NAME, KOR, ENG, MATH) VALUES('지영', 100, 100, NULL);
COMMIT;

-- NULL값이 연산에서 사용되면 결과가 NULL이다.
SELECT 1 + NULL FROM DUAL;

-- NULL 처리 함수
-- 1. NVL 함수(NULL VALUE)
--  NVL(칼럼, 칼럼값이 NULL일 때 대신 사용할 값)

-- NAME이 없으면 '아무개' , KOR,ENG,MATH가 없으면 0으로 조회
SELECT 
    NVL(NAME,'아무개') AS STU_NAME
   ,NVL(KOR, 0) 
   ,NVL(ENG, 0)
   ,NVL(MATH, 0)           -- 2

 FROM
    SAMPLE                 -- 1

ORDER BY 
    STU_NAME ASC;          -- 3
    
    
-- 이름과 총점을 조회하기
-- 이름이 없으면 '아무개', 점수가 없으면 0점
-- 결과
-- 아무개 300
-- 영숙 200
-- 정수 200
-- 지영 200
SELECT 
    NVL(NAME,'아무개') AS STU_NAME
   ,NVL(KOR,0) 
   ,NVL(ENG,0)
   ,NVL(MATH,0)
   , KOR + ENG + MATH AS TOTAL
 FROM
    SAMPLE;

-- 2. NVL2 함수
--    NVL2(칼럼, NULL이 아닐 때 사용할 값, NULL일 때 사용할 값)

SELECT 
   NVL2(NAME,NAME || '님', '아무개')  -- || 는 + 
  ,NVL2(KOR,'응시','결시')
  ,NVL2(ENG,'응시', '결시')
  ,NVL2(MATH,'응시', '결시')
  FROM
    SAMPLE;
        
    
-- 집계함수 (그룹함수)
-- 1. 통계(합계,평균, 최대, 최소, 개수 등)를 낼 때 사용
-- 2. NULL값을 연산에서 제외
-- 3. 종류
--  1) SUM(칼럼)   : 칼럼 합계
--  2) AVG(칼럼)   : 칼럼 평균
--  3) MAX(최대)   : 칼럼 최대값
--  4) MIN(최소)   : 칼럼 최소값
--  5) COUNT(칼럼) : 칼럼에 입력된 데이터의 개수
    
-- 각 칼럼(KOR, ENG, MATH)의 합계
-- ROM 단위의 더하기가 아님
SELECT
       SUM(KOR)  -- 국어합
      ,SUM(ENG)  -- 영어합
      ,SUM(MATH) -- 수학합
--    ,SUM(KOR, ENG, MATH) 인수(ARGUMENTS)가 3개이므로 불가능함(인수 1개여야 함)
      ,SUM(KOR + ENG + MATH) -- KOR + ENG + MATH와 같은 연산(SUM 함수를 잘못 사용한 예시)
      ,SUM(KOR) + SUM(ENG) + SUM(MATH) -- 국어합 + 영어합 + 수학합
    FROM
         SAMPLE;
    
-- 각 칼럼(KOR, ENG, MATH)의 평균
SELECT 
    AVG(KOR)  --NULL 제외한 KOR의 평균
   ,AVG(ENG)  --NULL 제외한 ENG의 평균
   ,AVG(MATH) --NULL 제외한 MATH의 평균
  FROM
        SAMPLE;
    
-- NULL값은 결시를 의미하므로 0점 처리함
SELECT
        AVG(NVL(KOR,0))
       ,AVG(NVL(ENG,0))
       ,AVG(NVL(MATH,0))
  FROM
       SAMPLE;
     
-- 각 칼럼(KOR, ENG, MATH)의 최대값
SELECT
       MAX(KOR)
      ,MAX(ENG)
      ,MAX(MATH)
  FROM
       SAMPLE;


-- 각 칼럼(KOR, ENG, MATH)의 최소값
-- NULL값은 결시를 의미하므로 0점 처리함
SELECT
       MIN(NVL(KOR,0))
      ,MIN(NVL(ENG,0))
      ,MIN(NVL(MATH,0))
  FROM
      SAMPLE;
    
    
-- KOR 시험을 응시한 학생이 몇 명인가?
SELECT
       COUNT(KOR)       
  FROM
       SAMPLE;

-- 전체 학생 몇명인가? (전체 ROW의 개수)
-- 특정 칼럼을 지정하지 않고 전체 칼럼(*)을 이용해서 전체 Row 개수를 구함
SELECT
       COUNT(*)
  FROM
       SAMPLE;

-- 성명   국어 영어 수학 합계 평균
-- 아무개 100  100  100  300  100
-- 영숙   0    100  100  200  66.67
-- 정수   100    0  100  200  66.67
-- 지영   100  100    0  200  66.67 


SELECT
     NVL(NAME,'아무개') AS 성명
    ,NVL(KOR,0) AS 국어
    ,NVL(ENG,0) AS 영어
    ,NVL(MATH,0) AS 수학
    ,NVL(KOR,0) + NVL(ENG,0) +NVL(MATH,0) AS 합계
    ,(NVL(KOR,0) + NVL(ENG,0) +NVL(MATH,0)) / 3 AS 평균
   FROM
        SAMPLE;


