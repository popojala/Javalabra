/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoitin;

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
        
        Kysely kys= new Kysely();
        kys.LueSanalista("sanasto.txt");
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
