package dialog;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;

import main.MainFrame;


/**
 * @brief
 * @author 
 * @version 
 * @see 
 */
public class AboutDialog extends JDialog{

	public AboutDialog(JFrame f, String msg, boolean modal) {
		// TODO Auto-generated constructor stub
		super(f,msg,modal);
		
		setSize(new Dimension(880,660)); //다이얼로그 크기
		setLocationRelativeTo(null); //가운데 위치
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //닫기
		setResizable(false); //크기 조정


		
	}

}
