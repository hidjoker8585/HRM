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
 * @brief 메인 프레임입니다
 *        모든 화면의 기본이 되는 클래스입니다
 * 
 * @author 이현우
 * @version 1.00 2020. 02. 11
 * @see GUI 안정성을 위하여 AWT 대신 SWING을 사용합니다. 
 *      컴포넌트와 컨테이너 앞에 J만 붙고 AWT 사용법 동일
 * 
 */

public class MainFrame extends JFrame implements ActionListener{


	/**
	 * 모든 컴포넌트와 컨테이너는 접근제한자 private
	 * 변수명 레이블 lbl_이름, 텍스트박스 txt_이름, 텍스트필드 area_, 테이블 table_이름
	 * 패널 pane_이름, 다이얼로그 dialog_이름 등..
	 * 
	 */
	//권한
	private boolean master = true; //(관리자 : true)
	
	//컨테이너
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
	
	//컴포넌트
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
		setTitle("인사관리 프로그램");
		
		setSize(new Dimension(1280,768)); //프레임 크기
		setLocationRelativeTo(null); //가운데 위치
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		root = getContentPane();
		root.setLayout(new GridLayout(1,1));				

		//다이얼로그 생성
		aboutDialog = new AboutDialog(this,"대하여",true);
		accountDialog = new AccountLookupDialog(this,"계좌정보",true);
		boardDetailDialog = new BoardDetailDialog(this,"게시글보기",true);
		boardWriteDialog = new BoardWriteDialog(this,"게시글작성",true);
		creditDialog = new CreditDialog(this,"크레딧",true);
		empAddDialog = new EmpAddDialog(this,"사원등록",true);
		empDetailDialog = new EmpDetailDialog(this,"사원상세",true);
		empUpdateDialog = new EmpUpdateDialog(this,"사원수정",true);
		helpDialog = new HelpDialog(this,"도움말",true);
		LoginDialog = new LoginDialog(this,"로그인",true);
		modifyPwDialog = new ModifyPasswordDialog(this,"패스워드 수정",true);
		pwFindDialog = new PasswordFindDialog(this,"패스워드 찾기",true);
		schAddDialog = new ScheduleAddDialog(this,"일정 등록",true);
		
		//주패널 생성
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

		mInfo = new JMenu("정보");
		
		miLogout = new JMenuItem("LogOut");
		miLogout.addActionListener(this);
		mInfo.add(miLogout);

		miSch = new JMenuItem("일정");
		miSch.addActionListener(this);
		mInfo.add(miSch);

		miBoard = new JMenuItem("게시판");
		miBoard.addActionListener(this);
		mInfo.add(miBoard);

		if(master==true) {
			miMessage = new JMenuItem("알림메시지");
			miMessage.addActionListener(this);
			mInfo.add(miMessage);
		}
		
		miExit = new JMenuItem("종료");
		miExit.addActionListener(this);
		mInfo.add(miExit);
		
		
		mEmp = new JMenu("사원");
		
		if(master==true) {
			miEmpAdd = new JMenuItem("사원등록");
			miEmpAdd.addActionListener(this);
			mEmp.add(miEmpAdd);
		}
		
		miEmpLookup = new JMenuItem("사원조회");
		miEmpLookup.addActionListener(this);
		mEmp.add(miEmpLookup);
		
		mDept = new JMenu("부서");
		
		miDeptLookup = new JMenuItem("부서조회");
		miDeptLookup.addActionListener(this);
		mDept.add(miDeptLookup);
		
		if(master==true) {
			miDeptManage = new JMenuItem("부서관리");
			miDeptManage.addActionListener(this);
			mDept.add(miDeptManage);
		}
		
		mEvl = new JMenu("인사평가");
		
		if(master==true) {
			miEvlManage = new JMenuItem("인사평가 관리");
			miEvlManage.addActionListener(this);
			mEvl.add(miEvlManage);
		}else {
			miEvlStart = new JMenuItem("인사평가 실시");
			miEvlStart.addActionListener(this);
			mEvl.add(miEvlStart);
		}
		
		miEvlResult = new JMenuItem("인사평가 결과");
		miEvlResult.addActionListener(this);
		mEvl.add(miEvlResult);
		
		mHelp = new JMenu("도움");
		
		miHelp = new JMenuItem("도움말");
		miHelp.addActionListener(this);
		mHelp.add(miHelp);
		
		miAbout = new JMenuItem("관하여");
		miAbout.addActionListener(this);
		mHelp.add(miAbout);
		
		miCredit = new JMenuItem("크레딧");
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
			JOptionPane.showMessageDialog(this, "작업중");
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
