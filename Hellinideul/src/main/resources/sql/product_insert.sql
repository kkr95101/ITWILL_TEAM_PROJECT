set define off;

-- 비타민 카테고리 (3000) 3001~3099 : 오메가3 
insert into category values(3401,3400,'오메가3'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'필수 오메가-3',11000,'image/omega.png','건강유지를 위한 오메가3 함유',3401);  
         
  -- 비타민 카테고리 (3000) 3101~3199 : 스포츠 퍼포먼스       
insert into category values(3101,3100,'스포츠 퍼포먼스'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'모노 크레아틴',33000,'image/mono.png','근력과 힘이 필요한 운동에 적합한 제품',3101);  

insert into category values(3102,3100,'스포츠 퍼포먼스'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'콜라겐 파우더',40000,'image/colP.png','무설탕 무지방 콜라겐 공급원',3102);   

insert into category values(3103,3100,'스포츠 퍼포먼스'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'알파맨 멀티비타민',20000,'image/alpha.png','활동적인 일상과 운동을 즐기시는 분들을 위한 멀티 비타민',3103);  

insert into category values(3104,3100,'스포츠 퍼포먼스'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'크레아틴 젤리',40000,'image/creJelly.png','크레아틴을 섭취하는 맛있고 간편한 방법',3104);  

insert into category values(3105,3100,'스포츠 퍼포먼스'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'프로틴 젤리',40000,'image/proJe.png','어디서나 즐길 수 있는 부드럽고 맛있는 프로틴 젤리',3105);  

insert into category values(3106,3100,'스포츠 퍼포먼스'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'CLA',15000,'image/cla.png','오메가 6를 간편하게 섭취하는 방법',3106);  

insert into category values(3107,3100,'스포츠 퍼포먼스'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'아연&마그네슘',30000,'image/am.png','비타민 B6가 첨가되어 더욱 특별한 아연&마그네슘 영양제',3107);  

insert into category values(3108,3100,'스포츠 퍼포먼스'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'펌프 인핸서(구:니트로 익스트림)',25000,'image/pump.png','펌프 개선제',3108);  

insert into category values(3109,3100,'스포츠 퍼포먼스'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'데일리 멀티비타민',25000,'image/muti.png','멀티비타민 영양 보조제',3109);

-- 비타민 카테고리 (3000) 3201~3299 : 뼈&관절 건강
insert into category values(3201,3200,'뼈&관절 건강'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'글루코사민 콘드로이틴',30000,'image/glucoCon.png','관절과 연골에서 자연적으로 발생',3201);
         
insert into category values(3202,3200,'뼈&관절 건강'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'글루코사민&콘드로이틴 플러스 (구: 조인트 플러스)',30000,'image/glucoCon.png','글루코사민 및 콘드로이친',3202);         
         
insert into category values(3203,3200,'뼈&관절 건강'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'글루코사민 HCL & 콘드로이틴',24000,'image/glucoHcl.png','900mg',3203);          
                 
         
-- 비타민 카테고리 (3000) 3301~3399 : 체중감량
insert into category values(3301,3300,'체중감량'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'Carb Metaboliser( 흰 강낭콩 추출물 )',57000,'image/cong.png','서빙당 흰 강낭콩 추출물 1,000mg 함유',3301);   

insert into category values(3302,3300,'체중감량'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'다이어트 보조제 (구:액티브 우먼 다이어트 캡슐™)',49000,'image/dietVojo.png','체중조절 보조제',3302); 
    
         
         
-- 스포츠웨어 카테고리 (2100) 2301~2399 : 악세사리         
insert into category values(2301,2300,'악세사리'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'MP 배럴 백 - 블랙',65000,'image/bag1.png','넉넉한 짐 배럴 백',2301); 
         
insert into category values(2302,2300,'악세사리'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'MP 더플백 - 블랙',87000,'image/bag2.png','MP 더플백',2302);         
         
insert into category values(2303,2300,'악세사리'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'MP 어댑트 백팩',150000,'image/bag3.png','트레이닝 백팩',2303);
         
insert into category values(2311,2300,'악세사리'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'패디드 고중량 리프팅 스트랩',30000,'image/ac1.png','향상된 내구성',2311);          
         
insert into category values(2312,2300,'악세사리'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'가죽 리프팅 벨트',45000,'image/belt1.png','리프트를 이용한 운동을 할 때 등과 코어 부분을 보조',2312);         
         
insert into category values(2313,2300,'악세사리'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'그립 스트랭스너 (악력기)',45000,'image/stRang.png','집에서 편안하게 그립력을 높이세요.',2313);         
         
insert into category values(2314,2300,'악세사리'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'요가 리커버리 매트 - 그레이',64000,'image/yoga.png','홈트레이닝을 위한 요가 매트',2314);           
 
insert into category values(2315,2300,'악세사리'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'MP 남성용 리프팅 글러브 - 블랙',35000,'image/globe.png','남성용 리프팅 글러브',2315); 
 
insert into category values(2316,2300,'악세사리'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'힙업 밴드 - 라이트 블루',35000,'image/hip.png','[NEW] 하체운동 홈트 필수품!',2316); 
 
insert into category values(2321,2300,'악세사리'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'쉐이커',10000,'image/shake.png','현존 가장 혁신적인 쉐이커 보틀',2321);  
         
insert into category values(2322,2300,'악세사리'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'핸드 타월 (수건)',30000,'image/handT.png','소프트 터치 짐 타월',2322); 
 
insert into category values(2323,2300,'악세사리'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no)
         values(product_p_no_SEQ.nextval,'요가 블럭 - 그레이',27000,'image/yoga2.png','논슬립 경량 요가 블록',2323); 
 
 
 -- 스포츠웨어 카테고리 (2100) 2201~2299 : 하의   
 
insert into category values(2201,2200,'하의'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no)
         values(product_p_no_SEQ.nextval,'MP 남성용 에센셜 트레이닝 조거 - 블랙',50000,'image/bottom1.png','포켓이 있는 남성용 슬림핏 트레이닝 조거','S',2201);
insert into category values(2202,2200,'하의'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no)
         values(product_p_no_SEQ.nextval,'MP 남성용 에센셜 트레이닝 조거 - 블랙',50000,'image/bottom1.png','포켓이 있는 남성용 슬림핏 트레이닝 조거','M',2202);
insert into category values(2203,2200,'하의'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no)
         values(product_p_no_SEQ.nextval,'MP 남성용 에센셜 트레이닝 조거 - 블랙',50000,'image/bottom1.png','포켓이 있는 남성용 슬림핏 트레이닝 조거','L',2203);
         
         
insert into category values(2204,2200,'하의'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no)
         values(product_p_no_SEQ.nextval,'MP 남성용 템포 조거 - 블랙',35000,'image/bottom2.png','지퍼 포켓이 있고 통기성이 뛰어난 남성용 조거','S',2204);         
insert into category values(2205,2200,'하의'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no)
         values(product_p_no_SEQ.nextval,'MP 남성용 템포 조거 - 블랙',35000,'image/bottom2.png','지퍼 포켓이 있고 통기성이 뛰어난 남성용 조거','M',2205);
insert into category values(2206,2200,'하의'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no)
         values(product_p_no_SEQ.nextval,'MP 남성용 템포 조거 - 블랙',35000,'image/bottom2.png','지퍼 포켓이 있고 통기성이 뛰어난 남성용 조거','L',2206); 
         
         
insert into category values(2207,2200,'하의'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no)
         values(product_p_no_SEQ.nextval,'MP 남성용 템포 쇼츠 - 블랙',68000,'image/bottom3.png','남성용 재활용 폴리에스터 쇼츠','S',2207);        
insert into category values(2208,2200,'하의'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no)
         values(product_p_no_SEQ.nextval,'MP 남성용 템포 쇼츠 - 블랙',68000,'image/bottom3.png','남성용 재활용 폴리에스터 쇼츠','M',2208);         
insert into category values(2209,2200,'하의'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no)
         values(product_p_no_SEQ.nextval,'MP 남성용 템포 쇼츠 - 블랙',68000,'image/bottom3.png','남성용 재활용 폴리에스터 쇼츠','L',2209);         
         
insert into category values(2210,2200,'하의'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no)
         values(product_p_no_SEQ.nextval,'남성용 에센셜 우븐 트레이닝 쇼츠 - 블랙',38000,'image/bottom4.png','포켓이 있는 남성용 7인치 라이트웨이트 우븐 트레이닝 쇼츠','S',2210);
insert into category values(2211,2200,'하의'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no)
         values(product_p_no_SEQ.nextval,'남성용 에센셜 우븐 트레이닝 쇼츠 - 블랙',38000,'image/bottom4.png','포켓이 있는 남성용 7인치 라이트웨이트 우븐 트레이닝 쇼츠','M',2211);
insert into category values(2212,2200,'하의'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no)
         values(product_p_no_SEQ.nextval,'남성용 에센셜 우븐 트레이닝 쇼츠 - 블랙',38000,'image/bottom4.png','포켓이 있는 남성용 7인치 라이트웨이트 우븐 트레이닝 쇼츠','L',2212);           
         
         
insert into category values(2213,2200,'하의'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no)
         values(product_p_no_SEQ.nextval,'MP 여성용 템포 리브 심리스 레깅스 - 소프트 파인',38000,'image/bottom5.png','여성용 스쿼트 방지 레깅스','S',2213);         
insert into category values(2214,2200,'하의'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no)
         values(product_p_no_SEQ.nextval,'MP 여성용 템포 리브 심리스 레깅스 - 소프트 파인',38000,'image/bottom5.png','여성용 스쿼트 방지 레깅스','M',2214);         
insert into category values(2215,2200,'하의'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no)
         values(product_p_no_SEQ.nextval,'MP 여성용 템포 리브 심리스 레깅스 - 소프트 파인',38000,'image/bottom5.png','여성용 스쿼트 방지 레깅스','L',2215);         
         
         
insert into category values(2216,2200,'하의'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no)
         values(product_p_no_SEQ.nextval,'MP 여성용 커브 하이 웨이스트 부티 쇼츠 - 데인저 말',32000,'image/bottom6.png','하이 웨이스트, 움직임에 제한이 없는 부티 쇼츠','S',2216);          
insert into category values(2217,2200,'하의'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no)
         values(product_p_no_SEQ.nextval,'MP 여성용 커브 하이 웨이스트 부티 쇼츠 - 데인저 말',32000,'image/bottom6.png','하이 웨이스트, 움직임에 제한이 없는 부티 쇼츠','M',2217);
insert into category values(2218,2200,'하의'); 
insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no)
         values(product_p_no_SEQ.nextval,'MP 여성용 커브 하이 웨이스트 부티 쇼츠 - 데인저 말',32000,'image/bottom6.png','하이 웨이스트, 움직임에 제한이 없는 부티 쇼츠','L',2218);
         


 --프로틴
 --웨이프로틴
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1101,1100,'웨이프로틴');
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'임팩트 웨이 아이솔레이트',39900,'image/impactI.png','단백질 함유량 90%이상의 최상급 WPI',1101);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1102,1100,'웨이프로틴');
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'임팩트 웨이 프로틴',19900,'image/impact.png','마이프로틴 No.1 베스트셀러',1102);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1103,1100,'웨이프로틴');       
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'클리어 웨이 아이솔레이트',64900,'image/clearI.png','깨끗하고 산뜻한 음용감의 웨이 아이솔레이트',1103);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1104,1100,'웨이프로틴');       
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'웨이트 게이너 블렌드',49900,'image/wGainer.png','매스업에 도움을 줄 수 있는 효과적인 게이너',1104);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1105,1100,'웨이프로틴');       
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'에센셜 웨이 프로틴',30900,'image/essential.png','더욱 비용 효율적인 웨이 프로틴',1105);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1106,1100,'웨이프로틴'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'프로틴 젤리',39900,'image/jelly.png','어디서나 즐길 수 있는 부드럽고 맛있는 프로틴 젤리',1106);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1107,1100,'웨이프로틴'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'프로틴 식사대용 블렌드',28900,'image/siksa.png','서빙당 약 200kcal의 고단백질 식사대용 쉐이크',1107);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1108,1100,'웨이프로틴'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'임팩트 다이어트 웨이',52900,'image/diet.png','최고의 영양성분을 더한 체중조절 단백질 파우더',1108);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1109,1100,'웨이프로틴'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'THE 웨이',85900,'image/theWhey.png','프리미엄 올인원 단백질 보충제',1109);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1110,1100,'웨이프로틴'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'클리어 프로틴 워터 - RTD (6팩)',39900,'image/clearW.png','천연 향료 함유',1110);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1111,1100,'웨이프로틴'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'토탈 프로틴 블렌드',54900,'image/totalB.png','빠른+느린흡수 프로틴',1111);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1112,1100,'웨이프로틴'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'가수분해 웨이 프로틴',149900,'image/gasu.png','프리-다이제스티드 단백질',1112);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1113,1100,'웨이프로틴'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'임팩트 프로틴 블렌드',69900,'image/impactB.png','한 번에 두 가지 제품의 장점을 모두 누리세요',1113);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1114,1100,'웨이프로틴'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'퓨처 웨이',59900,'image/future.png','동물성 성분을 함유하지 않은 친환경 프로틴 파우더',1114);



--아이솔레이트
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1201,1200,'아이솔레이트'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'클리어 웨이 아이솔레이트 - 20servings - 라즈베리 레몬에이드',64900,'image/clearI1.png','깨끗하고 산뜻한 음용감의 웨이 아이솔레이트',1201);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1202,1200,'아이솔레이트');
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'클리어 웨이 아이솔레이트 - 20servings - 유자 그린티',64900,'image/clearI2.png','깨끗하고 산뜻한 음용감의 웨이 아이솔레이트',1202);
  
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1203,1200,'아이솔레이트');
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'클리어 웨이 아이솔레이트 - 20servings - 감귤',64900,'image/clearI3.png','깨끗하고 산뜻한 음용감의 웨이 아이솔레이트',1203);

 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1204,1200,'아이솔레이트');
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'클리어 웨이 아이솔레이트 - 20servings - 리치',64900,'image/clearI4.png','깨끗하고 산뜻한 음용감의 웨이 아이솔레이트',1204);
 
 
 --식물성 단백질
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1301,1300,'식물성 단백질'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'현미 프로틴',39900,'image/sikmul1.png','체중 증량을 도와주는 비건 부스트, 식물성 단백질',1301);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1302,1300,'식물성 단백질');
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'소이 프로틴 아이솔레이트',19900,'image/sikmul2.png','90% 이상의 단백질 성분으로 엄격한 채식주의자에게 적합한 프로틴',1302);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1303,1300,'식물성 단백질');
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'완두콩 프로틴 아이솔레이트',35900,'image/sikmul3.png','식물성 단백질',1303);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1304,1300,'식물성 단백질');
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'식물성 프로틴 블렌드',39900,'image/sikmul4.png','완두콩과 잠두콩 단백질을 첨가해 재탄생한 식물성 영양 성분',1304);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1305,1300,'식물성 단백질');
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'클리어 비건 프로틴',49900,'image/sikmul5.png','채식주의자도 마실 수 있는 청량한 클리어 프로틴',1305);
 
 
 --복합 단백질
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1401,1400,'복합 단백질');
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'프로틴 팬케이크 믹스',59900,'image/vok1.png','영양만점 팬케이크의 놀라운 단백질 함유량!',1401);

 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1402,1400,'복합 단백질');
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'프로틴 머그 케이크',25900,'image/vok2.png','1분 안에 완성하는 고단백 간식',1402);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1403,1400,'복합 단백질');
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'아침 식사 스무디',81900,'image/vok3.png','고단백 아침 식사 간편식',1403);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(1404,1400,'복합 단백질');
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_category_no) values(product_p_no_SEQ.nextval,'홀 퓨얼 블렌드',32900,'image/vok4.png','비건에게 적합한 식사 대용 포뮬러',1404);
   
 --상의
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2101,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 남성용 리니어 마크 그래픽 트레이닝 탱크탑 - 트루 블루',24900,'image/top7.png','그래픽 트레이닝 탱크탑','S',2101);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2102,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 남성용 리니어 마크 그래픽 트레이닝 탱크탑 - 트루 블루',24900,'image/top7.png','그래픽 트레이닝 탱크탑','M',2102);

 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2103,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 남성용 리니어 마크 그래픽 트레이닝 탱크탑 - 트루 블루',24900,'image/top7.png','그래픽 트레이닝 탱크탑','L',2103);

 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2104,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 남성용 벨로시티 롱 슬리브 탑 - 포세이돈',28900,'image/top8.png','남성용 메쉬 롱 슬리브 탑','S',2104);
  
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2105,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 남성용 벨로시티 롱 슬리브 탑 - 포세이돈',28900,'image/top8.png','남성용 메쉬 롱 슬리브 탑','M',2105);
   
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2106,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 남성용 벨로시티 롱 슬리브 탑 - 포세이돈',28900,'image/top8.png','남성용 메쉬 롱 슬리브 탑','L',2106);
   
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2107,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 남성용 벨로시티 스트링거 베스트 - 딥 틸',28900,'image/top9.png','레귤러 핏 스트링거 조끼','S',2107);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2108,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 남성용 벨로시티 스트링거 베스트 - 딥 틸',28900,'image/top9.png','레귤러 핏 스트링거 조끼','M',2108);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2109,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 남성용 벨로시티 스트링거 베스트 - 딥 틸',28900,'image/top9.png','레귤러 핏 스트링거 조끼','L',2109);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2110,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 남성용 벨로시티 숏 슬리브 티셔츠 - 화이트',24900,'image/top10.png','남성용 숏 슬리브 트레이닝 티셔츠','S',2110);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2111,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 남성용 벨로시티 숏 슬리브 티셔츠 - 화이트',24900,'image/top10.png','남성용 숏 슬리브 트레이닝 티셔츠','M',2111);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2112,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 남성용 벨로시티 숏 슬리브 티셔츠 - 화이트',24900,'image/top10.png','남성용 숏 슬리브 트레이닝 티셔츠','L',2112);
   
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2113,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 남성용 에센셜 트레이닝 탱크탑 - 블랙',39900,'image/top11.png','남성용 레귤러 핏 탱크 탑','S',2113);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2114,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 남성용 에센셜 트레이닝 탱크탑 - 블랙',39900,'image/top11.png','남성용 레귤러 핏 탱크 탑','M',2114);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2115,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 남성용 에센셜 트레이닝 탱크탑 - 블랙',39900,'image/top11.png','남성용 레귤러 핏 탱크 탑','L',2115);
  
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2116,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 남성용 에센셜 트레이닝 티셔츠 - 네이비',34900,'image/top12.png','남성용 숏 슬리브 트레이닝 티셔츠','S',2116);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2117,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 남성용 에센셜 트레이닝 티셔츠 - 네이비',34900,'image/top12.png','남성용 숏 슬리브 트레이닝 티셔츠','M',2117);

 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2118,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 남성용 에센셜 트레이닝 티셔츠 - 네이비',34900,'image/top12.png','남성용 숏 슬리브 트레이닝 티셔츠','L',2118);
   
   



 --
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2151,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 여성용 어댑트 레이서백 크롭 베스트 - 블랙',26900,'image/top1.png','여성용 레귤러 핏 코튼 크롭 탑','S',2151);

 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2152,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 여성용 어댑트 레이서백 크롭 베스트 - 블랙',26900,'image/top1.png','여성용 레귤러 핏 코튼 크롭 탑','M',2152);

 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2153,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 여성용 어댑트 레이서백 크롭 베스트 - 블랙',26900,'image/top1.png','여성용 레귤러 핏 코튼 크롭 탑','L',2153);

 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2154,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 여성용 컴포저 트위스트 프론트 크롭 티셔츠 - 블랙',22900,'image/top2.png','지속 가능한 크롭 탑','S',2154);
  
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2155,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 여성용 컴포저 트위스트 프론트 크롭 티셔츠 - 블랙',22900,'image/top2.png','지속 가능한 크롭 탑','M',2155);
  
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2156,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 여성용 컴포저 트위스트 프론트 크롭 티셔츠 - 블랙',22900,'image/top2.png','지속 가능한 크롭 탑','L',2156);
    
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2157,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 여성용 컴포저 숏 슬리브 크롭 탑 - 블랙',20900,'image/top3.png','여성용 크로스 프론트 숏 슬리브 크롭 탑','S',2157);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2158,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 여성용 컴포저 숏 슬리브 크롭 탑 - 블랙',20900,'image/top3.png','여성용 크로스 프론트 숏 슬리브 크롭 탑','M',2158);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2159,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 여성용 컴포저 숏 슬리브 크롭 탑 - 블랙',20900,'image/top3.png','여성용 크로스 프론트 숏 슬리브 크롭 탑','L',2159);
   
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2160,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 여성용 어댑트 레이서백 베스트 - 마젠타',20900,'image/top4.png','여성용 슬림핏 코튼 트레이닝 베스트','S',2160);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2161,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 여성용 어댑트 레이서백 베스트 - 마젠타',20900,'image/top4.png','여성용 슬림핏 코튼 트레이닝 베스트','M',2161);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2162,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 여성용 어댑트 레이서백 베스트 - 마젠타',20900,'image/top4.png','여성용 슬림핏 코튼 트레이닝 베스트','L',2162);
    
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2163,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 여성용 어댑트 레이서백 크롭 베스트 - 애시드 라임',26900,'image/top5.png','여성용 레귤러 핏 코튼 크롭 탑','S',2163);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2164,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 여성용 어댑트 레이서백 크롭 베스트 - 애시드 라임',26900,'image/top5.png','여성용 레귤러 핏 코튼 크롭 탑','M',2164);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2165,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 여성용 어댑트 레이서백 크롭 베스트 - 애시드 라임',26900,'image/top5.png','여성용 레귤러 핏 코튼 크롭 탑','L',2165);
  
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2166,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 여성용 페이드 그래픽 크롭 티셔츠 - 캔디 플로스',14900,'image/top6.png','크롭 티셔츠','S',2166);
 
 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2167,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 여성용 페이드 그래픽 크롭 티셔츠 - 캔디 플로스',14900,'image/top6.png','크롭 티셔츠','M',2167);

 insert into category(p_category_no,p_parent_category_no,p_category_name) values(2168,2100,'상의'); 
 insert into product(p_no,p_name,p_price,p_image,p_desc,p_size,p_category_no) values(product_p_no_SEQ.nextval,'MP 여성용 페이드 그래픽 크롭 티셔츠 - 캔디 플로스',14900,'image/top6.png','크롭 티셔츠','L',2168);
    
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
 insert into category values(3400,3000,'비타민');
 
 
 set define on;