
package statistics.matcher;

import java.util.Arrays;
import java.util.List;
import statistics.Player;

/**
 *
 * @author samutamm
 */
public class Not implements Matcher{
    private List<Matcher> matchers;

    public Not(Matcher... matcherArray) {
        this.matchers = Arrays.asList(matcherArray);
    }

    @Override
    public boolean matches(Player p) {
        return matchers.stream().noneMatch(x -> x.matches(p));
    }
    
}
