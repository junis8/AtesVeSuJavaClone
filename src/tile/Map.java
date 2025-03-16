package tile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import main.GamePanel;
import main.KeyHandle;

public class Map {
	public ArrayList<Collision> collisionArray = new ArrayList<Collision>();
	private GamePanel gamePanel;
	public KeyHandle keyH;
	public static Graphics2D g2d;
	public Graphics2D g2D;
	static int count1;

	point p = new point(200, 500, 3);

	public Map(GamePanel gamePanel, KeyHandle keyH) {

		this.gamePanel = gamePanel;
		this.keyH = keyH;

		collisionArray.add(new Collision(0, 690, 720, 30));
		collisionArray.add(new Collision(663, 640, 60, 40));
		collisionArray.add(new Collision(0, 600, 200, 23));
		collisionArray.add(new Collision(270, 600, 338, 25));
		collisionArray.add(new Collision(80, 510, 720, 25));
		collisionArray.add(new Collision(0, 400, 620, 25));
		collisionArray.add(new Collision(0, 550, 25, 25));
		collisionArray.add(new Collision(0, 300, 40, 100));
		collisionArray.add(new Collision(640, 470, 70, 45));
		collisionArray.add(new Collision(670, 445, 50, 25));
		collisionArray.add(new Collision(40, 350, 40, 50));
		collisionArray.add(new Collision(85, 260, 720, 25));
		collisionArray.add(new Collision(0, 160, 520, 25));
		collisionArray.add(new Collision(550, 200, 90, 20));
		collisionArray.add(new Collision(680, 230, 40, 30));
	}

	public ArrayList<Collision> getCollisionArray() {
		return collisionArray;
	}

	public void setCollisionArray(ArrayList<Collision> collisionArray) {
		this.collisionArray = collisionArray;
	}

	public void draw2(Graphics2D g1) {

		g1.setColor(Color.WHITE);
		g1.fillRect(0, 690, 720, 30);
		g1.fillRect(660, 640, 60, 60);
		g1.fillRect(0, 600, 200, 25);
		g1.fillRect(270, 600, 338, 25);
		g1.fillRect(80, 510, 720, 25);
		g1.fillRect(0, 400, 620, 25);
		g1.fillRect(0, 550, 25, 25);
		g1.fillRect(640, 470, 80, 45);
		g1.fillRect(670, 445, 50, 25);
		g1.fillRect(0, 300, 40, 100);
		g1.fillRect(40, 350, 40, 50);
		g1.fillRect(85, 260, 720, 25);
		g1.fillRect(0, 160, 520, 25);
		g1.fillRect(550, 200, 90, 20);
		g1.fillRect(680, 230, 40, 30);

		g1.setColor(Color.BLUE);
		// x y uznlk gnslk
		g1.fillRect(330, 690, 45, 20);

		g1.setColor(Color.RED);
		// x y uznlk gnslk
		g1.fillRect(430, 690, 45, 20);

		g1.setColor(Color.GREEN);
		// x y uznlk gnslk
		g1.fillRect(380, 600, 45, 20);

		g1.setColor(Color.PINK);
		// x y uznlk gnslk
		g1.fillRect(0, 60, 20, 100);
	}

	public static void changeColor() {
		count1++;
	}

	public void draw(Graphics2D g2, int x, int y) {

		if (count1 == 3) {
			count1 = 0;
		}

		if (count1 == 0) {
			g2.setColor(Color.BLUE);

		}
		if (count1 == 1) {
			g2.setColor(Color.RED);

		}
		if (count1 == 2) {
			g2.setColor(Color.MAGENTA);

		}

		this.g2D = g2;
		g2D.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
	}

	public static String getColor() {

		if (count1 == 0) {
			return "blue";
		} else if (count1 == 1) {
			return "red";
		} else {
			return "magenta";
		}
	}

}
