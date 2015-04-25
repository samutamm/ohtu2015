
package ohtu.komento;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

/**
 *
 * @author samutamm
 */
public class Erotus extends LaskuKomento {
    private int viimeisin;

    public Erotus(Sovelluslogiikka logiikka, JTextField syöte, JTextField tuloste) {
        super(logiikka, syöte, tuloste);
        viimeisin = 0;
    }

    @Override
    public void laske(int luku) {
        this.logiikka.miinus(luku);
        this.viimeisin = -luku;
    }

    @Override
    public void peru() {
        this.laske(viimeisin);
        this.paivita();
    }
}
