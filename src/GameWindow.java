import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    GameCanvas canvas;
    public GameWindow(){
        this.setSize(800,600);

        this.canvas = new GameCanvas();
        this.setContentPane(this.canvas);
        this.setBackground(Color.BLACK);
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               System.exit(0);
            }
        });
        this.canvas.setVisible(true);
        this.setVisible(true);



    }

}
