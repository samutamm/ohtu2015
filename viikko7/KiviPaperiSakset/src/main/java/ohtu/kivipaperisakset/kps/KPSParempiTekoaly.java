package ohtu.kivipaperisakset.kps;

import ohtu.kivipaperisakset.kps.KPS;
import ohtu.kivipaperisakset.pelaaja.IhmisPelaaja;
import ohtu.kivipaperisakset.pelaaja.Pelaaja;
import ohtu.kivipaperisakset.pelaaja.TekoalyParannettu;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KPS{
    
    @Override
    protected Pelaaja asetaEnsimmainenPelaaja() {
        return new IhmisPelaaja("Ensimmäisen ");
    }

    @Override
    protected Pelaaja asetaToinenPelaaja() {
        return new TekoalyParannettu(20);
    }
}
