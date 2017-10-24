package touhou.Enemy;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;

import java.util.ArrayList;

public class Enemy extends GameObject {
    public BoxCollider boxCollider;
    long shootingTimer = System.nanoTime();
    long delay = 400;
    public Enemy(){
        this.image = Utils.loadImage("assets/images/enemies/level0/pink/3.png");
        boxCollider = new BoxCollider(30,30);
    }
    public void run(){

        position.addUp(0,2);
        boxCollider.position.set(this.position);
    }
    public void getHit(){
        isActive = false;
    }
    public void shoot() {
        long shooting = (System.nanoTime() - shootingTimer) / 2000000;
        if (shooting > delay) {
            EnemyBullet newBullet = new EnemyBullet();
            newBullet.position.set(this.position);
            GameObject.add(newBullet);
            shootingTimer = System.nanoTime();
        }
    }
}
