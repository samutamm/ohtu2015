package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(80, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void lisaaVarastoonNegatiivinenMaara() {
        varasto.lisaaVarastoon(-1);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaaVarastoonVahemmanKunMahtuu() {
        varasto.lisaaVarastoon(varasto.getTilavuus()-1);
        double saldo = varasto.getSaldo();
        assertEquals(varasto.getTilavuus()-1, saldo, vertailuTarkkuus);
    }

    @Test
    public void lisaaVarastoTayteen() {
        varasto.lisaaVarastoon(varasto.getTilavuus() + 1);
        assertEquals(varasto.getSaldo(), varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void otaVarastostaNegatiivinenMaara() {
        varasto.lisaaVarastoon(5);

        double saatiin = varasto.otaVarastosta(-4);
        assertEquals(0.0, saatiin, vertailuTarkkuus);
    }

    @Test
    public void tyhjennaVarasto() {
        varasto.lisaaVarastoon(5);

        double saldo = varasto.getSaldo();
        double saatiin = varasto.otaVarastosta(saldo +1);
        assertEquals(saldo, saatiin, vertailuTarkkuus);
    }

    @Test
    public void otaKohtuudella() {
        varasto.lisaaVarastoon(5);

        double saldo = varasto.getSaldo();
        double saatiin = varasto.otaVarastosta(saldo -1);
        assertEquals(saatiin, saldo-1, vertailuTarkkuus);
    }
    @Test
    public void konstr() {
        varasto = new Varasto(-1);
        varasto = new Varasto(0);
        varasto = new Varasto(1,1);
        varasto = new Varasto(1,2);
        varasto = new Varasto(-1,2);
        varasto = new Varasto(-1,-1);
        varasto.toString();
    }
}