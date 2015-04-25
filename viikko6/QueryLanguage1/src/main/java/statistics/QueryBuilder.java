
package statistics;

import java.util.ArrayList;
import java.util.List;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Not;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

/**
 *
 * @author samutamm
 */
public class QueryBuilder {
    private List<Matcher> matchers;

    public QueryBuilder() {
        this.matchers = new ArrayList<>();
    }
    
    public QueryBuilder playsIn(String team) {
        this.matchers.add(new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matchers.add(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matchers.add(new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matcherArray) {
        this.matchers.add(new Or(matcherArray));
        return this;
    }
    
    public QueryBuilder noneOf(Matcher... matcherArray) {
        this.matchers.add(new Not(matcherArray));
        return this;
    }
    
    public Matcher build() {
        Matcher ret = new And(this.matchers.toArray(new Matcher[this.matchers.size()]));
        this.matchers.clear();
        return ret;
    }
}
