
package codigopool;


import java.awt.Graphics;
import static java.lang.Math.sqrt;
import java.util.ArrayList;


/*Clase reunida en un arreglo de Bolas que corrobora toda accion de ellas entre si
y los bordes de la mesa*/
public class Cajon {
    /*Propiedades*/
    private ArrayList<Bola> cajon;
    private int flagcolor;
    private int flagwhite;
    /*Constructor*/
    public Cajon(){
        cajon = new ArrayList();
        flagcolor = 0;
        flagwhite = 0;
    }
    /*Metodos de agregacion del arreglo*/
    public void newBola(Bola nueva){
        
        cajon.add(nueva);
    }
    
    public void newPlayer(BolaJugador x){
        
        cajon.add(x);
    }
    /*Metodo que genera en ciclo el movimiento de las Bolas*/
    public void mover(){
       
        for (int i = 0; i < cajon.size(); i++) {
            cajon.get(i).move();
        }
        
    }
    /*Comando que genera el movimiento inicial de la Bola del Jugador al golpear*/
    public void setMove(double x, double y){
        cajon.get(0).setMoveX(x*0.05);
        cajon.get(0).setMoveY(y*0.05);
    }
    /*Metodo para retornar una copia de la instancia de la Bola del Jugador*/
    public Bola getBall(){
        if(cajon.size() != 0){
            return cajon.get(0);
        }
        return null;
    }
    
    /*Metodos Con los que se corrobora las colisiones entre las Clases y los Bordes*/
    public void checkpuntos(Huecos a){
        /*Metodo que chequea si cualquier bola entra a algun hueco*/
        for (int i = 0; i < cajon.size(); i++) {
            double aux = a.getX() - cajon.get(i).getX();
            double auy = a.getY() - cajon.get(i).getY();
            double mag = Math.sqrt(aux*aux+auy*auy);
            if(mag<= 11){
                if(cajon.get(i).getNumber() == 0){
                    cajon.get(0).setPosition(600, 300);
                    flagwhite =1;
                    
                }else{
                    
                    cajon.remove(cajon.get(i));
                    flagcolor=1;
                }
            }
        }
    }
    
     
    public void ColisionBorder(float x, float y, float width, float height){
        /*Metodo que analiza los choques contra los bordes*/
        
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
        
    }
    
    public void ColisionBall(){
        /*Metodo que revisa las colisiones entre las bolas*/
        for (int i = 0; i < cajon.size(); i++) {
            
            for (int j = 1; j < cajon.size(); j++) {
                
                if(i == j){
                    continue;
                }
                boolean aux = checkdiametro(cajon.get(i), cajon.get(j));
                if(  true == aux){                   
                    descolision(cajon.get(i), cajon.get(j));
                    changerColision(cajon.get(i), cajon.get(j));
                    
                }
            }
        }
        
    }
    
    public void changerColision(Bola a, Bola b){
        /*Metodo que genera el cambio de velocidades de las bolas en colision*/
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
        
        a.setMoveX(velox1*cosx-veloy1*siny);
        a.setMoveY(veloy1*cosx+velox1*siny);
        
        b.setMoveX(velox2*cosx-veloy2*siny);
        b.setMoveY(veloy2*cosx+velox2*siny);
        
       
        
        
    }
    
    public void descolision(Bola a, Bola b){
        /*Metodo que reposiciona las bolas tras detectar la colision*/
        double midx = (a.getX() +b.getX())/2;
        double midy = (a.getY() +b.getY())/2;
        
        double aux = b.getX()-a.getX() ;
        double auy = b.getY() -a.getY();
        double mag = sqrt(aux*aux +auy*auy);
        aux /= mag;
        auy /= mag;
        
        b.setPosition(midx+aux*10, midy+auy*10);
        a.setPosition(midx-aux*10, midy-auy*10);
        
    }
    
    public boolean checkdiametro(Bola a, Bola b){
        /*Metodo que corrobora la distancia entre las bolas, ayuda al detectar si se detecta la
        colision si la distancia entre ellas es menor al diametro entre ellas*/
        double x = b.getX() -a.getX();
        double y = b.getY() -a.getY();
        x = x*x;
        y = y*y;
        double result = sqrt(x+y);
        if(result <= 20){
            return true;
        }
        return false;
    }
    
    public int checkdiscount(){
        /*Genera el aumento de puntaje o descuentos tras la caida de las bolas en los huecos*/
         if(flagwhite == 1){
            if(flagcolor == 0){
                flagwhite = 0;
                return -1;
            }
            
        }else{
            if(flagcolor == 1){
                flagcolor=0;
                return 1;
            }
        }
        return 0;  
    }
    public int checkCantidad(){
        
        return cajon.size();
    }
    public boolean checkvelocity(){
        for (int i = 0; i < cajon.size(); i++) {
            if(cajon.get(i).getMoveX()!= 0){
                return true;
            }
            if(cajon.get(i).getMoveY()!= 0){
                return true;
            }
            checkdiscount();
            
        }
        
        flagcolor =0;
        flagwhite = 0;
        return false;
    }
    
    public void clear(){
        while(cajon.size() != 0){
            cajon.remove(0);
        }
            
        
    }
    public void paint(Graphics g){
        for(int i=0; i<cajon.size();i++){
           cajon.get(i).paint(g);
           
        }
    }
    
}
