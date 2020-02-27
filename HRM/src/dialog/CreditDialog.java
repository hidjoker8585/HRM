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
 * @brief ũ���� ���̾�α��Դϴ�
 * @author ������
 * @version ver 1.00 (2020-02-27)
 * @see 
 */
public class CreditDialog extends JDialog{
	
	//������Ʈ �ʵ�
	private JLabel lbl_head;
	private JLabel lbl_photo;
	private JTextArea area_content;
	
	//�̹���
	private File file;
	private File basicFile;
	private BufferedImage bfImg;
	private Image image;
	private ImageIcon iIcon;
	
	public CreditDialog(JFrame f, String msg, boolean modal) {
		// TODO Auto-generated constructor stub
		super(f,msg,modal);
		
		setSize(new Dimension(660,760)); //���̾�α� ũ��
		setLayout(null);
		setLocationRelativeTo(null); //��� ��ġ
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //�ݱ�
		setResizable(false); //ũ�� ����
		
		//�ؽ�Ʈ ��� �߰�
		lbl_head = new JLabel("�ߺα��������");
		lbl_head.setBounds(10, 10, 630, 100);
		lbl_head.setFont(new Font("���",Font.BOLD,40));
		lbl_head.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lbl_head.setHorizontalAlignment(JLabel.CENTER);
				
				
		//�̹��� �߰�
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
		
		//������ �߰�
		String txt = "\t\t      <������ �Ұ�>\n\n" + 
				"            ������ : ������, �����, �ŵ���, �ں�, �̼�ȭ, �ڿ���, ������, ������ \n\n " +
				"\t\t  <������Ʈ �� �ּ�> \n" + 
				"\t   https://github.com/hidjoker8585/HRM-project \n" +
				"\t\t       �����մϴ� \n";
		area_content = new JTextArea();
		area_content.setBounds(10, 500, 630, 200);
		area_content.setFont(new Font("���",Font.BOLD,16));
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
