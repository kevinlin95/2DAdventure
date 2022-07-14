package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    // Keyboard Shortcuts
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        // W Key
        if(code == KeyEvent.VK_W){
            upPressed = true;
        }

        // S Key
        if(code == KeyEvent.VK_S){
            downPressed = true;
        }

        // A Key
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }

        // D Key
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = false;
        }

        // S Key
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }

        // A Key
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }

        // D Key
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }

    }
}
