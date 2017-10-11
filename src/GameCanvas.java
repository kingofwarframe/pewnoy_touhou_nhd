import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    BufferedImage backgroud, player;
    public GameCanvas(){
        //1. Load Background
        try {
            backgroud = ImageIO.read(new File("assets/images/background/0.png"));
            player = ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //2 Draw Background

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backgroud, 0, 0, null);
        g.drawImage(player, 192, 500, null);
    }
}
