
package ohtu.komento;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

/**
 *
 * @author samutamm
 */
public class Summa extends LaskuKomento {
    private int viimeisin;
    public Summa(Sovelluslogiikka logiikka, JTextField syöte, JTextField tuloste) {
        super(logiikka, syöte, tuloste);
        this.viimeisin = 0;
    }
    @Override
    public void laske(int luku) {
        this.logiikka.plus(luku);
        this.viimeisin = -luku;
    }

    @Override
    public void peru() {
        this.laske(viimeisin);
        this.paivita();
    }
}
