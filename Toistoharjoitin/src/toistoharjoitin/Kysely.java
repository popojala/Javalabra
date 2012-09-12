/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoitin;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;
/**
 *
 * @author Paavo
 */
public class Kysely{
    private TreeMap<String, String> sanalista;
    private ArrayList<String> sanat;
    private TreeMap<String, Integer> tietamiset;
    
    
    
    public Kysely(){
        TreeMap<String, String> tyhjasanalista = new TreeMap<String, String>();
        ArrayList<String> tyhjasanat = new ArrayList<String>();
        TreeMap<String, Integer> tyhjatietamiset = new TreeMap<String, Integer>();
        this.sanalista = tyhjasanalista;
        this.sanat = tyhjasanat;
        this.tietamiset = tyhjatietamiset;
        
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
   
    
    
    public String kysySana(int index){
        return sanat.get(index);
        }
   
    public String OikeaVastaus(String sana){
        return (sanalista.get(sana));
    }
    
    public boolean tarkistaVastaus(String sana, String vastaus){
        return vastaus.equals(OikeaVastaus(sana));
    }
    public void kirjaaTulos(String sana, String vastaus){
        if (tarkistaVastaus(sana, vastaus)){
            tietamiset.put(sana, tietamiset.get(sana)+1);
            System.out.println("Oikein!");
        }
        else {
            tietamiset.put(sana, 0);
            System.out.println("Oikea vastaus olisi ollut " + sanalista.get(sana));
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
