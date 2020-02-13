package panel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


/**
 * @brief 부서조회
 * @author 이현우
 * @version v 1.00 (2020.02.12)
 * @see 
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
	
//		pane_main.setLayout(null);

		
	}
	
	public void makeDeptTable() {
		//컬럼명 백터
		Vector<Object> colNames = new Vector<>();
		colNames.addElement("부서명");
		
		// 로우값 넣기(테스트 데이터)
		Vector<String> row1;
		row1 = new Vector<>();
		row1.addElement("인사팀");
		Vector<String> row2;
		row2 = new Vector<>();
		row2.addElement("개발팀");
		Vector<String> row3;
		row3 = new Vector<>();
		row3.addElement("영업팀");
		
		//테이블 모델 설정
		tbModel_deptList = new DefaultTableModel(colNames, 0);
		tbModel_deptList.addRow(row1);
		tbModel_deptList.addRow(row2);
		tbModel_deptList.addRow(row3);
		
		//테이블 설정	
		table_deptList = new JTable(tbModel_deptList);
		table_deptList.setFillsViewportHeight(false);
		table_deptList.setRowSelectionAllowed(false);
		table_deptList.setCellSelectionEnabled(true);
		
		table_deptList.setRowHeight(30);
		colModel_dept = table_deptList.getColumnModel();
		colModel_dept.getColumn(0).setPreferredWidth(100);
		
		//스크롤 설정	
		scroll_dept = new JScrollPane(table_deptList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_dept.setBounds(70,50,250,300);
		
		pane_main.add(scroll_dept);

		
	}
	public void makeLeaderTable() {
				
		// 컬럼명 백터
		Vector<String> colNames = new Vector<>();
		colNames.addElement("직급");
		colNames.addElement("이름");
		colNames.addElement("사번");
		colNames.addElement("상세보기");
		
		// 로우값 넣기(테스트 데이터)
		Vector<String> row;
		row = new Vector<>();
		row.addElement("팀장");
		row.addElement("김영희");
		row.addElement("10004");
		row.addElement("보기");
		
		// 테이블 모델 설정
		tbModel_leader = new DefaultTableModel(colNames,0);
		tbModel_leader.addRow(row);
		
		// 테이블 설정
		table_leader = new JTable(tbModel_leader);
		table_leader.setFillsViewportHeight(false);
		table_leader.setRowSelectionAllowed(false);
		table_leader.setCellSelectionEnabled(false);
		
		// 셀 에디터 설정
		table_leader.getColumn("상세보기").setCellEditor(new ButtonEditor(new JCheckBox()));
		table_leader.getColumn("상세보기").setCellRenderer(new ButtonRenderer());
		
		// 셀 사이즈 설정
		table_leader.setRowHeight(30);
		colModel_leader = table_leader.getColumnModel();
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

		// 컬럼명 백터
		Vector<Object> colNames = new Vector<>();
		colNames.addElement("직급");
		colNames.addElement("이름");
		colNames.addElement("사번");
		colNames.addElement("상세보기");
		
		// 로우값 넣기(테스트 데이터)
		Vector<Object> row1;
		row1 = new Vector<>();
		row1.addElement("사원");
		row1.addElement("홍길동");
		row1.addElement("10002");
		row1.addElement("보기");		
		Vector<Object> row2;
		row2 = new Vector<>();
		row2.addElement("사원");
		row2.addElement("김동수");
		row2.addElement("10003");
		row2.addElement("보기");	
		Vector<Object> row3;
		row3 = new Vector<>();
		row3.addElement("사원");
		row3.addElement("대나무");
		row3.addElement("10005");
		row3.addElement("보기");	
		Vector<Object> row4;
		row4 = new Vector<>();
		row4.addElement("사원");
		row4.addElement("줄리앙");
		row4.addElement("10011");
		row4.addElement("보기");
		
		// 테이블 모델 설정
		tbModel_empList = new DefaultTableModel(colNames,0);
		tbModel_empList.addRow(row1);
		tbModel_empList.addRow(row2);
		tbModel_empList.addRow(row3);
		tbModel_empList.addRow(row4);
		
		// 테이블 설정
		table_empList = new JTable(tbModel_empList);
		table_empList.setFillsViewportHeight(false);
		table_empList.setRowSelectionAllowed(true);
		
		// 셀 에디터 설정
		table_empList.getColumn("상세보기").setCellEditor(new ButtonEditor(new JCheckBox()));
		table_empList.getColumn("상세보기").setCellRenderer(new ButtonRenderer());

		table_empList.setRowHeight(30);
		colModel_emp = table_empList.getColumnModel();
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
	
	private class ButtonEditor extends DefaultCellEditor {

		private JButton btn;
		private String label;
		private boolean isPushed;
		
		public ButtonEditor(JCheckBox checkBox) {
			// TODO Auto-generated constructor stub
			super(checkBox);
			btn = new JButton();
			btn.setOpaque(true);
			btn.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					fireEditingStopped();
				}
			});
		}
		

		
		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			if(isPushed) {
				JOptionPane.showMessageDialog(btn,"버튼 눌림!");
			}
			isPushed = false;
			return label;
		}


		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			// TODO Auto-generated method stub
			if(isSelected) {
				btn.setForeground(table.getSelectionForeground());
				btn.setBackground(table.getSelectionBackground());
			}else {
				btn.setForeground(table.getForeground());
				btn.setBackground(table.getBackground());
			}
			if(value==null||value.equals("")) {
				return null;
			}else {
				label = value.toString();
				btn.setText(label);
				isPushed = true;
				return btn;
			}
		}

	}
	
	private class ButtonRenderer extends JButton implements TableCellRenderer{
		
		public ButtonRenderer() {
			// TODO Auto-generated constructor stub
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub
			if(isSelected) {
				setForeground(table.getSelectionForeground());
				setBackground(table.getSelectionBackground());
			}else {
				setForeground(table.getForeground());
				setBackground(UIManager.getColor("Button.background"));
			}
			if(value==null||value.equals("")) {
				return null;
			}else {
				setText(value.toString());
				return this;
			}
		}


	}
}
