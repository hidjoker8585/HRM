package panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import util.TableEditor;
import util.TableModel;
import util.TableRenderer;


/**
 * @brief �μ���ȸ
 * @author ������
 * @version v 1.03 (2020.02.16)
 * @see DB���� ����..
 * 
 */
public class DeptLookupPanel extends JPanel{

	//���� ��� ��
	private static final int TABLE_HEADER_HEIGHT = 40;
	private static final Color TABLE_HEADER_BACKGROUND = new Color(200, 200, 200);
	private static final Font TABLE_HEADER_FONT = new Font("���",Font.BOLD,14); 

	private static final int TABLE_CELL_HEIGHT = 40;
	private static final Font TABLE_CELL_FONT = new Font("���",Font.PLAIN,14);
	
	private static final Color AREA_INTRODUCTION_BACKGROUND = new Color(220, 220, 220);
	private static final Font LBL_INTRODUCTION_FONT = new Font("���",Font.BOLD,18);
	private static final Font AREA_INTRODUCTION_FONT = new Font("���",Font.PLAIN,14);
	
	private static final int TABLE_DEPT_X= 80;
	private static final int TABLE_DEPT_Y = 40;
	private static final int TABLE_DEPT_WIDTH= 300;
	private static final int TABLE_DEPT_HEIGHT= 300;
	
	private static final int TABLE_LEADER_X = 480;
	private static final int TABLE_LEADER_Y = 40;
	private static final int TABLE_LEADER_WIDTH = 700;
	private static final int TABLE_LEADER_HEIGHT = 80;
	private static final int TABLE_LEADER_COL1_WIDTH = 200;
	private static final int TABLE_LEADER_COL2_WIDTH = 200;
	private static final int TABLE_LEADER_COL3_WIDTH = 200;
	private static final int TABLE_LEADER_COL4_WIDHT = 100;
	
	private static final int TABLE_EMP_X = 480;
	private static final int TABLE_EMP_Y = 160;
	private static final int TABLE_EMP_WIDTH = 700;
	private static final int TABLE_EMP_HEIGHT = 450;
	private static final int TABLE_EMP_COL1_WIDTH = 200;
	private static final int TABLE_EMP_COL2_WIDTH = 200;
	private static final int TABLE_EMP_COL3_WIDTH = 200;
	private static final int TABLE_EMP_COL4_WIDTH = 100;
	
	private static final int PANEL_INTRODUCTION_X = 80;
	private static final int PANEL_INTRODUCTION_Y = 360;
	private static final int PANEL_INTRODUCTION_WIDTH = 300;
	private static final int PANEL_INTRODUCTION_HEIGHT = 260;
	
	//�����̳�
	private JPanel pane_main;
	private JPanel pane_sub_intro;
	
	//������Ʈ
	private JTable table_deptList;
	private JTable table_leader;
	private JTable table_empList;
	
	private JLabel lbl_intro;
	private JTextArea area_intro;
	
	//���̺� ����
	private TableModel tbModel_leader;
	private TableModel tbModel_deptList;
	private TableModel tbModel_empList;

	private JScrollPane scroll_leader;
	private JScrollPane scroll_dept;
	private JScrollPane scroll_emp;

	private TableColumnModel colModel_leader;	
	private TableColumnModel colModel_dept;	
	private TableColumnModel colModel_emp;
	
	private JTableHeader header_dept;
	private JTableHeader header_leader;
	private JTableHeader header_emp;
	
	
	private DefaultTableCellRenderer defaultRenderer;
	
	
	//������
	public DeptLookupPanel() {
		// TODO Auto-generated constructor stub
		
		//�г� �ʱ� ����
		initPanel();
		
		//�μ� ���̺� ����
		makeDeptTable();
		
		//���� ���̺� ����
		makeLeaderTable();
		
		//��� ���̺� ����
		makeEmpTable();
		
		//�μ� ����
		makeDeptIntroduction();
	
		add(pane_main);

	}
	
	public void initPanel() {
		
		setLayout(new GridLayout(1,1));

		pane_main = new JPanel();
		pane_main.setLayout(null);
		
	}
	
	public void makeDeptTable() {
		// ���̺� ���� ����
		Vector<Object> colNames = new Vector<>();
		colNames.addElement("�μ���");
		
		// ������ ����(�׽�Ʈ)
		Vector<Object> row1;
		row1 = new Vector<>();
		row1.addElement("�λ���");
		Vector<Object> row2;
		row2 = new Vector<>();
		row2.addElement("����1��");
		Vector<Object> row3;
		row3 = new Vector<>();
		row3.addElement("����2��");
		Vector<Object> row4;
		row4 = new Vector<>();
		row4.addElement("�ѹ���");
		Vector<Object> row5;
		row5 = new Vector<>();
		row5.addElement("ȫ����");
		Vector<Object> row6;
		row6 = new Vector<>();
		row6.addElement("�繫��");
		
		//���̺� �� ����
		//tbModel_deptList = new TableModel(colNames, 0,0);
		tbModel_deptList = new TableModel(colNames, 0);
		
		//Row ����
		tbModel_deptList.addRow(row1);
		tbModel_deptList.addRow(row2);
		tbModel_deptList.addRow(row3);
		tbModel_deptList.addRow(row4);
		tbModel_deptList.addRow(row5);
		tbModel_deptList.addRow(row6);

		//���̺� ����	
		table_deptList = new JTable(tbModel_deptList);
		table_deptList.setFillsViewportHeight(false);
		table_deptList.setRowSelectionAllowed(true);
		table_deptList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// �� ������,������ ����
		defaultRenderer = new DefaultTableCellRenderer();
		colModel_dept = table_deptList.getColumnModel();
		//colModel_dept.getColumn(0).setCellEditor(new TableEditor("check"));
		//colModel_dept.getColumn(0).setCellRenderer(new TableRenderer("check"));
		colModel_dept.getColumn(0).setCellRenderer(defaultRenderer);

		//���̺� �� ������
		table_deptList.setRowHeight(TABLE_CELL_HEIGHT);
		colModel_dept.getColumn(0).setPreferredWidth(TABLE_DEPT_WIDTH);
		
		//��ũ�� ����	
		scroll_dept = new JScrollPane(table_deptList,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_dept.setBounds(TABLE_DEPT_X,TABLE_DEPT_Y,TABLE_DEPT_WIDTH,TABLE_DEPT_HEIGHT);
		
		//���̺� ��� ����
		header_dept = table_deptList.getTableHeader();
		header_dept.setPreferredSize(new Dimension(TABLE_DEPT_WIDTH,TABLE_HEADER_HEIGHT));
		header_dept.setBackground(TABLE_HEADER_BACKGROUND);
		header_dept.setReorderingAllowed(false);
		
		// ���̺� ��Ʈ ����
		table_deptList.getTableHeader().setFont(TABLE_HEADER_FONT);
		table_deptList.setFont(TABLE_CELL_FONT);
		
		
		pane_main.add(scroll_dept);

		
	}
	public void makeLeaderTable() {
				
		// ���̺� ���� ����
		Vector<Object> colNames = new Vector<>();
		colNames.addElement("����");
		colNames.addElement("�̸�");
		colNames.addElement("���");
		colNames.addElement("�󼼺���");
		
		// ������ ����(�׽�Ʈ)
		Vector<Object> row;
		row = new Vector<>();
		row.addElement("����");
		row.addElement("�迵��");
		row.addElement("10004");
		row.addElement(10004);
		
		// ���̺� �� ����
		tbModel_leader = new TableModel(colNames,0,3);
    	
    	// Row ����
		tbModel_leader.addRow(row);
		
		// ���̺� ����
		table_leader = new JTable(tbModel_leader);
		table_leader.setFillsViewportHeight(false);
		table_leader.setRowSelectionAllowed(false);
		table_leader.setCellSelectionEnabled(false);
		
		// ���̺� ��Ʈ ����
		header_leader = table_leader.getTableHeader();
		header_leader.setFont(TABLE_HEADER_FONT);
		table_leader.setFont(TABLE_CELL_FONT);

		// �� ������,������ ����
		defaultRenderer.setHorizontalAlignment(JLabel.CENTER);
		colModel_leader = table_leader.getColumnModel();
		colModel_leader.getColumn(0).setCellRenderer(defaultRenderer);
		colModel_leader.getColumn(1).setCellRenderer(defaultRenderer);
		colModel_leader.getColumn(2).setCellRenderer(defaultRenderer);
		colModel_leader.getColumn(3).setCellEditor(new TableEditor("button"));
		colModel_leader.getColumn(3).setCellRenderer(new TableRenderer("button"));
			
		//���̺� �� ������
		table_leader.setRowHeight(TABLE_CELL_HEIGHT);
		colModel_leader.getColumn(0).setPreferredWidth(TABLE_LEADER_COL1_WIDTH);
		colModel_leader.getColumn(1).setPreferredWidth(TABLE_LEADER_COL2_WIDTH);
		colModel_leader.getColumn(2).setPreferredWidth(TABLE_LEADER_COL3_WIDTH);
		colModel_leader.getColumn(3).setPreferredWidth(TABLE_LEADER_COL4_WIDHT);
		
		//��ũ�� ����
		scroll_leader = new JScrollPane(table_leader,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_leader.setBounds(TABLE_LEADER_X,TABLE_LEADER_Y,TABLE_LEADER_WIDTH,TABLE_LEADER_HEIGHT);
		
		//���̺� ��� ����
		header_leader.setPreferredSize(new Dimension(TABLE_LEADER_WIDTH,TABLE_HEADER_HEIGHT));
		header_leader.setBackground(TABLE_HEADER_BACKGROUND);
		header_leader.setReorderingAllowed(false);
		
		pane_main.add(scroll_leader);
		
	}

	public void makeEmpTable() {

		// ���̺� ���� ����
		Vector<Object> colNames = new Vector<>();
		colNames.addElement("����");
		colNames.addElement("�̸�");
		colNames.addElement("���");
		colNames.addElement("�󼼺���");
		
		// ������ ����(�׽�Ʈ)
		Vector<Object> row1;
		row1 = new Vector<>();
		row1.addElement("���");
		row1.addElement("ȫ�浿");
		row1.addElement("10002");
		row1.addElement(10002);		
		Vector<Object> row2;
		row2 = new Vector<>();
		row2.addElement("���");
		row2.addElement("�赿��");
		row2.addElement("10003");
		row2.addElement(10003);	
		Vector<Object> row3;
		row3 = new Vector<>();
		row3.addElement("���");
		row3.addElement("�볪��");
		row3.addElement("10005");
		row3.addElement(10005);	
		Vector<Object> row4;
		row4 = new Vector<>();
		row4.addElement("���");
		row4.addElement("�ٸ���");
		row4.addElement("10011");
		row4.addElement(10011);
		
		// ���̺� �� ����
		//tbModel_empList = new TableModel(colNames,0,2,3);
		tbModel_empList = new TableModel(colNames,0,3);

    	//Row ����
		tbModel_empList.addRow(row1);
		tbModel_empList.addRow(row2);
		tbModel_empList.addRow(row3);
		tbModel_empList.addRow(row4);
		
		// ���̺� ����
		table_empList = new JTable(tbModel_empList);
		table_empList.setFillsViewportHeight(false);
		table_empList.setRowSelectionAllowed(true);
		table_empList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
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
		colModel_emp.getColumn(3).setCellEditor(new TableEditor("button"));
		colModel_emp.getColumn(3).setCellRenderer(new TableRenderer("button"));

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
	
	public void makeDeptIntroduction() {
		
		//�г� ����
		pane_sub_intro = new JPanel();
		pane_sub_intro.setLayout(null);
		pane_sub_intro.setBounds(PANEL_INTRODUCTION_X,PANEL_INTRODUCTION_Y,PANEL_INTRODUCTION_WIDTH,PANEL_INTRODUCTION_HEIGHT);
		pane_sub_intro.setBorder(new EtchedBorder());
		
		//���̺� ����
		lbl_intro = new JLabel("[�μ��Ұ�]");
		lbl_intro.setBounds(10, 10, 100, 30);
		lbl_intro.setFont(LBL_INTRODUCTION_FONT);
		
		//�ؽ�Ʈ ����� ����
		area_intro = new JTextArea(5, 15);
		area_intro.setEditable(false);
		area_intro.setBounds(20,50,260,190);
	    area_intro.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    area_intro.setBackground(AREA_INTRODUCTION_BACKGROUND);
	    area_intro.setLineWrap(true);
	    area_intro.setFont(AREA_INTRODUCTION_FONT);
	    
	    //�μ��Ұ� �ؽ�Ʈ(�׽�Ʈ ��)
	    String intro = "\n    �λ����� ������ �����ϰ� ��ġ�ϸ� \n"
	    		+ "    ���� ������ �����ϰ� ���ϴ� ��  \n"
	    		+ "    �����ڿ� ������ �� ������ �ϰ� �ֽ� \n"
	    		+ "    �ϴ�\n\n"
	    		+ "    ��ġ : ���� 3F \n"
	    		+ "    ����ó : xx-xxxx-xxxx";
		area_intro.setText(intro);
	    
	    pane_sub_intro.add(lbl_intro);
		pane_sub_intro.add(area_intro);
		
		pane_main.add(pane_sub_intro);
		
	}
	

	

}
