package util;

import java.sql.Date;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
/**
 * @brief 테이블 모델 클래스입니다.
 *        콤보박스나,체크박스,버튼 기능이 적용된 테이블 컬럼을
 *        추가로 생성자 매개변수에 넣어 사용합니다.
 * @author 이현우
 * @version v 1.01 (2020.02.25)
 * @see 
 */
public class TableModel extends DefaultTableModel{

	//테이블 타입
	private String type;
	
	//수정할 셀 컬럼 넘버
	private int colNum1=-1; 
	private int colNum2=-1;
	
	private Vector<Object> colhead;
	
	public TableModel(Vector<Object> colNames, int rows) {
		super(colNames, rows);
		colhead = colNames;
	}
	
	public TableModel(Vector<Object> colNames, int rows, int editNum) {
		// TODO Auto-generated constructor stub
		super(colNames,rows);
		colhead = colNames;
		colNum1 = editNum;
	}
	public TableModel(Vector<Object> colNames, int rows, int editNum,String t) {
		// TODO Auto-generated constructor stub
		super(colNames,rows);
		colhead = colNames;
		colNum1 = editNum;
		type = t;
	}
	
	public TableModel(Vector<Object> colNames, int rows, int editNum1, int editNum2) {
		// TODO Auto-generated constructor stub
		super(colNames,rows);
		colhead = colNames;
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
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colhead.size();		
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		if(type.equals("EmpLookup")) {
			switch(columnIndex) {
			case 0 : return String.class;
			case 1 : return Integer.class;
			case 2 : return String.class;
			case 3 : return String.class;
			case 4 : return Date.class;
			case 5 : return Integer.class;
			}
		}
		if(type.equals("Dept_emp")) {
			switch(columnIndex) {
			case 0 : return String.class;
			case 1 : return String.class;
			case 2 : return Integer.class;
			case 3 : return Integer.class;
			}
		}
		return String.class;
	}
	
	
}
