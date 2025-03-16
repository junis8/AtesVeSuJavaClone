package tile;

import java.awt.Color;
import java.awt.Graphics2D;


import main.GamePanel;

public class point {
    private int x;
    private int y;
    private int size;

    public point(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size; 
        
    }

    public void draw(Graphics2D g2d, GamePanel gamePanel) {
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(x, y, size, size);
    }

    public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	

}