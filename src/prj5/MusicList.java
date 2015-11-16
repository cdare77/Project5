package prj5;

/**
 * 
 * @author Chris Dare cdare77
 * @version 11/15/2015
 */
public class MusicList {
    
    private SortedList<Song> list;
    
    public MusicList() {
        list = new SortedList<Song>();
    }
    
    public void sortByTitle() {
        list.setSortMethod("title");
    }
    
    public void sortByArtist() {
        list.setSortMethod("artist");
    }
    
    public void sortByGenre() {
        list.setSortMethod("genre");
    }
    
    public void sortByReleaseYear() {
        list.setSortMethod("releaseYear");
    }
}
