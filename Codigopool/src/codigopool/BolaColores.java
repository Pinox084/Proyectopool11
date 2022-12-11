package codigopool;
import java.awt.Color;
import java.awt.Graphics;
public class BolaColores extends Bola {
    int tipo;
    public BolaColores(double x, double y,int n){
        /*Constructor*/
        super(x,y,n);
        if(n<=2){
            tipo=1;
        }
        if(n>2 && n<=4){
            tipo=2;
        }
        if(n>4 && n<=6){
            tipo=3;
        }
        if(n>6 && n<=8){
            tipo=4;
        }
        if(n>8 && n<=10){
            tipo=5;
        }
        if(n>10 && n<=12){
            tipo=6;
        }
        if(n>12 && n<=14){
            tipo=7;
        }
        if(n>14 && n<=16){
            tipo=8;
        }
    }
    
    
    @Override
    /*Pinta la Bola dependiendo del tipo*/
    public void paint(Graphics g){
        switch (tipo){
                case 1:
                    super.paint(g);
                    g.setColor(Color.red);
                    g.fillOval((int)getX()-10, (int)getY()-10,20,20);
                    g.setColor(Color.black);
                    g.drawString(""+this.getNumber(), (int)getX()-3, (int)getY()+3);
                    break;
                case 2:
                    super.paint(g);
                    g.setColor(Color.blue);
                    g.fillOval((int)getX()-10, (int)getY()-10,20,20);
                    g.setColor(Color.black);
                    g.drawString(""+this.getNumber(), (int)getX()-3, (int)getY()+3);
                    break;
                case 3:
                    super.paint(g);
                    g.setColor(Color.yellow);
                    g.fillOval((int)getX()-10, (int)getY()-10,20,20);
                    g.setColor(Color.black);
                    g.drawString(""+this.getNumber(), (int)getX()-3, (int)getY()+3);
                    
                    break;
                case 4:
                    super.paint(g);
                    g.setColor(Color.orange);
                    g.fillOval((int)getX()-10, (int)getY()-10,20,20);
                    g.setColor(Color.black);
                    g.drawString(""+this.getNumber(), (int)getX()-3, (int)getY()+3);
                    break;
                case 5:
                    super.paint(g);
                    g.setColor(Color.cyan);
                    g.fillOval((int)getX()-10, (int)getY()-10,20,20);
                    g.setColor(Color.black);
                    g.drawString(""+this.getNumber(), (int)getX()-3, (int)getY()+3);
                    break;
                case 6:
                    super.paint(g);
                    g.setColor(Color.PINK);
                    g.fillOval((int)getX()-10, (int)getY()-10,20,20);
                    g.setColor(Color.black);
                    g.drawString(""+this.getNumber(), (int)getX()-3, (int)getY()+3);
                    break;
                case 7:
                    super.paint(g);
                    g.setColor(Color.magenta);
                    g.fillOval((int)getX()-10, (int)getY()-10,20,20);
                    g.setColor(Color.black);
                    g.drawString(""+this.getNumber(), (int)getX()-3, (int)getY()+3);
                    break;
                case 8:
                    super.paint(g);
                    g.setColor(Color.black);
                    g.fillOval((int)getX()-10, (int)getY()-10,20,20);
                    g.setColor(Color.white);
                    g.fillOval((int)getX()-6, (int)getY()-7, 15,15);
                    g.setColor(Color.black);
                    g.drawString(""+this.getNumber(), (int)getX()-5, (int)getY()+5);
                    break;
        }
    }
            
}
