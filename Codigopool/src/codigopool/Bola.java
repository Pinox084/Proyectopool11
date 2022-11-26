package codigopool;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Bola {
    protected float locationX;
    protected float locationY;
    protected float moveX;
    protected float moveY;
    protected final double radio = 50;
    
    public Bola(float x, float y){
        
        locationX = x;
        locationY = y;
        moveX = 0.1f;
        moveY = 0.5f;
    }
    
    public void move(){
        locationX = locationX +moveX;
        locationY = locationY +moveY;
        
        if((locationX <= 0) || (locationX >= 1000) ){
            moveX = moveX * -1;
            
        }
        if((locationY <= 0) || (locationY >= 1000) ){
            moveY = moveY * -1;
        }
        System.out.println(locationX);
        System.out.println(locationY);
    }
    public float getX(){
        return locationX;
    }
    public float getY(){
        return locationY;
    }
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillOval(Math.round(locationX), Math.round(locationY),50,50);
        
    }
}
