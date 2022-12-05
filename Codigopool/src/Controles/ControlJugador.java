
package Controles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class ControlJugador extends JPanel implements MouseListener, MouseMotionListener{
    
    private double mouseX;
    private double mouseY;
    
    public ControlJugador(){
        super();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println(e.getX() + " "+ e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println(e.getX() + " "+ e.getY());
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println(e.getX() + " "+ e.getY());
    }

    
}

   