/**********************member insert************************/
insert into userinfo(m_id,m_pw,m_name,m_phone,m_email,m_address) values('user1','1111','임범준','010-1234-4567','user1@naver.com','서울시 송파구');
insert into userinfo(m_id,m_pw,m_name,m_phone,m_email,m_address) values('user2','1111','배종호','010-1111-2222','user2@naver.com','서울시 강남구');
insert into userinfo(m_id,m_pw,m_name,m_phone,m_email,m_address) values('user3','1111','권경록','010-3333-4444','user3@naver.com','서울시 강서구');
insert into userinfo(m_id,m_pw,m_name,m_phone,m_email,m_address) values('user4','1111','이동현','010-5555-6666','user4@naver.com','서울시 동작구');
insert into userinfo(m_id,m_pw,m_name,m_phone,m_email,m_address) values('user5','1111','이다영','010-7777-8888','user5@naver.com','서울시 서초구');
insert into userinfo(m_id,m_pw,m_name,m_phone,m_email,m_address) values('user6','1111','박근우','010-9999-0000','user6@naver.com','경기도 수원');

/**********************product insert************************/

insert into product(p_no,p_name,p_price,p_image,p_desc,p_category) values(product_p_no_SEQ.nextval, '문과 남자의 과학공부', 15750, 'bestSeller1.jpg', '유시민이 들려주는 과학 인문학이야기',10);
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category) values(product_p_no_SEQ.nextval, '스킵과 로퍼 6', 5400, 'bestSeller2.jpg', '도쿄 고교생활 속 연애이야기',10);
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category) values(product_p_no_SEQ.nextval, '도둑맞은 집중력', 16920, 'bestSeller3.jpg', '삶에서 도난당하고 있는 집중력을 되찾는법을 담은책',10);
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category) values(product_p_no_SEQ.nextval, '스튜디오 지브리 입체건축전 도록', 27000, 'bestSeller4.jpg', '스튜디오 지브리 입체건축전 전시회 도록',10);
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category) values(product_p_no_SEQ.nextval, '꿀벌의예언1', 15120, 'novel1.jpg', '꿀벌이 사라진 지구를 예언서로 구하는 이야기',20);
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category) values(product_p_no_SEQ.nextval, '있을법한모든것', 13500, 'novel2.jpg', '우리도한번쯤상상해봤을또는 상상하지못한 이야기',20);
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category) values(product_p_no_SEQ.nextval, '꿀벌의예언2', 15120, 'novel3.jpg', '꿀벌이 사라진 지구를 예언서로 구하는 이야기',20);
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category) values(product_p_no_SEQ.nextval, '나니아 연대기 (리커버 특별판)', 67500, 'novel4.jpg', '나니아 연대기 시리즈 총 7편을 하나로 묶은 합본의 특별판',20);
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category) values(product_p_no_SEQ.nextval, '세이노의가르침', 6480, 'selfImprovement1.jpg', '순자산 천억원대 자산가의 인생이야기',30);
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category) values(product_p_no_SEQ.nextval, '최적의공부뇌', 15120, 'selfImprovement2.jpg', '공부를 잘하기 위한 최소조건인 뇌의최적화에 대해',30);
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category) values(product_p_no_SEQ.nextval, '역행자 확장판', 17550, 'selfImprovement3.jpg', '운명과 본능의 지배에서 벗어나 경제적 자유와 행복을 쟁취하는 라이프해킹의 비밀을 담은 책',30);
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category) values(product_p_no_SEQ.nextval, '사장학개론', 22500, 'selfImprovement4.jpg', '한국과 미국, 전 세계를 오가며 ‘사장을 가르치는 사장’으로 알려진 『돈의 속성』의 저자 김승호 회장의 신간',30);


/**********************cart insert************************/
insert into cart(c_no, m_id ,p_no, c_qty) values (cart_c_no_SEQ.nextval,'user1',1,2);
insert into cart(c_no, m_id ,p_no, c_qty) values (cart_c_no_SEQ.nextval,'user1',2,1);

insert into cart(c_no, m_id ,p_no, c_qty) values (cart_c_no_SEQ.nextval,'user2',3,4);
insert into cart(c_no, m_id ,p_no, c_qty) values (cart_c_no_SEQ.nextval,'user2',4,2);
insert into cart(c_no, m_id ,p_no, c_qty) values (cart_c_no_SEQ.nextval,'user2',1,1);


/**********************orders insert************************/
insert into orders(o_no,o_desc,o_date,o_price,m_id) values (orders_o_no_SEQ.nextval,'나는너랑외1권',sysdate,50000,'user1');

insert into orders(o_no,o_desc,o_date,o_price,m_id) values (orders_o_no_SEQ.nextval,'심플라이프외1권',sysdate-2,40000,'user1');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,1);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,2);

insert into orders(o_no,o_desc,o_date,o_price,m_id) values (orders_o_no_SEQ.nextval,'도둑맞은집중력외1권',sysdate-1,40000,'user2');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,3);


insert into orders(o_no,o_desc,o_date,o_price,m_id) values (orders_o_no_SEQ.nextval,'비가오면열리는상점외1권',sysdate,70000,'user2');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,4);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,2,orders_o_no_SEQ.currval,2);



insert into orders(o_no,o_desc,o_date,o_price,m_id) values (orders_o_no_SEQ.nextval,'다태유외0권',sysdate-1,40000,'user2');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,2);

insert into orders(o_no,o_desc,o_date,o_price,m_id) values (orders_o_no_SEQ.nextval,'해커스토익외1권',sysdate,30000,'user1');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,2);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,4);


commit;
desc order_item;


