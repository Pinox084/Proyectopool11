package codigopool;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Botones extends JPanel implements KeyListener{
    public Botones(){
    }
    
    public void potencia(){
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.VK_A==e.getKeyCode()){
            System.out.println("presionaste A ");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
