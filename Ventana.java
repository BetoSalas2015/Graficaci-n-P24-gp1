import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Ventana extends Frame {

    private Dibujo dibujo;
    private Panel panelDatos, panelPunto1;
    private Label lblPunto1;
    private TextField txtPunto1x, txtPunto1y;
    private Button btnGraficar, btnAgregar, btnCargar;
    private Vector<Point> vectorPuntos;

    public Ventana() {
        super("Dibujo");

        panelDatos = new Panel();
        panelDatos.setLayout(new GridLayout(1, 10));
        panelPunto1 = new Panel();
        panelPunto1.setLayout(new GridLayout(1, 2));

        vectorPuntos = new Vector<Point>();


        lblPunto1 = new Label("Punto1: ");


        txtPunto1x = new TextField("0");
        txtPunto1y = new TextField("0");

        //btnAgregar = new Button("Agregar");
        btnCargar = new Button("Cargar Puntos");
        btnGraficar = new Button("Graficar");

        panelPunto1.add(txtPunto1x); 
        panelPunto1.add(txtPunto1y);


        panelDatos.add(lblPunto1);
        panelDatos.add(panelPunto1);
        //panelDatos.add(btnAgregar);

        dibujo = new Dibujo();

        add(dibujo, "Center"); // agraga el objeto dibujo a la ventana
        //add(panelDatos, "North");
        //add(btnGraficar, "South"); 
        add(btnCargar, "South");
        setSize(400, 400);
        setVisible(true);
        setResizable(true);

        addWindowListener(new CloseWin());
        btnGraficar.addActionListener( new BotónGraficar() );
        //btnAgregar.addActionListener(new BotónAgregar() );
        btnCargar.addActionListener(new BotónCargar());
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
            vectorPuntos.add( new Point(Integer.parseInt( txtPunto1x.getText()), 
                                        Integer.parseInt(txtPunto1y.getText())));
        }
    }

    private class BotónCargar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String c, cad1, cad2; 
            StringTokenizer token;
            vectorPuntos = new Vector<Point>();
            try {
                BufferedReader entrada = new BufferedReader( new FileReader("coordenadas.txt"));
                while (( c = entrada.readLine() ) != null) {
                    token = new StringTokenizer(c, ",");
                    cad1 = token.nextToken();
                    cad2 = token.nextToken();

                    vectorPuntos.add( new Point( Integer.parseInt(cad1), Integer.parseInt(cad2) ));
                }
                entrada.close();
                dibujo.asignaPuntos(vectorPuntos);
                dibujo.repaint();
            } catch (IOException ex) {
                System.out.println("El archivo no se pudi cargar. ");
            }
            
        }
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }

}
