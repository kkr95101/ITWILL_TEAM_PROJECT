package com.itwill.shop.ui.배종호;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.itwill.shop.ui.Main2;

public class MainCategoryPanel extends JPanel {
	
	private Main2 mainFrame;
	
	JScrollPane scrollPane = new JScrollPane();
		public MainCategoryPanel() throws Exception{
			setPreferredSize(new Dimension(500, 776));
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(2, 480));
		//scrollPane.setPreferredSize(new Dimension(460, 500));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 475, 557);
		add(scrollPane);
		
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setBackground(Color.WHITE);
		
		
		
		backgroundPanel.setPreferredSize(new Dimension(10, 800));
		scrollPane.setViewportView(backgroundPanel);
		backgroundPanel.setLayout(null);
		
		JPanel bestPanel = new JPanel();
		bestPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uBCA0\uC2A4\uD2B8\uC140\uB7EC", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		bestPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bestPanel.setBackground(new Color(245, 245, 245));
		bestPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.changePanel(2,0, -1, null);
			}
		});
		bestPanel.setBounds(11, 6, 433, 227);
		backgroundPanel.add(bestPanel);
		bestPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setIcon(new ImageIcon(MainCategoryPanel.class.getResource("/com/itwill/shop/image/bestSeller1.jpg")));
		lblNewLabel.setBounds(19, 26, 118, 159);
		bestPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setIcon(new ImageIcon(MainCategoryPanel.class.getResource("/com/itwill/shop/image/bestSeller2.jpg")));
		lblNewLabel_1.setBounds(156, 26, 118, 159);
		bestPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2.setIcon(new ImageIcon(MainCategoryPanel.class.getResource("/com/itwill/shop/image/bestSeller3.jpg")));
		lblNewLabel_2.setBounds(293, 26, 118, 159);
		bestPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("<html>문과남자의<br> 과학공부</html>");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_4.setBounds(16, 185, 118, 36);
		bestPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("<html>스킵과로퍼6</html>");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_5.setBounds(155, 185, 118, 36);
		bestPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("<html>도둑맞은 집중력</html>");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_6.setBounds(294, 185, 118, 36);
		bestPanel.add(lblNewLabel_6);
		
		JPanel bestPanel_1 = new JPanel();
		bestPanel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.changePanel(2,1, -1, null);
			}
		});
		bestPanel_1.setBorder(new TitledBorder(null, "\uC18C\uC124", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bestPanel_1.setLayout(null);
		bestPanel_1.setBackground(new Color(245, 245, 245));
		bestPanel_1.setBounds(13, 235, 433, 227);
		backgroundPanel.add(bestPanel_1);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(MainCategoryPanel.class.getResource("/com/itwill/shop/image/novel1.jpg")));
		lblNewLabel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7.setBounds(19, 26, 118, 159);
		bestPanel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(MainCategoryPanel.class.getResource("/com/itwill/shop/image/novel2.jpg")));
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_1.setBounds(156, 26, 118, 159);
		bestPanel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(MainCategoryPanel.class.getResource("/com/itwill/shop/image/novel3.jpg")));
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setBounds(293, 26, 118, 159);
		bestPanel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("<html>꿀벌의예언1편</html>");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_4_1.setBounds(18, 187, 118, 36);
		bestPanel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_3 = new JLabel("<html>있을법한모든것</html>");
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_4_3.setBounds(156, 187, 118, 36);
		bestPanel_1.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("<html>꿀벌의예언2편</html>");
		lblNewLabel_4_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_4.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_4_4.setBounds(294, 187, 118, 36);
		bestPanel_1.add(lblNewLabel_4_4);
		
		JPanel bestPanel_2 = new JPanel();
		bestPanel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.changePanel(2,2, -1, null);
			}
		});
		bestPanel_2.setBorder(new TitledBorder(null, "\uC790\uAE30\uAC1C\uBC1C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bestPanel_2.setLayout(null);
		bestPanel_2.setBackground(new Color(245, 255, 250));
		bestPanel_2.setBounds(15, 471, 433, 227);
		backgroundPanel.add(bestPanel_2);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(MainCategoryPanel.class.getResource("/com/itwill/shop/image/selfImprovement1.jpg")));
		lblNewLabel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8.setBounds(19, 26, 118, 159);
		bestPanel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(MainCategoryPanel.class.getResource("/com/itwill/shop/image/selfImprovement2.jpg")));
		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setBounds(156, 26, 118, 159);
		bestPanel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(MainCategoryPanel.class.getResource("/com/itwill/shop/image/selfImprovement3.jpg")));
		lblNewLabel_2_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_2.setBounds(293, 26, 118, 159);
		bestPanel_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("<html>세이노의가르침</html>");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_4_1_1.setBounds(21, 187, 118, 36);
		bestPanel_2.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("<html>최적의공부뇌</html>");
		lblNewLabel_4_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_2.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_4_1_2.setBounds(158, 187, 118, 36);
		bestPanel_2.add(lblNewLabel_4_1_2);
		
		JLabel lblNewLabel_4_1_3 = new JLabel("<html>역행자</html>");
		lblNewLabel_4_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_3.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_4_1_3.setBounds(295, 187, 118, 36);
		bestPanel_2.add(lblNewLabel_4_1_3);
		
		
		
		
	}
		public void setMainFrame(Main2 main2) {
			this.mainFrame=main2;
			
		}
}



