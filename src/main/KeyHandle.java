package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import entity.Player;
import tile.Map;


public class KeyHandle implements KeyListener {

	public static final int LEFT = 0;
	public static final int UP = 1;
	public static final int RIGHT = 2;
	public static final int DOWN = 3;

	public boolean up, down, left, right, moving = false, jump;
	int count = 0;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}


	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		
		if (code == KeyEvent.VK_W&&Player.jumping==false) {
			up=true;
		}
		if (code == KeyEvent.VK_A) {
			left = true;
		}
		if (code == KeyEvent.VK_D) {
			right = true;
		}
		if (code == KeyEvent.VK_F) {
			Map.changeColor();
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_W) {
			up = false;
		}
		if (code == KeyEvent.VK_A) {
			left = false;
		}
		if (code == KeyEvent.VK_D) {
			right = false;
		}

	}

}
