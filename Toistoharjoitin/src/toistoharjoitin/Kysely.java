/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoitin;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
/**
 *
 * @author Paavo
 */
public class Kysely{
    private TreeMap<String, String> sanalista;
    private ArrayList<String> sanat;
    private TreeMap<String, Integer> tietamiset;
    private int toleranssi = 3;
    private int uudelleenKysyminenVaara = 7;
         
    
    
    
    
    public Kysely(){
        TreeMap<String, String> tyhjasanalista = new TreeMap<String, String>();
        ArrayList<String> tyhjasanat = new ArrayList<String>();
        TreeMap<String, Integer> tyhjatietamiset = new TreeMap<String, Integer>();
        this.sanalista = tyhjasanalista;
        this.sanat = tyhjasanat;
        this.tietamiset = tyhjatietamiset;
        
    }
    
    public void LueSanalista(String tiedostonimi){
        ArrayList<String> lukuapu = new ArrayList<String>();
        try {
            Scanner lukija = new Scanner(new File(tiedostonimi));
            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                String[] temp;
                temp = rivi.split(" ", 2);
                lisaaSanapari(temp[0],temp[1]);
                
                
                
                
                
            }
        } catch (Exception e) {
            System.out.println("Virhe lataamisessa!");
        }
    }

  
    
    
 
    public void lisaaSanapari(String sana, String vastine){
        sanalista.put(sana, vastine);
        sanat.add(sana);
        tietamiset.put(sana, 2);
    }
    
    //random luokasta tämä. omarandom. leikkiluokka randomille.
    //ei ole nyt käytössä, koska teen varmaan jotenkin toisin. 
// public int satunnainen(int ylaraja){
  //     return 0;
    //}
   
    
    
    public String kysySana(){
        String sana = sanat.get(0);
        sanat.remove(0);
        return sana;
        }
   
    public String OikeaVastaus(String sana){
        return (sanalista.get(sana));
    }
    
    public boolean tarkistaVastaus(String sana, String vastaus){
        return vastaus.equals(OikeaVastaus(sana));
    }
    
    //tässä laitetaan väärin arvattu sana seitsemänneksi kysyttävien listalla.
    //Sitä pitää vielä miettiä, että toteutanko sen, että opettaja tai muu voisi
    //määrittää kuinka monen kysymyksen jälkeen kysytään uudelleen väärin
    //vastattua
    
    public void kirjaaTulos(String sana, String vastaus){
        if (tarkistaVastaus(sana, vastaus)){
            tietamiset.put(sana, tietamiset.get(sana)+1);
            System.out.println("Oikein!");
            
            //lisätään nyt aivan viimeiseksi. mahdolliset järjestysmuistamiset
            //ongelmana? Muutenkin voi keksiä paremman järjestelmän jos on aikaa.
            
            if (tietamiset.get(sana)< toleranssi){
                sanat.add(sanat.size()-1, sana);
                
            }
        }
        else {
            tietamiset.put(sana, 0);
            System.out.println("Oikea vastaus olisi ollut " + sanalista.get(sana));
            if (sanat.size()<uudelleenKysyminenVaara){
                sanat.add(sanat.size()-1, sana);
            }
            else {
                sanat.add(uudelleenKysyminenVaara-1, sana);
            }
        }
    }
    public int Tietamiskerrat(String sana){
        return tietamiset.get(sana);
    }
        
   
    public int listanKoko(){
        return sanalista.size();
    }
    public String sanatUlos(){
        String tuloste = "";
        for (String sana : sanat){
            tuloste = tuloste + sana + "\n";
        }
        return tuloste;
    }
    
            
}
