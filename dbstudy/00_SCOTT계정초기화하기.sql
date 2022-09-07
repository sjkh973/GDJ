-- SCOTT 계정 초기화

-- 1. SCOTT 계정과 SCOTT 계정이 가지고 있는 객체(테이블 등)를 함께 제거한다.
DROP USER SCOTT CASCADE;

-- 2. SCOTT 계정을 만든다.
CREATE USER SCOTT IDENTIFIED BY TIGER;

-- 3. SCOTT 계정에 접속 및 객체 사용 권한을 부여한다.
GRANT CONNECT, RESOURCE TO SCOTT;
GRANT DBA TO SCOTT; -- 뷰 생성 등 모든 권한을 가짐




