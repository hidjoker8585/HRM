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
 * @brief �������
 * @author LeeSunwha
 * @version v1.00 2020.02.11
 * @see ���޺� ȭ��������
 */
public class EmpLookupPanel extends JPanel{

	
	//���� ��� ��
	private static final int TABLE_HEADER_HEIGHT = 40;
	private static final int TABLE_CELL_HEIGHT = 40;
	
	private static final Color TABLE_HEADER_BACKGROUND = new Color(200, 200, 200);
	private static final Color TABLE_CELL_BACKGROUND = new Color(240, 240, 240);
	
	private static final Font TABLE_HEADER_FONT = new Font("���",Font.BOLD,14); 
	private static final Font TABLE_CELL_FONT = new Font("���",Font.PLAIN,14);
	
	private static final int TABLE_EMP_X = 380;
	private static final int TABLE_EMP_Y = 50;
	private static final int TABLE_EMP_WIDTH = 800;
	private static final int TABLE_EMP_HEIGHT = 550;
	private static final int TABLE_EMP_COL1_WIDTH = 150;
	private static final int TABLE_EMP_COL2_WIDTH = 150;
	private static final int TABLE_EMP_COL3_WIDTH = 150;
	private static final int TABLE_EMP_COL4_WIDTH = 150;
	private static final int TABLE_EMP_COL5_WIDTH = 100;
	
	//�����̳�
	private JPanel pane_main;
	
	
	//������Ʈ
	private JTable table_empList;
	
	//���̺� ����
	private TableModel tbModel_empList;

	private JScrollPane scroll_emp;

	private TableColumnModel colModel_emp;
	private JTableHeader header_emp;

	private DefaultTableCellRenderer defaultRenderer;


	//DB
	private ArrayList<Emp> empList;
	
	public EmpLookupPanel() {
		// TODO Auto-generated constructor stub
		
		//�г� �ʱ� ����
		initPanel();
		
		//��� ���̺� ����
		makeEmpTable();
		
		//db�� ��������
		getData();
	}
	
	public void initPanel() {
		
		setLayout(new GridLayout(1,1));

		pane_main = new JPanel();
		pane_main.setLayout(null);
		
		add(pane_main);

		
	}
	
	public void makeEmpTable() {

		// ���̺� ���� ����
		Vector<Object> colNames = new Vector<>();
		colNames.addElement("�̸�");
		colNames.addElement("���");
		colNames.addElement("����");
		colNames.addElement("�Ի���");
		colNames.addElement("�󼼺���");
		
		// ���̺� �� ����
		//tbModel_empList = new TableModel(colNames,0,2,3);
		tbModel_empList = new TableModel(colNames,0,4);

		// ���̺� ����
		table_empList = new JTable(tbModel_empList);
		table_empList.setFillsViewportHeight(false);
		table_empList.setRowSelectionAllowed(true);
		table_empList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_empList.setBackground(TABLE_CELL_BACKGROUND);
		
		// �� ��Ʈ ����
		header_emp = table_empList.getTableHeader();
		header_emp.setFont(TABLE_HEADER_FONT);
		table_empList.setFont(TABLE_CELL_FONT);

		// �� ������,������ ����
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

		//���̺� �� ������
		table_empList.setRowHeight(TABLE_CELL_HEIGHT);
		colModel_emp.getColumn(0).setPreferredWidth(TABLE_EMP_COL1_WIDTH);
		colModel_emp.getColumn(1).setPreferredWidth(TABLE_EMP_COL2_WIDTH);
		colModel_emp.getColumn(2).setPreferredWidth(TABLE_EMP_COL3_WIDTH);
		colModel_emp.getColumn(3).setPreferredWidth(TABLE_EMP_COL4_WIDTH);
		colModel_emp.getColumn(4).setPreferredWidth(TABLE_EMP_COL5_WIDTH);


		// ��ũ�� ����
		scroll_emp = new JScrollPane(table_empList,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_emp.setBounds(TABLE_EMP_X, TABLE_EMP_Y, TABLE_EMP_WIDTH, TABLE_EMP_HEIGHT);
		
		//���̺� ��� ����
		header_emp.setPreferredSize(new Dimension(TABLE_EMP_WIDTH,TABLE_HEADER_HEIGHT));
		header_emp.setBackground(TABLE_HEADER_BACKGROUND);
		header_emp.setReorderingAllowed(false);
		
		pane_main.add(scroll_emp);

	}
	
	public void getData(){
		empList = new ArrayList<>();
		Emp emp = new Emp();
		emp.setDept("�λ���");		
		emp.setPosition("���");
		emp.setName("ȫ�浿");
		emp.setEmpNo(10002);
		emp = new Emp();
		emp.setDept("�λ���");		
		emp.setPosition("���");
		emp.setName("�赿��");
		emp.setEmpNo(10003);
		empList.add(emp);
		emp = new Emp();
		emp.setDept("�λ���");		
		emp.setPosition("���");
		emp.setName("�볪��");
		emp.setEmpNo(10005);
		empList.add(emp);
		emp = new Emp();
		emp.setDept("�λ���");		
		emp.setPosition("���");
		emp.setName("ȫ�浿");
		emp.setEmpNo(10002);
		empList.add(emp);
		emp.setDept("����1��");		
		emp.setPosition("���");
		emp.setName("�ٸ���");
		emp.setEmpNo(10011);
		empList.add(emp);
		emp = new Emp();
		emp.setDept("����1��");		
		emp.setPosition("����");
		emp.setName("����");
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
