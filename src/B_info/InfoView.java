package B_info;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
		bExit = new JButton("Exit (alt+X)",new ImageIcon("src\\B_info\\imgs\\exit.png"));		// 버튼에 이미지 추가
		//bExit.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("exit.png")));
		bExit.setHorizontalTextPosition(JButton.CENTER);	// 글자를 버튼의 가운데
		bExit.setVerticalTextPosition(JButton.BOTTOM);		// 글자를 버튼 하단에 위치시킴
		bExit.setRolloverIcon(new ImageIcon("src\\B_info\\imgs\\cancel.png"));		// 마우스를 버튼에 올릴경우 이미지가 변경됨
		bExit.setPressedIcon(new ImageIcon("src\\B_info\\imgs\\add.png"));			// 마우스를 클릭할 경우 이미지 변경.
		bExit.setToolTipText("버튼을 누르면 나가기가 됩니다");								// 툴팁 생성 (도움말)
		bExit.setMnemonic('x');			// 단축키 효과 지정 (문자 입력시 자동으로 alt 효과가 추가됨)
		//			bExit.addActionListener(new ActionListener() {		// Exit 버튼을 누를경우 종료됨.
		//				
		//				@Override
		//				public void actionPerformed(ActionEvent e) {
		//					// 버튼을 누르면 종료되게 만듦.
		//					System.exit(0);
		//					
		//				}
		//			});
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


	public void eventProc() {


		//add 버튼이 눌렸을 때 이벤트 발생
		bAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	// 이벤트 발생용 (해당 형태의 타이핑을 많이 이용할 것)
				// 이벤트 확인 (메세지 창을 띄움)
				JOptionPane.showMessageDialog(null, "ADD 버튼 클릭");	// 이벤트가 있다면 해당 메시지 박스를 띄워라
			}	
		});

		//show 버튼이 눌렸을 때 이벤트 발생
		bShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	// 이벤트 발생용 (해당 형태의 타이핑을 많이 이용할 것)
				// 이벤트 확인 (메세지 창을 띄움)
				JOptionPane.showMessageDialog(null, "SHOW 버튼 클릭");	// 이벤트가 있다면 해당 메시지 박스를 띄워라
			}	
		});

		//search 버튼이 눌렸을 때 이벤트 발생
		bSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	// 이벤트 발생용 (해당 형태의 타이핑을 많이 이용할 것)
				// 이벤트 확인 (메세지 창을 띄움)
				JOptionPane.showMessageDialog(null, "SEARCH 버튼 클릭");	// 이벤트가 있다면 해당 메시지 박스를 띄워라
			}	
		});

		//delete 버튼이 눌렸을 때 이벤트 발생
		bDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	// 이벤트 발생용 (해당 형태의 타이핑을 많이 이용할 것)
				// 이벤트 확인 (메세지 창을 띄움)
				JOptionPane.showMessageDialog(null, "DELETE 버튼 클릭");	// 이벤트가 있다면 해당 메시지 박스를 띄워라
			}	
		});

		//cancel 버튼이 눌렸을 때 이벤트 발생
		bCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	// 이벤트 발생용 (해당 형태의 타이핑을 많이 이용할 것)
				// 이벤트 확인 (메세지 창을 띄움)
				JOptionPane.showMessageDialog(null, "Exit 버튼 클릭");	// 이벤트가 있다면 해당 메시지 박스를 띄워라
			}	
		});

		//exit 버튼이 눌렸을 때 이벤트 발생
		bExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	// 이벤트 발생용 (해당 형태의 타이핑을 많이 이용할 것)
				// 이벤트 확인 (메세지 창을 띄움)
				JOptionPane.showMessageDialog(null, "Exit 버튼 클릭");	// 이벤트가 있다면 해당 메시지 박스를 띄워라
			}	
		});

		//주민번호 입력창에서 엔터쳤을 때 주민번호 출력
		tfID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	// 이벤트 발생용 (해당 형태의 타이핑을 많이 이용할 것)
				getJuminInfo();
			}	// end of action performed
		});		// end of action Listener

		// 주민번호 입력창에서 포커스 이벤트 발생했을 때
		tfID.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// focus를 잃어버렸을 때 이벤트
				getJuminInfo();

			}	// end of focusLost

			@Override
			public void focusGained(FocusEvent e) {
				// focus를 얻었을 때 이벤트

			}	// end of foucsGained
		});
	}		// end of event proc

	void getJuminInfo() {
		String jumin = tfID.getText();
		if (jumin.length() != 14) {
			JOptionPane.showMessageDialog(null, "-를 포함한 15자를 맞춰주세요");
			return;
		}	// end of if

		// (1) 주민번호의 7번째 문자로 성별을 구하여 성별창에 출력
		char sex = jumin.charAt(7);
		if (sex == '1'| sex == '3'| sex == '9') {
			tfSex.setText("남자");	// 획득한 sex가 조건에 해당할 경우, 이를 Sex textField에 출력
		} else if (sex == '2' | sex == '4' | sex == '9') {
			tfSex.setText("여자");
		} else {	// 해당 조건에 걸리지 않을 경우 경고문 출력
			JOptionPane.showMessageDialog(null, "잘못 입력하셨습니다.");
			System.exit(0);			// 주민등록번호를 잘못 입력하였으므로 프로그램 종료.
			return;
		}	// end of (1)

		// (2) 주민번호의 8번째 문자로 출신지를 구하여 출신지 창에 출력
		char chul = jumin.charAt(8);
		String home = null;
		switch (chul) {	// 문자, 정수, 문자열 입력 가능
		case '0' : 
			home = "서울";
			tfHome.setText(home);	//획득한 Home 을 Home textField에 출력
			break;

		case '1' : 
			home = "인천/부산";
			tfHome.setText(home);
			break;

		case '2' :
			home = "경기";
			tfHome.setText(home);
			break;
			
		case '3' :
			home = "강원";
			tfHome.setText(home);
			break;

		case '9' :
			home = "제주";
			tfHome.setText(home);
			break;

		default : 	// 조건과 일치하지 않을경우 Home 에 경고를 띄우고, 경고문 출력
			home = "오류";
			tfHome.setText(home);
			JOptionPane.showMessageDialog(null, "잘못 입력하셨습니다.");
			break;
		} // end of (2)
		// (3) 주민번호에서 년도에 의해 나이를 구해서 나이창에 출력
		String nai = jumin.substring(0,2);		//nai = 주민등록 번호상 생년 2자리 취득;
		// int sunai = (Int)nai;		// 캐스팅 변환 명령어 필요
		int sunai = Integer.parseInt(nai);	// sunai = 앞서 취득한 생년을 문자열이 아닌 숫자로 취급;
		int age = 0;

		Calendar c = Calendar.getInstance(); // 객체가 이미 생성되어 있으므로, 가지고 와야 함. Calender 이용, getinstance 로 년, 월, 일 중 하나 취득
		int year = c.get(Calendar.YEAR);		// year 라는 변수에 get 을 이용해 Calender에서 연도를 취득
		if (sex == '1'| sex =='2' ) {		// 1,2에 해당할 경우
			age = year - (1900+sunai)+1;	// 1900년대 생으로 계산
		} else if (sex =='3'| sex =='4') {	// 3,4에 해당할 경우
			age = year - (2000+sunai)+1;	// 2000년대 생으로 계산
			String age2 = String.valueOf(age);
			tfAge.setText(age2);
		} else if (sex == '9' | sex == '0') {	// 9,0 에 해당할 경우
			age = year - (1800+sunai)+1;	// 1800년대 생으로 계산
		} else {
			JOptionPane.showMessageDialog(null, "잘못 입력하셨습니다.");
		} // end of age calculating
		String age2 = String.valueOf(age);	// 계산 이후 나이를 다시 문자열로 취급해줄 변수 선언
		tfAge.setText(age2);				// Age 텍스트 필드에 나이 출력

	}	// end of getJuminInfo

	public static void main(String[] args) {

		InfoView info = new InfoView();
		info.addLayout();
		info.eventProc();

	}

}
