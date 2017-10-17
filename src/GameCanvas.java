import touhou.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {



    int enemyY = 40;

    BufferedImage backBuffer;
    Graphics backGraphics;
    BufferedImage enemy;
    BufferedImage backgroud;
    Player player = new Player();
    public GameCanvas() {
        //1 tao back buffer
        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();
        //2. Load Background
        try {
            backgroud = ImageIO.read(new File("assets/images/background/0.png"));

            enemy = ImageIO.read(new File("assets/images/enemies/level0/pink/1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void render() {
        //1 Draw everything on back buffer
        backGraphics.drawImage(backgroud, 0, 0, null);
        player.render(backGraphics);

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
        player.run();
    }

}
