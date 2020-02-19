package dialog;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * @brief ��� ��ȸ ���̾�α�
 * @author �ڿ���
 * @version v1.00 2020.02.19
 * @see none
 */

public class EmpDetailDialog extends JDialog{
	private int empNo;
	public EmpDetailDialog(JFrame f, String msg, boolean modal,int num) {
		// TODO Auto-generated constructor stub
		super(f,msg,modal);
		
		setSize(new Dimension(600,880)); //���̾�α� ũ��
		setLocationRelativeTo(null); //��� ��ġ
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //�ݱ�

		
		Label search = new Label("��ȸ : ");
		search.setBounds(200,50,80,40);
		add(search);
		
		Choice searchC = new Choice();
		searchC.setBounds(300, 60, 100, 40);
		searchC.add("��ȸ����");
		searchC.add("�����ȣ");
		searchC.add("����̸�");
		searchC.add("��ȭ��ȣ");
		add(searchC);
				
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

		//����Ϲ�ȣ
		Label mobile_no = new Label("�ڵ�����ȣ : ");
		mobile_no.setBounds(200, 150, 80, 40);
		add(mobile_no);
		TextField mobile_t = new TextField("");
		mobile_t.setBounds(300,160,120,20);
		add(mobile_t);
				
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
		Button pic_b1 = new Button("��������");
		pic_b1.setBackground(Color. YELLOW);
		pic_b1.setBounds(63, 235, 80, 30);
		add(pic_b1);
				
		//�������
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
		
				
		//�Ի���
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
				
		//����
		Label rank_name = new Label("���� : ");
		rank_name.setBounds(60, 370, 80, 40);
		add(rank_name);
		TextField rank_nameT = new TextField("");
		rank_nameT.setBounds(220, 380, 30, 20);
		add(rank_nameT);
		
		//ȣ��
		Label paylevel_no = new Label("ȣ�� : ");
		paylevel_no.setBounds(300, 370, 80, 40);
		add(paylevel_no);
		TextField paylevel_noT = new TextField("");
		paylevel_noT.setBounds(390, 380, 30, 20);
		add(paylevel_noT);			
				
				
		//�μ�
		Label dep_name = new Label("�μ� : ");
		dep_name.setBounds(60, 400, 80, 40);
		add(dep_name);
		TextField dep_nameT = new TextField("");
		dep_nameT.setBounds(160, 410, 120, 20);
		add(dep_nameT);	
		
		
		//���¹�ȣ
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
				
		//���
		Label hobby = new Label("��� : ");
		hobby.setBounds(60, 460, 80, 40);
		add(hobby);
		TextField hobbyT = new TextField("");
		hobbyT.setBounds(160,470,300,40);
		add(hobbyT);
				
		//Ư��
		Label specialty = new Label("Ư�� : ");
		specialty.setBounds(60, 510, 80, 40);
		add(specialty);
		TextField specialtyT = new TextField("");
		specialtyT.setBounds(160,520,300,40);
		add(specialtyT);

		//����
		Button clear_b = new Button("�ű�");
		clear_b.setBackground(Color. YELLOW);
		clear_b.setBounds(63, 600, 80, 30);
		add(clear_b);
				
		Button mod_b = new Button("����");
		mod_b.setBackground(Color. YELLOW);
		mod_b.setBounds(400, 600, 80, 30);
		add(mod_b);
				
	}
}
