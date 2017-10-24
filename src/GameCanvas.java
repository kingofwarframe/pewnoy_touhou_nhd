import bases.GameObject;
import touhou.Enemy.Enemy;
import touhou.Enemy.EnemyBullet;
import touhou.Player.Player;
import touhou.Enemy.EnemySpawner;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameCanvas extends JPanel {



    public  int backY = 2509;
    BufferedImage backBuffer;
    Graphics backGraphics;

    BufferedImage background;
    Player player = new Player();

    GameObject enemy = new Enemy();



    public GameCanvas() {

        //1 tao back buffer
        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();
        //2. Load Background
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("adding player");
        GameObject.add(player);
        GameObject.add(new EnemySpawner());
        GameObject.add(enemy);
    }

    public void render() {
        //1 Draw everything on back buffer
        backGraphics.drawImage(background, 0, backY, null);
      GameObject.renderAll(backGraphics);
        if (backY <= 0 ){
            backY += 5;
        }
        else {
            backY += -2509;
        }

        //2 call repaint
        repaint();
    }
    //3 Draw Background


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }

    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);


    }

    public void keyReleased(KeyEvent e) {

        player.keyReleased(e);

    }

    public void run() {
        GameObject.runAll();
    }

}
