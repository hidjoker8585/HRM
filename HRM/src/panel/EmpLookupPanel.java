package panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import dao.DaoImpl;
import dto.Emp;
import main.MainFrame;
import util.TableEditor;
import util.TableModel;
import util.TableRenderer;


/**
 * @brief 사원관리
 * @author 정 : 이선화, 부 : 이현우
 * @version v1.01 2020.02.24
 * @see db연결 및 이미지연결
 */
public class EmpLookupPanel extends JPanel implements AncestorListener, KeyListener, ActionListener ,
												ListSelectionListener, DocumentListener{

	//설정 상수 값
	private static final int TABLE_HEADER_HEIGHT = 40;
	private static final int TABLE_CELL_HEIGHT = 40;

	private static final Color TABLE_HEADER_BACKGROUND = new Color(200, 200, 200);
	private static final Color TABLE_CELL_BACKGROUND = new Color(240, 240, 240);
	
	private static final Font TABLE_HEADER_FONT = new Font("고딕",Font.BOLD,14); 
	private static final Font TABLE_CELL_FONT = new Font("고딕",Font.PLAIN,14);
	
	private static final int TABLE_EMP_X = 370;
	private static final int TABLE_EMP_Y = 50;
	private static final int TABLE_EMP_WIDTH = 850;
	private static final int TABLE_EMP_HEIGHT = 550;
	private static final int TABLE_EMP_COL1_WIDTH = 150;
	private static final int TABLE_EMP_COL2_WIDTH = 150;
	private static final int TABLE_EMP_COL3_WIDTH = 150;
	private static final int TABLE_EMP_COL4_WIDTH = 150;
	private static final int TABLE_EMP_COL5_WIDTH = 150;
	private static final int TABLE_EMP_COL6_WIDTH = 100;
	
	private static final int PANEL_IMAGE_X = 50;
	private static final int PANEL_IMAGE_Y = 50;
	private static final int PANEL_IMAGE_WIDTH = 300;
	private static final int PANEL_IMAGE_HEIGHT = 400;
	
	private static final int PANEL_SEARCH_X = 50;
	private static final int PANEL_SEARCH_Y = 470;
	private static final int PANEL_SEARCH_WIDTH = 300;
	private static final int PANEL_SEARCH_HEIGHT = 130;
	
	
	//컨테이너
	private JFrame frame;
	private JPanel pane_main;
	private JPanel pane_sub_image;
	private JPanel pane_sub_search;

	//컴포넌트
	private JTable table_empList;
	private JLabel lbl_image;
	private JLabel lbl_search;
	private JComboBox<String> combo_search;
	private JTextField txt_search; 
	
	//테이블 설정
	private TableModel tbModel_empList;
	private JScrollPane scroll_emp;
	private TableColumnModel colModel_emp;
	private JTableHeader header_emp;
	private TableRowSorter<TableModel> sorter;

	private DefaultTableCellRenderer defaultRenderer;

	//DB
	private DaoImpl dao;
	private ArrayList<Emp> empList;
	
	//이미지
	private File basicFile;
	private BufferedImage bfImg;
	private Image image;
	private ImageIcon iIcon;
	
	//검색
	private int searchType;
	
	
	public EmpLookupPanel(JFrame f) {
		// TODO Auto-generated constructor stub
		
		frame = f;
		dao = MainFrame.getDao();		
		
		//패널 초기 설정
		initPanel();
		
		//사원 테이블 설정
		makeEmpTable();
		
		//이미지 패널 설정
		makeImagePanel();
		
		//검색 패널 설정
		makeSearchPanel();
		
		add(pane_main);

		
	}
	
	public void initPanel() {
		
		setLayout(new GridLayout(1,1));

		pane_main = new JPanel();
		pane_main.setLayout(null);
		addAncestorListener(this);
		
	}
	
	public void makeEmpTable() {

		// 테이블 제목 백터
		Vector<Object> colNames = new Vector<>();
		colNames.addElement("이름");
		colNames.addElement("사번");
		colNames.addElement("부서");
		colNames.addElement("팀장");
		colNames.addElement("입사일");
		colNames.addElement("상세보기");
		
		// 테이블 모델 설정
		//tbModel_empList = new TableModel(colNames,0,2,3);
		tbModel_empList = new TableModel(colNames,0,5,"EmpLookup");

		// 테이블 설정
		table_empList = new JTable(tbModel_empList);
		table_empList.setFillsViewportHeight(false);
		table_empList.setRowSelectionAllowed(true);
		table_empList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_empList.setBackground(TABLE_CELL_BACKGROUND);
		sorter = new TableRowSorter<TableModel>(tbModel_empList);
	    table_empList.setRowSorter(sorter);
		
		// 셀 폰트 설정
		header_emp = table_empList.getTableHeader();
		header_emp.setFont(TABLE_HEADER_FONT);
		table_empList.setFont(TABLE_CELL_FONT);

		// 셀 에디터,렌더러 설정
		defaultRenderer = new DefaultTableCellRenderer();
		defaultRenderer.setHorizontalAlignment(JLabel.CENTER);
		colModel_emp = table_empList.getColumnModel();
		colModel_emp.getColumn(0).setCellRenderer(defaultRenderer);
		colModel_emp.getColumn(1).setCellRenderer(defaultRenderer);
		colModel_emp.getColumn(2).setCellRenderer(defaultRenderer);
		colModel_emp.getColumn(3).setCellRenderer(defaultRenderer);
		colModel_emp.getColumn(4).setCellRenderer(defaultRenderer);
		colModel_emp.getColumn(5).setCellEditor(new TableEditor("button",frame));
		colModel_emp.getColumn(5).setCellRenderer(new TableRenderer("button"));

		//테이블 셀 사이즈
		table_empList.setRowHeight(TABLE_CELL_HEIGHT);
		colModel_emp.getColumn(0).setPreferredWidth(TABLE_EMP_COL1_WIDTH);
		colModel_emp.getColumn(1).setPreferredWidth(TABLE_EMP_COL2_WIDTH);
		colModel_emp.getColumn(2).setPreferredWidth(TABLE_EMP_COL3_WIDTH);
		colModel_emp.getColumn(3).setPreferredWidth(TABLE_EMP_COL4_WIDTH);
		colModel_emp.getColumn(4).setPreferredWidth(TABLE_EMP_COL5_WIDTH);
		colModel_emp.getColumn(5).setPreferredWidth(TABLE_EMP_COL6_WIDTH);


		// 스크롤 설정
		scroll_emp = new JScrollPane(table_empList,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_emp.setBounds(TABLE_EMP_X, TABLE_EMP_Y, TABLE_EMP_WIDTH, TABLE_EMP_HEIGHT);
		
		//테이블 헤더 설정
		header_emp.setPreferredSize(new Dimension(TABLE_EMP_WIDTH,TABLE_HEADER_HEIGHT));
		header_emp.setBackground(TABLE_HEADER_BACKGROUND);
		header_emp.setReorderingAllowed(false);
		
		pane_main.add(scroll_emp);
	}
	
	public void makeImagePanel() {
		
		pane_sub_image = new JPanel();
		pane_sub_image.setLayout(null);
		pane_sub_image.setBounds(PANEL_IMAGE_X,PANEL_IMAGE_Y,PANEL_IMAGE_WIDTH,PANEL_IMAGE_HEIGHT);
		pane_sub_image.setBorder(new EtchedBorder());
		
		lbl_image = new JLabel();
		lbl_image.setBounds(10,10,280,350);
		lbl_image.setBorder(new BevelBorder(BevelBorder.RAISED));
		basicFile = new File("./src/resource","image.jpg");
		try {
			bfImg = ImageIO.read(basicFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		image = bfImg.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
		iIcon = new ImageIcon(image);
		lbl_image.setIcon(iIcon);
		
		pane_sub_image.add(lbl_image);
		pane_main.add(pane_sub_image);
	}
	
	public void makeSearchPanel() {
		
		pane_sub_search = new JPanel();
		pane_sub_search.setLayout(null);
		pane_sub_search.setBounds(PANEL_SEARCH_X,PANEL_SEARCH_Y,PANEL_SEARCH_WIDTH,PANEL_SEARCH_HEIGHT);
		pane_sub_search.setBorder(new EtchedBorder());
		
		lbl_search = new JLabel("검색");
		lbl_search.setBounds(10,15,60,40);
		lbl_search.setHorizontalAlignment(JLabel.CENTER);
		lbl_search.setFont(TABLE_HEADER_FONT);
		
		String[] arr = {"사원명","사원번호","부서명","팀장명"};
		combo_search = new JComboBox<>(arr);
		combo_search.setBounds(110,15,160,40);
		combo_search.setFont(TABLE_CELL_FONT);
		combo_search.setEditable(false);
		combo_search.addActionListener(this);
		
		txt_search = new JTextField();
		txt_search.setBounds(20,75,250,40);
		txt_search.setFont(TABLE_CELL_FONT);
		txt_search.addKeyListener(this);
		txt_search.getDocument().addDocumentListener(this);
		
		pane_sub_search.add(lbl_search);
		pane_sub_search.add(combo_search);
		pane_sub_search.add(txt_search);

		pane_main.add(pane_sub_search);
		
	}

	@Override
	public void ancestorAdded(AncestorEvent event) {
		// TODO Auto-generated method stub
		//db값 가져오기
		getData();
		//테이블 컬렉션 설정
		table_empList.getSelectionModel().addListSelectionListener(this);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			int num = combo_search.getSelectedIndex();
			combo_search.setSelectedIndex(num>0?num-1:0);
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			int num = combo_search.getSelectedIndex();
			combo_search.setSelectedIndex(num<3?num+1:3);
		}
	}
	@Override
	public void ancestorMoved(AncestorEvent event) {}
	@Override
	public void ancestorRemoved(AncestorEvent event) {
		//사원테이블 초기화
		table_empList.getSelectionModel().removeListSelectionListener(this);		
		for (int i = tbModel_empList.getRowCount() - 1; i > -1; i--) {
			tbModel_empList.removeRow(i);
		}
		
		//컬렉션 초기화
		empList.clear();
		
		//검색 초기화
		txt_search.setText("");
		combo_search.setSelectedIndex(0);
		searchType = 0;
		
	}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	
	public void getData(){
		//사원 리스트 얻기
		empList = dao.getEmpList();
		
		//사원테이블에 데이터 채우기
		for (Emp emp : empList) {
			Vector<Object> row = new Vector<>();
			row.addElement(emp.getName());
			row.addElement(emp.getEmpNo());
			row.addElement(emp.getDept());
			row.addElement(emp.getLeader());
			row.addElement(emp.getHireDate());
			row.addElement(emp.getEmpNo());
			tbModel_empList.addRow(row);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		printImage();		
	}

	public void printImage() {
		int row = table_empList.getSelectedRow();
		if(row>-1) {
			row = table_empList.convertRowIndexToModel(row);
			String fileName = String.valueOf(tbModel_empList.getValueAt(row, 1)) + ".jpg";
			File file = new File("./src/resource",fileName);
			if(file.exists()) {
				try {
					bfImg = ImageIO.read(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				image =bfImg.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
				iIcon = new ImageIcon(image);
				lbl_image.setIcon(iIcon);
				return;

			}	
		}
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

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		filter();
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		filter();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		filter();
	}
	
	public void filter() {
		RowFilter<TableModel, Object> rf= null;
		try {
			rf = RowFilter.regexFilter(txt_search.getText().trim(), searchType);
		} catch (Exception e) {
			// TODO: handle exception
			return;
		}
		sorter.setRowFilter(rf);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==combo_search) {
			searchType = combo_search.getSelectedIndex();
		}
	}
}
