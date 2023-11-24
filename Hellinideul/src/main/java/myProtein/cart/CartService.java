package myProtein.cart;

import java.util.List;

public class CartService {
	private CartDao cartDao;
	
	public CartService() throws Exception {
		cartDao = new CartImplMyBatis();
	}
	
	public int addCart(String u_id,int p_no,int c_qty) throws Exception {
		if (cartDao.cartRowCount(u_id,p_no) > 0) {
			return cartDao.updateByU_Id(u_id,p_no,c_qty);
		}
		return cartDao.insert(u_id,p_no,c_qty);
	}
	public int removeCartByC_No(int c_no) throws Exception {
		return cartDao.deleteByC_No(c_no);
	}
	public int removeCartByU_Id(String u_id) throws Exception {
		return cartDao.deleteByU_Id(u_id);
	}
	public int updateByC_No(int c_qty,int c_no) throws Exception {
		return cartDao.updateByC_No(c_qty, c_no);
	}
	public int updateByU_Id(String u_id,int p_no, int c_qty) throws Exception {
		return cartDao.updateByU_Id(u_id, p_no, c_qty);
	}
	public List<Cart> findAll(String u_id) throws Exception {
		return cartDao.findCartListByU_Id(u_id);
	}
	public Cart findCartItemByCartNo(int c_no) throws Exception{
		return cartDao.findByCartNo(c_no);
	}
}
