package E_tabbedpane2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class PanelA extends JPanel {
	
	JLabel aLa = new JLabel("판넬 A");
	JButton aBtn = new JButton("A 버튼");
	
	
	
	public PanelA () {
		setBackground(new Color(255,0,0));	// RGB (Red, Green, Blue)
		addLayout();
		eventProc();
	}//end of PanelA
	
	void addLayout () {
		add(aLa);
		add(aBtn);
	}
	
	void eventProc() {
		
		
	}

}
