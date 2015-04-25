package ohtu.intjoukkosovellus;

import org.junit.Before;
import org.junit.Test;

public class IntJoukkuYksiparametrisellaKonstruktorillaTest extends IntJoukkoTest {

    @Before
    @Override
    public void setUp() {
        joukko = new IntJoukko(3);
        joukko.lisaa(10);
        joukko.lisaa(3);
    }

    // perii kaikki testit luokasta IntJoukkoTest
    @Test
    public void intJoukonLuominenNegatiivisellaKapasiteetillaAiheuttaaPoikkeuksen() {
        
        exception.expect(IndexOutOfBoundsException.class);
        new IntJoukko(-33);
        //exception.expectMessage("Kapasitteetti väärin");
    }
}
