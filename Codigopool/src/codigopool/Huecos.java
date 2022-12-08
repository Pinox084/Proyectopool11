package codigopool;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Huecos {
    private float x,y,width,height;
    private ArrayList<Huecos> hueco;
    public Huecos(float x, float y, float a){
        this.x = x;
        this.y = y;
        width = a;
        height = a;
        hueco= new ArrayList();
    }
    
    
    
    
    public void paint(Graphics g){
        
        g.setColor(Color.DARK_GRAY);
        g.fillOval((int)x, (int)y, (int)width, (int)height);
    }
}
