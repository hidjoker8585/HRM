package dialog;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @brief 로그인 창 
 * @author 박빈
 * @version v1.00 2020.02.11
 * @see 
 */
public class LoginDialog extends JDialog{
	public LoginDialog(JFrame f, String msg, boolean modal) {
		// TODO Auto-generated constructor stub
		super(f,msg,modal);
		
		setSize(new Dimension(500,660)); //다이얼로그 크기
		setLocationRelativeTo(null); //가운데 위치
		//setLocation(new Point(0,0));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //닫기
		setLayout(null);
		
		
		JButton btn = new JButton("버튼1");
		btn.setBounds(40,40,100,30);
		
		JTextField txt = new JTextField("내용을 입력하세요");
		txt.setBounds(40,100,200,30);
		
		
		add(btn);
		add(txt);
	}
}
