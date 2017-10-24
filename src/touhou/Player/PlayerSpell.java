package touhou.Player;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import touhou.Enemy.Enemy;

public class PlayerSpell extends GameObject {


    final int Speed = 30;
    BoxCollider boxCollider;
    public PlayerSpell() {

        image = Utils.loadImage("assets/images/player-bullets/a/dan.png");
        boxCollider = new BoxCollider(20,20);
    }



    public void run()
    {
        this.position.substractBy(0,Speed);
        boxCollider.position.set(this.position);
        Enemy enemy = GameObject.collideWith(this.boxCollider);
        if (enemy !=null){
            enemy.getHit();
            this.isActive = false;
        }
    }
}
