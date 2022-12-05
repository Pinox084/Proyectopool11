
package codigopool;


import java.awt.Graphics;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
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
    public void setMove(){
        cajon.get(0).setMoveX(1f);
        cajon.get(0).setMoveY(1f);
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
    }
    
    public void ColisionBall(){
        for (int i = 0; i < cajon.size(); i++) {
            
            for (int j = 0; j < cajon.size(); j++) {
                double aux = checkdiametro(cajon.get(i), cajon.get(j));
                if(  aux <= 10f){
                    
                    changerColision(cajon.get(i), cajon.get(j));
                    
                }
            }
        }
    }
    
    public void changerColision(Bola a, Bola b){
        double x = b.getX() -a.getX();
        double y = b.getY()- a.getY();
        double tangente = y/x;
        double angle = Math.atan(tangente);
        x =a.getMoveX()*Math.cos(angle)+b.getMoveX()*Math.cos(angle);
        x *= -1;
        y = a.getMoveY()*Math.sin(angle)+b.getMoveY()*Math.sin(angle);
        y *= -1;
        a.setMoveX(x);
        a.setMoveY(y);
        x = a.getMoveX()*Math.cos(angle)+b.getMoveX()*Math.cos(angle);
        y = a.getMoveY()*Math.sin(angle)+b.getMoveY()*Math.sin(angle);
        b.setMoveX(x);
        b.setMoveY(y);
        
        
    }
    public double checkdiametro(Bola a, Bola b){
        double x = pow(b.getX() -a.getX(),2);
        double y = pow(b.getY() -a.getY(),2);
        double result = sqrt(x+y);
        return result;
    }
    public void paint(Graphics g){
        for(int i=0; i<cajon.size();i++){
           cajon.get(i).paint(g);
           
        }
    }
}
