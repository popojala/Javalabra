/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoitin;

import java.util.ArrayList;
import java.util.TreeMap;
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
    public void lataakoArrayListin() {
        ArrayList<String> aakkosia = luk.lueRivitListaksi("lukijatestitiedosto");
        assertEquals("c", aakkosia.get(2));
    }
<<<<<<< HEAD
    @Test 
           public void ToimiikoAListlatausJosValilyonteja(){
    ArrayList<String> aakkos = luk.lueRivitListaksi("lukijatestivalilyonti");
    assertEquals("c d e", aakkos.get(1));
=======

    @Test
    public void kunTiedostoaEiOle() {
        assertEquals(null, luk.lueRivitListaksi("olematontiedosto"));
    }

    @Test
    public void tiedostossaValilyonteja() {
        ArrayList<String> lista = luk.lueRivitListaksi("lukijatestivalilyonti");
        assertEquals("tama testi toimii!", lista.get(1));
    }

    @Test
    public void tiedostossaSkandeja() {
        ArrayList<String> lista = luk.lueRivitListaksi("jeejee");
        assertEquals("Lasse Mårtenson", lista.get(1));
    }

    @Test
    public void lataakoTreemapinSS() {
        TreeMap<String, String> s = luk.lueTiedostoTreeMapiksiSS("paavo", "-");
        assertEquals(2, s.size());
    }

    @Test
    public void lataakoTreemapinSSoikein() {
        TreeMap<String, String> a = luk.lueTiedostoTreeMapiksiSS("testisanalista", " ");
        assertEquals("boy", a.get("poika"));
    }
    @Test 
    public void EiErotintaRivilla(){
        TreeMap<String, String> a = luk.lueTiedostoTreeMapiksiSS("testisanalista", "-");
        assertEquals(null, a.get("poika"));
        }
    @Test 
    public void montaErotintaRivillaA(){
        TreeMap<String, String> a = luk.lueTiedostoTreeMapiksiSS("lukijatestivalilyonti", " ");
        assertEquals(2, a.size());
    }
    @Test 
    public void montaErotintaRivillaB(){
        TreeMap<String, String> a = luk.lueTiedostoTreeMapiksiSS("lukijatestivalilyonti", " ");
        assertEquals("testi toimii!", a.get("tama"));
        assertEquals("b", a.get("a"));}
>>>>>>> 8233cbbb573bfc67b0a019629ca621d875645421
}
}
