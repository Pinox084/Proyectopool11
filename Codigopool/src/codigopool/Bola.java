package codigopool;

import java.awt.Color;
import java.awt.Graphics;

public class Bola {
    private double location;
    private double radio;
    
    public Bola(){
        
    }
    
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillOval(50, 50, 50, 50);
        //g.drawOval(50, 50, 50, 50);
    }
}
