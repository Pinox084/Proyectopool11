package codigopool;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Bola {
    protected double locationX;
    protected double locationY;
    protected double moveX;
    protected double moveY;
    private int number;
    
    public Bola(double x, double y, int n){
        /*Constructor*/
        locationX = x;
        locationY = y;
        moveX = 0f;
        moveY = 0f;
        number = n;
    }
    
    
    /*Modifica la posicion de la Bola*/
    public void move(){
        locationX = locationX + moveX;
        locationY = locationY + moveY;
        friction();
              
    }
    public void friction(){
        
        moveX *= 0.98;
        moveY *= 0.98;
        if((Math.abs(moveX) <= 0.010f)){
            moveX = 0;
        }
        if((Math.abs(moveY) <= 0.010f)){
            moveY = 0;
        }
        
    }
    /*Getters y Setters*/
    public void setPosition(double x, double y){
        locationX = x;
        locationY = y;
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
    /*Pintado borde de la Bola*/
    public void paint(Graphics g){
       
        g.setColor(Color.black);
        g.fillOval((int)getX()-12, (int)getY()-12,25,25);
    }
}
