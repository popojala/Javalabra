package toistoharjoitin;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *ApuOlio jonka metodit palauttavat lukemastaan tekstitiedostosta
 * arraylistin tai treemapin. 
 *
 * @author Paavo
 */
public class Lukija {

    public ArrayList<String> lueRivitListaksi(String listanNimi) {
        String tiedostonimi = listanNimi + ".txt";
        ArrayList<String> listat = new ArrayList<String>();
        try {
            Scanner lukija = new Scanner(new File(tiedostonimi), "UTF-8");
            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                listat.add(rivi);
            }
        } catch (Exception e) {
            System.out.println("Virhe listan nimoinn lataamisessa");
        }
        return listat;
    }
    
    public TreeMap<String, String> lueTiedostoTreeMapiksiSS(String tiedostonimi, String erotin){
        TreeMap<String, String> sanalista = new TreeMap<String, String>();
        try {
            Scanner lukija = new Scanner(new File(tiedostonimi + ".txt"));
            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                String[] temp;
                temp = rivi.split(erotin, 2);
                sanalista.put(temp[0], temp[1]);
 }
        } catch (Exception e) {
            System.out.println("Virhe sanalistan lataamisessa!");
        }
        return sanalista;
    }
    
    public TreeMap<String, Integer> lueTiedostoTreeMapiksiSI(String tiedostonimi, String erotin){
        TreeMap<String, Integer> sanaJaNumero = new TreeMap<String, Integer>();
        try {
            Scanner lukija = new Scanner(new File(tiedostonimi + ".txt"));
            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                String[] temp;
                temp = rivi.split(" ", 2);
                int numero = Integer.parseInt(temp[1]);
                sanaJaNumero.put(temp[0], numero);
 }
        } catch (Exception e) {
            System.out.println("Virhe tietamisten lataamisessa!");
        }
        return sanaJaNumero;
    }
}
