package com.itwill.shop.ui.임범준;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.itwill.shop.member.Member;
import com.itwill.shop.ui.Main2;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberInfoPanel extends JPanel {
	private JTextField memberInfoIdTF;
	private JTextField memberInfoPwTF;
	private JTextField memberInfoNameTF;
	private JTextField memberInfoPhoneTF;
	private JTextField memberInfoEmailTF;
	private JTextField memberInfoAddressTF;
	
	public Main2 mainFrame;
	private JLabel memberInfoTitleLB;
	private JButton updateBtn;
	private JButton updateBtn1;
	
	
	

	/**
	 * Create the panel.
	 */
	public MemberInfoPanel() throws Exception{
		setLayout(new BorderLayout(0, 0));
		
		JPanel memberInfoPanel = new JPanel();
		memberInfoPanel.setBackground(new Color(255, 255, 255));
		add(memberInfoPanel, BorderLayout.CENTER);
		memberInfoPanel.setLayout(null);
		
		memberInfoTitleLB = new JLabel("회원정보");
		memberInfoTitleLB.setFont(new Font("굴림", Font.BOLD, 20));
		memberInfoTitleLB.setHorizontalAlignment(SwingConstants.CENTER);
		memberInfoTitleLB.setBounds(124, 34, 185, 42);
		memberInfoPanel.add(memberInfoTitleLB);
		
		JLabel memberInfoIdLB = new JLabel("아이디");
		memberInfoIdLB.setBounds(71, 118, 73, 28);
		memberInfoPanel.add(memberInfoIdLB);
		
		JLabel memberInfoPwLB = new JLabel("비밀번호");
		memberInfoPwLB.setBounds(71, 166, 73, 28);
		memberInfoPanel.add(memberInfoPwLB);
		
		JLabel memberInfoNameLB = new JLabel("이름");
		memberInfoNameLB.setBounds(71, 222, 73, 28);
		memberInfoPanel.add(memberInfoNameLB);
		
		JLabel memberInfoPhoneLB = new JLabel("전화번호");
		memberInfoPhoneLB.setBounds(71, 279, 73, 28);
		memberInfoPanel.add(memberInfoPhoneLB);
		
		JLabel memberInfoEmailLB = new JLabel("이메일");
		memberInfoEmailLB.setBounds(71, 333, 73, 28);
		memberInfoPanel.add(memberInfoEmailLB);
		
		JLabel memberInfoAddressLB = new JLabel("주소");
		memberInfoAddressLB.setBounds(71, 400, 73, 28);
		memberInfoPanel.add(memberInfoAddressLB);
		
		memberInfoIdTF = new JTextField();
		memberInfoIdTF.setEditable(false);
		memberInfoIdTF.setBounds(160, 120, 160, 28);
		memberInfoPanel.add(memberInfoIdTF);
		memberInfoIdTF.setColumns(10);
		
		memberInfoPwTF = new JTextField();
		memberInfoPwTF.setEditable(false);
		memberInfoPwTF.setColumns(10);
		memberInfoPwTF.setBounds(160, 170, 160, 28);
		memberInfoPanel.add(memberInfoPwTF);
		
		memberInfoNameTF = new JTextField();
		memberInfoNameTF.setEditable(false);
		memberInfoNameTF.setColumns(10);
		memberInfoNameTF.setBounds(160, 221, 160, 28);
		memberInfoPanel.add(memberInfoNameTF);
		
		memberInfoPhoneTF = new JTextField();
		memberInfoPhoneTF.setEditable(false);
		memberInfoPhoneTF.setColumns(10);
		memberInfoPhoneTF.setBounds(160, 280, 160, 28);
		memberInfoPanel.add(memberInfoPhoneTF);
		
		memberInfoEmailTF = new JTextField();
		memberInfoEmailTF.setEditable(false);
		memberInfoEmailTF.setColumns(10);
		memberInfoEmailTF.setBounds(160, 335, 160, 28);
		memberInfoPanel.add(memberInfoEmailTF);
		
		memberInfoAddressTF = new JTextField();
		memberInfoAddressTF.setEditable(false);
		memberInfoAddressTF.setColumns(10);
		memberInfoAddressTF.setBounds(160, 400, 160, 28);
		memberInfoPanel.add(memberInfoAddressTF);
		
		updateBtn = new JButton("수정하기");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String id = memberInfoIdTF.getText();
					String pw = memberInfoPwTF.getText();
					String name = memberInfoNameTF.getText();
					String phone = memberInfoPhoneTF.getText();
					String email = memberInfoEmailTF.getText();
					String address = memberInfoAddressTF.getText();
					
					Member updateMember = new Member(id, pw, name, phone, email, address);
					mainFrame.memberService.update(updateMember);
					mainFrame.loginMember = mainFrame.memberService.findUser(id);

					
					memberInfoIdTF.setEditable(false);
					memberInfoPwTF.setEditable(false);
					memberInfoNameTF.setEditable(false);
					memberInfoPhoneTF.setEditable(false);
					memberInfoEmailTF.setEditable(false);
					memberInfoAddressTF.setEditable(false);
					memberInfoTitleLB.setText("회원정보");
					updateBtn.setEnabled(true);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		updateBtn.setBounds(234, 469, 97, 23);
		memberInfoPanel.add(updateBtn);
		
		updateBtn1 = new JButton("수정");
		updateBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				String btnText = updateBtn1.getText();
				if(btnText.equals("수정")) {
					updateInfoEnable(true);
				} 
			} catch (Exception e) {
				e.printStackTrace();
				}
			}	
		});
		updateBtn1.setBounds(109, 469, 97, 23);
		memberInfoPanel.add(updateBtn1);

	}
	
	public void setMainFrame(Main2 mainFrame) {
		this.mainFrame=mainFrame;
	}
	
	// 로그인후 회원정보 확인
//	public void memberInfo() throws Exception {
//		memberInfoIdTF.setText(mainFrame.loginMember.getM_Id());
//		memberInfoPwTF.setText(mainFrame.loginMember.getM_Pw());
//		memberInfoNameTF.setText(mainFrame.loginMember.getM_Name());
//		memberInfoPhoneTF.setText(mainFrame.loginMember.getM_Phone());
//		memberInfoEmailTF.setText(mainFrame.loginMember.getM_Email());
//		memberInfoAddressTF.setText(mainFrame.loginMember.getM_Address());
//		
//	}
	
	public void memberInfo(Member member) throws Exception {
		memberInfoIdTF.setText(member.getM_Id());
		memberInfoPwTF.setText(member.getM_Pw());
		memberInfoNameTF.setText(member.getM_Name());
		memberInfoPhoneTF.setText(member.getM_Phone());
		memberInfoEmailTF.setText(member.getM_Email());
		memberInfoAddressTF.setText(member.getM_Address());
	}
	
	public void updateInfoEnable(boolean b) {
		if(b) {
			memberInfoPwTF.setEditable(true);
			memberInfoNameTF.setEditable(true);
			memberInfoPhoneTF.setEditable(true);
			memberInfoEmailTF.setEditable(true);
			memberInfoAddressTF.setEditable(true);
			
			memberInfoTitleLB.setText("회원정보수정");
			updateBtn.setEnabled(true);
		} else {
			memberInfoIdTF.setEditable(false);
			memberInfoPwTF.setEditable(false);
			memberInfoNameTF.setEditable(false);
			memberInfoPhoneTF.setEditable(false);
			memberInfoEmailTF.setEditable(false);
			memberInfoAddressTF.setEditable(false);
			updateBtn.setText("수정");
			memberInfoTitleLB.setText("회원정보");
			updateBtn.setEnabled(false);
			
		}
		
	}
	

	
}
