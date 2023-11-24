package myProtein.cart;

import java.util.List;

public interface CartDao {
	//카트 추가
	public int insert(String u_id,int p_no,int c_qty);
	//유저 아이디로 카트 삭제
	public int deleteByU_Id(String u_id);
	//카트 번호로 카트 삭제
	public int deleteByC_No(int c_no);
	//카트 번호로 카트 수정
	public int updateByC_No(int c_qty, int c_no);
	//유저 아이디로 카트 수정
	public int updateByU_Id(String u_id,int p_no,int c_qty);
	//유저 아이디와 상품 번호로 카트 개수 구하기
	public int cartRowCount(String u_id,int p_no);
	//유저 아이디로 카트 리스트 구하기
	public List<Cart> findCartListByU_Id(String u_id);
	//카트 번호로 하나 찾기
	public Cart findByCartNo(int c_no);
}

