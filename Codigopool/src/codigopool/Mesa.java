package codigopool;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Mesa {

    public int puntos;
    private float X;
    private float Y;
    private float width;
    private float height;
    public Cajon caja;
    private ArrayList<Huecos> huecos;
    public boolean flaginit;
    private double potx;
    private double poty;
    private double mod;
    

    public Mesa(float x, float y, float a, float b) {
        /*Constructor*/
        X = x;
        Y = y;
        width = a;
        height = b;
        huecos = new ArrayList();
        caja = new Cajon();
        flaginit = false;
        puntos = 0;
        mod = 1;
        newHuecos();
    }

    public void newHuecos() {
        huecos.add(new Huecos(210,200,30));
        huecos.add(new Huecos(500,200,30));
        huecos.add(new Huecos(790,200,30));
        huecos.add(new Huecos(210,500,30));
        huecos.add(new Huecos(500,500,30));
        huecos.add(new Huecos(790,500,30));
    }

    public void golpear(double a, double b) {
        /*Ejecuta el movimiento de la Bola del jugador dependiendo de donde se apunte*/
        Bola player = caja.getBall();
        if (caja.checkvelocity() == false) {
            if(mod != 0){
                modificadorPotencia(player, a,b);
                caja.setMove(potx, poty);
            }
            
            
            mod = 1;
            game();
        }

    }
    
    public void modificadorPotencia(Bola player, double a , double b){
        /*Modifica la potencia del golpe del palo*/
        a = a - player.getX();
        b = b - player.getY();
        double angulo = Math.atan2(b,a);       
        potx = 20 * Math.cos(angulo);
        poty = 20 * Math.sin(angulo);
        potx *= mod*10;
        poty *= mod*10;
       
        
    }
    
    public void Modificador(int n){
        /*Cambia la constante de la potencia del golpe*/
        mod += n;
        if(mod <= 1){
            mod = 1;
        }
        if(mod >= 3){
            mod =3;
        }
        System.out.println(mod);
    }
    
    public void game() {
        /*Metodo que genera el loop y la revision de choques en el juego*/
        for (int i = 0; i < huecos.size(); i++) {
            caja.checkpuntos(huecos.get(i));
        }
        puntos = puntos + caja.checkdiscount();
        if (puntos < 0) {
            puntos = 0;
        }
        caja.ColisionBall();
        caja.ColisionBorder(X, Y, width, height);
        caja.mover();
        //System.out.println("puntos : " + puntos);
        /*if( caja.checkCantidad() == 1){   
        }*/

    }

    public void initPosition(int n) {
        /*Inicializa las posiciones de las Bolas*/
        if (flaginit == false) {
            if (n == 8) {
                caja.newPlayer(new BolaJugador(X + 300, Y + 20, 0));
                for (int i = 1; i < 5; i++) {
                    float pox = X + 80 + i * 10;
                    float poy = Y + 65 + (float) i * 20;
                    caja.newBola(new BolaColores(pox, poy, i));
                }
                
                for (int i = 5; i < 8; i++) {
                    float pox = X + 25 + i * 10;
                    float poy = Y +0 + (float) i * 20;
                    caja.newBola(new BolaColores(pox, poy, i));
                }
                float pox = X + -15 + 8 * 10;
                float poy = Y -25 + (float) 8 * 20;
                caja.newBola(new BolaColores(pox, poy, 8));
                Pantalla.p.repaint();
                flaginit = true;
                
            }
            if(n==15){
                caja.newPlayer(new BolaJugador(X + 300, Y + 20, 0));
                for (int i = 1; i < 6; i++) {
                    float pox = X + 90 + i * 10;
                    float poy = Y + 80 + (float) i * 20;
                    caja.newBola(new BolaColores(pox, poy, i));
                }
                
                for (int i = 6; i < 10; i++) {
                    float pox = X + 25 + i * 10;
                    float poy = Y +0 + (float) i * 20;
                    caja.newBola(new BolaColores(pox, poy, i));
                }
                for (int i = 10; i < 13; i++) {
                    float pox = X + -30 + i * 10;
                    float poy = Y +-60 + (float) i * 20;
                    caja.newBola(new BolaColores(pox, poy, i));
                }
                for (int i = 13; i < 15; i++) {
                    float pox = X + -75 + i * 10;
                    float poy = Y -100 + (float) i * 20;
                    caja.newBola(new BolaColores(pox, poy, i));
                }
                float pox = X + -110 + 15 * 10;
                float poy = Y -120 + (float) 15 * 20;
                caja.newBola(new BolaColores(pox, poy, 15));
                Pantalla.p.repaint();
                flaginit = true;
            }
            
            
        }

    }
    
    public void Restart(){
        /*Reinicia las posiciones del juego*/
        caja.clear();
        flaginit = false;
        puntos = 0;
        Pantalla.p.repaint();
    }
    public void paint(Graphics g) {

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect((int) X - 15, (int) Y - 15, (int) width + 30, (int) height + 30);
        g.setColor(Color.green);
        g.fillRect((int) X, (int) Y, (int) width, (int) height);
        caja.paint(g);
        for (int i = 0; i < 6; i++) {
            huecos.get(i).paint(g);
        }
    }

}
