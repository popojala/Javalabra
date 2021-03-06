package toistoharjoitin;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.ArrayList;
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
        kys = new Kysely("testi", "englanti");
        kys.luoTilanne();
        

    }

    @After
    public void tearDown() {
        (new File("testienglantitietamiset.txt")).delete();
        (new File("testienglantisanat.txt")).delete();
        (new File ("testienglantisanalista.txt")).delete();
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
    @Test public void tallentaako(){
        kys.kysySana();
        kys.kirjaaTulos("poika", "boy");
        kys.tallennaTilanne();

        assertTrue(new File ("testienglantitietamiset.txt").exists());
        assertTrue(new File ("testienglantisanat.txt").exists());
    }
    @Test public void lataakoSanat(){
        kys.kysySana();
        kys.kirjaaTulos("poika", "boy");
        kys.tallennaTilanne();
        kys.lataaTilanne();
        assertEquals("hevonen", kys.kysySana());
    }
    @Test public void lataakoTietamiset(){
        kys.kysySana();
        kys.kirjaaTulos("poika", "boy");
       
        assertEquals(3, kys.Tietamiskerrat("poika"));
}
}
