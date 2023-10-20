package ver0_0_1;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.*;

//맵이 바뀌는 것을 판단하고 보여주는 코드.
//Frame.java의 JFrame에 배경 컴포넌트를 add시키는 방식으로 진행.

public class Opning {
	private JPanel background;
	private String imagePath = "images/";
	private int storyNum = 0;
	
	private String sceneName[] = {
			"001.png",
			"002.png"
	};
	private Frame frame;
	//맵이 생길때마다 여기 하나씩 추가.
	private ImageIcon story[] = {
			new ImageIcon(imagePath + sceneName[0]),
			new ImageIcon(imagePath + sceneName[1]),
			new ImageIcon(imagePath + "yes.png"),
			new ImageIcon(imagePath + "yes.png"),
			new ImageIcon(imagePath + "yes.png")
	};
	
	Opning(JFrame bg){
		for(int i = 0; i < sceneName.length; i++) {
			File img = new File(imagePath + sceneName[i]);
			if(!img.isFile()) {
				JOptionPane.showMessageDialog(null, sceneName[i] + "가(이) 존재하지 않습니다.", "이미지 로딩 오류", 1);
			}
		}
		
		background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(story[storyNum].getImage(), 0, 0, this);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        
        bg.setContentPane(background);
        bg.setVisible(true);
        
     // MouseListener를 구현한 리스너 객체 생성
        MouseListener opningMouse = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if (storyNum + 1 >= sceneName.length - 1) {
            		new Map(bg);
            	}
        		nextStory(bg);
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
        background.addMouseListener(opningMouse);
	}
	
	//다음 맵
	void nextStory(JFrame bg) {
		storyNum++;
		background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(story[storyNum].getImage(), 0, 0, this);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        bg.setContentPane(background);
        bg.setVisible(true);
	}
	
	//이전 맵
	void previousStory(JFrame bg) {
		storyNum--;
		background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(story[storyNum].getImage(), 0, 0, this);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        bg.setContentPane(background);
        bg.setVisible(true);
	}
	
	JPanel getJPanel() {
		return background;
	}
	
}
