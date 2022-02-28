/* Ʈ���̳� */
DROP TABLE Trainer 
	CASCADE CONSTRAINTS;

/* ���α׷� */
DROP TABLE Program 
	CASCADE CONSTRAINTS;

/* �⼮��� */
DROP TABLE attend 
	CASCADE CONSTRAINTS;
	
/* Ŭ���� */
DROP TABLE Class 
	CASCADE CONSTRAINTS;
	
/* ȸ�� */
DROP TABLE Member 
	CASCADE CONSTRAINTS;

/* ��û */
DROP TABLE Submit
	CASCADE CONSTRAINTS;

/* Ʈ���̳� */
CREATE TABLE Trainer (
	traNo NUMBER NOT NULL, /* Ʈ���̳ʹ�ȣ */
	traName VARCHAR2(50), /* Ʈ���̳ʸ� */
	traMajor VARCHAR2(50), /* ��Ī�о� */
	traGender VARCHAR2(10) /* ���� */
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
		
/* ���α׷� */
CREATE TABLE Program (
	ProgNo NUMBER NOT NULL, /* ���α׷���ȣ */
	ProgName VARCHAR2(100) NOT NULL, /* �̸� */
	ProgDetail VARCHAR2(100), /* ���� */
	traNo NUMBER /* Ʈ���̳ʹ�ȣ */
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
		
/* �⼮��� */
CREATE TABLE attend (
	attno NUMBER NOT NULL, /* ��Ϲ�ȣ */
	attdate Date, /* ��¥ */
	memNo NUMBER /* ȸ����ȣ */
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
		
/* Ŭ���� */
CREATE TABLE Class (
	ClassNo NUMBER NOT NULL, /* Ŭ������ȣ */
	ClassName VARCHAR2(50), /* ���¸� */
	teacher VARCHAR2(50), /* ���� */
	time VARCHAR2(50), /* �ð� */
	limit NUMBER DEFAULT 20, /* �����ο� */
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
		
/* ȸ�� */
CREATE TABLE Member (
	memNo NUMBER NOT NULL, /* ȸ����ȣ */
	memName VARCHAR2(50) NOT NULL, /* �̸� */
	memEmail VARCHAR2(100) NOT NULL, /* �̸��� */
	memPwd VARCHAR2(50) NOT NULL, /* ��й�ȣ */
	memTel VARCHAR2(50), /* ��ȭ��ȣ */
	memZip VARCHAR2(100), /* �����ȣ */
	memAddr VARCHAR2(100), /* �ּ� */
	memAddrDetail VARCHAR2(100), /* ���ּ� */
	memRegdate Date DEFAULT sysdate,
	ProgNo NUMBER /* ���α׷���ȣ */
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

/* ��û */
CREATE TABLE Submit (
	subno NUMBER NOT NULL, /* ��û��ȣ */
	ClassNo NUMBER NOT NULL, /* Ŭ������ȣ */
	memNo NUMBER NOT NULL /* ȸ����ȣ */
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