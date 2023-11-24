package com.itwill.shop.ui.임범준;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.itwill.shop.order.Order;
import com.itwill.shop.ui.Main2;

public class OrderPanel extends JPanel {
	
	public Main2 mainFrame;
	private JPanel orderItemListPanel;
	private JPanel orderListTitlePanel;
	private JPanel orderPanel;
	private JPanel orderItemPanel;
	
	
	

	

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public OrderPanel() throws Exception {
		setPreferredSize(new Dimension(460, 500));
		
		setLayout(new BorderLayout(0, 0));
		
		orderPanel = new JPanel();
		orderPanel.setPreferredSize(new Dimension(10, 500));
		//orderPanel.setPreferredSize(new Dimension(10, 600));
		add(orderPanel, BorderLayout.CENTER);
		orderPanel.setLayout(null);
		
		orderListTitlePanel = new JPanel();
		orderListTitlePanel.setLayout(null);
		orderListTitlePanel.setBounds(12, 10, 434, 29);
		orderPanel.add(orderListTitlePanel);
		
		JLabel orderItemLB = new JLabel("주문 내역");
		orderItemLB.setHorizontalAlignment(SwingConstants.CENTER);
		orderItemLB.setFont(new Font("굴림", Font.BOLD, 20));
		orderItemLB.setBounds(117, 0, 189, 25);
		orderListTitlePanel.add(orderItemLB);
		
		JPanel orderListPanel = new JPanel();
		orderListPanel.setBackground(new Color(255, 255, 255));
		orderListPanel.setBounds(12, 49, 434, 452);
		orderPanel.add(orderListPanel);
		orderListPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane orderListScrollPane = new JScrollPane();
		orderListScrollPane.setPreferredSize(new Dimension(2, 300));
		orderListPanel.add(orderListScrollPane, BorderLayout.CENTER);
		
		orderItemListPanel = new JPanel();
		orderItemListPanel.setPreferredSize(new Dimension(10, 2000));
		orderListScrollPane.setViewportView(orderItemListPanel);
		orderItemListPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		/**********************order item********************/
		orderItemPanel = new JPanel();
		orderItemPanel.setPreferredSize(new Dimension(410, 200));
		orderItemListPanel.add(orderItemPanel);
		orderItemPanel.setLayout(null);
		
		JLabel orderItemImage = new JLabel("");
		orderItemImage.setIcon(new ImageIcon(OrderPanel.class.getResource("/com/itwill/shop/image/bestSeller1.jpg")));
		orderItemImage.setPreferredSize(new Dimension(120, 175));
		orderItemImage.setBounds(12, 10, 120, 175);
		orderItemPanel.add(orderItemImage);
		
		JLabel orderDescLB = new JLabel("주문이름");
		orderDescLB.setHorizontalAlignment(SwingConstants.CENTER);
		orderDescLB.setBounds(191, 68, 180, 15);
		orderItemPanel.add(orderDescLB);
		
		JLabel orderItemPriceTitleLB = new JLabel("최종결제금액");
		orderItemPriceTitleLB.setFont(new Font("굴림", Font.BOLD, 12));
		orderItemPriceTitleLB.setBounds(173, 127, 105, 41);
		orderItemPanel.add(orderItemPriceTitleLB);
		
		JLabel orderItemPriceLB = new JLabel("10000원");
		orderItemPriceLB.setBounds(300, 127, 93, 41);
		orderItemPanel.add(orderItemPriceLB);

	} // 생성자 종료
	
	public void setMainFrame(Main2 mainFrame) throws Exception{
		this.mainFrame = mainFrame;
	}
	
	
	public void displayOrderList() throws Exception {
		orderItemListPanel.removeAll();
		List<Order> orderList = mainFrame.orderService.orderWithOrderItemList(mainFrame.loginMember.getM_Id());
		
		for (Order order : orderList) {
			/**********************order item********************/
			orderItemPanel = new JPanel();
			orderItemPanel.setPreferredSize(new Dimension(410, 200));
			orderItemListPanel.add(orderItemPanel);
			orderItemPanel.setLayout(null);
			
			JLabel orderItemImage = new JLabel("");
			orderItemImage.setIcon(new ImageIcon(OrderPanel.class.getResource("/com/itwill/shop/image/"+order.getOrderItemList().get(0).getProduct().getP_image())));
			orderItemImage.setPreferredSize(new Dimension(120, 175));
			orderItemImage.setBounds(12, 10, 120, 175);
			orderItemPanel.add(orderItemImage);
			
			JLabel orderDescLB = new JLabel(order.getO_desc() + " 외"+(orderList.size()-1)+"건");
			orderDescLB.setHorizontalAlignment(SwingConstants.CENTER);
			orderDescLB.setBounds(191, 68, 180, 15);
			orderItemPanel.add(orderDescLB);
			
			JLabel orderItemPriceTitleLB = new JLabel("최종결제금액");
			orderItemPriceTitleLB.setFont(new Font("굴림", Font.BOLD, 12));
			orderItemPriceTitleLB.setBounds(173, 127, 105, 41);
			orderItemPanel.add(orderItemPriceTitleLB);
			
			JLabel orderItemPriceLB = new JLabel(new DecimalFormat("#,###원").format(mainFrame.orderService.orderNoPrice(mainFrame.loginMember.getM_Id(), order.getO_no())));
			orderItemPriceLB.setBounds(300, 127, 93, 41);
			orderItemPanel.add(orderItemPriceLB);
			
			
			/**************************************/
		}
	}
}	
				

		



	

