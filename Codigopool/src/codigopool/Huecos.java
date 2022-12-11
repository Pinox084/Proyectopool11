package codigopool;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Huecos {
    /*Objeto que genera los huecos donde deben caer las Bolas, solo Requiere darle posicion y pintarlas*/
    private double x,y,width,height;
    /*Constructot*/
    public Huecos(double x, double y, double a){
        this.x = x;
        this.y = y;
        width = a;
        height = a;
        
    }
    
    
    /*Metodos*/
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
