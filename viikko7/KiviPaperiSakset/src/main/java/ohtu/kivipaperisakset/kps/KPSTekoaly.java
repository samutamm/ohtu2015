package ohtu.kivipaperisakset.kps;

import ohtu.kivipaperisakset.kps.KPS;
import ohtu.kivipaperisakset.pelaaja.Tekoaly;
import java.util.Scanner;
import ohtu.kivipaperisakset.pelaaja.IhmisPelaaja;
import ohtu.kivipaperisakset.pelaaja.Pelaaja;

public class KPSTekoaly extends KPS {

    @Override
    protected Pelaaja asetaEnsimmainenPelaaja() {
        return new IhmisPelaaja("Ensimmäisen ");
    }

    @Override
    protected Pelaaja asetaToinenPelaaja() {
        return new Tekoaly();
    }
}