/* 트레이너 */
DROP TABLE Trainer 
	CASCADE CONSTRAINTS;

/* 프로그램 */
DROP TABLE Program 
	CASCADE CONSTRAINTS;

/* 출석기록 */
DROP TABLE attend 
	CASCADE CONSTRAINTS;
	
/* 클래스 */
DROP TABLE Class 
	CASCADE CONSTRAINTS;
	
/* 회원 */
DROP TABLE Member 
	CASCADE CONSTRAINTS;

/* 신청 */
DROP TABLE Submit
	CASCADE CONSTRAINTS;

/* 트레이너 */
CREATE TABLE Trainer (
	traNo NUMBER NOT NULL, /* 트레이너번호 */
	traName VARCHAR2(50), /* 트레이너명 */
	traMajor VARCHAR2(50), /* 코칭분야 */
	traGender VARCHAR2(10) /* 성별 */
);

drop sequence tra_seq;

create sequence tra_seq
increment by 1
start with 1
nocache;

CREATE UNIQUE INDEX PK_Trainer
	ON Trainer (
		traNo ASC
	);

ALTER TABLE Trainer
	ADD
		CONSTRAINT PK_Trainer
		PRIMARY KEY (
			traNo
		);
		
/* 프로그램 */
CREATE TABLE Program (
	ProgNo NUMBER NOT NULL, /* 프로그램번호 */
	ProgName VARCHAR2(100) NOT NULL, /* 이름 */
	ProgDetail VARCHAR2(100), /* 설명 */
	traNo NUMBER /* 트레이너번호 */
);

CREATE UNIQUE INDEX PK_Program
	ON Program (
		ProgNo ASC
	);

ALTER TABLE Program
	ADD
		CONSTRAINT PK_Program
		PRIMARY KEY (
			ProgNo
		);
		
/* 출석기록 */
CREATE TABLE attend (
	attno NUMBER NOT NULL, /* 기록번호 */
	attdate Date, /* 날짜 */
	memNo NUMBER /* 회원번호 */
);

drop sequence att_seq;

create sequence att_seq
increment by 1
start with 1
nocache;

CREATE UNIQUE INDEX PK_attend
	ON attend (
		attno ASC
	);

ALTER TABLE attend
	ADD
		CONSTRAINT PK_attend
		PRIMARY KEY (
			attno
		);
		
/* 클래스 */
CREATE TABLE Class (
	ClassNo NUMBER NOT NULL, /* 클래스번호 */
	ClassName VARCHAR2(50), /* 강좌명 */
	teacher VARCHAR2(50), /* 강사 */
	time VARCHAR2(50), /* 시간 */
	limit NUMBER DEFAULT 20, /* 수강인원 */
	left NUMBER
);

drop sequence c_seq;

create sequence c_seq
increment by 1
start with 200
nocache;

CREATE UNIQUE INDEX PK_Class
	ON Class (
		ClassNo ASC
	);

ALTER TABLE Class
	ADD
		CONSTRAINT PK_Class
		PRIMARY KEY (
			ClassNo
		);
		
/* 회원 */
CREATE TABLE Member (
	memNo NUMBER NOT NULL, /* 회원번호 */
	memName VARCHAR2(50) NOT NULL, /* 이름 */
	memEmail VARCHAR2(100) NOT NULL, /* 이메일 */
	memPwd VARCHAR2(50) NOT NULL, /* 비밀번호 */
	memTel VARCHAR2(50), /* 전화번호 */
	memZip VARCHAR2(100), /* 우편번호 */
	memAddr VARCHAR2(100), /* 주소 */
	memAddrDetail VARCHAR2(100), /* 상세주소 */
	memRegdate Date DEFAULT sysdate,
	ProgNo NUMBER /* 프로그램번호 */
);

drop sequence mem_seq;

create sequence mem_seq
increment by 1
start with 1000;

CREATE UNIQUE INDEX PK_Member
	ON Member (
		memNo ASC
	);

ALTER TABLE Member
	ADD
		CONSTRAINT PK_Member
		PRIMARY KEY (
			memNo
		);

/* 신청 */
CREATE TABLE Submit (
	subno NUMBER NOT NULL, /* 신청번호 */
	ClassNo NUMBER NOT NULL, /* 클래스번호 */
	memNo NUMBER NOT NULL /* 회원번호 */
);

drop sequence sub_seq;

create sequence sub_seq
increment by 1
start with 1;

CREATE UNIQUE INDEX PK_Submit
	ON Submit (
		subNo ASC
	);

ALTER TABLE Submit
	ADD
		CONSTRAINT PK_Submit
		PRIMARY KEY (
			subNo
		);

ALTER TABLE Member
	ADD
		CONSTRAINT FK_Program_TO_Member
		FOREIGN KEY (
			ProgNo
		)
		REFERENCES Program (
			ProgNo
		);

ALTER TABLE Program
	ADD
		CONSTRAINT FK_Trainer_TO_Program
		FOREIGN KEY (
			traNo
		)
		REFERENCES Trainer (
			traNo
		);

ALTER TABLE Submit
	ADD
		CONSTRAINT FK_Member_TO_Submit
		FOREIGN KEY (
			memNo
		)
		REFERENCES Member (
			memNo
		);


commit;