package com.itwill.shop.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.itwill.shop.cart.CartService;
import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberService;
import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderItem;
import com.itwill.shop.order.OrderService;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;
import com.itwill.shop.ui.권경록.ProductDetailPanel;
import com.itwill.shop.ui.배종호.MainCategoryPanel;
import com.itwill.shop.ui.이다영.CartPanel;
import com.itwill.shop.ui.이동현.ProductBestSellerListPanel;
import com.itwill.shop.ui.이동현.ProductNovelListPanel;
import com.itwill.shop.ui.이동현.ProductSearchPanel;
import com.itwill.shop.ui.이동현.ProductSelfImprovementListPanel;
import com.itwill.shop.ui.임범준.MemberCreatePanel;
import com.itwill.shop.ui.임범준.MemberInfoPanel;
import com.itwill.shop.ui.임범준.MemberLoginPanel;
import com.itwill.shop.ui.임범준.OrderPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class Main2 extends JFrame {
	/************ 1.Service객체멤버변수선언 ************/
	public ProductService productService;
	public OrderService orderService;
	public MemberService memberService;
	public CartService cartService;
	public OrderItem orderItem;
	public Order order;
	
	public Main2 mainFrame;

	/********* 2.로그인한회원 멤버필드선언 *****/
	public Member loginMember =null; 

	private JPanel contentPane;
	public JTextField searchTextField;
	public MemberLoginPanel loginPanel;
	private MemberCreatePanel memberCreatePanel;
	private MemberLoginPanel memberLoginPanel;
	public JTabbedPane memberTabbedpane;
	public JTabbedPane productTabbedPane;
	private ProductNovelListPanel productNovelListPanel;
	private ProductBestSellerListPanel productBestSellerListPanel;
	private ProductSelfImprovementListPanel productSelfImprovementListPanel;
	private JPanel productBestSellerPanel;
	private JPanel productNovel;
	private JPanel productSelfImprovement;
	public JTabbedPane shopTabbedPane;
	private ProductDetailPanel productDetailPanel;
	public CartPanel cartPanel;
	private MainCategoryPanel mainCategoryPanel;
	private ProductSearchPanel productSearchPanel;
	public OrderPanel orderPanel;
	public MemberInfoPanel memberInfoPanel;
	private JLabel logoutLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main2 frame = new Main2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public Main2() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel northPanel = new JPanel();
		northPanel.setBackground(new Color(255, 255, 255));
		northPanel.setPreferredSize(new Dimension(10, 40));
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(null);

		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(Main2.class.getResource("/com/itwill/shop/image/logo.png")));
		logoLabel.setBounds(42, 0, 50, 40);
		northPanel.add(logoLabel);

		JLabel cartLogoLabel = new JLabel("");
		cartLogoLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cartLogoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(loginMember != null) {
					shopTabbedPane.setSelectedIndex(3);
					
				} else {
					shopTabbedPane.setSelectedIndex(1);
					memberTabbedpane.setSelectedIndex(0);
					JOptionPane.showMessageDialog(null, "로그인이 필요한 서비스입니다.");
				}
				
			}
		});
				
//					shopTabbedPane.setSelectedIndex(3);
				
		cartLogoLabel.setIcon(new ImageIcon(Main2.class.getResource("/com/itwill/shop/image/cart.png")));
		cartLogoLabel.setBounds(418, 0, 46, 40);
		northPanel.add(cartLogoLabel);

		searchTextField = new JTextField();
		searchTextField.setBounds(145, 10, 131, 21);
		northPanel.add(searchTextField);
		searchTextField.setColumns(10);

		JLabel searchLabel = new JLabel("");
		searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchLabel.setIcon(new ImageIcon(Main2.class.getResource("/com/itwill/shop/image/search_image20.png")));
		searchLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (searchTextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "검색어를 입력하세요.");
				}else {
					productTabbedPane.setSelectedIndex(-1);
					productTabbedPane.setSelectedIndex(4);
					try {
						changePanel(2, 4, -1, null);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					productTabbedPane.setEnabledAt(4, true);
				}
			}
		});
		searchLabel.setBounds(277, 0, 26, 40);
		northPanel.add(searchLabel);
		
		logoutLabel = new JLabel("");
		logoutLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logoutLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memberLoginPanel.logoutProcess();
				shopTabbedPane.setSelectedIndex(1);
				memberTabbedpane.setSelectedIndex(0);
			}
		});
		logoutLabel.setIcon(new ImageIcon(Main2.class.getResource("/com/itwill/shop/image/logout.png")));
		logoutLabel.setBounds(315, 10, 102, 30);
		northPanel.add(logoutLabel);

		shopTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (shopTabbedPane.getSelectedIndex() == 0) {
					
				}
				if (shopTabbedPane.getSelectedIndex() == 1) {
					
				}
				if (shopTabbedPane.getSelectedIndex() == 2) {
					
				}
				if (shopTabbedPane.getSelectedIndex() == 3) {
					
				}
				if (shopTabbedPane.getSelectedIndex() == 4) {
					try {
						orderPanel.displayOrderList();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (shopTabbedPane.getSelectedIndex() == 2) {
					productTabbedPane.setSelectedIndex(0);
				}
			}
		});
		shopTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPane.add(shopTabbedPane, BorderLayout.CENTER);
		
		mainCategoryPanel = new MainCategoryPanel();
		shopTabbedPane.addTab("메인", null, mainCategoryPanel, null);

		memberTabbedpane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("회원", null, memberTabbedpane, null);

		memberLoginPanel = new MemberLoginPanel();
		memberTabbedpane.addTab("로그인", null, memberLoginPanel, null);

		memberCreatePanel = new MemberCreatePanel();
		memberTabbedpane.addTab("회원가입", null, memberCreatePanel, null);
		
		memberInfoPanel = new MemberInfoPanel();
		memberTabbedpane.addTab("회원정보", null, memberInfoPanel, null);
		
		productTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		productTabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				/****************************************************************/

				try {
					if (productBestSellerListPanel == null ||
							productNovelListPanel == null  || 
							productSelfImprovementListPanel == null ||
							productSearchPanel == null) {
						return;
					}
					if (productTabbedPane.getSelectedIndex() == 0) {
						productBestSellerListPanel.displayBestSellerList();
					} else if (productTabbedPane.getSelectedIndex() == 1) {
						productNovelListPanel.displayBestSellerList();
					} else if (productTabbedPane.getSelectedIndex() == 2) {
						productSelfImprovementListPanel.displayBestSellerList();
					} else if (productTabbedPane.getSelectedIndex() == 3) {
						productDetailPanel.displayProductDetail();
					} else if (productTabbedPane.getSelectedIndex() == 4) {
						productSearchPanel.displaySearchList(searchTextField.getText());
					}

				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});
		shopTabbedPane.addTab("상품", null, productTabbedPane, null);

		productBestSellerPanel = new JPanel();
		productTabbedPane.addTab("베스트셀러", null, productBestSellerPanel, null);
		productBestSellerPanel.setLayout(new BorderLayout(0, 0));

		productBestSellerListPanel = new ProductBestSellerListPanel();

		productBestSellerPanel.add(productBestSellerListPanel, BorderLayout.CENTER);

		productNovel = new JPanel();
		productTabbedPane.addTab("소설", null, productNovel, null);
		productNovel.setLayout(new BorderLayout(0, 0));

		productNovelListPanel = new ProductNovelListPanel();
		productNovel.add(productNovelListPanel, BorderLayout.CENTER);

		productSelfImprovement = new JPanel();
		productTabbedPane.addTab("자기계발", null, productSelfImprovement, null);
		productSelfImprovement.setLayout(new BorderLayout(0, 0));

		productSelfImprovementListPanel = new ProductSelfImprovementListPanel();
		productSelfImprovement.add(productSelfImprovementListPanel, BorderLayout.CENTER);

		productDetailPanel = new ProductDetailPanel();
		productDetailPanel.setBackground(Color.WHITE);
		productTabbedPane.addTab("상세보기", null, productDetailPanel, null);
		productTabbedPane.setEnabledAt(3, false);
		
		productSearchPanel = new ProductSearchPanel();
		productTabbedPane.addTab("검색결과", null, productSearchPanel, null);
		productTabbedPane.setEnabledAt(4, false);
		
		cartPanel = new CartPanel();
		shopTabbedPane.addTab("장바구니", null, cartPanel, null);
		shopTabbedPane.setEnabledAt(3, false);
		
		orderPanel = new OrderPanel();
		shopTabbedPane.addTab("주문", null, orderPanel, null);
		shopTabbedPane.setEnabledAt(4, false);
		
		
		
		
		productTabbedPane.setSelectedIndex(-1);
		

		memberService = new MemberService();
		productService = new ProductService();
		cartService = new CartService();
		orderService = new OrderService();

		
		productBestSellerListPanel.setMainFrame(this);
		productNovelListPanel.setMainFrame(this);
		productSelfImprovementListPanel.setMainFrame(this);
		mainCategoryPanel.setMainFrame(this);
		productDetailPanel.setMainFrame(this);
		productSearchPanel.setMainFrame(this);
		cartPanel.setMainFrame(this);
		memberLoginPanel.setMainFrame(this);
		memberCreatePanel.setMainFrame(this);
		memberInfoPanel.setMainFrame(this);
		orderPanel.setMainFrame(this);
		
		
		
		
		
		
		

	}// 생성자
	
	
	
	public void setMainFrame(Main2 mainFrame) {
		this.mainFrame = mainFrame;
	}
	

	public void changePanel(int shopTabbedPaneNo, int productTabbedPaneNo, int memberTabbedPaneNo, Map data){
		if (shopTabbedPaneNo == 0) {

			// 메인
			shopTabbedPane.setSelectedIndex(shopTabbedPaneNo);
		} else if (shopTabbedPaneNo == 1) {
			// 회원
			shopTabbedPane.setSelectedIndex(shopTabbedPaneNo);
			if (memberTabbedPaneNo == 0) {
				// 로그인
				memberTabbedpane.setSelectedIndex(memberTabbedPaneNo);
			} else if (memberTabbedPaneNo == 1) {
				// 회원가입
			}
		} else if (shopTabbedPaneNo == 2) {
			shopTabbedPane.setSelectedIndex(shopTabbedPaneNo);
			// 상품
			if (productTabbedPaneNo == 0) {
				// 베스트셀러
				productTabbedPane.setSelectedIndex(productTabbedPaneNo);
			} else if (productTabbedPaneNo == 1) {
				// 소설
				productTabbedPane.setSelectedIndex(productTabbedPaneNo);
			} else if (productTabbedPaneNo == 2) {
				// 자기계발
				productTabbedPane.setSelectedIndex(productTabbedPaneNo);
			} else if (productTabbedPaneNo == 3) {
				// 디테일
				Product p = (Product) data.get("product");
				productDetailPanel.setProduct(p);
				shopTabbedPane.setSelectedIndex(2);
				productTabbedPane.setSelectedIndex(3);
			} else if(productTabbedPaneNo == 4) {
				productTabbedPane.setSelectedIndex(productTabbedPaneNo);
			}
		} else if (shopTabbedPaneNo == 3) {
			// 장바구니
			shopTabbedPane.setSelectedIndex(shopTabbedPaneNo);
		} else if (shopTabbedPaneNo == 4) {
			// 주문내역
			shopTabbedPane.setSelectedIndex(shopTabbedPaneNo);
			
		}

	}
	
	
	
	
}



