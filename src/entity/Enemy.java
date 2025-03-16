package entity;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Entity implements Runnable {
	private int start_x;
	private int start_y;
	private int num = 0;
	public int bound1 = 0;
	public int bound2 = 0;
	private int size = 30;
	private float speed = 1;
	private boolean movingRight = true;
	private boolean running = true;
	int count = 0;
	String colorString1 = "";
	String colorString2 = "";

	public Enemy(int x, int y, int num) {
		this.x = x;
		this.y = y;
		start_y = y;
		start_x = x;
		this.num = num;
	}

	public void draw(Graphics g) {

		count++;

		if (count == 1000) {
			count = 0;
		}

		if (num == 1) {
			if (count < 500) {
				g.setColor(Color.RED);
				colorString1 = "red";
			}
			if (count >= 500 && count < 1000) {
				g.setColor(Color.BLUE);
				colorString1 = "blue";
			}
		}
		if (num == 2) {
			if (count < 500) {
				g.setColor(Color.BLUE);
				colorString2 = "blue";
			}
			if (count >= 500 && count < 1000) {
				g.setColor(Color.RED);
				colorString2 = "red";
			}
		}

		g.fillRect(x, y, size, size);
	}

	public void update() {
		if (movingRight) {
			x += speed;
		} else {
			x -= speed;
		}
		if (num == 1) {
			if (x <= 82 || x >= 638 - size) {
				movingRight = !movingRight;
			}
		}
		if (num == 2) {
			if (x <= 82 || x >= 617 - size) {
				movingRight = !movingRight;
			}
		}
	}

	public void setDefaultValues() {
		x = start_x;
		y = start_y;
	}

	public boolean checkCollision(int playerX, int playerY, String playerColor) {
		if (x + 30 > playerX && x < playerX + 24 && y + 30 > playerY && y < playerY + 24) {

			if (num==1) {
				if(!playerColor.equals(colorString1))
				return true;
			}
			if (num==2) {
				if(!playerColor.equals(colorString2))
				return true;
			}

		}
		return false;
	}

	@Override
	public void run() {
		while (running) {
			update();
			try {
				Thread.sleep(70); // Hareket hızı
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public void stop() {
		running = false;
	}
}