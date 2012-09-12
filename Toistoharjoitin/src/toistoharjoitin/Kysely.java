/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoitin;

import java.util.ArrayList;
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
    
    
    public int satunnainen(int ylaraja){
        return (int)(Math.random()*(ylaraja+1));
    }
   
    
    
    public String kysySana(){
        return sanat.get(satunnainen(sanat.size()));
        }
   
    public String OikeaVastaus(String sana){
        return (sanalista.get(sana));
    }
    
    public boolean tarkastaVastaus(String sana, String vastaus){
        return vastaus.equals(OikeaVastaus(sana));
    }
    public void kirjaaTulos(String vastaus, String sana){
        
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
