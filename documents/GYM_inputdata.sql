insert into trainer
values(0,'�Ϲݻ����','-','-');
insert into trainer
values(tra_seq.nextval,'���ڱ浿','���̾�ƮPT','��');
insert into trainer
values(tra_seq.nextval,'ưư�Ѹ�','��Ȱ �� ��������PT','��');
insert into trainer
values(tra_seq.nextval,'�����̶�ġ','�����ɾ�PT','��');
insert into trainer
values(tra_seq.nextval,'�ٸ��ٱ輱��','ü������PT','��');
insert into trainer
values(tra_seq.nextval,'�ǰ���','����PT','��');
insert into trainer
values(tra_seq.nextval,'���ϵ�','�����PT','��');
insert into trainer
values(tra_seq.nextval,'�����ڷ�','��ŻPT','��');

select * from trainer;

insert into program
values(100,'�⺻����','�ⱸ��� �� Ŭ���� ���� ����',default);
insert into program
values(101,'PT����','���̾�ƮPT ��Ī ,�ⱸ��� �� Ŭ���� ���� ����',1);
insert into program
values(102,'PT����','��Ȱ PT ��Ī ,�ⱸ��� �� Ŭ���� ���� ����',2);
insert into program
values(103,'PT����','�����ɾ�PT ��Ī ,�ⱸ��� �� Ŭ���� ���� ����',3);
insert into program
values(104,'PT����','ü������PT ��Ī ,�ⱸ��� �� Ŭ���� ���� ����',4);
insert into program
values(105,'PT����','����PT ��Ī ,�ⱸ��� �� Ŭ���� ���� ����',5);
insert into program
values(106,'PT����','�����PT ��Ī ,�ⱸ��� �� Ŭ���� ���� ����',6);
insert into program
values(107,'PT����','��ŻPT ��Ī ,�ⱸ��� �� Ŭ���� ���� ����',7);

select * from PROGRAM;

insert into member(memno,memname,mememail,mempwd)
values(mem_seq.nextval,'������','admin@admin.com','admin');

select * from MEMBER;

insert into class
values(c_seq.nextval,'�ʶ��׽�','���ϳ�','10:30',20,20);
insert into class
values(c_seq.nextval,'�䰡','����ȫ','11:30',20,20);
insert into class
values(c_seq.nextval,'���Ǵ�','���ϳ���','12:30',20,20);

select * from class;
select * from attend;

commit;