package codigopool;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Bola {
    protected float locationX;
    protected float locationY;
    protected float moveX;
    protected float moveY;
    protected final float radio = 50;
    private int number;
    
    public Bola(float x, float y, int n){
        
        locationX = x;
        locationY = y;
        moveX = 0.1f;
        moveY = 0;
        n = number;
    }
    
    
    
    public void move(){
        locationX = locationX +moveX;
        locationY = locationY +moveY;
        System.out.println("Pelota " + number + ": "+locationX);
        
        
    }
    public void setmoveX(float x){
        moveX = x;
        
        
    }
    public void setMoveY(float y){
        moveY = y;
    }
    public float getX(){
        return locationX;
    }
    public float getY(){
        return locationY;
    }
    public float getMoveX(){
        return moveX;
    }
    public float getMoveY(){
        return moveY;
    }
    public int getNumber(){
        return number;
    }
    public void paint(Graphics g){
       
        
    }
}
