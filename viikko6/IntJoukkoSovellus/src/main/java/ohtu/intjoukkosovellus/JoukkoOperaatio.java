
package ohtu.intjoukkosovellus;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author samutamm
 */
public class JoukkoOperaatio {
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        Arrays.stream(aTaulu).forEach(x::lisaa);
        Arrays.stream(bTaulu).forEach(x::lisaa);
        return x;
    }

    private static Set<Integer> taulukkoSetiksi(int[] taulukko) {
        Integer[] integerSetti = ArrayUtils.toObject(taulukko);
        return Arrays.stream(integerSetti).collect(Collectors.toSet());
    }
    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray(); 
        Set<Integer> bSetti = taulukkoSetiksi(bTaulu);
        Arrays.stream(aTaulu)
                .filter(x -> bSetti.contains(x))
                .forEach(y::lisaa);
        return y;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        Arrays.stream(aTaulu).forEach(z::lisaa);
        Arrays.stream(bTaulu).forEach(z::poista);
        return z;
    }
}
