package ver0_0_1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Lv.1 은주쌤, 보경쌤

public class Teacher {
	private String script[] = {
			"학생 1: 쌤 이번에 배운 내용이 잘 이해가 안돼요 ㅠㅠ",
			"A쌤 : 어… 그건 말이지~",
			"친구 1 : 똑똑똑",
			"A쌤 : 어 들어와~",
			"친구 1 : 쌤 여쭙게 있어서요 혹시 들어가도 될까요?",
			"A쌤 : 어 그래, 학생 1아 나중에 알려줘도 될까?",
			"학생 1: 아 네 괜찮아요, 안녕히계세요.",
			"친구 1 : 쌤, 이번에 학교에서 행사 있다고 들었어요! 언제 시작하는 거예요?",
			"A쌤 : 아~ 그건 이번 10월달 즈음에 시작해.",
			"친구 1 : 아 넵, 알겠습니다.",
			"A쌤 : 어… 근데 친구 1아 지금 시간이 …",
			"미림 : 친구 1아 곧 수업 준비 해야 돼서 빨리 올라가야 돼!",
			"친구 1 : 아 빨리 올라가야겠다! 가자 미림아 시간 내주셔서 감사합니다. 선생님!"
	};
	private JLabel text = new JLabel();
	int t = 0;
	private JFrame frame;
	private JPanel panel;
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton checkButton;
    private int num1, num2;
    private String result="함기훈";
	
	Teacher(JFrame bg){
		text.setBounds(50, 500, 1200, 80);
		text.setText(script[t++]);
		bg.add(text);
		bg.repaint();
		// MouseListener를 구현한 리스너 객체 생성
        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	
            	
                
//                checkButton = new JButton("확인");
//                panel.add(checkButton);
            	if(t >= script.length - 1) {
            		JTextField answer = new JTextField();
	            	answer.setHorizontalAlignment(JTextField.CENTER);
	            	answer.setBounds(50,550,180,30);
	                bg.add(answer);
	                bg.repaint();
	                answer.addKeyListener(new KeyAdapter() {
	                   @Override
	                   public void keyPressed(KeyEvent e) {
	                      if(e.getKeyCode() == KeyEvent.VK_ENTER) {
	                         String are = answer.getText();
	                         if(result.equals(are)) {
	                        	 text.setText("정답입니다!");
	                        	 text.setLocation(50, 450);
	                        	 bg.repaint();
	                         }
	                      }
	                   }
	                });
            	}else {
            		text.setText(script[t++]);
            	}
            }

            // 나머지 MouseListener 메서드 구현
            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        
     // 패널에 마우스 리스너 추가
        bg.addMouseListener(mouseListener);
       
	}
}
