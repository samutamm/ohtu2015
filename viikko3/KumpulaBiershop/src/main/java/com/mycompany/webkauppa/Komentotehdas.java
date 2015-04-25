
package com.mycompany.webkauppa;

import com.mycompany.webkauppa.ohjaus.OstoksenLisaysKoriin;
import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;

/**
 *
 * @author samutamm
 */
public class Komentotehdas {

    public Komentotehdas() {
    }
    
    public OstoksenLisaysKoriin ostoksenLisaysKoriin(Ostoskori ostoskori, long tuoteId) {
        return new OstoksenLisaysKoriin(ostoskori, tuoteId);
    }
}
