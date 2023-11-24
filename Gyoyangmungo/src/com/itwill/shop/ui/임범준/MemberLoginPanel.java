package com.itwill.shop.ui.임범준;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberService;
import com.itwill.shop.ui.Main2;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MemberLoginPanel extends JPanel {
	private JTextField memberLoginIdTF;
	private JTextField memberLoginPwTF;
	
	
	
	private Main2 mainFrame;	
	private MemberService memberService;
	
	private JLabel memberLoginIdMsgLB;
	private JLabel memberLoginPwMsgLB;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public MemberLoginPanel() throws Exception {
		setLayout(new BorderLayout(0, 0));
		
		JPanel memberLoginPanel = new JPanel();
		add(memberLoginPanel, BorderLayout.CENTER);
		memberLoginPanel.setLayout(null);
		
		memberLoginIdTF = new JTextField();
		memberLoginIdTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memberLoginIdTF.setText("");
			}
		});
		memberLoginIdTF.setText("아이디");
		memberLoginIdTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberLoginIdTF.setColumns(10);
		memberLoginIdTF.setBounds(70, 222, 245, 35);
		memberLoginPanel.add(memberLoginIdTF);
		
		memberLoginPwTF = new JTextField();
		memberLoginPwTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memberLoginPwTF.setText("");
			}
		});
		memberLoginPwTF.setText("비밀번호");
		memberLoginPwTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberLoginPwTF.setColumns(10);
		memberLoginPwTF.setBounds(70, 290, 245, 35);
		memberLoginPanel.add(memberLoginPwTF);
		
		JButton loginButton = new JButton("로그인");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***********입력 유효성체크********/
			try {
				String userid = memberLoginIdTF.getText();
				String password = memberLoginPwTF.getText();
				if (userid.equals("")) {
					memberLoginIdMsgLB.setText("아이디를 입력하세요.");
					memberLoginIdMsgLB.requestFocus();
					return;
				}
				if (password.equals("")) {
					memberLoginPwMsgLB.setText("패쓰워드를 입력하세요.");
					memberLoginPwMsgLB.requestFocus();
					return;
				}
				System.out.println(mainFrame);
				
					int result = mainFrame.memberService.login(userid, password);
					if (result == 1) {
						loginProcess(userid);
						mainFrame.shopTabbedPane.setSelectedIndex(0);
						
					} else if (result == 0) {
						memberLoginIdMsgLB.setText("정보가 틀리네??");
						memberLoginIdTF.requestFocus();
						memberLoginIdTF.setSelectionStart(0);
						memberLoginIdTF.setSelectionEnd(userid.length());
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		
			
		});
		loginButton.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		loginButton.setBounds(327, 222, 103, 103);
		memberLoginPanel.add(loginButton);
		
		JButton memberInsertButton = new JButton("회원가입");
		memberInsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.memberTabbedpane.setSelectedIndex(1);
			}
		});
		memberInsertButton.setForeground(Color.BLACK);
		memberInsertButton.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		memberInsertButton.setBounds(70, 358, 360, 54);
		memberLoginPanel.add(memberInsertButton);
		
		JLabel loginLogo = new JLabel("로고들어갈예정");
		loginLogo.setIcon(new ImageIcon(MemberLoginPanel.class.getResource("/com/itwill/shop/image/Login.png")));
		loginLogo.setPreferredSize(new Dimension(60, 50));
		loginLogo.setBounds(174, 70, 120, 120);
		memberLoginPanel.add(loginLogo);
		
		memberLoginIdMsgLB = new JLabel("");
		memberLoginIdMsgLB.setForeground(Color.RED);
		memberLoginIdMsgLB.setBounds(80, 260, 235, 26);
		memberLoginPanel.add(memberLoginIdMsgLB);
		
		memberLoginPwMsgLB = new JLabel("");
		memberLoginPwMsgLB.setForeground(Color.RED);
		memberLoginPwMsgLB.setBounds(80, 330, 235, 26);
		memberLoginPanel.add(memberLoginPwMsgLB);

		
		memberService = new MemberService();

	} // 생성자끝
	public void setMainFrame(Main2 mainFrame) {
		this.mainFrame = mainFrame;
	}
	


	/**************로그인성공시 호출할메쏘드***************/
	void loginProcess(String userId) throws Exception{
		/***********로그인성공시 해야할일***********
		 1.로그인성공한 멤버객체 멤버필드에저장
		 2.MemberMainFrame타이틀변경
		 3.로그인,회원가입탭 불활성화
		   회원정보       탭 활성화
		   로그인,회원가입 메뉴아이템 불활성화
		   로그아웃 메뉴아이템 활성화
		   
		   
		 4.회원정보보기 화면전환
		********************************************/
		mainFrame.loginMember = mainFrame.memberService.findUser(userId);
		System.out.println("로그인성공");
		mainFrame.shopTabbedPane.setEnabledAt(3, true);
		mainFrame.shopTabbedPane.setEnabledAt(4, true);
		mainFrame.cartPanel.displayCartList();
		mainFrame.orderPanel.displayOrderList();
		if(mainFrame.loginMember.getM_Id().equals("admin")) {
			mainFrame.memberTabbedpane.setEnabledAt(0,false);
			mainFrame.memberTabbedpane.setEnabledAt(1,false );
			mainFrame.memberTabbedpane.setEnabledAt(2,true);
			
//			memberTabbedPane.setEnabledAt(4,true);
			mainFrame.memberTabbedpane.setSelectedIndex(2);

		}else {
			mainFrame.memberTabbedpane.setEnabledAt(0,false );
			mainFrame.memberTabbedpane.setEnabledAt(1,false );
			mainFrame.memberTabbedpane.setEnabledAt(2,true);
			mainFrame.memberTabbedpane.setSelectedIndex(2);
			mainFrame.shopTabbedPane.setSelectedIndex(0);
//			mainFrame.memberInfoPanel.memberInfo(mainFrame.loginMember);
			mainFrame.memberInfoPanel.memberInfo(mainFrame.loginMember);
		
		}
	}
	
	
	public void logoutProcess() {
		
		mainFrame.loginMember = null;
		
		memberLoginIdTF.setText("");
		memberLoginPwTF.setText("");
		
		
		mainFrame.memberTabbedpane.setEnabledAt(0, true);
		mainFrame.memberTabbedpane.setEnabledAt(1, true);
		mainFrame.memberTabbedpane.setEnabledAt(2, false);
		
		mainFrame.shopTabbedPane.setEnabledAt(3, false);
		mainFrame.shopTabbedPane.setEnabledAt(4, false);
	}
	
	
	
	
}