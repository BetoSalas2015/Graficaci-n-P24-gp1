import java.awt.*;
import java.awt.geom.*;

public class Dibujo extends Canvas {

    private Punto punto1, punto2;

    public Dibujo() {               //constructor

    }

    public void asignaPuntos(Punto punto1, Punto punto2) {
        this.punto1 = punto1;
        this.punto2 = punto2;
    }

    public void paint(Graphics gc) {
        if(punto1 != null && punto2 != null)
             gc.drawLine(punto1.getX(), punto1.getY(), punto2.getX(), punto2.getY());

    }
    
}
