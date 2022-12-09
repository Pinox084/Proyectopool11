
package codigopool;

import Controles.ControlJugador;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;


public class Pantalla extends JFrame {
    
    public static Pantalla p;
    
    public Mesa mesita;
    private ControlJugador mouse;
    public Pantalla() throws InterruptedException{
       super();
       p = this;
       mesita = new Mesa(200,200,600,300);
   
       Puntuacion x = new Puntuacion();
       x.setBounds(0, 0, 1000, 120);
       add(x);
       
       mouse = new ControlJugador(mesita);
       mouse.setBounds(0, 0, 1000, 600);
       mouse.setBackground(Color.gray);
       addKeyListener(mouse);       
       add(mouse);
       
       int t = 0;
       
       
       
       setLayout(null); 
       this.setResizable(false);
       setSize(1000,600);        
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
       
       do{
           
           mesita.game();
           
           repaint();
           Thread.sleep(3);
       }while(t == 0);
       
    }
    
    
    public void paint(Graphics g){
        super.paint(g);
        mesita.paint(g);
               
    }
}
