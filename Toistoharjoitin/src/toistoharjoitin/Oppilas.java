/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoitin;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *Olio sisaltaa oppilaan tunnuksen, ja listan listoista joita Oppilas
 * on jo harjoitellut, ja onko päässyt ne läpi.
 * @author Paavo
 **/
public class Oppilas {
    private ArrayList<String> omatListat;
    private ArrayList<String> kaikkiListat;
    private String tunnus;
    
    public Oppilas(String tunnus){
    Lukija lukija = new Lukija();
    this.tunnus = tunnus;    
    this.omatListat = lukija.lueRivitListaksi(tunnus);
    this.kaikkiListat = lukija.lueRivitListaksi("listat");
    
        
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
   public void tallennaListaTiedostoksi(ArrayList<String> lista, String tiedostonimi){
        try {
            PrintWriter kirjoittaja = new PrintWriter(new File( tiedostonimi + ".txt"));
            for (String nimi : lista) {
                kirjoittaja.println(nimi);
                
            }
            kirjoittaja.close();
            
        } catch (Exception e) {
            System.out.println("Virhe kayttajan listojen paivittamisessa kirjoittamisessa!");

        }
   }
 
       
   
   
   public Kysely avaaKysely(String lista){
       Kysely kysely = new Kysely(tunnus, lista);
       if (omatListat.contains(lista)){
           kysely.lataaTilanne();
           return kysely;
       }
       if(kaikkiListat.contains(lista)){
            kysely.luoTilanne();
            omatListat.add(lista);
            tallennaListaTiedostoksi(omatListat, tunnus);
            
         return kysely;
        }
       return null;
        
   }
   /*
    * tämän voisi uudelleennimetä järkevämmäksi. esim lue txtFileriveittäin.
    */
/*  public ArrayList<String> sanatListaksi(String listanNimi){
      Lukija lukija = new Lukija();
      lukija.lueRivitListaksi(listanNimi);
      
   /*   String tiedostonimi = listanNimi + ".txt";
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
       return listat;*/
   
    
}
