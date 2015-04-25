
package ohtu.komento;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

/**
 *
 * @author samutamm
 */
public abstract class LaskuKomento implements Komento{
    protected Sovelluslogiikka logiikka;
    private JTextField syöte;
    private JTextField tuloste;

    public LaskuKomento(Sovelluslogiikka logiikka, JTextField syöte, JTextField tuloste) {
        this.logiikka = logiikka;
        this.syöte = syöte;
        this.tuloste = tuloste;
    }
    
    @Override
    public void suorita() {
        int luku = 0;
        try {
            luku = Integer.parseInt(this.syöte.getText());
        } catch(NumberFormatException e) {
            if(!this.syöte.getText().isEmpty()) {
                return;
            }
        }
        this.laske(luku);
        paivita();
    }

    protected void paivita() {
        this.syöte.setText("");
        this.tuloste.setText(this.logiikka.tulos() + "");
    }
    
    public abstract void laske(int luku);
}
