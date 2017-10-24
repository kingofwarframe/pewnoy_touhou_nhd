package touhou.Enemy;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import touhou.Player.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {
    BufferedImage image;

    public int x;
    public int y;
    final int SPEED = 10;
    public BoxCollider boxColider;
    public EnemyBullet() {
        boxColider = new BoxCollider(20,20);
        image = Utils.loadImage("assets/images/enemies/bullets/cyan.png");

    }

    public void render(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }

    public void run() {
       position.y += SPEED;
        boxColider.position.set(this.position);
        Enemy player = GameObject.collideWith(this.boxColider);
        if(player != null){
            player.getHit();
            this.isActive = false;
        }
    }

}
