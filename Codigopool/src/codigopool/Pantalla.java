
package codigopool;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;


public class Pantalla extends JFrame {
    
    public static Pantalla p;
    
    private Mesa mesita;
    private Background fondo;
    private Botones boton;
    
    public Pantalla(){
       super();
       p = this;
       mesita = new Mesa(200,200,600,300);
       
       fondo = new Background(1000,600);
       boton = new Botones();
       fondo.setBounds(0,0,1000,800);
       fondo.setBackground(Color.black);
       addKeyListener(boton);
       add(fondo);
       
       int t = 0;
       
       
       
       setLayout(null); 
       this.setResizable(false);
       setSize(1000,600);        
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
       //x.setmove(1f, 0);
       do{
           
           mesita.game();
           repaint();
       }while(t == 0);
       
    }
    
    
    public void paint(Graphics g){
        super.paint(g);
        mesita.paint(g);
        
        
    }
}
