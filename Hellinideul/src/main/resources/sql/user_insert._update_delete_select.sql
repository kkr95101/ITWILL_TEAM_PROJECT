DROP TABLE user_info CASCADE CONSTRAINTS;

CREATE TABLE user_info(
		u_id                          		VARCHAR2(20)		 NULL ,
		u_pw                          		VARCHAR2(20)		 NULL ,
		u_name                        		VARCHAR2(50)		 NULL ,
		u_phone                       		VARCHAR2(50)		 NULL ,
		u_email                       		VARCHAR2(50)		 NULL ,
		u_address                     		VARCHAR2(100)		 NULL 
);

insert into user_info values('aaa', 'aaa', '권경록', '010-1111-1111', 'aaa@gmail.com', '서울시 강남구');
insert into user_info values('bbb', 'bbb', '김숙현', '010-2222-2222', 'bbb@gmail.com', '서울시 광진구');
insert into user_info values('ccc', 'ccc', '이동현', '010-3333-3333', 'ccc@gmail.com', '서울시 강서구');
insert into user_info values('ddd', 'ddd', '이다영', '010-4444-4444', 'ddd@gmail.com', '서울시 강북구');
insert into user_info values('eee', 'eee', '이승현', '010-5555-5555', 'eee@gmail.com', '경기도 안양시');
insert into user_info values('fff', 'fff', '이승규', '010-6666-6666', 'fff@gmail.com', '경기도 성남시');
insert into user_info values('ggg', 'ggg', '배종호', '010-7777-7777', 'ggg@gmail.com', '경기도 용인시');
INSERT INTO user_info VALUES ('o3o', 'q1w2e3r4~', '홍길동', '010-4555-8484', 'o3o@gmail.com', '서울시 종로구');
INSERT INTO user_info VALUES ('lokoio1122', 'q1w2e3r4~', '김항일', '010-5587-8484', 'lokoio1122@gmail.com', '서울시 강남구');
INSERT INTO user_info VALUES ('crown1212', 'q1w2e3r4~', '김이동', '010-4555-8484', 'crown1212@gmail.com', '서울시 강동구');
INSERT INTO user_info VALUES ('trtr44', 'q1w2e3r4~', '강기동', '010-7655-2356', 'trtr44@gmail.com', '서울시 도봉구');
INSERT INTO user_info VALUES ('soso23', 'q1w2e3r4~', '윤항기', '010-3437-6753', 'soso23@gmail.com', '서울시 양천구');
INSERT INTO user_info VALUES ('nidini985', 'q1w2e3r4~', '박민주', '010-5643-2346', 'nidini985@gmail.com', '서울시 구로구');
INSERT INTO user_info VALUES ('love9595', 'q1w2e3r4~', '임길수', '010-1389-1480', 'love9595@gmail.com', '경기도 성남시');
INSERT INTO user_info VALUES ('leetuy123', 'q1w2e3r4~', '김민수', '010-6784-6789', 'leetuy123@gmail.com', '경기도 수원시');

update user_info set u_pw='111' where u_id='aaa'; 

delete from user_info where u_id='aaa';
select * from user_info;
select * from user_info where u_id='aaa';
select count(*) from user_info where u_id='aaa';