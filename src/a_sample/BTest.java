package a_sample;

import javax.swing.*;

public class BTest extends JFrame {	// JFrame을 상속
	
	JButton btn;		// JButton 을 호출할 수 있는 필드 생성
	
	BTest () {
		super("나의 두번째 창");
		btn = new JButton("확인2");
	}
	void addLayOut() {
		add(btn);
		
		setBounds(100,100,500,350);		// 창 크기 지정 // 자녀 클래스에서 부모 클래스 함수 생성자 호출 없이 접근 가능
		setVisible(true);				// 창을 보이게 만듦
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 창을 닫으면 콘솔 종료
	}
	public static void main(String[] args) {
		
		BTest b = new BTest ();
		b.addLayOut ();
		
	}

}
