package codigopool;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Huecos {
    private double x,y,width,height;
    
    public Huecos(double x, double y, double a){
        this.x = x;
        this.y = y;
        width = a;
        height = a;
        
    }
    
    
    
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void paint(Graphics g){
        
        g.setColor(Color.DARK_GRAY);
        g.fillOval((int)x-15, (int)y-15, (int)width, (int)height);
    }
}
