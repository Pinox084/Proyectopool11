
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
    public void TestGeneracion(){
        
    }
    
    @Test()
    public void TestRestart(){
       
        mesita.Restart();
        mesita.initPosition(8);
        assertNotNull(mesita.caja.getBall());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
