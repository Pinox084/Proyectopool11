
package codigopool;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicolás
 */
public class Tester1 {
    private Mesa mesita;
    public Tester1() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        new Pantalla();
        mesita = new Mesa(0,0, 400, 300);
        mesita.initPosition(8);
    }
    
    
    
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void TestGolpe(){
        mesita.Modificador(3);
        mesita.golpear(200, 300);
        Bola x = mesita.caja.getBall();
        assertNotNull(x.getMoveX());
        assertNotNull(x.getMoveY());
        
    }
    
    @Test()
    public void TestRestart(){
        
        mesita.Restart();
        mesita.initPosition(8);
        assertNotNull(mesita.caja.getBall());
    }
    
}
