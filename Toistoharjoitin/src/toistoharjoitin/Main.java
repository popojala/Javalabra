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
        kys.lisaaSanapari("apina", "monkey");
        kys.lisaaSanapari("paavo", "ovaap");
        String kysyttava = kys.kysySana(0);
        System.out.println("mikä on suomeksi " + kysyttava + " ?");
        String vastaus = input.nextLine();
        kys.kirjaaTulos(kysyttava, vastaus);
    }
}
