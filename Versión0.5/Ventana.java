import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class Ventana extends Frame {

    private Dibujo dibujo;
    private Panel panelDatos, panelPunto1;
    private Label lblPunto1;
    private TextField txtPunto1x, txtPunto1y;
    private Button btnGraficar, btnAgregar;
    private Vector<Punto> vectorPuntos;

    public Ventana() {
        super("Dibujo");

        panelDatos = new Panel();
        panelDatos.setLayout(new GridLayout(1, 10));
        panelPunto1 = new Panel();
        panelPunto1.setLayout(new GridLayout(1, 2));

        vectorPuntos = new Vector<Punto>();


        lblPunto1 = new Label("Punto1: ");


        txtPunto1x = new TextField("0");
        txtPunto1y = new TextField("0");

        btnAgregar = new Button("Agregar");
        btnGraficar = new Button("Graficar");

        panelPunto1.add(txtPunto1x);
        panelPunto1.add(txtPunto1y);


        panelDatos.add(lblPunto1);
        panelDatos.add(panelPunto1);
        panelDatos.add(btnAgregar);

        dibujo = new Dibujo();

        add(dibujo, "Center"); // agraga el objeto dibujo a la ventana
        add(panelDatos, "North");
        add(btnGraficar, "South"); 
        setSize(400, 400);
        setVisible(true);

        addWindowListener(new CloseWin());
        btnGraficar.addActionListener( new BotónGraficar() );
        btnAgregar.addActionListener(new BotónAgregar() );
    }

    private class CloseWin extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            setVisible(false);
            dispose();
        }
    }

    private class BotónGraficar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            dibujo.asignaPuntos(vectorPuntos);
            dibujo.repaint();
        }
        
    }

    private class BotónAgregar implements ActionListener {
    
        @Override
        public void actionPerformed(ActionEvent e) {
            vectorPuntos.add( new Punto(Integer.parseInt( txtPunto1x.getText()), 
                                        Integer.parseInt(txtPunto1y.getText())));
        }
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }

}
