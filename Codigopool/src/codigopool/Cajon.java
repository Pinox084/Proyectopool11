
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
    public double checkspeedX(Bola a, Bola b){
        if(abs(a.getMoveX())>= abs(b.moveX)){
            return a.getMoveX();
        }else{
            return b.getMoveX();
        }
        
    }
    public double checkspeedY(Bola a, Bola b){
        if(abs(a.getMoveY())>= abs(b.moveY)){
            return a.getMoveY();
        }else{
            return b.getMoveY();
        }
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
                double check;
                double checkx;
                double checky;
                double x =cajon.get(i).getMoveX();
                double y = cajon.get(i).getMoveY();
                check = checkdiametro(cajon.get(i), cajon.get(j));
                checkx = checkspeedX(cajon.get(i), cajon.get(j));
                checky = checkspeedY(cajon.get(i), cajon.get(j));
                if(check <= 20){
                                       
                    cajon.get(j).setMoveX(checkx);
                    cajon.get(j).setMoveY(checky);
                }
                
            }
        }
    }
    public double checkdiametro(Bola a, Bola b){
        double result;
        
        double x = pow(b.getX() -a.getX(),2);
        double y = pow(b.getY()-a.getY(),2);
        result = sqrt(x+y);
        return result;
    }
    public void paint(Graphics g){
        for(int i=0; i<cajon.size();i++){
           cajon.get(i).paint(g);
           
        }
    }
}
