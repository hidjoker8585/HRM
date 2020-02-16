package util;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;
/**
 * @brief 테이블 모델 클래스입니다.
 *        콤보박스나,체크박스,버튼 기능이 적용된 테이블 컬럼을
 *        추가로 생성자 매개변수에 넣어 사용합니다.
 * @author 이현우
 * @version v 1.00 (2020.02.15)
 * @see 
 */
public class TableModel extends DefaultTableModel{

	//수정할 셀 컬럼 넘버
	private int colNum1=-1; 
	private int colNum2=-1;
	
	public TableModel(Vector<Object> colNames, int rows) {
		super(colNames, rows);
	}
	
	public TableModel(Vector<Object> colNames, int rows, int editNum) {
		// TODO Auto-generated constructor stub
		super(colNames,rows);
		colNum1 = editNum;
	}
	
	public TableModel(Vector<Object> colNames, int rows, int editNum1, int editNum2) {
		// TODO Auto-generated constructor stub
		super(colNames,rows);
		colNum1 = editNum1;
		colNum2 = editNum2;
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		if(column==colNum1) return true;
		if(column==colNum2) return true;
		return false;
	}
}
