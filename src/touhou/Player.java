package touhou;

import bases.Utils;

import javax.rmi.CORBA.Util;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player {
    int x = 354;
    int y = 500;
    BufferedImage  image;
    boolean rightPressed;
    boolean upPressed;
    boolean downPressed;
    boolean leftPressed;
    final int Speed = 5;
    final int Left = 0;
    final int Right = 354;
    final int Top = 0;
    final int Bottom = 500;
    public Player(){
        image = Utils.loadImage("assets/images/players/straight/touhou resize.png");
    }
    public void render(Graphics backGraphics){
        backGraphics.drawImage(image, x, y, null);
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;

        }

    }

    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;

        }
    }
    public void run() {
        int vy = 0;
        int vx = 0;
        if (rightPressed) {

            vx += Speed;


        }
        if (leftPressed) {

            vx -= Speed;

        }
        if (upPressed) {

            vy -= Speed;

        }
        if (downPressed) {

            vy += Speed;

        }


        y = y + vy;
        x = x + vx;
        x = (int)clamp(x, Left, Right);
        y = (int)clamp(y, Top, Bottom);
    }
    private float clamp(float value, float min, float max){
        if (value < min){
            return  min;
        }
        if (value > max){
            return max;
        }
        return value;
    }
}
