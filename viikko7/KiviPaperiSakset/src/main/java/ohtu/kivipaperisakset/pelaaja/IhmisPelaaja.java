
package ohtu.kivipaperisakset.pelaaja;

import java.util.Scanner;

/**
 *
 * @author samutamm
 */
public class IhmisPelaaja implements Pelaaja{

    private Scanner scanner;
    private String nimi;
    
    public IhmisPelaaja(String nimi) {
        this.nimi = nimi;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String annaSiirto() {
        return scanner.nextLine();
    }

    @Override
    public void asetaSiirto(String ekaSiirto) {
        
    }
    
    @Override
    public String toString() {
        return this.nimi + " pelaajan siirto: ";
    }
    
    @Override
    public boolean tarvitseeTulostuksen() {
        return false;
    }
    
}
