package prj5;

import CS2114.Button;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * GUI which represents the data as 9
 * SongShapes, a legend, and respective buttons
 * @author Chris Dare cdare77
 * @version 11/20/2015
 */
public class GUIDataVisualizationWindow {

    private SortedList<Song> list;
    private LinkedList<GUISongShape> currentSongs;
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
    private GUILegendShape legend;
    
    private int currentPage;
    
    /**
     * Constructor for DataVisualizationWindow which
     * takes in a list to represent
     * @param list -List to represent
     */
    public GUIDataVisualizationWindow(SortedList<Song> list) {
        currentSongs = new LinkedList<GUISongShape>();
        this.list = list;
        window = new Window();
        window.setInfoText("Project 5");
        currentPage = 0;
        int i = 0;
        while (i < 9 && (9 * currentPage) + i < list.size()) {
            currentSongs.add(new GUISongShape(window, 120 + 230 * (i % 3),
                    50 + 150 * (i / 3), list, list.get((9 * currentPage) + i)));
            i++;
        }

        legend = new GUILegendShape(window, 650, 200);
        
        setUpButtons();
    }
    
    /**
     * sets up the 10 buttons for use, and assigns
     * them respective events for onClick
     */
    public void setUpButtons() {
        prev = new Button("<- prev");
        prev.onClick(this, "clickedPrev");
        window.addButton(prev, WindowSide.NORTH);
        
        sortByArtist = new Button("Sort by Artist Name");
        sortByArtist.onClick(this, "clickedSortByArtist");
        window.addButton(sortByArtist, WindowSide.NORTH);
        
        sortByTitle = new Button("Sort by Song Title");
        sortByTitle.onClick(this, "clickedSortByTitle");
        window.addButton(sortByTitle, WindowSide.NORTH);
        
        sortByReleaseYear = new Button("Sort by Release Year");
        sortByReleaseYear.onClick(this, "clickedSortByReleaseYear");
        window.addButton(sortByReleaseYear, WindowSide.NORTH);
        
        sortByGenre = new Button("Sort by Genre");
        sortByGenre.onClick(this, "clickedSortByGenre");
        window.addButton(sortByGenre, WindowSide.NORTH);
        
        next = new Button("next ->");
        next.onClick(this, "clickedNext");
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
    
    /**
     * action event executed when quit button
     * is clicked
     * @param button quitButton
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }
    
    /**
     * action event executed when repMajor
     * button is clicked
     * @param button repMajor
     */
    public void clickedRepMajor(Button button) {
        for (GUISongShape song : currentSongs) {
            song.setRepresentation(GUIRepresentation.MAJOR);
        }
        legend.setUpColorTitles(GUIRepresentation.MAJOR);
    }
    
    /**
     * action event executed when repHobby
     * is clicked
     * @param button repHobby
     */
    public void clickedRepHobby(Button button) {
        for (GUISongShape song : currentSongs) {
            song.setRepresentation(GUIRepresentation.HOBBY);
        }
        legend.setUpColorTitles(GUIRepresentation.HOBBY);
    }
    
    /**
     * action event executed when repRegion
     * is clicked
     * @param button repRegion
     */
    public void clickedRepRegion(Button button) {
        for (GUISongShape song : currentSongs) {
            song.setRepresentation(GUIRepresentation.REGION);
        }
        legend.setUpColorTitles(GUIRepresentation.REGION);
    }
    
    /**
     * action event executed when next is 
     * clicked
     * @param button next
     */
    public void clickedNext(Button button) {
        if (9 * (currentPage + 1) > list.size()) {
            return;
        }
        for (GUISongShape song : currentSongs) {
            song.removeShape();
        }
        currentSongs.clear();
        currentPage++;
        
        int i = 0;
        while (i < 9 && (9 * currentPage) + i < list.size()) {
            currentSongs.add(new GUISongShape(window, 120 + 230 * (i % 3),
                    50 + 150 * (i / 3), list, list.get((9 * currentPage) + i)));
            i++;
        }
    }
    
    /**
     * action event executed when prev is clicked
     * @param button prev
     */
    public void clickedPrev(Button button) {
        if (currentPage == 0) {
            return;
        }
        for (GUISongShape song : currentSongs) {
            song.removeShape();
        }
        currentSongs.clear();
        currentPage--;
        
        int i = 0;
        while (i < 9 && (9 * currentPage) + i < list.size()) {
            currentSongs.add(new GUISongShape(window, 120 + 230 * (i % 3),
                    50 + 150 * (i / 3), list, list.get((9 * currentPage) + i)));
            i++;
        }
    }
    
    /**
     * action event executed when sortByArtist is
     * clicked
     * @param button sortByArtist
     */
    public void clickedSortByArtist(Button button) {
        for (GUISongShape song : currentSongs) {
            song.removeShape();
        }
        currentSongs.clear();
        list.setSortMethod("artist");
        
        int i = 0;
        while (i < 9 && (9 * currentPage) + i < list.size()) {
            currentSongs.add(new GUISongShape(window, 120 + 230 * (i % 3),
                    50 + 150 * (i / 3), list, list.get((9 * currentPage) + i)));
            i++;
        }
        for (GUISongShape song : currentSongs) {
            song.setSortInfoMethod();
        }
    }
    
    /**
     * action event executed when sortByGenre is clicked
     * @param button sortByGenre
     */
    public void clickedSortByGenre(Button button) {
        for (GUISongShape song : currentSongs) {
            song.removeShape();
        }
        currentSongs.clear();
        list.setSortMethod("genre");
        
        int i = 0;
        while (i < 9 && (9 * currentPage) + i < list.size()) {
            currentSongs.add(new GUISongShape(window, 120 + 230 * (i % 3),
                    50 + 150 * (i / 3), list, list.get((9 * currentPage) + i)));
            i++;
        }
        for (GUISongShape song : currentSongs) {
            song.setSortInfoMethod();
        }
    }
    
    /**
     * action event executed when sortByReleaseYear
     * is clicked
     * @param button sortByReleaseYear
     */
    public void clickedSortByReleaseYear(Button button) {
        for (GUISongShape song : currentSongs) {
            song.removeShape();
        }
        currentSongs.clear();
        list.setSortMethod("releaseYear");
        
        int i = 0;
        while (i < 9 && (9 * currentPage) + i < list.size()) {
            currentSongs.add(new GUISongShape(window, 120 + 230 * (i % 3),
                    50 + 150 * (i / 3), list, list.get((9 * currentPage) + i)));
            i++;
        }
        for (GUISongShape song : currentSongs) {
            song.setSortInfoMethod();
        }
    }
    
    /**
     * action event executed when sortByTitle
     * is clicked
     * @param button sortByTitle
     */
    public void clickedSortByTitle(Button button) {
        for (GUISongShape song : currentSongs) {
            song.removeShape();
        }
        currentSongs.clear();
        list.setSortMethod("title");
        
        int i = 0;
        while (i < 9 && (9 * currentPage) + i < list.size()) {
            currentSongs.add(new GUISongShape(window, 120 + 230 * (i % 3),
                    50 + 150 * (i / 3), list, list.get((9 * currentPage) + i)));
            i++;
        }
        for (GUISongShape song : currentSongs) {
            song.setSortInfoMethod();
        }
    }
}
