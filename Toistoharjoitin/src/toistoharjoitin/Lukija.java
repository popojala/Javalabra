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
        File tiedosto = new File(tiedostonimi);
        if (!tiedosto.exists()){
            return null;}
        
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
    
    public TreeMap<String, String> lueTiedostoTreeMapiksiSS(String listanNimi, String erotin){
        TreeMap<String, String> sanalista = new TreeMap<String, String>();
        String tiedostonimi = listanNimi + ".txt";
        File tiedosto = new File(tiedostonimi);
        if (!tiedosto.exists()){
            return null;}
        try {
            Scanner lukija = new Scanner(new File(listanNimi + ".txt"));
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
        File tiedosto = new File(tiedostonimi + ".txt");
        if (!tiedosto.exists()){
            return null;}
        try {
            Scanner lukija = new Scanner(new File(tiedostonimi + ".txt", "UTF-8"));
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
