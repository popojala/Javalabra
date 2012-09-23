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
public class KyselyTest {

    Kysely kys;

    public KyselyTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        kys = new Kysely("pertti", "englanti");
        

    }

    @After
    public void tearDown() {
    }
    
    @Test 
    public void luokoTilanteen(){
        assertEquals(3, kys.sanalistanKoko());
    }
    @Test
    public void kysyykoSanan(){
        assertEquals("poika", kys.kysySana());
    }
    @Test public void kysyykoToisenSanan(){
        kys.kysySana();
        assertEquals("hevonen", kys.kysySana());
    }
    @Test public void PoistaakoKysytyt(){
        kys.kysySana();
        assertEquals(2, kys.sanatKoko());
    }
    @Test public void TarkistaakoOikean(){
        assertEquals(true, kys.tarkistaVastaus("hevonen", "horse") );
    }
    @Test public void TarkistaakoVaaran(){
        assertEquals(false, kys.tarkistaVastaus("poika", "goy"));
    }
    @Test public void lisaakoVaarinVastatun(){
        kys.kirjaaTulos("poika", "goy");
        assertEquals(4, kys.sanatKoko());
    }
    @Test public void poistaakoKolmestiTiedetyn(){
        kys.kirjaaTulos("poika", "boy");
        assertEquals(3, kys.sanatKoko());
    
    }
    @Test public void paivittaakoTietamiset(){
        kys.kirjaaTulos("poika", "boy");
        assertEquals(3, kys.Tietamiskerrat("poika"));
    }
    @Test public void nollaakoTietamiset(){
        kys.kirjaaTulos("hevonen", "goat");
        assertEquals(0, kys.Tietamiskerrat("hevonen"));
    }
    @Test public void tallentaakoJaLataako(){
        kys.kysySana();
        kys.kirjaaTulos("poika", "boy");
        kys.tallennaTilanne();
        kys.lataaTilanne();
        assertEquals(3, kys.Tietamiskerrat("poika"));
    }
    }
   

