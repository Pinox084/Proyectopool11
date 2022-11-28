package codigopool;

import java.awt.Color;
import java.awt.Graphics;

public class BolaJugador extends Bola{
    
    public BolaJugador(float x, float y, int n){
        super(x,y,n);
        
    }
    
    
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillOval((int)locationX, (int)locationY,20,20);
    }
}
