package panel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
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
	
	private JTable table_deptList;
	private JTable table_leader;
	private JTable table_empList;
	
	private JLabel lbl_explanation;
	private JTextArea area_explanation;
	
	private JScrollPane scroll_leader;
	private TableColumnModel colModel_leader;
	
	
	public DeptLookupPanel() {
		// TODO Auto-generated constructor stub
		
		//패널 초기 설정
		initPanel();
		
		
	}
	
	public void initPanel() {
		
		pane_main = new JPanel();
		
		String[] leader_colNames = {"직급","이름","사번","상세보기"};
		Object[][] leader_data = {{"팀장","홍길동",new Integer(10001),null} };
		
		table_leader = new JTable(leader_data,leader_colNames);
		table_leader.setFillsViewportHeight(true);
		table_leader.setRowSelectionAllowed(false);
		table_leader.setCellSelectionEnabled(true);
		colModel_leader = table_leader.getColumnModel();
		colModel_leader.getColumn(0).setPreferredWidth(100);
		colModel_leader.getColumn(1).setPreferredWidth(100);
		colModel_leader.getColumn(2).setPreferredWidth(100);
		colModel_leader.getColumn(3).setPreferredWidth(50);
		scroll_leader = new JScrollPane(table_leader);
		

		pane_main.add(scroll_leader);
		add(pane_main);
		
	}
}
