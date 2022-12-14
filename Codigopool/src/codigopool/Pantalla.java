
package codigopool;

import Controles.ControlJugador;
import Controles.Puntuacion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Pantalla extends JFrame {
    
    public static Pantalla p;
    
    public Mesa mesita;
    private ControlJugador mouse;
    public Puntuacion score;
    /*Constructor con generalizacion de Mesa, Puntuacion y Controles en el JFrame*/
    public Pantalla(){
       super();
       p = this;
       mesita = new Mesa(200,200,600,300);
   
       score = new Puntuacion();
       score.setBounds(0, 0, 1000, 120);
       score.setBackground(Color.red);
       add(score);
       
       mouse = new ControlJugador(mesita);
       mouse.setBounds(0, 0, 1000, 600);
       
       addKeyListener(mouse);       
       add(mouse);
       
       int t = 0;
       
       
       setLayout(null); 
       this.setResizable(false);
       setSize(1000,600);        
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
       
       
    }
    /*Metodo para cambio de puntaje*/
    public void changeScore(int n){
        score.changeText(n);
    }
    public void paint(Graphics g){
        super.paint(g);
        
        score.changeText(mesita.puntos);
    }
}
