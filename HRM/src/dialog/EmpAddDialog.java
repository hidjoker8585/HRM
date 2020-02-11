package dialog;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * @brief 사원 등록 다이얼로그
 * @author 박영훈
 * @version v1.00 2020.02.11
 * @see none
 */
public class EmpAddDialog extends JDialog{
	
	public EmpAddDialog(JFrame f, String msg, boolean modal) {
		// TODO Auto-generated constructor stub
		super(f,msg,modal);
		
		setSize(new Dimension(660,880)); //다이얼로그 크기
		setLocationRelativeTo(null); //가운데 위치
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //닫기

	}
}
