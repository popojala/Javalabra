/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoitin;

import java.io.File;
import java.io.PrintWriter;
import java.util.TreeMap;

/**
 *Sisaltaa listan kayttajista ja heidan salasanoistaan.
 * Luo oppilaan, jos kayttajatunnus vastaa salasanaa
 * tai rekisteroi uuden oppilaan ja lisaa listaan kayttajan ja vastaavan
 * salasanan
 * @author Paavo
 */
public class kayttajat {

    private TreeMap<String, String> kayttajalista;

    public kayttajat() {
        Lukija lukija = new Lukija();
       this.kayttajalista =  lukija.lueTiedostoTreeMapiksiSS("kayttajat", " ");
       

    }

    public Oppilas kirjaudu(String tunnus, String salasana) {
        if (salasana.equals(kayttajalista.get(tunnus))) {
            Oppilas o = new Oppilas(tunnus);
            return o;
        } else {
            return null;
        }
    }

    public void rekisteroidy(String tunnus, String salasana) {
        if (KelpaakoTunnusJaSalasana(tunnus, salasana)) {

            kayttajalista.put(tunnus, salasana);
            try {
                PrintWriter kirjoittaja = new PrintWriter(new File("kayttajat.txt"));
                for (String a : kayttajalista.keySet()) {
                    kirjoittaja.println(a + " " + kayttajalista.get(a));

                }
                kirjoittaja.close();
            } catch (Exception e) {
                System.out.println("Virhe tiedoston kirjoittamisessa!");
            }
            try {
                PrintWriter kirjoittaja = new PrintWriter(new File(tunnus + ".txt"));
                kirjoittaja.println("tyhja");
            } catch (Exception e) {
                System.out.println("Virhe tiedoston kirjoittamisessa!");
            }
        }
    }

    public boolean KelpaakoTunnusJaSalasana(String tunnus, String salasana) {
        if (onkoMerkkia(tunnus, ' ') || onkoMerkkia(salasana, ' ') || kayttajalista.containsKey(tunnus)) {
            return false;
        }
        return true;
    }

    public boolean onkoMerkkia(String sana, char merkki) {
        for (int i = 0; i < sana.length(); i++) {
            if (sana.charAt(i) == merkki) {
                return true;
            }
        }
        return false;
    }
}
