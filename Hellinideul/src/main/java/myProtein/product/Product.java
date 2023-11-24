package myProtein.product;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import myProtein.category.Category;

@AllArgsConstructor
@Getter
@Setter
@ToString

public class Product {
	private int p_no;
	private String p_name;
	private int p_price;
	private String p_image;
	private String p_desc;
	private int p_order_count;
	private int p_stock;
	private String p_size;
	private int p_category_no;
	private Category category1;
	private Category category2;
	
	public Product() {
		
	}

	

	
	
	
}
