package touhou;

import bases.Utils;

import java.awt.image.BufferedImage;

public class PlayerSpell {
    int x;
    int y;
    BufferedImage image;
    final int Speed = 10;
    public PlayerSpell(){
        image = Utils.loadImage("assets/images/player-bullets/a/dan.png");
    }
}
