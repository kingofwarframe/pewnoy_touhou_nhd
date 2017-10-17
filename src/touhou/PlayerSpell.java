package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerSpell {
    public int x;
    public int y;
    BufferedImage image;
    final int Speed = 30;

    public PlayerSpell() {
        image = Utils.loadImage("assets/images/player-bullets/a/dan.png");
    }

    public void render(Graphics backgraphics) {
        backgraphics.drawImage(image, x, y, null);
    }
    public void run(){
        y -=Speed;
    }
}
