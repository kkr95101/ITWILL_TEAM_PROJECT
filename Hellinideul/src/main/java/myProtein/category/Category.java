package myProtein.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import myProtein.product.Product;



public class Category {
	
	private int p_category_no;
	private int p_parent_category_no;
	private String p_category_name;
	private Product product;
	
	
	public Category() {
	}




	public Category(int p_category_no, int p_parent_category_no, String p_category_name) {
		super();
		this.p_category_no = p_category_no;
		this.p_parent_category_no = p_parent_category_no;
		this.p_category_name = p_category_name;
	}



	public int getP_category_no() {
		return p_category_no;
	}



	public void setP_category_no(int p_category_no) {
		this.p_category_no = p_category_no;
	}



	public int getP_parent_category_no() {
		return p_parent_category_no;
	}



	public void setP_parent_category_no(int p_parent_category_no) {
		this.p_parent_category_no = p_parent_category_no;
	}



	public String getP_category_name() {
		return p_category_name;
	}



	public void setP_category_name(String p_category_name) {
		this.p_category_name = p_category_name;
	}


	@Override
	public String toString() {
		return "Category [p_category_no=" + p_category_no + ", p_parent_category_no=" + p_parent_category_no
				+ ", p_category_name=" + p_category_name + "]";
	}



	
	
}
