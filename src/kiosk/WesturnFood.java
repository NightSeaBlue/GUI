package kiosk;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class WesturnFood extends JPanel{	//양식 패널

	// 1. 멤버변수선언

	Main parent;							// 메인을 상속할 수 있는 변수 선언
	JButton [] menu = new JButton [4]; 		// 양식 버튼 4개 지정


	// 2. 멤버 변수 객체생성
	WesturnFood( ) {						//기본 생성자 생성

	}

	WesturnFood(Main i) {					//부모클래스와 이어주는 생성자
		parent = i;							// 이때 입력받는 변수는 parent 와 동일
		menu[0] = new JButton("햄버거");
		menu[1] = new JButton("스테이크");
		menu[2] = new JButton("파스타");
		menu[3] = new JButton("맥주");
		addLayout();						// addLayout 실행
		eventProc();						// eventProc 실행
	}
	
	/*
	 * 	함수명 : addLayout
	 * 	인자 : 없음
	 * 	리턴값 : void
	 * 	역할 : 패널의 화면 구성
	 * 
	 */

	public void addLayout () {
		
		for (int i = 0; i < menu.length ; i++) {
			// 버튼 내 문자의 위치 조정
			add(menu[i]);
			menu[i].setVerticalTextPosition(JButton.BOTTOM);
			menu[i].setHorizontalTextPosition(JButton.CENTER);			// end of 문자 위치
			menu[i].setPreferredSize(new Dimension(120,120));			// 버튼 크기 조정
			menu[i].setToolTipText(String.valueOf(i+1)+"번째 메뉴 입니다.");// 수직, 아래
		}

		//첫번째 이미지
		menu[0].setIcon(new ImageIcon("src\\kiosk\\imgs\\햄버거.png"));
		//두번째 이미지
		menu[1].setIcon(new ImageIcon("src\\kiosk\\imgs\\스테이크.png"));		
		//세번째 이미지
		menu[2].setIcon(new ImageIcon("src\\kiosk\\imgs\\파스타.png"));
		//네번재 이미지
		menu[3].setIcon(new ImageIcon("src\\kiosk\\imgs\\맥주.png"));
		
		// 패널의 크기 조절 및 패널 타입 세부 디테일 지정
		setPreferredSize(new Dimension(400,400));
		setBackground(Color.white);
		setLayout(new GridLayout(2,2,10,10));

	}	
	
	/*
	 * 	함수명 : eventProc
	 * 	인자 : 없음
	 * 	리턴값 : void
	 * 	역할 : 패널의 버튼별 이벤트 구성 및 실행
	 * 
	 */
	public void eventProc() {
		for (int i = 0; i < menu.length; i++) {
			menu[i].addActionListener(new ActionListener() {		
				@Override
				public void actionPerformed(ActionEvent e) {
					// 버튼을 누를 경우, 버튼 별 설정되어 있는 메뉴의 가격을 결과창에 호출
					JButton eBtn = (JButton)e.getSource();	// 버튼을 눌렀을 때 이벤트가 발생한 버튼에서 소스 획득
					String str = eBtn.getText();			// 버튼의 텍스트를 획득할 변수 선언
					// 버튼의 텍스트(메뉴명) 이 HashMap menu의 key 에 해당하므로 이를 호출
					// 버튼을 눌렀을 때, 메뉴 명과 가격 호출
					JOptionPane.showMessageDialog(null,str+"의 가격은 \t"+parent.menu.get(str)+"원 입니다.");
					parent.ta.append(str+"\t"+parent.menu.get(str)+"원\n"); // 주문한 금액의 합계 계산
					parent.total += parent.menu.get(str);
					parent.tf.setText(String.valueOf(parent.total)+"원");
				}	// end of Action Performed		
			});	// end of Add Action Listener()
		}		// end of for
	}		//end of eventProc



} //end of public class
