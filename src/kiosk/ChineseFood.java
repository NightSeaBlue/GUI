package kiosk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChineseFood extends JPanel{	// 중식 패널
	// 필드 선언
	JButton [] menu = new JButton [4];	// 중식 버튼 4개 지정
	Main parent;						// 메인을 상속할 수 있는 변수 선언

	public ChineseFood(Main main) {	// 생성자 생성
		parent = main;	// 이때 입력받는 변수는 parent 와 동일
		// 버튼 생성
		menu[0] = new JButton ("백주");
		menu[1] = new JButton ("짬뽕");
		menu[2] = new JButton ("훠궈");
		menu[3] = new JButton ("만두");
		addLayout();	// addLayout 실행
		eventProc();	// eventProc 실행
	}

	/*
	 * 	함수명 : addLayout
	 * 	인자 : 없음
	 * 	리턴값 : void
	 * 	역할 : 패널의 화면 구성
	 * 
	 */
	
	void addLayout () {
		// 각 버튼 생성 및 크기 조정 , 버튼별 툴 팁 추가
		for(int i = 0; i < menu.length ;i++) {
			add(menu[i]);
			// 버튼 내 문자의 위치 조정
			menu[i].setVerticalTextPosition(JButton.BOTTOM);
			menu[i].setHorizontalTextPosition(JButton.CENTER);	// end of 문자 위치
			menu[i].setPreferredSize(new Dimension(120,120));	// 버튼 크기 조정
			menu[i].setToolTipText(String.valueOf(i+1)+"번째 메뉴 입니다.");	// 버튼 툴팁 생성
		}
		// 버튼 별 이미지 할당
		menu[0].setIcon(new ImageIcon("src\\kiosk\\imgs\\백주.png"));
		menu[1].setIcon(new ImageIcon("src\\kiosk\\imgs\\짬뽕.png"));
		menu[2].setIcon(new ImageIcon("src\\kiosk\\imgs\\훠궈.png"));
		menu[3].setIcon(new ImageIcon("src\\kiosk\\imgs\\만두.png"));

		// 패널의 크기 조절 및 패널 타입 지정
		setLayout(new GridLayout(2,2,10,10));
		setPreferredSize(new Dimension(400,400));
		setBackground(Color.white);

	}
	
	/*
	 * 	함수명 : eventProc
	 * 	인자 : 없음
	 * 	리턴값 : void
	 * 	역할 : 패널의 버튼별 이벤트 구성 및 실행
	 * 
	 */

	void eventProc() {
		// 버튼 별 이벤트 생성
		for(int i = 0 ; i < menu.length;i++) {
		menu[i].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼을 누를 경우, 버튼 별 설정되어 있는 메뉴의 가격을 결과창에 호출
				JButton eBtn = (JButton)e.getSource();	// 버튼을 눌렀을 때 이벤트가 발생한 버튼에서 소스 획득
				String str = eBtn.getText();		// 버튼의 텍스트를 획득할 변수 선언
				// 버튼의 텍스트(메뉴명) 이 HashMap menu의 key 에 해당하므로 이를 호출
				// 버튼을 눌렀을 때, 메뉴 명과 가격 호출
				JOptionPane.showMessageDialog(null,str+"의 가격은 \t"+parent.menu.get(str)+"원 입니다.");
				parent.total+=parent.menu.get(str);	// 주문한 금액의 합계 계산
				parent.ta.append(str+"\t"+parent.menu.get(str)+"원\n");
				parent.tf.setText(String.valueOf(parent.total)+"원");
			}// end of Action Performed
		});	// end of Add Action Listener()
		
		}	// end of for
	} // end of Event Proc
	

}
