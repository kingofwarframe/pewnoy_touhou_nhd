package touhou.Player;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.physics.BoxCollider;

import java.awt.event.KeyEvent;

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
    public BoxCollider boxCollider;
    public Player(){
          position.set(384,500);
          this.boxCollider = new BoxCollider(10,10);
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
    Vector2D velocity = new Vector2D();
    private void move() {
        velocity.set(0,0);
        if (rightPressed) {

            velocity.x += Speed;


        }
        if (leftPressed) {

            velocity.x -= Speed;

        }
        if (upPressed) {

            velocity.y -= Speed;

        }
        if (downPressed) {

            velocity.y += Speed;

        }
        position.addUp(velocity);


        position.x = (int)clamp(position.x, Left, Right);
        position.y = (int)clamp(position.y, Top, Bottom);
    }

    public void shoot(){
        if (xPressed) {
            long shoot = (System.nanoTime() - shootingTimer) / 2000000;
            if(shoot >delay) {
                {
                    PlayerSpell newSpell = new PlayerSpell();
                    newSpell.position.set(this.position);
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

    public void getHit() {
        isActive = false;
    }
}
