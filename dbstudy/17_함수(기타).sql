-- 1. 순위
--    1) RANK() OVER(ORDER BY 순위구할칼럼 ASC) : 오름차순 순위, 낮은 값이 1등, ASC는 생략 가능
--    2) RANK() OVER(ORDER BY 순위구할칼럼 DESC) : 내림차순 순위, 높은 값이 1등
--    3) 같은 값이면 같은 등수(동점)로 처리

-- 1) EMPLOYEES 테이블의 사원 정보를 연봉이 높은 순으로 조회화기
--    연봉 순위를 함께 조회하기
SELECT 
       RANK() OVER(ORDER BY SALARY DESC) AS 연봉순위
     , EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , SALARY
  FROM 
        EMPLOYEES;
        
-- 2) EMPLOYEES 테이블의 사원 정보를 입사순으로 조회하기
--    먼저 입사한 사원이 1등
SELECT 
       RANK() OVER(ORDER BY HIRE_DATE ASC) AS 입사순위
     , EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , HIRE_DATE
  FROM
       EMPLOYEES;
       
       
-- 2. 그룹화
--    OVER(PARTITION BY 그룹화 칼럼)
--    그룹화작업을 수행하므로 집계함수(그룹함수)와 함께 사용이 가능함
SELECT 
       DISTINCT DEPARTMENT_ID 
      ,SUM(SALARY) OVER(PARTITION BY DEPARTMENT_ID) AS 부서별연봉합계 
      ,FLOOR(AVG(SALARY) OVER(PARTITION BY DEPARTMENT_ID)) AS 부서별연봉평균
      ,MAX(SALARY) OVER(PARTITION BY DEPARTMENT_ID) AS 부서별최대연봉
      ,MIN(SALARY) OVER(PARTITION BY DEPARTMENT_ID) AS 부서별최대연봉
      ,COUNT(*)    OVER(PARTITION BY DEPARTMENT_ID) AS 부서별사원수
  FROM 
        EMPLOYEES
 WHERE 
       DEPARTMENT_ID IS NOT NULL;
     
     
--  RANK() 함수와 PARTITION BY를 함께 사용하면 그룹 내 순위 구하기 가능함
SELECT
        RANK() OVER(PARTITION BY DEPARTMENT_ID ORDER BY SALARY DESC) AS 부서내연봉순위
       , EMPLOYEE_ID
       , FIRST_NAME
       , LAST_NAME
       , SALARY
       , DEPARTMENT_ID
  FROM 
        EMPLOYEES      
 ORDER BY 
          DEPARTMENT_ID ASC;
          
-- 3. 분기 처리(IF)
--    DECODE(표현식
--        , 값1, 결과1
--        , 값2, 결과2
--        , 값3, 결과3          
--        , ...)
--    표현식의 결과가 값1이면 결과1 반환, 값2이면 결과2 반환, ...
--    표현식의 결과와 값의 비교는 동등 비교(=)만 가능함

-- JOIN 없이 EMPLOYEES 테이블만 이용하여 EMPLOYEE_ID, DEPARTMENT_NAME 조회하기
SELECT
        EMPLOYEE_ID
       ,DECODE(DEPARTMENT_ID
         , 10, 'Administration'
         , 20, 'Marketing'
         , 30, 'Purchasing'
         , 40, 'Human Resources'
         , 50, 'Shipping'
         , 60, 'IT') AS부서명  
  FROM
       EMPLOYEES;
         
-- PHONE_NUMBER REGION
-- 011          MOBILE
-- 515          EAST
-- 590          WEST
-- 603          SOUTH
-- 650          NORTH
SELECT
      EMPLOYEE_ID  
      ,PHONE_NUMBER
      ,DECODE(SUBSTR(PHONE_NUMBER, 1,3)
         ,011, 'MOBILE'
         ,515, 'EAST'
         ,590, 'WEST'
         ,603, 'SOUTH'
         ,650, 'NORTH') AS REGION
        
  FROM
        EMPLOYEES;
  
-- 4. 분기 표현식
-- CASE 
--      WHEN 조건식 THEN 결과값1
--      WHEN 조건식 THEN 결과값2
--      ...
--      ELSE 결과값N
-- END

-- SALARY < 10000 : C
-- SALARY < 20000 : B
-- SALARY >= 20000 : A

SELECT 
        EMPLOYEE_ID
       ,SALARY
       , CASE
              WHEN SALARY < 10000 THEN 'C'
              WHEN SALARY < 20000 THEN 'B'
              ELSE 'A'
         END AS 구분
  FROM 
        EMPLOYEES;

-- EMPLOYEE_ID, HIRE_DATE(YYYY-MM-DD), 근무개월수, 퇴직금정산대상유무
-- 퇴직금정산대상 : 근무개월수가 240개월 이상이면 '정산대상', 아니면 빈 문자열 - > CASE END 함수
SELECT
        EMPLOYEE_ID AS 사원번호,
        TO_CHAR(HIRE_DATE,'YYYY-MM-DD') AS 고용일,
        FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) AS 근무개월수,
        CASE
             WHEN MONTHS_BETWEEN(SYSDATE, HIRE_DATE) >= 240 THEN '정산대상'
             ELSE ' '
        END AS 퇴직금정산대상     
  FROM
        EMPLOYEES;
          
          
          
          

