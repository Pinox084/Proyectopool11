
package Controles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class ControlTeclado extends JPanel implements KeyListener {

    
    public ControlTeclado(){
        this.addKeyListener(this);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.VK_A==e.getKeyCode()){
            System.out.println("presionaste A ");
        }
        if(e.VK_D == e.getKeyCode()){
            System.out.println("presionaste D ");
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
