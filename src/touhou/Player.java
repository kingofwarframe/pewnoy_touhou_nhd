package touhou;

import bases.GameObject;
import bases.Utils;

import javax.rmi.CORBA.Util;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {


    boolean rightPressed;
    boolean upPressed;
    boolean downPressed;
    boolean leftPressed;
    boolean xPressed;
    final int Speed = 5;
    final int Left = 0;
    final int Right = 354;
    final int Top = 0;
    final int Bottom = 500;
    long shootingTimer = System.nanoTime();
    long delay = 200;
    public Player(){
          x = 354;
          y = 500;
        image = Utils.loadImage("assets/images/players/straight/touhou resize.png");
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
        if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = true;
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
        if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = false;
        }

    }
    public void run() {
        move();
        shoot();

    }

    private void move() {
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

    public void shoot(){
        if (xPressed) {
            long shoot = (System.nanoTime() - shootingTimer) / 2000000;
            if(shoot >delay) {
                {
                    PlayerSpell newSpell = new PlayerSpell();
                    newSpell.x = x;
                    newSpell.y = y;
                    GameObject.add(newSpell);
                    shootingTimer = System.nanoTime();
                }
            }}

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
