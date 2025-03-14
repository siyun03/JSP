CREATE TABLE MYBATISUSER (
	SID NUMBER PRIMARY KEY,
	PASSWD VARCHAR2(200) NOT NULL,
	NAME NVARCHAR2(100) NOT NULL,
	EMAIL VARCHAR2(200)
);

CREATE SEQUENCE SEQ_MYBATISUSER;

SELECT *
FROM MYBATISUSER;


CREATE TABLE AUTHOR (
	ID NUMBER PRIMARY KEY,
	USERNAME NVARCHAR2(200),
	PASSWORD NVARCHAR2(200),
	EMAIL NVARCHAR2(200),
	BIO NVARCHAR2(200),
	FAVOURITE_SECTION NVARCHAR2(200)
);
DROP TABLE AUTHOR CASCADE CONSTRAINTS;

CREATE SEQUENCE SEQ_AUTHOR;

CREATE TABLE BLOG (
	ID NUMBER PRIMARY KEY,
	TITLE NVARCHAR2(200),
	BLOG_AUTHOR_ID NUMBER,
	FOREIGN KEY (BLOG_AUTHOR_ID) REFERENCES AUTHOR(ID)
);

CREATE SEQUENCE SEQ_BLOG;

CREATE TABLE POST (
	ID NUMBER PRIMARY KEY,
	CREATED_ON TIMESTAMP,
	SECTION NVARCHAR2(200),
	SUBJECT NVARCHAR2(200),
	DRAFT NUMBER,
	BODY NVARCHAR2(200),
	BLOG_ID NUMBER,
	POST_AUTHOR_ID NUMBER,
	FOREIGN KEY (BLOG_ID) REFERENCES BLOG(ID),
	FOREIGN KEY (POST_AUTHOR_ID) REFERENCES AUTHOR(ID)
);

CREATE SEQUENCE SEQ_POST;

CREATE TABLE TAG (
	ID NUMBER PRIMARY KEY,
	NAME NVARCHAR2(200),
	POST_ID NUMBER,
	FOREIGN KEY (POST_ID) REFERENCES POST(ID)
);

CREATE SEQUENCE SEQ_TAG;

CREATE TABLE CMT (
	ID NUMBER PRIMARY KEY,
	NAME NVARCHAR2(200),
	CMT NVARCHAR2(2000),
	POST_ID NUMBER,
	FOREIGN KEY (POST_ID) REFERENCES POST(ID)
);

CREATE SEQUENCE SEQ_CMT;