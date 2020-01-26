package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void etsitaanPelaajanMaaliMaara() {
        assertEquals(4, stats.search("Semenko").getGoals());
    }
    
    @Test
    public void etsitaanOlematontaPelaajaa() {
        assertEquals(null, stats.search("Kapanen"));
    }
    
    @Test
    public void etsitaanKaikkiJoukkueenPelaajat() {
        assertEquals(3, stats.team("EDM").size());
    }
    
    @Test
    public void etsitaanParasPistemies() {
        assertEquals("Gretzky", stats.topScorers(1).get(0).getName());
    }
    
    // public Player search(String name)
    // public List<Player> team(String teamName)
    // public List<Player> topScorers(int howMany)
    
}
