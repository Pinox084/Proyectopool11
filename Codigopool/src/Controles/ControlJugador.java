
package Controles;

import codigopool.Mesa;
import codigopool.Pantalla;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import javax.swing.*;

public class ControlJugador extends JPanel implements MouseListener, MouseMotionListener, ActionListener, KeyListener {

    private double mouseX;
    private double mouseY;
    private Mesa mesita;
    public ControlJugador(Mesa mesita) {
        super();
        this.mesita = mesita;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        Timer t = new Timer(16, this);
        t.start();
        
    

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mesita.golpear(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println(e.getX() + " "+ e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //System.out.println(e.getX() + " "+ e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println(e.getX() + " "+ e.getY());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Pantalla.p.mesita.game();
        //Pantalla.p.repaint();
    }

    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.VK_A == e.getKeyCode()) {
            System.out.println("presionaste A ");
        }
        if (e.VK_D == e.getKeyCode()) {
            System.out.println("presionaste D ");
        }
        if (e.VK_1 == e.getKeyCode()) {
            System.out.println("presionaste 8 ");
            //Pantalla.p.setEleccion(1);

        }
        if (e.VK_2 == e.getKeyCode()) {
            System.out.println("presionaste 15 ");
            //Pantalla.p.setEleccion(2);
        }
        if(e.VK_5 == e.getKeyCode()){
            //Pantalla.p.mesita.aux = 1;
        }
        if(e.VK_6 == e.getKeyCode()){
            //Pantalla.p.mesita.aux = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    /*public void paint(Graphics g) {

        super.paint(g);
    }*/
}

   