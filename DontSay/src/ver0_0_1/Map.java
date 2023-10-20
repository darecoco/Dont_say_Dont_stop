package ver0_0_1;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//맵이 바뀌는 것을 판단하고 보여주는 코드.
//Frame.java의 JFrame에 배경 컴포넌트를 add시키는 방식으로 진행.

public class Map {
	private JPanel background;
	private String imagePath = "images/";
	private static int mapNum = 0;
	
	private String mapName[] = {
			"001.png",
			"002.png",
			"003.png",
			"004.png",
			"005.png",
			"006.png",
			"007.png",
			"008.png",
			"009.png",
			"010.png"
	};
	
	//맵이 생길때마다 여기 하나씩 추가.
	private ImageIcon map[] = {
			new ImageIcon(imagePath + mapName[0]),
			new ImageIcon(imagePath + mapName[1]),
			new ImageIcon(imagePath + mapName[2]),
			new ImageIcon(imagePath + mapName[3]),
			new ImageIcon(imagePath + mapName[4]),
			new ImageIcon(imagePath + mapName[5]),
			new ImageIcon(imagePath + mapName[6]),
			new ImageIcon(imagePath + mapName[7]),
			new ImageIcon(imagePath + mapName[8]),
			new ImageIcon(imagePath + mapName[9])
	};
	
	Map(JFrame bg){
		for(int i = 0; i < mapName.length; i++) {
			File img = new File(imagePath + mapName[i]);
			if(!img.isFile()) {
				JOptionPane.showMessageDialog(null, mapName[i] + "가(이) 존재하지 않습니다.", "이미지 로딩 오류", 1);
			}
		}
		
		background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(map[mapNum].getImage(), 0, 0, this);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        
        previousMap(bg);
        bg.setContentPane(background);
        bg.setVisible(true);
        
     // MouseListener를 구현한 리스너 객체 생성
        MouseListener mapMouse = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 마우스 클릭 이벤트 처리
                new Move(bg);
//                new Teacher(background);
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
        bg.addMouseListener(mapMouse);
        
	}// Map()
	
	//다음 맵
	void nextMap(JFrame bg) {
		mapNum++;
		background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(map[mapNum].getImage(), 0, 0, this);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        bg.setContentPane(background);
        bg.setVisible(true);
	}
	
	//이전 맵
	void previousMap(JFrame bg) {
		mapNum--;
		background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(map[mapNum].getImage(), 0, 0, this);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        bg.setContentPane(background);
        bg.setVisible(true);
	}
	
	int getMapNum() {
		return mapNum;
	}
}
