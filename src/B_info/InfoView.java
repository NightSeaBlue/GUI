package B_info;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
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

	// PersonVO 를 저장할 List 생성
	ArrayList <PersonVO> list = new ArrayList<PersonVO>();



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
				JOptionPane.showMessageDialog(null, "정보 추가");	// 이벤트가 있다면 해당 메시지 박스를 띄워라
				inputData();	// 입력된 정보 저장
				clearTextField();	// 새로이 값을 입력할 수 있도록 초기화
				selectAll();
			}//end of Action Performed	
		});	// end of Add Action Listener

		//show 버튼이 눌렸을 때 이벤트 발생
		bShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	// 이벤트 발생용 (해당 형태의 타이핑을 많이 이용할 것)
				// 이벤트 확인 (메세지 창을 띄움)
				JOptionPane.showMessageDialog(null, "조회");	// 이벤트가 있다면 해당 메시지 박스를 띄워라
				selectAll();		// 저장된 list 를 보여주는 함수 호출
			}	// end of Action Performed
		});		// end of Action Listener

		//search 버튼이 눌렸을 때 이벤트 발생
		bSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	// 이벤트 발생용 (해당 형태의 타이핑을 많이 이용할 것)
				// 이벤트 확인 (메세지 창을 띄움)
				JOptionPane.showMessageDialog(null, "검색 성공");	// 이벤트가 있다면 해당 메시지 박스를 띄워라
				selectByTel();
			}	// end of Action Performed
		});		//end of Action Listener

		//tfTel 에서 엔터를 쳤을 때 selectByTel() 호출
		tfTel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	// 이벤트 발생용 (해당 형태의 타이핑을 많이 이용할 것)
				selectByTel();
			}	// end of Action Performed
		});		// end of Action Listener

		//delete 버튼이 눌렸을 때 text Field 값을 제거
		bDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	// 이벤트 발생용 (해당 형태의 타이핑을 많이 이용할 것)
				// 이벤트 확인 (메세지 창을 띄움)
				JOptionPane.showMessageDialog(null, "정보 삭제");	// 이벤트가 있다면 해당 메시지 박스를 띄워라
				deleteByTel();
//				clearTextField();	// 모든 필드 및 에어리어 초기화
			}	// end of Action Performed
		});		// end of Action Listener

		//cancel 버튼이 눌렸을 때 clearTextField() 함수 호출
		bCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	// 이벤트 발생용 (해당 형태의 타이핑을 많이 이용할 것)
				// 이벤트 확인 (메세지 창을 띄움)
				JOptionPane.showMessageDialog(null, "초기화");	// 이벤트가 있다면 해당 메시지 박스를 띄워라
				clearTextField();
			}	// end of Action Performed
		});		// end of Action Listener

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

	/*
	 *	함수명 : clearTextField()
	 * 	인자 : 없음
	 * 	리턴값 : void
	 * 	역할 : 각각의 텍스트 필드와 텍스트 에어리어의 입력된 값을 지우기
	 * 
	 */

	void clearTextField() {	// 입력된 모든 값을 null로 변경
		ta.setText(null);
		tfName.setText(null);
		tfID.setText(null);
		tfTel.setText(null);
		tfSex.setText(null);
		tfAge.setText(null);
		tfHome.setText(null);

	}// end of clearTextField

	/*
	 *  함수명 : inputData ()
	 *  인자 : 없음
	 *  리턴값 : void
	 *  역할 : 'ADD' 버튼을 눌렸을 때 사용자가 텍스트 필드에 입력한 값을 PersonVO() 에 저장
	 */

	void inputData () {
		// 객체 생성
		PersonVO vo = new PersonVO () {};
		// (1) 각각 text field 에 입력된 값을 얻어오기
		// (2) 1번의 값들을 PersonVO 멤버 변수에 저장 (setter/ constructor)
		vo.setName(tfName.getText());
		vo.setID(tfID.getText());
		vo.setTel(tfTel.getText());
		vo.setSex(tfSex.getText());
		vo.setAge(Integer.parseInt(tfAge.getText()));
		vo.setHome(tfHome.getText());
		// 입력된 여러 데이터를 list 에 저장
		list.add(vo);
	} // end of inputData

	/*
	 * 	함수명 : selectAll()
	 * 	인자 : 없음
	 * 	리턴값 : void
	 *  역할 : 리스트에 저장된 모든 정보를 textArea에 출력
	 *  	
	 */
	void selectAll() {
		ta.setText("====== 전체 목록 ====\n\n");	// 입력된 List 를 보여주기 전, TextArea 초기화 
		for(PersonVO vo : list) {
			ta.append(vo.toString());	//append 기존 입력 데이터 외 추가로 데이터 보여줌
		}
	}// end of SelectAll

	/*
	 *	함수명 : selectByTel
	 *	인자 : 없음
	 *	리턴값 : void
	 * 	역할 : 입력한 전화번호를 토대로 정보를 찾아냄 
	 * 
	 */

	void selectByTel () {
		// 1단계 입력한 전화번호 값을 얻어오기
		String tel = tfTel.getText();
		// 2단계 전화번호 값이 있으면, 그 값과 관련된 정보를 호출
		if (tel.equals("")) {	// 전화번호가 입력되어 있지 않을 경우
			JOptionPane.showMessageDialog(null, "전화번호를 입력하세요");
			return;
		}//end of if
		// list 에 저장된 PersonVO와 비교해 해당 전화번호가 있으면, 정보를 각각의 text field에 출력
		for (PersonVO vo : list) {	// 리스트 와 비교
			if(tel.equals(vo.getTel())) {	// 리스트 내 전화번호와 입력한 전화번호가 동일할 때
				tfName.setText(vo.getName());
				tfID.setText(vo.getID());
				tfAge.setText(String.valueOf(vo.getAge()));
				tfSex.setText(vo.getSex());
				tfHome.setText(vo.getHome());
			}	//end of if
		}// end of for



	}// end of selectByTel
	/*
	 * 	함수명 : deleteByTel
	 *  인자 : 없음
	 * 	리턴값 : void
	 * 	역할 : 입력한 전화번호를 토대로 해당 정보를 지움
	 * 
	 */
	void deleteByTel () {
		// 입력한 전화번호 값을 얻어오기
		// 입력받은 전화번호가 공백이라면 "전화번호를 입력하세요"라는 메세지 창을 출력
		// 리스트에 저장된 PersonVO() 의 전화번호와 비교하여
		// 해당 전화번호가 있으면, 그 해당하는 PersonVO를 리스트에서 삭제
		// (참고) 삭제하고 나서 break로 반복문 끝내기
		
		//1단계 입력한 전화번호 값을 얻어오기
		String tel = tfTel.getText();
		
		//2단계 전화번호 값이 있으면 그와 관련된 정보 list에서 제거
		if (tel.equals("")) {	// 전화번호가 입력되어 있지 않을 경우
			JOptionPane.showMessageDialog(null, "전화번호를 입력하세요");
			return;
		}//end of if
		
		// list 에 저장된 PersonVO와 비교해 해당 전화번호가 있으면, 정보를 list에서 제거
		for (PersonVO vo : list) {	// 리스트 와 비교
			if(tel.equals(vo.getTel())) {	// 리스트 내 전화번호와 입력한 전화번호가 동일할 때
				list.remove(vo);		// 리스트에 저장된 vo를 제거
				JOptionPane.showMessageDialog(null, "삭제 성공");
				ta.setText("");
				tfName.setText("");
				tfID.setText("");
				tfTel.setText("");
				tfAge.setText("");
				tfSex.setText("");
				tfHome.setText("");
				break;
			}	//end of if
		}// end of for
		
	}	// end of deleteByTel
	

	/*
	 *	함수명 : getJuminInfo ()
	 *	인자 : 없음
	 *	리턴 : void
	 *	역할 : 입력된 ID (주민번호) 를 통해 각종 정보를 획득하는 함수
	 * 
	 */
	void getJuminInfo() {
		String jumin = tfID.getText();	// tfID 상에 입력된 값을 저장해줄 변수 설정
		if (jumin.length() != 14) {		// 주민번호가 15자가 되지 않을 때
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
		int age = 0;						// 실제 나이를 계산하기 위한 변수 설정

		Calendar c = Calendar.getInstance(); // 객체가 이미 생성되어 있으므로, 가지고 와야 함. Calender 이용, getinstance 로 년, 월, 일 중 하나 취득
		int year = c.get(Calendar.YEAR);		// year 라는 변수에 get 을 이용해 Calender에서 연도를 취득
		if (sex == '1'| sex =='2' ) {		// 1,2에 해당할 경우
			age = year - (1900+sunai)+1;	// 1900년대 생으로 계산
		} else if (sex =='3'| sex =='4') {	// 3,4에 해당할 경우
			age = year - (2000+sunai)+1;	// 2000년대 생으로 계산
		} else if (sex == '9' | sex == '0') {	// 9,0 에 해당할 경우
			age = year - (1800+sunai)+1;	// 1800년대 생으로 계산
		} else {
			JOptionPane.showMessageDialog(null, "잘못 입력하셨습니다.");
		} // end of age calculating
		String age2 = String.valueOf(age);	// 계산 이후 나이를 다시 문자열로 취급해줄 변수 선언
		tfAge.setText(age2);				// Age 텍스트 필드에 나이 출력

	}	// end of getJuminInfo

	public static void main(String[] args) {

		InfoView info = new InfoView();		// 만들어낸 InfoView 클래스를 호출하기 위한 객체 생성
		info.addLayout();					// InfoView 내 함수 호출 (레이아웃 형태 지정)
		info.eventProc();					// InfoView 내 이벤트 함수 호출

	}

}
