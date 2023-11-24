--select p.p_category_no ,c.p_parent_category_no, max(p.p_order_count) as mc 
--from product p 
--join category c 
--on p.p_category_no=c.p_category_no 
--group by p.p_category_no,c.p_parent_category_no;

---- 베스트 상품 
--select * from product p 
--join (select p_category_no , max(p_order_count) as mc from product group by p_category_no) pc 
--on p.p_category_no=pc.p_category_no
--where p.p_order_count=pc.mc;

---- 카테고리별 베스트 상품

select * from product p 
    join 
        (select p.p_category_no ,c.p_parent_category_no, max(p.p_order_count) as mc 
        from product p 
        join category c 
        on p.p_category_no=c.p_category_no 
       group by p.p_category_no,c.p_parent_category_no) pc    
    on p.p_category_no=pc.p_category_no
where p.p_order_count=pc.mc;






-- select p1.p_name,max(p1.p_order_count) from product p1 group by p1.p_name  product p2 on p1.p_name =p2.p_name and max(p1.p_order_count)=p2.p_order_count ;

select p_name,sum(p_order_count) from product group by p_name order by sum(p_order_count) desc;













select * from product where p_size='S';











select * from product;


update proudct set p_order_count=3 where p_no=1079;
update proudct set p_order_count=3 where p_no=1044;
update proudct set p_order_count=2 where p_no=1045;
update product set p_order_count=7 where p_no=1052;
update product set p_order_count=1 where p_no=1050;
update product set p_order_count=10 where p_no=1058;
update product set p_order_count=2 where p_no=1065;
update product set p_order_count=6 where p_no=1080;
update product set p_order_count=2 where p_no=1057;

select p_name,sum(p_order_count) as s from product group by p_name;

select * from product p join
(select p_name,sum(p_order_count) as s from product group by p_name order by sum(p_order_count) desc) ps
on ps.s=p.p_order_count
order by p_order_count
where p.p_size='S'and p.p_size=null;


select rownum,p.p_no,p.p_name,p.p_image,p.p_price,ps.s from product p join
(select p_name,sum(p_order_count) as s from product group by p_name order by sum(p_order_count) desc) ps
on p.p_name=ps.p_name

where rownum<13
order by p.p_order_count desc;

select * from product p
join (select p_name,sum(p_order_count) as s from product group by p_name order by sum(p_order_count) desc) ps 
on p.p_name=ps.p_name
where p.p_size='s' or p.p_size is null;


select p.p_no,p.p_name,p.p_size,p.p_price,p.p_image,ps.s from product p join (
select rownum,p_name,s from
(select p_name,sum(p_order_count) as s from product group by p_name order by sum(p_order_count) desc)
where rownum<13) ps 
on p.p_name = ps.p_name
where p.p_size='S' or p.p_size is null;






select p_name,sum(p_order_count) as s from product group by p_name order by sum(p_order_count) desc;

 
select rownum,p_name,p_no,p_image,p_price 
from (select p_no,p_name,sum(p_order_count),p_image,p_price from product  group by p_no,p_name,p_image,p_price order by sum(p_order_count) desc) where rownum<13;



SELECT p_name, SUM(p_order_count) AS "주문수" FROM product GROUP BY p_name ORDER BY "주문수" desc;

-- 소 카테고리 낮은가격순
select   
    p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,
    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name 
    from product p 
    join category c1   
    on p.p_category_no=c1.p_category_no
    join category c2 
    on c2.p_category_no=c1.p_parent_category_no
    where c2.p_category_no=3100
    order by p.p_price;

-- 소 카테고리 높은가격순
select   
    p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,
    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name 
    from product p 
    join category c1   
    on p.p_category_no=c1.p_category_no
    join category c2 
    on c2.p_category_no=c1.p_parent_category_no
    where c2.p_category_no=3100
    order by p.p_price desc;

-- 소 카테고리 인기순
select   
    p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,
    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name 
    from product p 
    join category c1   
    on p.p_category_no=c1.p_category_no
    join category c2 
    on c2.p_category_no=c1.p_parent_category_no
    where c2.p_category_no=3100    
    order by p.p_order_count desc;
 
-- 소 카테고리별 보기
    
    select distinct   
    p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,
    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name 
    from product p 
    join category c1   
    on p.p_category_no=c1.p_category_no
    join category c2 
    on c2.p_category_no=c1.p_parent_category_no
    where c2.p_category_no=3100;
    
    
    -- 뿌리는 카테고리
    select distinct   
    p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,
    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name 
    from product p 
    join category c1   
    on p.p_category_no=c1.p_category_no
    join category c2 
    on c2.p_category_no=c1.p_parent_category_no
    where c2.p_category_no=2100
    and p.p_size='S';
    
    
    
    update product set p_category_no=2161 where p_no=121;
-- 큰 카테고리별 보기
select   
    p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,
    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name 
    from product p 
    join category c1   
    on p.p_category_no=c1.p_category_no
    join category c2 
    on c2.p_category_no=c1.p_parent_category_no
    where c2.p_parent_category_no=3000;

 -- 큰 카테고리 낮은가격순
select   
    p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,
    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name 
    from product p 
    join category c1   
    on p.p_category_no=c1.p_category_no
    join category c2 
    on c2.p_category_no=c1.p_parent_category_no
    where c2.p_parent_category_no=2000
    order by p.p_price;
    
    --큰 카테고리 높은가격순 
select   
    p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,
    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name 
    from product p 
    join category c1   
    on p.p_category_no=c1.p_category_no
    join category c2 
    on c2.p_category_no=c1.p_parent_category_no
    where c2.p_parent_category_no=2000
    order by p.p_price desc;    

-- 큰 카테고리 인기순
select   
    p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,
    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name 
    from product p 
    join category c1   
    on p.p_category_no=c1.p_category_no
    join category c2 
    on c2.p_category_no=c1.p_parent_category_no
    where c2.p_parent_category_no=2000
    order by p.p_order_count desc;



select * from (select   
    p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,
    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name 
    from product p 
    join category c1   
    on p.p_category_no=c1.p_category_no
    join category c2 
    on c2.p_category_no=c1.p_parent_category_no
    where c2.p_category_no=2100) s
    where s.p_size='s';

(select   
    p.*,c1.p_category_no as c1_p_category_no ,c1.p_parent_category_no as c1_p_parent_category_no,c1.p_category_name as c1_p_category_name ,
    c2.p_category_no as c2_p_category_no ,c2.p_parent_category_no as c2_p_parent_category_no ,c2.p_category_name as c2_p_category_name 
    from product p 
    join category c1   
    on p.p_category_no=c1.p_category_no
    join category c2 
    on c2.p_category_no=c1.p_parent_category_no
    where c2.p_category_no=2100);

update product set p_category_no =3401 where p_no=315;








Product(p_no=157, p_name=글루코사민 콘드로이틴, p_price=30000, p_image=update, p_desc=관절과 연골에서 자연적으로 발생, p_order_count=0, p_stock=20, p_size=null, p_category_no=3201, 
category1=Category [p_category_no=3201, p_parent_category_no=3200, p_category_name=뼈 건강], 
category2=Category [p_category_no=3201, p_parent_category_no=3200, p_category_name=뼈 건강])





-- 카테고리별(저렴한순)
select * from product p 
join category c 
on p.p_category_no=c.p_category_no
join category ce 
on ce.p_category_no=c.p_parent_category_no
where ce.p_parent_category_no=3000
order by p_price;

-- 카테고리별(가격높은순)
select * from product p 
join category c 
on p.p_category_no=c.p_category_no
join category ce 
on ce.p_category_no=c.p_parent_category_no
where ce.p_parent_category_no=3000
order by p_price;


select * from category c 
join product p 
on c.p_category_no=p.p_category_no 
where c.p_parent_category_no=1000 
order by p.p_order_count desc;



-- ex) 옷 -> 상의 [ 카테고리 2가지로 셀렉트 ] 
select * from product p join category c 
on p.p_category_no=c.p_category_no 
where c.p_parent_category_no=1;
 
 update category set p_parent_category_no=3400 where p_category_no=3002;
 
update category set p_parent_category_no=1100 where p_category_no>=1101 and p_category_no<=1199;
update category set p_parent_category_no=1200 where p_category_no>=1201 and p_category_no<=1299;
update category set p_parent_category_no=1300 where p_category_no>=1301 and p_category_no<=1399;
update category set p_parent_category_no=1400 where p_category_no>=1401 and p_category_no<=1499;
update category set p_parent_category_no=2100 where p_category_no>=2101 and p_category_no<=2199;
update category set p_parent_category_no=2200 where p_category_no>=2201 and p_category_no<=2299;
update category set p_parent_category_no=2300 where p_category_no>=2301 and p_category_no<=2399;
update category set p_parent_category_no=2400 where p_category_no>=2401 and p_category_no<=2499;
update category set p_parent_category_no=3100 where p_category_no>=3101 and p_category_no<=3199;
update category set p_parent_category_no=3200 where p_category_no>=3201 and p_category_no<=3299;       
update category set p_parent_category_no=3300 where p_category_no>=3301 and p_category_no<=3399; 
update category set p_parent_category_no=3400 where p_category_no>=3401 and p_category_no<=3499;  
 
insert into category values(1100,1000,'단백질 보충제');
insert into category values(1200,1000,'단백질 보충제'); 
insert into category values(1300,1000,'단백질 보충제'); 
insert into category values(1400,1000,'단백질 보충제'); 
insert into category values(2100,2000,'스포츠 웨어'); 
insert into category values(2200,2000,'스포츠 웨어'); 
insert into category values(2300,2000,'스포츠 웨어'); 
insert into category values(3100,3000,'비타민'); 
insert into category values(3200,3000,'비타민');
insert into category values(3300,3000,'비타민'); 

[Product [p_no=157, p_name=글루코사민 콘드로이틴, p_price=30000, p_image=update, p_desc=관절과 연골에서 자연적으로 발생, p_order_count=0, p_stock=20, p_size=null, p_category_no=3201, 
category=Category(p_category_no=3201, p_parent_category_no=3200, p_category_name=뼈 건강)]


update product set product.p_order_count=product.p_order_count+1,
                   product.p_stock=product.p_stock-#{oi_qty} 
where p_no=#{p_no};





select p_name,sum(p_order_count) as s from product group by p_name order by sum(p_order_count) desc; 
-- 이름으로 그룹화,오더카운트 합계 
select rownum,p_name,s from (select p_name,sum(p_order_count) as s from product group by p_name order by sum(p_order_count) desc) where rownum<13;
-- 오더카운트 합계 베스트순위 12

select p.p_no,p.p_name,p.p_size,p.p_price,p.p_image,ps.s from product p join (
select rownum,p_name,s from
(select p_name,sum(p_order_count) as s from product group by p_name order by sum(p_order_count) desc)
where rownum<13) ps 
on p.p_name = ps.p_name
where p.p_size='S' or p.p_size is null;
--베스트순위 12랑 제품 테이블 조인 이름으로 뽑는거는 옷 카테고리는 s 나머지는 null로 뽑음


(select * from product p join  order_item oi on p.p_no = oi.p_no);

update product
set p_order_co              unt = (select * from product p join order_item oi on p.p_no = oi.p_no).oi_qty;

p_order_count = p_order_count- (select * from product p join  order_item oi on p.p_no = oi.p_no).oi_qty ;





(select oi.oi_qty from product p join  order_item oi on p.p_no = oi.p_no) ;



update (select * from product ps join 
                    
                    (select p.p_name,sum(oi.oi_qty) as ois ,p.p_size from product p 
                            join order_item oi on p.p_no=oi.p_no 
                            group by p.p_size,p.p_name) s
                            
                    on ps.p_name =s.p.p_name and ps.p_size=s.p.p_size) d
                    
set d.p_order_count=d.ps.p_order_count + d.s.ois and d.ps.p_stock=d.ps.p_stock-d.s.ois 
where d.ps.p_no=985;


(select p.p_name,sum(oi.oi_qty) as ois ,p.p_size from product p 
                            join order_item oi on p.p_no=oi.p_no 
                            group by p.p_size,p.p_name);






(select p.p_name,sum(oi.oi_qty),p.p_size from product p join order_item oi on p.p_no=oi.p_no group by p.p_size,p.p_name); 







insert into category values(3400,3000,'비타민');


