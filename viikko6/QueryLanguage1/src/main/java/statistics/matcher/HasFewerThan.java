
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author samutamm
 */
public class HasFewerThan implements Matcher{
    private int value;
    private String fieldName;
    private Matcher hasAtLeast;

    public HasFewerThan(int value, String category) {
        this.value = value;
        this.fieldName = "get"+Character.toUpperCase(category.charAt(0))+category.substring(1, category.length());
        this.hasAtLeast = new HasAtLeast(value, category);
    }

    @Override
    public boolean matches(Player p) {
        return !this.hasAtLeast.matches(p);
    }
    
}
