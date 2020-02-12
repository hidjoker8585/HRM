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
 * @brief �μ���ȸ
 * @author ������
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
	
	
	public DeptLookupPanel() {
		// TODO Auto-generated constructor stub
		
		//�г� �ʱ� ����
		initPanel();
		
		
	}
	
	public void initPanel() {
		
		setLayout(null);

		pane_main = new JPanel();
		pane_main.setBounds(0,0,600,600);
		pane_main.setLayout(null);
		
		pane_sub_leader = new JPanel();
		pane_sub_leader.setLayout(null);
		
		//�÷��� ����
		Vector<Object> colNames_leader = new Vector<>();
		colNames_leader.addElement("����");
		colNames_leader.addElement("�̸�");
		colNames_leader.addElement("���");
		colNames_leader.addElement("�󼼺���");
		
		//���̺� �� ����
		tbModel_leader = new DefaultTableModel(colNames_leader, 0);		
		
		//���̰� �ֱ�
		Vector<Object> row_leader = new Vector<>();
		row_leader.addElement("����");
		row_leader.addElement("ȫ�浿");
		row_leader.addElement("10002");
		row_leader.addElement("�󼼺���");
		tbModel_leader.addRow(row_leader);
		
		//���̺� ����
		table_leader = new JTable(tbModel_leader);
		table_leader.setFillsViewportHeight(false);
		table_leader.setRowSelectionAllowed(false);
		table_leader.setCellSelectionEnabled(true);
		
		table_leader.setRowHeight(40);
		colModel_leader = table_leader.getColumnModel();
		colModel_leader.getColumn(0).setPreferredWidth(100);
		colModel_leader.getColumn(1).setPreferredWidth(100);
		colModel_leader.getColumn(2).setPreferredWidth(100);
		colModel_leader.getColumn(3).setPreferredWidth(50);
		
		//��ũ�� ����
		scroll_leader = new JScrollPane(table_leader);
		scroll_leader.setBounds(0,0,500,100);

		pane_main.add(scroll_leader);

//		pane_main.setLayout(null);

		add(pane_main);
		
	}
}
