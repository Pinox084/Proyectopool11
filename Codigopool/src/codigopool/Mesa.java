package codigopool;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class Mesa {
    private float X;
    private float Y;
    private float width;
    private float height;
    private Cajon caja;
     // private JLabel mesa;
    
    public Mesa(float x, float y, float a, float b){
        X = x;
        Y = y;
        width = a;
        height = b;
        caja = new Cajon();
        initPosition();
        
        
        
    }
    
    public void game(){
        caja.mover();
        caja.ColisionBorder(X, Y, height, width);
    }
    public void initPosition(){
        for (int i = 1; i < 10; i++) {
            float pox = X +(float)i*50;
            float poy = Y+(float)i*50; 
            caja.newBola(new BolaColores(pox,poy,i));
        }
    }
    
    public void paint(Graphics g){
        
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect((int)X-15, (int)Y-15, (int)width+30, (int)height+30);
        g.setColor(Color.green);
        g.fillRect((int)X, (int)Y, (int)width, (int)height);
        caja.paint(g);
        
    }
    
}
