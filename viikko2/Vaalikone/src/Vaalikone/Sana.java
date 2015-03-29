package Vaalikone;

public class Sana implements Comparable<Sana> {
    private String sana;
    private int esiintyma;

    public Sana(String s) {
        this.sana = s;
        this.esiintyma = 1;
    }

    public void lisaa() {
        this.esiintyma++;
    }

    public String getSana() {
        return sana;
    }

    public int getEsiintyma() {
        return esiintyma;
    }

    @Override
    public int compareTo(Sana o) {
        return o.getEsiintyma() - this.getEsiintyma();
    }

    public String toString() {
        return this.getSana() + " " + this.getEsiintyma();
    }
}
