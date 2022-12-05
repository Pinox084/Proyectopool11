
package codigopool;


import java.awt.Graphics;
import static java.lang.Math.sqrt;
import java.util.ArrayList;

public class Cajon {
    private ArrayList<Bola> cajon;
    public Cajon(){
        cajon = new ArrayList();
        
    }
    
    public void newBola(Bola nueva){
        
        cajon.add(nueva);
    }
    
    public void newPlayer(BolaJugador x){
        cajon.add(x);
    }
    public void mover(){
       
        for (int i = 0; i < cajon.size(); i++) {
            cajon.get(i).move();
        }
        
    }
    public void setMove(double x, double y){
        cajon.get(0).setMoveX(x*0.005);
        cajon.get(0).setMoveY(y*0.005);
    }
    public Bola getBall(){
        return cajon.get(0);
    }
    
    public void ColisionBorder(float x, float y, float width, float height){

        
        for (int i = 0; i < cajon.size(); i++) {
            
            if((cajon.get(i).getX() <= x+10) || (cajon.get(i).getX() >= width+190) ){
                
                double aux = cajon.get(i).getMoveX();
                aux = aux * -1;
                cajon.get(i).setMoveX(aux);
            }
            if((cajon.get(i).getY() <= y+10) || (cajon.get(i).getY() >= height+190) ){
                double aux2 = cajon.get(i).getMoveY();
                aux2 = aux2 * -1;
                cajon.get(i).setMoveY(aux2);
            }
        }
        System.out.println("Bola: " + cajon.get(0).getX() + " " + cajon.get(0).getY());
    }
    
    public void ColisionBall(){
        for (int i = 0; i < cajon.size(); i++) {
            
            for (int j = 0; j < cajon.size(); j++) {
                
                if(i == j){
                    continue;
                }
                double aux = checkdiametro(cajon.get(i), cajon.get(j));
                if(  20 >= aux){                   
                    //changerColision(cajon.get(i), cajon.get(j));   
                }
            }
        }
    }
    
    
    public void changerColision(Bola a, Bola b){
        double x = b.getX() - a.getX();
        double y = b.getY() - a.getY();
        double mag = Math.sqrt(x*x+y*y);
        //vector unitatio
        x = x/mag;
        y = y/mag;
        
         //vator tangente
        double ux = -y;
        double uy = x;
        //velocidades
        double vx1, vy1;
        double vx2, vy2;
        //velocidades a y b
        vx1 = a.getMoveX();
        vy1 = a.getMoveY();
        vx2 = b.getMoveX();
        vy2 = b.getMoveY();
        
        //vector n's
        
        double v1n = x*vx1 + y * vy1;
        double v1t = ux * vx1 +uy *vy2;
        double v2n = x* vx2 + y *vy2;
        double v2t = ux *vx2 + uy * vy2;
        
        double v1nx, v1ny;
        double v1tx, v1ty;
        double v2nx, v2ny;
        double v2tx, v2ty;
         
        v1n = v1n +2*v2n;
        v2n = v2n +2*v1n;
        
        v1nx = v1n * x;
        v1ny = v1n * y;
        
        v1tx = v1t * ux;
        v1ty = v1t * uy;
        
        v2nx = v2n * x;
        v2ny = v2n * y;
        
        v2tx = v2n * ux;
        v2ty = v2n * uy;
        
        vx1 = v1nx + v1tx ;
        vy1 = v1ny + v1ty;
        vx2 = v2nx + v2tx;
        vy2 = v2ny + v2ty;
         
        a.setMoveX(vx1);
        a.setMoveY(vy1);
        System.out.println("vx1: " + vx1 + "vy1: " + vy1);
        b.setMoveX(vx2);
        b.setMoveY(vy2);
        System.out.println("vx2: " + vx2 + "vy2: " + vy2);
    }
    public void descolision(Bola a, Bola b){
        double aux = (a.getX() +b.getX())/2;
        double auy = (a.getY() +b.getY())/2;
        
        double midx = a.getX() -b.getX();
        double midy = a.getY() -b.getY();
        double magmid = sqrt(midx*midx +midy*midy);
        midx /= magmid;
        midy /= magmid;
        
        b.setPosition(midx+aux*10, midy+auy*10);
        a.setPosition(midx-aux*10, midy-auy*10);
    }
    public double checkdiametro(Bola a, Bola b){
        double x = b.getX() -a.getX();
        double y = b.getY() -a.getY();
        x = x*x;
        y = y*y;
        double result = sqrt(x+y);
        
        return result;
    }
    public void paint(Graphics g){
        for(int i=0; i<cajon.size();i++){
           cajon.get(i).paint(g);
           
        }
    }
}
