
package ohtu.intjoukkosovellus;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JoukkoOperaatiotTest {
    
    
    @Test
    public void testSomething() {
        IntJoukko eka = teeJoukko(1,2);
        IntJoukko toka = teeJoukko(3,4);
        
        IntJoukko tulos = JoukkoOperaatio.yhdiste(eka, toka);
        int[] vastauksenLuvut = tulos.toIntArray();
        Arrays.sort(vastauksenLuvut);
        
        int[] odotettu = {1,2,3,4};
        
        assertArrayEquals(odotettu, vastauksenLuvut);        
    } 
    
    @Test
    public void leikkausToimii() {
        IntJoukko joukko = teeJoukko(1,2,3,10);
        IntJoukko joukko2 = teeJoukko(1,2,3,773);
        
        IntJoukko leikkaus = JoukkoOperaatio.leikkaus(joukko, joukko2);
        assertEquals(leikkaus.koko(), 3);
        assertTrue(leikkaus.kuuluu(3));
    }
    
    @Test
    public void erotusToimii() {
        IntJoukko joukko = teeJoukko(773, 1,88,2,3,10);
        IntJoukko joukko2 = teeJoukko(1,2,3,773, 5);
        IntJoukko erotus = JoukkoOperaatio.erotus(joukko, joukko2);
        assertEquals(erotus.koko(), 2);
        assertTrue(erotus.kuuluu(10));
        assertTrue(erotus.kuuluu(88));
    }

    private IntJoukko teeJoukko(int... luvut) {
        IntJoukko joukko = new IntJoukko();
        
        for (int luku : luvut) {
            joukko.lisaa(luku);
        }
        
        return joukko;
    }
}
