package panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 * @brief 게시판 패널입니다
 * @author 최예원
 * @version ver1.00 2020.02.18
 * @see 
 */
public class BoardListPanel extends JPanel{

	public BoardListPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		JButton btn = new JButton();

		JPanel subPane = new JPanel();
		subPane.setBounds(350,100,900,500);
		subPane.setBorder(new EtchedBorder());
		subPane.setBackground(new Color(200,200,200));
		subPane.setLayout(new GridLayout(0,3));
	
		for(int i=0 ; i<12 ; i++) {
			JLabel lbl = new JLabel("게시판");
			lbl.setPreferredSize(new Dimension(200,200));
			lbl.setBorder(new EtchedBorder());
			lbl.setBackground(Color.BLUE);
			subPane.add(lbl);
		}
		
		setBackground(Color.PINK);
		add(btn);
		add(subPane);
		
	}
	
}
