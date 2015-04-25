package ohtu.intjoukkosovellus;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        ljono = new int[kapasiteetti];
        IntStream.range(0, ljono.length).forEach(i -> ljono[i] = 0);
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) return false;
        ljono[alkioidenLkm] = luku;
        alkioidenLkm++;
        if (alkioidenLkm % ljono.length == 0) {
            kasvataTaulukkoa();
        }
        return true;
    }

    protected void kasvataTaulukkoa() {
        int[] uusiTaulukko = new int[alkioidenLkm + kasvatuskoko];
        IntStream.range(0, ljono.length).forEach(i -> uusiTaulukko[i] = ljono[i]);
        ljono = uusiTaulukko;
    }

    public boolean kuuluu(int luku) {
        return Arrays.stream(ljono).anyMatch(x -> x == luku);
    }

    public boolean poista(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (ljono[i] == luku) {
                ljono[i] = 0;
                IntStream.range(i, alkioidenLkm).forEach(this::siirraEteenpain);
                alkioidenLkm--;
                return true;
            }
        }
        return false;
    }

    public void siirraEteenpain(int kohta) {
        int apu = ljono[kohta];
        ljono[kohta] = ljono[kohta + 1];
        ljono[kohta + 1] = apu;
    }

    public int koko() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String mjono = Arrays.toString(this.toIntArray());
        mjono = mjono.replace('[', '{');
        mjono = mjono.replace(']', '}');
        return mjono;
    }

    public int[] toIntArray() {
        return Arrays.stream(ljono).filter(x -> x > 0).toArray();
    }
}
