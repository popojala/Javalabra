/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoitin;

import java.io.File;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Paavo
 */
public class OppilasTest {

    Oppilas opp;
    Oppilas testi;

    public OppilasTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        opp = new Oppilas("pertti");
        testi = new Oppilas("testi");
    }

    @After
    public void tearDown() {
        (new File("pertti.txt")).delete();
        (new File("testi.txt")).delete();
        (new File("perttiruotsitietamiset")).delete();
        (new File("perttiruotsisanat")).delete();
        (new File("perttiruotsisanalista")).delete();
    }

    @Test
    public void loikoOppilaan() {
        ArrayList<String> list = opp.kaikkiListatListana();
        assertEquals("ruotsi", list.get(0));
        assertEquals("englanti", list.get(1));

    }

    @Test
    public void OnkoOmatListatOikein() {
        ArrayList<String> lista = testi.omatListatListana();
        assertEquals("tama testi pelaa!", lista.get(1));
    }
   @Test
    public void AvaaKyselyKunOnOmissaListoissa(){
        Kysely kys = opp.avaaKysely("ruotsi");
        kys.kysySana();
        kys.kirjaaTulos("poika", "pojka");
        kys.tallennaTilanne();
        Kysely lataus = opp.avaaKysely("ruotsi");
        assertEquals("tytto", lataus.kysySana());
        assertEquals("auto", lataus.kysySana());
                }
}
