package codigopool;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Codigopool {

    public static void main(String[] args) {
        try {
            new Pantalla();
        } catch (InterruptedException ex) {
            Logger.getLogger(Codigopool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
