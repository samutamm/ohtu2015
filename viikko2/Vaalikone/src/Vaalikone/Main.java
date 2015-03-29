package Vaalikone;

import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        Lukija lukija = new Lukija("vastaukset_avoimena_datana.csv");
        List<String> rivit = lukija.lueRivit();

        Parseaja parse = new Parseaja();
        //tulostaSanojenTulokset(parse, rivit);
        tulosta(parse.laskeSanaparienEsiintymat(rivit));


    }

    public static void tulosta(List<Sana> sanat) {
        for(Sana s: sanat) {
            System.out.println(s);
        }
    }

}
