package util;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
/**
 * @brief 커스텀 테이블셀렌더러 클래스입니다
 * 		   버튼,콤보박스,체크박스 3종류를 지원합니다
 * @author 이현우
 * @version v 1.00 (2020.02.14)
 * @see 생성자 매개변수로 다음 설정 값을 주시면 사용할 수 있습니다
 *      버튼은 "button", 콤보박스는 "combo", 체크박스는 "check"
 *      현재는 버튼만 구현중..
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
			btn.setText("보기");
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
