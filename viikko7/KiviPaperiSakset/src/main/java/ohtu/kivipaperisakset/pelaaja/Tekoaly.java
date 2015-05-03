package ohtu.kivipaperisakset.pelaaja;

import ohtu.kivipaperisakset.pelaaja.Pelaaja;

public class Tekoaly implements Pelaaja{

    int siirto;

    public Tekoaly() {
        siirto = 0;
    }

    @Override
    public String annaSiirto() {
        siirto++;
        siirto = siirto % 3;

        if (siirto == 0) {
            return "k";
        } else if (siirto == 1) {
            return "p";
        } else {
            return "s";
        }
    }

    @Override
    public void asetaSiirto(String ekanSiirto) {
        // ei tehdä mitään 
    }
    
    public String toString() {
        return "Tietokone valitsi: ";
    }
    
    @Override
    public boolean tarvitseeTulostuksen() {
        return true;
    }
}
