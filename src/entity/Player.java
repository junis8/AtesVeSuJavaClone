package entity;

import java.awt.Graphics2D;
import main.GamePanel;
import main.KeyHandle;
import tile.Map;


public class Player extends Entity {

	public static Graphics2D g2d;
	public Graphics2D g2D;
	private GamePanel gamePanel;
	private Map map;
	public KeyHandle keyH;
	

	public static int count1 = 0;
	public static boolean jumping = false;

	public Player(GamePanel gamePanel, KeyHandle keyH) {
		this.gamePanel = gamePanel;
		this.keyH = keyH;
		setDefaultValues();
		map = new Map(gamePanel, keyH);

	}

	public void setDefaultValues() {

		x = 2;
		y = 666;
		speed = 2;
		
	}

	public void update() {
		if (keyH.left && !engel(x - 2, y, gamePanel.tileSize, gamePanel.tileSize) && x >= 3) {
			x -= speed;
			checkPoint();			
		}
		if (keyH.right && !engel(x + 2, y, 24, 24) && x < 690.5) {
			x += speed;
			checkPoint();
		}
	}

	public boolean engel(int kareX, int kareY, int kareGenislik, int kareYukseklik) {

		boolean sonuc = false;
		for (int i = 0; i < 15; i++) {
			sonuc = map.collisionArray.get(i).carpistiMi(kareX, kareY, kareGenislik, kareYukseklik);
			if (sonuc == true) {
				return sonuc;
			}
		}
		return sonuc;
	}
	
	public void checkPoint() {
		for (int i = 0; i < gamePanel.pointX.size(); i++) {
			if (x+8==gamePanel.pointX.get(i)&&y+6==gamePanel.pointY.get(i)) {
				gamePanel.score+=5;
				gamePanel.pointX.remove(i);
				gamePanel.pointY.remove(i);
				gamePanel.points.remove(i);
			}
			if (x+10==gamePanel.pointX.get(i)&&y+9==gamePanel.pointY.get(i)) {
				gamePanel.score+=5;
				gamePanel.pointX.remove(i);
				gamePanel.pointY.remove(i);
				gamePanel.points.remove(i);
			}
		}
		
	}

	public void draw(Graphics2D g2, Graphics2D g1) {

		map.draw(g2, x, y);
		map.draw2(g1);

	}
}
