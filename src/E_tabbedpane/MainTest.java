package E_tabbedpane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class MainTest {
	
	JFrame f;
	JButton btn;
	JLabel la;
	
	PanelA panelA;
	PanelB panelB;
	PanelC panelC;
	
	MainTest() {
		f = new JFrame ("나의 창");
		btn = new JButton ("확인");
		la = new JLabel("데이터");
		panelA = new PanelA(this);	// 새로 생성한 panelA의 객체는 PanelA 에서 만든 기존 객체이다.
		panelB = new PanelB();
		panelC = new PanelC();
	}// end of MainTest
	
	void addLayout() {

		f.setLayout(new BorderLayout());
		
		f.add(btn,BorderLayout.EAST);
		f.add(la,BorderLayout.SOUTH);
		
		JTabbedPane tab = new JTabbedPane();
		tab.addTab("메인", panelA);
		tab.addTab("서브", panelB);
		tab.addTab("기타", panelC);
		
		f.add(tab,BorderLayout.CENTER);
		
		f.setBounds(100,100,500,400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// end of addLayout

	void eventProc() {
		// 버튼을 눌렀을 때 A 판넬의 라벨을 변경
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	// 이벤트 발생용 (해당 형태의 타이핑을 많이 이용할 것)
				panelA.aLa.setText("Welcome");		// panelA 클래스의 A 라벨에 접근해, 문자를 변경
			}//end of Action Performed	
		});	// end of Add Action Listener
	}//end of Event Proc
	
	public static void main(String[] args) {
		
		MainTest test = new MainTest ();
		test.addLayout();
		test.eventProc();

	}

}
