import java.awt.Color;
import java.awt.Component;
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
	private JTextField ida;
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
	private JTextField Search_1;
	private JButton btn_beforeButton;
	private JTextField textTitle;
	private JTextField text_Day;
	private JTextField textWriter;
	private JTextField TtextField;
	private JTextField DtextField;
	private JTextField WtextField;
	private JTextArea postextArea;
	private JButton ExitButton;
	private JTextArea texNotArea;
	private JTextField TField;
	private JTextField DField;
	private JTextField WField;
	private JTextArea PArea;

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
		


		String[][]data=new String[][] {{"1","공지글1입니다","2020.01.05","관리자"},{"2","공지글2입니다","2020.01.06","관리자"},{"3","공지글3입니다","2020.01.07","관리자"}
			,{"4","공지글4입니다","2020.01.08","관리자"},{"5","공지글6입니다","2020.01.09","관리자"},{"6","공지글6입니다","2020.01.10","관리자"},{"7","공지글7입니다","2020.01.11","관리자"},{"8","공지글8입니다","2020.01.12","관리자"},{"9","공지글9입니다","2020.01.13","관리자"}
			,{"10","공지글10입니다","2020.01.14","관리자"},{"11","공지글11입니다","2020.01.15","관리자"},{"12","공지글12입니다","2020.01.16","관리자"},{"13","공지글13입니다","2020.01.17","관리자"},{"14","공지글14입니다","2020.01.18","관리자"},
			{"15","공지글15입니다","2020.01.19","관리자"},{"16","공지글16입니다","2020.01.20","관리자"},{"17","공지글17입니다","2020.02.11","관리자"},{"18","공지글18입니다","2020.02.12","관리자"},{"19","공지글19입니다","2020.02.19","관리자"}
			,{"20","공지글20입니다","2020.02.21","관리자"}};
			
		String[]headers=new String[] {"번호","제목","날짜","작성자"};
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 1144, 824);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);
		mainPanel.setLayout(null);
		
		ImagePanel M_boardpanel_1 = new ImagePanel(new ImageIcon("G:/Product/HRM-project/HRM/image/M_board.png").getImage());
		M_boardpanel_1.setBounds(280, 81, 847, 692);
		mainPanel.add(M_boardpanel_1);
		
		ImagePanel S_boardpanel = new ImagePanel(new ImageIcon("G:/Product/HRM-project/HRM/image/S_board.png").getImage());
		S_boardpanel.setBounds(30,81, 252, 692);
		mainPanel.add(S_boardpanel);
		
		JTable table=new JTable(data,headers);
		table.setFont(new Font("굴림",Font.PLAIN,10));
		table.setRowHeight(20);
		table.setAlignmentX(0);
		table.setSize(210,370);
		table.setPreferredScrollableViewportSize(new Dimension(210,370));
		
		
		
		
		
		
		TtextField = new JTextField();
		M_boardpanel_1.add(TtextField);
		TtextField.setFont(new Font("굴림", Font.PLAIN, 11));
		TtextField.setBounds(67, 129, 184, 20);
		TtextField.setColumns(10);
		TtextField.setBorder(null);
		
		DtextField = new JTextField();
		M_boardpanel_1.add(DtextField);
		DtextField.setFont(new Font("굴림", Font.PLAIN, 9));
		DtextField.setColumns(10);
		DtextField.setBounds(154, 287, 94, 11);
		DtextField.setBorder(null);
		
		WtextField = new JTextField();
		M_boardpanel_1.add(WtextField);
		WtextField.setFont(new Font("굴림", Font.PLAIN, 9));
		WtextField.setColumns(10);
		WtextField.setBounds(153, 305, 96, 11);
		WtextField.setBorder(null);
		
		postextArea = new JTextArea();
		M_boardpanel_1.add(postextArea);
		postextArea.setFont(new Font("굴림", Font.PLAIN, 9));
		postextArea.setBounds(68, 158, 179, 119);
		postextArea.setBorder(null);
		postextArea.setVisible(true);
			
			TField = new JTextField();
			TField.setFont(new Font("굴림", Font.PLAIN, 10));
			TField.setBackground(new Color(255, 222, 173));
			TField.setBounds(320, 128, 184, 21);
			M_boardpanel_1.add(TField);
			TField.setColumns(10);
			TField.setBorder(null);
			
			DField = new JTextField();
			DField.setFont(new Font("굴림", Font.PLAIN, 10));
			DField.setBackground(new Color(245, 222, 179));
			DField.setBounds(419, 284, 85, 15);
			M_boardpanel_1.add(DField);
			DField.setColumns(10);
			DField.setBorder(null);
			
			WField = new JTextField();
			WField.setFont(new Font("굴림", Font.PLAIN, 10));
			WField.setColumns(10);
			WField.setBackground(new Color(245, 222, 179));
			WField.setBounds(419, 299, 85, 15);
			M_boardpanel_1.add(WField);
			WField.setBorder(null);
			
			PArea = new JTextArea();
			PArea.setFont(new Font("굴림", Font.PLAIN, 10));
			PArea.setBackground(new Color(245, 222, 179));
			PArea.setBounds(320, 158, 184, 119);
			M_boardpanel_1.add(PArea);
		
			btn_N_Button = new JButton("");
			btn_N_Button.setIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/post_it02.png"));
			btn_N_Button.setPressedIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/on_post_it02.png"));
			btn_N_Button.setBounds(54, 116, 209, 206);
			btn_N_Button.setBorder(null);
			
			M_boardpanel_1.add(btn_N_Button);
			
			btn_N_Button_1 = new JButton("");
			btn_N_Button_1.setBorder(null);
			btn_N_Button_1.setIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/post_it01.png"));
			btn_N_Button_1.setPressedIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/on_post_it01.png"));
			btn_N_Button_1.setBounds(555, 116, 209, 206);
			M_boardpanel_1.add(btn_N_Button_1);
			
			btn_N_Button_2 = new JButton("");
			btn_N_Button_2.setBorder(null);
			btn_N_Button_2.setIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/post_it01.png"));
			btn_N_Button_2.setPressedIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/on_post_it01.png"));
			btn_N_Button_2.setBounds(307, 116, 209, 206);
			M_boardpanel_1.add(btn_N_Button_2);
			
			btn_N_Button_3 = new JButton("");
			btn_N_Button_3.setBorder(null);
			btn_N_Button_3.setIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/post_it01.png"));
			btn_N_Button_3.setPressedIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/on_post_it01.png"));
			btn_N_Button_3.setBounds(54, 413, 209, 206);
			M_boardpanel_1.add(btn_N_Button_3);
			
			btn_N_Button_4 = new JButton("");
			btn_N_Button_4.setBorder(null);
			btn_N_Button_4.setIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/post_it01.png"));
			btn_N_Button_4.setPressedIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/on_post_it01.png"));
			btn_N_Button_4.setBounds(307, 413, 209, 206);
			M_boardpanel_1.add(btn_N_Button_4);
			
			btn_N_Button_5 = new JButton("");
			btn_N_Button_5.setBorder(null);
			btn_N_Button_5.setIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/post_it01.png"));
			btn_N_Button_5.setPressedIcon(new ImageIcon("G:/Product/HRM-project/HRM/image/on_post_it01.png"));
			btn_N_Button_5.setBounds(555, 413, 209, 206);
			M_boardpanel_1.add(btn_N_Button_5);
			
			lblNewLabel = new JLabel("\uAC8C\uC2DC\uD310\uC5D0 \uC811\uC18D\uD558\uC168\uC2B5\uB2C8\uB2E4.");
			lblNewLabel.setBounds(664, 24, 148, 34);
			M_boardpanel_1.add(lblNewLabel);
			lblNewLabel.setForeground(new Color(160, 82, 45));
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 12));
				S_boardpanel.setLayout(null);
			
	
				ImagePanel Admin_panel = new ImagePanel(new ImageIcon("G:/Product/HRM-project/HRM/image/admin.jpg").getImage());
				Admin_panel.setBounds(3, 450, 237, 199);
				S_boardpanel.add(Admin_panel);
				Admin_panel.setVisible(false);
			
			
			
			
			
			Search = new JTextField();
			S_boardpanel.add(Search);
			Search.setFont(new Font("굴림", Font.PLAIN, 12));
			Search.setBounds(12, 108, 217,30);			
			Search.setColumns(10);
			Search.setVisible(false);
			
		
			Search.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
					String val=Search.getText();
					TableRowSorter<TableModel>trs=new TableRowSorter<>(table.getModel());
					table.setRowSorter(trs);
					trs.setRowFilter(RowFilter.regexFilter(val));
				}
			});
				
				
				
			
			
	
			JButton btn_ManaButton = new JButton("\uAD00\uB9AC\uC790 \uBAA8\uB4DC");
			btn_ManaButton.setBounds(12, 528, 217, 68);
			
			
			btn_ManaButton.setForeground(new Color(128, 0, 0));
			btn_ManaButton.setFont(new Font("굴림", Font.BOLD, 24));
			btn_ManaButton.setBackground(new Color(222, 184, 135));
			btn_ManaButton.setBorder(null);
			S_boardpanel.add(btn_ManaButton);
			

			JButton btn_exitButton = new JButton("EXIT");
			btn_exitButton.setBounds(12, 600, 217, 56);
			btn_exitButton.setForeground(new Color(128, 0, 0));
			btn_exitButton.setBackground(new Color(222, 184, 135));
			btn_exitButton.setFont(new Font("굴림", Font.BOLD, 24));
			btn_exitButton.setBorder(null);
			S_boardpanel.add(btn_exitButton);
			
			btn_exitButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);		
				}
				
			});

		
			JPanel notice_panel = new JPanel();
			notice_panel.setBounds(12, 148, 217, 375);
			S_boardpanel.add(notice_panel);
			notice_panel.setBackground(new Color(222, 184, 135));
			notice_panel.setLayout(null);
			notice_panel.setVisible(false);
			
			JButton btnboButton = new JButton("\uAC8C\uC2DC\uAE00\uB4F1\uB85D");
			btnboButton.setBounds(125, 532, 86, 30);
			btnboButton.setBackground(new Color(245, 222, 179));
			btnboButton.setFont(new Font("굴림", Font.PLAIN, 11));
			S_boardpanel.add(btnboButton);
			
			btnboButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					notice_panel.setVisible(true);
					textTitle.setVisible(true);
					texNotArea.setVisible(true);
					text_Day.setVisible(true);
					textWriter.setVisible(true);
					TField.setText(textTitle.getText());
					PArea.setText(texNotArea.getText());
					DField.setText(text_Day.getText());
					WField.setText(textWriter.getText());
				}
				
			});
			
			texNotArea = new JTextArea();
			texNotArea.setText("\uB0B4\uC6A9: ");
			texNotArea.setBounds(12, 59, 193, 260);
			notice_panel.add(texNotArea);
			
			textTitle = new JTextField();
			textTitle.setText("\uC81C\uBAA9:  ");
			textTitle.setBounds(12, 10, 193, 39);
			notice_panel.add(textTitle);
			textTitle.setColumns(10);			
			text_Day = new JTextField();
			text_Day.setText("\uC791\uC131\uC77C:");
			text_Day.setBounds(70, 327, 135, 21);
			notice_panel.add(text_Day);
			text_Day.setColumns(10);		
			textWriter = new JTextField();
			textWriter.setText("\uC791\uC131\uC790:");
			textWriter.setColumns(10);
			textWriter.setBounds(70, 348, 135, 21);
			notice_panel.add(textWriter);
			
			tablePanel = new JPanel();
			tablePanel.setBounds(15, 148, 210, 370);
			tablePanel.setBackground(new Color(243, 211, 165));
			S_boardpanel.add(tablePanel);
			tablePanel.setVisible(false);
			tablePanel.add(new JScrollPane(table));	
			
			JButton btnNoButton = new JButton("\uACF5\uC9C0\uAE00\uB4F1\uB85D");
			btnNoButton.setBounds(25, 532, 86, 30);
			btnNoButton.setBackground(new Color(245, 222, 179));
			btnNoButton.setFont(new Font("굴림", Font.PLAIN, 12));
			S_boardpanel.add(btnNoButton);
			
			btn_beforeButton = new JButton("\uC774\uC804 \uD654\uBA74\uAC00\uAE30");
			btn_beforeButton.setBounds(12, 537, 217, 53);
			btn_beforeButton.setForeground(new Color(128, 0, 0));
			btn_beforeButton.setFont(new Font("굴림", Font.BOLD, 24));
			btn_beforeButton.setBorder(null);
			btn_beforeButton.setBackground(new Color(222, 184, 135));
			btnNoButton.add(btn_beforeButton);
			
			btnNoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					notice_panel.setVisible(true);
					textTitle.setVisible(true);
					texNotArea.setVisible(true);
					text_Day.setVisible(true);
					textWriter.setVisible(true);
					TtextField.setText(textTitle.getText());
					postextArea.setText(texNotArea.getText());
					DtextField.setText(text_Day.getText());
					WtextField.setText(textWriter.getText());
				}
				
			});
			
			JButton btn_ListButton_1 = new JButton("\uAE00\uBAA9\uB85D\uBCF4\uAE30");
			btn_ListButton_1.setBounds(12, 85, 217, 53);
			btn_ListButton_1.setForeground(new Color(128, 0, 0));
			btn_ListButton_1.setFont(new Font("굴림", Font.BOLD, 24));
			btn_ListButton_1.setBackground(new Color(222, 184, 135));
			btn_ListButton_1.setBorder(null);
			S_boardpanel.add(btn_ListButton_1);
			btn_ListButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					btn_ListButton_1.setVisible(false);
					Search.setVisible(true);
					tablePanel.setVisible(true);
					table.setVisible(true);
					btnNoButton.setVisible(false);
					btn_beforeButton.setVisible(true);
					notice_panel.setVisible(false);
					
					
					
				}
			});
			
			
			JButton backButton = new JButton("\uB4A4\uB85C\uAC00\uAE30");
			backButton.setBounds(69, 570, 97, 23);
			backButton.setBackground(new Color(245, 222, 179));
			backButton.setFont(new Font("굴림", Font.PLAIN, 12));
			S_boardpanel.add(backButton);
			
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					btn_ManaButton.setVisible(true);
					Admin_panel.setVisible(false);
					btn_beforeButton.setVisible(true);
					btn_exitButton.setVisible(true);
					btnNoButton.setVisible(false);
					btnboButton.setVisible(false);
					backButton.setVisible(false);
					Search.setVisible(false);
					textTitle.setVisible(false);
					texNotArea.setVisible(false);
					text_Day.setVisible(false);
					textWriter.setVisible(false);
					btn_ListButton_1.setVisible(true);
					
					
					
				}
			});
			
			btn_ManaButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btn_ManaButton.setVisible(false);
					Admin_panel.setVisible(true);
					btn_ManaButton.setVisible(false);
					btn_beforeButton.setVisible(false);
					btn_exitButton.setVisible(false);
					btnNoButton.setVisible(false);
					btnboButton.setVisible(false);
					backButton.setVisible(false);
					Search.setVisible(false);
					btn_ListButton_1.setVisible(true);
					
				}
				
			});
			ida = new JTextField();
			ida.setBounds(23, 119, 186, 23);
			ida.setForeground(Color.DARK_GRAY);
			ida.setFont(new Font("굴림", Font.PLAIN, 12));
			ida.setToolTipText("ID");
			Admin_panel.add(ida);
			ida.setColumns(10);
			
			password = new JPasswordField();
			password.setBounds(23, 144, 186, 23);
			password.setForeground(Color.DARK_GRAY);
			password.setToolTipText("password");
			password.setFont(new Font("굴림", Font.PLAIN, 12));
			Admin_panel.add(password);
			
			JButton btnAdIn = new JButton("LOGIN");
			btnAdIn.setBounds(23, 172, 126, 23);
			Admin_panel.add(btnAdIn);
			
			ExitButton = new JButton("EXIT");
			ExitButton.setFont(new Font("굴림", Font.PLAIN, 11));
			ExitButton.setBounds(150, 172, 59, 23);
			Admin_panel.add(ExitButton);
			
			btnAdIn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (ida.getText().equals("jbedu1234")&&Arrays.equals(password.getPassword(),"1234".toCharArray())) {
						System.out.println("환영합니다");
						notice_panel.setVisible(true);
						Admin_panel.setVisible(false);
						btn_beforeButton.setVisible(false);
						btn_exitButton.setVisible(true);
						btnNoButton.setVisible(true);
						btnboButton.setVisible(true);
						backButton.setVisible(true);
						Search.setVisible(false);
						btn_ListButton_1.setVisible(true);
						
					}else {
						JOptionPane.showMessageDialog(null, "로그인에 실패하셨습니다");
					}
					
			}
			});
			
			ExitButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btn_ManaButton.setVisible(true);
					Admin_panel.setVisible(false);
					btn_ManaButton.setVisible(true);
					btn_exitButton.setVisible(true);
					btnNoButton.setVisible(false);
					btnboButton.setVisible(false);
					backButton.setVisible(false);
		
				}
				
			});
	

					
		ImagePanel welcomePanel=new ImagePanel(new ImageIcon("G:/Product/HRM-project/HRM/image/badpark_m.jpg").getImage());
		welcomePanel.setBounds(0, 0, 1134, 852);
		frame.getContentPane().add(welcomePanel);
		
			frame.setSize(welcomePanel.getWidth(),welcomePanel.getHeight());
			welcomePanel.setLayout(null);
			
			id = new JTextField();
			id.setBounds(23, 25, 126, 23);
			id.setForeground(Color.DARK_GRAY);
			id.setFont(new Font("굴림", Font.PLAIN, 12));
			id.setToolTipText("ID");
			welcomePanel.add(id);
			id.setColumns(10);
			
			password = new JPasswordField();
			password.setBounds(23, 58, 126, 23);
			password.setForeground(Color.DARK_GRAY);
			password.setToolTipText("password");
			password.setFont(new Font("굴림", Font.PLAIN, 12));
			welcomePanel.add(password);
			
			JButton btnLogIn = new JButton("LOGIN");
			btnLogIn.setBounds(23, 91, 126, 23);
			welcomePanel.add(btnLogIn);
			btnLogIn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (id.getText().equals("jbedu")&&Arrays.equals(password.getPassword(),"1234".toCharArray())) {
						System.out.println("환영합니다");
						welcomePanel.setVisible(false);
						mainPanel.setVisible(true);
						
						
					}else {
						JOptionPane.showMessageDialog(null, "로그인에 실패하셨습니다");
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
