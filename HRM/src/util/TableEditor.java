package util;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
/**
 * @brief ���̺� �� ������ Ŭ�����Դϴ�
 *     	   ��ư,�޺��ڽ�,üũ�ڽ� 3������ �����մϴ�
 *       ������ �Ű������� ���� ���� �Ѱ� �ֽø� ����� �� �ֽ��ϴ�
 *       ��ư�� "button", �޺��ڽ��� String[] ��Ϲ迭, üũ�ڽ��� "check"
 * @author ������
 * @version v 1.01 (2020.02.15)
 * @see 
 *      
 */
public class TableEditor extends AbstractCellEditor implements TableCellEditor, ActionListener{

	private String type;

	private JComboBox<String> combo;
	private JCheckBox check;
	private JButton button;
	
	private int empNo;
	
	public TableEditor(String msg){
		// TODO Auto-generated constructor stub
		type = msg;
		if (type.equals("button")) {
			button = new JButton();
			button.setOpaque(true);
			button.addActionListener(this);
		}else if(type.equals("check")) {
			check = new JCheckBox();
			check.setHorizontalAlignment(JLabel.CENTER);
			check.addActionListener(this);
		}
	}
	
	public TableEditor(String[] strArr){
		// TODO Auto-generated constructor stub
		type = "combo";
		combo = new JComboBox<String>(strArr);
		combo.setOpaque(true);	
		combo.addActionListener(this);
		((JLabel)combo.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		if(type.equals("button")) {
			JOptionPane.showMessageDialog(button,"��ư ����! "+empNo);
			return empNo;
		}else if(type.equals("combo")) {
			JOptionPane.showMessageDialog(combo, "�޺�����"+combo.getSelectedItem());
			return (String)combo.getSelectedItem();
		}else if(type.equals("check")) {
			JOptionPane.showMessageDialog(check,"üũȮ�� "+check.isSelected());
			return check.isSelected();
		}else {
			return null;
		}
	}


	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
			int column) {
		if (value == null || value.equals("")) {
			return null;
		} else if(type.equals("button")){
			// TODO Auto-generated method stub
			empNo = (int) value;
			button.setText("����");
			return button;
		}else if(type.equals("combo")) {
			combo.setSelectedItem((String)value);
			return combo;
		}else if(type.equals("check")) {
			check.setBackground(table.getSelectionBackground());
			check.setSelected((boolean)value);
			return check;
		}else {
			return null;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		fireEditingStopped();

	}

}
