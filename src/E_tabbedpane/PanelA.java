package E_tabbedpane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class PanelA extends JPanel {
	
	JLabel aLa = new JLabel("판넬 A");
	JButton aBtn = new JButton("A 버튼");
	
	MainTest parent;
	
	
	public PanelA (MainTest mainTest) {
		parent = mainTest;	//객체를 생성해 주소값을 할당해온다.
		setBackground(new Color(255,0,0));	// RGB (Red, Green, Blue)
		addLayout();
		eventProc();
	}//end of PanelA
	
	void addLayout () {
		add(aLa);
		add(aBtn);
	}
	
	void eventProc() {
		// a버튼을 눌렀을 때 
		aBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.la.setText("짜잔");
			}
		});
		
	}

}
