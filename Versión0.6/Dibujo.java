import java.awt.*;
 import java.awt.geom.*;
import java.util.Vector;

public class Dibujo extends Canvas {

    private Punto punto1;

    private Vector<Point> vectorPuntos;

    public Dibujo() {               //constructor

    }

    public void asignaPuntos(Punto punto1) {
        this.punto1 = punto1;

    }

    public void asignaPuntos(Vector<Point> vector) {
            vectorPuntos = vector;
    }

    private void planoCoordenado(Graphics gc) {
        Graphics2D g2d = (Graphics2D) gc;

        g2d.setColor( new Color(0x77BF9D));
        int h = getSize().height / 2;
        int w = getSize().width / 2;

        gc.translate(w, h);

        g2d.setStroke( new BasicStroke(2.0f));
        setBackground( new Color( 0x5EFFB3 ));

        for (int i = 0; i > -w; i -= 20) {
            g2d.draw(new Line2D.Float(i,-h,i,h));
        }
        for (int i = 0; i > -h; i -= 20) {
            g2d.draw(new Line2D.Float(-w, i, w, i));
        }
        for (int i = 0; i < w; i += 20) {
            g2d.draw(new Line2D.Float(i,-h,i,h));
        }
        for (int i = 0; i <  h; i += 20) {
            g2d.draw(new Line2D.Float(-w, i, w, i));
        }

        g2d.setStroke(new BasicStroke(3.0f));
        g2d.setColor(new Color(0xaa7e78));
        g2d.draw(new Line2D.Float(-w, 0, w, 0));
        g2d.draw(new Line2D.Float(0, -h, 0, h));



    }

    public void paint(Graphics gc) {
        Graphics2D g2d = (Graphics2D) gc;
        planoCoordenado(gc);
        int i;
        Color color = new Color(0,0, 255);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(2.0f));
        if (vectorPuntos != null) {
            for(i = 0; i < vectorPuntos.size() - 1; i++) {
                g2d.draw(new Line2D.Float(vectorPuntos.get(i), vectorPuntos.get(i + 1) ));
                
            }
            g2d.draw( new Line2D.Float(vectorPuntos.get(i), vectorPuntos.get(0)));
                            
        } 

    }
    
}
