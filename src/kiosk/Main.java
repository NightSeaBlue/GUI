package kiosk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main extends JFrame{		// 키오스크의 메인부
	// 메인부 필드 선언
	JFrame f;		//프레임
	JButton btn1,btn2;	// 버튼
	JLabel la;		// 라벨
	JTextArea ta;	// 결과 창
	JTextField tf;	// 총 금액 창	
	KoreanFood koreanFood;		// 한식 패널
	ChineseFood chineseFood;	// 중식 패널
	JapaneseFood japaneseFood;	// 일식 패널
	WesturnFood westurnFood;	// 양식 패널	

	JPanel bt;	// 기능을 할 버튼들을 붙여줄 패널 선언
	HashMap <String , Integer> menu;	// 메뉴의 정보를 보관할 HashMap 생성
	int total = 0;	// 주문 금액의 합계를 받을 변수 total 선언

	public Main () {		// 메인 생성자 생성
		f = new JFrame("키오스크");		// 프레임의 명 지정
		ta = new JTextArea("==메뉴==\t==가격==\n");		// 결과 창
		ta.setPreferredSize(new Dimension(200,20));		// 결과 창의 사이즈 지정
		tf = new JTextField(10);						// 총 합계를 불러줄 텍스트 필드 선언
		btn1 = new JButton("결제");						// 결제 버튼
		btn2 = new JButton("취소");						// 취소 버튼
		la = new JLabel("총 금액");						// 총 금액임을 나타내는 라벨 선언
		// 라벨의 문자열 위치 지정
		la.setHorizontalAlignment(JLabel.CENTER);
		la.setVerticalTextPosition(JLabel.CENTER);		// End of Label
		// 버튼들을 부착해 줄 패널 설정
		bt = new JPanel(new GridLayout(2,2));
		bt.setPreferredSize(new Dimension(50,50));
		bt.setBackground(new Color(210,225,255));		// end of Panel
		// 메뉴의 정보를 저장할 HashMap 생성
		menu = new HashMap <String, Integer> ();
		setMenu();										// 메뉴의 값을 저장할 setMenu 함수 실행
		// 각 메뉴별 생성자 호출
		chineseFood = new ChineseFood(this);
		koreanFood = new KoreanFood(this);
		westurnFood = new WesturnFood(this);
		japaneseFood = new JapaneseFood(this);
	}// end of Main

	/*
	 * 	함수명 : addLayout
	 * 	인자 : 없음
	 * 	리턴값 : void
	 * 	역할 : 키오스크의 화면 구성
	 * 
	 */
	public void addLayout () {
		// 프레임의 레이아웃 지정
		f.setLayout(new BorderLayout());
		// 결과값을 출력할 결과창 부착 (좌측)
		f.add(ta,BorderLayout.WEST);
		// 패널들을 결합시킬 Tabbed Pane 생성
		JTabbedPane tab = new JTabbedPane();
		// 패널 부착
		tab.addTab("한식", koreanFood);
		tab.addTab("중식", chineseFood);
		tab.addTab("일식", japaneseFood);
		tab.addTab("양식", westurnFood);
		tab.setPreferredSize(new Dimension(200,200));	// 패널 사이즈 지정
		// 탭 부착 위치 지정 (우측)
		f.add(tab,BorderLayout.EAST);
		// 기능을 하는 버튼 및 주문 금액의 합계를 띄울 텍스트 필드를 bt 패널에 부착
		bt.add(la);
		bt.add(tf);
		bt.add(btn1);
		bt.add(btn2);
		// 패널 부착 위치 지정 (남측)
		f.add(bt,BorderLayout.SOUTH);
		// 키오스크 창 사이즈 지정, 시각화, 종료버튼 활성화
		f.setBounds(100,100,500,500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	/*
	 * 	함수명 : eventProc
	 * 	인자 : 없음
	 * 	리턴값 : void
	 * 	역할 : 키오스크의 각 버튼별 이벤트 구성 및 함수 호출
	 * 
	 */

	public void eventProc()  {
		// 결제 버튼 누를 때 발생
		btn1.addActionListener(new ActionListener() {      
			@Override
			public void actionPerformed(ActionEvent e) {
				//확인 버튼 생성
				int dialogButton = JOptionPane.showConfirmDialog (null, "결제하시겠습니까?","결제창", JOptionPane.YES_NO_OPTION);
				if(dialogButton == JOptionPane.YES_OPTION) {   // 확인 버튼
					JOptionPane.showMessageDialog(null, "결제가 완료되었습니다. ");
					ta.setText(null);   //ta에 들어가는 모든 값 비우기
					tf.setText(String.valueOf(0));   //tf에 들어가는 모든 값 0원으로 비우기
				} // end of if(조건문)
			}	// end of Action Performed	
		});      //end of Add ActionListener 

		// 취소(cancel) 버튼 눌렀을 때 발생하는 옵션
		btn2.addActionListener(new ActionListener() {      
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText(null);   //Text Area 에 들어가는 모든 값 비우기
				tf.setText(String.valueOf(0));   // Text Field에 들어가는 모든 값 0원으로 비우기
			}  // end of Action Performed       
		});      //end of addActionListener 
	}

	/*
	 * 	함수명 : setMenu
	 * 	인자 : 없음
	 * 	리턴값 : void
	 * 	역할 : 메뉴의 이름 및 가격 값 저장 (key : 메뉴 명 / value : 가격)
	 * 
	 */
	
	void setMenu() {	// menu 라는 HashMap 에 데이터 저장
		menu.put("백주", 8500);
		menu.put("짬뽕", 6500);
		menu.put("훠궈", 10000);
		menu.put("만두", 10000);
		menu.put("김밥", 4000);
		menu.put("떡볶이", 6000);
		menu.put("비빔밥", 7000);
		menu.put("소주", 5000);
		menu.put("햄버거", 8500);
		menu.put("스테이크", 15000);
		menu.put("파스타", 10000);
		menu.put("맥주", 5000);
		menu.put("초밥", 12000);
		menu.put("새우튀김", 8000);
		menu.put("라멘", 10000);
		menu.put("사케", 12000);
	}

	public static void main(String[] args) {
		Main main = new Main () ;		// 메인 생성자 호출
		main.addLayout();				// addLayout 실행
		main.eventProc();				// eventProc 실행
	}

}
