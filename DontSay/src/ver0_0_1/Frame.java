package ver0_0_1;

import javax.swing.*;

//창만 만드는 코드(맵을 보여주는 코드는 Map.java)

public class Frame {
	private JFrame base = new JFrame();
	Frame(){
		base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		base.setTitle("미림 금칙어");
		base.setSize(1241, 856);
		base.setLayout(null);
		base.setLocationRelativeTo(null);
		base.setVisible(true);
		
//		new Opning(base);
		new Map(base);
	}
	
	JFrame getFrame() {
		return base;
	}
	
//	void startMap() {
//        new Map(base);
//    }
}
