
package ohtu.kivipaperisakset.pelaaja;

/**
 *
 * @author samutamm
 */
public interface Pelaaja {
    String annaSiirto();
    void asetaSiirto(String ekaSiirto);
    @Override
    String toString();
    boolean tarvitseeTulostuksen();
}
