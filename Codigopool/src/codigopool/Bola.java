package codigopool;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Bola {
    private double locationX;
    private double locationY;
    private final double radio = 50;
    
    public Bola(double x, double y){
        
        locationX = x;
        locationY = y;
    }
    
    public double getX(){
        return locationX;
    }
    public double getY(){
        return locationY;
    }
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillOval((int)locationX, (int)locationY,50,50);
        
    }
}
