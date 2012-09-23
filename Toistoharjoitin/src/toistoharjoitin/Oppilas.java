/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoitin;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Paavo
 */
public class Oppilas {
    private ArrayList<String> omatListat;
    private ArrayList<String> kaikkiListat;
    private String tunnus;
    
    public Oppilas(String tunnus){
    this.omatListat = sanatListaksi(tunnus);
    this.kaikkiListat = sanatListaksi("listat");
    this.tunnus = tunnus;    
        
    }
public ArrayList<String> omatListatListana() {
    return omatListat;
}  
public ArrayList<String> kaikkiListatListana(){
    return kaikkiListat;
}
   public String listatUlos(){
       String tuloste= "";
   
       for (String sana : omatListat){
           tuloste = tuloste + sana + "\n";
       }
       return tuloste;
   }
   public Kysely avaaKysely(String lista){
       Kysely kysely = new Kysely(tunnus, lista);
       if (omatListat.contains(lista)){
           kysely.lataaTilanne();
           return kysely;
       }
       if(kaikkiListat.contains(lista)){
            kysely.luoTilanne();
            return kysely;
        }
        return null;
   }
   public ArrayList<String> sanatListaksi(String listanNimi){
       String tiedostonimi = listanNimi + ".txt";
       ArrayList<String> listat = new ArrayList<String>();
       try {
           Scanner lukija = new Scanner(new File(tiedostonimi));
            while (lukija.hasNextLine()){
                String rivi = lukija.nextLine();
                listat.add(rivi);
            }
        }
        catch (Exception e){
            System.out.println("Virhe listan nimien lataamisessa");
        }
       return listat;
   }
    
}
