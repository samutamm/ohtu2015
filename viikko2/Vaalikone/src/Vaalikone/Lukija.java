package Vaalikone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lukija {

    private Scanner lukija;
    private File tiedosto;

    public Lukija(String tiedostonNimi){
        this.tiedosto = new File(tiedostonNimi);
        System.out.println(this.tiedosto.getAbsolutePath());
        try {
            this.lukija = new Scanner(tiedosto);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lukija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> lueRivit() {
        ArrayList<String> rivit = new ArrayList<String>();
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            rivit.add(rivi);
        }

        lukija.close();
        return rivit;
    }
}
