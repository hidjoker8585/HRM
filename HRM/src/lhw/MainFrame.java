package lhw;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class MainFrame extends Frame{

	private Button btn;
	public MainFrame() {
		// TODO Auto-generated constructor stub
		
		btn = new Button("¹öÆ°1");
		setLayout(new FlowLayout());
		add(btn);
		setBounds(100,100,1280,768);
		setVisible(true);
	}
	
}
