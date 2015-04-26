/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tehdas;

import com.mycompany.webkauppa.ohjaus.Komento;
import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;
import com.mycompany.webkauppa.sovelluslogiikka.Varasto;

/**
 *
 * @author samutamm
 */
public abstract class Tehdas {

    public abstract Komento ostoksenLisaysKoriin(Ostoskori ostoskori, long tuoteId, Varasto varasto);
    
    public abstract Komento ostoksenPoistoKorista(Ostoskori ostosokori, long tuoteId, Varasto varasto);
    
    public abstract Komento ostoksenSuoritus(String nimi, String osoite, String luottokorttinumero, Ostoskori ostoskori, Varasto varasto);
}
