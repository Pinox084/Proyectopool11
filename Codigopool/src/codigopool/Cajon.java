
package codigopool;


import java.awt.Graphics;
import java.util.ArrayList;

public class Cajon {
    private ArrayList<Bola> cajon;
    public Cajon(){
        cajon = new ArrayList();
        //players = new ArrayList();
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
    public void ColisionBorder(float x, float y, float width, float height){

        
        for (int i = 0; i < cajon.size(); i++) {
            
            if((cajon.get(i).getX() <= x) || (cajon.get(i).getX() >= width+180) ){
                
                double aux = cajon.get(i).getMoveX();
                aux = aux * -1;
                cajon.get(i).setMoveX(aux);
            }
            if((cajon.get(i).getY() <= y) || (cajon.get(i).getY() >= height+180) ){
                double aux2 = cajon.get(i).getMoveY();
                aux2 = aux2 * -1;
                cajon.get(i).setMoveY(aux2);
            }
        }
    }
    
    public void ColisionBall(){
        
    }
    public void paint(Graphics g){
        for(int i=0; i<cajon.size();i++){
           cajon.get(i).paint(g);
           //players.get(i).paint(g);
        }
    }
}
