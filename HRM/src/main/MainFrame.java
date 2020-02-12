package main;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dialog.AboutDialog;
import dialog.AccountLookupDialog;
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
import panel.BoardListPanel;
import panel.DeptLookupPanel;
import panel.DeptManagePanel;
import panel.EmpLookupPanel;
import panel.EvaluationExecPanel;
import panel.EvaluationManagePanel;
import panel.EvaluationResultPanel;
import panel.MessageTransferPanel;
import panel.ScheduleDetailPanel;
import panel.ScheduleManagePanel;

/**
 * @brief ���� �������Դϴ�
 *        ��� ȭ���� �⺻�� �Ǵ� Ŭ�����Դϴ�
 * 
 * @author ������
 * @version 1.00 2020. 02. 11
 * @see GUI �������� ���Ͽ� AWT ��� SWING�� ����մϴ�. 
 *      ������Ʈ�� �����̳� �տ� J�� �ٰ� AWT ���� ����
 * 
 */

public class MainFrame extends JFrame implements ActionListener{


	/**
	 * ��� ������Ʈ�� �����̳ʴ� ���������� private
	 * ������ ���̺� lbl_�̸�, �ؽ�Ʈ�ڽ� txt_�̸�, �ؽ�Ʈ�ʵ� area_, ���̺� table_�̸�
	 * �г� pane_�̸�, ���̾�α� dialog_�̸� ��..
	 * 
	 */
	//����
	private boolean master = false; //(������ : true)
	
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
	
	private JDialog aboutDialog;
	private JDialog accountDialog;
	private JDialog boardDetailDialog;
	private JDialog boardWriteDialog;
	private JDialog creditDialog;
	private JDialog empAddDialog;
	private JDialog empDetailDialog;
	private JDialog empUpdateDialog;
	private JDialog helpDialog;
	private JDialog LoginDialog;
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
	
	private JMenuItem miLogout;
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
	

	
	public MainFrame() {
		// TODO Auto-generated constructor stub
		
		initFrame();
		loginProc();
		makeMenuBar();

	}
	
	public void initFrame() {

		setLayout(new GridLayout(1,1));
		setTitle("�λ���� ���α׷�");
		
		setSize(new Dimension(1280,768)); //������ ũ��
		setLocationRelativeTo(null); //��� ��ġ
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		root = getContentPane();
		root.setLayout(new GridLayout(1,1));				

		//���̾�α� ����
		aboutDialog = new AboutDialog(this,"���Ͽ�",true);
		accountDialog = new AccountLookupDialog(this,"��������",true);
		boardDetailDialog = new BoardDetailDialog(this,"�Խñۺ���",true);
		boardWriteDialog = new BoardWriteDialog(this,"�Խñ��ۼ�",true);
		creditDialog = new CreditDialog(this,"ũ����",true);
		empAddDialog = new EmpAddDialog(this,"������",true);
		empDetailDialog = new EmpDetailDialog(this,"�����",true);
		empUpdateDialog = new EmpUpdateDialog(this,"�������",true);
		helpDialog = new HelpDialog(this,"����",true);
		LoginDialog = new LoginDialog(this,"�α���",true);
		modifyPwDialog = new ModifyPasswordDialog(this,"�н����� ����",true);
		pwFindDialog = new PasswordFindDialog(this,"�н����� ã��",true);
		schAddDialog = new ScheduleAddDialog(this,"���� ���",true);
		
		//���г� ����
		boardListPane = new BoardListPanel();
		deptLookupPane = new DeptLookupPanel();
		deptManagePane = new DeptManagePanel();
		empLookupPane = new EmpLookupPanel();
		evlExecPane = new EvaluationExecPanel();
		evlManagePane = new EvaluationManagePanel();
		evlResPane = new EvaluationResultPanel();
		messagePane = new MessageTransferPanel();
		schDetailPane = new ScheduleDetailPanel();
		schManagePane = new ScheduleManagePanel();
		
	}
	
	public void loginProc() {
		
	}
	
	public void makeMenuBar() {
		
		mb = new JMenuBar();

		mInfo = new JMenu("����");
		
		miLogout = new JMenuItem("LogOut");
		miLogout.addActionListener(this);
		mInfo.add(miLogout);

		miSch = new JMenuItem("����");
		miSch.addActionListener(this);
		mInfo.add(miSch);

		miBoard = new JMenuItem("�Խ���");
		miBoard.addActionListener(this);
		mInfo.add(miBoard);

		if(master==true) {
			miMessage = new JMenuItem("�˸��޽���");
			miMessage.addActionListener(this);
			mInfo.add(miMessage);
		}
		
		miExit = new JMenuItem("����");
		miExit.addActionListener(this);
		mInfo.add(miExit);
		
		
		mEmp = new JMenu("���");
		
		if(master==true) {
			miEmpAdd = new JMenuItem("������");
			miEmpAdd.addActionListener(this);
			mEmp.add(miEmpAdd);
		}
		
		miEmpLookup = new JMenuItem("�����ȸ");
		miEmpLookup.addActionListener(this);
		mEmp.add(miEmpLookup);
		
		mDept = new JMenu("�μ�");
		
		miDeptLookup = new JMenuItem("�μ���ȸ");
		miDeptLookup.addActionListener(this);
		mDept.add(miDeptLookup);
		
		if(master==true) {
			miDeptManage = new JMenuItem("�μ�����");
			miDeptManage.addActionListener(this);
			mDept.add(miDeptManage);
		}
		
		mEvl = new JMenu("�λ���");
		
		if(master==true) {
			miEvlManage = new JMenuItem("�λ��� ����");
			miEvlManage.addActionListener(this);
			mEvl.add(miEvlManage);
		}else {
			miEvlStart = new JMenuItem("�λ��� �ǽ�");
			miEvlStart.addActionListener(this);
			mEvl.add(miEvlStart);
		}
		
		miEvlResult = new JMenuItem("�λ��� ���");
		miEvlResult.addActionListener(this);
		mEvl.add(miEvlResult);
		
		mHelp = new JMenu("����");
		
		miHelp = new JMenuItem("����");
		miHelp.addActionListener(this);
		mHelp.add(miHelp);
		
		miAbout = new JMenuItem("���Ͽ�");
		miAbout.addActionListener(this);
		mHelp.add(miAbout);
		
		miCredit = new JMenuItem("ũ����");
		miCredit.addActionListener(this);
		mHelp.add(miCredit);
		
		mb.add(mInfo);
		mb.add(mEmp);
		mb.add(mDept);
		mb.add(mEvl);
		mb.add(mHelp);
		
		setJMenuBar(mb);
	
		revalidate();
		repaint();

	}
	
	public boolean getMaster() {
		return master;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==miLogout) {
			JOptionPane.showMessageDialog(this, "�۾���");
		}else if(e.getSource()==miSch) {
			root.removeAll();
			root.add(schManagePane);
			validate();
			repaint();
		}else if(e.getSource()==miBoard) {
			root.removeAll();
			root.add(boardListPane);
			validate();
			repaint();
		}else if(e.getSource()==miMessage) {
			root.removeAll();
			root.add(messagePane);
			validate();
			repaint();
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
			root.removeAll();
			root.add(evlManagePane);
			validate();
			repaint();
		}else if(e.getSource()==miEvlStart) {
			root.removeAll();
			root.add(evlExecPane);
			validate();
			repaint();
		}else if(e.getSource()==miEvlResult) {
			root.removeAll();
			root.add(evlResPane);
			validate();
			repaint();
		}else if(e.getSource()==miHelp) {
			helpDialog.setVisible(true);
		}else if(e.getSource()==miAbout) {
			aboutDialog.setVisible(true);
		}else if(e.getSource()==miCredit) {
			creditDialog.setVisible(true);
		}
		
	}

	
}
