package dialog;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

import dao.DaoImpl;
import dto.Emp;
import dto.Option;
import main.MainFrame;

/**
 * @brief 사원 상세 조회 다이얼로그
 * @author 정 : 박영훈, 부 : 이현우
 * @version v1.01 2020.02.22
 * @see DB연결 테스트
 */

public class EmpDetailDialog extends JDialog implements ActionListener{
	
	//상수값
	private static final Color BACKGROUND_COLOR = new Color(220,220,220);
	
	//다이얼로그
	private MainFrame frame;
	private JDialog empUpdateDialog;
	
	//컴포넌트
	private Label emp_no;
	private TextField emp_noT;
	private Label emp_name;
	private TextField name_t;
	private TextField txt_gender;
	private Label mobile_no;
	private TextField mobile_T;
	private Label email;
	private TextField emailT;
	private Label address;
	private TextField addressT;
	private Label school;
	private TextField schoolT;
	private Label major;
	private TextField majorT;
	private JLabel c;
	private Label birth;
	private TextField birthT;
	private Label startwork;
	private TextField startworkT;
	private Label lastwork;
	private TextField lastworkT1;
	private Label rank_name;
	private TextField rank_nameT;
	private Label paylevel_no;
	private TextField paylevel_noT;
	private Label dep_name;
	private TextField dep_nameT;
	private Label state_no;
	private TextField state_noT;
	private Label bank_account;
	private TextField bank_accountT;
	private Label bank_name;
	private TextField bank_nameT;
	private Label bank_holder;
	private TextField bank_holderT;
	private Label hobby;
	private TextField hobbyT;
	private Label specialty;
	private TextField specialtyT;
	private Label question;
	private TextField questionT;
	private Label answer;
	private TextField answerT;
	private Label remarks;
	private JTextArea area_remarks;
	private Button chk_b;
	private Button mod_b;
	
	//db연결
	private int empNo;
	private DaoImpl dao;
	
	//이미지
	private File basicFile;
	private BufferedImage bfImg;
	private Image image;
	private ImageIcon iIcon;
	
	public EmpDetailDialog(JFrame f, String msg, boolean modal,int num) {
		// TODO Auto-generated constructor stub
		super(f, msg, modal);
		frame = (MainFrame)f;
		empNo = num;
		dao = MainFrame.getDao();		

		//화면구성
		makePanel();
		
		//db값 가져오기
		getData();

				
	}
	
	public void makePanel(){

		setSize(new Dimension(600, 880)); // 다이얼로그 크기
		setLocationRelativeTo(null); // 가운데 위치
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 닫기
		setLayout(null);
		setResizable(false); //크기 조정


		// 사원번호
		emp_no = new Label("사원번호 : ");
		emp_no.setBounds(200, 90, 60, 40);
		add(emp_no);
		emp_noT = new TextField("자동생성 됩니다");
		emp_noT.setBounds(280, 100, 220, 20);
		emp_noT.setEditable(false);
		emp_noT.setBackground(BACKGROUND_COLOR);
		add(emp_noT);

		// 사원이름
		emp_name = new Label("사원이름 : ");
		emp_name.setBounds(200, 120, 60, 40);
		add(emp_name);
		name_t = new TextField("");
		name_t.setBounds(280, 130, 150, 20);
		name_t.setEditable(false);
		name_t.setBackground(BACKGROUND_COLOR);
		add(name_t);

		// 성별
		txt_gender = new TextField();
		txt_gender.setEditable(false);
		txt_gender.setBackground(BACKGROUND_COLOR);
		txt_gender.setBounds(440, 130, 60, 20);
		add(txt_gender);

		// 핸드폰번호
		mobile_no = new Label("핸드폰번호 : ");
		mobile_no.setBounds(200, 150, 60, 40);
		add(mobile_no);
		mobile_T = new TextField("");
		mobile_T.setBounds(280, 160, 200, 20);
		mobile_T.setEditable(false);
		mobile_T.setBackground(BACKGROUND_COLOR);
		add(mobile_T);

		email = new Label("e-mail : ");
		email.setBounds(200, 180, 60, 40);
		add(email);
		emailT = new TextField("");
		emailT.setBounds(280, 190, 200, 20);
		emailT.setEditable(false);
		emailT.setBackground(BACKGROUND_COLOR);
		add(emailT);

		address = new Label("주소 : ");
		address.setBounds(200, 210, 60, 40);
		add(address);
		addressT = new TextField("");
		addressT.setBounds(280, 220, 250, 40);
		addressT.setEditable(false);
		addressT.setBackground(BACKGROUND_COLOR);
		add(addressT);

		school = new Label("출신학교 : ");
		school.setBounds(50, 280, 60, 40);
		add(school);
		schoolT = new TextField("");
		schoolT.setBounds(130, 290, 150, 20);
		schoolT.setEditable(false);
		schoolT.setBackground(BACKGROUND_COLOR);
		add(schoolT);

		major = new Label("전공 : ");
		major.setBounds(300, 280, 30, 40);
		add(major);
		majorT = new TextField("");
		majorT.setBounds(340, 290, 200, 20);
		majorT.setEditable(false);
		majorT.setBackground(BACKGROUND_COLOR);
		add(majorT);

		// 사진등록
		c = new JLabel();
		c.setBounds(50, 100, 130, 150);
		c.setBackground(Color.GRAY);
		add(c);		

		// 생년월일 등록
		birth = new Label("생년월일 : ");
		birth.setBounds(50, 310, 60, 40);
		add(birth);
		birthT = new TextField("");
		birthT.setBounds(130, 320, 200, 20);
		birthT.setEditable(false);
		birthT.setBackground(BACKGROUND_COLOR);
		add(birthT);

		// 입사일 등록
		startwork = new Label("입사일 : ");
		startwork.setBounds(50, 340, 60, 40);
		add(startwork);
		startworkT = new TextField("");
		startworkT.setBounds(130, 350, 150, 20);
		startworkT.setEditable(false);
		startworkT.setBackground(BACKGROUND_COLOR);
		add(startworkT);

		// 퇴사일 등록
		lastwork = new Label("퇴사일 : ");
		lastwork.setBounds(290, 340, 40, 40);
		add(lastwork);
		lastworkT1 = new TextField("");
		lastworkT1.setBounds(340, 350, 150, 20);
		lastworkT1.setEditable(false);
		lastworkT1.setBackground(BACKGROUND_COLOR);
		add(lastworkT1);

		// 직급등록
		rank_name = new Label("직급 : ");
		rank_name.setBounds(50, 370, 60, 40);
		add(rank_name);
		rank_nameT = new TextField("");
		rank_nameT.setBounds(130, 380, 120, 20);
		rank_nameT.setEditable(false);
		rank_nameT.setBackground(BACKGROUND_COLOR);
		add(rank_nameT);

		// 호봉등록
		paylevel_no = new Label("호봉 : ");
		paylevel_no.setBounds(290, 370, 40, 40);
		add(paylevel_no);
		paylevel_noT = new TextField("");
		paylevel_noT.setBounds(340, 380, 80, 20);
		paylevel_noT.setEditable(false);
		paylevel_noT.setBackground(BACKGROUND_COLOR);
		add(paylevel_noT);

		// 부서등록
		dep_name = new Label("부서 : ");
		dep_name.setBounds(50, 400, 60, 40);
		add(dep_name);
		dep_nameT = new TextField("");
		dep_nameT.setBounds(130, 410, 120, 20);
		dep_nameT.setEditable(false);
		dep_nameT.setBackground(BACKGROUND_COLOR);
		add(dep_nameT);

		// 상태등록
		state_no = new Label("상태 : ");
		state_no.setBounds(290, 400, 40, 40);
		add(state_no);
		state_noT = new TextField("");
		state_noT.setBounds(340, 410, 80, 20);
		state_noT.setEditable(false);
		state_noT.setBackground(BACKGROUND_COLOR);
		add(state_noT);

		// 계좌번호 등록
		bank_account = new Label("계좌번호 : ");
		bank_account.setBounds(50, 430, 60, 40);
		add(bank_account);
		bank_accountT = new TextField("");
		bank_accountT.setBounds(130, 440, 140, 20);
		bank_accountT.setEditable(false);
		bank_accountT.setBackground(BACKGROUND_COLOR);
		add(bank_accountT);
		bank_name = new Label("은행명 : ");
		bank_name.setBounds(290, 430, 40, 40);
		add(bank_name);
		bank_nameT = new TextField("");
		bank_nameT.setBounds(340, 440, 80, 20);
		bank_nameT.setEditable(false);
		bank_nameT.setBackground(BACKGROUND_COLOR);
		add(bank_nameT);
		bank_holder = new Label("예금주 : ");
		bank_holder.setBounds(430, 430, 40, 40);
		add(bank_holder);
		bank_holderT = new TextField("");
		bank_holderT.setBounds(480, 440, 60, 20);
		bank_holderT.setEditable(false);
		bank_holderT.setBackground(BACKGROUND_COLOR);
		add(bank_holderT);

		// 취미등록
		hobby = new Label("취미 : ");
		hobby.setBounds(50, 460, 60, 40);
		add(hobby);
		hobbyT = new TextField("");
		hobbyT.setBounds(130, 470, 140, 20);
		hobbyT.setEditable(false);
		hobbyT.setBackground(BACKGROUND_COLOR);
		add(hobbyT);

		// 특기등록
		specialty = new Label("특기 : ");
		specialty.setBounds(290, 460, 40, 40);
		add(specialty);
		specialtyT = new TextField("");
		specialtyT.setBounds(340, 470, 200, 20);
		specialtyT.setEditable(false);
		specialtyT.setBackground(BACKGROUND_COLOR);
		add(specialtyT);

		// 질문내용
		question = new Label("질문내용 : ");
		question.setBounds(50, 490, 40, 40);
		add(question);
		questionT = new TextField("");
		questionT.setBounds(130, 500, 370, 20);
		questionT.setEditable(false);
		questionT.setBackground(BACKGROUND_COLOR);
		add(questionT);

		// 답변내용
		answer = new Label("답변내용 : ");
		answer.setBounds(50, 520, 40, 40);
		add(answer);
		answerT = new TextField("");
		answerT.setBounds(130, 530, 370, 20);
		answerT.setEditable(false);
		answerT.setBackground(BACKGROUND_COLOR);
		add(answerT);

		// 비고
		remarks = new Label("비고 : ");
		remarks.setBounds(50, 550, 40, 40);
		add(remarks);
		area_remarks = new JTextArea();
		area_remarks.setBounds(130, 560, 370, 70);
		area_remarks.setLineWrap(true);
		area_remarks.setBorder(new BevelBorder(BevelBorder.LOWERED));
		area_remarks.setEditable(false);
		area_remarks.setBackground(BACKGROUND_COLOR);
		add(area_remarks);

		/*
		CheckboxGroup gg= new CheckboxGroup();
		Checkbox mm = new Checkbox("남자" , gg, true);
		Checkbox ff = new Checkbox("여자", gg, false);
		add(ff);
		add(mm);
		mm.setBounds(240,100,50,50);
		ff.setBounds(300,100,50,50);

		Label id_la = new Label("*아이디 : ");
		id_la.setBounds(50, 180, 80, 50);
		add(id_la);
		
		TextField id_t = new TextField("");
		id_t.setBounds(140, 193, 80, 20);
		add(id_t);
		Button b = new Button("*아이디 중복 확인");
		b.setBounds(250,193,110,20);
		add(b);

		*/
		
		//보턴
		if(frame.getMaster()) {
			mod_b = new Button("수정");
			mod_b.setBackground(Color. YELLOW);
			mod_b.setBounds(350, 670, 80, 30);
			mod_b.addActionListener(this);
			add(mod_b);
		}
		
		chk_b = new Button("확인");
		chk_b.setBackground(Color. YELLOW);
		chk_b.setBounds(450, 670, 80, 30);
		chk_b.addActionListener(this);
		add(chk_b);
	}
	
	public void getData() {
		
		Emp input = new Emp();
		input.setEmpNo(empNo);
		Emp emp = null;
		if(frame.getMaster()) {
			emp = dao.getEmpForAdmin(input);
			emp_noT.setText(String.valueOf(emp.getEmpNo()));
			name_t.setText(emp.getName());
			txt_gender.setText(emp.getGender());
			mobile_T.setText(emp.getPhoneNo());
			emailT.setText(emp.getEmail());
			addressT.setText(emp.getAddress());
			schoolT.setText(emp.getSchool());
			majorT.setText(emp.getMajor());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");	
			birthT.setText(sdf.format(emp.getBirth()));
			startworkT.setText(sdf.format(emp.getHireDate()));
			if(emp.getRetireDate()!=null)lastworkT1.setText(sdf.format(emp.getRetireDate()));
			rank_nameT.setText(emp.getRank());
			paylevel_noT.setText(emp.getPayRank());
			dep_nameT.setText(emp.getDept());
			state_noT.setText(emp.getState());
			bank_nameT.setText(emp.getBankName());
			bank_accountT.setText(String.valueOf(emp.getAccount()));
			bank_holderT.setText(emp.getBankHolder());
			if(emp.getHobby()!=null)hobbyT.setText(emp.getHobby());
			if(emp.getSpecialty()!=null)specialtyT.setText(emp.getSpecialty());
			questionT.setText(emp.getQuestion());
			answerT.setText(emp.getAnswer());
			if(emp.getRemarks()!=null)area_remarks.setText(emp.getRemarks());
			
			//emp.get
		}else {
			emp = dao.getEmpForUser(input);
			emp_noT.setText(String.valueOf(emp.getEmpNo()));
			name_t.setText(emp.getName());
			txt_gender.setText(emp.getGender());
			emailT.setText(emp.getEmail());
			addressT.setText(emp.getAddress());
			schoolT.setText(emp.getSchool());
			majorT.setText(emp.getMajor());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");	
			startworkT.setText(sdf.format(emp.getHireDate()));
			rank_nameT.setText(emp.getRank());
			dep_nameT.setText(emp.getDept());
			if(emp.getHobby()!=null)hobbyT.setText(emp.getHobby());
			if(emp.getSpecialty()!=null)specialtyT.setText(emp.getSpecialty());
		}
		
		basicFile = new File("./src/resource","image.jpg");
		File file = new File("./src/resource",emp.getEmpNo()+".jpg");
		if(file.exists()) {
			try {
				bfImg = ImageIO.read(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			image =bfImg.getScaledInstance(c.getWidth(), c.getHeight(), Image.SCALE_SMOOTH);
			iIcon = new ImageIcon(image);
			c.setIcon(iIcon);
		}else {
			try {
				bfImg = ImageIO.read(basicFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			image =bfImg.getScaledInstance(c.getWidth(), c.getHeight(), Image.SCALE_SMOOTH);
			iIcon = new ImageIcon(image);
			c.setIcon(iIcon);	
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==chk_b) {
			dispose();
		}
		if(e.getSource()==mod_b) {
			dispose();
			empUpdateDialog = new EmpUpdateDialog(frame,"사원수정",true,empNo);
			empUpdateDialog.setVisible(true);
		}
	}
}
