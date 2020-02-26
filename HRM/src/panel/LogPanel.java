package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import main.MainFrame;

public class LogPanel extends JPanel implements AncestorListener{

	//ÄÁÅ×ÀÌ³Ê
	private MainFrame frame;
	private JPanel pane_main;
	private JPanel pane_sub_log;
	
	//ÄÄÆ÷³ÍÆ®
	private JLabel lbl_image;
	private JLabel lbl_Name;
	private JLabel lbl_welcome;
	
	//ÀÌ¹ÌÁö
	private File basicFile;
	private BufferedImage bfImg;
	private Image image;
	private ImageIcon iIcon;

	
	public LogPanel(JFrame f) {
		// TODO Auto-generated constructor stub
		frame = (MainFrame)f;
		
		initPane();
		
		add(pane_main);
	}
	
	public void initPane() {
		
		setLayout(new GridLayout(1,1));
		
		pane_main = new JPanel();
		pane_main.setLayout(null);
		pane_main.setBackground(Color.DARK_GRAY);
		pane_main.addAncestorListener(this);

		pane_sub_log = new JPanel();
		pane_sub_log.setLayout(null);
		pane_sub_log.setBounds(0,0,1280,150);
		pane_sub_log.setBackground(Color.pink);
		
		lbl_image = new JLabel();
		lbl_image.setBounds(800,20,100,100);
		lbl_image.setBorder(new EtchedBorder());
		
		basicFile = new File("./src/resource","image.jpg");
		
		lbl_Name = new JLabel();
		lbl_Name.setBounds(920, 50, 100, 40);
		lbl_Name.setFont(new Font("¸¼Àº»ù¹°",Font.ITALIC,20));
		
		lbl_welcome = new JLabel();
		lbl_welcome.setBounds(1040, 50, 200, 40);
		lbl_welcome.setFont(new Font("¸¼Àº»ù¹°",Font.PLAIN,18));
		lbl_welcome.setText(" ´Ô, È¯¿µÇÕ´Ï´Ù!!");
		
	}
	
	public void getLog() {
		if (frame.getLogin()) {
			System.out.println("°Ù·Î±×");
			File file = new File("./src/resource", frame.getUser().getEmpNo() + ".jpg");
			if (file.exists()) {
				try {
					bfImg = ImageIO.read(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				image = bfImg.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
				iIcon = new ImageIcon(image);
				lbl_image.setIcon(iIcon);
			} else {
				try {
					bfImg = ImageIO.read(basicFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				image = bfImg.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
				iIcon = new ImageIcon(image);
				lbl_image.setIcon(iIcon);
			}

			lbl_Name.setText(frame.getUser().getName());

			pane_sub_log.add(lbl_image);
			pane_sub_log.add(lbl_Name);
			pane_sub_log.add(lbl_welcome);

			pane_main.add(pane_sub_log);

		}
		
	}

	@Override
	public void ancestorAdded(AncestorEvent event) {
		// TODO Auto-generated method stub
		getLog();
	}
	@Override
	public void ancestorMoved(AncestorEvent event) {}
	@Override
	public void ancestorRemoved(AncestorEvent event) {}


}
