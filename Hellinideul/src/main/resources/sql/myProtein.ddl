DROP TABLE board CASCADE CONSTRAINTS;
DROP TABLE order_item CASCADE CONSTRAINTS;
DROP TABLE orders CASCADE CONSTRAINTS;
DROP TABLE cart CASCADE CONSTRAINTS;
DROP TABLE product CASCADE CONSTRAINTS;
DROP TABLE category CASCADE CONSTRAINTS;
DROP TABLE user_info CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: user_info */
/**********************************/
CREATE TABLE user_info(
		u_id                          		VARCHAR2(20)		 NULL ,
		u_pw                          		VARCHAR2(20)		 NULL ,
		u_name                        		VARCHAR2(50)		 NULL ,
		u_phone                       		VARCHAR2(50)		 NULL ,
		u_email                       		VARCHAR2(50)		 NULL ,
		u_address                     		VARCHAR2(100)		 NULL 
);

COMMENT ON TABLE user_info is 'user_info';
COMMENT ON COLUMN user_info.u_id is 'u_id';
COMMENT ON COLUMN user_info.u_pw is 'u_pw';
COMMENT ON COLUMN user_info.u_name is 'u_name';
COMMENT ON COLUMN user_info.u_phone is 'u_phone';
COMMENT ON COLUMN user_info.u_email is 'u_email';
COMMENT ON COLUMN user_info.u_address is 'u_address';


/**********************************/
/* Table Name: category */
/**********************************/
CREATE TABLE category(
		p_category_no                 		NUMBER(10)		 NULL ,
		p_parent_category_no          		NUMBER(10)		 NULL ,
		p_category_name               		VARCHAR2(100)		 NULL 
);

COMMENT ON TABLE category is 'category';
COMMENT ON COLUMN category.p_category_no is 'p_category_no';
COMMENT ON COLUMN category.p_parent_category_no is 'p_parent_category_no';
COMMENT ON COLUMN category.p_category_name is 'p_category_name';


/**********************************/
/* Table Name: product */
/**********************************/
CREATE TABLE product(
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(100)		 NULL ,
		p_price                       		NUMBER(10)		 NULL ,
		p_image                       		VARCHAR2(100)		 NULL ,
		p_desc                        		VARCHAR2(200)		 NULL ,
		p_order_count                 		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		p_stock                       		NUMBER(10)		 DEFAULT 20		 NOT NULL,
		p_size                        		VARCHAR2(3)		 NULL ,
		p_category_no                 		NUMBER(10)		 NULL 
);

DROP SEQUENCE product_p_no_SEQ;

CREATE SEQUENCE product_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE product is 'product';
COMMENT ON COLUMN product.p_no is 'p_no';
COMMENT ON COLUMN product.p_name is 'p_name';
COMMENT ON COLUMN product.p_price is 'p_price';
COMMENT ON COLUMN product.p_image is 'p_image';
COMMENT ON COLUMN product.p_desc is 'p_desc';
COMMENT ON COLUMN product.p_order_count is 'p_order_count';
COMMENT ON COLUMN product.p_stock is 'p_stock';
COMMENT ON COLUMN product.p_size is 'p_size';
COMMENT ON COLUMN product.p_category_no is 'p_category_no';


/**********************************/
/* Table Name: cart */
/**********************************/
CREATE TABLE cart(
		c_no                          		NUMBER(10)		 NULL ,
		c_qty                         		NUMBER(10)		 NULL ,
		p_no                          		NUMBER(10)		 NULL ,
		u_id                          		VARCHAR2(20)		 NULL 
);

DROP SEQUENCE cart_c_no_SEQ;

CREATE SEQUENCE cart_c_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE cart is 'cart';
COMMENT ON COLUMN cart.c_no is 'c_no';
COMMENT ON COLUMN cart.c_qty is 'c_qty';
COMMENT ON COLUMN cart.p_no is 'p_no';
COMMENT ON COLUMN cart.u_id is 'u_id';


/**********************************/
/* Table Name: orders */
/**********************************/
CREATE TABLE orders(
		o_no                          		NUMBER(10)		 NULL ,
		o_desc                        		VARCHAR2(100)		 NULL ,
		o_date                        		DATE		 DEFAULT sysdate		 NULL ,
		o_price                       		NUMBER(10)		 NULL ,
		u_id                          		VARCHAR2(20)		 NULL 
);

DROP SEQUENCE orders_o_no_SEQ;

CREATE SEQUENCE orders_o_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE orders is 'orders';
COMMENT ON COLUMN orders.o_no is 'o_no';
COMMENT ON COLUMN orders.o_desc is 'o_desc';
COMMENT ON COLUMN orders.o_date is 'o_date';
COMMENT ON COLUMN orders.o_price is 'o_price';
COMMENT ON COLUMN orders.u_id is 'u_id';


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



COMMENT ON TABLE order_item is 'order_item';
COMMENT ON COLUMN order_item.oi_no is 'oi_no';
COMMENT ON COLUMN order_item.oi_qty is 'oi_qty';
COMMENT ON COLUMN order_item.o_no is 'o_no';
COMMENT ON COLUMN order_item.p_no is 'p_no';


/**********************************/
/* Table Name: board */
/**********************************/
CREATE TABLE board(
		board_no                      		NUMBER(10)		 NULL ,
		title                         		VARCHAR2(100)		 NOT NULL,
		writer                        		VARCHAR2(20)		 NOT NULL,
		content                       		VARCHAR2(2000)		 NOT NULL,
		regdate                       		DATE		 DEFAULT sysdate		 NULL ,
		read_count                    		NUMBER(10)		 DEFAULT 0		 NULL ,
		groupno                       		NUMBER(10)		 NOT NULL,
		step                          		NUMBER(10)		 NOT NULL,
		depth                         		NUMBER(10)		 DEFAULT 0		 NULL ,
		u_id                          		VARCHAR2(20)		 NOT NULL
);

DROP SEQUENCE board_board_no_SEQ;

CREATE SEQUENCE board_board_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE board is 'board';
COMMENT ON COLUMN board.board_no is 'board_no';
COMMENT ON COLUMN board.title is 'title';
COMMENT ON COLUMN board.writer is 'writer';
COMMENT ON COLUMN board.content is 'content';
COMMENT ON COLUMN board.regdate is 'regdate';
COMMENT ON COLUMN board.read_count is 'read_count';
COMMENT ON COLUMN board.groupno is 'groupno';
COMMENT ON COLUMN board.step is 'step';
COMMENT ON COLUMN board.depth is 'depth';
COMMENT ON COLUMN board.u_id is 'u_id';



ALTER TABLE user_info ADD CONSTRAINT IDX_user_info_PK PRIMARY KEY (u_id);

ALTER TABLE category ADD CONSTRAINT IDX_category_PK PRIMARY KEY (p_category_no);

ALTER TABLE product ADD CONSTRAINT IDX_product_PK PRIMARY KEY (p_no);
ALTER TABLE product ADD CONSTRAINT IDX_product_FK0 FOREIGN KEY (p_category_no) REFERENCES category (p_category_no);

ALTER TABLE cart ADD CONSTRAINT IDX_cart_PK PRIMARY KEY (c_no);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK0 FOREIGN KEY (u_id) REFERENCES user_info (u_id);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK1 FOREIGN KEY (p_no) REFERENCES product (p_no);

ALTER TABLE orders ADD CONSTRAINT IDX_orders_PK PRIMARY KEY (o_no);
ALTER TABLE orders ADD CONSTRAINT IDX_orders_FK0 FOREIGN KEY (u_id) REFERENCES user_info (u_id);

ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_PK PRIMARY KEY (oi_no);
ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_FK0 FOREIGN KEY (o_no) REFERENCES orders (o_no) on CASCADE DELETE;
ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_FK1 FOREIGN KEY (p_no) REFERENCES product (p_no);

ALTER TABLE board ADD CONSTRAINT IDX_board_PK PRIMARY KEY (board_no);
ALTER TABLE board ADD CONSTRAINT IDX_board_FK0 FOREIGN KEY (u_id) REFERENCES user_info (u_id);       
