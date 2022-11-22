
package codigopool;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Pantalla extends JFrame {
    
    private Pantalla p;
    private Mesa mesita;
    public Pantalla(){
       super();
       p = this;
       mesita = new Mesa(200,200,600,300);
       setLayout(null);
       
       this.setSize(1000,800); 
       getContentPane().setBackground(Color.BLACK);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
        
    }
    public void paint(Graphics g){
        mesita.paint(g);
    }
}
