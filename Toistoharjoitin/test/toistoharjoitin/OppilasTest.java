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
public class OppilasTest {
    
    Oppilas opp;
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
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void loikoOppilaan() {
        ArrayList<String> list = opp.kaikkiListatListana();
        assertEquals("ruotsi", list.get(0));
    
}
}
