DROP TABLE order_item CASCADE CONSTRAINTS;
DROP TABLE orders CASCADE CONSTRAINTS;
DROP TABLE cart CASCADE CONSTRAINTS;
DROP TABLE product CASCADE CONSTRAINTS;
DROP TABLE userinfo CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: userinfo */
/**********************************/
CREATE TABLE userinfo(
		m_id                          		VARCHAR2(20)		 NULL ,
		m_pw                          		VARCHAR2(20)		 NULL ,
		m_name                        		VARCHAR2(50)		 NULL ,
		m_phone                       		VARCHAR2(50)		 NULL ,
		m_email                       		VARCHAR2(50)		 NULL ,
		m_address                     		VARCHAR2(100)		 NULL 
);




/**********************************/
/* Table Name: product */
/**********************************/
CREATE TABLE product(
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(50)		 NULL ,
		p_price                       		NUMBER(10)		 NULL ,
		p_image                       		VARCHAR2(100)		 NULL ,
		p_desc                        		VARCHAR2(200)		 NULL ,
		p_category                          NUMBER(10)		 NULL 
);

DROP SEQUENCE product_p_no_SEQ;

CREATE SEQUENCE product_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



/**********************************/
/* Table Name: cart */
/**********************************/
CREATE TABLE cart(
		c_no                          		NUMBER(10)		 NULL ,
		c_qty                         		NUMBER(10)		 NULL ,
		p_no                          		NUMBER(10)		 NULL ,
		m_id                          		VARCHAR2(20)		 NULL 
);

DROP SEQUENCE cart_c_no_SEQ;

CREATE SEQUENCE cart_c_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


/**********************************/
/* Table Name: orders */
/**********************************/
CREATE TABLE orders(
		o_no                          		NUMBER(10)		 NULL ,
		o_desc                        		VARCHAR2(100)		 NULL ,
		o_date                        		DATE		 DEFAULT sysdate		 NULL ,
		o_price                       		NUMBER(10)		 NULL ,
		m_id                          		VARCHAR2(20)		 NULL 
);

DROP SEQUENCE orders_o_no_SEQ;

CREATE SEQUENCE orders_o_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




/**********************************/
/* Table Name: order_item */
/**********************************/
CREATE TABLE order_item(
		oi_no                         		NUMBER(10)		 NULL ,
		oi_qty                        		NUMBER(10)		 NULL ,
		o_no                          		NUMBER(10)		 NULL ,
		p_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE order_item_oi_no_SEQ;

CREATE SEQUENCE order_item_oi_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;





ALTER TABLE userinfo ADD CONSTRAINT IDX_userinfo_PK PRIMARY KEY (m_id);

ALTER TABLE product ADD CONSTRAINT IDX_product_PK PRIMARY KEY (p_no);

ALTER TABLE cart ADD CONSTRAINT IDX_cart_PK PRIMARY KEY (c_no);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK0 FOREIGN KEY (m_id) REFERENCES userinfo (m_id);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK1 FOREIGN KEY (p_no) REFERENCES product (p_no);

ALTER TABLE orders ADD CONSTRAINT IDX_orders_PK PRIMARY KEY (o_no);
ALTER TABLE orders ADD CONSTRAINT IDX_orders_FK0 FOREIGN KEY (m_id) REFERENCES userinfo (m_id);

ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_PK PRIMARY KEY (oi_no);
ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_FK0 FOREIGN KEY (o_no) REFERENCES orders (o_no);
ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_FK1 FOREIGN KEY (p_no) REFERENCES product (p_no);


