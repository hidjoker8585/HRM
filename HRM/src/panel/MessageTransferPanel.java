package panel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

/**
 * @brief  Messagesending
 * @author ksk
 * @version V1.00 2020.02.12
 * @see none
 */
public class MessageTransferPanel extends JPanel{

	public MessageTransferPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
	
		setBackground(Color.white);
		
		JButton btn1 = new JButton("쓰기");
		btn1.setBounds(50,100,100,30);
		
		JTextField txt = new JTextField("입력하세요");
		txt.setBounds(50,150,600,200);
		
		JButton btn2 = new JButton("보내기");
		btn2.setBounds(550,370,100,30);
		
		add(btn1);
		add(txt);
		add(btn2);
		
		
		
		
		
		
		
	}
}
