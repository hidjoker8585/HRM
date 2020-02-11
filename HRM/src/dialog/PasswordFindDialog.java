package dialog;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * @brief
 * @author 
 * @version 
 * @see 
 */
public class PasswordFindDialog extends JDialog{
	public PasswordFindDialog(JFrame f, String msg, boolean modal) {
		// TODO Auto-generated constructor stub
		super(f,msg,modal);
		
		setSize(new Dimension(880,660)); //다이얼로그 크기
		setLocationRelativeTo(null); //가운데 위치
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //닫기

	}
}
