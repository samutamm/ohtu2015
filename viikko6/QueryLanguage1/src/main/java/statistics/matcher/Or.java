
package statistics.matcher;

import java.util.Arrays;
import java.util.List;
import statistics.Player;

/**
 *
 * @author samutamm
 */
public class Or implements Matcher {
    private List<Matcher> matchers;

    public Or(Matcher... matcherArray) {
        this.matchers = Arrays.asList(matcherArray);
    }
    

    @Override
    public boolean matches(Player p) {
        return matchers.stream().anyMatch(x -> x.matches(p));
    }
    
}
