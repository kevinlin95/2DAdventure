package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //Screen Settings
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3; // scaling tile

    final int tileSize = originalTileSize * scale; // 48x48 tile
    // 4 by 3 ratio || 16 x 12 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread(){
        // constructing a new thread here and referencing it will automatically call run();
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // as long as gameThread exists, game will run, main loop
        while(gameThread !=  null){
            System.out.println("The game loop is running!");

            // update() is used to update character information, etc
            update();

            // paintComponent() to draw the screen with the updated information
            repaint();
        }
    }

    public void update(){

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.WHITE);

        g2.fillRect(100, 100, tileSize, tileSize);

        g2.dispose();
    }
}
