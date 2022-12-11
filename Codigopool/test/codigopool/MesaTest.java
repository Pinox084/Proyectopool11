/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package codigopool;

import java.awt.Graphics;
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
public class MesaTest {
    
    public MesaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of newHuecos method, of class Mesa.
     */
    @Test
    public void testNewHuecos() {
        System.out.println("newHuecos");
        Mesa instance = null;
        instance.newHuecos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of golpear method, of class Mesa.
     */
    @Test
    public void testGolpear() {
        System.out.println("golpear");
        double a = 0.0;
        double b = 0.0;
        Mesa instance = null;
        instance.golpear(a, b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificadorPotencia method, of class Mesa.
     */
    @Test
    public void testModificadorPotencia() {
        System.out.println("modificadorPotencia");
        Bola player = null;
        double a = 0.0;
        double b = 0.0;
        Mesa instance = null;
        instance.modificadorPotencia(player, a, b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Modificador method, of class Mesa.
     */
    @Test
    public void testModificador() {
        System.out.println("Modificador");
        int n = 0;
        Mesa instance = null;
        instance.Modificador(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of game method, of class Mesa.
     */
    @Test
    public void testGame() {
        System.out.println("game");
        Mesa instance = null;
        instance.game();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initPosition method, of class Mesa.
     */
    @Test
    public void testInitPosition() {
        System.out.println("initPosition");
        int n = 0;
        Mesa instance = null;
        instance.initPosition(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Restart method, of class Mesa.
     */
    @Test
    public void testRestart() {
        System.out.println("Restart");
        Mesa instance = null;
        instance.Restart();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paint method, of class Mesa.
     */
    @Test
    public void testPaint() {
        System.out.println("paint");
        Graphics g = null;
        Mesa instance = null;
        instance.paint(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
