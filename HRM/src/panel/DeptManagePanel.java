package panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import dao.DaoImpl;
import dto.Dept;
import dto.Emp;
import util.TableEditor;
import util.TableModel;
import util.TableRenderer;

/**
 * @brief �μ����� Ŭ�����Դϴ�
 * @author ������
 * @version v1.03 (2020.02.20)
 * @see �ڵ� ������..
 */
public class DeptManagePanel extends JPanel implements ListSelectionListener, ActionListener{

	//���� ��� ��
	private static final int TABLE_HEADER_HEIGHT = 40;
	private static final int TABLE_CELL_HEIGHT = 40;

	private static final Color TABLE_HEADER_BACKGROUND = new Color(200, 200, 200);
	private static final Color TABLE_CELL_BACKGROUND = new Color(255, 255, 255);
	private static final Color AREA_INTRODUCTION_BACKGROUND = new Color(255, 255, 255);
	private static final Color PANEL_EDIT_BACKGROUND = new Color(255, 255, 255);
	
	private static final Font TABLE_HEADER_FONT = new Font("���",Font.BOLD,14); 
	private static final Font TABLE_CELL_FONT = new Font("���",Font.PLAIN,14);
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
	
	private static final int PANEL_INTRODUCTION_X = 80;
	private static final int PANEL_INTRODUCTION_Y = 360;
	private static final int PANEL_INTRODUCTION_WIDTH = 300;
	private static final int PANEL_INTRODUCTION_HEIGHT = 260;
	
	private static final int PANEL_EDIT_X = 480;
	private static final int PANEL_EDIT_Y = 160;
	private static final int PANEL_EDIT_WIDTH = 700;
	private static final int PANEL_EDIT_HEIGHT = 450;
	
	//�����̳�
	private JFrame frame;
	private JPanel pane_main;
	private JPanel pane_sub_intro;
	private JPanel pane_sub_edit;
	
	//������Ʈ
	private JTable table_deptList;
	private JTable table_leader;
	
	private JLabel lbl_intro;
	private JTextArea area_intro;
	
	private JLabel lbl_inputName;
	private JLabel lbl_inputIntro;
	private JLabel lbl_inputLeader;
	
	private JTextField txt_inputName;
	private JTextArea area_inputIntro;
	private JComboBox<String> combo_inputLeader;

	private JButton btn_clear;
	private JButton btn_addDept;
	private JButton btn_editDept;
	private JButton btn_deleteDept;
	
	//���̺� ����
	private TableModel tbModel_leader;
	private TableModel tbModel_deptList;

	private JScrollPane scroll_leader;
	private JScrollPane scroll_dept;

	private TableColumnModel colModel_leader;	
	private TableColumnModel colModel_dept;	
	
	private JTableHeader header_dept;
	private JTableHeader header_leader;
	
	private DefaultTableCellRenderer defaultRenderer;
	
	//DB
	private DaoImpl dao;
	private TreeMap<Dept, ArrayList<Emp>> sourceMap;
	private ArrayList<Dept> deptList;
	private HashMap<String, Emp> deptLeader;
	private ArrayList<Emp> empList;
	
	//������
	public DeptManagePanel(JFrame f) {
		
		frame = f;
		
		//�г� �ʱ� ����
		initPanel();
		
		//�μ� ���̺� ����
		makeDeptTable();
		
		//���� ���̺� ����
		makeLeaderTable();
		
		//�μ� ����
		makeDeptIntroduction();

		//db�� ��������
		getData();

		//�μ� ���� �г�
		makeEditPanel();
		

	

		add(pane_main);
	}
	
	public void initPanel() {
		
		setLayout(new GridLayout(1,1));

		pane_main = new JPanel();
		pane_main.setLayout(null);
		
	}
	
	public void makeDeptTable() {

		//�μ�����Ʈ 
		Vector<Object> colNames = new Vector<>();
		colNames.addElement("�μ���");
		
		//���̺� �� ����
		//tbModel_deptList = new TableModel(colNames, 0,0);
		tbModel_deptList = new TableModel(colNames, 0);

		//���̺� ����	
		table_deptList = new JTable(tbModel_deptList);
		table_deptList.setFillsViewportHeight(false);
		table_deptList.setRowSelectionAllowed(true);
		table_deptList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_deptList.setBackground(TABLE_CELL_BACKGROUND);
		table_deptList.getSelectionModel().addListSelectionListener(this);
		
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
		
		// ���̺� �� ����
		tbModel_leader = new TableModel(colNames,0,3);
		
		// ���̺� ����
		table_leader = new JTable(tbModel_leader);
		table_leader.setFillsViewportHeight(false);
		table_leader.setRowSelectionAllowed(false);
		table_leader.setCellSelectionEnabled(false);
		table_leader.setBackground(TABLE_CELL_BACKGROUND);
		
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
		colModel_leader.getColumn(3).setCellEditor(new TableEditor("button",frame));
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
		area_intro = new JTextArea();
		area_intro.setEditable(false);
		area_intro.setBounds(20,50,260,190);
	    area_intro.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    area_intro.setBackground(AREA_INTRODUCTION_BACKGROUND);
	    area_intro.setLineWrap(true);
	    area_intro.setFont(AREA_INTRODUCTION_FONT);
	    
	    pane_sub_intro.add(lbl_intro);
		pane_sub_intro.add(area_intro);
		
		pane_main.add(pane_sub_intro);
		
	}
	
	public void getData() {
		//dao = new DaoImpl();
		//sourceMap = dao.getAllByDept();
		//empList = dao.getAllEmp();
		// �׽�Ʈ������ �ֱ�
		
		// �׽�Ʈ ������
		sourceMap = new TreeMap<>();
		Dept dept = new Dept();
		empList = new ArrayList<>();
		ArrayList empAll = new ArrayList<>();
	    //�μ��Ұ� �ؽ�Ʈ(�׽�Ʈ ��)
	    String intro = "\n    �λ����� ������ �����ϰ� ��ġ�ϸ� \n"
	    		+ "    ���� ������ �����ϰ� ���ϴ� ��  \n"
	    		+ "    �����ڿ� ������ �� ������ �ϰ� �ֽ� \n"
	    		+ "    �ϴ�\n\n"
	    		+ "    ��ġ : ���� 3F \n"
	    		+ "    ������ : xx-xxxx-xxxx";
		dept.setName("�λ���");
		dept.setLeaderNo(10004);
		dept.setIntro(intro);
		Emp emp = new Emp();
		emp.setDept("�λ���");		
		emp.setPosition("���");
		emp.setName("ȫ�浿");
		emp.setEmpNo(10002);
		empAll.add(emp);
		empList.add(emp);
		emp = new Emp();
		emp.setDept("�λ���");		
		emp.setPosition("����");
		emp.setName("�迵��");
		emp.setEmpNo(10004);
		empAll.add(emp);
		empList.add(emp);
		emp = new Emp();
		emp.setDept("�λ���");		
		emp.setPosition("���");
		emp.setName("�赿��");
		emp.setEmpNo(10003);
		empAll.add(emp);
		empList.add(emp);
		emp = new Emp();
		emp.setDept("�λ���");		
		emp.setPosition("���");
		emp.setName("�볪��");
		emp.setEmpNo(10005);
		empAll.add(emp);
		empList.add(emp);
		sourceMap.put(dept, empAll);
		
	    intro = "\n    ����1���� �ַ�� ���߰� �������� \n"
	    		+ "    ������ ����ϰ� �ֽ��ϴ�   \n"
	    		+ "    \n"
	    		+ "    ��ġ : ���� 4F \n"
	    		+ "    ������ : xx-xxxx-xxxx";
	    empAll = new ArrayList<>();
	    dept = new Dept();
		emp = new Emp();
		dept.setName("����1��");
		dept.setLeaderNo(10007);
		dept.setIntro(intro);
		emp.setDept("����1��");		
		emp.setPosition("���");
		emp.setName("�ٸ���");
		emp.setEmpNo(10011);
		empAll.add(emp);
		empList.add(emp);
		emp = new Emp();
		emp.setDept("����1��");		
		emp.setPosition("����");
		emp.setName("����");
		emp.setEmpNo(10007);
		empAll.add(emp);
		empList.add(emp);
		sourceMap.put(dept, empAll);	
	    dept = new Dept();
		//emp = new Emp();
		dept.setName("ȫ����");
		dept.setLeaderNo(10007);
		sourceMap.put(dept, null);

		// ������ �й��ϱ�
		deptList = new ArrayList<>();
		deptLeader = new HashMap<>();
		
		Iterator<Map.Entry<Dept, ArrayList<Emp>>> iter = sourceMap.entrySet().iterator();
		while ( iter.hasNext()) {
			Map.Entry<Dept, ArrayList<Emp>> entry = iter.next();
			Dept row = (Dept)entry.getKey();
			deptList.add(row);
			if(entry.getValue() == null) {
				deptLeader.put(row.getName(), null);
			}else {
				for (Emp e : entry.getValue()) {
					if(e.getEmpNo()==row.getLeaderNo()) {
						deptLeader.put(row.getName(), e);
					}
				}
			}
			Vector<Object> name = new Vector<>();
			name.addElement(row.getName());
			tbModel_deptList.addRow(name);
		}
	}
	
	public void makeEditPanel(){
		
		//�г� ����
		pane_sub_edit = new JPanel();
		pane_sub_edit.setBounds(PANEL_EDIT_X,PANEL_EDIT_Y,PANEL_EDIT_WIDTH,PANEL_EDIT_HEIGHT);
		pane_sub_edit.setBackground(PANEL_EDIT_BACKGROUND);	
		pane_sub_edit.setLayout(null);
		
		//���̺� ����
		lbl_inputName = new JLabel("�μ���");
		lbl_inputName.setBounds(30,50,100,40);
		lbl_inputName.setHorizontalAlignment(JLabel.CENTER);
		lbl_inputName.setFont(TABLE_HEADER_FONT);

		lbl_inputIntro = new JLabel("�μ��Ұ�");
		lbl_inputIntro.setBounds(30,120,100,40);
		lbl_inputIntro.setHorizontalAlignment(JLabel.CENTER);
		lbl_inputIntro.setFont(TABLE_HEADER_FONT);

		lbl_inputLeader = new JLabel("����");
		lbl_inputLeader.setBounds(30,340,100,40);
		lbl_inputLeader.setHorizontalAlignment(JLabel.CENTER);
		lbl_inputLeader.setFont(TABLE_HEADER_FONT);
		
		//�ؽ�Ʈ�ʵ� ����
		txt_inputName = new JTextField();
		txt_inputName.setBounds(140,50,260,40);
		txt_inputName.setFont(TABLE_CELL_FONT);
		
		//�ؽ�Ʈ����� ����
		area_inputIntro = new JTextArea();
		area_inputIntro.setBounds(140,120,260,190);
		area_inputIntro.setBackground(TABLE_HEADER_BACKGROUND);
		area_inputIntro.setLineWrap(true);
		area_inputIntro.setFont(AREA_INTRODUCTION_FONT);

		//�޺��ڽ� ����
		String[] leaderArr = new String[empList.size()+1];
		leaderArr[0] = "������ �����ϼ���";
		int count = 1;
		for (Emp e  : empList) {
			leaderArr[count] = e.getName() + "_���:"+e.getEmpNo();
			count++;
		}
		combo_inputLeader = new JComboBox<String>(leaderArr);
		combo_inputLeader.setBounds(140,340,260,40);
		combo_inputLeader.setFont(TABLE_CELL_FONT);
		combo_inputLeader.setEditable(false);
		
		//��ư ����
		btn_clear = new JButton("����");
		btn_clear.setBounds(480,50,150,40);
		btn_clear.addActionListener(this);
		
		btn_addDept = new JButton("�߰�");
		btn_addDept.setBounds(480,200,150,40);
		btn_addDept.addActionListener(this);
	
		btn_editDept = new JButton("����");
		btn_editDept.setBounds(480,270,150,40);
		btn_editDept.addActionListener(this);
		
		btn_deleteDept = new JButton("����");
		btn_deleteDept.setBounds(480,340,150,40);
		btn_deleteDept.addActionListener(this);
		
		//������Ʈ ���� �����̳ʿ� �߰�
		pane_sub_edit.add(lbl_inputName);
		pane_sub_edit.add(txt_inputName);
		pane_sub_edit.add(lbl_inputIntro);
		pane_sub_edit.add(area_inputIntro);
		pane_sub_edit.add(lbl_inputLeader);
		pane_sub_edit.add(combo_inputLeader);
		pane_sub_edit.add(btn_clear);
		pane_sub_edit.add(btn_addDept);
		pane_sub_edit.add(btn_editDept);
		pane_sub_edit.add(btn_deleteDept);
	
		pane_main.add(pane_sub_edit);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		selectDeptRow();
	}
	
	public void selectDeptRow() {
		// ���̺� �ʱ�ȭ
		for (int i = tbModel_leader.getRowCount() - 1; i > -1; i--) {
			tbModel_leader.removeRow(i);
		}
		// intro �ʱ�ȭ
		area_intro.setText("");

		// ������ ���̺� �߰�
		int rowNum = table_deptList.getSelectedRow();
		if(rowNum==-1) return;
		Dept dept = deptList.get(rowNum);
		area_intro.setText(dept.getIntro());
		Emp emp = deptLeader.get(dept.getName());
		if (emp != null) {
			Vector<Object> row = new Vector<>();
			row.addElement(emp.getPosition());
			row.addElement(emp.getName());
			row.addElement(emp.getEmpNo());
			row.addElement(emp.getEmpNo());
			tbModel_leader.addRow(row);
		}
		
		// ������ ������â�� �߰�
		txt_inputName.setText(dept.getName());
		area_inputIntro.setText(dept.getIntro());
		Emp leader = deptLeader.get(dept.getName());
		if(leader==null) {
			combo_inputLeader.setSelectedIndex(0);
		}else {
			combo_inputLeader.setSelectedItem(leader.getName()+"_���:"+leader.getEmpNo());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_clear) {
			clearEdit();
		}
		if(e.getSource()==btn_addDept) {
			boolean res = validateData();
			if(res) {
				addDept();
				clearEdit();
			}
		}
		if(e.getSource()==btn_editDept) {
			boolean res = validateData();
			if(res) {
				editDept();
			}
		}
		if(e.getSource()==btn_deleteDept) {
			boolean res = validateData();
			if(res) {
				deleteDept();
				clearEdit();
			}
		}
	}
	
	public void clearEdit() {
		txt_inputName.setText("");
		area_inputIntro.setText("");
		combo_inputLeader.setSelectedIndex(0);
	}
	public boolean validateData() {
		if(txt_inputName.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "�μ��̸��� �Է��ϼ���");
			return false;
		}else if(txt_inputName.getText().trim().length()>10) {
			JOptionPane.showMessageDialog(this, "�μ��̸��� 10�� �̳��� �Է��ϼ���");
			return false;
		}
		return true;
		
	}
	public void addDept() {
		//���� �μ� üũ
		int selectedRow = -1;
		for(int count=0 ;count<tbModel_deptList.getRowCount();count++ ) {
			if(((String)tbModel_deptList.getValueAt(count, 0)).equals(txt_inputName.getText().trim())) {
				selectedRow = count;
				break;
			}
		}
		if(selectedRow!=-1) {
			JOptionPane.showMessageDialog(this, "���� �̸��� �μ��� �̹� �����մϴ�");
			return;
		}
		
		//db �߰�
		Dept dept = new Dept();
		dept.setName(txt_inputName.getText().trim());
		dept.setIntro(area_inputIntro.getText());
		if(combo_inputLeader.getSelectedIndex()>0) {
			dept.setLeaderNo(Integer.parseInt(((String)combo_inputLeader.getSelectedItem()).split("_���:")[1]));
		}
		//dao.addDept(dept)
		
		//deptList�� �߰�
		deptList.add(dept);
		
		//deptLeader�� �߰�
		for (Emp data : empList) {
			if(dept.getLeaderNo()==data.getEmpNo()) {
				deptLeader.put(dept.getName(),data);
			}
		}
		//���̺� �߰�
		System.out.println("���̺� �߰�");
		Vector<Object> row = new Vector<>();
		row.addElement(dept.getName());
		tbModel_deptList.addRow(row);
		
		JOptionPane.showMessageDialog(this, "�߰��Ϸ�");

	}
	
	public void editDept() {
		//���� �μ� üũ
		int selectedRow = -1;
		for(int count=0 ;count<tbModel_deptList.getRowCount();count++ ) {
			if(count == table_deptList.getSelectedRow()) continue;
			if(((String)tbModel_deptList.getValueAt(count, 0)).equals(txt_inputName.getText().trim())) {
				selectedRow = count;
				break;
			}
		}
		if(selectedRow!=-1) {
			JOptionPane.showMessageDialog(this, "���� �̸��� �μ��� �̹� �����մϴ�");
			return;
		}
		
		//db ����
		Dept dept = new Dept();
		dept.setName(txt_inputName.getText().trim());
		dept.setIntro(area_inputIntro.getText());
		if(combo_inputLeader.getSelectedIndex()>0) {
			dept.setLeaderNo(Integer.parseInt(((String)combo_inputLeader.getSelectedItem()).split("_���:")[1]));
		}else {
			dept.setLeaderNo(0);
		}
		//dao.updateDept(dept)
		
		//deptList ����
		int rowNum = table_deptList.getSelectedRow();
		deptList.set(rowNum, dept);
		
		//deptLeader ����
		if(combo_inputLeader.getSelectedIndex()>0) {
			int leader = Integer.parseInt(((String)combo_inputLeader.getSelectedItem()).split("_���:")[1]);
			for (Emp data : empList) {
				if(data.getEmpNo()==leader) {
					deptLeader.put(dept.getName(), data);
				}
			}
		}else {
			deptLeader.put(dept.getName(), null);
		}
		
		//���̺� ����
		tbModel_deptList.setValueAt(txt_inputName.getText().trim(), rowNum, 0);
		
		//��Ʈ�� ����
		area_intro.setText(dept.getIntro());
		
		//�������̺� ����
		for (int i = tbModel_leader.getRowCount() - 1; i > -1; i--) {
			tbModel_leader.removeRow(i);
		}
		Emp emp = deptLeader.get(dept.getName());
		if (emp != null) {
			Vector<Object> row = new Vector<>();
			row.addElement(emp.getPosition());
			row.addElement(emp.getName());
			row.addElement(emp.getEmpNo());
			row.addElement(emp.getEmpNo());
			tbModel_leader.addRow(row);
		}
		
		JOptionPane.showMessageDialog(this, "�����Ϸ�");

	}
	
	public void deleteDept() {
		//deptList����
		int selectedRow = -1;
		for(int count=0 ;count<tbModel_deptList.getRowCount();count++ ) {
			if(((String)tbModel_deptList.getValueAt(count, 0)).equals(txt_inputName.getText().trim())) {
				selectedRow = count;
				break;
			}
		}
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "��ġ�ϴ� �μ����� ã�� ���� �����ϴ�");
			return;
		}else {
			Object[] option = {"��","�ƴϿ�"};
			table_deptList.setRowSelectionInterval(selectedRow, selectedRow);
			int selected = JOptionPane.showOptionDialog(this, "���õ� �μ��� �����Ͻðڽ��ϱ�?", "�μ�����", JOptionPane.YES_NO_OPTION
										, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
			if(selected==1) return;
		}
		
		deptList.remove(selectedRow);

		//db ����
		Dept dept = new Dept();
		dept.setName(txt_inputName.getText().trim());
		//dao.deleteDept(dept);

		//deptLeader����
		deptLeader.remove(dept.getName());

		//���̺� ����
		tbModel_deptList.removeRow(selectedRow);
		
		JOptionPane.showMessageDialog(this, "�����Ϸ�");

	}
}
