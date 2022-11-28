package codigopool;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Bola {
    protected double locationX;
    protected double locationY;
    protected double moveX;
    protected double moveY;
    protected final float radio = 50;
    private int number;
    
    public Bola(double x, double y, int n){
        
        locationX = x;
        locationY = y;
        moveX = 0.000001f;
        moveY = 0.000001f;
        number = n;
    }
    
    
    
    public void move(){
        locationX = locationX + moveX;
        locationY = locationY + moveY;
       
              
    }
    public void setMoveX(double x){
        moveX = x;
          
    }
    public void setMoveY(double y){
        moveY = y;
    }
    public double getX(){
        return locationX;
    }
    public double getY(){
        return locationY;
    }
    public double getMoveX(){
        return moveX;
    }
    public double getMoveY(){
        return moveY;
    }
    public int getNumber(){
        return number;
    }
    public void paint(Graphics g){
       
        
    }
}
