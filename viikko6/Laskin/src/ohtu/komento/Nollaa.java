
package ohtu.komento;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

/**
 *
 * @author samutamm
 */
public class Nollaa extends LaskuKomento{
    private int viimeisin;

    public Nollaa(Sovelluslogiikka logiikka, JTextField syöte, JTextField tuloste) {
        super(logiikka, syöte, tuloste);
        this.viimeisin = 0;
    }

    @Override
    public void laske(int luku) {
        this.viimeisin = logiikka.tulos();
        this.logiikka.nollaa();
    }

    @Override
    public void peru() {
        this.logiikka.plus(viimeisin);
        this.paivita();
    }
    
}
