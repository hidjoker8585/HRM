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
 * @brief �μ���ȸ
 * @author ������
 * @version v 1.00 (2020.02.12)
 * @see 
 */
public class DeptLookupPanel extends JPanel{

	//�����̳�
	private JPanel pane_main;
	
	//������Ʈ
	private JTable table_deptList;
	private JTable table_leader;
	private JTable table_empList;
	
	private JLabel lbl_explanation;
	private JTextArea area_explanation;
	
	//���̺� ����
	private DefaultTableModel tbModel_leader;
	private DefaultTableModel tbModel_deptList;
	private DefaultTableModel tbModel_empList;

	private JScrollPane scroll_leader;
	private JScrollPane scroll_dept;
	private JScrollPane scroll_emp;

	private TableColumnModel colModel_leader;	
	private TableColumnModel colModel_dept;	
	private TableColumnModel colModel_emp;	
	
	//������
	public DeptLookupPanel() {
		// TODO Auto-generated constructor stub
		
		//�г� �ʱ� ����
		initPanel();
		
		//���� ���̺� ����
		makeLeaderTable();
		
		//�μ� ���̺� ����
		makeDeptTable();
		
		//��� ���̺� ����
		makeEmpTable();
		
		//�μ� ����
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
		//�÷��� ����
		Vector<Object> colNames = new Vector<>();
		colNames.addElement("�μ���");
		
		// �ο찪 �ֱ�(�׽�Ʈ ������)
		Vector<String> row1;
		row1 = new Vector<>();
		row1.addElement("�λ���");
		Vector<String> row2;
		row2 = new Vector<>();
		row2.addElement("������");
		Vector<String> row3;
		row3 = new Vector<>();
		row3.addElement("������");
		
		//���̺� �� ����
		tbModel_deptList = new DefaultTableModel(colNames, 0);
		tbModel_deptList.addRow(row1);
		tbModel_deptList.addRow(row2);
		tbModel_deptList.addRow(row3);
		
		//���̺� ����	
		table_deptList = new JTable(tbModel_deptList);
		table_deptList.setFillsViewportHeight(false);
		table_deptList.setRowSelectionAllowed(false);
		table_deptList.setCellSelectionEnabled(true);
		
		table_deptList.setRowHeight(30);
		colModel_dept = table_deptList.getColumnModel();
		colModel_dept.getColumn(0).setPreferredWidth(100);
		
		//��ũ�� ����	
		scroll_dept = new JScrollPane(table_deptList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_dept.setBounds(70,50,250,300);
		
		pane_main.add(scroll_dept);

		
	}
	public void makeLeaderTable() {
				
		// �÷��� ����
		Vector<String> colNames = new Vector<>();
		colNames.addElement("����");
		colNames.addElement("�̸�");
		colNames.addElement("���");
		colNames.addElement("�󼼺���");
		
		// �ο찪 �ֱ�(�׽�Ʈ ������)
		Vector<String> row;
		row = new Vector<>();
		row.addElement("����");
		row.addElement("�迵��");
		row.addElement("10004");
		row.addElement("����");
		
		// ���̺� �� ����
		tbModel_leader = new DefaultTableModel(colNames,0);
		tbModel_leader.addRow(row);
		
		// ���̺� ����
		table_leader = new JTable(tbModel_leader);
		table_leader.setFillsViewportHeight(false);
		table_leader.setRowSelectionAllowed(false);
		table_leader.setCellSelectionEnabled(false);
		
		// �� ������ ����
		table_leader.getColumn("�󼼺���").setCellEditor(new ButtonEditor(new JCheckBox()));
		table_leader.getColumn("�󼼺���").setCellRenderer(new ButtonRenderer());
		
		// �� ������ ����
		table_leader.setRowHeight(30);
		colModel_leader = table_leader.getColumnModel();
		colModel_leader.getColumn(0).setPreferredWidth(100);
		colModel_leader.getColumn(1).setPreferredWidth(100);
		colModel_leader.getColumn(2).setPreferredWidth(100);
		colModel_leader.getColumn(3).setPreferredWidth(50);
		
		//��ũ�� ����
		scroll_leader = new JScrollPane(table_leader,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_leader.setBounds(600,30,600,55);
		
		pane_main.add(scroll_leader);

	}

	public void makeEmpTable() {

		// �÷��� ����
		Vector<Object> colNames = new Vector<>();
		colNames.addElement("����");
		colNames.addElement("�̸�");
		colNames.addElement("���");
		colNames.addElement("�󼼺���");
		
		// �ο찪 �ֱ�(�׽�Ʈ ������)
		Vector<Object> row1;
		row1 = new Vector<>();
		row1.addElement("���");
		row1.addElement("ȫ�浿");
		row1.addElement("10002");
		row1.addElement("����");		
		Vector<Object> row2;
		row2 = new Vector<>();
		row2.addElement("���");
		row2.addElement("�赿��");
		row2.addElement("10003");
		row2.addElement("����");	
		Vector<Object> row3;
		row3 = new Vector<>();
		row3.addElement("���");
		row3.addElement("�볪��");
		row3.addElement("10005");
		row3.addElement("����");	
		Vector<Object> row4;
		row4 = new Vector<>();
		row4.addElement("���");
		row4.addElement("�ٸ���");
		row4.addElement("10011");
		row4.addElement("����");
		
		// ���̺� �� ����
		tbModel_empList = new DefaultTableModel(colNames,0);
		tbModel_empList.addRow(row1);
		tbModel_empList.addRow(row2);
		tbModel_empList.addRow(row3);
		tbModel_empList.addRow(row4);
		
		// ���̺� ����
		table_empList = new JTable(tbModel_empList);
		table_empList.setFillsViewportHeight(false);
		table_empList.setRowSelectionAllowed(true);
		
		// �� ������ ����
		table_empList.getColumn("�󼼺���").setCellEditor(new ButtonEditor(new JCheckBox()));
		table_empList.getColumn("�󼼺���").setCellRenderer(new ButtonRenderer());

		table_empList.setRowHeight(30);
		colModel_emp = table_empList.getColumnModel();
		colModel_emp.getColumn(0).setPreferredWidth(100);
		colModel_emp.getColumn(1).setPreferredWidth(100);
		colModel_emp.getColumn(2).setPreferredWidth(100);
		colModel_emp.getColumn(3).setPreferredWidth(50);

		// ��ũ�� ����
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
				JOptionPane.showMessageDialog(btn,"��ư ����!");
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
