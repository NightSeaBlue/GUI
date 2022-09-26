package B_info;

import java.awt.*;
import javax.swing.*;

public class InfoView {
	
	// 1. 멤버 변수 선언
	JFrame f;
	JTextField tfName,tfID,tfTel,tfSex,tfAge,tfHome;
	JTextArea ta;
	JButton bAdd,bShow,bSearch,bDelete,bCancel,bExit;
	
	
	
	// 2. 멤버 변수 객체 생성
	InfoView () {
		f = new JFrame("DBTest");
		tfName = new JTextField(20);	// 문자열을 하나 입력할 수 있는 변수 생성
		tfID = new JTextField(20);
		tfTel = new JTextField(20);
		tfSex = new JTextField(20);
		tfAge = new JTextField(20);
		tfHome = new JTextField(20);
		ta = new JTextArea (250,50);	// 여러 문자열을 입력할 수 있는 변수 생성
		bAdd = new JButton("Add");		// 각 버튼의 형태를 띄는 JButton 생성
		bShow = new JButton("Show");
		bSearch = new JButton("Search");
		bDelete = new JButton("Delete");
		bCancel = new JButton("Cancel");
		bExit = new JButton("Exit");
		
	}
	
	// 3. 화면 구성 및 출력
	/*
	 *  전체 프레임 BorderLayout 지정
	 *  - West	: JPanel GridLayout 지정 6행 2열 JPanel(GridLayout (6,2))
	 *  - Center : TextArea
	 *  - South : JPanel 생성 (GridLayout(1,6))
	 */
	public void addLayout() {
		// 프레임 지정
		f.setLayout(new BorderLayout());
		
		// 붙이기 작업 진행 (West)
			JPanel jwest = new JPanel (new GridLayout (6,2));	// textfield를 묶을 수 있는 판넬 생성
			jwest.setPreferredSize(new Dimension(250,25));	// 판넬의 사이즈 지정
			jwest.add(new JLabel("Name",JLabel.CENTER));	// 각 라벨 입력 , JLabel.CENTER을 통해 가운데 정렬
			jwest.add(tfName);								// 입력창 생성
			jwest.add(new JLabel("ID",JLabel.CENTER));
			jwest.add(tfID);
			jwest.add(new JLabel("Tel",JLabel.CENTER));
			jwest.add(tfTel);
			jwest.add(new JLabel("Sex",JLabel.CENTER));
			jwest.add(tfSex);
			jwest.add(new JLabel("Age",JLabel.CENTER));
			jwest.add(tfAge);
			jwest.add(new JLabel("Home",JLabel.CENTER));
			jwest.add(tfHome);
		f.add(jwest,BorderLayout.WEST);
		
		// 붙이기 작업 진행 (East)
		f.add(ta,BorderLayout.CENTER);		//textarea 를 가운데에 위치
		
		// 붙이기 작업 진행 (South)
			JPanel jsouth = new JPanel (new GridLayout(1,6));	// JButton을 묶을 수 있는 판넬 생성
			jsouth.setPreferredSize(new Dimension(100,50));
			jsouth.add(bAdd);
			jsouth.add(bShow);
			jsouth.add(bSearch);
			jsouth.add(bDelete);
			jsouth.add(bCancel);
			jsouth.add(bExit);
		f.add(jsouth,BorderLayout.SOUTH);
		
		// 화면 출력
		f.setBounds(0, 0, 500, 500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 창 종료시, 콘솔도 종료기능 활성화
			
	}


	public static void main(String[] args) {
		
		InfoView info = new InfoView();
		info.addLayout();

	}

}
