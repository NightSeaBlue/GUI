package kiosk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JapaneseFood extends JPanel{	//일식 패널

	Main parent;							//메인을 상속할 수 있는 변수 선언
	JButton [] menu = new JButton[4];		//일식 버튼 4개 지정


	public JapaneseFood(Main kiosk) {		//부모 클래스와 이어주는 생성자
		parent = kiosk;						//parent 변수에 넣어줌

		menu[0] = new JButton("초밥");		//버튼0 = 초밥
		menu[1] = new JButton("라멘");		//버튼1 = 라멘
		menu[2] = new JButton("새우튀김");		//버튼2 = 새우튀김
		menu[3] = new JButton("사케");		//버튼3 = 사케

		addLayout();						//메서드 실행
		eventProc();						//메서드 실행

	}//end jpFoods

	/*
	 * 	함수명 : addLayout
	 * 	인자	 : 없음
	 * 	리턴값 : void
	 * 	역할	 : 패널의 화면 구성
	 * 
	 */
	
	void addLayout() {

		setBackground(Color.WHITE);								//백그라운드 색 지정
		setLayout(new GridLayout(2,2));							//그리드 레이아웃 행열 지정
		
		for (int i = 0; i < menu.length; i++) {
			add(menu[i]);
			menu[i].setPreferredSize(new Dimension(120,120));	// 크기 재지정
			menu[i].setVerticalTextPosition(JButton.BOTTOM);	// 버튼 수직 기준 텍스트 위치 지정
			menu[i].setHorizontalTextPosition(JButton.CENTER);	// 버튼 수평 기준 텍스트 위치 지정
			menu[i].setToolTipText(String.valueOf(i+1)+"번째 메뉴 입니다.");
		}

		//아이콘 삽입
		menu[0].setIcon(new ImageIcon("src\\kiosk\\imgs\\초밥.png"));
		menu[1].setIcon(new ImageIcon("src\\kiosk\\imgs\\라멘.png"));
		menu[2].setIcon(new ImageIcon("src\\kiosk\\imgs\\새우튀김.png"));
		menu[3].setIcon(new ImageIcon("src\\kiosk\\imgs\\사케.png"));
		//아이콘 삽입 여기까지
		
		// 판넬 세부 디테일 작업
				setPreferredSize(new Dimension(400,400));
				setBackground(Color.white);
				setLayout(new GridLayout(2,2,10,10));

	}//end addLayout()


	/*
	 * 	함수명 : eventProc
	 * 	인자 : 없음
	 * 	리턴값 : void
	 * 	역할 : 패널의 버튼별 이벤트 구성 및 실행
	 * 
	 */
	
	void eventProc() {	//이벤트 메서드(버튼 클릭하면 ~~)
		for(int i = 0; i < menu.length; i++) {
			menu[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton eBtn = (JButton)e.getSource();	//eBtn변수에 눌러진 버튼의 소스를 넣음
					String str = eBtn.getText();			//eBtn변수에 들어온 소스의 텍스트 추출해 str에 넣음
					JOptionPane.showMessageDialog(null,str+"의 가격은 \t"+parent.menu.get(str)+"원 입니다.");
					parent.ta.append(str+"\t"+parent.menu.get(str)+"원\n");		//총액
					parent.total += parent.menu.get(str);		//총액에 메뉴 금액 추가
					parent.tf.setText(String.valueOf(parent.total)+"원");	//총계에 출력
				}// end of actionPerformed()
			});// end of addActionListener()
		}// for

	}//end eventProc()
}

