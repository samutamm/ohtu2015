package ohtuesimerkki;

import java.util.*;
import java.util.stream.Stream;

import org.junit.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {

    private static Statistics stats;

    @BeforeClass
    public static void setUpClass() {
      Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
      };
      stats = new Statistics( readerStub );
    }


    @Test
    public void searchDoesNotReturnNonExistingPlayer() {
      assertEquals(stats.search("Late"), null);
    }

    @Test
    public void searchDoReturnExistingPlayer() {
        Player player = stats.search("Semenko");
        assertEquals(player.getName(), "Semenko");
    }

    @Test
    public void nonexistingTeamIsEmpty() {
        List<Player> team = stats.team("HNMKY");
        assertEquals(team.size(), 0);
    }

    @Test
    public void existingTeamContainsPlayers() {
        List<Player> team = stats.team("EDM");
        final long players = team.stream().map(player -> player.getName()).count();
        assertEquals(players, 3);
    }

    @Test
    public void topZeroListIsEmpty() {
        assertTrue(stats.topScorers(0).isEmpty());
    }

    @Test
    public void top2AreInCorrectOrder() {
        List<Player> list = stats.topScorers(2);
        final Player top1 = list.stream().max(Comparator.comparing(player -> player.getPoints())).get();
        final Player top2 = list.stream().min(Comparator.comparing(player -> player.getPoints())).get();

        assertEquals(list.size(), 2);
        assertEquals(top1.getName(), "Gretzky");
        assertEquals(top2.getName(), "Lemieux");
    }

    @Test
    public void top6AreInCorrectOrder() {
        ArrayList<Player> players = new ArrayList<Player>();

        players.add(new Player("Semenko", "EDM", 4, 12));
        players.add(new Player("Lemieux", "PIT", 45, 54));
        players.add(new Player("Kurri",   "EDM", 37, 53));
        players.add(new Player("Yzerman", "DET", 42, 56));
        players.add(new Player("Gretzky", "EDM", 35, 89));

        Collections.sort(players);
        //Collections.reverse(players);

        final List<Player> list = stats.topScorers(5);
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i).toString(), players.get(i).toString());
        }
    }

}
