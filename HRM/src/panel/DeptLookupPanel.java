package panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.w3c.dom.views.AbstractView;

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
	private DeptTableModel tbModel_leader;
	private DeptTableModel tbModel_deptList;
	private DeptTableModel tbModel_empList;

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
		
		// �ο찪 �ֱ�
		List<Vector> list = new ArrayList<Vector>();
		
		//���̺� �� ����
		tbModel_deptList = new DeptTableModel(colNames, list);
		
		//���̺� ����	
		table_deptList = new JTable(tbModel_deptList);
		table_deptList.setFillsViewportHeight(false);
		table_deptList.setRowSelectionAllowed(false);
		table_deptList.setCellSelectionEnabled(true);
		
		table_deptList.setRowHeight(30);
		colModel_dept = table_deptList.getColumnModel();
		colModel_dept.getColumn(0).setPreferredWidth(150);
		
		//��ũ�� ����	
		scroll_dept = new JScrollPane(table_deptList);
		scroll_dept.setBounds(50,100,150,300);
		
		pane_main.add(scroll_dept);

		
	}
	public void makeLeaderTable() {
				
		// �÷��� ����
		Vector<Object> colNames = new Vector<>();
		colNames.addElement("����");
		colNames.addElement("�̸�");
		colNames.addElement("���");
		colNames.addElement("�󼼺���");
		
		// �ο찪 �ֱ�
		List<Vector> list = new ArrayList<Vector>();
		Vector<Object> row;
		row = new Vector<>();
		row.addElement("����");
		row.addElement("�迵��");
		row.addElement("10004");
		row.addElement(new JButton());
		list.add(row);
			
		// ���̺� �� ����
		tbModel_leader = new DeptTableModel(colNames,list);

		// ���̺� ����
		table_leader = new JTable(tbModel_leader);
		table_leader.setFillsViewportHeight(false);
		table_leader.setRowSelectionAllowed(false);
		table_leader.setCellSelectionEnabled(false);
		
		// �� ������ ����
		table_leader.setDefaultEditor(JButton.class, new ButtonEditor());
		
		// �� ������ ����
		table_leader.setRowHeight(30);
		colModel_leader = table_leader.getColumnModel();
		colModel_leader.getColumn(0).setPreferredWidth(100);
		colModel_leader.getColumn(1).setPreferredWidth(100);
		colModel_leader.getColumn(2).setPreferredWidth(100);
		colModel_leader.getColumn(3).setPreferredWidth(50);
		
		//��ũ�� ����
		scroll_leader = new JScrollPane(table_leader);
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
		
		// �ο찪 �ֱ�
		List<Vector> list = new ArrayList<Vector>();
		Vector<Object> row;
		row = new Vector<>();
		row.addElement("���");
		row.addElement("ȫ�浿");
		row.addElement(new Boolean(true));
		row.addElement(new JButton());
		list.add(row);
		
		
		// ���̺� �� ����
		tbModel_empList = new DeptTableModel(colNames,list);

		// ���̺� ����
		table_empList = new JTable(tbModel_empList);
		table_empList.setFillsViewportHeight(false);
		table_empList.setRowSelectionAllowed(true);

		table_empList.setRowHeight(30);
		colModel_emp = table_empList.getColumnModel();
		colModel_emp.getColumn(0).setPreferredWidth(100);
		colModel_emp.getColumn(1).setPreferredWidth(100);
		colModel_emp.getColumn(2).setPreferredWidth(100);
		colModel_emp.getColumn(3).setPreferredWidth(50);

		// ��ũ�� ����
		scroll_emp = new JScrollPane(table_empList);
		scroll_emp.setBounds(600, 150, 600, 400);

		pane_main.add(scroll_emp);

	}
	
	//Ŀ���� ���̺� ��
	private class DeptTableModel extends AbstractTableModel{
		
		private Vector<Object> colNames; //���̺� �÷� ���
		private List<Vector> rowList;  //���̺� �ο� ������
		
		public DeptTableModel(Vector<Object> names,List<Vector> list) {
			// TODO Auto-generated constructor stub			
			colNames = names;
			rowList = list;
		}
		
		//�� �� ���
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return colNames.size();
		}

		//�� �� ���
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return rowList.size();
		}

		//�� ����̸� ���
		@Override
		public String getColumnName(int arg0) {
			// TODO Auto-generated method stub
			return (String)colNames.get(arg0);
		}
		
		//�� �� ���
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return rowList.get(rowIndex).get(columnIndex);
		}
		
		//�� Ŭ���� ���
		@Override
		public Class<?> getColumnClass(int columnIndex) {
			// TODO Auto-generated method stub
			return getValueAt(0, columnIndex).getClass();
		}
		
		//�����Ұ�
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return false;
		}
		
		//�� ����
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			rowList.get(rowIndex).setElementAt(aValue, columnIndex);
		}
		
		//�� �߰�
		public void addRow(Vector<Object> row) {
			rowList.add(row);
		}
		
		//�� ����
		public void deleteRow(int rowIndex) {
			rowList.remove(rowIndex);
		}
		
		//���
		public void debugData() {
			for(int i =0 ; i < rowList.size() ; i++) {
				System.out.print("["+i+"] row :");
				for(int j=0 ; j <colNames.size() ; j++) {
					System.out.print(" "+rowList.get(i).get(j).toString());
				}
				System.out.println();
			}
		}
	}

	private class ButtonEditor extends AbstractCellEditor implements ActionListener, TableCellEditor {

		private JButton btn;
		private ImageIcon icon;
		private Color color = Color.PINK;
		public ButtonEditor() {
			// TODO Auto-generated constructor stub
			btn = new JButton();
			btn.setActionCommand("EDIT");
			btn.addActionListener(this);
			btn.setBackground(color);
			btn.setBorderPainted(false);
		}
		
		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return 	color;

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			// TODO Auto-generated method stub
			color = (Color)value;
			return btn;
		}

	}
}
