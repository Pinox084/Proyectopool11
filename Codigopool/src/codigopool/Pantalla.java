
package codigopool;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;


public class Pantalla extends JFrame {
    
    private Pantalla p;
    private BolaJugador x;
    private Mesa mesita;
    private Background fondo;
    //private JPanel atras;
    public Pantalla(){
       super();
       p = this;
       mesita = new Mesa(200,200,600,300);
       
       fondo = new Background(1000,800);
       
       fondo.setBounds(0,0,1000,800);
       fondo.setBackground(Color.black);
       
       add(fondo);
       x = new BolaJugador(50,50);
       
       
       setLayout(null);       
       setSize(1000,800);        
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
       
    }
    public void paint(Graphics g){
        super.paint(g);
        mesita.paint(g);
        x.paint(g);
        
    }
}
