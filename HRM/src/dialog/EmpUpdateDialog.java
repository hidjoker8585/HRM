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
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.DaoImpl;
import dto.Emp;
import dto.Option;
import main.MainFrame;
import util.SHA512;

/**
 * @brief ��� ���� ���̾�α�
 * @author �� : �ڿ���, ��: ������
 * @version v1.01 2020.02.24
 * @see db���� Ȯ��
 */
public class EmpUpdateDialog extends JDialog implements ActionListener, ComponentListener{
	
	//�޺��ڽ�
	private JComboBox<String> combo_gender;
	private JComboBox<String> combo_state;
	private JComboBox<String> rank_nameC;
	private JComboBox<String> paylevel_noC;
	private JComboBox<String> dep_nameC;
	private JComboBox<String> combo_question;

	//������Ʈ
	private Label emp_no;
	private Label emp_name;
	private Label mobile_no;
	private Label email;
	private Label email_la1;
	private Label address;
	private Label school;
	private Label major;
	private Label birth;
	private Label birth_la1;
	private Label state_no;
	private Label dep_name;
	private Label startwork;
	private Label paylevel_no;
	private Label rank_name;	
	private Label lastwork;
	private Label bank_account;
	private Label bank_name;
	private Label bank_holder;
	private Label hobby;
	private Label specialty;
	private Label question;
	private Label answer;
	private Label remarks;
	private Label lbl_pw;
	private Button save_b;


	private TextField emp_noT;
	private TextField name_t;
	private Choice mobile_noT1;
	private TextField mobile_noT2;
	private TextField mobile_noT3;
	private TextField emailT;
	private TextField emailT1;
	private Choice email_c;
	private TextField addressT;
	private TextField schoolT;
	private TextField majorT;
	private TextField birthT;
	private TextField birthT2;
	private TextField birthT3;
	private TextField startworkT;
	private TextField startworkT2;
	private TextField startworkT3;
	private TextField lastworkT1;
	private TextField lastworkT2;
	private TextField lastworkT3;
	private TextField bank_accountT;
	private TextField bank_nameT;
	private TextField bank_holderT;
	private TextField hobbyT;
	private TextField specialtyT;
	private TextField answerT;
	private JTextArea area_remarks;
	private TextField pw_input;
	
	
	//db����
	private int empNo;
	private Option option;
	private DaoImpl dao;
	private Emp emp;
		
	//�̹���
	private JFileChooser chooser;
	private JLabel c;
	private Button pic_b1;
	private File basicFile;
	private File beforeFile;
	private File targetFile;
	private BufferedImage bfImg;
	private Image image;
	private ImageIcon iIcon;
	
	//���Ͻ�Ʈ��
	private File destFile;
	private FileInputStream fis;
	private FileOutputStream fos;
	
	
	public EmpUpdateDialog(JFrame f, String msg, boolean modal,int num) {
		// TODO Auto-generated constructor stub
		super(f,msg,modal);
		empNo = num;
		dao = MainFrame.getDao();		
		
		setSize(new Dimension(660,880)); //���̾�α� ũ��
		setLocationRelativeTo(null); //��� ��ġ
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //�ݱ�
		setResizable(false); //ũ�� ����
		
		//db�� �ޱ�
		getData();
		
		//ȭ�鱸��
		makePanel();
		
		//��������Է�
		inputEmp();

	}
	
	public void getData() {

		//�����׸� �� �޾ƿ���
		option = dao.getChoiceOption();
		
		//������� �޾ƿ���
		Emp e = new Emp();
		e.setEmpNo(empNo);
		emp = dao.getEmpForAdmin(e);
		
	}

	public void makePanel() {
		
		setSize(new Dimension(600,800)); //���̾�α� ũ��
		setLocationRelativeTo(null); //��� ��ġ
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //�ݱ�
		setLayout(null);
		setResizable(false); //ũ�� ����


		//�����ȣ
		emp_no = new Label("�����ȣ : ");
		emp_no.setBounds(200,90,60,40);
		add(emp_no);
		emp_noT = new TextField("�ڵ�����");
		emp_noT.setEditable(false);
		emp_noT.setBounds(280,100,70,20);
		add(emp_noT);
		
		//�н�����
		lbl_pw = new Label("�н����� :");
		lbl_pw.setBounds(360,90,50,40);
		add(lbl_pw);
		pw_input = new TextField("�����Ұ�");
		pw_input.setEditable(false);
		pw_input.setBounds(420,98,110,20);		
		add(pw_input);


		//����̸�
		emp_name = new Label("����̸� : ");
		emp_name.setBounds(200,120,60,40);
		add(emp_name);
		name_t = new TextField("");
		name_t.setBounds(280,130,150,20);
		add(name_t);
		
		//����
		String[] gender = {"����","����","����"};
		combo_gender = new JComboBox<String>(gender);
		combo_gender.setEditable(false);
		combo_gender.setBackground(new Color(255,255,255));
		combo_gender.setBounds(440,130,60,20);
		add(combo_gender);

		mobile_no = new Label("�ڵ�����ȣ : ");
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
		email_c.add("�����Է�");
		email_c.add("naver.com");
		email_c.add("gmail.com");
		email_c.add("daum.net");
		add(email_c);
		
		address = new Label("�ּ� : ");
		address.setBounds(200, 210, 60, 40);
		add(address);
		addressT = new TextField("");
		addressT.setBounds(280,220,250,40);
		add(addressT);
		
		school = new Label("����б� : ");
		school.setBounds(50, 280, 60, 40);
		add(school);
		schoolT = new TextField("");
		schoolT.setBounds(130,290,150,20);
		add(schoolT);
		
		major = new Label("���� : ");
		major.setBounds(300,280,30,40);
		add(major);
		majorT = new TextField("");
		majorT.setBounds(340,290,200,20);
		add(majorT);
		
		
		//�������
		c= new JLabel();
		c.setBounds(50,100,110,120);
		c.setBackground(Color. GRAY);
		add(c);
		basicFile = new File("./src/resource","image.jpg");
		File file = new File("./src/resource",empNo+".jpg");
		if(file.exists()) {
			try {
				bfImg = ImageIO.read(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			image =bfImg.getScaledInstance(c.getWidth(), c.getHeight(), Image.SCALE_SMOOTH);
			iIcon = new ImageIcon(image);
			beforeFile = file;
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
		
		//���� ���� ���̾�α�
		chooser = new JFileChooser();
		chooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter fef1 = new FileNameExtensionFilter("JPG ����", "jpg");
		chooser.addChoosableFileFilter(fef1);
		chooser.setCurrentDirectory(new File(System.getProperty("user.home")+"\\"+"Desktop"));
		
		
		pic_b1 = new Button("�������");
		pic_b1.setBackground(Color. YELLOW);
		pic_b1.setBounds(63, 235, 80, 30);
		pic_b1.addActionListener(this);
		add(pic_b1);
		
		//������� ���
		birth = new Label("������� : ");
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
		
		//�Ի��� ���
		startwork = new Label("�Ի��� : ");
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
		
		//����� ���
		lastwork = new Label("����� : ");
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
		
		//���޵��
		rank_name = new Label("���� : ");
		rank_name.setBounds(50, 370, 60, 40);
		add(rank_name);
		
		rank_nameC = new JComboBox<>(option.getRankList());
		rank_nameC.setBounds(130, 380, 120, 20);
		rank_nameC.setEditable(false);
		add(rank_nameC);
		
		//ȣ�����
		paylevel_no = new Label("ȣ�� : ");
		paylevel_no.setBounds(290, 370, 40, 40);
		add(paylevel_no);
		paylevel_noC = new JComboBox<String>(option.getPayrankList());
		paylevel_noC.setBounds(340, 380, 80, 20);
		add(paylevel_noC);
		
		//�μ����
		dep_name = new Label("�μ� : ");
		dep_name.setBounds(50, 400, 60, 40);
		add(dep_name);	
		dep_nameC = new JComboBox<String>(option.getDeptList());
		dep_nameC.setBounds(130, 410, 120, 20);
		dep_nameC.setEditable(false);
		add(dep_nameC);
		
		
		//���µ��
		state_no = new Label("���� : ");
		state_no.setBounds(290, 400, 40, 40);
		add(state_no);
		combo_state = new JComboBox<String>(option.getStateList());
		combo_state.setBounds(340, 410, 80, 20);
		combo_state.setEditable(false);
		add(combo_state);
		
		
		//���¹�ȣ ���
		bank_account = new Label("���¹�ȣ : ");
		bank_account.setBounds(50, 430, 60, 40);
		add(bank_account);
		bank_accountT = new TextField("");
		bank_accountT.setBounds(130,440,140,20);
		add(bank_accountT);
		bank_name = new Label("����� : ");
		bank_name.setBounds(290, 430, 40, 40);
		add(bank_name);
		bank_nameT = new TextField("");
		bank_nameT.setBounds(340,440,80,20);
		add(bank_nameT);
		bank_holder = new Label("������ : ");
		bank_holder.setBounds(430, 430, 40, 40);
		add(bank_holder);
		bank_holderT = new TextField("");
		bank_holderT.setBounds(480,440,60,20);
		add(bank_holderT);

		//��̵��
		hobby = new Label("��� : ");
		hobby.setBounds(50, 460, 60, 40);
		add(hobby);
		hobbyT = new TextField("");
		hobbyT.setBounds(130,470,140,20);
		add(hobbyT);
		
		//Ư����
		specialty = new Label("Ư�� : ");
		specialty.setBounds(290, 460, 40, 40);
		add(specialty);
		specialtyT = new TextField("");
		specialtyT.setBounds(340,470,200,20);
		add(specialtyT);

		//��������
		question = new Label("�������� : ");
		question.setBounds(50, 490, 40, 40);
		add(question);
		combo_question = new JComboBox<String>(option.getQuestionList());
		combo_question.setBounds(130, 500, 370, 20);
		combo_question.setEditable(false);
		add(combo_question);
		
		//�亯����
		answer = new Label("�亯���� : ");
		answer.setBounds(50, 520, 40, 40);
		add(answer);
		answerT = new TextField("");
		answerT.setBounds(130,530,370,20);
		add(answerT);
		
		//���
		remarks = new Label("��� : ");
		remarks.setBounds(50, 550, 40, 40);
		add(remarks);
		area_remarks = new JTextArea();
		area_remarks.setBounds(130,560,370,70);
		area_remarks.setLineWrap(true);
		area_remarks.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(area_remarks);

		/*
		CheckboxGroup gg= new CheckboxGroup();
		Checkbox mm = new Checkbox("����" , gg, true);
		Checkbox ff = new Checkbox("����", gg, false);
		add(ff);
		add(mm);
		mm.setBounds(240,100,50,50);
		ff.setBounds(300,100,50,50);

		Label id_la = new Label("*���̵� : ");
		id_la.setBounds(50, 180, 80, 50);
		add(id_la);
		
		TextField id_t = new TextField("");
		id_t.setBounds(140, 193, 80, 20);
		add(id_t);
		Button b = new Button("*���̵� �ߺ� Ȯ��");
		b.setBounds(250,193,110,20);
		add(b);

		*/
		
		//����
		save_b = new Button("���");
		save_b.setBackground(Color. YELLOW);
		save_b.setBounds(450, 670, 80, 30);
		save_b.addActionListener(this);
		add(save_b);
		
	}

	public void inputEmp() {
		
		
		emp_noT.setText(String.valueOf(emp.getEmpNo()));
		name_t.setText(emp.getName());
		mobile_noT1.select(emp.getPhoneNo().substring(0, 3));
		mobile_noT2.setText(emp.getPhoneNo().substring(3, emp.getPhoneNo().length()-4));
		mobile_noT3.setText(emp.getPhoneNo().substring(emp.getPhoneNo().length()-4, emp.getPhoneNo().length()));
		emailT.setText(emp.getEmail().split("@")[0]);
		emailT1.setText(emp.getEmail().split("@")[1]);
		addressT.setText(emp.getAddress());
		schoolT.setText(emp.getSchool());
		majorT.setText(emp.getMajor());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date1 = sdf.format(emp.getBirth());
		birthT.setText(date1.substring(0, 4));
		birthT2.setText(date1.substring(4, 6));
		birthT3.setText(date1.substring(6, 8));
		String date2 = sdf.format(emp.getHireDate());
		startworkT.setText(date2.substring(0, 4));
		startworkT2.setText(date2.substring(4, 6));
		startworkT3.setText(date2.substring(6, 8));
		if(emp.getRetireDate()!=null) {
			String date3 = sdf.format(emp.getRetireDate());
			lastworkT1.setText(date3.substring(0, 4));
			lastworkT2.setText(date3.substring(4, 6));
			lastworkT3.setText(date3.substring(6, 8));
		}
		bank_accountT.setText(emp.getAccount());
		bank_nameT.setText(emp.getName());
		bank_holderT.setText(emp.getBankHolder());
		hobbyT.setText(emp.getHobby());
		specialtyT.setText(emp.getSpecialty());
		answerT.setText(emp.getAnswer());
		area_remarks.setText(emp.getRemarks());
		combo_gender.setSelectedItem(emp.getGender());
		combo_state.setSelectedItem(emp.getState());
		rank_nameC.setSelectedItem(emp.getRank());
		paylevel_noC.setSelectedItem(emp.getPayRank());
		dep_nameC.setSelectedItem(emp.getDept());
		combo_question.setSelectedItem(emp.getQuestion());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==save_b) {
			boolean valRes = valid();
			if (valRes) {
				int inRes = editEmp();
				if (inRes > 0) {
					if(targetFile!=null&&targetFile.exists()) {
						transferImage();
					}else if(targetFile==null&&beforeFile!=null) {
						beforeFile.delete();
					}
					JOptionPane.showMessageDialog(this, "���������� ��������� �Ϸ��߽��ϴ�");
				} else {
					JOptionPane.showMessageDialog(this, "��������� �����߽��ϴ�.\n������ Ȯ�����ּ���");
				}
			}
		}
		if(e.getSource()==pic_b1) {
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
		
		if(name_t.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "�̸��� ��Ȯ�� �Է��ϼ���");
			return false;
		}
		if(mobile_noT1.getSelectedIndex()<0) {
			JOptionPane.showMessageDialog(this, "�ڵ��� ��ȣ �� �ڸ��� �����ϼ���");
			return false;
		}
		if(mobile_noT2.getText().trim().length()<3||mobile_noT2.getText().trim().length()>4) {
			JOptionPane.showMessageDialog(this, "�ڵ��� ��ȣ�� ��Ȯ�� �Է��ϼ���");
			return false;
		}
		if(mobile_noT3.getText().trim().length()!=4) {
			JOptionPane.showMessageDialog(this, "�ڵ��� ��ȣ�� ��Ȯ�� �Է��ϼ���");
			return false;
		}
		if(emailT.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "�̸����� ��Ȯ�� �Է��ϼ���");
			return false;
		}
		if(emailT1.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "�̸����� ��Ȯ�� �Է��ϼ���");
			return false;
		}
		if(addressT.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "�ּҸ� ��Ȯ�� �Է��ϼ���");
			return false;
		}
		if(schoolT.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "�б����� ��Ȯ�� �Է��ϼ���");
			return false;
		}
		if(majorT.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "������ ��Ȯ�� �Է��ϼ���");
			return false;
		}
		if(birthT.getText().trim().length()!=4) {
			JOptionPane.showMessageDialog(this, "��������� ��Ȯ�� �Է��ϼ���");
			return false;
		}
		if(birthT2.getText().trim().length()!=2) {
			JOptionPane.showMessageDialog(this, "��������� ��Ȯ�� �Է��ϼ���");
			return false;
		}
		if(birthT3.getText().trim().length()!=2) {
			JOptionPane.showMessageDialog(this, "��������� ��Ȯ�� �Է��ϼ���");
			return false;
		}
		if(startworkT.getText().trim().length()!=4) {
			JOptionPane.showMessageDialog(this, "�Ի����� ��Ȯ�� �Է��ϼ���");
			return false;
		}
		if(startworkT2.getText().trim().length()!=2) {
			JOptionPane.showMessageDialog(this, "�Ի����� ��Ȯ�� �Է��ϼ���");
			return false;
		}
		if(startworkT3.getText().trim().length()!=2) {
			JOptionPane.showMessageDialog(this, "�Ի����� ��Ȯ�� �Է��ϼ���");
			return false;
		}
		if(!(lastworkT1.getText().trim().equals(""))&&lastworkT1.getText().trim().length()!=4) {
			JOptionPane.showMessageDialog(this, "������� ��Ȯ�� �Է��ϼ���");
			return false;
		}
		if(!(lastworkT2.getText().trim().equals(""))&&lastworkT2.getText().trim().length()!=2) {
			JOptionPane.showMessageDialog(this, "������� ��Ȯ�� �Է��ϼ���");
			return false;
		}
		if(!(lastworkT3.getText().trim().equals(""))&&lastworkT3.getText().trim().length()!=2) {
			JOptionPane.showMessageDialog(this, "������� ��Ȯ�� �Է��ϼ���");
			return false;
		}
		if(!((lastworkT3.getText().trim().equals(""))&&
				(lastworkT2.getText().trim().equals(""))&&
						(lastworkT1.getText().trim().equals("")))&&(!(!(lastworkT3.getText().trim().equals(""))&&
								!(lastworkT2.getText().trim().equals(""))&&
										!(lastworkT1.getText().trim().equals(""))))){
			JOptionPane.showMessageDialog(this, "������� ��Ȯ�� �Է��ϼ���");
			return false;
								}
		if(answerT.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this,"�亯�� ��Ȯ�� �Է��ϼ���");
			return false;
		}
		if(combo_gender.getSelectedIndex()<1) {
			JOptionPane.showMessageDialog(this,"������ �����ϼ���");
			return false;
		}
		if(combo_question.getSelectedIndex()<1) {
			JOptionPane.showMessageDialog(this,"���� �׸��� �����ϼ���");
			return false;
		}
		if(combo_state.getSelectedIndex()<1) {
			JOptionPane.showMessageDialog(this,"���¸� �����ϼ���");
			return false;
		}
		if(rank_nameC.getSelectedIndex()<1) {
			JOptionPane.showMessageDialog(this,"������ �����ϼ���");
			return false;
		}
		if(paylevel_noC.getSelectedIndex()<1) {
			JOptionPane.showMessageDialog(this,"ȣ���� �����ϼ���");
			return false;
		}
		if(dep_nameC.getSelectedIndex()<1) {
			JOptionPane.showMessageDialog(this,"�μ��� �����ϼ���");
			return false;
		}
		
		return true;

	}
	
	public int editEmp() {
		
		Emp emp = new Emp();
		//���
		emp.setEmpNo(Integer.valueOf(emp_noT.getText().trim()));
		//�̸�
		emp.setName(name_t.getText().trim());
		//���ѹ�
		emp.setPhoneNo(mobile_noT1.getSelectedItem()+mobile_noT2.getText().trim()
				+mobile_noT3.getText().trim());
		//�̸���
		String email = emailT.getText().trim()+"@"+emailT1.getText().trim();
		emp.setEmail(email);
		//�ּ�
		emp.setAddress(addressT.getText().trim());
		//�б�
		emp.setSchool(schoolT.getText().trim());
		//����
		emp.setMajor(majorT.getText().trim());
		//�������,�Ի���,�����
		String birth = birthT.getText().trim()+birthT2.getText().trim()+birthT3.getText().trim();
		String start = startworkT.getText().trim()+startworkT2.getText().trim()
				+startworkT3.getText().trim();
		String last = lastworkT1.getText().trim()+lastworkT2.getText().trim()
				+lastworkT3.getText().trim();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDD");
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
		//���¹�ȣ
		emp.setAccount(bank_accountT.getText().trim());
		//�����̸�
		emp.setBankName(bank_nameT.getText().trim());
		//������
		emp.setBankHolder(bank_holderT.getText().trim());
		//���
		emp.setHobby(hobbyT.getText().trim());
		//Ư��
		emp.setSpecialty(specialtyT.getText().trim());
		//�亯
		emp.setAnswer(answerT.getText().trim());
		//���
		emp.setRemarks(area_remarks.getText().trim());
		//�μ�
		emp.setDept((String)dep_nameC.getSelectedItem());
		//����
		emp.setGender((String)combo_gender.getSelectedItem());
		//��������
		emp.setQuestion((String)combo_question.getSelectedItem());
		//����
		emp.setState((String)combo_state.getSelectedItem());
		//����
		emp.setRank((String)rank_nameC.getSelectedItem());
		//ȣ��
		emp.setPayRank((String)paylevel_noC.getSelectedItem());
		
		return dao.editEmp(emp);
		
	}
	
	public void clearForm() {
		
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
		
		targetFile = null;
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
		
	}
	
	public void transferImage() {
		
		byte[] buf = new byte[1024];
		int len = 0;
		String destName = empNo+".jpg";
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

