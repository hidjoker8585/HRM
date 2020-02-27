package dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/**
 * @brief 크레딧 다이얼로그입니다
 * @author 이현우
 * @version ver 1.00 (2020-02-27)
 * @see 
 */
public class CreditDialog extends JDialog{
	
	//컴포넌트 필드
	private JLabel lbl_head;
	private JLabel lbl_photo;
	private JTextArea area_content;
	
	//이미지
	private File file;
	private File basicFile;
	private BufferedImage bfImg;
	private Image image;
	private ImageIcon iIcon;
	
	public CreditDialog(JFrame f, String msg, boolean modal) {
		// TODO Auto-generated constructor stub
		super(f,msg,modal);
		
		setSize(new Dimension(660,760)); //다이얼로그 크기
		setLayout(null);
		setLocationRelativeTo(null); //가운데 위치
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //닫기
		setResizable(false); //크기 조정
		
		//텍스트 헤드 추가
		lbl_head = new JLabel("중부기술교육원");
		lbl_head.setBounds(10, 10, 630, 100);
		lbl_head.setFont(new Font("고딕",Font.BOLD,40));
		lbl_head.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lbl_head.setHorizontalAlignment(JLabel.CENTER);
				
				
		//이미지 추가
		lbl_photo = new JLabel();
		lbl_photo.setBounds(10, 130, 630, 360);
		lbl_photo.setBorder(new EtchedBorder());
		file = new File("./src/resource", "Jungbu.jpg");
		basicFile = new File("./src/resource","image.jpg");
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
		image = bfImg.getScaledInstance(lbl_photo.getWidth(), lbl_photo.getHeight(), Image.SCALE_SMOOTH);
		iIcon = new ImageIcon(image);
		lbl_photo.setIcon(iIcon);
		
		//콘텐츠 추가
		String txt = "\t\t      <제작자 소개>\n\n" + 
				"            참여자 : 이현우, 김순기, 신동윤, 박빈, 이선화, 박영훈, 유지광, 최혜원 \n\n " +
				"\t\t  <프로젝트 깃 주소> \n" + 
				"\t   https://github.com/hidjoker8585/HRM-project \n" +
				"\t\t       감사합니다 \n";
		area_content = new JTextArea();
		area_content.setBounds(10, 500, 630, 200);
		area_content.setFont(new Font("고딕",Font.BOLD,16));
		area_content.setEditable(false);
		area_content.setLineWrap(true);
		area_content.setBackground(new Color(238, 238, 238));
		area_content.setBorder(new BevelBorder(BevelBorder.RAISED));
		area_content.setText(txt);
		
		add(lbl_head);
		add(lbl_photo);
		add(area_content);
	}
}
