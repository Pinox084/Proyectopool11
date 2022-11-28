
package codigopool;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;


public class Pantalla extends JFrame {
    
    public static Pantalla p;
    private BolaJugador x;
    private Mesa mesita;
    private Background fondo;
    
    public Pantalla(){
       super();
       p = this;
       mesita = new Mesa(200,200,600,300);
       
       fondo = new Background(1000,600);
       
       fondo.setBounds(0,0,1000,600);
       fondo.setBackground(Color.black);
       
       add(fondo);
       x = new BolaJugador(50,50,0);
       int t = 0;
       
       
       
       setLayout(null); 
       this.setResizable(false);
       setSize(1000,600);        
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
       //x.setmove(1f, 0);
       do{
           x.move();
           mesita.game();
           repaint();
       }while(t == 0);
       
    }
    
    
    public void paint(Graphics g){
        super.paint(g);
        mesita.paint(g);
        x.paint(g);
        
    }
}
