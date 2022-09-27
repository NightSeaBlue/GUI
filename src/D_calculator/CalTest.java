package D_calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalTest {

	// 1.멤버 변수 선언
	JFrame f;
	JTextField tf;
	JButton [] bNum = new JButton [10];	// 0 ~ 9 숫자 표현할 버튼
	JButton [] bOP = new JButton [4];		// +,-,*,/ 를 표현할 버튼
	JButton bEqual;	// = 버튼 
	JButton bC;		// C 버튼

	//계산용 변수 선언
	double first,second;		// first = 초기 입력하는 숫자 , second = 연산자 입력후 계산하는 숫자 / 정확한 계산을 위해 Type Double
	String op;		// op = 연산자를 눌렀을 때, 계산을 위한 연산자 저장


	// 2. 객체 생성
	CalTest() {
		f = new JFrame ("유치원계산기");
		tf = new JTextField (50);
		bEqual = new JButton("=");
		bC = new JButton("C");
		bNum = new JButton [10]; 
		for(int i = 0 ; i <bNum.length; i++) {
			bNum[i] = new JButton (String.valueOf(i));	//배열로 지정한 bNum에 각각 값 할당
		}
		bOP[0] = new JButton("+"); bOP[1]=new JButton("-"); bOP[2] = new JButton("*"); bOP[3]= new JButton("/");	//bOP에 각각 값 할당

	} // end of CalTest()

	// 3. 화면 구성 및 화면 출력
	void addLayout() {
		f.setLayout(new BorderLayout());
		JPanel jcenter = new JPanel (new GridLayout(4,4));	//Grid 형태의 레이아웃 지정
		jcenter.setPreferredSize(new Dimension(250,100));
		jcenter.add(bC);	// C버튼 추가
		for(int i = 0 ; i < 10 ;i ++) {
			jcenter.add(bNum[i]);
		} // 숫자 버튼 추가
		jcenter.add(bOP[0]);	// 사칙 연산 추가
		jcenter.add(bEqual);	// = 추가
		jcenter.add(bOP[1]);	// 사칙 연산 추가
		jcenter.add(bOP[2]);	// 사칙 연산 추가
		jcenter.add(bOP[3]);	// 사칙 연산 추가


		f.add(tf,BorderLayout.NORTH);		//TextField 를 Frame의 위쪽에 부착
		f.add(jcenter,BorderLayout.CENTER);	// 판넬을 Frame의 중앙에 부착


		f.setBounds(0, 0, 250, 250);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// end of addLayout()

	// 4. 이벤트 구성 및 화면 출력
	void eventProc() {

		// 숫자 버튼이 눌렸을 때

		for(int i = 0; i <bNum.length;i++) {	// 숫자버튼 입력시 숫자버튼 클릭 출력
			bNum[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {	// 이벤트 발생용 (해당 형태의 타이핑을 많이 이용할 것)
					//이벤트가 발생한 컴포넌트의 참조를 얻어옴.
					JButton eBtn = (JButton)e.getSource();	// 버튼을 눌렀을 때 이벤트가 발생한 버튼의 참조값 획득
					String su = (tf.getText()+eBtn.getText());	// 참조값을 받아줄 변수 지정. (처음 화면에 뜨는 숫자 + 버튼을 눌렀을 때 숫자)
					tf.setText(su);	// 획득한 참조값을 TextField에 올림
				}// end of actionPerformed	
			});	// end of ActionListener
		}	// end of for

		// 연산자 버튼이 눌렸을 때
		for(int i = 0 ; i<bOP.length;i++) {
			bOP[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//이벤트가 발생한 컴포넌트의 참조를 얻어옴.
					JButton eBtn = (JButton)e.getSource();	// 버튼을 눌렀을 때 이벤트가 발생한 버튼의 참조값 획득
					op = eBtn.getText();			// 참조값을 받아줄 변수 지정.
					first = Integer.parseInt(tf.getText());	// 연산자를 입력하기 전 숫자를 저장
					tf.setText("");
					JOptionPane.showMessageDialog(null,op+" 계산 실행");	// 계산할 연산자를 눌렀음을 안내
				}// end of actionPerformed
			});// end of ActionListener
		}// end of for

		// equal 버튼이 눌렸을 때
		bEqual.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//이벤트가 발생한 컴포넌트의 참조를 얻어옴.
				second = Integer.parseInt(tf.getText());
				switch(op) {
				case "+" : first+=second; break;
				case "-" : first-=second; break;
				case "*" : first*=second; break;
				case "/" : first/=second; break;
				}
				tf.setText(String.valueOf(first));	// 결과값에 공백이 있어선 안됨, 해당하는 값을 반환하는 것이기 때문
			}//end of actionPerformed
		});//end of ActionListener

		// C 버튼이 눌렸을 때
		bC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// C버튼을 눌렀을 때 값을 모두 없앤다.
				tf.setText("");					// 텍스트 필드에 입력된 값을 모두 공백으로 전환
			}//end of action performed
		}); // end of bC

	}// end of eventProc()

	public static void main(String[] args) {

		CalTest cal = new CalTest () ;	// 화면 출력을 위한 새로운 생성자 호출
		cal.addLayout();	// 화면 구성 함수 호출
		cal.eventProc();	// 이벤트 함수 호출


	}

}
