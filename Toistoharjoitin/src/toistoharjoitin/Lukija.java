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

    /**
 * Metodi lukee tiedostosta rivit ArrayListiin
 */

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
    
    /**
     * Metodi riveittäin tiedostoa ja laittaa erottimen jälkeen olevanStringin
     * treemapin valueksi, ja ennen erotinta esiintyvän pätkän keyksi. 
     * @param listanNimi
     * @param erotin
     * @return 
     */
    
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
    /**
     *  Metodi riveittäin tiedostoa ja laittaa erottimen jälkeen olevan Integerin
     * treemapin valueksi, ja ennen erotinta esiintyvän Stringin keyksi. 
     * @param listanNimi
     * @param erotin
     * @return 
     */
    
    public TreeMap<String, Integer> lueTiedostoTreeMapiksiSI(String listanNimi, String erotin){
        TreeMap<String, Integer> sananumero = new TreeMap<String, Integer>();
        String numero = "23";
        int luku = Integer.parseInt(numero);
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
                int num = nextInt(temp[1]);
                sananumero.put(temp[0], num);
 }
        } catch (Exception e) {
            System.out.println("Virhe tietamisten lataamisessa!");
        }
        return sananumero;}

    private int nextInt(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
