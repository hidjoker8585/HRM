package panel;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 * @brief 부서조회
 * @author 이현우
 * @version v 1.00 (2020.02.12)
 * @see 
 */
public class DeptLookupPanel extends JPanel{

	
	private JPanel pane_main;
	private JPanel pane_sub_leader;
	
	private JTable table_deptList;
	private JTable table_leader;
	private JTable table_empList;
	
	private JLabel lbl_explanation;
	private JTextArea area_explanation;
	
	private DefaultTableModel tbModel_leader;
	private JScrollPane scroll_leader;
	private TableColumnModel colModel_leader;
	
	private DefaultTableModel tbModel_deptList;
	private JScrollPane scroll_dept;
	private TableColumnModel colModel_dept;	
	
	private DefaultTableModel tbModel_empList;
	private JScrollPane scroll_emp;
	private TableColumnModel colModel_emp;	
	
	public DeptLookupPanel() {
		// TODO Auto-generated constructor stub
		
		//패널 초기 설정
		initPanel();
		
		
	}
	
	public void initPanel() {
		
		setLayout(null);

		pane_main = new JPanel();
		pane_main.setBounds(0,0,1280,768);
		pane_main.setLayout(null);
		
		pane_sub_leader = new JPanel();
		pane_sub_leader.setLayout(null);
		
		//컬럼명 백터
		Vector<Object> colNames_leader = new Vector<>();
		colNames_leader.addElement("직급");
		colNames_leader.addElement("이름");
		colNames_leader.addElement("사번");
		colNames_leader.addElement("상세보기");
		Vector<Object> colNames_dept = new Vector<>();
		colNames_dept.addElement("부서명");

		Vector<Object> colNames_emp = new Vector<>();
		colNames_emp.addElement("직급");
		colNames_emp.addElement("이름");
		colNames_emp.addElement("사번");
		colNames_emp.addElement("상세보기");
		

		
		//테이블 모델 설정
		tbModel_leader = new DefaultTableModel(colNames_leader, 1);		
		tbModel_deptList = new DefaultTableModel(colNames_dept, 5);
		tbModel_empList = new DefaultTableModel(colNames_emp, 8);		


		//더미값 넣기
		Vector<Object> row_leader = new Vector<>();
		row_leader.addElement("팀장");
		row_leader.addElement("홍길동");
		row_leader.addElement("10002");
		row_leader.addElement("상세보기");
		
		tbModel_leader.addRow(row_leader);
		
		//테이블 설정
		table_leader = new JTable(tbModel_leader);
		table_leader.setFillsViewportHeight(false);
		table_leader.setRowSelectionAllowed(false);
		table_leader.setCellSelectionEnabled(true);
		
		table_deptList = new JTable(tbModel_deptList);
		table_deptList.setFillsViewportHeight(false);
		table_deptList.setRowSelectionAllowed(false);
		table_deptList.setCellSelectionEnabled(true);
		
		table_empList = new JTable(tbModel_empList);
		table_empList.setFillsViewportHeight(false);
		table_empList.setRowSelectionAllowed(false);
		table_empList.setCellSelectionEnabled(true);
		
		table_leader.setRowHeight(30);
		colModel_leader = table_leader.getColumnModel();
		colModel_leader.getColumn(0).setPreferredWidth(100);
		colModel_leader.getColumn(1).setPreferredWidth(100);
		colModel_leader.getColumn(2).setPreferredWidth(100);
		colModel_leader.getColumn(3).setPreferredWidth(50);
		
		table_leader.setRowHeight(30);
		colModel_leader = table_leader.getColumnModel();
		colModel_leader.getColumn(0).setPreferredWidth(150);
		
		table_leader.setRowHeight(30);
		colModel_leader = table_leader.getColumnModel();
		colModel_leader.getColumn(0).setPreferredWidth(100);
		colModel_leader.getColumn(1).setPreferredWidth(100);
		colModel_leader.getColumn(2).setPreferredWidth(100);
		colModel_leader.getColumn(3).setPreferredWidth(50);
		
		//스크롤 설정
		scroll_leader = new JScrollPane(table_leader);
		scroll_leader.setBounds(600,30,600,55);
		
		scroll_dept = new JScrollPane(table_deptList);
		scroll_dept.setBounds(50,100,150,300);

		scroll_emp = new JScrollPane(table_empList);
		scroll_emp.setBounds(600,150,600,400);
		
		pane_main.add(scroll_leader);
		pane_main.add(scroll_dept);
		pane_main.add(scroll_emp);

//		pane_main.setLayout(null);

		add(pane_main);
		
	}
}
