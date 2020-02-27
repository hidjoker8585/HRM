package dialog;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.DaoImpl;
import dto.Emp;
import main.MainFrame;
import panel.LogPanel;
import util.SHA512;

/**
 * @brief 로그인 창 
 * @author 정 : 박빈, 부 : 이현우
 * @version v1.01 2020.02.26
 * @see 
 */
public class LoginDialog extends JDialog implements ActionListener,WindowListener{
	
	
	//컨테이너
	private MainFrame frame;
	private Container root;
	private LogPanel pane_logResult;
	
	//컴포넌트
	private JLabel lbl_empNo;
	private JLabel lbl_pw;
	private JTextField txt_empNo;
	private JPasswordField pw_password;
	private JButton btn_login;
	private JButton btn_findPw;
	
	//DB
	private DaoImpl dao;
	
	
	
	public LoginDialog(JFrame f, String msg, boolean modal) {
		// TODO Auto-generated constructor stub
		super(f,msg,modal);
		frame = (MainFrame)f;
		root = frame.getRoot();
		dao = MainFrame.getDao();		

		pane_logResult = new LogPanel(frame);
		
		setSize(new Dimension(500,400)); //다이얼로그 크기
		setLocationRelativeTo(null); //가운데 위치
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLayout(null);
		setResizable(false); //크기 조정s
		
		lbl_empNo = new JLabel("사원번호");
		lbl_empNo.setBounds(100,100,60,40);
		
		txt_empNo = new JTextField();
		txt_empNo.setBounds(180,100,220,40);
		
		lbl_pw = new JLabel("패스워드");
		lbl_pw.setBounds(100,170,60,40);
		
		pw_password = new JPasswordField();
		pw_password.setBounds(180,170,220,40);
		
		btn_login = new JButton("로그인");
		btn_login.setBounds(300,260,100,40);
		btn_login.addActionListener(this);
		
		btn_findPw = new JButton("PW찾기");
		btn_findPw.setBounds(100,260,100,40);
				
		addWindowListener(this);
		
		
		add(lbl_empNo);
		add(txt_empNo);
		add(lbl_pw);
		add(pw_password);
		add(btn_login);
		add(btn_findPw);
			
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		Object[] option = {"예","아니오"};
		int selected = JOptionPane.showOptionDialog(this, "프로그램을 종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION
				, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
		if(selected==0) {
			System.exit(0);
		}
	}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_login) {
			procLogin();
		}
		if(e.getSource()==btn_findPw) {
			JOptionPane.showMessageDialog(this, "공사중..");
		}
	}
	
	public void procLogin() {
		
		Emp emp = new Emp();
		emp.setEmpNo(Integer.valueOf(txt_empNo.getText().trim()));
		//emp.setPw(SHA512.getSHA512(String.valueOf(pw_password.getPassword())));
		emp.setPw(String.valueOf(pw_password.getPassword()));

		boolean result = dao.chkLogin(emp);	
		//로그인 결과
		if(result) {
			if(emp.getEmpNo()==10000) frame.setMaster(true); //관리자
			frame.setLogin(result);
			frame.setUser(dao.getEmpForUser(emp));
			frame.makeMenuBar();
			root.removeAll();
			root.add(pane_logResult);
			frame.validate();
			frame.repaint();
			txt_empNo.setText("");
			pw_password.setText("");
			dispose();
		}else {
			JOptionPane.showMessageDialog(this, "사원번호,비밀번호를 다시 확인하세요");
		}
	}

	
}
