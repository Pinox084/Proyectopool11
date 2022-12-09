
package codigopool;
import Controles.ControlTeclado;
import Controles.ControlJugador;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;


public class Pantalla extends JFrame {
    
    public static Pantalla p;
    
    public Mesa mesita;
    //private Background fondo;
    //private Botones boton;
    private ControlTeclado controld;
    private ControlJugador mouse;
    public Pantalla() throws InterruptedException{
       super();
       p = this;
       mesita = new Mesa(200,200,600,300);
       
       //fondo = new Background(1000,600);
       //boton = new Botones();
       //fondo.setBounds(0,0,1000,800);
       //fondo.setBackground(Color.gray);
       Puntuacion x = new Puntuacion();
       x.setBounds(0, 0, 1000, 120);
       add(x);
       //controld = new ControlTeclado();
       mouse = new ControlJugador();
       mouse.setBounds(0, 0, 1000, 600);
       mouse.setBackground(Color.gray);
       //addKeyListener(controld);
       //addKeyListener(boton);
       //add(fondo);
       //add(controld);
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
