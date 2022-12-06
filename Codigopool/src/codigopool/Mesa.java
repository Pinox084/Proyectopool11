package codigopool;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class Mesa {
    private float X;
    private float Y;
    private float width;
    private float height;
    private Cajon caja;
     // private JLabel mesa;
    
    public Mesa(float x, float y, float a, float b){
        X = x;
        Y = y;
        width = a;
        height = b;
        
        caja = new Cajon();
        initPosition();
        
        
        
    }
    public void golpear(double a, double b){
        Bola player = caja.getBall();
        a = a - player.getX();
        b = b - player.getY();
        caja.setMove(a,b);
    }
    public void game(){        
        caja.ColisionBall();
        caja.ColisionBorder(X, Y, width, height);
        caja.mover();
        
    }
    public void initPosition(){
        caja.newPlayer(new BolaJugador(X +300, Y+20, 0));
        for (int i = 1; i < 2; i++) {
            float pox = X+50+i*10;
            float poy = Y+10+(float)i*20; 
            caja.newBola(new BolaColores(pox,poy,i));
            
        }
        
    }
    
    public void paint(Graphics g){
        
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect((int)X-15, (int)Y-15, (int)width+30, (int)height+30);
        g.setColor(Color.green);
        g.fillRect((int)X, (int)Y, (int)width, (int)height);
        caja.paint(g);
        
    }
    
}
