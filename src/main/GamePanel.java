package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // Screen Settings
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 1; // scaling tile
    public final int tileSize = originalTileSize * scale; // 16 tile
    // 4 by 4 ratio || 50 x 50 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 2500px
    public final int screenHeight = tileSize * maxScreenRow; // 2500px

    // World Settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    // Frames per second
    final double FRAMES_PER_SECOND = 60.0;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public Player player = new Player(this, keyH);


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    // Do not touch, needed to run game
    public void startGameThread(){
        // constructing a new thread here and referencing it will automatically call run();
        gameThread = new Thread(this);
        gameThread.start();
    }
    // Do not touch, needed to run game
    @Override
    public void run() {
        // as long as gameThread exists, game will run, main loop

        double drawInterval = 1000000000/FRAMES_PER_SECOND; // 0.01666 seconds, repeating of course.
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread !=  null){

            // update() is used to update character information, etc
            update();

            // paintComponent() to draw the screen with the updated information
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // do not touch
    public void update(){

        player.update();
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);

        player.draw(g2);

        g2.dispose();
    }
}
