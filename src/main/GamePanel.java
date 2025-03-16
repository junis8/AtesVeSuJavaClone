package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.Enemy;
import entity.Player;
import tile.Map;
import tile.point;

public class GamePanel extends JPanel implements Runnable {
	public ArrayList<point> copiedPoints = new ArrayList<>();
	public ArrayList<point> points = new ArrayList<>();
	public ArrayList<Integer> pointX = new ArrayList<>();
	public ArrayList<Integer> pointY = new ArrayList<>();
	public ArrayList<Integer> pointXcop = new ArrayList<>();
	public ArrayList<Integer> pointYcop = new ArrayList<>();
	public ArrayList<Enemy> enemies;

	final int originalTileSize = 8;
	final int scale = 3;
	int count = 0;

	public final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;
	public static int score = 0;
	public final static float SCALE = 0.8f;

	int FPS = 60;

	KeyHandle keyH = new KeyHandle();
	Thread gameThread;
	Player player = new Player(this, keyH);

	private final int windowWidth = 300; // Pencere genişliği
	private final int windowHeight = 200; // Pencere yüksekliği
	private final String gameOverMessage = "Oyun Bitti"; // Oyun bitti mesajı
	private final Font gameOverFont = new Font("Arial", Font.BOLD, 24); // Yazı fontu

	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;

	public GamePanel() {

		points.add(new point(120, 672, 8));
		points.add(new point(190, 672, 8));
		points.add(new point(260, 672, 8));
		points.add(new point(200, 495, 8));
		points.add(new point(270, 495, 8));
		points.add(new point(340, 495, 8));
		points.add(new point(410, 495, 8));
		for (point p : points) {
			pointX.add(p.getX());
		}
		for (point p : points) {
			pointY.add(p.getY());
		}

		for (point p : points) {
			copiedPoints.add(new point(p.getX(), p.getY(), 8));
		}

		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		setPanelSize();
		this.addKeyListener(keyH);
		this.enemies = new ArrayList<>();
		createEnemies();
		this.setFocusable(true);

	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();

	}

	private void setPanelSize() {

		Dimension size = new Dimension(720, 720);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);

	}

	private void createEnemies() {
		// Düşmanları oluştur ve listeye ekle
		enemies.add(new Enemy(600, 480, 1));
		enemies.add(new Enemy(100, 370, 2));

	}

	public void run() {

		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;

		while (gameThread != null) {
			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;

			lastTime = currentTime;

			if (delta >= 1) {

				update();
				repaint();
				delta--;
			}

			if (player.y >= 3 && player.y < 690.5 && !player.engel(player.x, player.y + 1, 24, 24)) {
				player.y += 1;

				try {
					gameThread.sleep((long) 10);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			for (int i = 0; i < 1; i++) {
				if (player.keyH.up) {
					player.jumping = true;

				}
				if (player.jumping && player.y >= 3 && player.y < 690.5
						&& !player.engel(player.x, player.y - 40, 24, 24)) {
					count++;

					if (count > 1) {
						break;
					}
					for (int j = 0; j < 30; j++) {
						if (!player.engel(player.x, player.y - 2, 24, 24)) {
							player.y -= 2;
						} else {
							break;
						}
					}

				}
			}

			if (player.engel(player.x + 1, player.y + 1, 24, 24)) {
				player.jumping = false;
				count = 0;
			}

			if (player.x <= 20 && player.y <= 160) {
				stopGame();
				showGameOverWindow();
				break;
			}
			if (player.x >= 311 && player.x <= 373 && player.y >= 665 && (Map.getColor().equals("red")||Map.getColor().equals("magenta"))) {
				restartGame();

			}
			if (player.x >= 411 && player.x <= 473 && player.y >= 665 && (Map.getColor().equals("blue")||Map.getColor().equals("magenta"))) {
				restartGame();

			}

			for (int i = 0; i < 2; i++) {
				if (enemies.get(i).checkCollision(player.x, player.y, Map.getColor())) {
					restartGame();
				}
				if (enemies.get(i).checkCollision(player.x, player.y, Map.getColor())) {
					restartGame();
				}
			}

			

			if (player.x >= 362 && player.x <= 422 && player.y >= 574 && player.y <= 600) {
				restartGame();

			}

		}

	}

	public void update() {

		player.update();
		for (Enemy enemy : enemies) {
			enemy.update();
		}
	}

	private void stopGame() {
		gameThread = null;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		Graphics2D g1 = (Graphics2D) g;
		player.draw(g2, g1);

		Label skorEtiketi = new Label("Skor: " + score);
		skorEtiketi.setForeground(Color.WHITE);
		this.add(skorEtiketi);

		g2.setColor(Color.WHITE);
		g2.setFont(new Font("Arial", Font.PLAIN, 14)); // Yazı fontunu ayarla
		g2.drawString("Skor: " + score, 650, 20); // Skoru ekrana yazdır
		for (point p : points) {
			p.draw(g2, this);
		}
		for (Enemy enemy : enemies) {
			enemy.draw(g);
		}

		g2.dispose();

	}

	private void restartGame() {

		score = 0;
		// Oyunu yeniden başlatma işlemleri
		player.setDefaultValues(); // Oyuncu konumunu sıfırla
		for (Enemy e : enemies) {
			e.setDefaultValues();
		}
		points.removeAll(points);

		for (point p : copiedPoints) {
			points.add(new point(p.getX(), p.getY(), 8));
		}
		
			pointX.removeAll(pointX);
			pointY.removeAll(pointY);
		

		for (point p : copiedPoints) {
			pointX.add(p.getX());
		}
		for (point p : copiedPoints) {
			pointY.add(p.getY());
		}

	}

	private void showGameOverWindow() {
		// Pencereyi tam ekran olarak al
		int screenWidth = this.getWidth();
		int screenHeight = this.getHeight();

		// "Oyun Bitti" penceresinin boyutlarını ayarla
		int windowX = (screenWidth - windowWidth) / 2; // X konumu
		int windowY = (screenHeight - windowHeight) / 2; // Y konumu

		// Yeni bir pencere oluştur
		JFrame gameOverFrame = new JFrame("Oyun Bitti");
		gameOverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameOverFrame.setSize(windowWidth, windowHeight);
		gameOverFrame.setLocation(windowX, windowY);
		gameOverFrame.setResizable(false);
		// "Oyun Bitti" mesajını çizmek için yeni bir panel oluştur
		JPanel gameOverPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				drawGameOverMessage(g); // "Oyun Bitti" mesajını çiz
			}
		};
		gameOverFrame.add(gameOverPanel); // Paneli pencereye ekle
		gameOverFrame.setVisible(true); // Pencereyi göster
	}

	private void changeScore(int changeAmount) {
		score += changeAmount;
		
	}

	private void drawGameOverMessage(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(gameOverFont); // Yazı fontunu ayarla
		FontMetrics fontMetrics = g2.getFontMetrics();
		int textWidth = fontMetrics.stringWidth(gameOverMessage); // Yazı genişliği
		int textHeight = fontMetrics.getHeight(); // Yazı yüksekliği
		int x = (windowWidth - textWidth) / 2; // Yazıyı ortalamak için x koordinatı
		int y = (windowHeight - textHeight) / 2 + fontMetrics.getAscent() - 20; // Yazıyı ortalamak için y koordinatı
		g2.setColor(Color.BLACK); // Yazı rengi
		g2.drawString(gameOverMessage, x, y); // Yazıyı çiz

		g2.setFont(new Font("Arial", Font.PLAIN, 14)); // Yazı fontunu ayarla
		FontMetrics scoreFontMetrics = g2.getFontMetrics();
		int scoreTextWidth = scoreFontMetrics.stringWidth("Skor: " + score); // Skor yazısının genişliği
		int scoreTextHeight = scoreFontMetrics.getHeight(); // Skor yazısının yüksekliği
		int scoreX = (windowWidth - scoreTextWidth) / 2; // Skoru ortalamak için x koordinatı
		int scoreY = y + textHeight + scoreTextHeight - 20; // Skoru ortalamak için y koordinatı
		g2.setColor(Color.BLACK); // Skor rengi
		g2.drawString("Skor: " + score, scoreX, scoreY); // Skoru çiz
	}
}