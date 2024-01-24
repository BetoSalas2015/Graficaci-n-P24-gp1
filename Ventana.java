import java.awt.*;
import java.awt.event.*;

public class Ventana extends Frame {

    private Dibujo dibujo;
    private Panel panelDatos, panelPunto1, panelPunto2;
    private Label lblPunto1, lblPunto2;
    private TextField txtPunto1x, txtPunto1y, txtPunto2x, txtPunto2y;
    private Button btnGraficar;

    public Ventana() {
        super("Dibujo");

        panelDatos = new Panel();
        panelDatos.setLayout(new GridLayout(1, 10));
        panelPunto1 = new Panel();
        panelPunto1.setLayout(new GridLayout(1, 2));
        panelPunto2 = new Panel();
        panelPunto2.setLayout(new GridLayout(1, 2));

        lblPunto1 = new Label("Punto1: ");
        lblPunto2 = new Label("Punto2: ");

        txtPunto1x = new TextField("0");
        txtPunto1y = new TextField("0");
        txtPunto2x = new TextField("0");
        txtPunto2y = new TextField("0");

        btnGraficar = new Button("Graficar");

        panelPunto1.add(txtPunto1x);
        panelPunto1.add(txtPunto1y);
        panelPunto2.add(txtPunto2x);
        panelPunto2.add(txtPunto2y);

        panelDatos.add(lblPunto1);
        panelDatos.add(panelPunto1);
        panelDatos.add(lblPunto2);
        panelDatos.add(panelPunto2);

        dibujo = new Dibujo();

        add(dibujo, "Center"); // agraga el objeto dibujo a la ventana
        add(panelDatos, "North");
        add(btnGraficar, "South"); 
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
