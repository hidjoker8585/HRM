package util;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
/**
 * @brief Ŀ���� ���̺������� Ŭ�����Դϴ�
 * 		   ��ư,�޺��ڽ�,üũ�ڽ� 3������ �����մϴ�
 * @author ������
 * @version v 1.00 (2020.02.14)
 * @see ������ �Ű������� ���� ���� ���� �ֽø� ����� �� �ֽ��ϴ�
 *      ��ư�� "button", �޺��ڽ��� "combo", üũ�ڽ��� "check"
 *      ����� ��ư�� ������..
 */
public class TableRenderer implements TableCellRenderer{
	
	private String type;
	
	private JButton btn;
	private JComboBox<String> combo;
	private JCheckBox check;
	
	private boolean chk;
	
	public TableRenderer(String msg) {
		// TODO Auto-generated constructor stub
		type = msg;
		if(type.equals("button")) {
			btn = new JButton();
			btn.setText("����");
			btn.setOpaque(true);
		}else if(type.equals("combo")) {
			
		}else if(type.equals("check")) {
			check = new JCheckBox();
			check.setSelected(false);
			check.setOpaque(true);
		}
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
			return combo;
		}else if(type.equals("check")){
			if (isSelected) {
				check.setBorder(BorderFactory.createMatteBorder(3, 10, 3, 10, table.getSelectionBackground()));
			} else {
				check.setBorder(BorderFactory.createMatteBorder(3, 10, 3, 10, table.getBackground()));
			}
			return check;
		}else {
			return null;
		}
	}


}
