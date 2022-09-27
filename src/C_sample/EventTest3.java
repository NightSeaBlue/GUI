package C_sample;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/*
 *	화면(JFrame)에 '확인' 버튼 하나 출력 
 */

public class EventTest3 {


	// 멤버 변수 선언
	JFrame f;
	JButton btonc;

	// 멤버 변수 객체 선언
	EventTest3 () {
		f = new JFrame ("Event Test");
		btonc = new JButton ("확인");
		
		//(2) 핸들러 객체 생성
		//(3) 이벤트 발생할 컴포넌트와 연결
		btonc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	// 이벤트 발생용 (해당 형태의 타이핑을 많이 이용할 것)
				// 이벤트 확인 (메세지 창을 띄움)
				JOptionPane.showMessageDialog(null, "이벤트 발생3");	// 이벤트가 있다면 해당 메시지 박스를 띄워라
				
			}	
		});	// 해당하는 이벤트를 듣는 메소드 생성
		
	}
	
	// (1) 이벤트 핸들러 만들기
	//		핸들러 - 이벤트 처리 클래스
	
//	class MyHandler implements ActionListener{	//Inner Class (외부클래스$이너클래스.class 로 생성됨)
//
//		@Override
//		public void actionPerformed(ActionEvent e) {	// 이벤트 발생용
//			// 이벤트 확인 (메세지 창을 띄움)
//			JOptionPane.showMessageDialog(null, "이벤트 발생3");	// 이벤트가 있다면 해당 메시지 박스를 띄워라
//			
//		}	
//		
//	}

	// 화면 구성 및 출력
	public void addLayout() {
		f.setLayout(new FlowLayout());
		f.add(btonc);

		f.setBounds(0, 0, 500, 500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public static void main(String[] args) {

		EventTest3 event = new EventTest3 ();

		event.addLayout();


	}

}
