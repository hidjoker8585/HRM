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
public class EmpDetailDialog extends JDialog{
	public EmpDetailDialog(JFrame f, String msg, boolean modal) {
		// TODO Auto-generated constructor stub
		super(f,msg,modal);
		
		setSize(new Dimension(660,880)); //���̾�α� ũ��
		setLocationRelativeTo(null); //��� ��ġ
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //�ݱ�
		
	}
}
