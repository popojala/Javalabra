/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoitin;

/**
 *
 * @author ppoojala
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Kysely kys= new Kysely();
        kys.lisaaSanapari("apina", "monkey");
        kys.lisaaSanapari("paavo", "ovaap");
        System.out.println(kys.sanatUlos());
    }
}
