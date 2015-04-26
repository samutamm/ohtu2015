
package tehdas;

import com.mycompany.webkauppa.ohjaus.Komento;
import com.mycompany.webkauppa.ohjaus.OstoksenLisaysKoriin;
import com.mycompany.webkauppa.ohjaus.OstoksenPoistoKorista;
import com.mycompany.webkauppa.ohjaus.OstoksenSuoritus;
import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;
import com.mycompany.webkauppa.sovelluslogiikka.Varasto;

/**
 *
 * @author samutamm
 */
public class TestiTehdas extends Tehdas {

    @Override
    public Komento ostoksenLisaysKoriin(Ostoskori ostoskori, long tuoteId, Varasto varasto) {
        return new OstoksenLisaysKoriin(ostoskori, tuoteId, varasto);
    }

    @Override
    public Komento ostoksenPoistoKorista(Ostoskori ostosokori, long tuoteId, Varasto varasto) {
        return new OstoksenPoistoKorista(ostosokori, tuoteId, varasto);
    }

     @Override
    public Komento ostoksenSuoritus(String nimi, String osoite, String luottokorttinumero, Ostoskori ostoskori, Varasto varasto) {
        return new OstoksenSuoritus(nimi, osoite, luottokorttinumero, ostoskori, varasto);
    }
    
}
