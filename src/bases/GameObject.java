package bases;

import bases.physics.BoxCollider;
import touhou.Player.Player;
import touhou.Enemy.Enemy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    public Vector2D position;
    public BufferedImage image;
    public boolean isActive;
    static Vector<GameObject> gameObjects = new Vector<>() ;
    static Vector<GameObject> newGameObjects = new Vector<>();
    public static void runAll(){
        for (GameObject gameObject: gameObjects){
            if (gameObject.isActive) {
                gameObject.run();
                
            }
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }
    public static void renderAll(Graphics g){
        for (GameObject gameObject: gameObjects){
            if (gameObject.isActive) {
                gameObject.render(g);
            }
        }
    }
    public static void add(GameObject gameObject){
        newGameObjects.add(gameObject);
    }
    public GameObject() {
        position = new Vector2D();
        isActive = true;
    }
    public static Enemy collideWith(BoxCollider boxCollider){
        for (GameObject gameObject :gameObjects){
            if (gameObject.isActive && gameObject instanceof  Enemy){
                Enemy enemy = (Enemy) gameObject;
                if (enemy.boxCollider.collideWidth(boxCollider)){
                    return enemy;
                }
            }
        }
        return null;
    }
    public static Player collideWithPlayer(BoxCollider boxCollider){
        for (GameObject gameObject :gameObjects){
            if (gameObject instanceof  Player){
                Player player = (Player) gameObject;
                if (player.boxCollider.collideWidth(boxCollider)){
                    return player;
                }
            }
        }
        return null;
    }
    public void run(){

    }
    public void render(Graphics g){
        if (image !=  null){
            g.drawImage(image,
                    (int)(position.x - image.getWidth() / 2),
                    (int)(position.y - image.getHeight() / 2), null);
        }
    }
}
