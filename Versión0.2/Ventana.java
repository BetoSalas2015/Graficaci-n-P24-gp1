import java.awt.*;
import java.awt.event.*;

public class Ventana extends Frame {

    private Dibujo dibujo;

    public Ventana() {
        super("Dibujo");

        dibujo = new Dibujo();
        add(dibujo, "Center");
        setSize(400, 400);
        setVisible(true);

        addWindowListener(new CloseWin());
    }

    private class CloseWin extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            setVisible(false);
            dispose();
        }
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }

}
