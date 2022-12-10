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
    // private JLabel mesa;

    public Mesa(float x, float y, float a, float b) {
        X = x;
        Y = y;
        width = a;
        height = b;
        huecos = new ArrayList();
        caja = new Cajon();
        flaginit = false;
        puntos = 0;
        newHuecos();
    }

    public void newHuecos() {
        huecos.add(new Huecos(200, 190, 30));
        huecos.add(new Huecos(490, 190, 30));
        huecos.add(new Huecos(780, 190, 30));
        huecos.add(new Huecos(200, 490, 30));
        huecos.add(new Huecos(490, 490, 30));
        huecos.add(new Huecos(780, 490, 30));
    }

    public void golpear(double a, double b) {

        Bola player = caja.getBall();
        if (caja.checkvelocity() == false) {
            if(mod != 0){
                modificadorPotencia(player, a,b);
                caja.setMove(potx, poty);
            }
            
            /*potx = a - player.getX();
            poty = b - player.getY();
            System.out.println(potx+ " " + poty);
            caja.setMove(potx, poty);*/
            
            mod = 0;
            game();
        }

    }
    
    public void modificadorPotencia(Bola player, double a , double b){
        a = a - player.getX();
        b = b - player.getY();
        double tangente = b/a;
        double angulo = Math.atan2(b,a);
        System.out.println(angulo);
        potx = 20 * Math.cos(angulo);
        poty = 20 * Math.sin(angulo);
        potx *= mod*10;
        poty *= mod*10;
       
        
    }
    
    public void Modificador(int n){
        mod += n;
        if(mod <= 0){
            mod = 0;
        }
        if(mod >= 3){
            mod =3;
        }
        System.out.println(mod);
    }
    
    public void game() {

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
        if (flaginit == false) {
            if (n == 8) {
                caja.newPlayer(new BolaJugador(X + 300, Y + 20, 0));
                for (int i = 1; i < n; i++) {
                    float pox = X + 50 + i * 10;
                    float poy = Y + 10 + (float) i * 20;
                    caja.newBola(new BolaColores(pox, poy, i));

                }
                Pantalla.p.repaint();
                flaginit = true;
                
            }
            if(n==15){
                caja.newPlayer(new BolaJugador(X + 300, Y + 20, 0));
                Pantalla.p.repaint();
                flaginit = true;
            }
            
            
        }

    }
    
    public void Restart(){
        caja.clear();
        flaginit = false;
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
