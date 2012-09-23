/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoitin;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ppoojala
 */
public class Main {
Random r;
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
        ArrayList<String> kaikkilistat = o.kaikkiListatListana();
        System.out.println(kaikkilistat);
        System.out.println("kirjoita valitsemasi listan nimi");
        String lista = input.nextLine();
        Kysely kys= new Kysely(tunnus, lista);
        
        
        String vastaus = "";
        while (!vastaus.equals("luovutan")&& kys.sanatKoko()!=0){
        String kysyttava = kys.kysySana();
        System.out.println("mikä on suomeksi " + kysyttava + " ?");
        vastaus = input.nextLine();
        kys.kirjaaTulos(kysyttava, vastaus);
        
        if (kys.tarkistaVastaus(kysyttava, vastaus)){
            System.out.println("Oikein!");
        }
        else {
            System.out.println("Oikea vastaus olisi ollut " + kys.OikeaVastaus(kysyttava));
        }
        
        
    }
        kys.tallennaTilanne();
}
}
