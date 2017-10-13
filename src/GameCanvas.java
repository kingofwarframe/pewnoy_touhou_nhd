import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    BufferedImage backgroud, player;
    int playerX = 354;
    int playerY = 500;
    int backY = -2585;
    int enemyY = 40;
    boolean rightPressed;
    boolean upPressed;
    boolean downPressed;
    boolean leftPressed;
    BufferedImage backBuffer;
    Graphics backGraphics;
    BufferedImage enemy;
    public GameCanvas() {
        //1 tao back buffer
        backBuffer = new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();
        //2. Load Background
        try {
            backgroud = ImageIO.read(new File("assets/images/background/0.png"));
            player = ImageIO.read(new File("assets/images/players/straight/0.png"));
            enemy = ImageIO.read(new File("assets/images/enemies/level0/pink/1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void render(){
        //1 Draw everything on back buffer
        backGraphics.drawImage(backgroud, 0, backY, null);
        backGraphics.drawImage(player, playerX, playerY, null);
        backGraphics.drawImage(enemy,20,enemyY,null);
        //2 call repaint
        repaint();
    }
    //3 Draw Background


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer,0,0,null);
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_RIGHT ){
            rightPressed =  true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            downPressed = true;

        }

    }

    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode()== KeyEvent.VK_RIGHT ){
            rightPressed =  false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            downPressed = false;

        }
    }
    public void run() {
        int vy = 0;
        int vx = 0;
        if (rightPressed) {
            if (playerX < 354) {
                vx += 5;
            }

        }
        if (leftPressed) {
            if (playerX > 0) {
                vx -= 5;
            }
        }
        if (upPressed) {
            if (playerY > 0) {
                vy -= 5;
            }
        }
        if (downPressed) {
            if (playerY < 524) {
                vy += 5;
            }
        }
        if (backY == 0) {
            backY -= 2595;
        } else {
            backY += 5;
        }
        // Hình như logic của em bị sai :(. Anh xem xong hộ em đoạn này nhé.

            if (enemyY<=40) {
                enemyY += 10;
            } else{
                enemyY --;
            }


            playerY = playerY + vy;
            playerX = playerX + vx;

        }
    }
