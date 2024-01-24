import java.awt.*;
import java.awt.geom.*;

public class Dibujo extends Canvas {

    public Dibujo() {               //constructor

    }

    public void paint(Graphics gc) {
        Color color = new Color(50, 26,94);
        gc.setColor(Color.black);
        gc.fillRect(0, 0, getWidth(), getHeight());
        gc.setColor(Color.yellow);
        gc.fillArc(70, 70, 175, 175, 35, 280);
        gc. setColor(color);
        gc.fillOval(140, 110, 18, 18);
        gc.setColor(new Color(230, 214, 19));
        gc.fillOval(200, 145, 30, 30);
        gc.fillOval(270, 145, 30, 30);
        gc.fillOval(340, 145, 30, 30);
    }
    
}
