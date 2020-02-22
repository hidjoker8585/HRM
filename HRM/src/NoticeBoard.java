import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class NoticeBoard {

	private JFrame frame;
	private JTextField id;
	private JPasswordField password;
	private JPanel mainPanel;
	private JLabel lblNewLabel;
	private JPanel M_boardpanel;
	private JButton btn_N_Button;
	private JButton btn_N_Button_1;
	private JButton btn_N_Button_2;
	private JButton btn_N_Button_3;
	private JButton btn_N_Button_4;
	private JButton btn_N_Button_5;
	private JPanel tablePanel;
	private JTextField Search;
	private JButton btn_beforeButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoticeBoard window = new NoticeBoard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NoticeBoard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 1144, 824);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);
		
		lblNewLabel = new JLabel("Welcom~!!");
		lblNewLabel.setForeground(new Color(160, 82, 45));
		lblNewLabel.setFont(new Font("����", Font.BOLD | Font.ITALIC, 48));
		lblNewLabel.setBounds(820, 23, 312, 48);
		mainPanel.add(lblNewLabel);
		
		
		
		
		
		
		ImagePanel S_boardpanel = new ImagePanel(new ImageIcon("G:/Product/HRM-project/HRM/image/S_board.png").getImage());
		S_boardpanel.setBounds(30,81, 252, 692);
		mainPanel.add(S_boardpanel);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setText("  ");
		textArea.setBackground(new Color(222, 184, 135));
		textArea.setFont(new Font("����", Font.PLAIN, 12));
		textArea.setForeground(Color.BLACK);
		textArea.setToolTipText("\uAE00\uC744 \uC791\uC131\uD558\uC2E0\uD6C4 \uC800\uC7A5\uD558\uAE30 \uBC84\uD2BC\uC744 \uB20C\uB7EC\uC8FC\uC138\uC694");
		textArea.setBounds(12, 148, 217, 370);
		S_boardpanel.add(textArea);
		
		
		tablePanel = new JPanel();
		tablePanel.setBackground(new Color(243, 211, 165));
		tablePanel.setBounds(15, 148, 210, 370);
		tablePanel.setVisible(true);
		String[][]data=new String[][] {{"1","������1�Դϴ�","2020.01.05","������"},{"2","������2�Դϴ�","2020.01.06","������"},{"3","������3�Դϴ�","2020.01.07","������"}
			,{"4","������4�Դϴ�","2020.01.08","������"},{"5","������6�Դϴ�","2020.01.09","������"},{"6","������6�Դϴ�","2020.01.10","������"},{"7","������7�Դϴ�","2020.01.11","������"},{"8","������8�Դϴ�","2020.01.12","������"},{"9","������9�Դϴ�","2020.01.13","������"}
			,{"10","������10�Դϴ�","2020.01.14","������"},{"11","������11�Դϴ�","2020.01.15","������"},{"12","������12�Դϴ�","2020.01.16","������"},{"13","������13�Դϴ�","2020.01.17","������"},{"14","������14�Դϴ�","2020.01.18","������"},
			{"15","������15�Դϴ�","2020.01.19","������"},{"16","������16�Դϴ�","2020.01.20","������"},{"17","������17�Դϴ�","2020.02.11","������"},{"18","������18�Դϴ�","2020.02.12","������"},{"19","������19�Դϴ�","2020.02.19","������"}
			,{"20","������20�Դϴ�","2020.02.21","������"}};
			
		String[]headers=new String[] {"��ȣ","����","��¥","�ۼ���"};
		JTable table=new JTable(data,headers);
		table.setFont(new Font("sanserif",Font.BOLD,10));
		table.setRowHeight(20);
		table.setAlignmentX(0);
		table.setSize(210,370);
		table.setPreferredScrollableViewportSize(new Dimension(210,370));
		
	
		tablePanel.add(new JScrollPane(table));
		Search = new JTextField();
		
		JButton btn_saveButton_2 = new JButton("\uC800\uC7A5\uD558\uAE30");
		frame.getContentPane().add(tablePanel);
		
		
		
		
		S_boardpanel.add(tablePanel);
		
		
		
		JButton btn_exitButton = new JButton("EXIT");
		btn_exitButton.setForeground(new Color(128, 0, 0));
		btn_exitButton.setBackground(new Color(222, 184, 135));
		btn_exitButton.setFont(new Font("����", Font.BOLD, 24));
		btn_exitButton.setBounds(12, 600, 217, 53);
		btn_exitButton.setBorder(null);
		S_boardpanel.add(btn_exitButton);
		
		JButton btn_ListButton_1 = new JButton("\uAE00\uBAA9\uB85D\uBCF4\uAE30");
		btn_ListButton_1.setForeground(new Color(128, 0, 0));
		btn_ListButton_1.setFont(new Font("����", Font.BOLD, 24));
		btn_ListButton_1.setBackground(new Color(222, 184, 135));
		btn_ListButton_1.setBounds(12, 85, 217, 53);
		btn_ListButton_1.setBorder(null);
		S_boardpanel.add(btn_ListButton_1);
		btn_ListButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				textArea.setVisible(false);
				btn_saveButton_2.setVisible(false);
				
				
				tablePanel.setVisible(true);
				Search.setVisible(true);
				
				
				
			}
		});
		
		
		btn_saveButton_2.setForeground(new Color(128, 0, 0));
		btn_saveButton_2.setFont(new Font("����", Font.BOLD, 24));
		btn_saveButton_2.setBackground(new Color(222, 184, 135));
		btn_saveButton_2.setBounds(12, 537, 217, 53);
		btn_saveButton_2.setBorder(null);
		S_boardpanel.add(btn_saveButton_2);
		
		
		Search.setToolTipText("\uAC80\uC0C9\uC5B4\uB97C \uC785\uB825\uD558\uC138\uC694");
		Search.setFont(new Font("����", Font.PLAIN, 14));
		Search.setBounds(12, 85, 217, 53);
		S_boardpanel.add(Search);
		Search.setColumns(10);
		
		btn_beforeButton = new JButton("\uC774\uC804 \uD654\uBA74\uAC00\uAE30");
		btn_beforeButton.setForeground(new Color(128, 0, 0));
		btn_beforeButton.setFont(new Font("����", Font.BOLD, 24));
		btn_beforeButton.setBorder(null);
		btn_beforeButton.setBackground(new Color(222, 184, 135));
		btn_beforeButton.setBounds(12, 537, 217, 53);
		
		S_boardpanel.add(btn_beforeButton);
		
		
		Search = new JTextField();
		Search.setFont(new Font("����", Font.PLAIN, 14));
		Search.setBounds(12, 85, 217, 53);
		S_boardpanel.add(Search);
		Search.setColumns(10);	
		
	
		Search.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String val=Search.getText();
				TableRowSorter<TableModel>trs=new TableRowSorter<>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});
		
		ImagePanel M_boardpanel = new ImagePanel(new ImageIcon("G:/Product/HRM-project/HRM/image/M_board.png").getImage());
		M_boardpanel.setBounds(280, 81, 847, 692);
		mainPanel.add(M_boardpanel);
		
		btn_N_Button = new JButton("");
		btn_N_Button.setIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/post_it02.png"));
		btn_N_Button.setPressedIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/on_post_it02.png"));
		btn_N_Button.setBounds(54, 116, 209, 206);
		btn_N_Button.setBorder(null);
		
		M_boardpanel.add(btn_N_Button);
		
		btn_N_Button_1 = new JButton("");
		btn_N_Button_1.setBorder(null);
		btn_N_Button_1.setIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/post_it01.png"));
		btn_N_Button_1.setPressedIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/on_post_it01.png"));
		btn_N_Button_1.setBounds(555, 116, 209, 206);
		M_boardpanel.add(btn_N_Button_1);
		
		btn_N_Button_2 = new JButton("");
		btn_N_Button_2.setBorder(null);
		btn_N_Button_2.setIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/post_it01.png"));
		btn_N_Button_2.setPressedIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/on_post_it01.png"));
		btn_N_Button_2.setBounds(307, 116, 209, 206);
		M_boardpanel.add(btn_N_Button_2);
		
		btn_N_Button_3 = new JButton("");
		btn_N_Button_3.setBorder(null);
		btn_N_Button_3.setIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/post_it01.png"));
		btn_N_Button_3.setPressedIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/on_post_it01.png"));
		btn_N_Button_3.setBounds(54, 413, 209, 206);
		M_boardpanel.add(btn_N_Button_3);
		
		btn_N_Button_4 = new JButton("");
		btn_N_Button_4.setBorder(null);
		btn_N_Button_4.setIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/post_it01.png"));
		btn_N_Button_4.setPressedIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/on_post_it01.png"));
		btn_N_Button_4.setBounds(307, 413, 209, 206);
		M_boardpanel.add(btn_N_Button_4);
		
		btn_N_Button_5 = new JButton("");
		btn_N_Button_5.setBorder(null);
		btn_N_Button_5.setIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/post_it01.png"));
		btn_N_Button_5.setPressedIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/on_post_it01.png"));
		btn_N_Button_5.setBounds(555, 413, 209, 206);
		M_boardpanel.add(btn_N_Button_5);
		ImagePanel welcomePanel=new ImagePanel(new ImageIcon("G:/Product/HRM-project/HRM/image/badpark_m.jpg").getImage());
		welcomePanel.setBounds(0, 0, 1134, 852);
		frame.getContentPane().add(welcomePanel);
		
			frame.setSize(welcomePanel.getWidth(),welcomePanel.getHeight());
			welcomePanel.setLayout(null);
			
			id = new JTextField();
			id.setBounds(23, 25, 126, 23);
			id.setForeground(Color.DARK_GRAY);
			id.setFont(new Font("����", Font.PLAIN, 12));
			id.setToolTipText("ID");
			welcomePanel.add(id);
			id.setColumns(10);
			
			password = new JPasswordField();
			password.setBounds(23, 58, 126, 23);
			password.setForeground(Color.DARK_GRAY);
			password.setToolTipText("password");
			password.setFont(new Font("����", Font.PLAIN, 12));
			welcomePanel.add(password);
			
			JButton btnLogIn = new JButton("LOGIN");
			btnLogIn.setBounds(23, 91, 126, 23);
			welcomePanel.add(btnLogIn);
			btnLogIn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (id.getText().equals("jbedu")&&Arrays.equals(password.getPassword(),"1234".toCharArray())) {
						System.out.println("ȯ���մϴ�");
						welcomePanel.setVisible(false);
						mainPanel.setVisible(true);
						
					}else {
						JOptionPane.showMessageDialog(null, "�α��ο� �����ϼ̽��ϴ�");
					}
					
			}
			});
	
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class ImagePanel extends JPanel{
	
	private Image img;
	
	public ImagePanel(Image img) {
		this.img=img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);
		
}
	public int getWidth() {
		return img.getWidth(null);
	}
	
	public int getHeight() {
		return img.getHeight(null);
	}

	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
