package panel;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import util.TableEditor;
import util.TableRenderer;


/**
 * @brief 부서조회
 * @author 이현우
 * @version v 1.02 (2020.02.15)
 * @see 테이블 기능 테스트 중
 */
public class DeptLookupPanel extends JPanel{

	//컨테이너
	private JPanel pane_main;
	
	//컴포넌트
	private JTable table_deptList;
	private JTable table_leader;
	private JTable table_empList;
	
	private JLabel lbl_explanation;
	private JTextArea area_explanation;
	
	//테이블 설정
	private DefaultTableModel tbModel_leader;
	private DefaultTableModel tbModel_deptList;
	private DefaultTableModel tbModel_empList;

	private JScrollPane scroll_leader;
	private JScrollPane scroll_dept;
	private JScrollPane scroll_emp;

	private TableColumnModel colModel_leader;	
	private TableColumnModel colModel_dept;	
	private TableColumnModel colModel_emp;	
	
	private DefaultTableCellRenderer defaultRenderer;
	
	
	//생성자
	public DeptLookupPanel() {
		// TODO Auto-generated constructor stub
		
		//패널 초기 설정
		initPanel();
		
		//리더 테이블 설정
		makeLeaderTable();
		
		//부서 테이블 설정
		makeDeptTable();
		
		//사원 테이블 설정
		makeEmpTable();
		
		//부서 설명
		makeDeptExplanation();
	
		add(pane_main);

	}
	
	public void initPanel() {
		
		setLayout(null);

		pane_main = new JPanel();
		pane_main.setBounds(0,0,1280,768);
		pane_main.setLayout(null);
		
	}
	
	public void makeDeptTable() {
		// 테이블 제목 백터
		Vector<Object> colNames = new Vector<>();
		colNames.addElement("부서명");
		
		// 데이터 백터(테스트)
		Vector<Object> row1;
		row1 = new Vector<>();
		row1.addElement(false);
		Vector<Object> row2;
		row2 = new Vector<>();
		row2.addElement(false);
		Vector<Object> row3;
		row3 = new Vector<>();
		row3.addElement(false);
		
		//테이블 모델 설정
		tbModel_deptList = new DefaultTableModel(colNames, 0);
		
		//Row 삽입
		tbModel_deptList.addRow(row1);
		tbModel_deptList.addRow(row2);
		tbModel_deptList.addRow(row3);
		
		//테이블 설정	
		table_deptList = new JTable(tbModel_deptList);
		table_deptList.setFillsViewportHeight(false);
		table_deptList.setRowSelectionAllowed(true);
		table_deptList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// 셀 에디터,렌더러 설정
		colModel_dept = table_deptList.getColumnModel();
		colModel_dept.getColumn(0).setCellEditor(new TableEditor("check"));
		colModel_dept.getColumn(0).setCellRenderer(new TableRenderer("check"));
		
		//테이블 셀 사이즈
		table_deptList.setRowHeight(30);
		colModel_dept.getColumn(0).setPreferredWidth(100);
		
		//스크롤 설정	
		scroll_dept = new JScrollPane(table_deptList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_dept.setBounds(70,50,250,300);
		
		pane_main.add(scroll_dept);

		
	}
	public void makeLeaderTable() {
				
		// 테이블 제목 백터
		Vector<String> colNames = new Vector<>();
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
		tbModel_leader = new DefaultTableModel(colNames,0);
    	
    	// Row 삽입
		tbModel_leader.addRow(row);
		
		// 테이블 설정
		table_leader = new JTable(tbModel_leader);
		table_leader.setFillsViewportHeight(false);
		table_leader.setRowSelectionAllowed(false);
		table_leader.setCellSelectionEnabled(false);
		
		// 테이블 폰트 설정
		table_leader.setFont(new Font("고딕",Font.PLAIN,14));


		// 셀 에디터,렌더러 설정
		defaultRenderer = new DefaultTableCellRenderer();
		defaultRenderer.setHorizontalAlignment(JLabel.CENTER);
		colModel_leader = table_leader.getColumnModel();
		colModel_leader.getColumn(0).setCellRenderer(defaultRenderer);
		colModel_leader.getColumn(1).setCellRenderer(defaultRenderer);
		colModel_leader.getColumn(2).setCellRenderer(defaultRenderer);
		colModel_leader.getColumn(3).setCellEditor(new TableEditor("button"));
		colModel_leader.getColumn(3).setCellRenderer(new TableRenderer("button"));
		
		//테이블 셀 사이즈
		table_leader.setRowHeight(30);
		colModel_leader.getColumn(0).setPreferredWidth(100);
		colModel_leader.getColumn(1).setPreferredWidth(100);
		colModel_leader.getColumn(2).setPreferredWidth(100);
		colModel_leader.getColumn(3).setPreferredWidth(50);
		
		//스크롤 설정
		scroll_leader = new JScrollPane(table_leader,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_leader.setBounds(600,30,600,55);
		
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
		row1.addElement("A");
		row1.addElement(10002);		
		Vector<Object> row2;
		row2 = new Vector<>();
		row2.addElement("사원");
		row2.addElement("김동수");
		row2.addElement("B");
		row2.addElement(10003);	
		Vector<Object> row3;
		row3 = new Vector<>();
		row3.addElement("사원");
		row3.addElement("대나무");
		row3.addElement("C");
		row3.addElement(10005);	
		Vector<Object> row4;
		row4 = new Vector<>();
		row4.addElement("사원");
		row4.addElement("줄리앙");
		row4.addElement("D");
		row4.addElement(10011);
		
		// 테이블 모델 설정
		tbModel_empList = new DefaultTableModel(colNames,0);
    	
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
		table_empList.getTableHeader().setFont(new Font("고딕",Font.BOLD,14));
		table_empList.setFont(new Font("고딕",Font.PLAIN,14));

		// 셀 에디터,렌더러 설정
		colModel_emp = table_empList.getColumnModel();
		colModel_emp.getColumn(0).setCellRenderer(defaultRenderer);
		colModel_emp.getColumn(1).setCellRenderer(defaultRenderer);
		String[] arr = {"A","B","C","D","E"};
		colModel_emp.getColumn(2).setCellEditor(new TableEditor(arr));
		colModel_emp.getColumn(2).setCellRenderer(new TableRenderer(arr));
		colModel_emp.getColumn(3).setCellEditor(new TableEditor("button"));
		colModel_emp.getColumn(3).setCellRenderer(new TableRenderer("button"));

		//테이블 셀 사이즈
		table_empList.setRowHeight(30);
		colModel_emp.getColumn(0).setPreferredWidth(100);
		colModel_emp.getColumn(1).setPreferredWidth(100);
		colModel_emp.getColumn(2).setPreferredWidth(100);
		colModel_emp.getColumn(3).setPreferredWidth(50);

		// 스크롤 설정
		scroll_emp = new JScrollPane(table_empList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_emp.setBounds(600, 150, 600, 400);
		

		pane_main.add(scroll_emp);

	}
	
	public void makeDeptExplanation() {
		
	}
	

	

}
