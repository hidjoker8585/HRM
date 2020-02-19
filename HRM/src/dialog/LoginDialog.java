package dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/**
 * @brief 로그인 창 
 * @author 박빈
 * @version v1.00 2020.02.11
 * @see 
 */
public class LoginDialog extends JDialog{

	//BufferedImage img;
	Image img2;
	
	public LoginDialog(JFrame f, String msg, boolean modal) {
		// TODO Auto-generated constructor stub
		super(f,msg,modal);
		
		setSize(new Dimension(500,300)); //다이얼로그 크기
		setLocationRelativeTo(null); //가운데 위치
		//setLocation(new Point(0,0));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //닫기
		setLayout(null);
		
		

		
		JLabel lbl1 = new JLabel("사원번호");
		lbl1.setBounds(50,100,100,30);
		lbl1.setFont(new Font("고딕", Font.PLAIN, 20));
	//	lbl1.setBorder(new EtchedBorder());
		
		JLabel lbl2 = new JLabel("비밀번호");
		lbl2.setBounds(50,150,100,30);
		lbl2.setFont(new Font("고딕", Font.PLAIN, 20));
	//	lbl2.setBorder(new EtchedBorder());
		
		
		JTextField txt = new JTextField("");
		txt.setBounds(150,100,200,30);
	
		try {
			//img = ImageIO.read(new File("./src/resource","스머프.jpg"));
			img2 = ImageIO.read(new File("./src/resource","스머프.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JButton btn = new JButton(new ImageIcon(img2));
		btn.setBounds(200,200,100,30);
		btn.setFont(new Font("고딕", Font.BOLD, 16));
		btn.setBackground(Color.pink);
		
		JLabel lbl3 = new JLabel();
		lbl3.setBounds(0,0,100,30);		
		
		JPasswordField pw = new JPasswordField();
		pw.setBounds(150,150,200,30);
		

		
		add(pw);
		add(btn);
		add(lbl1);
		add(txt);
		add(lbl2);

	}
	
//	@Override
//	public void paint(Graphics g) {
//		// TODO Auto-generated method stub
//		g.drawImage(img, 0, 0, 600, 400, null);
//	}
}
