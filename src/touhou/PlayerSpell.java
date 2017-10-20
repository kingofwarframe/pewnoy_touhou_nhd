package touhou;

import bases.GameObject;
import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerSpell extends GameObject {


    final int Speed = 30;

    public PlayerSpell() {

        image = Utils.loadImage("assets/images/player-bullets/a/dan.png");
    }



    public void run()
    {
        y -= Speed;
    }
}
