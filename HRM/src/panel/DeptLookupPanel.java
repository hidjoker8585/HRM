package panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import util.TableEditor;
import util.TableModel;
import util.TableRenderer;


/**
 * @brief 부서조회
 * @author 이현우
 * @version v 1.03 (2020.02.16)
 * @see DB연결 남음..
 * 
 */
public class DeptLookupPanel extends JPanel{

	//설정 상수 값
	private static final int TABLE_HEADER_HEIGHT = 40;
	private static final Color TABLE_HEADER_BACKGROUND = new Color(200, 200, 200);
	private static final Font TABLE_HEADER_FONT = new Font("고딕",Font.BOLD,14); 

	private static final int TABLE_CELL_HEIGHT = 40;
	private static final Font TABLE_CELL_FONT = new Font("고딕",Font.PLAIN,14);
	
	private static final Color AREA_INTRODUCTION_BACKGROUND = new Color(220, 220, 220);
	private static final Font LBL_INTRODUCTION_FONT = new Font("고딕",Font.BOLD,18);
	private static final Font AREA_INTRODUCTION_FONT = new Font("고딕",Font.PLAIN,14);
	
	private static final int TABLE_DEPT_X= 80;
	private static final int TABLE_DEPT_Y = 40;
	private static final int TABLE_DEPT_WIDTH= 300;
	private static final int TABLE_DEPT_HEIGHT= 300;
	
	private static final int TABLE_LEADER_X = 480;
	private static final int TABLE_LEADER_Y = 40;
	private static final int TABLE_LEADER_WIDTH = 700;
	private static final int TABLE_LEADER_HEIGHT = 80;
	private static final int TABLE_LEADER_COL1_WIDTH = 200;
	private static final int TABLE_LEADER_COL2_WIDTH = 200;
	private static final int TABLE_LEADER_COL3_WIDTH = 200;
	private static final int TABLE_LEADER_COL4_WIDHT = 100;
	
	private static final int TABLE_EMP_X = 480;
	private static final int TABLE_EMP_Y = 160;
	private static final int TABLE_EMP_WIDTH = 700;
	private static final int TABLE_EMP_HEIGHT = 450;
	private static final int TABLE_EMP_COL1_WIDTH = 200;
	private static final int TABLE_EMP_COL2_WIDTH = 200;
	private static final int TABLE_EMP_COL3_WIDTH = 200;
	private static final int TABLE_EMP_COL4_WIDTH = 100;
	
	private static final int PANEL_INTRODUCTION_X = 80;
	private static final int PANEL_INTRODUCTION_Y = 360;
	private static final int PANEL_INTRODUCTION_WIDTH = 300;
	private static final int PANEL_INTRODUCTION_HEIGHT = 260;
	
	//컨테이너
	private JPanel pane_main;
	private JPanel pane_sub_intro;
	
	//컴포넌트
	private JTable table_deptList;
	private JTable table_leader;
	private JTable table_empList;
	
	private JLabel lbl_intro;
	private JTextArea area_intro;
	
	//테이블 설정
	private TableModel tbModel_leader;
	private TableModel tbModel_deptList;
	private TableModel tbModel_empList;

	private JScrollPane scroll_leader;
	private JScrollPane scroll_dept;
	private JScrollPane scroll_emp;

	private TableColumnModel colModel_leader;	
	private TableColumnModel colModel_dept;	
	private TableColumnModel colModel_emp;
	
	private JTableHeader header_dept;
	private JTableHeader header_leader;
	private JTableHeader header_emp;
	
	
	private DefaultTableCellRenderer defaultRenderer;
	
	
	//생성자
	public DeptLookupPanel() {
		// TODO Auto-generated constructor stub
		
		//패널 초기 설정
		initPanel();
		
		//부서 테이블 설정
		makeDeptTable();
		
		//리더 테이블 설정
		makeLeaderTable();
		
		//사원 테이블 설정
		makeEmpTable();
		
		//부서 설명
		makeDeptIntroduction();
	
		add(pane_main);

	}
	
	public void initPanel() {
		
		setLayout(new GridLayout(1,1));

		pane_main = new JPanel();
		pane_main.setLayout(null);
		
	}
	
	public void makeDeptTable() {
		// 테이블 제목 백터
		Vector<Object> colNames = new Vector<>();
		colNames.addElement("부서명");
		
		// 데이터 백터(테스트)
		Vector<Object> row1;
		row1 = new Vector<>();
		row1.addElement("인사팀");
		Vector<Object> row2;
		row2 = new Vector<>();
		row2.addElement("개발1팀");
		Vector<Object> row3;
		row3 = new Vector<>();
		row3.addElement("개발2팀");
		Vector<Object> row4;
		row4 = new Vector<>();
		row4.addElement("총무팀");
		Vector<Object> row5;
		row5 = new Vector<>();
		row5.addElement("홍보팀");
		Vector<Object> row6;
		row6 = new Vector<>();
		row6.addElement("재무팀");
		
		//테이블 모델 설정
		//tbModel_deptList = new TableModel(colNames, 0,0);
		tbModel_deptList = new TableModel(colNames, 0);
		
		//Row 삽입
		tbModel_deptList.addRow(row1);
		tbModel_deptList.addRow(row2);
		tbModel_deptList.addRow(row3);
		tbModel_deptList.addRow(row4);
		tbModel_deptList.addRow(row5);
		tbModel_deptList.addRow(row6);

		//테이블 설정	
		table_deptList = new JTable(tbModel_deptList);
		table_deptList.setFillsViewportHeight(false);
		table_deptList.setRowSelectionAllowed(true);
		table_deptList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// 셀 에디터,렌더러 설정
		defaultRenderer = new DefaultTableCellRenderer();
		colModel_dept = table_deptList.getColumnModel();
		//colModel_dept.getColumn(0).setCellEditor(new TableEditor("check"));
		//colModel_dept.getColumn(0).setCellRenderer(new TableRenderer("check"));
		colModel_dept.getColumn(0).setCellRenderer(defaultRenderer);

		//테이블 셀 사이즈
		table_deptList.setRowHeight(TABLE_CELL_HEIGHT);
		colModel_dept.getColumn(0).setPreferredWidth(TABLE_DEPT_WIDTH);
		
		//스크롤 설정	
		scroll_dept = new JScrollPane(table_deptList,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_dept.setBounds(TABLE_DEPT_X,TABLE_DEPT_Y,TABLE_DEPT_WIDTH,TABLE_DEPT_HEIGHT);
		
		//테이블 헤더 설정
		header_dept = table_deptList.getTableHeader();
		header_dept.setPreferredSize(new Dimension(TABLE_DEPT_WIDTH,TABLE_HEADER_HEIGHT));
		header_dept.setBackground(TABLE_HEADER_BACKGROUND);
		header_dept.setReorderingAllowed(false);
		
		// 테이블 폰트 설정
		table_deptList.getTableHeader().setFont(TABLE_HEADER_FONT);
		table_deptList.setFont(TABLE_CELL_FONT);
		
		
		pane_main.add(scroll_dept);

		
	}
	public void makeLeaderTable() {
				
		// 테이블 제목 백터
		Vector<Object> colNames = new Vector<>();
		colNames.addElement("직급");
		colNames.addElement("이름");
		colNames.addElement("사번");
		colNames.addElement("상세보기");
		
		// 데이터 백터(테스트)
		Vector<Object> row;
		row = new Vector<>();
		row.addElement("팀장");
		row.addElement("김영희");
		row.addElement("10004");
		row.addElement(10004);
		
		// 테이블 모델 설정
		tbModel_leader = new TableModel(colNames,0,3);
    	
    	// Row 삽입
		tbModel_leader.addRow(row);
		
		// 테이블 설정
		table_leader = new JTable(tbModel_leader);
		table_leader.setFillsViewportHeight(false);
		table_leader.setRowSelectionAllowed(false);
		table_leader.setCellSelectionEnabled(false);
		
		// 테이블 폰트 설정
		header_leader = table_leader.getTableHeader();
		header_leader.setFont(TABLE_HEADER_FONT);
		table_leader.setFont(TABLE_CELL_FONT);

		// 셀 에디터,렌더러 설정
		defaultRenderer.setHorizontalAlignment(JLabel.CENTER);
		colModel_leader = table_leader.getColumnModel();
		colModel_leader.getColumn(0).setCellRenderer(defaultRenderer);
		colModel_leader.getColumn(1).setCellRenderer(defaultRenderer);
		colModel_leader.getColumn(2).setCellRenderer(defaultRenderer);
		colModel_leader.getColumn(3).setCellEditor(new TableEditor("button"));
		colModel_leader.getColumn(3).setCellRenderer(new TableRenderer("button"));
			
		//테이블 셀 사이즈
		table_leader.setRowHeight(TABLE_CELL_HEIGHT);
		colModel_leader.getColumn(0).setPreferredWidth(TABLE_LEADER_COL1_WIDTH);
		colModel_leader.getColumn(1).setPreferredWidth(TABLE_LEADER_COL2_WIDTH);
		colModel_leader.getColumn(2).setPreferredWidth(TABLE_LEADER_COL3_WIDTH);
		colModel_leader.getColumn(3).setPreferredWidth(TABLE_LEADER_COL4_WIDHT);
		
		//스크롤 설정
		scroll_leader = new JScrollPane(table_leader,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_leader.setBounds(TABLE_LEADER_X,TABLE_LEADER_Y,TABLE_LEADER_WIDTH,TABLE_LEADER_HEIGHT);
		
		//테이블 헤더 설정
		header_leader.setPreferredSize(new Dimension(TABLE_LEADER_WIDTH,TABLE_HEADER_HEIGHT));
		header_leader.setBackground(TABLE_HEADER_BACKGROUND);
		header_leader.setReorderingAllowed(false);
		
		pane_main.add(scroll_leader);
		
	}

	public void makeEmpTable() {

		// 테이블 제목 백터
		Vector<Object> colNames = new Vector<>();
		colNames.addElement("직급");
		colNames.addElement("이름");
		colNames.addElement("사번");
		colNames.addElement("상세보기");
		
		// 데이터 백터(테스트)
		Vector<Object> row1;
		row1 = new Vector<>();
		row1.addElement("사원");
		row1.addElement("홍길동");
		row1.addElement("10002");
		row1.addElement(10002);		
		Vector<Object> row2;
		row2 = new Vector<>();
		row2.addElement("사원");
		row2.addElement("김동수");
		row2.addElement("10003");
		row2.addElement(10003);	
		Vector<Object> row3;
		row3 = new Vector<>();
		row3.addElement("사원");
		row3.addElement("대나무");
		row3.addElement("10005");
		row3.addElement(10005);	
		Vector<Object> row4;
		row4 = new Vector<>();
		row4.addElement("사원");
		row4.addElement("줄리앙");
		row4.addElement("10011");
		row4.addElement(10011);
		
		// 테이블 모델 설정
		//tbModel_empList = new TableModel(colNames,0,2,3);
		tbModel_empList = new TableModel(colNames,0,3);

    	//Row 삽입
		tbModel_empList.addRow(row1);
		tbModel_empList.addRow(row2);
		tbModel_empList.addRow(row3);
		tbModel_empList.addRow(row4);
		
		// 테이블 설정
		table_empList = new JTable(tbModel_empList);
		table_empList.setFillsViewportHeight(false);
		table_empList.setRowSelectionAllowed(true);
		table_empList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// 셀 폰트 설정
		header_emp = table_empList.getTableHeader();
		header_emp.setFont(TABLE_HEADER_FONT);
		table_empList.setFont(TABLE_CELL_FONT);

		// 셀 에디터,렌더러 설정
		colModel_emp = table_empList.getColumnModel();
		colModel_emp.getColumn(0).setCellRenderer(defaultRenderer);
		colModel_emp.getColumn(1).setCellRenderer(defaultRenderer);
		//String[] arr = {"A","B","C","D","E"};
		//colModel_emp.getColumn(2).setCellEditor(new TableEditor(arr));
		//colModel_emp.getColumn(2).setCellRenderer(new TableRenderer(arr));
		colModel_emp.getColumn(2).setCellRenderer(defaultRenderer);
		colModel_emp.getColumn(3).setCellEditor(new TableEditor("button"));
		colModel_emp.getColumn(3).setCellRenderer(new TableRenderer("button"));

		//테이블 셀 사이즈
		table_empList.setRowHeight(TABLE_CELL_HEIGHT);
		colModel_emp.getColumn(0).setPreferredWidth(TABLE_EMP_COL1_WIDTH);
		colModel_emp.getColumn(1).setPreferredWidth(TABLE_EMP_COL2_WIDTH);
		colModel_emp.getColumn(2).setPreferredWidth(TABLE_EMP_COL3_WIDTH);
		colModel_emp.getColumn(3).setPreferredWidth(TABLE_EMP_COL4_WIDTH);

		// 스크롤 설정
		scroll_emp = new JScrollPane(table_empList,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_emp.setBounds(TABLE_EMP_X, TABLE_EMP_Y, TABLE_EMP_WIDTH, TABLE_EMP_HEIGHT);
		
		//테이블 헤더 설정
		header_emp.setPreferredSize(new Dimension(TABLE_EMP_WIDTH,TABLE_HEADER_HEIGHT));
		header_emp.setBackground(TABLE_HEADER_BACKGROUND);
		header_emp.setReorderingAllowed(false);
		
		pane_main.add(scroll_emp);

	}
	
	public void makeDeptIntroduction() {
		
		//패널 설정
		pane_sub_intro = new JPanel();
		pane_sub_intro.setLayout(null);
		pane_sub_intro.setBounds(PANEL_INTRODUCTION_X,PANEL_INTRODUCTION_Y,PANEL_INTRODUCTION_WIDTH,PANEL_INTRODUCTION_HEIGHT);
		pane_sub_intro.setBorder(new EtchedBorder());
		
		//레이블 설정
		lbl_intro = new JLabel("[부서소개]");
		lbl_intro.setBounds(10, 10, 100, 30);
		lbl_intro.setFont(LBL_INTRODUCTION_FONT);
		
		//텍스트 에어리어 설정
		area_intro = new JTextArea(5, 15);
		area_intro.setEditable(false);
		area_intro.setBounds(20,50,260,190);
	    area_intro.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    area_intro.setBackground(AREA_INTRODUCTION_BACKGROUND);
	    area_intro.setLineWrap(true);
	    area_intro.setFont(AREA_INTRODUCTION_FONT);
	    
	    //부서소개 텍스트(테스트 값)
	    String intro = "\n    인사팀은 직원을 선발하고 배치하며 \n"
	    		+ "    직원 역량을 개발하고 평가하는 등  \n"
	    		+ "    인적자원 관리를 주 업무로 하고 있습 \n"
	    		+ "    니다\n\n"
	    		+ "    위치 : 본사 3F \n"
	    		+ "    연락처 : xx-xxxx-xxxx";
		area_intro.setText(intro);
	    
	    pane_sub_intro.add(lbl_intro);
		pane_sub_intro.add(area_intro);
		
		pane_main.add(pane_sub_intro);
		
	}
	

	

}
