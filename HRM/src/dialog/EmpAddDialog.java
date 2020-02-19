package dialog;

import java.awt.*;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * @brief ��� ��� ���̾�α�
 * @author �ڿ���
 * @version v1.00 2020.02.11
 * @see none
 */
public class EmpAddDialog extends JDialog {

	public EmpAddDialog(JFrame f, String msg, boolean modal) {
		// TODO Auto-generated constructor stub
		super(f,msg,modal);
		
		setSize(new Dimension(600,800)); //���̾�α� ũ��
		setLocationRelativeTo(null); //��� ��ġ
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //�ݱ�
		setLayout(null);

		//�����ȣ
		Label emp_no = new Label("�����ȣ : ");
		emp_no.setBounds(200,90,80,40);
		add(emp_no);
		TextField emp_noT = new TextField("�ڵ����� �˴ϴ�");
		emp_noT.setBounds(300,100,120,20);
		
		add(emp_noT);

		//����̸�
		Label emp_name = new Label("����̸� : ");
		emp_name.setBounds(200,120,80,40);
		add(emp_name);
		TextField name_t = new TextField("");
		name_t.setBounds(300,130,120,20);
		add(name_t);

		Label mobile_no = new Label("�ڵ�����ȣ : ");
		mobile_no.setBounds(200, 150, 80, 40);
		add(mobile_no);
		Choice mobile_noT1 = new Choice();
		mobile_noT1.setBounds(300,160,50,20);
		mobile_noT1.add("010");
		mobile_noT1.add("011");
		add(mobile_noT1);
		TextField mobile_noT2 = new TextField("");
		mobile_noT2.setBounds(360,160,70,20);
		add(mobile_noT2);
		TextField mobile_noT3 = new TextField("");
		mobile_noT3.setBounds(440,160,70,20);
		add(mobile_noT3);
		
		Label email = new Label("e-mail : ");
		email.setBounds(200, 180, 80, 40);
		add(email);
		TextField emailT = new TextField("");
		emailT.setBounds(300,190,90,20);
		add(emailT);
		Label email_la1 = new Label("@");
		email_la1.setBounds(390, 190, 20, 20);
		add(email_la1);
		TextField emailT1 = new TextField("");
		emailT1.setBounds(410,190,80,20);
		add(emailT1);
		
		Choice email_c = new Choice();
		email_c.setBounds(490, 190, 70, 40);
		email_c.add("�����Է�");
		email_c.add("naver.com");
		email_c.add("gmail.com");
		email_c.add("daum.net");
		add(email_c);
		
		Label address = new Label("�ּ� : ");
		address.setBounds(200, 210, 80, 40);
		add(address);
		TextField addressT = new TextField("");
		addressT.setBounds(300,220,250,40);
		add(addressT);
		
		Label school = new Label("����б� : ");
		school.setBounds(60, 280, 80, 40);
		add(school);
		TextField schoolT = new TextField("");
		schoolT.setBounds(160,290,200,20);
		add(schoolT);
		
		
		//�������
		Canvas c= new Canvas();
		c.setBounds(50,100,110,120);
		c.setBackground(Color. GRAY);
		add(c);
		Button pic_b1 = new Button("�������");
		pic_b1.setBackground(Color. YELLOW);
		pic_b1.setBounds(63, 235, 80, 30);
		add(pic_b1);
		
		//������� ���
		Label birth = new Label("������� : ");
		birth.setBounds(60, 310, 80, 40);
		add(birth);
		TextField birthT = new TextField("");
		birthT.setBounds(160, 320, 50, 20);
		add(birthT);
		TextField birthT2 = new TextField("");
		birthT2.setBounds(220, 320, 30, 20);
		add(birthT2);
		TextField birthT3 = new TextField("");
		birthT3.setBounds(260, 320, 30, 20);
		add(birthT3);
		Label birth_la1 = new Label("ex) 1986. 09. 20");
		birth_la1.setBounds(300, 310, 100, 40);
		add(birth_la1);
		
		//�Ի��� ���
		Label startwork = new Label("�Ի��� : ");
		startwork.setBounds(60, 340, 80, 40);
		add(startwork);
		TextField startworkT = new TextField("");
		startworkT.setBounds(160, 350, 50, 20);
		add(startworkT);
		TextField startworkT2 = new TextField("");
		startworkT2.setBounds(220, 350, 30, 20);
		add(startworkT2);
		TextField startworkT3 = new TextField("");
		startworkT3.setBounds(260, 350, 30, 20);
		add(startworkT3);
		Label startwork_la1 = new Label("ex) 1990. 09. 20");
		startwork_la1.setBounds(300, 340, 100, 40);
		add(startwork_la1);
		
		//���޵��
		Label rank_name = new Label("���� : ");
		rank_name.setBounds(60, 370, 80, 40);
		add(rank_name);
		
		Choice rank_nameC = new Choice();
		rank_nameC.setBounds(160, 380, 120, 40);
		rank_nameC.add("���޼���");
		rank_nameC.add("����");
		rank_nameC.add("����");
		rank_nameC.add("���");
		add(rank_nameC);
		
		//ȣ�����
		Label paylevel_no = new Label("ȣ�� : ");
		paylevel_no.setBounds(300, 370, 80, 40);
		add(paylevel_no);
			
		Choice paylevel_noC = new Choice();
		paylevel_noC.setBounds(400, 380, 120, 40);
		paylevel_noC.add("ȣ������");
		paylevel_noC.add("1��");
		paylevel_noC.add("2��");
		paylevel_noC.add("3��");
		add(paylevel_noC);
		
		//�μ����
		Label dep_name = new Label("�μ� : ");
		dep_name.setBounds(60, 400, 80, 40);
		add(dep_name);
			
		Choice dep_nameC = new Choice();
		dep_nameC.setBounds(160, 410, 120, 40);
		dep_nameC.add("�μ�����");
		dep_nameC.add("�λ��");
		dep_nameC.add("������");
		dep_nameC.add("������");
		dep_nameC.add("�����κ�");
		dep_nameC.add("�����");
		dep_nameC.add("IT��");
		dep_nameC.add("�����ú�");
		add(dep_nameC);
		
		//���¹�ȣ ���
		Label bank_account = new Label("���¹�ȣ : ");
		bank_account.setBounds(60, 430, 80, 40);
		add(bank_account);
		TextField bank_accountT = new TextField("");
		bank_accountT.setBounds(160,440,200,20);
		add(bank_accountT);
		TextField bank_nameT = new TextField("");
		bank_nameT.setBounds(380,440,80,20);
		add(bank_nameT);
		Label bank_name = new Label(" ����");
		bank_name.setBounds(460, 430, 40, 40);
		add(bank_name);
		
		//��̵��
		Label hobby = new Label("��� : ");
		hobby.setBounds(60, 460, 80, 40);
		add(hobby);
		TextField hobbyT = new TextField("");
		hobbyT.setBounds(160,470,300,40);
		add(hobbyT);
		
		//Ư����
		Label specialty = new Label("Ư�� : ");
		specialty.setBounds(60, 510, 80, 40);
		add(specialty);
		TextField specialtyT = new TextField("");
		specialtyT.setBounds(160,520,300,40);
		add(specialtyT);

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
		Button clear_b = new Button("�ű�");
		clear_b.setBackground(Color. YELLOW);
		clear_b.setBounds(63, 600, 80, 30);
		add(clear_b);
		
		Button save_b = new Button("����");
		save_b.setBackground(Color. YELLOW);
		save_b.setBounds(300, 600, 80, 30);
		add(save_b);
		
		Button mod_b = new Button("����");
		mod_b.setBackground(Color. YELLOW);
		mod_b.setBounds(400, 600, 80, 30);
		add(mod_b);
		
	}

}

