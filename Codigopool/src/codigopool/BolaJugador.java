package codigopool;

import java.awt.Color;
import java.awt.Graphics;

public class BolaJugador extends Bola{
    
    public BolaJugador(double x, double y){
        super(x,y);
    }
    
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillOval((int)getX(), (int)getY(),20,20);
        g.drawOval((int)getX()-1, (int)getY(), 20, 20);
    }
}
