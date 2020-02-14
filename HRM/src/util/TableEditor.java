package util;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
/**
 * @brief Ŀ���� ���̺������� Ŭ�����Դϴ�
 *     	   ��ư,�޺��ڽ�,üũ�ڽ� 3������ �����մϴ�
 * @author ������
 * @version v 1.00 (2020.02.14)
 * @see ������ �Ű������� ���� ���� ���� �ֽø� ����� �� �ֽ��ϴ�
 *      ��ư�� "button", �޺��ڽ��� "combo", üũ�ڽ��� "check"
 *      ����� ��ư�� ������..
 */
public class TableEditor extends AbstractCellEditor implements TableCellEditor, ActionListener{

	private String type;

	private JComboBox<String> combo;
	private JCheckBox check;
	private JButton button;
	
	private boolean chk;
	private int empNo;
	
	
	public TableEditor(String msg){
		// TODO Auto-generated constructor stub
		type = msg;
		if (type.equals("button")) {
			button = new JButton();
			button.setOpaque(true);
			button.addActionListener(this);
		}else if(type.equals("combo")) {
			combo = new JComboBox<String>();
		}else if(type.equals("chk")) {
			check = new JCheckBox();
			check.setSelected(false);
			check.addActionListener(this);
		}
	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		if(type.equals("button")) {
			JOptionPane.showMessageDialog(button,"��ư ����! "+empNo);
			return empNo;
		}else if(type.equals("combo")) {
			return null;
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
			if (isSelected) {
				button.setBorder(BorderFactory.createMatteBorder(3, 10, 3, 10, table.getSelectionBackground()));
			} else {
				button.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, table.getBackground()));
			}
			empNo = (int) value;
			button.setText("����");
			return button;
		}else if(type.equals("check")) {
			if(isSelected) {

			}else {
				
			}
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
