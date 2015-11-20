package prj5;

import CS2114.Button;
import CS2114.Window;
import CS2114.WindowSide;

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
        
        setUpButtons();
    }
    
    public void setUpButtons() {
        prev = new Button("<- prev");
        window.addButton(prev, WindowSide.NORTH);
        
        sortByArtist = new Button("Sort by Artist Name");
        window.addButton(sortByArtist, WindowSide.NORTH);
        
        sortByTitle = new Button("Sort by Song Title");
        window.addButton(sortByTitle, WindowSide.NORTH);
        
        sortByReleaseYear = new Button("Sort by Release Year");
        window.addButton(sortByReleaseYear, WindowSide.NORTH);
        
        sortByGenre = new Button("Sort by Genre");
        window.addButton(sortByGenre, WindowSide.NORTH);
        
        next = new Button("next ->");
        window.addButton(next, WindowSide.NORTH);
        
        repHobby = new Button("Represent Hobby");
        repHobby.onClick(this, "clickedRepHobby");
        window.addButton(repHobby, WindowSide.SOUTH);
        
        repMajor = new Button("Represent Major");
        repMajor.onClick(this, "clickedRepMajor");
        window.addButton(repMajor, WindowSide.SOUTH);
        
        repRegion = new Button("Represent Region");
        repRegion.onClick(this, "clickedRepRegion");
        window.addButton(repRegion, WindowSide.SOUTH);
        
        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.SOUTH);
    }
    
    public void clickedQuit(Button button) {
        System.exit(0);
    }
    
    public void clickedRepMajor(Button button) {
        song1.setRepresentation(Representation.MAJOR);
    }
    
    public void clickedRepHobby(Button button) {
        song1.setRepresentation(Representation.HOBBY);
    }
    
    public void clickedRepRegion(Button button) {
        song1.setRepresentation(Representation.REGION);
    }
}
