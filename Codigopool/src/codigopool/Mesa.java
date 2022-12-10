package codigopool;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Mesa {

    private int puntos = 0;
    private float X;
    private float Y;
    private float width;
    private float height;
    public Cajon caja;
    private ArrayList<Huecos> huecos;
    // private JLabel mesa;

    public Mesa(float x, float y, float a, float b) {
        X = x;
        Y = y;
        width = a;
        height = b;
        huecos = new ArrayList();
        caja = new Cajon();
        initPosition();
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
            a = a - player.getX();
            b = b - player.getY();
            caja.setMove(a, b);
            game();
        }

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
        System.out.println("puntos : " + puntos);
        /*if( caja.checkCantidad() == 1){   
        }*/

    }

    public void initPosition() {
        caja.newPlayer(new BolaJugador(X + 300, Y + 20, 0));
        for (int i = 1; i < 8; i++) {
            float pox = X + 50 + i * 10;
            float poy = Y + 10 + (float) i * 20;
            caja.newBola(new BolaColores(pox, poy, i));

        }

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
