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
        kys = new Kysely();
        kys.lisaaSanapari("apina", "monkey");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void lisaakoSanan() {
        kys.lisaaSanapari("en bil", "auto");
        kys.lisaaSanapari("Italia", "Rooma");
        assertEquals(3, kys.listanKoko());
    }
    @Test 
    public void lisaakoTietamiset(){
        assertEquals(2, kys.Tietamiskerrat("apina"));
    }

    @Test
    public void toimiikoOikeaVastaus() {
        
        assertEquals("monkey", kys.OikeaVastaus("apina"));
    }

    @Test
   public void kysyySanaa() {
        
        assertEquals("apina", kys.kysySana(0));
   }

    @Test
    public void TarkistaakoVastauksen() {
       Assert.assertTrue(kys.tarkistaVastaus("apina", "monkey"));
    }
    @Test
    public void paivittyikoOikeaTietamys(){
        kys.kirjaaTulos("apina", "monkey");
        assertEquals(3, kys.Tietamiskerrat("apina"));
    }
    @Test
    public void paivittyikoVaaraTietamys(){
        kys.kirjaaTulos("apina", "donkey");
        assertEquals(0, kys.Tietamiskerrat("apina"));
        
    }
    @Test 
    public void toimiikoSanatUlos(){
        kys.lisaaSanapari("aasi", "donkey");
        assertEquals("apina\naasi\n", kys.sanatUlos());
    }
}
