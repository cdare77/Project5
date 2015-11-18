package prj5;

import CS2114.Button;
import CS2114.Window;

public class DataVisualizationWindow {

    private SortedList<Song> list;
    private Window window;
    private Button sortByArtist;
    private Button sortByGenre;
    private Button sortByTitle;
    private Button sortByReleaseYear;
    private Button prev;
    private Button next;
    private Button repHobby;
    private Button repMajor;
    private Button repRegion;
    private Button quit;
    
    private SongShape song1;
    
    
    public DataVisualizationWindow(SortedList<Song> list) {
        this.list = list;
        window = new Window();
        window.setInfoText("Project 5");
        
        
        song1 = new SongShape(window, 80, 50, list, list.get(0));

    }
}
