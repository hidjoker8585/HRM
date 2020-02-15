package util;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
/**
 * @brief Ŀ���� ���̺� �� ������ Ŭ�����Դϴ�
 * 		   ��ư,�޺��ڽ�,üũ�ڽ� 3������ �����մϴ�
 *       ������ �Ű������� ���� ���� �Ѱ� �ֽø� ����� �� �ֽ��ϴ�
 *       ��ư�� "button", �޺��ڽ��� String[] �ɼǹ迭, üũ�ڽ��� "check"
 * @author ������
 * @version v 1.01 (2020.02.15)
 * @see 
 */
public class TableRenderer implements TableCellRenderer{
	
	private String type;
	
	private JButton btn;
	private JComboBox<String> combo;
	private JCheckBox check;
		
	public TableRenderer(String msg) {
		// TODO Auto-generated constructor stub
		type = msg;
		if(type.equals("button")) {
			btn = new JButton();
			btn.setText("����");
			btn.setOpaque(true);
		}else if(type.equals("check")) {
			check = new JCheckBox();
			check.setHorizontalAlignment(JLabel.CENTER);
			check.setOpaque(true);
		}	
	}
	
	public TableRenderer(String[] strArr) {
		// TODO Auto-generated constructor stub
		type = "combo";
		combo = new JComboBox<String>(strArr);
		combo.setOpaque(true);
		((JLabel)combo.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		if (value == null) {
			return null;
		} else if(type.equals("button")) {
			if (isSelected) {
				btn.setBorder(BorderFactory.createMatteBorder(3, 10, 3, 10, table.getSelectionBackground()));
			} else {
				btn.setBorder(BorderFactory.createMatteBorder(3, 10, 3, 10, table.getBackground()));
			}
			return btn;
		}else if(type.equals("combo")) {
			if(isSelected) {
				combo.setForeground(table.getSelectionForeground());
				combo.setBackground(table.getSelectionBackground());
			}else {
				combo.setForeground(table.getForeground());
				combo.setBackground(table.getBackground());
			}
			combo.setSelectedItem((String)value);
			return combo;
		}else if(type.equals("check")){
			if (isSelected) {
				check.setForeground(table.getSelectionForeground());
				check.setBackground(table.getSelectionBackground());
			} else {
				check.setForeground(table.getForeground());
				check.setBackground(table.getBackground());
			}
			check.setSelected((boolean)value);
			return check;
		}else {
			return null;
		}
	}


}
