insert into trainer
values(0,'일반사용자','-','-');
insert into trainer
values(tra_seq.nextval,'날쌘길동','다이어트PT','남');
insert into trainer
values(tra_seq.nextval,'튼튼둘리','재활 및 통증개선PT','여');
insert into trainer
values(tra_seq.nextval,'멋쟁이또치','웨딩케어PT','남');
insert into trainer
values(tra_seq.nextval,'바르다김선생','체형교정PT','여');
insert into trainer
values(tra_seq.nextval,'건강인','산후PT','남');
insert into trainer
values(tra_seq.nextval,'나일등','운동선수PT','여');
insert into trainer
values(tra_seq.nextval,'정다자래','토탈PT','남');

select * from trainer;

insert into program
values(100,'기본사용권','기구사용 및 클래스 수강 가능',default);
insert into program
values(101,'PT사용권','다이어트PT 코칭 ,기구사용 및 클래스 수강 가능',1);
insert into program
values(102,'PT사용권','재활 PT 코칭 ,기구사용 및 클래스 수강 가능',2);
insert into program
values(103,'PT사용권','웨딩케어PT 코칭 ,기구사용 및 클래스 수강 가능',3);
insert into program
values(104,'PT사용권','체형교정PT 코칭 ,기구사용 및 클래스 수강 가능',4);
insert into program
values(105,'PT사용권','산후PT 코칭 ,기구사용 및 클래스 수강 가능',5);
insert into program
values(106,'PT사용권','운동선수PT 코칭 ,기구사용 및 클래스 수강 가능',6);
insert into program
values(107,'PT사용권','토탈PT 코칭 ,기구사용 및 클래스 수강 가능',7);

select * from PROGRAM;

insert into member(memno,memname,mememail,mempwd)
values(mem_seq.nextval,'관리자','admin@admin.com','admin');

select * from MEMBER;

insert into class
values(c_seq.nextval,'필라테스','강하나','10:30',20,20);
insert into class
values(c_seq.nextval,'요가','박지홍','11:30',20,20);
insert into class
values(c_seq.nextval,'스피닝','강하나둘','12:30',20,20);

select * from class;
select * from attend;

commit;