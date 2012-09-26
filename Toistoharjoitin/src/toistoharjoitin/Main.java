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
 * @author ppoojala
 */
public class Main {
public static Scanner input = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("anna tunnus");
        String tunnus = input.nextLine();
        System.out.println("anna salasana");
        String salasana = input.nextLine();
        kayttajat k = new kayttajat();
        k.rekisteroidy(tunnus, salasana);
        Oppilas o = k.kirjaudu(tunnus, salasana);
        ArrayList<String> omatListat = o.omatListatListana();
        ArrayList<String> kaikkilistat = o.kaikkiListatListana();
        System.out.println(kaikkilistat);
        System.out.println("näitä olet jo kokeillut");
        System.out.println(omatListat);
        System.out.println("kirjoita valitsemasi listan nimi");
        String lista = input.nextLine();
        Kysely kys= o.avaaKysely(lista);
        
        
        String vastaus = "";
        while ( kys.sanatKoko()!=0){
        String kysyttava = kys.kysySana();
        System.out.println("mikä on suomeksi " + kysyttava + " ?");
        vastaus = input.nextLine();
        if (vastaus.equals("luovutan")){
            kys.tallennaTilanne();
            System.out.println("Jatka pelaamista myöhemmin!");
            return;
            
        }
        kys.kirjaaTulos(kysyttava, vastaus);
        
        if (kys.tarkistaVastaus(kysyttava, vastaus)){
            System.out.println("Oikein!");
        }
        else {
            System.out.println("Oikea vastaus olisi ollut " + kys.OikeaVastaus(kysyttava));
        }
        
        
    }
        System.out.println("Olet oppinut listan " + lista);
        omatListat.remove(lista);
        omatListat.add(lista + " (osattu)");
        o.tallennaListaTiedostoksi(omatListat, tunnus);
        (new File(tunnus + lista + "tietamiset.txt")).delete();
        (new File(tunnus + lista + "sanat.txt")).delete();
        
          
}
}

