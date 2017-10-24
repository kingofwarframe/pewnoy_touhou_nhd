package touhou.Enemy;

import bases.FrameCounter;
import bases.GameObject;

import java.util.Random;

public class EnemySpawner  extends GameObject{
    FrameCounter frameCounter = new FrameCounter(60);
    Random random = new Random();
    public void run(){
        if (frameCounter.run()){
            frameCounter.reset();
            spawn();
        }
    }
    public void spawn(){
        Enemy enemy = new Enemy();
       enemy.position.set(100 ,random.nextInt(380));
        GameObject.add(enemy);

    }
}
