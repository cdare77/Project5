package prj5;

import student.TestCase;

/**
 * Tests the methods in sorted list to ensure
 * order
 * @author Chris Dare cdare77
 * @version 11/17/2015
 */
public class SortedListTest extends TestCase {

    private SortedList<Song> list;
    private Song dontStopBelievin;
    private Song livinOnAPrayer;
    private Song pourSomeSugarOnMe;
    private Song hotlineBling;
    private Song wildestDreams;
    private Song twentyTwo;
    private Song ourSong;
    private Song redemptionSong;
    private Song letItBe;
    private Song iveGotYouUnderMySkin;
    
    @Override
    public void setUp() {
        list = new SortedList<Song>();
        
        
        dontStopBelievin = new Song("Don't Stop Believin'"
                , "Journey", "Rock", 1981);
        livinOnAPrayer = new Song("Livin' on a Prayer",
                "Bon Jovi", "Rock", 1986);
        pourSomeSugarOnMe = new Song("Pour Some Sugar on Me"
                , "Def Leopard", "Rock", 1987);
        hotlineBling = new Song("Hotline Bling",
                "Drake", "Hip-Hop / Rap", 2015);
        wildestDreams = new Song("Wildest Dreams",
                "Taylor Swift", "Pop", 2015);
        twentyTwo = new Song("22", "Taylor Swift", "Pop", 2012);
        ourSong = new Song("Our Song", "Taylor Swift", "Pop", 2006);
        redemptionSong = new Song("Redemption Song", "Bob Marley",
                "Reggae", 1976);
        letItBe = new Song("Let It Be", "The Beatles", "Rock", 1970);
        iveGotYouUnderMySkin = new Song("I've Got "
                + "You Under My Skin", "Frank Sinatra", "Jazz", 1956);
    }
    
    /**
     * Tests the add method to assure order is held
     */
    public void testAdd() {
        list.add(redemptionSong);
        list.add(dontStopBelievin);
        list.add(iveGotYouUnderMySkin);
        list.add(ourSong);
        
        assertEquals(list.toString(), "[\"Don't Stop Believin'\","
                + " Journey (1981), Genre: Rock, \"I've Got You Under"
                + " My Skin\", Frank Sinatra (1956), Genre: Jazz, "
                + "\"Our Song\", Taylor Swift (2006), Genre: Pop, "
                + "\"Redemption Song\", Bob Marley (1976), Genre: Reggae]");

        list.clear();
        
        list.add(pourSomeSugarOnMe);
        list.add(hotlineBling);
        list.add(wildestDreams);
        list.add(twentyTwo);
        list.add(letItBe);
        
        assertEquals(list.toString(), "[\"22\", Taylor Swift (2012), "
                + "Genre: Pop, \"Hotline Bling\", Drake (2015), Genre:"
                + " Hip-Hop / Rap, \"Let It Be\", The Beatles (1970),"
                + " Genre: Rock, \"Pour Some Sugar on Me\", Def Leopard "
                + "(1987), Genre: Rock, \"Wildest Dreams\", Taylor Swift"
                + " (2015), Genre: Pop]");
        
    }
    
    /**
     * Tests the compare method for several 
     * sort methods
     */
    public void testCompare() {
        assertTrue(list.compare(dontStopBelievin, livinOnAPrayer) < 0);
        
        list.setSortMethod("artist");
        
        assertTrue(list.compare(dontStopBelievin, livinOnAPrayer) > 0);
        
        list.setSortMethod("genre");
        
        assertTrue(list.compare(dontStopBelievin, livinOnAPrayer) == 0);
        
        list.setSortMethod("releaseYear");
        
        assertTrue(list.compare(dontStopBelievin, livinOnAPrayer) < 0);
        
    }
    
    /**
     * Tests setSortMethod() and passively tests sort 
     */
    public void testSetSortMethod() {
        list.add(redemptionSong);
        list.add(dontStopBelievin);
        list.add(iveGotYouUnderMySkin);
        list.add(ourSong);
        
        assertEquals(list.toString(), "[\"Don't Stop Believin'"
                + "\", Journey (1981), Genre: Rock, \"I've Got"
                + " You Under My Skin\", Frank Sinatra (1956), "
                + "Genre: Jazz, \"Our Song\", Taylor Swift (2006),"
                + " Genre: Pop, \"Redemption Song\", Bob Marley"
                + " (1976), Genre: Reggae]");
        
        list.setSortMethod("artist");
        
        assertEquals(list.toString(), "[\"Redemption Song\","
                + " Bob Marley (1976), Genre: Reggae, \"I've "
                + "Got You Under My Skin\", Frank Sinatra "
                + "(1956), Genre: Jazz, \"Don't Stop Believin'\""
                + ", Journey (1981), Genre: Rock, \"Our Song\","
                + " Taylor Swift (2006), Genre: Pop]");
        
        list.setSortMethod("releaseYear");
        
        assertEquals(list.toString(), "[\"I've Got You Under"
                + " My Skin\", Frank Sinatra (1956), Genre: Jazz"
                + ", \"Redemption Song\", Bob Marley (1976), "
                + "Genre: Reggae, \"Don't Stop Believin'\", Journey"
                + " (1981), Genre: Rock, \"Our Song\", Taylor Swift"
                + " (2006), Genre: Pop]");
        
        list.setSortMethod("genre");
        
        assertEquals(list.toString(), "[\"I've Got You Under My Skin"
                + "\", Frank Sinatra (1956), Genre: Jazz, \"Our Song\""
                + ", Taylor Swift (2006), Genre: Pop, \"Redemption Song\""
                + ", Bob Marley (1976), Genre: Reggae, \"Don't Stop"
                + " Believin'\", Journey (1981), Genre: Rock]");
        
        list.setSortMethod("title");
        
        assertEquals(list.toString(), "[\"Don't Stop Believin'"
                + "\", Journey (1981), Genre: Rock, \"I've Got"
                + " You Under My Skin\", Frank Sinatra (1956), "
                + "Genre: Jazz, \"Our Song\", Taylor Swift (2006),"
                + " Genre: Pop, \"Redemption Song\", Bob Marley"
                + " (1976), Genre: Reggae]");
    }

}
