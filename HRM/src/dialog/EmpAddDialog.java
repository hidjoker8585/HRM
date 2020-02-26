package dialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.DaoImpl;
import dto.Emp;
import dto.Option;
import main.MainFrame;
import util.SHA512;

/**
 * @brief 사원 등록 다이얼로그
 * @author 정 : 박영훈, 부: 이현우
 * @version v1.02 2020.02.24
 * @see db연결 확인
 */
public class EmpAddDialog extends JDialog implements ActionListener, ComponentListener{
	
	//콤보박스
	private JComboBox<String> combo_gender;
	private JComboBox<String> combo_state;
	private JComboBox<String> rank_nameC;
	private JComboBox<String> paylevel_noC;
	private JComboBox<String> dep_nameC;
	private JComboBox<String> combo_question;

	//컴포넌트
	private Label emp_no;
	private TextField emp_noT;
	private Label emp_name;
	private TextField name_t;
	private Label mobile_no;
	private Choice mobile_noT1;
	private TextField mobile_noT2;
	private TextField mobile_noT3;
	private Label email;
	private TextField emailT;
	private Label email_la1;
	private TextField emailT1;
	private Choice email_c;
	private Label address;
	private TextField addressT;
	private Label school;
	private TextField schoolT;
	private Label major;
	private TextField majorT;
	private Label birth;
	private TextField birthT;
	private TextField birthT2;
	private TextField birthT3;
	private Label birth_la1;
	private Label state_no;
	private Label dep_name;
	private Label startwork;
	private TextField startworkT;
	private Label paylevel_no;
	private Label rank_name;
	private TextField startworkT2;
	private TextField startworkT3;
	private Label lastwork;
	private TextField lastworkT1;
	private TextField lastworkT2;
	private TextField lastworkT3;
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
	private Label answer;
	private TextField answerT;
	private Label remarks;
	private JTextArea area_remarks;
	private Button save_b;
	private Label lbl_pw;
	private JPasswordField pw_input;
	
	
	//db연결
	private Option option;
	private DaoImpl dao;
	
	//이미지
	private JFileChooser chooser;
	private JLabel c;
	private Button pic_b1;
	private File basicFile;
	private File targetFile;
	private BufferedImage bfImg;
	private Image image;
	private ImageIcon iIcon;
	
	//파일스트림
	private File destFile;
	private FileInputStream fis;
	private FileOutputStream fos;

	
	public EmpAddDialog(JFrame f, String msg, boolean modal) {
		// TODO Auto-generated constructor stub
		super(f,msg,modal);
		dao = MainFrame.getDao();		

		//화면구성
		makePanel();
		
	}
	
	public void getData() {
		//선택항목 값 받아오기
		option = dao.getChoiceOption();
		
		//콤보박스 값 비우기
		combo_state.removeAllItems();
		rank_nameC.removeAllItems();
		paylevel_noC.removeAllItems();
		dep_nameC.removeAllItems();
		combo_question.removeAllItems();
		
		for (String item : option.getStateList()) {
			combo_state.addItem(item);
		}
		for (String item : option.getRankList()) {
			rank_nameC.addItem(item);
		}
		for (String item : option.getPayrankList()) {
			paylevel_noC.addItem(item);
		}
		for (String item : option.getDeptList()) {
			dep_nameC.addItem(item);
		}
		for (String item : option.getQuestionList()) {
			combo_question.addItem(item);
		}
	}
	
	public void makePanel() {
		
		setSize(new Dimension(600,800)); //다이얼로그 크기
		setLocationRelativeTo(null); //가운데 위치
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //닫기
		setLayout(null);
		setResizable(false); //크기 조정
		addComponentListener(this);


		//사원번호
		emp_no = new Label("사원번호 : ");
		emp_no.setBounds(200,90,60,40);
		add(emp_no);
		emp_noT = new TextField("자동생성");
		emp_noT.setEditable(false);
		emp_noT.setBounds(280,100,70,20);
		add(emp_noT);
		
		//패스워드
		lbl_pw = new Label("패스워드 :");
		lbl_pw.setBounds(360,90,50,40);
		add(lbl_pw);
		pw_input = new JPasswordField();
		pw_input.setBorder(new BevelBorder(BevelBorder.LOWERED));
		pw_input.setBounds(420,98,110,20);		
		add(pw_input);


		//사원이름
		emp_name = new Label("사원이름 : ");
		emp_name.setBounds(200,120,60,40);
		add(emp_name);
		name_t = new TextField("");
		name_t.setBounds(280,130,150,20);
		add(name_t);
		
		//성별
		String[] gender = {"성별","여성","남성"};
		combo_gender = new JComboBox<String>(gender);
		combo_gender.setEditable(false);
		combo_gender.setBackground(new Color(255,255,255));
		combo_gender.setBounds(440,130,60,20);
		add(combo_gender);

		mobile_no = new Label("핸드폰번호 : ");
		mobile_no.setBounds(200, 150, 60, 40);
		add(mobile_no);
		mobile_noT1 = new Choice();
		mobile_noT1.setBounds(280,160,60,20);
		mobile_noT1.add("010");
		mobile_noT1.add("011");
		add(mobile_noT1);
		mobile_noT2 = new TextField("");
		mobile_noT2.setBounds(340,160,75,20);
		add(mobile_noT2);
		mobile_noT3 = new TextField("");
		mobile_noT3.setBounds(425,160,75,20);
		add(mobile_noT3);
		
		email = new Label("e-mail : ");
		email.setBounds(200, 180, 60, 40);
		add(email);
		emailT = new TextField("");
		emailT.setBounds(280,190,90,20);
		add(emailT);
		email_la1 = new Label("@");
		email_la1.setBounds(375, 190, 15, 20);
		add(email_la1);
		emailT1 = new TextField("");
		emailT1.setBounds(395,190,80,20);
		add(emailT1);
		
		email_c = new Choice();
		email_c.setBounds(490, 190, 70, 20);
		email_c.add("직접입력");
		email_c.add("naver.com");
		email_c.add("gmail.com");
		email_c.add("daum.net");
		add(email_c);
		
		address = new Label("주소 : ");
		address.setBounds(200, 210, 60, 40);
		add(address);
		addressT = new TextField("");
		addressT.setBounds(280,220,250,40);
		add(addressT);
		
		school = new Label("출신학교 : ");
		school.setBounds(50, 280, 60, 40);
		add(school);
		schoolT = new TextField("");
		schoolT.setBounds(130,290,150,20);
		add(schoolT);
		
		major = new Label("전공 : ");
		major.setBounds(300,280,30,40);
		add(major);
		majorT = new TextField("");
		majorT.setBounds(340,290,200,20);
		add(majorT);
		
		
		//사진등록
		c= new JLabel();
		c.setBounds(50,100,110,120);
		c.setBackground(Color. GRAY);
		basicFile = new File("./src/resource","image.jpg");
		try {
			bfImg = ImageIO.read(basicFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		image =bfImg.getScaledInstance(c.getWidth(), c.getHeight(), Image.SCALE_SMOOTH);
		iIcon = new ImageIcon(image);
		c.setIcon(iIcon);
		add(c);

		pic_b1 = new Button("사진등록");
		pic_b1.addActionListener(this);
		pic_b1.setBackground(Color. YELLOW);
		pic_b1.setBounds(63, 235, 80, 30);
		add(pic_b1);

		//파일 선택 다이얼로그
		chooser = new JFileChooser();
		chooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter fef1 = new FileNameExtensionFilter("JPG 파일", "jpg");
		chooser.addChoosableFileFilter(fef1);
		chooser.setCurrentDirectory(new File(System.getProperty("user.home")+"\\"+"Desktop"));
		
		//생년월일 등록
		birth = new Label("생년월일 : ");
		birth.setBounds(50, 310, 60, 40);
		add(birth);
		birthT = new TextField("");
		birthT.setBounds(130, 320, 60, 20);
		add(birthT);
		birthT2 = new TextField("");
		birthT2.setBounds(200, 320, 30, 20);
		add(birthT2);
		birthT3 = new TextField("");
		birthT3.setBounds(240, 320, 30, 20);
		add(birthT3);
		birth_la1 = new Label("ex) 1986. 09. 20");
		birth_la1.setBounds(290, 320, 100, 20);
		add(birth_la1);
		
		//입사일 등록
		startwork = new Label("입사일 : ");
		startwork.setBounds(50, 340, 60, 40);
		add(startwork);
		startworkT = new TextField("");
		startworkT.setBounds(130, 350, 60, 20);
		add(startworkT);
		startworkT2 = new TextField("");
		startworkT2.setBounds(200, 350, 30, 20);
		add(startworkT2);
		startworkT3 = new TextField("");
		startworkT3.setBounds(240, 350, 30, 20);
		add(startworkT3);
		
		//퇴사일 등록
		lastwork = new Label("퇴사일 : ");
		lastwork.setBounds(290, 340, 40, 40);
		add(lastwork);
		lastworkT1 = new TextField("");
		lastworkT1.setBounds(340, 350, 60, 20);
		add(lastworkT1);
		lastworkT2 = new TextField("");
		lastworkT2.setBounds(410, 350, 30, 20);
		add(lastworkT2);
		lastworkT3 = new TextField("");
		lastworkT3.setBounds(450, 350, 30, 20);
		add(lastworkT3);
		
		//직급등록
		rank_name = new Label("직급 : ");
		rank_name.setBounds(50, 370, 60, 40);
		add(rank_name);
		
		rank_nameC = new JComboBox<>();
		rank_nameC.setBounds(130, 380, 120, 20);
		rank_nameC.setEditable(false);
		add(rank_nameC);
		
		//호봉등록
		paylevel_no = new Label("호봉 : ");
		paylevel_no.setBounds(290, 370, 40, 40);
		add(paylevel_no);
		paylevel_noC = new JComboBox<String>();
		paylevel_noC.setBounds(340, 380, 80, 20);
		add(paylevel_noC);
		
		//부서등록
		dep_name = new Label("부서 : ");
		dep_name.setBounds(50, 400, 60, 40);
		add(dep_name);	
		dep_nameC = new JComboBox<String>();
		dep_nameC.setBounds(130, 410, 120, 20);
		dep_nameC.setEditable(false);
		add(dep_nameC);
		
		
		//상태등록
		state_no = new Label("상태 : ");
		state_no.setBounds(290, 400, 40, 40);
		add(state_no);
		combo_state = new JComboBox<String>();
		combo_state.setBounds(340, 410, 80, 20);
		combo_state.setEditable(false);
		add(combo_state);
		
		
		//계좌번호 등록
		bank_account = new Label("계좌번호 : ");
		bank_account.setBounds(50, 430, 60, 40);
		add(bank_account);
		bank_accountT = new TextField("");
		bank_accountT.setBounds(130,440,140,20);
		add(bank_accountT);
		bank_name = new Label("은행명 : ");
		bank_name.setBounds(290, 430, 40, 40);
		add(bank_name);
		bank_nameT = new TextField("");
		bank_nameT.setBounds(340,440,80,20);
		add(bank_nameT);
		bank_holder = new Label("예금주 : ");
		bank_holder.setBounds(430, 430, 40, 40);
		add(bank_holder);
		bank_holderT = new TextField("");
		bank_holderT.setBounds(480,440,60,20);
		add(bank_holderT);

		//취미등록
		hobby = new Label("취미 : ");
		hobby.setBounds(50, 460, 60, 40);
		add(hobby);
		hobbyT = new TextField("");
		hobbyT.setBounds(130,470,140,20);
		add(hobbyT);
		
		//특기등록
		specialty = new Label("특기 : ");
		specialty.setBounds(290, 460, 40, 40);
		add(specialty);
		specialtyT = new TextField("");
		specialtyT.setBounds(340,470,200,20);
		add(specialtyT);

		//질문내용
		question = new Label("질문내용 : ");
		question.setBounds(50, 490, 40, 40);
		add(question);
		combo_question = new JComboBox<String>();
		combo_question.setBounds(130, 500, 370, 20);
		combo_question.setEditable(false);
		add(combo_question);
		
		//답변내용
		answer = new Label("답변내용 : ");
		answer.setBounds(50, 520, 40, 40);
		add(answer);
		answerT = new TextField("");
		answerT.setBounds(130,530,370,20);
		add(answerT);
		
		//비고
		remarks = new Label("비고 : ");
		remarks.setBounds(50, 550, 40, 40);
		add(remarks);
		area_remarks = new JTextArea();
		area_remarks.setBounds(130,560,370,70);
		area_remarks.setLineWrap(true);
		area_remarks.setBorder(new BevelBorder(BevelBorder.LOWERED));
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
		save_b = new Button("등록");
		save_b.setBackground(Color. YELLOW);
		save_b.setBounds(450, 670, 80, 30);
		save_b.addActionListener(this);
		add(save_b);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == save_b) {
			boolean valRes = valid();
			if (valRes) {
				int inRes = addEmp();
				if (inRes > 0) {
					if(targetFile!=null&&targetFile.exists())transferImage();
					JOptionPane.showMessageDialog(this, "정상적으로 사원등록이 됐습니다");
					clearForm();
					dispose();
				} else {
					JOptionPane.showMessageDialog(this, "사원등록에 실패했습니다.\n정보를 확인해주세요");
				}
			}
		}
		if(e.getSource() == pic_b1) {
			int res = chooser.showOpenDialog(this);
			if(res==JFileChooser.APPROVE_OPTION) {
				targetFile = chooser.getSelectedFile();				
				try {
					bfImg = ImageIO.read(targetFile);
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				image =bfImg.getScaledInstance(c.getWidth(), c.getHeight(), Image.SCALE_SMOOTH);
				iIcon = new ImageIcon(image);
				c.setIcon(iIcon);
			}else if(res==JFileChooser.CANCEL_OPTION) {
				targetFile = null;
				try {
					bfImg = ImageIO.read(basicFile);
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				image =bfImg.getScaledInstance(c.getWidth(), c.getHeight(), Image.SCALE_SMOOTH);
				iIcon = new ImageIcon(image);
				c.setIcon(iIcon);	
			}
		}
	}
	public boolean valid() {
		
		if(pw_input.getPassword().length<1) {
			JOptionPane.showMessageDialog(this, "패스워드를 입력하세요");
			return false;
		}
		if(name_t.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 정확히 입력하세요");
			return false;
		}
		if(mobile_noT1.getSelectedIndex()<0) {
			JOptionPane.showMessageDialog(this, "핸드폰 번호 앞 자리를 선택하세요");
			return false;
		}
		if(mobile_noT2.getText().trim().length()<3||mobile_noT2.getText().trim().length()>4) {
			JOptionPane.showMessageDialog(this, "핸드폰 번호를 정확히 입력하세요");
			return false;
		}
		if(mobile_noT3.getText().trim().length()!=4) {
			JOptionPane.showMessageDialog(this, "핸드폰 번호를 정확히 입력하세요");
			return false;
		}
		if(emailT.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "이메일을 정확히 입력하세요");
			return false;
		}
		if(emailT1.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "이메일을 정확히 입력하세요");
			return false;
		}
		if(addressT.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "주소를 정확히 입력하세요");
			return false;
		}
		if(schoolT.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "학교명을 정확히 입력하세요");
			return false;
		}
		if(majorT.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "전공을 정확히 입력하세요");
			return false;
		}
		if(birthT.getText().trim().length()!=4) {
			JOptionPane.showMessageDialog(this, "생년월일을 정확히 입력하세요");
			return false;
		}
		if(birthT2.getText().trim().length()!=2) {
			JOptionPane.showMessageDialog(this, "생년월일을 정확히 입력하세요");
			return false;
		}
		if(birthT3.getText().trim().length()!=2) {
			JOptionPane.showMessageDialog(this, "생년월일을 정확히 입력하세요");
			return false;
		}
		if(startworkT.getText().trim().length()!=4) {
			JOptionPane.showMessageDialog(this, "입사일을 정확히 입력하세요");
			return false;
		}
		if(startworkT2.getText().trim().length()!=2) {
			JOptionPane.showMessageDialog(this, "입사일을 정확히 입력하세요");
			return false;
		}
		if(startworkT3.getText().trim().length()!=2) {
			JOptionPane.showMessageDialog(this, "입사일을 정확히 입력하세요");
			return false;
		}
		if(!(lastworkT1.getText().trim().equals(""))&&lastworkT1.getText().trim().length()!=4) {
			JOptionPane.showMessageDialog(this, "퇴사일을 정확히 입력하세요");
			return false;
		}
		if(!(lastworkT2.getText().trim().equals(""))&&lastworkT2.getText().trim().length()!=2) {
			JOptionPane.showMessageDialog(this, "퇴사일을 정확히 입력하세요");
			return false;
		}
		if(!(lastworkT3.getText().trim().equals(""))&&lastworkT3.getText().trim().length()!=2) {
			JOptionPane.showMessageDialog(this, "퇴사일을 정확히 입력하세요");
			return false;
		}
		if(!((lastworkT3.getText().trim().equals(""))&&
				(lastworkT2.getText().trim().equals(""))&&
						(lastworkT1.getText().trim().equals("")))&&(!(!(lastworkT3.getText().trim().equals(""))&&
								!(lastworkT2.getText().trim().equals(""))&&
										!(lastworkT1.getText().trim().equals(""))))){
			JOptionPane.showMessageDialog(this, "퇴사일을 정확히 입력하세요");
			return false;
								}
		if(answerT.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this,"답변을 정확히 입력하세요");
			return false;
		}
		if(combo_gender.getSelectedIndex()<1) {
			JOptionPane.showMessageDialog(this,"성별을 선택하세요");
			return false;
		}
		if(combo_question.getSelectedIndex()<1) {
			JOptionPane.showMessageDialog(this,"질문 항목을 선택하세요");
			return false;
		}
		if(combo_state.getSelectedIndex()<1) {
			JOptionPane.showMessageDialog(this,"상태를 선택하세요");
			return false;
		}
		if(rank_nameC.getSelectedIndex()<1) {
			JOptionPane.showMessageDialog(this,"직급을 선택하세요");
			return false;
		}
		if(paylevel_noC.getSelectedIndex()<1) {
			JOptionPane.showMessageDialog(this,"호봉을 선택하세요");
			return false;
		}
		if(dep_nameC.getSelectedIndex()<1) {
			JOptionPane.showMessageDialog(this,"부서를 선택하세요");
			return false;
		}
		
		return true;

	}
	
	public int addEmp() {
		
		Emp emp = new Emp();
		//패스워드
		//emp.setPw(SHA512.getSHA512(String.valueOf(pw_input.getPassword())));
		emp.setPw(String.valueOf(pw_input.getPassword()));
		//이름
		emp.setName(name_t.getText().trim());
		//폰넘버
		emp.setPhoneNo(mobile_noT1.getSelectedItem()+mobile_noT2.getText().trim()
				+mobile_noT3.getText().trim());
		//이메일
		String email = emailT.getText().trim()+"@"+emailT1.getText().trim();
		emp.setEmail(email);
		//주소
		emp.setAddress(addressT.getText().trim());
		//학교
		emp.setSchool(schoolT.getText().trim());
		//전공
		emp.setMajor(majorT.getText().trim());
		//생년월일,입사일,퇴사일
		String birth = birthT.getText().trim()+birthT2.getText().trim()+birthT3.getText().trim();
		String start = startworkT.getText().trim()+startworkT2.getText().trim()
				+startworkT3.getText().trim();
		String last = lastworkT1.getText().trim()+lastworkT2.getText().trim()
				+lastworkT3.getText().trim();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			emp.setBirth(sdf.parse(birth));
			emp.setHireDate(sdf.parse(start));
			if(!(lastworkT1.getText().trim().equals(""))&&!(lastworkT2.getText().trim().equals(""))
					&&!(lastworkT3.getText().trim().equals(""))) {
				emp.setRetireDate(sdf.parse(last));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//계좌번호
		emp.setAccount(bank_accountT.getText().trim());
		//은행이름
		emp.setBankName(bank_nameT.getText().trim());
		//예금주
		emp.setBankHolder(bank_holderT.getText().trim());
		//취미
		emp.setHobby(hobbyT.getText().trim());
		//특기
		emp.setSpecialty(specialtyT.getText().trim());
		//답변
		emp.setAnswer(answerT.getText().trim());
		//비고
		emp.setRemarks(area_remarks.getText().trim());
		//부서
		emp.setDept((String)dep_nameC.getSelectedItem());
		//성별
		emp.setGender((String)combo_gender.getSelectedItem());
		//질문내용
		emp.setQuestion((String)combo_question.getSelectedItem());
		//상태
		emp.setState((String)combo_state.getSelectedItem());
		//직급
		emp.setRank((String)rank_nameC.getSelectedItem());
		//호봉
		emp.setPayRank((String)paylevel_noC.getSelectedItem());
		
		return dao.addEmp(emp);
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		clearForm();	
	}

	@Override
	public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentResized(ComponentEvent e) {}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		//db값 받기
		getData();
	}
	
	public void clearForm() {
		
		pw_input.setText("");
		name_t.setText("");
		mobile_noT1.select(0);
		mobile_noT2.setText("");
		mobile_noT3.setText("");
		emailT.setText("");
		emailT1.setText("");
		addressT.setText("");
		schoolT.setText("");
		majorT.setText("");
		birthT.setText("");
		birthT2.setText("");
		birthT3.setText("");
		startworkT.setText("");
		startworkT2.setText("");
		startworkT3.setText("");
		lastworkT1.setText("");
		lastworkT2.setText("");
		lastworkT3.setText("");
		lastworkT1.setText("");
		lastworkT2.setText("");
		lastworkT3.setText("");
		bank_accountT.setText("");
		bank_nameT.setText("");
		bank_holderT.setText("");
		hobbyT.setText("");
		specialtyT.setText("");
		answerT.setText("");
		area_remarks.setText("");
		dep_nameC.setSelectedIndex(0);
		combo_gender.setSelectedIndex(0);
		combo_question.setSelectedIndex(0);
		combo_state.setSelectedIndex(0);
		rank_nameC.setSelectedIndex(0);
		paylevel_noC.setSelectedIndex(0);
		
		//이미지 초기화
		targetFile = null;
		try {
			bfImg = ImageIO.read(basicFile);
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		image =bfImg.getScaledInstance(c.getWidth(), c.getHeight(), Image.SCALE_SMOOTH);
		iIcon = new ImageIcon(image);
		c.setIcon(iIcon);
	}
	
	public void transferImage() {
		
		byte[] buf = new byte[1024];
		int len = 0;
		String destName = dao.getEmpNoRecently()+".jpg";
		destFile = new File("./src/resource",destName);
		
		try {
			fis = new FileInputStream(targetFile);
			fos = new FileOutputStream(destFile,false);
			
			while((len=fis.read(buf))!=-1){
				fos.write(buf,0,len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(fos!=null)fos.close();
					if(fis!=null)fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
}

