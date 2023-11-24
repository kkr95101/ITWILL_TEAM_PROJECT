package com.itwill.shop.ui.임범준;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberService;
import com.itwill.shop.ui.Main2;

public class MemberCreatePanel extends JPanel {
	private JTextField memberJoinIdTF;
	private JTextField memberJoinPwTF;
	private JTextField memberJoinNameTF;
	private JTextField memberJoinPhoneTF;
	private JTextField memberJoinEmailTF;
	private JTextField memberJoinAddressTF;

	public Main2 mainFrame;
	public MemberService memberService;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public MemberCreatePanel() throws Exception {
		setLayout(new BorderLayout(0, 0));
		
		JPanel memberCreatePanel = new JPanel();
		add(memberCreatePanel, BorderLayout.CENTER);
		memberCreatePanel.setLayout(null);
		
		JLabel memberJoinTitleLB = new JLabel("회원가입");
		memberJoinTitleLB.setHorizontalAlignment(SwingConstants.CENTER);
		memberJoinTitleLB.setFont(new Font("굴림", Font.BOLD, 22));
		memberJoinTitleLB.setBounds(73, 32, 314, 29);
		memberCreatePanel.add(memberJoinTitleLB);
		
		memberJoinIdTF = new JTextField();
		memberJoinIdTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memberJoinIdTF.setText("");
			}
		});
		memberJoinIdTF.setText("아이디\r\n");
		memberJoinIdTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinIdTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinIdTF.setColumns(10);
		memberJoinIdTF.setBounds(93, 91, 287, 25);
		memberCreatePanel.add(memberJoinIdTF);
		
		memberJoinPwTF = new JTextField();
		memberJoinPwTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memberJoinPwTF.setText("");
			}
		});
		memberJoinPwTF.setText("비밀번호");
		memberJoinPwTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinPwTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinPwTF.setColumns(10);
		memberJoinPwTF.setBounds(93, 156, 287, 25);
		memberCreatePanel.add(memberJoinPwTF);
		
		JLabel memberJoinIdMsgLB = new JLabel("");
		memberJoinIdMsgLB.setHorizontalAlignment(SwingConstants.CENTER);
		memberJoinIdMsgLB.setForeground(Color.RED);
		memberJoinIdMsgLB.setBounds(103, 126, 277, 20);
		memberCreatePanel.add(memberJoinIdMsgLB);
		
		memberJoinNameTF = new JTextField();
		memberJoinNameTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memberJoinNameTF.setText("");
			}
		});
		memberJoinNameTF.setText("이름");
		memberJoinNameTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinNameTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinNameTF.setColumns(10);
		memberJoinNameTF.setBounds(93, 200, 287, 25);
		memberCreatePanel.add(memberJoinNameTF);
		
		memberJoinPhoneTF = new JTextField();
		memberJoinPhoneTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memberJoinPhoneTF.setText("");
			}
		});
		memberJoinPhoneTF.setText("전화번호");
		memberJoinPhoneTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinPhoneTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinPhoneTF.setColumns(10);
		memberJoinPhoneTF.setBounds(93, 243, 287, 25);
		memberCreatePanel.add(memberJoinPhoneTF);
		
		memberJoinEmailTF = new JTextField();
		memberJoinEmailTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memberJoinEmailTF.setText("");
			}
		});
		memberJoinEmailTF.setText("이메일");
		memberJoinEmailTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinEmailTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinEmailTF.setColumns(10);
		memberJoinEmailTF.setBounds(93, 289, 287, 25);
		memberCreatePanel.add(memberJoinEmailTF);
		
		memberJoinAddressTF = new JTextField();
		memberJoinAddressTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memberJoinAddressTF.setText("");
			}
		});
		memberJoinAddressTF.setText("주소");
		memberJoinAddressTF.setHorizontalAlignment(SwingConstants.LEFT);
		memberJoinAddressTF.setFont(new Font("굴림", Font.PLAIN, 18));
		memberJoinAddressTF.setColumns(10);
		memberJoinAddressTF.setBounds(93, 335, 287, 25);
		memberCreatePanel.add(memberJoinAddressTF);
		
		JButton memberJoinButton = new JButton("가입");
		memberJoinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String memberId = memberJoinIdTF.getText();
					boolean isDuplicate = mainFrame.memberService.isDuplicateId(memberId);
					if(isDuplicate) {
						memberJoinIdTF.setSelectionStart(0);
						memberJoinIdTF.setSelectionEnd(memberId.length());
						memberJoinIdTF.requestFocus();
						memberJoinIdMsgLB.setText("아이디가 존재합니다");
						return;
					}
					String password = memberJoinPwTF.getText();
					String name = memberJoinNameTF.getText();
					String phone = memberJoinPhoneTF.getText();
					String email = memberJoinEmailTF.getText();
					String address = memberJoinAddressTF.getText();
					Member member = new Member(memberId, password, name, phone, email, address);
					mainFrame.memberService.create(member);
					mainFrame.memberTabbedpane.setSelectedIndex(0);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	
			}
		});
		memberJoinButton.setFont(new Font("굴림", Font.BOLD, 20));
		memberJoinButton.setBounds(135, 405, 193, 50);
		memberCreatePanel.add(memberJoinButton);
		
		
		memberService = new MemberService();

	} // 생성자끝
	public void setMainFrame(Main2 mainFrame) {
		this.mainFrame = mainFrame;
	}
	
}
