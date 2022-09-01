/*
    인덱스
    
    1. INDEX
    2. 빠른 검색을 위해서 특정 칼럼에 인덱스를 등록함
    3. 인덱스가 등록된 칼럼은 검색이 빠름
    4. 인덱스가 자동으로 등록되는 경우
        1) PK로 지정한 칼럼
        2) UNIQUE가 제약조건을 가진 칼럼
    5. 수정(갱신)이 자주 발생하는 칼럼에 인덱스를 부여하면 도리어 성능이 떨어짐
    6. 인덱스 생성
        1) 비보유 인덱스(칼럼 내용에 중복이 있는 경우)
           CREATE INDEX 인덱스_이름 ON 테이블_이름(칼럼_이름);
        2) 고유 인덱스(칼럼 내용에 중복이 없는 경우)
            CREATE UNIQUE 인덱스 이름 ON 테이블_이름(칼럼_이름);
            
*/

-- 인덱스 조회
-- 사용자가 작성한 인덱스는 USER_INDEXES 데이터 사전에서 확인
-- 
DESC USER_INDEXES;
SELECT INDEX_NAME, TABLE_NAME
  FROM USER_INDEXES;
  
-- 인덱스 칼럼 조회
-- 사용자가 작성한 인덱스가 동작하는 칼럼 확인은 USER_IDN_COLUMNS 데이터 사전에서 확인
DESC USER_IND_COLUMNS;
  
-- 인덱스 생성
CREATE INDEX IDX_NAME ON EMPLOYEE(NAME);

DROP INDEX IDX_NAME;

/*
    
    CODE는 PK고 VARCHAR2 타입일때
    WHERE CODE = '1' <- 정상동작
    WHERE CODE = 1 < - 동작은 하지만 내부동작으로 인해 TO_NUMBER(CODE)가 됨
    
    WHERE TO_NUMBER(CODE) = 1 (내부동작)
    TO_NUMBER() 함수로 인해 CODE의 인덱스를 사용할 수 없음
    WHERE 절 작성 시 가급적 등호 왼쪽은 가공안하는 것이 좋다.
*/