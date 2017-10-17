package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy {
    BufferedImage image;

   public int x = 134;
   public int y = 143;

    final int SPEED = 2;

    final int LEFT = 0;
    final int RIGHT = 350;
    final int TOP = 0;
    final int BOTTOM = 520;
    long shootingTimer = System.nanoTime();
    long delay = 300;




    public Enemy() {
        image = Utils.loadImage("assets/images/enemies/level0/pink/3.png");
    }

    public void render(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }

    public void run(){
     if (x > 0){
         x+=SPEED;
     }
     if (x == 330){
         x-=SPEED;
     }

        x = (int) Utils.clamp(x, LEFT, RIGHT);
        y = (int)Utils.clamp(y, TOP, BOTTOM);
    }
    public void shoot(ArrayList<EnemyBullet> bullets) {
        long shooting = (System.nanoTime() - shootingTimer) / 2000000;
        if (shooting > delay) {
            EnemyBullet newBullet = new EnemyBullet();
            newBullet.x = x;
            newBullet.y = y;

            bullets.add(newBullet);
            shootingTimer = System.nanoTime();
        }
    }

}
