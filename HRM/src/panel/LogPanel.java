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
import javax.swing.BorderFactory;
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
	private JLabel lbl_head;
	private JLabel lbl_image;
	private JLabel lbl_Name;
	private JLabel lbl_welcome;
	private JLabel lbl_main_image1;
	private JLabel lbl_main_image2;
	private JLabel lbl_main_image3;
	private JLabel lbl_main_image4;

	
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
		
		lbl_main_image1 = new JLabel();
		lbl_main_image1.setBounds(160,90,400,300);
		lbl_main_image1.setBorder(new EtchedBorder());

		lbl_main_image2 = new JLabel();
		lbl_main_image2.setBounds(710,90,400,300);
		lbl_main_image2.setBorder(new EtchedBorder());
		
		lbl_main_image3 = new JLabel();
		lbl_main_image3.setBounds(160,400,400,300);
		lbl_main_image3.setBorder(new EtchedBorder());
		
		lbl_main_image4 = new JLabel();
		lbl_main_image4.setBounds(710,400,400,300);
		lbl_main_image4.setBorder(new EtchedBorder());
		
		pane_sub_log = new JPanel();
		pane_sub_log.setLayout(null);
		pane_sub_log.setBounds(0,0,1280,80);
		pane_sub_log.setBackground(Color.pink);
		
		lbl_head = new JLabel("ÁßºÎ±â¼ú±³À°¿ø");
		lbl_head.setBounds(10, 10, 300, 70);
		lbl_head.setFont(new Font("°íµñ",Font.ITALIC,40));
		lbl_head.setHorizontalAlignment(JLabel.CENTER);
		
		lbl_image = new JLabel();
		lbl_image.setBounds(900,10,60,60);
		lbl_image.setBorder(new EtchedBorder());
		
		basicFile = new File("./src/resource","image.jpg");
		
		lbl_Name = new JLabel();
		lbl_Name.setBounds(980, 30, 70, 40);
		lbl_Name.setFont(new Font("¸¼Àº»ù¹°",Font.ITALIC,20));
		
		lbl_welcome = new JLabel();
		lbl_welcome.setBounds(1060, 30, 180, 40);
		lbl_welcome.setFont(new Font("¸¼Àº»ù¹°",Font.PLAIN,18));
		lbl_welcome.setText(" ´Ô, È¯¿µÇÕ´Ï´Ù!!");
		
	}
	
	public void getLog() {
		if (frame.getLogin()) {
			
			File file = new File("./src/resource", "Jungbu1.jpg");
			if (file.exists()) {
				try {
					bfImg = ImageIO.read(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					bfImg = ImageIO.read(basicFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			image = bfImg.getScaledInstance(lbl_main_image1.getWidth(), lbl_main_image1.getHeight(), Image.SCALE_SMOOTH);
			iIcon = new ImageIcon(image);
			lbl_main_image1.setIcon(iIcon);
			
			file = new File("./src/resource", "Jungbu2.jpg");
			if (file.exists()) {
				try {
					bfImg = ImageIO.read(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					bfImg = ImageIO.read(basicFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			image = bfImg.getScaledInstance(lbl_main_image2.getWidth(), lbl_main_image2.getHeight(), Image.SCALE_SMOOTH);
			iIcon = new ImageIcon(image);
			lbl_main_image2.setIcon(iIcon);
			
			file = new File("./src/resource", "Jungbu3.jpg");
			if (file.exists()) {
				try {
					bfImg = ImageIO.read(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					bfImg = ImageIO.read(basicFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			image = bfImg.getScaledInstance(lbl_main_image3.getWidth(), lbl_main_image3.getHeight(), Image.SCALE_SMOOTH);
			iIcon = new ImageIcon(image);
			lbl_main_image3.setIcon(iIcon);
			
			file = new File("./src/resource", "Jungbu4.jpg");
			if (file.exists()) {
				try {
					bfImg = ImageIO.read(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					bfImg = ImageIO.read(basicFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			image = bfImg.getScaledInstance(lbl_main_image4.getWidth(), lbl_main_image4.getHeight(), Image.SCALE_SMOOTH);
			iIcon = new ImageIcon(image);
			lbl_main_image4.setIcon(iIcon);
			
			file = new File("./src/resource", frame.getUser().getEmpNo() + ".jpg");
			if (file.exists()) {
				try {
					bfImg = ImageIO.read(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				try {
					bfImg = ImageIO.read(basicFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			image = bfImg.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
			iIcon = new ImageIcon(image);
			lbl_image.setIcon(iIcon);

			lbl_Name.setText(frame.getUser().getName());

			pane_main.add(lbl_main_image1);
			pane_main.add(lbl_main_image2);
			pane_main.add(lbl_main_image3);
			pane_main.add(lbl_main_image4);
			
			pane_sub_log.add(lbl_head);
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
	public void ancestorRemoved(AncestorEvent event) {
		pane_sub_log.removeAll();
		pane_main.removeAll();
	}


}
