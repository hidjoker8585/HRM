package panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import dto.Emp;
import util.TableEditor;
import util.TableModel;
import util.TableRenderer;


/**
 * @brief 사원관리
 * @author LeeSunwha
 * @version v1.00 2020.02.11
 * @see 직급별 화면관리모드
 */
public class EmpLookupPanel extends JPanel{

	
	//설정 상수 값
	private static final int TABLE_HEADER_HEIGHT = 40;
	private static final int TABLE_CELL_HEIGHT = 40;
	
	private static final Color TABLE_HEADER_BACKGROUND = new Color(200, 200, 200);
	private static final Color TABLE_CELL_BACKGROUND = new Color(240, 240, 240);
	
	private static final Font TABLE_HEADER_FONT = new Font("고딕",Font.BOLD,14); 
	private static final Font TABLE_CELL_FONT = new Font("고딕",Font.PLAIN,14);
	
	private static final int TABLE_EMP_X = 380;
	private static final int TABLE_EMP_Y = 50;
	private static final int TABLE_EMP_WIDTH = 800;
	private static final int TABLE_EMP_HEIGHT = 550;
	private static final int TABLE_EMP_COL1_WIDTH = 150;
	private static final int TABLE_EMP_COL2_WIDTH = 150;
	private static final int TABLE_EMP_COL3_WIDTH = 150;
	private static final int TABLE_EMP_COL4_WIDTH = 150;
	private static final int TABLE_EMP_COL5_WIDTH = 100;
	
	//컨테이너
	private JPanel pane_main;
	
	
	//컴포넌트
	private JTable table_empList;
	
	//테이블 설정
	private TableModel tbModel_empList;

	private JScrollPane scroll_emp;

	private TableColumnModel colModel_emp;
	private JTableHeader header_emp;

	private DefaultTableCellRenderer defaultRenderer;


	//DB
	private ArrayList<Emp> empList;
	
	public EmpLookupPanel() {
		// TODO Auto-generated constructor stub
		
		//패널 초기 설정
		initPanel();
		
		//사원 테이블 설정
		makeEmpTable();
		
		//db값 가져오기
		getData();
	}
	
	public void initPanel() {
		
		setLayout(new GridLayout(1,1));

		pane_main = new JPanel();
		pane_main.setLayout(null);
		
		add(pane_main);

		
	}
	
	public void makeEmpTable() {

		// 테이블 제목 백터
		Vector<Object> colNames = new Vector<>();
		colNames.addElement("이름");
		colNames.addElement("사번");
		colNames.addElement("팀장");
		colNames.addElement("입사일");
		colNames.addElement("상세보기");
		
		// 테이블 모델 설정
		//tbModel_empList = new TableModel(colNames,0,2,3);
		tbModel_empList = new TableModel(colNames,0,4);

		// 테이블 설정
		table_empList = new JTable(tbModel_empList);
		table_empList.setFillsViewportHeight(false);
		table_empList.setRowSelectionAllowed(true);
		table_empList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_empList.setBackground(TABLE_CELL_BACKGROUND);
		
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
		colModel_emp.getColumn(3).setCellRenderer(defaultRenderer);
		colModel_emp.getColumn(4).setCellEditor(new TableEditor("button"));
		colModel_emp.getColumn(4).setCellRenderer(new TableRenderer("button"));

		//테이블 셀 사이즈
		table_empList.setRowHeight(TABLE_CELL_HEIGHT);
		colModel_emp.getColumn(0).setPreferredWidth(TABLE_EMP_COL1_WIDTH);
		colModel_emp.getColumn(1).setPreferredWidth(TABLE_EMP_COL2_WIDTH);
		colModel_emp.getColumn(2).setPreferredWidth(TABLE_EMP_COL3_WIDTH);
		colModel_emp.getColumn(3).setPreferredWidth(TABLE_EMP_COL4_WIDTH);
		colModel_emp.getColumn(4).setPreferredWidth(TABLE_EMP_COL5_WIDTH);


		// 스크롤 설정
		scroll_emp = new JScrollPane(table_empList,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_emp.setBounds(TABLE_EMP_X, TABLE_EMP_Y, TABLE_EMP_WIDTH, TABLE_EMP_HEIGHT);
		
		//테이블 헤더 설정
		header_emp.setPreferredSize(new Dimension(TABLE_EMP_WIDTH,TABLE_HEADER_HEIGHT));
		header_emp.setBackground(TABLE_HEADER_BACKGROUND);
		header_emp.setReorderingAllowed(false);
		
		pane_main.add(scroll_emp);

	}
	
	public void getData(){
		empList = new ArrayList<>();
		Emp emp = new Emp();
		emp.setDept("인사팀");		
		emp.setPosition("사원");
		emp.setName("홍길동");
		emp.setEmpNo(10002);
		emp = new Emp();
		emp.setDept("인사팀");		
		emp.setPosition("사원");
		emp.setName("김동수");
		emp.setEmpNo(10003);
		empList.add(emp);
		emp = new Emp();
		emp.setDept("인사팀");		
		emp.setPosition("사원");
		emp.setName("대나무");
		emp.setEmpNo(10005);
		empList.add(emp);
		emp = new Emp();
		emp.setDept("인사팀");		
		emp.setPosition("사원");
		emp.setName("홍길동");
		emp.setEmpNo(10002);
		empList.add(emp);
		emp.setDept("개발1팀");		
		emp.setPosition("사원");
		emp.setName("줄리앙");
		emp.setEmpNo(10011);
		empList.add(emp);
		emp = new Emp();
		emp.setDept("개발1팀");		
		emp.setPosition("팀장");
		emp.setName("박혁");
		emp.setEmpNo(10007);
		empList.add(emp);
		
		for (Emp e : empList) {
			Vector<Object> row = new Vector<>();
			row.addElement(e.getName());
			row.addElement(e.getEmpNo());
			row.addElement(e.getPosition());
			row.addElement(null);
			row.addElement(e.getEmpNo());
			tbModel_empList.addRow(row);
		}
	}
}
