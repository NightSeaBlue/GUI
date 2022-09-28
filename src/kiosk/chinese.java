package kiosk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class chinese extends JPanel{

	JButton [] menu = new JButton [4];  


	public chinese(Main main) {
		menu[0] = new JButton ("백주");
		menu[1] = new JButton ("짬뽕");
		menu[2] = new JButton ("훠궈");
		menu[3] = new JButton ("만두");
		addLayout();
		eventProc();
	}

	void addLayout () {
		menu[0].setIcon(new ImageIcon("src\\kiosk\\imgs\\baiju.png"));
		menu[1].setIcon(new ImageIcon("src\\kiosk\\imgs\\jjb.png"));
		menu[2].setIcon(new ImageIcon("src\\kiosk\\imgs\\hg.png"));
		menu[3].setIcon(new ImageIcon("src\\kiosk\\imgs\\dmp.png"));
		for(int i = 0; i < menu.length ;i++) {
			menu[i].setHorizontalTextPosition(JButton.CENTER);
			menu[i].setVerticalTextPosition(JButton.BOTTOM);
			add(menu[i]);
		}

		setPreferredSize(new Dimension(400,400));
		setBackground(Color.white);
		setLayout(new GridLayout(2,2));


	}

	void eventProc() {
		// 백주 버튼
		menu[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 백주 버튼을 눌렀을 때 , 메뉴와 가격 호출
				JOptionPane.showMessageDialog(null, "백주의 가격은 6500원 입니다.");

			}
		});

		//	짬뽕 버튼
		menu[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 짬뽕 버튼을 눌렀을 때, 메뉴와 가격 호출
				JOptionPane.showMessageDialog(null, "짬뽕의 가격은 6500원 입니다.");

			}
		});

		// 훠궈 버튼
		menu[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 훠궈 버튼을 눌렀을 때, 메뉴와 가격 호출
				JOptionPane.showMessageDialog(null, "훠궈의 가격은 8000원 입니다.");

			}
		});

		// 만두 버튼
		menu[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 만두 버튼을 눌렀을 때, 메뉴와 가격 호출
				JOptionPane.showMessageDialog(null, "만두의 가격은 10000원 입니다.");

			}
		});

	} // end of Event Proc

}
