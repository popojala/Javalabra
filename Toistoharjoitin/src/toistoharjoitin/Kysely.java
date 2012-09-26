/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoitin;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

/**
 * Sisaltaa tiedot kayttajan tunnuksesta ja listasta jota kysellaan
 * niiden avulla avataan tallennetusta tiedostosta tilanne tai luodaan uusi tilanne
 * jossa on kuinka monta kertaa sana on tiedetty, ja missa jarjestyksessa
 * sanat kysytaan. 
 * 
 * @author Paavo
 */
public class Kysely {

    private TreeMap<String, String> sanalista;
    private ArrayList<String> sanat;
    private TreeMap<String, Integer> tietamiset;
    private int toleranssi = 3;
    private int uudelleenKysyminenVaara = 7;
    private String tunnus;
    private String lista;
    
    

    public Kysely(String tunnus, String lista) {
        TreeMap<String, String> tyhjasanalista = new TreeMap<String, String>();
        ArrayList<String> tyhjasanat = new ArrayList<String>();
        TreeMap<String, Integer> tyhjatietamiset = new TreeMap<String, Integer>();
        this.sanalista = tyhjasanalista;
        this.sanat = tyhjasanat;
        this.tietamiset = tyhjatietamiset;
        this.tunnus = tunnus;
        this.lista = lista;
    }
    
    public void luoTilanne(){
        
        try {
            Scanner lukija = new Scanner(new File(lista + ".txt"));
            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                String[] temp;
                temp = rivi.split(" ", 2);
                sanalista.put(temp[0], temp[1]);
                tietamiset.put(temp[0], 2);
                sanat.add(temp[0]);
                
 }
        } catch (Exception e) {
            System.out.println("Virhe luoTilanteessa!");
        }
        //*Toistaiseksi shuffle pois käytöstä, että testit toimii
        //joku pitäisi olla, että sufflaa vaan vaikka 7 ensimmäistä.
       // Collections.shuffle(sanat);
    }

    public void lataaTilanne() {
        sanalista.clear();
        tietamiset.clear();
        sanat.clear();
        Lukija luki = new Lukija();
        sanat = luki.lueRivitListaksi(tunnus + lista + "sanat");
        tietamiset = luki.lueTiedostoTreeMapiksiSI(tunnus + lista + "tietamiset", " ");
        sanalista = luki.lueTiedostoTreeMapiksiSS(lista, " ");
        
   }

    
/**
 * Metodi metodi palauttaa sanat-listan indeksissä 0 sijaitsevan
 * sanan.
 *
 * @return sana jota tahdotaan kysyä
 */
    public String kysySana() {
        String sana = sanat.get(0);
        sanat.remove(0);
        return sana;
    }

    public String OikeaVastaus(String sana) {
        return (sanalista.get(sana));
    }

    public boolean tarkistaVastaus(String sana, String vastaus) {
        return vastaus.equals(OikeaVastaus(sana));
    }

    public void kirjaaTulos(String sana, String vastaus) {
        if (tarkistaVastaus(sana, vastaus)) {
            tietamiset.put(sana, tietamiset.get(sana) + 1);


            //lisätään nyt aivan viimeiseksi. mahdolliset järjestysmuistamiset
            //ongelmana? Muutenkin voi keksiä paremman järjestelmän jos on aikaa.

            if (tietamiset.get(sana) < toleranssi) {
                sanat.add(sanat.size(), sana);

            }
        } else {
            tietamiset.put(sana, 0);
            if (sanat.size() < uudelleenKysyminenVaara) {
                sanat.add(sanat.size(), sana);
            } else {
                sanat.add(uudelleenKysyminenVaara - 1, sana);
            }
        }
    }

    public int Tietamiskerrat(String sana) {
        return tietamiset.get(sana);
    }

    public int sanalistanKoko() {
        return sanalista.size();
    }

    public int sanatKoko() {
        return sanat.size();
    }

    public String sanatUlos() {
        String tuloste = "";
        for (String sana : sanat) {
            tuloste = tuloste + sana + "\n";
        }
        return tuloste;
    }

    public void tallennaTilanne() {
        
        /*Miten näitä kannattaisi laittaa näitä
         * kirjoittajajuttuja paketteihin, ja pitäisikö tämä hajoittaa? ehkä 
         * ainakin että jokainen erikseen tallennetaan. 
         */

        try {
            PrintWriter kirjoittaja = new PrintWriter(new File(tunnus + lista + "sanat.txt"));
            for (String sana : sanat) {
                kirjoittaja.println(sana);
                
            }
            kirjoittaja.close();
        } catch (Exception e) {
            System.out.println("Virhe sanat-tiedoston kirjoittamisessa!");
        }
        try {
            PrintWriter kirjoittaja = new PrintWriter(new File( tunnus + lista + "tietamiset.txt"));
            for (String sana : tietamiset.keySet()) {
                kirjoittaja.println(sana + " " + tietamiset.get(sana));
                
            }
            kirjoittaja.close();
        } catch (Exception e) {
            System.out.println("Virhe tietamiset-tiedoston kirjoittamisessa!");
        }
         try {
            PrintWriter kirjoittaja = new PrintWriter(new File( tunnus + lista + "sanalista.txt"));
            for (String sana : sanalista.keySet()) {
                kirjoittaja.println(sana + " " + sanalista.get(sana));
                
            }
            kirjoittaja.close();
        } catch (Exception e) {
            System.out.println("Virhe tietamiset-tiedoston kirjoittamisessa!");

        }
         /*
          * tämä kirjoittaa käyttäjän tietoihin, että tätä listaa on yritetty. ongelma on, että kayttajanlistoihin pääsee
          * käsiksi parhaiten oppilas-oliosta, siellä voisi kyselyn avatessa lisätä käyttäjän listoihin
          * että tästä listasta on jo muistissa tietoja, mutta jotenkin turvallisempi olo, että
          * muistilista lisättäisiin vasta tässä tallentamisvaiheessa, eikun eikä olekaan
          */
        
       
         }
      
}