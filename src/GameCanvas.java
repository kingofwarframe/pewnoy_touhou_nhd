import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    BufferedImage backgroud, player;
    int playerX = 384;
    int playerY = 500;
    boolean rightPressed;
    boolean upPressed;
    boolean downPressed;
    boolean leftPressed;
    BufferedImage backBuffer;
    Graphics backGraphics;
    public GameCanvas() {
        //1 tao back buffer
        backBuffer = new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();
        //2. Load Background
        try {
            backgroud = ImageIO.read(new File("assets/images/background/0.png"));
            player = ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void render(){
        //1 Draw everything on back buffer
        backGraphics.drawImage(backgroud, 204, 0, null);
        backGraphics.drawImage(player, playerX, playerY, null);
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
    public void run(){
        int vy = 0;
        int vx = 0;
        if (rightPressed){
            vx += 5;
        }
        if (leftPressed){
            vx -= 5;
        }
        if (upPressed){
            vy -=5;
        }
        if (downPressed){
            vy +=5;
        }
        playerY = playerY + vy;
        playerX = playerX + vx;
    }
}
