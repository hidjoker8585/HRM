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
public class EmpAddDialog extends JFrame{
	
	//public EmpAddDialog(JFrame f, String msg, boolean modal) {
		// TODO Auto-generated constructor stub
		//super(f,msg,modal);
		
		//setSize(new Dimension(660,880)); //���̾�α� ũ��
		//setLocationRelativeTo(null); //��� ��ġ
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE); //�ݱ�
		
		 Label emp_no;
		 Label emp_name;
		 Label mobile_no;
		 Label email;
		 Label address;
		 Label school;
		 Label birth;
		 Label startWork;
		 Label lastWork;
		 Label rank_name;
		 Label paylevel_no;
		 Label bank_account;
		 Label hobby;
		 Label specialty;
		 Label photo;
		 Label dep_no;
		 Label year;
		 Label month;
		 Label day;
		 
		 TextField emp_noF;
		 TextField emp_nameF;
		 TextField mobile_noF;
		 TextField emailF;
		 TextField addressF;
		 TextField schoolF;
		 TextField birthF;
		 TextField startWorkF;
		 TextField lastWorkF;
		 TextField rank_nameF;
		 TextField paylevel_noF;
		 TextField bank_accountF;
		 TextField hobbyF;
		 TextField specialtyF;
		 TextField photoF;
		 TextField dep_noF;
		 

		 Choice yearC;
		 Choice monthC;
		 Choice dayC;

		 Button resetB;
		 Button confirmB;
		 Button modifyB;
		 

		 Panel[] p;

		 MenuBar bar;

		 EmpAddDialog(String title)
		 {
		  super(title);
		  this.initMembers();
		  this.settingFrame();
		  this.showFrame();
		 }
		 
		 public void inputNumbers(int n, Choice c )
		 {
		    
		  for(int i = 0; i <= n ; i++ )
		  {
		   c.add( Integer.toString(i) );
		  }
		 }
		 
		 public void inputNumbers(int start,int n, Choice c )
		 {
		  for(int i = start; i <= n ; i++ )
		   c.add( Integer.toString(i));
		 }
		 
		 private void initMembers()
		 {
			 emp_no = new Label("�����ȣ");
			 emp_name = new Label("�̸�");
			 mobile_no = new Label("��ȭ��ȣ");
			 email = new Label("�̸���");
			 address = new Label("�ּ�");
			 school = new Label("����б�");
			 birth = new Label("�������");
			 year = new Label("��");
			 month = new Label("��");
			 day = new Label("��");
			 startWork = new Label("�Ի���");
			 lastWork = new Label("������");
			 rank_name = new Label("����");
			 paylevel_no = new Label("ȣ��");
			 bank_account = new Label("���¹�ȣ");
			 hobby = new Label("���");
			 specialty = new Label("Ư��");
			 photo = new Label("����");
			 dep_no = new Label("�μ�");
			
			 
			 emp_noF = new TextField(10);
			 emp_nameF = new TextField(20);
			 mobile_noF = new TextField(20);
			 emailF = new TextField(20);
			 addressF = new TextField(50);
			 schoolF = new TextField(20);
			 birthF = new TextField(15);
			 startWorkF = new TextField(15);
			 lastWorkF = new TextField(15);
			 rank_nameF = new TextField(10);
			 paylevel_noF = new TextField(10);
			 bank_accountF = new TextField(20);
			 hobbyF = new TextField(30);
			 specialtyF = new TextField(30);
			 photoF = new TextField(10);
			 dep_noF = new TextField(10);
				
		  

			 yearC = new Choice();
			 this.inputNumbers(1940, 2020, yearC);
			 monthC = new Choice();
			 this.inputNumbers(12, monthC);
			 dayC = new Choice();
			 this.inputNumbers(31, dayC);

		 	 resetB = new Button("�� ��");
			 confirmB = new Button("�� ��");
			 modifyB = new Button("�� ��");

			 p = new Panel[15];
			 for(int i = 0; i < p.length; i++)
				 p[i] = new Panel();

		 }
		 
		 public void settingFrame()
		 {
		 
		  p[0].add(emp_no);
		  p[0].add(emp_noF);

		  p[1].add(emp_name);
		  p[1].add(emp_nameF);
		  
		  p[2].add(mobile_no);
		  p[2].add(mobile_noF);
		  
		  p[3].add(email);
		  p[3].add(emailF);
		  
		  p[4].add(address);
		  p[4].add(addressF);
		  
		  p[5].add(photo);
		  p[5].add(photoF);
		  	  
		  p[6].add(school);
		  p[6].add(schoolF);
		  
		  p[7].add(birth);
		  p[7].add(yearC);
		  p[7].add(year);
		  p[7].add(monthC);
		  p[7].add(month);
		  p[7].add(dayC);
		  p[7].add(day);
		  
		  
		  p[8].add(startWork);
		  p[8].add(startWorkF);
		  
		  	  
		  //p[7].add(lastWork);
		  //p[7].add(lastWorkF);
		  
		  p[9].add(rank_name);
		  p[9].add(rank_nameF);
		  
		  p[10].add(paylevel_no);
		  p[10].add(paylevel_noF);
		  
		  p[11].add(bank_account);
		  p[11].add(bank_accountF);
		  
		  p[12].add(hobby);
		  p[12].add(hobbyF);
		  
		  p[13].add(specialty);
		  p[13].add(specialtyF);
		  
		  p[14].add(resetB);
		  p[14].add(confirmB);
		  p[14].add(modifyB);

		 }
		 public void showFrame()
		 {
		  this.setLayout( new GridLayout(16,1) );
		  //this.setMenuBar(bar);
		  
		  for(int i = 0 ; i < p.length ; i++)
		   this.add(p[i]);
		  //this.add(p[0]);

		  this.setSize(800,800);
		  this.pack();
		  this.setVisible(true);
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 }

		 public static void main(String[] args)
		 {
		  new EmpAddDialog("ȸ������");
		 }

	}

