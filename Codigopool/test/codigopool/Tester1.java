
package codigopool;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Tester1 {
    private Mesa mesita;
    private Cajon caja;
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
        caja = new Cajon();
    }
    
    
    
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void TestDiametro(){
        //Test que corrobora la colision entre dos Bolas
        BolaJugador player = new BolaJugador(10,10,0);
        BolaColores color = new BolaColores(12,12,1);
        assertTrue(caja.checkdiametro(player,color));
        
        
    }
    
    @Test()
    public void TestRestart(){
        /*Test que corrobora que el reinicio y seleccion de juego, exista una Bola
        dentro del arreglo de Bolas*/
        mesita.Restart();
        mesita.initPosition(8);
        assertNotNull(mesita.caja.getBall());
    }
    
}
