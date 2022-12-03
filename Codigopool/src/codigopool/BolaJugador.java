package codigopool;

import java.awt.Color;
import java.awt.Graphics;

public class BolaJugador extends Bola{
    
    public BolaJugador(double x, double y, int n){
        super(x,y,n);
        
    }
    
    
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillOval((int)locationX-10, (int)locationY-10,20,20);
    }
}
