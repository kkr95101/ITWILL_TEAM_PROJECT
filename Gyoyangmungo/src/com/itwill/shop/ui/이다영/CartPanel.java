package com.itwill.shop.ui.이다영;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.member.Member;
import com.itwill.shop.ui.Main2;

public class CartPanel extends JPanel {
	
	/********Service************/
	
	public JButton deleteAllButton;
	private JLabel cartTotalPriceLabel;
	private JPanel cartListContentPanel;
	private JPanel cartListPanel;
	/****Frame*****/
	private Main2 mainFrame;
	
	int totPrice = 0;
	private JPanel cartBottomPanel;
	private JPanel cartContentPanel;
	private JScrollPane scrollPane;
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public CartPanel() throws Exception { // 생성자 시작
		setPreferredSize(new Dimension(460, 500)); 
		setLayout(new BorderLayout(0, 0));
		
		cartContentPanel = new JPanel();
		add(cartContentPanel, BorderLayout.CENTER);
		cartContentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel cartTopPanel = new JPanel();
		cartTopPanel.setBackground(new Color(224, 255, 255));
		cartTopPanel.setPreferredSize(new Dimension(10, 50));
		cartContentPanel.add(cartTopPanel, BorderLayout.NORTH);
		cartTopPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("장바구니");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("휴먼엑스포", Font.PLAIN, 25));
		lblNewLabel.setBounds(116, 7, 150, 30);
		cartTopPanel.add(lblNewLabel);
		
		// 카트 전체삭제
		deleteAllButton = new JButton("전체 삭제");
		deleteAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mainFrame.cartService.deleteCartItemByUserId(mainFrame.loginMember.getM_Id());
					JOptionPane.showMessageDialog(null, "전체상품이 삭제되었습니다.");
					displayCartList();
					mainFrame.shopTabbedPane.setSelectedIndex(-1);
					mainFrame.shopTabbedPane.setSelectedIndex(3);
					cartTotalPriceLabel.setText("");
				} catch (Exception e1) {
					//
				}
			}
		});
		
		deleteAllButton.setBounds(325, 14, 89, 23);
		cartTopPanel.add(deleteAllButton);
		
		cartBottomPanel = new JPanel();
		cartBottomPanel.setBackground(new Color(224, 255, 255));
		cartBottomPanel.setPreferredSize(new Dimension(10, 80));
		cartContentPanel.add(cartBottomPanel, BorderLayout.SOUTH);
		cartBottomPanel.setLayout(null);
		
		JLabel cartTotalLabel = new JLabel("총 상품금액 : ");
		cartTotalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cartTotalLabel.setFont(new Font("굴림", Font.BOLD, 15));
		cartTotalLabel.setBounds(10, 22, 115, 30);
		cartBottomPanel.add(cartTotalLabel);
		
		// 카트 총 상품금액이 나오는 곳
		cartTotalPriceLabel = new JLabel("");
		cartTotalPriceLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		cartTotalPriceLabel.setBounds(134, 22, 130, 30);
		cartBottomPanel.add(cartTotalPriceLabel);
		
		JButton selectedItemOrderButton = new JButton("주문하기");
		selectedItemOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					mainFrame.orderService.create(mainFrame.loginMember.getM_Id());
					mainFrame.orderPanel.displayOrderList();
					mainFrame.shopTabbedPane.setSelectedIndex(4);
					mainFrame.cartService.deleteCartItemByUserId(mainFrame.loginMember.getM_Id());
					mainFrame.cartPanel.displayCartList();
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				
				
				
			}
		});
		selectedItemOrderButton.setFont(new Font("굴림", Font.PLAIN, 20));
		selectedItemOrderButton.setBounds(294, 10, 142, 60);
		cartBottomPanel.add(selectedItemOrderButton);
		
		cartListPanel = new JPanel();
		cartListPanel.setBackground(new Color(224, 255, 255));
		cartContentPanel.add(cartListPanel, BorderLayout.CENTER);
		cartListPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(460, 2000));
		scrollPane.setBounds(0, 0, 460, 370);
		cartListPanel.add(scrollPane);
		
		// 카트 리스트
		cartListContentPanel = new JPanel();
		cartListContentPanel.setBackground(new Color(224, 255, 255));
		cartListContentPanel.setPreferredSize(new Dimension(350, 2000));
		scrollPane.setViewportView(cartListContentPanel);
		
		JPanel itemPanel = new JPanel(); // 카트 상품 디테일
		itemPanel.setBackground(Color.WHITE);
		itemPanel.setPreferredSize(new Dimension(440, 230));
		itemPanel.setLayout(null);
		cartListContentPanel.add(itemPanel);
		
		// 카트 상품 이미지 
		JLabel bookItemImageLabel = new JLabel("이미지");
		bookItemImageLabel.setBounds(82, 50, 81, 96);
		itemPanel.add(bookItemImageLabel);
		
		JLabel bookTitleLabel = new JLabel("책 이름");
		bookTitleLabel.setFont(new Font("굴림", Font.BOLD, 15));
		bookTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bookTitleLabel.setBounds(186, 49, 230, 40);
		itemPanel.add(bookTitleLabel);
		
		JLabel bookPriceLabel = new JLabel("");
		bookPriceLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		bookPriceLabel.setBounds(296, 115, 120, 23);
		itemPanel.add(bookPriceLabel);
		
		// 카트 상품 수량
		JComboBox itemQtyComboBox = new JComboBox();
		itemQtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		itemQtyComboBox.setBounds(244, 176, 40, 30);
		itemPanel.add(itemQtyComboBox);
		
		
		JButton	deleteButton = new JButton("삭제");
		deleteButton.setBounds(296, 175, 80, 30);
		itemPanel.add(deleteButton);
		
		JLabel priceLabel = new JLabel("상품금액  : ");
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setFont(new Font("굴림", Font.BOLD, 15));
		priceLabel.setBounds(199, 116, 100, 30);
		itemPanel.add(priceLabel);
		
		itemPanel.removeAll();

	
			
		
			
	} // 생성자 끝
	
	public void setMainFrame(Main2 mainFrame) throws Exception {
		this.mainFrame=mainFrame;
		
	}
	
	
	
	public void displayCartList() throws Exception{
			
			JCheckBox[] cartCB = null;
			cartListContentPanel.removeAll();
			List<Cart> cartList = mainFrame.cartService.findCartItemByAll(mainFrame.loginMember.getM_Id());
			totPrice = 0;
			cartCB = new JCheckBox[cartList.size()];
			/*********************for문 시작*****************/
			for(Cart cart : cartList) {
				// 카트 상품 디테일 패널
				JPanel itemPanel = new JPanel();
				itemPanel.setBackground(new Color(255, 255, 255));
				itemPanel.setPreferredSize(new Dimension(420, 230));
				itemPanel.setLayout(null);
				cartListContentPanel.add(itemPanel);

				
				
				// 카트 상품 이미지 가져오기
				JLabel bookItemImageLabel = new JLabel();
				bookItemImageLabel.setIcon(new ImageIcon(CartPanel.class.getResource("/com/itwill/shop/image/"+cart.getProduct().getP_image())));
				bookItemImageLabel.setBounds(50, 10, 120, 175);
				itemPanel.add(bookItemImageLabel);

				
				totPrice = totPrice + cart.getCart_qty() * cart.getProduct().getP_price();
				cartTotalPriceLabel.setText(new DecimalFormat("#,###원").format(totPrice));
				
				
				//카트 상품 수량에따른 가격
				JLabel bookPriceLabel = new JLabel("");
				bookPriceLabel.setText(new DecimalFormat("#,###원").format(cart.getProduct().getP_price() * cart.getCart_qty()));
				bookPriceLabel.setFont(new Font("굴림", Font.PLAIN, 15));
				bookPriceLabel.setBounds(296, 116, 120, 30);
				itemPanel.add(bookPriceLabel);
				
				// 카트 상품 제목 가져오기
				JLabel bookTitleLabel = new JLabel("책 이름");
				bookTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
				bookTitleLabel.setText(cart.getProduct().getP_name());
				bookTitleLabel.setFont(new Font("굴림", Font.BOLD, 16));
				bookTitleLabel.setBounds(186, 49, 230, 40);
				itemPanel.add(bookTitleLabel);
				
				
				JLabel priceLabel = new JLabel("상품금액  : ");
				priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
				priceLabel.setFont(new Font("굴림", Font.BOLD, 15));
				priceLabel.setBounds(176, 116, 120, 30);
				itemPanel.add(priceLabel);
				
				
				// 카트 상품 수량 수정 (콤보박스)
				JComboBox itemQtyComboBox = new JComboBox();
				itemQtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
				itemQtyComboBox.setBounds(244, 176, 40, 30);
				itemQtyComboBox.setSelectedItem(cart.getCart_qty() + "");
				itemPanel.add(itemQtyComboBox);
				itemQtyComboBox.addItemListener(new ItemListener() {
					private Cart c = cart;
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange() == ItemEvent.SELECTED) {
							//카트 갯수에따른 총금액
							try {
								c.setCart_qty(c.getCart_qty());
								totPrice = totPrice - c.getCart_qty() * c.getProduct().getP_price();
								String cartSelectedQtyStr = (String)itemQtyComboBox.getSelectedItem();
								int cartSelectedQty = Integer.parseInt(cartSelectedQtyStr);
								int updateCartQty = mainFrame.cartService.updateCart(c.getCart_no(), cartSelectedQty);
								c.setCart_qty(cartSelectedQty);
								// 카트아이템총가격변경
								bookPriceLabel.setText(new DecimalFormat("#,###원").format(c.getProduct().getP_price() * cartSelectedQty));
								totPrice = totPrice + c.getProduct().getP_price() * cartSelectedQty;
								cartTotalPriceLabel.setText(new DecimalFormat("#,###원").format(totPrice));
								
								
								
							}catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					}
				});
				
				
				// 카트 리스트 안에서 삭제 버튼 누르면 상품 삭제
				JButton	deleteButton = new JButton("삭제");
				deleteButton.addActionListener(new ActionListener() {
					private Cart c = cart;			
					public void actionPerformed(ActionEvent e) {
						// 삭제 메소드, m_id인자 들어와야함.
						// 카트 총액
						try {
							int deleteItemCount = mainFrame.cartService.deleteCartItemByCartNo(cart.getCart_no());
							JOptionPane.showMessageDialog(null, "상품이 삭제되었습니다");
							
							
							displayCartList();
							cartTotalPriceLabel.setText(new DecimalFormat("#,###원").format(totPrice));
							
							mainFrame.shopTabbedPane.setSelectedIndex(-1);
							mainFrame.shopTabbedPane.setSelectedIndex(3);
							
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				
				deleteButton.setBounds(296, 175, 80, 30);
				deleteButton.setFont(new Font("굴림", Font.BOLD, 15));
				itemPanel.add(deleteButton);
				
				cartListContentPanel.add(itemPanel);
				
				//카트 아이템 디테일 끝
				
			
			} /**************** for문 끝 *****************/
			
				
	} // displayCartList() 끝
	
	public String addCartListTotal() throws Exception {
		return Integer.toString(mainFrame.cartService.addCartListTotal(mainFrame.loginMember.getM_Id()));
		
	}
	
	
	
	public void resetCart() throws Exception {
		cartTotalPriceLabel.setText(addCartListTotal() + "원");
		displayCartList();
	}
}