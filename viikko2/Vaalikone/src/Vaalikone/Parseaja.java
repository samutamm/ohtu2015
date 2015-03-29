package Vaalikone;

import java.util.*;

public class Parseaja {

    public String[] pilkoKysymyksiin(String rivi) {
        return rivi.split(";", -1);
    }

    public String poistaPilkut(String lause) {
        String l = lause.toLowerCase();
        return l.replace(",", "");
    }

    public String[] pilkoSanoihin(String vastaus) {
        return vastaus.split(" ");
    }

    public List<Sana> laskeSanojenEsiintymat(List<String> rivit) {
        Map<String, Sana> sanatSanaOlioidenMukaan = new HashMap<>();

        for (int i = 1; i < rivit.size(); i++) {
            String rivi = rivit.get(i);
            String[] vastaukset = pilkoKysymyksiin(rivi);
            if (vastaukset.length < 13) continue;
            String vastaus = poistaPilkut(vastaukset[12]);
            sanatSanaOlioidenMukaan = kasitteleSanat(sanatSanaOlioidenMukaan, pilkoSanoihin(vastaus));
        }

        List<Sana> sanat = new ArrayList<>(sanatSanaOlioidenMukaan.values());
        sanat.sort(null);
        return sanat;
    }

    private Map<String, Sana> kasitteleSanat(Map<String, Sana> sanatSanaOlioidenMukaan, String[] sanat) {

        for (int i = 0; i < sanat.length; i++) {
            String sana = sanat[i];
            if (!sanatSanaOlioidenMukaan.containsKey(sana)) {
                sanatSanaOlioidenMukaan.put(sana, new Sana(sana));
            } else {
                sanatSanaOlioidenMukaan.get(sana).lisaa();
            }
        }
        return sanatSanaOlioidenMukaan;
    }

    public List<Sana> laskeSanaparienEsiintymat(List<String> rivit) {
        Map<String, Sana> sanatSanaOlioidenMukaan = new HashMap<>();

        for (int i = 1; i < rivit.size(); i++) {
            String rivi = rivit.get(i);
            String[] vastaukset = pilkoKysymyksiin(rivi);
            if (vastaukset.length < 13) continue;
            String vastaus = poistaPilkut(vastaukset[12]);
            String[] sanaparit = paritaSanat(pilkoSanoihin(vastaus));
            sanatSanaOlioidenMukaan = kasitteleSanat(sanatSanaOlioidenMukaan, sanaparit);
        }

        List<Sana> sanat = new ArrayList<>(sanatSanaOlioidenMukaan.values());
        sanat.sort(null);
        return sanat;
    }

    private String[] paritaSanat(String[] sanat) {
        List<String> parit = new ArrayList<>();
        for (int i = 1; i < sanat.length; i++) {
            parit.add(sanat[i-1] + " " + sanat[i]);
        }
        return parit.toArray(new String[parit.size()]);
    }
}
