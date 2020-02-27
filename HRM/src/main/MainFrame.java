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
 * @brief 메인 프레임입니다
 *        모든 화면의 기본이 되는 클래스입니다
 * 
 * @author 이현우
 * @version 1.01 2020. 02. 26
 * @see 메뉴바 정리
 * 
 */

public class MainFrame extends JFrame implements ActionListener{

	//Log
	private boolean login = false; //(로그인여부)
	
	//권한
	private boolean master = false; //(관리자 : true)
	
	//사용자 정보
	private Emp user;
	
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
	
	//컴포넌트
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
		
		//프레임 초기 구성
		initFrame();
		
		//로그인 처리
		loginProc();
		
		//메뉴바 셋팅
		makeMenuBar();
				
		revalidate();
		repaint();

	}
	
	public void initFrame() {

		setLayout(new GridLayout(1,1));
		setTitle("인사관리 프로그램");
		
		setSize(new Dimension(1280,768)); //프레임 크기
		setLocationRelativeTo(null); //가운데 위치
		setResizable(false); //크기 조정
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		root = getContentPane();
		root.setLayout(new GridLayout(1,1));
		

		//다이얼로그 생성
		aboutDialog = new AboutDialog(this,"대하여",true);
		boardDetailDialog = new BoardDetailDialog(this,"게시글보기",true);
		boardWriteDialog = new BoardWriteDialog(this,"게시글작성",true);
		creditDialog = new CreditDialog(this,"크레딧",true);
		empAddDialog = new EmpAddDialog(this,"사원등록",true);
		helpDialog = new HelpDialog(this,"도움말",true);
		loginDialog = new LoginDialog(this,"로그인",true);
		modifyPwDialog = new ModifyPasswordDialog(this,"패스워드 수정",true);
		pwFindDialog = new PasswordFindDialog(this,"패스워드 찾기",true);
		schAddDialog = new ScheduleAddDialog(this,"일정 등록",true);
		
		//주패널 생성
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
		
		//메뉴 컴포넌트 생성
		mb = new JMenuBar();

		mInfo = new JMenu("정보");
		miLog = new JMenuItem("LogOut");
		miLog.addActionListener(this);
		miSch = new JMenuItem("일정");
		miSch.addActionListener(this);
		miBoard = new JMenuItem("게시판");
		miBoard.addActionListener(this);
		miMessage = new JMenuItem("알림메시지");
		miMessage.addActionListener(this);
		miExit = new JMenuItem("종료");
		miExit.addActionListener(this);
		
		mEmp = new JMenu("사원");
		miEmpAdd = new JMenuItem("사원등록");
		miEmpAdd.addActionListener(this);
		miEmpLookup = new JMenuItem("사원조회");
		miEmpLookup.addActionListener(this);
		
		mDept = new JMenu("부서");
		miDeptLookup = new JMenuItem("부서조회");
		miDeptLookup.addActionListener(this);
		miDeptManage = new JMenuItem("부서관리");
		miDeptManage.addActionListener(this);
		
		mEvl = new JMenu("인사평가");
		miEvlManage = new JMenuItem("인사평가 관리");
		miEvlManage.addActionListener(this);
		miEvlStart = new JMenuItem("인사평가 실시");
		miEvlStart.addActionListener(this);
		miEvlResult = new JMenuItem("인사평가 결과");
		miEvlResult.addActionListener(this);
		
		mHelp = new JMenu("도움");
		miHelp = new JMenuItem("도움말");
		miHelp.addActionListener(this);
		miAbout = new JMenuItem("관하여");
		miAbout.addActionListener(this);
		miCredit = new JMenuItem("크레딧");
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
			JOptionPane.showMessageDialog(this, "공사중..");
//			root.removeAll();
//			root.add(schManagePane);
//			validate();
//			repaint();
		}else if(e.getSource()==miBoard) {
			JOptionPane.showMessageDialog(this, "공사중..");
//			root.removeAll();
//			root.add(boardListPane);
//			validate();
//			repaint();
		}else if(e.getSource()==miMessage) {
			JOptionPane.showMessageDialog(this, "공사중..");
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
			JOptionPane.showMessageDialog(this, "공사중..");
//			root.removeAll();
//			root.add(evlManagePane);
//			validate();
//			repaint();
		}else if(e.getSource()==miEvlStart) {
			JOptionPane.showMessageDialog(this, "공사중..");
//			root.removeAll();
//			root.add(evlExecPane);
//			validate();
//			repaint();
		}else if(e.getSource()==miEvlResult) {
			JOptionPane.showMessageDialog(this, "공사중..");
//			root.removeAll();
//			root.add(evlResPane);
//			validate();
//			repaint();
		}else if(e.getSource()==miHelp) {
//			helpDialog.setVisible(true);
			JOptionPane.showMessageDialog(this, "공사중..");
		}else if(e.getSource()==miAbout) {
//			aboutDialog.setVisible(true);
			JOptionPane.showMessageDialog(this, "공사중..");
		}else if(e.getSource()==miCredit) {
			root.removeAll();
			root.add(logPane);
			validate();
			repaint();
			creditDialog.setVisible(true);
		}
		
	}

	
}
