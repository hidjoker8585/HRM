package panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import dto.Dept;
import dto.Emp;
import util.TableEditor;
import util.TableModel;
import util.TableRenderer;

/**
 * @brief  Messagesending
 * @author ksk
 * @version V1.00 2020.02.12
 * @see none
 */
public class MessageTransferPanel extends JPanel{

	//���� ��� ��
	private static final int TABLE_HEADER_HEIGHT = 40;
	private static final int TABLE_CELL_HEIGHT = 40;
	
	private static final Color TABLE_HEADER_BACKGROUND = new Color(200, 200, 200);
	private static final Color TABLE_CELL_BACKGROUND = new Color(240, 240, 240);
	
	private static final Font TABLE_HEADER_FONT = new Font("���",Font.BOLD,14); 
	private static final Font TABLE_CELL_FONT = new Font("���",Font.PLAIN,14);
	
	private static final int TABLE_EMP_X = 50;
	private static final int TABLE_EMP_Y = 50;
	private static final int TABLE_EMP_WIDTH = 550;
	private static final int TABLE_EMP_HEIGHT = 550;
	private static final int TABLE_EMP_COL1_WIDTH = 150;
	private static final int TABLE_EMP_COL2_WIDTH = 150;
	private static final int TABLE_EMP_COL3_WIDTH = 150;
	private static final int TABLE_EMP_COL4_WIDTH = 100;
	
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

	
	public MessageTransferPanel() {
		
		//�г� �ʱ� ����
		initPanel();

		//��� ���̺� ����
		makeEmpTable();
		
		//db�� ��������
		getData();
		
		add(pane_main);

	}
	
	public void initPanel() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(1,1));
		pane_main = new JPanel();
		pane_main.setLayout(null);
		
		pane_main.setBackground(Color.white);
		
		JButton btn1 = new JButton("����");
		btn1.setBounds(610,100,100,30);
		
		JTextField txt = new JTextField("�Է��ϼ���");
		txt.setBounds(610,150,500,300);
		
		JButton btn2 = new JButton("������");
		btn2.setBounds(800,470,100,30);
		
		pane_main.add(btn1);
		pane_main.add(txt);
		pane_main.add(btn2);
	}
	
	
	public void makeEmpTable() {

		// ���̺� ���� ����
		Vector<Object> colNames = new Vector<>();
		colNames.addElement("�μ�");
		colNames.addElement("�̸�");
		colNames.addElement("���");
		colNames.addElement("������");
		
		// ���̺� �� ����
		//tbModel_empList = new TableModel(colNames,0,2,3);
		tbModel_empList = new TableModel(colNames,0,3);

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
		colModel_emp.getColumn(3).setCellEditor(new TableEditor("check",null));
		colModel_emp.getColumn(3).setCellRenderer(new TableRenderer("check"));

		//���̺� �� ������
		table_empList.setRowHeight(TABLE_CELL_HEIGHT);
		colModel_emp.getColumn(0).setPreferredWidth(TABLE_EMP_COL1_WIDTH);
		colModel_emp.getColumn(1).setPreferredWidth(TABLE_EMP_COL2_WIDTH);
		colModel_emp.getColumn(2).setPreferredWidth(TABLE_EMP_COL3_WIDTH);
		colModel_emp.getColumn(3).setPreferredWidth(TABLE_EMP_COL4_WIDTH);

		// ��ũ�� ����
		scroll_emp = new JScrollPane(table_empList,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_emp.setBounds(TABLE_EMP_X, TABLE_EMP_Y, TABLE_EMP_WIDTH, TABLE_EMP_HEIGHT);
		
		//���̺� ��� ����
		header_emp.setPreferredSize(new Dimension(TABLE_EMP_WIDTH,TABLE_HEADER_HEIGHT));
		header_emp.setBackground(TABLE_HEADER_BACKGROUND);
		header_emp.setReorderingAllowed(false);
		
		pane_main.add(scroll_emp);

	}
	
	public void getData() {
		//dao = new DaoImpl();
		//sourceMap = dao.getAllByDept();
		// �׽�Ʈ������ �ֱ�
		
		// �׽�Ʈ ������
	    //�μ��Ұ� �ؽ�Ʈ(�׽�Ʈ ��)
		empList = new ArrayList<>();
		Emp emp = new Emp();
		emp.setDept("�λ���");		
		emp.setPosition("���");
		emp.setName("ȫ�浿");
		emp.setEmpNo(10002);
		empList.add(emp);
		emp = new Emp();
		emp.setDept("�λ���");		
		emp.setPosition("����");
		emp.setName("�迵��");
		emp.setEmpNo(10004);
		empList.add(emp);
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

		// ������ �й��ϱ�
		for (Emp e : empList) {
			Vector<Object> row = new Vector<>();
			row.addElement(e.getDept());
			row.addElement(e.getName());
			row.addElement(e.getEmpNo());
			row.addElement(false);
			tbModel_empList.addRow(row);
		}
	}
}