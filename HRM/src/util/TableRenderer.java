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
 * @brief 커스텀 테이블 셀 렌더러 클래스입니다
 * 		   버튼,콤보박스,체크박스 3종류를 지원합니다
 *       생성자 매개변수로 다음 값을 넘겨 주시면 사용할 수 있습니다
 *       버튼은 "button", 콤보박스는 String[] 옵션배열, 체크박스는 "check"
 * @author 이현우
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
			btn.setText("보기");
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
