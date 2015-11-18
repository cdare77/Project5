package prj5;

public class Input {

    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Song dontStopBelievin = new Song("Don't Stop Believin'"
                , "Journey", "Rock", 1981);
        Song livinOnAPrayer = new Song("Livin' on a Prayer",
                "Bon Jovi", "Rock", 1986);
        Song pourSomeSugarOnMe = new Song("Pour Some Sugar on Me"
                , "Def Leopard", "Rock", 1987);
        Song hotlineBling = new Song("Hotline Bling",
                "Drake", "Hip-Hop / Rap", 2015);
        Song wildestDreams = new Song("Wildest Dreams",
                "Taylor Swift", "Pop", 2015);
        Song twentyTwo = new Song("22", "Taylor Swift", "Pop", 2012);
        Song ourSong = new Song("Our Song", "Taylor Swift", "Pop", 2006);
        Song redemptionSong = new Song("Redemption Song", "Bob Marley",
                "Reggae", 1976);
        Song letItBe = new Song("Let It Be", "The Beatles", "Rock", 1970);
        Song iveGotYouUnderMySkin = new Song("I've Got "
                + "You Under My Skin", "Frank Sinatra", "Jazz", 1956);
        
        SortedList<Song> list = new SortedList<Song>();
        
        list.add(iveGotYouUnderMySkin);
        list.add(letItBe);
        list.add(redemptionSong);
        list.add(ourSong);
        list.add(twentyTwo);
        list.add(wildestDreams);
        list.add(hotlineBling);
        list.add(pourSomeSugarOnMe);
        list.add(livinOnAPrayer);
        list.add(dontStopBelievin);
        
        twentyTwo.setHobbyData(new SongData(25, 30),
                new SongData(35, 50),
                new SongData(40, 60), new SongData(20, 20));
        
        DataVisualizationWindow window = new DataVisualizationWindow(list);
    }
}
