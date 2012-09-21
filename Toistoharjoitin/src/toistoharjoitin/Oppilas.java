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
    private ArrayList<String> listaListoista;
    private String tunnus;
    
    public Oppilas(String tunnus){
    this.tunnus = tunnus;    
        try {
            Scanner lukija = new Scanner(new File(tunnus + ".txt"));
            while (lukija.hasNextLine()){
                String rivi = lukija.nextLine();
                this.listaListoista.add(rivi);
            }
        }
        catch (Exception e){
            System.out.println("Virhe lataamisessa");
        }
        
    }
   // public Kysely avaaKysely(String lista){
        // tämä tarkastaa onko tallaista listaa jo kyselty, jos on lataaTilanne
    // jos ei ole luo nollatilanne
    // avaaminen onnistuu ehkä konkatenoimalla tunnusjalista ja että tilanne on tallennettu sillä nimellä?
    
    //}
    
}
