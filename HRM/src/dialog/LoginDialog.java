package dialog;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @brief �α��� â 
 * @author �ں�
 * @version v1.00 2020.02.11
 * @see 
 */
public class LoginDialog extends JDialog{
	public LoginDialog(JFrame f, String msg, boolean modal) {
		// TODO Auto-generated constructor stub
		super(f,msg,modal);
		
		setSize(new Dimension(500,660)); //���̾�α� ũ��
		setLocationRelativeTo(null); //��� ��ġ
		//setLocation(new Point(0,0));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //�ݱ�
		setLayout(null);
		
		
		JButton btn = new JButton("��ư1");
		btn.setBounds(40,40,100,30);
		
		JTextField txt = new JTextField("������ �Է��ϼ���");
		txt.setBounds(40,100,200,30);
		
		
		add(btn);
		add(txt);
	}
}
