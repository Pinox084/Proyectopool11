
package Controles;

import codigopool.Bola;
import codigopool.Mesa;
import codigopool.Pantalla;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
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
    int n;
    private boolean line;
    public ControlJugador(Mesa mesita) {
        /*Constructor JPanel */
        super();
        this.mesita = mesita;
        ImageIcon foto = new ImageIcon("fondo.png");
        JLabel marco = new JLabel();
        marco.setBounds(0, 0, 1000, 600);
        marco.setIcon(new ImageIcon(foto.getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH)));
        add(marco);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        Timer t = new Timer(2, this);
        t.start();
       
    

    }
    /*Controles de Eventos de Mouse y Teclado*/
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mesita.golpear(e.getX(), e.getY());
        line = false;
        Pantalla.p.score.changePotencia(-5);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        if(mesita.caja.checkvelocity() == false){
              line = true; 
              Pantalla.p.repaint();
            
        }else{
            line = false;
        }
            
        
    }
    public void drawLine(Graphics g, int a, int b){
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(mesita.caja.checkvelocity() == true){
            Pantalla.p.mesita.game();
            Pantalla.p.repaint();
        }
        
    }

    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.VK_S == e.getKeyCode()) {
            mesita.Modificador(-1);
            Pantalla.p.score.changePotencia(-1);
            
        }
        if (e.VK_W == e.getKeyCode()) {
            mesita.Modificador(1);
            Pantalla.p.score.changePotencia(1);
            
            
        }
        if(e.VK_R == e.getKeyCode()){
            mesita.Restart();
            
        }
        if (e.VK_1 == e.getKeyCode()) {
            mesita.initPosition(8);
            System.out.println("presionaste 8 ");
            

        }
        if (e.VK_2 == e.getKeyCode()) {
            mesita.initPosition(15);
            System.out.println("presionaste 15 ");
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    public void paint(Graphics g) {
        super.paint(g);
        mesita.paint(g);
        if(line == true){
            Bola aux = mesita.caja.getBall();
            if(aux != null){
                g.setColor(Color.MAGENTA);
                g.drawLine((int)aux.getX(), (int)aux.getY(),(int)mouseX , (int)mouseY);
            }
            
            
        }
        
    }
}

   