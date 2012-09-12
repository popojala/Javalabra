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
        
    }
    
    @After
    public void tearDown() {
    }
    @Test
    //public void hello(){}
    public void lisasikoSanaparin(){
        Kysely kys= new Kysely();
        kys.lisaaSanapari("apina", "monkey");
        assertEquals("monkey", kys.OikeaVastaus("apina"));
    }
}
          

