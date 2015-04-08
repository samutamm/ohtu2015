
package ohtu.verkkokauppa;

/**
 *
 * @author root
 */
public interface PankkiRajapinta {

    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
    
}
