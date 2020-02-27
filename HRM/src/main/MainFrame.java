package main;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dao.DaoImpl;
import dialog.AboutDialog;
import dialog.BoardDetailDialog;
import dialog.BoardWriteDialog;
import dialog.CreditDialog;
import dialog.EmpAddDialog;
import dialog.EmpDetailDialog;
import dialog.EmpUpdateDialog;
import dialog.HelpDialog;
import dialog.LoginDialog;
import dialog.ModifyPasswordDialog;
import dialog.PasswordFindDialog;
import dialog.ScheduleAddDialog;
import dto.Emp;
import panel.BoardListPanel;
import panel.DeptLookupPanel;
import panel.DeptManagePanel;
import panel.EmpLookupPanel;
import panel.EvaluationExecPanel;
import panel.EvaluationManagePanel;
import panel.EvaluationResultPanel;
import panel.LogPanel;
import panel.MessageTransferPanel;
import panel.ScheduleDetailPanel;
import panel.ScheduleManagePanel;

/**
 * @brief ���� �������Դϴ�
 *        ��� ȭ���� �⺻�� �Ǵ� Ŭ�����Դϴ�
 * 
 * @author ������
 * @version 1.01 2020. 02. 26
 * @see �޴��� ����
 * 
 */

public class MainFrame extends JFrame implements ActionListener{

	//Log
	private boolean login = false; //(�α��ο���)
	
	//����
	private boolean master = false; //(������ : true)
	
	//����� ����
	private Emp user;
	
	//�����̳�
	private Container root;
	
	private JPanel empLookupPane;
	private JPanel deptLookupPane;
	private JPanel deptManagePane;
	private JPanel evlExecPane;
	private JPanel evlResPane;
	private JPanel evlManagePane;
	private JPanel boardListPane;
	private JPanel messagePane;
	private JPanel schManagePane;
	private JPanel schDetailPane;
	private JPanel logPane;

	
	private JDialog aboutDialog;
	private JDialog boardDetailDialog;
	private JDialog boardWriteDialog;
	private JDialog creditDialog;
	private JDialog empAddDialog;
	private JDialog helpDialog;
	private JDialog loginDialog;
	private JDialog modifyPwDialog;
	private JDialog pwFindDialog;
	private JDialog schAddDialog;
	
	//������Ʈ
	private JMenuBar mb;
	
	private JMenu mInfo;
	private JMenu mEmp;
	private JMenu mDept;
	private JMenu mEvl;
	private JMenu mHelp;
	
    private JMenuItem miLog;
	private JMenuItem miSch;
	private JMenuItem miBoard;
	private JMenuItem miMessage;
	private JMenuItem miExit;
	
	private JMenuItem miEmpAdd;
	private JMenuItem miEmpLookup;
	
	private JMenuItem miDeptLookup;
	private JMenuItem miDeptManage;
	
	private JMenuItem miEvlResult;
	private JMenuItem miEvlStart;
	private JMenuItem miEvlManage;
	
	private JMenuItem miAbout;
	private JMenuItem miCredit;
	private JMenuItem miHelp;
	
	//DB
	private static DaoImpl dao = new DaoImpl();
	

	
	public MainFrame() {
		// TODO Auto-generated constructor stub
		
		//������ �ʱ� ����
		initFrame();
		
		//�α��� ó��
		loginProc();
		
		//�޴��� ����
		makeMenuBar();
				
		revalidate();
		repaint();

	}
	
	public void initFrame() {

		setLayout(new GridLayout(1,1));
		setTitle("�λ���� ���α׷�");
		
		setSize(new Dimension(1280,768)); //������ ũ��
		setLocationRelativeTo(null); //��� ��ġ
		setResizable(false); //ũ�� ����
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		root = getContentPane();
		root.setLayout(new GridLayout(1,1));
		

		//���̾�α� ����
		aboutDialog = new AboutDialog(this,"���Ͽ�",true);
		boardDetailDialog = new BoardDetailDialog(this,"�Խñۺ���",true);
		boardWriteDialog = new BoardWriteDialog(this,"�Խñ��ۼ�",true);
		creditDialog = new CreditDialog(this,"ũ����",true);
		empAddDialog = new EmpAddDialog(this,"������",true);
		helpDialog = new HelpDialog(this,"����",true);
		loginDialog = new LoginDialog(this,"�α���",true);
		modifyPwDialog = new ModifyPasswordDialog(this,"�н����� ����",true);
		pwFindDialog = new PasswordFindDialog(this,"�н����� ã��",true);
		schAddDialog = new ScheduleAddDialog(this,"���� ���",true);
		
		//���г� ����
		boardListPane = new BoardListPanel();
		deptLookupPane = new DeptLookupPanel(this);
		deptManagePane = new DeptManagePanel(this);
		empLookupPane = new EmpLookupPanel(this);
		evlExecPane = new EvaluationExecPanel();
		evlManagePane = new EvaluationManagePanel();
		evlResPane = new EvaluationResultPanel();
		messagePane = new MessageTransferPanel();
		schDetailPane = new ScheduleDetailPanel();
		schManagePane = new ScheduleManagePanel();
		logPane = new LogPanel(this);
		
		//�޴� ������Ʈ ����
		mb = new JMenuBar();

		mInfo = new JMenu("����");
		miLog = new JMenuItem("LogOut");
		miLog.addActionListener(this);
		miSch = new JMenuItem("����");
		miSch.addActionListener(this);
		miBoard = new JMenuItem("�Խ���");
		miBoard.addActionListener(this);
		miMessage = new JMenuItem("�˸��޽���");
		miMessage.addActionListener(this);
		miExit = new JMenuItem("����");
		miExit.addActionListener(this);
		
		mEmp = new JMenu("���");
		miEmpAdd = new JMenuItem("������");
		miEmpAdd.addActionListener(this);
		miEmpLookup = new JMenuItem("�����ȸ");
		miEmpLookup.addActionListener(this);
		
		mDept = new JMenu("�μ�");
		miDeptLookup = new JMenuItem("�μ���ȸ");
		miDeptLookup.addActionListener(this);
		miDeptManage = new JMenuItem("�μ�����");
		miDeptManage.addActionListener(this);
		
		mEvl = new JMenu("�λ���");
		miEvlManage = new JMenuItem("�λ��� ����");
		miEvlManage.addActionListener(this);
		miEvlStart = new JMenuItem("�λ��� �ǽ�");
		miEvlStart.addActionListener(this);
		miEvlResult = new JMenuItem("�λ��� ���");
		miEvlResult.addActionListener(this);
		
		mHelp = new JMenu("����");
		miHelp = new JMenuItem("����");
		miHelp.addActionListener(this);
		miAbout = new JMenuItem("���Ͽ�");
		miAbout.addActionListener(this);
		miCredit = new JMenuItem("ũ����");
		miCredit.addActionListener(this);
		
		setJMenuBar(mb);	

	}
	
	public void loginProc() {
		root.add(logPane);
		validate();
		repaint();
		loginDialog.setVisible(true);
	}
	
	public void makeMenuBar() {
		
		mb.removeAll();
		mInfo.removeAll();
		mEmp.removeAll();
		mDept.removeAll();
		mEvl.removeAll();
		mHelp.removeAll();
		
		if(login) {
			mb.setEnabled(true);
		
			mInfo.add(miLog);
			mInfo.add(miSch);
			mInfo.add(miBoard);
			if (master == true)
				mInfo.add(miMessage);
			mInfo.add(miExit);
			if (master == true)
				mEmp.add(miEmpAdd);
			mEmp.add(miEmpLookup);
			mDept.add(miDeptLookup);
			if (master == true)
				mDept.add(miDeptManage);
			if (master == true) {
				mEvl.add(miEvlManage);
			} else {
				mEvl.add(miEvlStart);
			}
			mEvl.add(miEvlResult);
			mHelp.add(miHelp);
			mHelp.add(miAbout);
			mHelp.add(miCredit);

			mb.add(mInfo);
			mb.add(mEmp);
			mb.add(mDept);
			mb.add(mEvl);
			mb.add(mHelp);
		}else {
			mb.setEnabled(false);
		}
	
	}
	
	public boolean getMaster() {
		return master;
	}
	public void setMaster(boolean value) {
		master = value;
	}
	
	public boolean getLogin() {
		return login;
	}
	public void setLogin(boolean res) {
		login = res;
	}
	
	public Emp getUser() {
		return user;
	}
	
	public void setUser(Emp u) {
		user = u;
	}
	
	public Container getRoot() {
		return root;
	}
	public static DaoImpl getDao() {
		return dao;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==miLog) {
			login = false;
			master = false;
			makeMenuBar();
			root.removeAll();
			root.add(logPane);
			validate();
			repaint();
			loginDialog.setVisible(true);
		}else if(e.getSource()==miSch) {
			JOptionPane.showMessageDialog(this, "������..");
//			root.removeAll();
//			root.add(schManagePane);
//			validate();
//			repaint();
		}else if(e.getSource()==miBoard) {
			JOptionPane.showMessageDialog(this, "������..");
//			root.removeAll();
//			root.add(boardListPane);
//			validate();
//			repaint();
		}else if(e.getSource()==miMessage) {
			JOptionPane.showMessageDialog(this, "������..");
//			root.removeAll();
//			root.add(messagePane);
//			validate();
//			repaint();
		}else if(e.getSource()==miExit) {
			System.exit(0);
		}else if(e.getSource()==miEmpAdd) {
			empAddDialog.setVisible(true);
		}else if(e.getSource()==miEmpLookup) {
			root.removeAll();
			root.add(empLookupPane);
			validate();
			repaint();
		}else if(e.getSource()==miDeptLookup) {
			root.removeAll();
			root.add(deptLookupPane);
			validate();
			repaint();
		}else if(e.getSource()==miDeptManage) {
			root.removeAll();
			root.add(deptManagePane);
			validate();
			repaint();
		}else if(e.getSource()==miEvlManage) {
			JOptionPane.showMessageDialog(this, "������..");
//			root.removeAll();
//			root.add(evlManagePane);
//			validate();
//			repaint();
		}else if(e.getSource()==miEvlStart) {
			JOptionPane.showMessageDialog(this, "������..");
//			root.removeAll();
//			root.add(evlExecPane);
//			validate();
//			repaint();
		}else if(e.getSource()==miEvlResult) {
			JOptionPane.showMessageDialog(this, "������..");
//			root.removeAll();
//			root.add(evlResPane);
//			validate();
//			repaint();
		}else if(e.getSource()==miHelp) {
//			helpDialog.setVisible(true);
			JOptionPane.showMessageDialog(this, "������..");
		}else if(e.getSource()==miAbout) {
//			aboutDialog.setVisible(true);
			JOptionPane.showMessageDialog(this, "������..");
		}else if(e.getSource()==miCredit) {
			root.removeAll();
			root.add(logPane);
			validate();
			repaint();
			creditDialog.setVisible(true);
		}
		
	}

	
}
