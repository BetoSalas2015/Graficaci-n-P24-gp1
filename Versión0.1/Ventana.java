import java.awt.*;
import java.awt.event.*;

public class Ventana extends Frame {

    public Ventana() {
        super("Dibujo");
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


    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }

}
