package kiosk;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KoreanFood extends JPanel{
	
	JButton[] btn;
	Main parent;
	
	public KoreanFood(Main main) {
		parent = main;	// 메인 참조값
		btn = new JButton[4];
		btn[0] = new JButton("김밥");		// 버튼 김밥
		btn[1] = new JButton("떡볶이");	// 버튼 떡볶이
		btn[2] = new JButton("비빔밥");	// 버튼 비빔밥
		btn[3] = new JButton("소주");		// 버튼 소주
		addLayout();	// 패널 및 버튼 레이아웃 설정
		eventProc();	// 단추 눌렸을 때 제어
	}
	
	/*
	 * 함수명		: addLayout
	 * 인자		: 없음
	 * 리턴값		: void
	 * 역할		: 버튼 외형 설정
	 */
	public void addLayout() {
		for (int i = 0; i < btn.length; i++) {
			add(btn[i]);
			btn[i].setPreferredSize(new Dimension(120,120));	// 크기 재지정
			btn[i].setVerticalTextPosition(JButton.BOTTOM);		// 버튼 수직 기준 텍스트 위치 지정
			btn[i].setHorizontalTextPosition(JButton.CENTER);	// 버튼 수평 기준 텍스트 위치 지정
			btn[i].setToolTipText(String.valueOf(i+1)+"번째 메뉴 입니다.");
		}
		// 버튼에 이미지 삽입
		btn[0].setIcon(new ImageIcon("src\\kiosk\\imgs\\김밥.PNG"));
		btn[1].setIcon(new ImageIcon("src\\kiosk\\imgs\\떡볶이.PNG"));
		btn[2].setIcon(new ImageIcon("src\\kiosk\\imgs\\비빔밥.PNG"));
		btn[3].setIcon(new ImageIcon("src\\kiosk\\imgs\\소주.PNG"));
		// 판넬 세부 디테일 작업
		setPreferredSize(new Dimension(400,400));
		setBackground(Color.white);
		setLayout(new GridLayout(2,2,10,10));
	}
	
	/*
	 * 함수명		: eventProc
	 * 인자		: 없음
	 * 리턴값		: void
	 * 역할		: 버튼 눌릴 때 이벤트 처리
	 */
	public void eventProc() {
		for(int i = 0; i < btn.length; i++) {
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton eBtn = (JButton)e.getSource();
					String str = eBtn.getText();
					JOptionPane.showMessageDialog(null,str+"의 가격은 \t"+parent.menu.get(str)+"원 입니다.");
					parent.ta.append(str+"\t"+parent.menu.get(str)+"원\n");
					parent.total += parent.menu.get(str);
					parent.tf.setText(String.valueOf(parent.total)+"원");
				}// end of actionPerformed()
			});// end of addActionListener()
		}// for
	}
}