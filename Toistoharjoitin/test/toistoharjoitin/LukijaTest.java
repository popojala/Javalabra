/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoitin;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Paavo
 */
public class LukijaTest {
    
    Lukija luk;
    public LukijaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        luk = new Lukija();
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void lataakoArrayListin(){
        ArrayList<String> aakkosia = luk.lueRivitListaksi("lukijatestitiedosto");
        assertEquals("c", aakkosia.get(2));
    }
    @Test 
           public void ToimiikoAListlatausJosValilyonteja(){
    ArrayList<String> aakkos = luk.lueRivitListaksi("lukijatestivalilyonti");
    assertEquals("c d e", aakkos.get(1));
}
}