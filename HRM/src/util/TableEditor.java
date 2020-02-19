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
 * @brief 테이블 셀 에디터 클래스입니다
 *     	   버튼,콤보박스,체크박스 3종류를 지원합니다
 *       생성자 매개변수로 다음 값을 넘겨 주시면 사용할 수 있습니다
 *       버튼은 "button", 콤보박스는 String[] 목록배열, 체크박스는 "check"
 * @author 이현우
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
			JOptionPane.showMessageDialog(button,"버튼 눌림! "+empNo);
			return empNo;
		}else if(type.equals("combo")) {
			JOptionPane.showMessageDialog(combo, "콤보선택"+combo.getSelectedItem());
			return (String)combo.getSelectedItem();
		}else if(type.equals("check")) {
			JOptionPane.showMessageDialog(check,"체크확인 "+check.isSelected());
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
			button.setText("보기");
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
