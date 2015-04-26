package com.mycompany.ohmawebkauppa.sovelluslogiikka.ohjaus;

import com.mycompany.webkauppa.ohjaus.Komento;
import com.mycompany.webkauppa.ohjaus.OstoksenPoistoKorista;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.webkauppa.sovelluslogiikka.*;
import tehdas.Tehdas;
import tehdas.TestiTehdas;

public class OstoksenPoistoKoristaTest {

    Varasto varasto = Varasto.getInstance();
    Ostoskori kori;
    long tuoteid = 1;
    Komento ostoksenPoisto;
    Tehdas tehdas;

    @Before
    public void setUp() {
        Tuote tuote = varasto.etsiTuote(tuoteid);
        kori = new Ostoskori();
        kori.lisaaTuote(tuote);
        tehdas = new TestiTehdas();
    }

    @Test
    public void poistettuTuoteEiEnaaKorissa() {
        ostoksenPoisto = tehdas.ostoksenPoistoKorista(kori, tuoteid, varasto);
        ostoksenPoisto.suorita();
    
        assertEquals(0, kori.tuotteitaKorissa());
        assertEquals(0, kori.hinta());
        assertEquals(0, kori.ostokset().size());
    }
    
    @Test
    public void tuotteenMaaraKasvaa(){
        int varastossaAluksi = varasto.etsiTuote(tuoteid).getSaldo();
        
        ostoksenPoisto = tehdas.ostoksenPoistoKorista(kori, tuoteid, varasto);
        ostoksenPoisto.suorita();
    
        assertEquals(varastossaAluksi+1, varasto.etsiTuote(tuoteid).getSaldo());
    }

}
