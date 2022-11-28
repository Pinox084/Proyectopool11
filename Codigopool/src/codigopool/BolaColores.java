package codigopool;

import java.awt.Color;
import java.awt.Graphics;
public class BolaColores extends Bola {
    int tipo;
    public BolaColores(double x, double y,int n){
        super(x,y,n);
        if((getX()+getY())>=100){
            tipo=1;
        }
        if((getX()+getY())<=100){
            tipo=2;
        }
    }
    
    
    @Override
    public void paint(Graphics g){
        switch (tipo){
                case 1:
                    g.setColor(Color.red);
                    g.fillOval((int)getX(), (int)getY(),20,20);
                case 2:
                    g.setColor(Color.blue);
                    g.fillOval((int)getX(), (int)getY(),20,20);
        }
    }
            
}

