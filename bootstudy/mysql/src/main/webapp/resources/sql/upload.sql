-- team 스키마 사용 
USE team;

-- 쿼리문 실행
-- 1. 단독 실행 : ctrl + enter
-- 2. 블록 실행 : 블록 잡고 ctrl + shift + enter
-- 3. 전체 실행 : ctrl + shift + enter

-- DROP TABLE
DROP TABLE IF EXISTS ATTACH;
DROP TABLE IF EXISTS UPLOAD;

-- 파일 첨부 정보


CREATE TABLE UPLOAD
(
    UPLOAD_NO INT NOT NULL AUTO_INCREMENT,  -- INT/BIG/INT/SMALLINT, AUTO_INCREMENT가 시퀀스 대체
    TITLE VARCHAR(100),   -- 제목
    CONTENT VARCHAR(100), -- 내용
    CREATE_DATE DATETIME,      -- 작성일
    MODIFY_DATE DATETIME,       -- 수정일
    CONSTRAINT PK_UPLOAD PRIMARY KEY(UPLOAD_NO) -- AUTO_INCREMENT를 사용하려면 PK 등록이 필수
);

CREATE TABLE ATTACH
(
    ATTACH_NO INT NOT NULL AUTO_INCREMENT,     -- INT/BIG/INT/SMALLINT, AUTO_INCREMENT가 시퀀스 대체
    PATH VARCHAR(300),       -- 파일의 경로
    ORIGIN VARCHAR(300),     -- 파일의 원래 이름
    FILESYSTEM VARCHAR(42),  -- 파일의 저장된 이름
    DOWNLOAD_CNT INT,           -- 다운로드 횟수
    HAS_THUMBNAIL SMALLINT,     -- 썸네일이 있으면 1, 없으면 0
    UPLOAD_NO INT,              -- 게시글번호, FK
	CONSTRAINT PK_ATTACH PRIMARY KEY(ATTACH_NO),
    CONSTRAINT FK_ATTACH_UPLOAD FOREIGN KEY(UPLOAD_NO) REFERENCES UPLOAD(UPLOAD_NO) ON DELETE CASCADE
);






