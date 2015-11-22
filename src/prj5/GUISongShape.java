package prj5;

import java.awt.Color;

import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

/**
 * GUI class with composition
 * relation with window. Each SongShape
 * represents one song
 * @author Chris Dare cdare77
 * @version 11/20/2015
 */
public class GUISongShape {
    
    private SortedList<Song> list;
    private Window window;
    
    private int centerX;
    private int centerY;
    
    private Song song;
    private TextShape title;
    private TextShape sortMethodInfo;
    private Shape divider;
    private Shape pinkLike;
    private Shape pinkListen;
    private Shape blueLike;
    private Shape blueListen;
    private Shape yellowLike;
    private Shape yellowListen;
    private Shape greenLike;
    private Shape greenListen;
    
    private GUIRepresentation rep;
    
    private static final int WEIGHT = 100;
    
    /**
     * Constructor of class which has composition
     * relation with window, successively calling
     * window.addShape() in order to add respective
     * elements
     * @param window -Window which composes respective
     * shapes
     * @param x -centerX position of shape
     * @param y -centerY position of shape
     * @param list -list to specify how
     * songs are currently sorted
     * @param song -Song to represent
     */
    public GUISongShape(Window window, int x, int y,
            SortedList<Song> list, Song song) {
        
        this.window = window;
        this.list = list;
        
        this.centerX = x;
        this.centerY = y;
        this.song = song;
        
        title = new TextShape(x, y - 20, song.getTitle());
        title.setBackgroundColor(Color.WHITE);
        title.setX(title.getX() - title.getWidth() / 2);
        window.addShape(title);
        
        this.setSortInfoMethod();

        divider = new Shape(x, y + 20, 5, 60, Color.BLACK);
        window.addShape(divider);
        
        rep = GUIRepresentation.HOBBY;
        setRepShapes(rep);
    }
    
    /**
     * redraws the sortMethod info under the title 
     * TextShape
     */
    public void setSortInfoMethod() {
        if (list.getSortMethod().equals("genre")) {
            sortMethodInfo = new TextShape(centerX, centerY,
                    "genre: " + song.getGenre());
        }
        else if (list.getSortMethod().equals("releaseYear")) {
            sortMethodInfo = new TextShape(centerX, centerY,
                    "year: " + song.getReleaseYear());
        }
        else {
            sortMethodInfo = new TextShape(centerX, centerY,
                    "by " + song.getArtist());
        }
        sortMethodInfo.setX(sortMethodInfo.getX() 
                - sortMethodInfo.getWidth() / 2);
        sortMethodInfo.setBackgroundColor(Color.WHITE);
        window.addShape(sortMethodInfo);
    }
    
    /**
     * redefines each pink, blue, yellow, and green
     * listen shape for hobbies
     */
    private void setUpHobbyListens() {
        int totalListens = song.totalListens();
        
        pinkListen = new Shape(centerX, centerY + 20,
                WEIGHT * song.read.listens / totalListens,
                15, new Color(255, 20, 147));
        pinkListen.setX(pinkListen.getX() - pinkListen.getWidth());
        window.addShape(pinkListen);
        
        blueListen = new Shape(centerX, centerY + 35,
                WEIGHT * song.art.listens / totalListens,
                15, Color.BLUE);
        blueListen.setX(blueListen.getX() - blueListen.getWidth());
        window.addShape(blueListen);
        
        yellowListen = new Shape(centerX, centerY + 50,
                WEIGHT * song.sports.listens / totalListens,
                15, Color.YELLOW);
        yellowListen.setX(yellowListen.getX() - yellowListen.getWidth());
        window.addShape(yellowListen);
        
        greenListen = new Shape(centerX, centerY + 65,
                WEIGHT * song.music.listens / totalListens,
                15, Color.GREEN.darker());
        greenListen.setX(greenListen.getX() - greenListen.getWidth());
        window.addShape(greenListen);
    }
    
    /**
     * redefines each pink, blue, yellow, and green
     * like shape for hobbies
     */
    private void setUpHobbyLikes() {
        
        int totalLikes = song.totalLikes();
        
        pinkLike = new Shape(centerX, centerY + 20,
                WEIGHT * song.read.likes / totalLikes,
                15, new Color(255, 20, 147));
        window.addShape(pinkLike);
        
        blueLike = new Shape(centerX, centerY + 35,
                WEIGHT * song.art.likes / totalLikes,
                15, Color.BLUE);
        window.addShape(blueLike);
        
        yellowLike = new Shape(centerX, centerY + 50,
                WEIGHT * song.sports.likes / totalLikes,
                15, Color.YELLOW);
        window.addShape(yellowLike);
        
        greenLike = new Shape(centerX, centerY + 65,
                WEIGHT * song.music.likes / totalLikes,
                15, Color.GREEN.darker());
        window.addShape(greenLike);
    }
    
    /**
     * redefines each pink, blue, yellow, and green
     * listen shape for majors
     */
    private void setUpMajorListens() {
        int totalListens = song.totalListens();
        
        pinkListen = new Shape(centerX, centerY + 20,
                WEIGHT * song.compSci.listens / totalListens,
                15, new Color(255, 20, 147));
        pinkListen.setX(pinkListen.getX() - pinkListen.getWidth());
        window.addShape(pinkListen);
        
        blueListen = new Shape(centerX, centerY + 35,
                WEIGHT * song.enge.listens / totalListens,
                15, Color.BLUE);
        blueListen.setX(blueListen.getX() - blueListen.getWidth());
        window.addShape(blueListen);
        
        yellowListen = new Shape(centerX, centerY + 50,
                WEIGHT * song.math.listens / totalListens,
                15, Color.YELLOW);
        yellowListen.setX(yellowListen.getX() - yellowListen.getWidth());
        window.addShape(yellowListen);
        
        greenListen = new Shape(centerX, centerY + 65,
                WEIGHT * song.other.listens / totalListens,
                15, Color.GREEN.darker());
        greenListen.setX(greenListen.getX() - greenListen.getWidth());
        window.addShape(greenListen);
    }
    
    /**
     * redefines each pink, blue, yellow, and green
     * like shape for major
     */
    private void setUpMajorLikes() {
        
        int totalLikes = song.totalLikes();
        
        pinkLike = new Shape(centerX, centerY + 20,
                WEIGHT * song.compSci.likes / totalLikes,
                15, new Color(255, 20, 147));
        window.addShape(pinkLike);
        
        blueLike = new Shape(centerX, centerY + 35,
                WEIGHT * song.enge.likes / totalLikes,
                15, Color.BLUE);
        window.addShape(blueLike);
        
        yellowLike = new Shape(centerX, centerY + 50,
                WEIGHT * song.math.likes / totalLikes,
                15, Color.YELLOW);
        window.addShape(yellowLike);
        
        greenLike = new Shape(centerX, centerY + 65,
                WEIGHT * song.other.likes / totalLikes,
                15, Color.GREEN.darker());
        window.addShape(greenLike);
    }
    
    /**
     * redefines each pink, blue, yellow, and green
     * listen shape for region
     */
    private void setUpRegionListens() {
        int totalListens = song.totalListens();
        
        pinkListen = new Shape(centerX, centerY + 20,
                WEIGHT * song.sEast.listens / totalListens,
                15, new Color(255, 20, 147));
        pinkListen.setX(pinkListen.getX() - pinkListen.getWidth());
        window.addShape(pinkListen);
        
        blueListen = new Shape(centerX, centerY + 35,
                WEIGHT * song.nEast.listens / totalListens,
                15, Color.BLUE);
        blueListen.setX(blueListen.getX() - blueListen.getWidth());
        window.addShape(blueListen);
        
        yellowListen = new Shape(centerX, centerY + 50,
                WEIGHT * song.otherStates.listens / totalListens,
                15, Color.YELLOW);
        yellowListen.setX(yellowListen.getX() - yellowListen.getWidth());
        window.addShape(yellowListen);
        
        greenListen = new Shape(centerX, centerY + 65,
                WEIGHT * song.foreign.listens / totalListens,
                15, Color.GREEN.darker());
        greenListen.setX(greenListen.getX() - greenListen.getWidth());
        window.addShape(greenListen);
    }
    
    /**
     * redefines each pink, blue, yellow, and green
     * like shape for region
     */
    private void setUpRegionLikes() {
        
        int totalLikes = song.totalLikes();
        
        pinkLike = new Shape(centerX, centerY + 20,
                WEIGHT * song.sEast.likes / totalLikes,
                15, new Color(255, 20, 147));
        window.addShape(pinkLike);
        
        blueLike = new Shape(centerX, centerY + 35,
                WEIGHT * song.nEast.likes / totalLikes,
                15, Color.BLUE);
        window.addShape(blueLike);
        
        yellowLike = new Shape(centerX, centerY + 50,
                WEIGHT * song.otherStates.likes / totalLikes,
                15, Color.YELLOW);
        window.addShape(yellowLike);
        
        greenLike = new Shape(centerX, centerY + 65,
                WEIGHT * song.foreign.likes / totalLikes,
                15, Color.GREEN.darker());
        window.addShape(greenLike);
    }
    
    /**
     * private helper method which determines which
     * of the respective setUp methods to call
     * for each representation
     * @param repres Representation method to compare
     */
    private void setRepShapes(GUIRepresentation repres) {
        if (repres == GUIRepresentation.HOBBY) {
            setUpHobbyListens();
            setUpHobbyLikes();
        }
        else if (repres == GUIRepresentation.MAJOR) {
            setUpMajorListens();
            setUpMajorLikes();
        }
        else {
            setUpRegionListens();
            setUpRegionLikes();
        }
        window.repaint();
    }
    
    /**
     * public method which removes all prior shapes
     * and redraws them in proper representation
     * @param represent -sets rep private variable
     * and redraws
     */
    public void setRepresentation(GUIRepresentation represent) {
        window.removeShape(blueListen);
        window.removeShape(blueLike);
        window.removeShape(yellowListen);
        window.removeShape(yellowLike);
        window.removeShape(greenListen);
        window.removeShape(greenLike);
        window.removeShape(pinkListen);
        window.removeShape(pinkLike);
        rep = represent;
        setRepShapes(rep);
    }
    
    /**
     * strictly for webcat purposes
     */
    public void webCatPurp() {
        title = new TextShape(0, 0, "title");
        divider = new Shape(0, 0, 1, 1);
    }
}
