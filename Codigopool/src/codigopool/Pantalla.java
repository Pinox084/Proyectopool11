
package codigopool;

import Controles.ControlJugador;
import Controles.Puntuacion;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;


public class Pantalla extends JFrame {
    
    public static Pantalla p;
    
    public Mesa mesita;
    private ControlJugador mouse;
    public Puntuacion score;
    public Pantalla() throws InterruptedException{
       super();
       p = this;
       mesita = new Mesa(200,200,600,300);
   
       score = new Puntuacion();
       score.setBounds(0, 0, 1000, 120);
       score.setBackground(Color.red);
       add(score);
       
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
       
       
    }
    
    public void changeScore(int n){
        score.changeText(n);
    }
    public void paint(Graphics g){
        super.paint(g);
        //mesita.paint(g);
               
    }
}
