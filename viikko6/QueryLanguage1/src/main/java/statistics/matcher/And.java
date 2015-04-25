package statistics.matcher;

import java.util.Arrays;
import java.util.List;
import statistics.Player;

public class And implements Matcher {

    private List<Matcher> matchers;

    public And(Matcher... matcherArray) {
        this.matchers = Arrays.asList(matcherArray);
    }

    @Override
    public boolean matches(Player p) {
        return matchers.stream().allMatch(x -> x.matches(p));
    }
}
