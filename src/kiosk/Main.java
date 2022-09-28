package kiosk;

import java.awt.BorderLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class Main extends JFrame{
	JFrame f;
	JButton btn;
	JLabel la;
	JTextArea ta;
	chinese chinese;

	public Main () {
		f = new JFrame("키오스크");
		ta = new JTextArea(250,100);
		chinese = new chinese(this);

	}

	public void addLayout () {
		f.setLayout(new BorderLayout());

		f.add(ta,BorderLayout.WEST);

		JTabbedPane tab = new JTabbedPane();
		tab.addTab("중식", chinese);

		f.add(tab,BorderLayout.EAST);

		f.setBounds(100,100,500,500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

//	public void eventProc() {
//
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main () ;
		main.addLayout();
//		main.eventProc();
	}

}
