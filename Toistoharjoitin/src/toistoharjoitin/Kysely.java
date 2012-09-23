/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoitin;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

/**
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
    private HashSet<String> kayttajanListat;
    

    public Kysely(String tunnus, String lista) {
        TreeMap<String, String> tyhjasanalista = new TreeMap<String, String>();
        ArrayList<String> tyhjasanat = new ArrayList<String>();
        TreeMap<String, Integer> tyhjatietamiset = new TreeMap<String, Integer>();
        this.sanalista = tyhjasanalista;
        this.sanat = tyhjasanat;
        this.tietamiset = tyhjatietamiset;
        this.tunnus = tunnus;
        this.lista = lista;
        this.kayttajanListat = kayttajanListat();
        if (kayttajanListat.contains(lista)){
            lataaTilanne();
        }
        else {
            luoTilanne();
        }
        
        

    }
    public HashSet<String> kayttajanListat(){
        HashSet<String> kaytlist = new HashSet<String>();
        try {
            Scanner lukija = new Scanner(new File(tunnus + ".txt"));
            while (lukija.hasNextLine()){
                String rivi = lukija.nextLine();
                kaytlist.add(rivi);
            }
        }
        catch (Exception e){
            System.out.println("virhe kayttajalistan lataamisessa");
        }
        return kaytlist;
    }
    
    public void luoTilanne(){
        kayttajanListat.add(lista);
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
       // Collections.shuffle(sanat);
    }

    public void lataaTilanne() {
        sanalista.clear();
        tietamiset.clear();
        sanat.clear();
        try {
            Scanner lukija = new Scanner(new File(lista + ".txt"));
            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                String[] temp;
                temp = rivi.split(" ", 2);
                sanalista.put(temp[0], temp[1]);
 }
        } catch (Exception e) {
            System.out.println("Virhe sanalistan lataamisessa!");
        }
        try {
            Scanner lukija = new Scanner(new File(tunnus + lista + "tietamiset.txt"));
            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                String[] temp;
                temp = rivi.split(" ", 2);
                int numero = Integer.parseInt(temp[1]);
                tietamiset.put(temp[0], numero);
 }
        } catch (Exception e) {
            System.out.println("Virhe tietamisten lataamisessa!");
        }
         try {
            Scanner lukija = new Scanner(new File(tunnus + lista + "sanat.txt"));
            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                sanat.add(rivi);
 }
        } catch (Exception e) {
            System.out.println("Virhe sanojen lataamisessa lataamisessa!");
    }
   
    }

    //random luokasta tämä. omarandom. leikkiluokka randomille.
    //ei ole nyt käytössä, koska teen varmaan jotenkin toisin. 
// public int satunnainen(int ylaraja){
    //     return 0;
    //}
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
//lisää se, että tämä tallentaa myös tiedon tietämismääristä
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
         try {
            PrintWriter kirjoittaja = new PrintWriter(new File( tunnus + ".txt"));
            for (String lista : kayttajanListat) {
                kirjoittaja.println(lista );
                
            }
            kirjoittaja.close();
        } catch (Exception e) {
            System.out.println("Virhe kayttajan listojen paivittamisessa kirjoittamisessa!");

        }
       
         }
      
}