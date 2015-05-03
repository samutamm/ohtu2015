package ohtu.kivipaperisakset.kps;

import ohtu.kivipaperisakset.pelaaja.Tekoaly;
import java.util.Scanner;
import ohtu.kivipaperisakset.Tuomari;
import ohtu.kivipaperisakset.pelaaja.Pelaaja;
import ohtu.kivipaperisakset.pelaaja.IhmisPelaaja;

/**
 *
 * @author samutamm
 */
public abstract class KPS {

    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        //Pelaaja pelaaja1 =  new IhmisPelaaja();
        Pelaaja pelaaja1 = asetaEnsimmainenPelaaja();
        //Pelaaja pelaaja2 = new Tekoaly();
        Pelaaja pelaaja2 = asetaToinenPelaaja();
        String ekanSiirto = "";
        String tokanSiirto = "";

        ekanSiirto = teeVuoro(pelaaja1, ekanSiirto);
        tokanSiirto = teeVuoro(pelaaja2, tokanSiirto);

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            ekanSiirto = teeVuoro(pelaaja1, ekanSiirto);
            tokanSiirto = teeVuoro(pelaaja2, tokanSiirto);
            
            pelaaja2.asetaSiirto(ekanSiirto);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private String teeVuoro(Pelaaja pelaaja, String ekanSiirto) {
        System.out.println(pelaaja);
        ekanSiirto = pelaaja.annaSiirto();
        if (pelaaja.tarvitseeTulostuksen()) {
            System.out.println(ekanSiirto);
        }
        return ekanSiirto;
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    protected abstract Pelaaja asetaEnsimmainenPelaaja();

    protected abstract Pelaaja asetaToinenPelaaja();
}
