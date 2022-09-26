package a_sample;
/*
 * 	java의 GUI (화면) / Graphic User Interface
 * 		- AWT : 1.2 이전
 * 		- Swing : 1.2 이후
 * 					  대부분 클래스 앞에 J
 */


import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ATest {
	
	JFrame f;		// JFrame 은 창을 만들 수 있는 Class 중 하나
	JButton btn,btn2;
	JCheckBox btnj,btno;
	JRadioButton radiom,radiof;
	JTextField tf;
	JTextArea ta;
	
	ATest() {
		f = new JFrame ("나의 첫 창");
		btn = new JButton("클릭");		// 지정 안하는 경우 null point exception 발생
		btn2 = new JButton("취소");
		btnj = new JCheckBox("Java");
		btno = new JCheckBox("Oracle");
		radiom = new JRadioButton("남자");
		radiof = new JRadioButton("여자");
		tf = new JTextField(20);
		ta = new JTextArea(40,20);
		ButtonGroup group = new ButtonGroup ();		// 양자 택일이 되도록 묶어줌
		group.add(radiom);
		group.add(radiof);
	}

	void addLayOut () {
//		f.setLayout(new FlowLayout());		// 한 줄에 배치
//		f.setLayout(new GridLayout(3,3));	// GridLayout : 행과 열의 크기 지정할 수 있음
		f.setLayout(new BorderLayout());	// 동/서/남/북/가운데 배치
		
		//붙이기 작업
		f.add(btn, BorderLayout.NORTH);
		f.add(btn2,BorderLayout.SOUTH);
//		f.add(btnj);
//		f.add(btno);
			JPanel pEast = new JPanel();	// 패널을 만들어서 원하는 버튼 여러개를 부착할 수 있음
			pEast.add(radiof);
			pEast.add(radiom);
		f.add(pEast, BorderLayout.EAST);	
//		f.add(radiom, BorderLayout.EAST);
//		f.add(radiof, BorderLayout.EAST);		// 덮어씌움 처리됨
		f.add(new JLabel("입력하세요"), BorderLayout.WEST);
//		f.add(tf, BorderLayout.EAST);
		f.add(ta, BorderLayout.CENTER);
		
		// 화면출력
		f.setBounds(100, 100, 500, 350);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		ATest a = new ATest ();
		a.addLayOut();

	}

}
