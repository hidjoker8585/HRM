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
		
		JButton btn = new JButton("버튼");
		btn.setBounds(50,100,100,30);
		
		JTextField txt = new JTextField("입력하세요");
		txt.setBounds(50,200,600,50);
		
		add(btn);
		add(txt);
		
		
		
		
		
		
		
	}
}
