package codigopool;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

public class Mesa {
    private double X;
    private double Y;
    private double width;
    private double height;
    
   // private JLabel mesa;
    
    public Mesa(double x, double y, double a, double b){
        X = x;
        Y = y;
        width = a;
        height = b;
        
    }
    
    public void paint(Graphics g){
        g.setColor(Color.green);
        g.fillRect((int)X, (int)Y, (int)width, (int)height);
    }
    
}
