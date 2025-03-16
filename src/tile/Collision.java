package tile;

import java.util.ArrayList;

public class Collision {
	private int x, y, width, height;
	 ArrayList<Collision> collisionArray = new ArrayList<Collision>();
	 
	    
	 public Collision(int x, int y, int width, int height) {
	        this.x = x;
	        this.y = y;
	        this.width = width;
	        this.height = height;
	    }

	    public boolean carpistiMi(int kareX, int kareY, int kareGenislik, int kareYukseklik) {
	        // Kare ve engel arasında çarpışma kontrolü
	        return kareX + kareGenislik > x && 
	               kareX < x + width && 
	               kareY + kareYukseklik > y && 
	               kareY < y + height;
	    }
	    
	 
	}
