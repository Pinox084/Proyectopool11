
package codigopool;


import java.awt.Graphics;
import java.util.ArrayList;

public class Cajon {
    private ArrayList<Bola> cajon;
    
    public Cajon(){
        cajon = new ArrayList();
    }
    
    public void newBola(Bola nueva){
        System.out.print(nueva.getNumber());
        cajon.add(nueva);
    }
    public void mover(){
        for (int i = 0; i < cajon.size(); i++) {
            cajon.get(i).move();
        }
                
    }
    public void ColisionBorder(float x, float y, float width, float height){
        
        for (int i = 0; i < cajon.size(); i++) {
            
            if((cajon.get(i).getX() <= x) || (cajon.get(i).getX() >= width) ){
                float aux = cajon.get(i).getMoveX() * -1;
                cajon.get(i).setmoveX(aux);
            
            }
            if((cajon.get(i).getY() <= y) || (cajon.get(i).getY() >= height) ){
                float aux2 = cajon.get(i).getMoveY() * -1;
                cajon.get(i).setMoveY(aux2);
            }
            
            
        }
        
    }
    
    public void ColisionBall(){
        
    }
    public void Colision(){
        
    }
    
    public void paint(Graphics g){
        for(int i=0; i<cajon.size();i++){
           cajon.get(i).paint(g);
           
        }
    }
}
