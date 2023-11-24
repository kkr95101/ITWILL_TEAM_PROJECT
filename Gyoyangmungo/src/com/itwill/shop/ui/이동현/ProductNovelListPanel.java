package com.itwill.shop.ui.이동현;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;
import com.itwill.shop.ui.Main2;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductNovelListPanel extends JPanel {
	private JPanel productNovelListPanel;
	public Main2 mainFrame;
	/**
	 * Create the panel.
	 */
	public ProductNovelListPanel() throws Exception {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 460, 500);
		add(scrollPane);
		
		productNovelListPanel = new JPanel();
		productNovelListPanel.setBackground(SystemColor.menu);
		productNovelListPanel.setPreferredSize(new Dimension(420, 750));
		scrollPane.setViewportView(productNovelListPanel);
		productNovelListPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JPanel bestSellerListPanel = new JPanel();
		bestSellerListPanel.setBackground(Color.WHITE);
		bestSellerListPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bestSellerListPanel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bestSellerListPanel.setPreferredSize(new Dimension(420, 175));
		productNovelListPanel.add(bestSellerListPanel);
		bestSellerListPanel.setLayout(null);
		
		JLabel bestSellerImageLabel = new JLabel("");
		bestSellerImageLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		bestSellerImageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bestSellerImageLabel.setIcon(new ImageIcon(ProductBestSellerListPanel.class.getResource("/com/itwill/shop/image/bestSeller2.jpg")));
		bestSellerImageLabel.setBounds(0, 0, 120, 175);
		bestSellerListPanel.add(bestSellerImageLabel);
		
		JLabel bestSellerNameLabel = new JLabel("");
		bestSellerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bestSellerNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		bestSellerNameLabel.setBounds(132, 10, 276, 44);
		bestSellerListPanel.add(bestSellerNameLabel);
		
		JButton buyButton = new JButton("바로구매");
		buyButton.setBounds(294, 119, 80, 40);
		bestSellerListPanel.add(buyButton);
		
		JButton cartButton = new JButton("");
		cartButton.setIcon(new ImageIcon(ProductBestSellerListPanel.class.getResource("/com/itwill/shop/image/shopping_cart_icon.png")));
		cartButton.setBounds(232, 119, 50, 40);
		bestSellerListPanel.add(cartButton);
		
		JLabel saleLabel = new JLabel("판매가");
		saleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		saleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		saleLabel.setBounds(156, 64, 100, 30);
		bestSellerListPanel.add(saleLabel);
		
		JLabel priceLabel = new JLabel("원");
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		priceLabel.setBounds(258, 64, 150, 30);
		bestSellerListPanel.add(priceLabel);
		
		
		
		
	}
	
	public void displayBestSellerList() throws Exception {
		List<Product> novelList = mainFrame.productService.novelList();
		
		productNovelListPanel.removeAll();
		
		for (Product product : novelList) {
			JPanel bestSellerListPanel = new JPanel();
			bestSellerListPanel.setBackground(Color.WHITE);
			bestSellerListPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			bestSellerListPanel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			bestSellerListPanel.setPreferredSize(new Dimension(420, 175));
			productNovelListPanel.add(bestSellerListPanel);
			bestSellerListPanel.setLayout(null);
			
			JLabel bestSellerImageLabel = new JLabel("");
			bestSellerImageLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("click");
					Map data=new HashMap();
					data.put("product", product);
					mainFrame.changePanel(2,3,-1,data);
					mainFrame.productTabbedPane.setEnabledAt(3, true);
				}
			});
			bestSellerImageLabel.setIcon(new ImageIcon(ProductBestSellerListPanel.class.getResource("/com/itwill/shop/image/"+product.getP_image())));
			bestSellerImageLabel.setBounds(0, 0, 120, 175);
			bestSellerListPanel.add(bestSellerImageLabel);
			
			JLabel bestSellerNameLabel = new JLabel(product.getP_name());
			bestSellerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			bestSellerNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
			bestSellerNameLabel.setBounds(132, 10, 276, 44);
			bestSellerListPanel.add(bestSellerNameLabel);
			
			
			JComboBox cartComboBox = new JComboBox();
			cartComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
			cartComboBox.setBounds(170, 119, 50, 23);
			bestSellerListPanel.add(cartComboBox);
			
			JButton buyButton = new JButton("바로구매");
			buyButton.addActionListener(new ActionListener() {
				Product p = product;
				public void actionPerformed(ActionEvent e) {
					if (mainFrame.loginMember != null) {
						// 바로구매 누를시 주문창으로 가면서 oi생성
					try {
						String cartQtyStr = (String)cartComboBox.getSelectedItem();
						int cartQty = Integer.parseInt(cartQtyStr);
						mainFrame.orderService.create(mainFrame.loginMember.getM_Id(), product.getP_no(), cartQty);
						mainFrame.orderPanel.displayOrderList();
						mainFrame.changePanel(4, -1, -1, null);
						cartComboBox.setSelectedItem("1");
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else {
					mainFrame.changePanel(1, -1, 0, null);
					JOptionPane.showMessageDialog(null, "로그인이 필요한 서비스입니다.");
					cartComboBox.setSelectedItem("1");
				}
			}
			});
			buyButton.setBounds(294, 119, 90, 40);
			bestSellerListPanel.add(buyButton);
			
			JButton cartAddButton = new JButton("");
			cartAddButton.addActionListener(new ActionListener() {
				Product p = product;
				
				public void actionPerformed(ActionEvent e) {
					if (mainFrame.loginMember != null) {
						// 장바구니 상품 추가
					try {
						String cartQtyStr = (String)cartComboBox.getSelectedItem();
						int cartQty = Integer.parseInt(cartQtyStr);
						mainFrame.cartService.addCart(new Cart(0, cartQty, mainFrame.loginMember.getM_Id(), 
											new Product(p.getP_no(), p.getP_name(), p.getP_price(),
														p.getP_image(), p.getP_desc(), p.getP_category())));
						mainFrame.cartPanel.displayCartList();
						JOptionPane.showMessageDialog(null, "장바구니에 상품이 담겼습니다.");
						cartComboBox.setSelectedItem("1");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else {
					mainFrame.changePanel(1, -1, 0, null);
					JOptionPane.showMessageDialog(null, "로그인이 필요한 서비스입니다.");
					cartComboBox.setSelectedItem("1");
				}
			}
			});
			cartAddButton.setIcon(new ImageIcon(ProductBestSellerListPanel.class.getResource("/com/itwill/shop/image/shopping_cart_icon.png")));
			cartAddButton.setBounds(232, 119, 50, 40);
			bestSellerListPanel.add(cartAddButton);
			
			JLabel saleLabel = new JLabel("판매가");
			saleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			saleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
			saleLabel.setBounds(156, 64, 100, 30);
			bestSellerListPanel.add(saleLabel);
			
			JLabel priceLabel = new JLabel(product.getP_price()+"원");
			priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
			priceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
			priceLabel.setBounds(258, 64, 150, 30);
			bestSellerListPanel.add(priceLabel);
		}
		
		
	}
	public void setMainFrame(Main2 mainFrame) {
		this.mainFrame = mainFrame;
	}

}
