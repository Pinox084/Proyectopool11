
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
        cajon.get(0).setMoveX(x*0.05);
        cajon.get(0).setMoveY(y*0.05);
    }
    public Bola getBall(){
        return cajon.get(0);
    }
    
    public void checkpuntos(Huecos a){
        for (int i = 0; i < cajon.size(); i++) {
            double aux = a.getX() - cajon.get(i).getX();
            double auy = a.getY() - cajon.get(i).getY();
            double mag = Math.sqrt(aux*aux+auy*auy);
            if(mag<= 11){
                if(cajon.get(i).getNumber() == 0){
                    cajon.get(0).setPosition(600, 300);
                }else{
                    
                    cajon.remove(cajon.get(i));
                }
            }
        }
    }
    public void ColisionBorder(float x, float y, float width, float height){

        
        for (int i = 0; i < cajon.size(); i++) {
            
            if((cajon.get(i).getX() <= x+10) || (cajon.get(i).getX() >= width+190) ){
                
                double aux = cajon.get(i).getMoveX();
                aux = aux * -1;
                cajon.get(i).setMoveX(aux);
                double a = cajon.get(i).getX();
                double b = cajon.get(i).getY();
                cajon.get(i).setPosition(a+aux,b);
            }
            if((cajon.get(i).getY() <= y+10) || (cajon.get(i).getY() >= height+190) ){
                double aux2 = cajon.get(i).getMoveY();
                aux2 = aux2 * -1;
                cajon.get(i).setMoveY(aux2);
                double a = cajon.get(i).getX();
                double b = cajon.get(i).getY();
                cajon.get(i).setPosition(a,b+aux2);
            }
        }
        //System.out.println("Bola: " + cajon.get(0).getX() + " " + cajon.get(0).getY());
    }
    
    public void ColisionBall(){
        for (int i = 0; i < cajon.size(); i++) {
            
            for (int j = 1; j < cajon.size(); j++) {
                
                if(i == j){
                    continue;
                }
                double aux = checkdiametro(cajon.get(i), cajon.get(j));
                if(  21 >= aux){                   
                    descolision(cajon.get(i), cajon.get(j));
                    changerColision(cajon.get(i), cajon.get(j));
                    
                }
            }
        }
        //System.out.println("Bola: " + cajon.get(0).getX() + " " + cajon.get(0).getY());
    }
    
    
    public void changerColision(Bola a, Bola b){
        double x = a.getX() - b.getX();
        double y = a.getY() - b.getY();
        double angle = Math.atan2(y,x);
        
        double vx1, vy1;
        double vx2, vy2;
        vx1 = a.getMoveX();
        vy1 = a.getMoveY();
        vx2 = b.getMoveX();
        vy2 = b.getMoveY();
        
        double cosx = Math.cos(angle);
        double siny = Math.sin(angle);
        double velox1;
        double veloy1;
        double velox2;
        double veloy2;
        
        velox1 = cosx * vx1 + siny * vy1;
        veloy1 = -siny * vx1 + cosx *vy1;
        
        velox2 = cosx * vx2 + siny * vy2;
        veloy2 = -siny * vx2 + cosx * vy2;
        
        double vfinal;
        double vfinal2;
        
        vfinal = velox1;
        vfinal2 = velox2;
        velox1 = vfinal2;
        velox2 = vfinal;
        //b.setPosition(b.getX()+ x, b.getY()+y);
        //a.setPosition(x, y);
        a.setMoveX(velox1*cosx-veloy1*siny);
        a.setMoveY(veloy1*cosx+velox1*siny);
        
        b.setMoveX(velox2*cosx-veloy2*siny);
        b.setMoveY(veloy2*cosx+velox2*siny);
        
        System.out.println("Bola Blanca: " + a.getMoveX() + " " + a.getMoveY());
        System.out.println("Bola Roja: " + b.getMoveX() + " " + b.getMoveY());
        
        
    }
    public void descolision(Bola a, Bola b){
        double midx = (a.getX() +b.getX())/2;
        double midy = (a.getY() +b.getY())/2;
        
        double aux = b.getX()-a.getX() ;
        double auy = b.getY() -a.getY();
        double mag = sqrt(aux*aux +auy*auy);
        aux /= mag;
        auy /= mag;
        
        b.setPosition(midx+aux*10, midy+auy*10);
        a.setPosition(midx-aux*10, midy-auy*10);
        //System.out.println("Bola: " + a.getX() + " " + a.getY());
        //System.out.println("Bola: " + b.getX() + " " + b.getY());
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
