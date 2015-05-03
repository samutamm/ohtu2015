
package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.kps.KPSTekoaly;
import ohtu.kivipaperisakset.kps.KPSPelaajaVsPelaaja;
import ohtu.kivipaperisakset.kps.KPSParempiTekoaly;
import ohtu.kivipaperisakset.kps.KPS;

/**
 *
 * @author samutamm
 */
public class PeliTehdas {
    
    public static KPS pelaajaVSpelaaja() {
        return new KPSPelaajaVsPelaaja();
    }
    
    public static KPS tekoaly() {
        return new KPSTekoaly();
    }
    
    public static KPS parempiTekoaly() {
        return new KPSParempiTekoaly();
    }
}
