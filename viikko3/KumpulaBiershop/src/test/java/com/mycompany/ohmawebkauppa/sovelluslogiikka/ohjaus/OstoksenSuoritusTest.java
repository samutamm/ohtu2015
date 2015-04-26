
package com.mycompany.ohmawebkauppa.sovelluslogiikka.ohjaus;

import com.mycompany.webkauppa.ohjaus.Komento;
import com.mycompany.webkauppa.ohjaus.OstoksenSuoritus;
import com.mycompany.webkauppa.sovelluslogiikka.*;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tehdas.Tehdas;
import tehdas.TestiTehdas;

public class OstoksenSuoritusTest {
    PankkiFasaadi pankki = PankkiFasaadi.getInstance();
    PankkiFasaadi hylkaavaPankki = teeHylkaavaPankki();
    ToimitusjarjestelmaFasaadi toimitusJarjestelma = ToimitusjarjestelmaFasaadi.getInstance();
    Varasto varasto = Varasto.getInstance();
    Tehdas tehdas;
    
    long tuoteId1;
    long tuoteId2;
    Tuote tuote1;
    Tuote tuote2;
    Ostoskori kori;
    String nimi;
    String osoite;
    String luottokortti;

    OstoksenSuoritus ostoksenSuoritus;
    
    @Before
    public void setUp() {
        nimi = "Arto Vihavainen";
        osoite = "Herttoniemenranta 10 Helsinki";
        luottokortti = "12345";
        
        tuoteId1 = 1;
        tuote1 = varasto.etsiTuote(tuoteId1);
        tuoteId2 = 2;
        tuote2 = varasto.etsiTuote(tuoteId2);
        
        kori = new Ostoskori();
        kori.lisaaTuote(tuote1);        
        kori.lisaaTuote(tuote2);
        tehdas = new TestiTehdas();
    }
    
    @Test
    public void josMaksuOnnistuuKoriTyhjenee() {
        ostoksenSuoritus = (OstoksenSuoritus)tehdas.ostoksenSuoritus(nimi, osoite, luottokortti, kori, varasto);
        ostoksenSuoritus.suorita();

        assertEquals(0, kori.ostokset().size());
        assertEquals(0, kori.hinta()); 
        assertEquals(0, kori.tuotteitaKorissa());         
    }
    
    @Test
    public void josMaksuOnnistuuPankinRajapintaaKaytetty() {
        ostoksenSuoritus = (OstoksenSuoritus)tehdas.ostoksenSuoritus(nimi, osoite, luottokortti, kori, varasto);
        ostoksenSuoritus.suorita();       
    }   

    @Test
    public void josMaksuOnnistuuToiRajmituksenapintaaKaytetty() {
        ostoksenSuoritus = (OstoksenSuoritus)tehdas.ostoksenSuoritus(nimi, osoite, luottokortti, kori, varasto);
        ostoksenSuoritus.suorita();       
    }             

    // - tyhjä kori, nimi tai osoite -> ei kutsuta pankkia, ei toimitusta
     
    @Test
    public void josPankkiEiHyvaksyMaksuaPalautetaanFalseToimitustaEiTehda() {        
        ostoksenSuoritus = (OstoksenSuoritus)tehdas.ostoksenSuoritus(nimi, osoite, luottokortti, kori, varasto);
        ostoksenSuoritus.setPankki(hylkaavaPankki);
 
        
        assertFalse( ostoksenSuoritus.suorita() );
        
        // assertSomething
    } 
    
    // epäonnistuessa kori säilyy ennallaan
    
    private PankkiFasaadi teeHylkaavaPankki() {
        return new PankkiFasaadi(){

            @Override
            public boolean maksa(String nimi, String luottokortti, int hinta) {
                return false;
            }
                        
        };
    }
}
