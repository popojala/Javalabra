/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;
import toistoharjoitin.Kysely;

/**
 *
 * @author Paavo
 */
public class KyselijaTest {
    
    Kysely kys;

    
    public KyselijaTest() {
    }
    

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        kys= new Kysely();
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void lisaakoSanan(){
        kys.lisaaSanapari("en bil", "auto");
        kys.lisaaSanapari("Italia", "Rooma");
        assertEquals(2, kys.listanKoko());
    }
    @Test
    public void toimiikoOikeaVastaus(){
        kys.lisaaSanapari("apina", "monkey");
        assertEquals("monkey", kys.OikeaVastaus("apina"));
    }
}
          

