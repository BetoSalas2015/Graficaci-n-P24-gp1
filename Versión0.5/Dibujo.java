import java.awt.*;
import java.awt.geom.*;
import java.util.Vector;

public class Dibujo extends Canvas {

    private Punto punto1;

    private Vector<Punto> vectorPuntos;

    public Dibujo() {               //constructor

    }

    public void asignaPuntos(Punto punto1) {
        this.punto1 = punto1;

    }

    public void asignaPuntos(Vector<Punto> vector) {
            vectorPuntos = vector;
    }

    public void paint(Graphics gc) {
        int i;
        Color color = new Color(50, 26, 94);
        if (vectorPuntos != null) {
            for(i = 0; i < vectorPuntos.size() - 1; i++) {
                gc.drawLine(vectorPuntos.get(i).getX(), vectorPuntos.get(i).getY(), 
                             vectorPuntos.get(i + 1).getX(), vectorPuntos.get(i + 1).getY());
                
            }
            gc.drawLine(vectorPuntos.get(i).getX(), vectorPuntos.get(i).getY(), 
                            vectorPuntos.get(0).getX(), vectorPuntos.get(0).getY());
                            
        }

    }
    
}
