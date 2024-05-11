import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Principal extends JFrame {
    private JMenuBar jMenuBar;
    private JMenu raster;
    private JMenuItem basicoLinea, bresenhamLinea, salir;
    
    public Principal() {
        super("Graficación y Animación");

        jMenuBar = new JMenuBar();

        creaMenuRaster();

        setJMenuBar(jMenuBar);

        addWindowListener(new CloseWin());
        setSize(600,400);
        setVisible(true);
    }

    //  Clases de la gestion de eventos
    public class CloseWin extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            setVisible(false);
            dispose();
        }
        
    }

    private class BLinea implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AlgoritmoBLinea basLinea = new AlgoritmoBLinea();
        }
        
    }

    private class Salir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            setVisible(false);
            dispose(); 
        }
        
    }

    //  Sección de métodos
    private void creaMenuRaster () {
        raster = new JMenu();
        raster.setMnemonic('R');
        raster.setText("Rastreo");

        basicoLinea = new JMenuItem();
        basicoLinea.setMnemonic('L');
        basicoLinea.setText("Básico de Linea");

        bresenhamLinea = new JMenuItem();
        bresenhamLinea.setMnemonic('B');
        bresenhamLinea.setText("Bresenham de Linea");

        salir  = new JMenuItem();
        salir.setMnemonic('S');
        salir.setText("Salir");
        //...  Acá van los que faltan

        // Configuramos el menu
        raster.add(basicoLinea);
        raster.add(bresenhamLinea);
        raster.addSeparator();
        raster.add(salir);
        
        jMenuBar.add(raster);

        //  Asignamos los Eventos
        salir.addActionListener(new Salir() );
        basicoLinea.addActionListener(new BLinea());
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
    }

}
