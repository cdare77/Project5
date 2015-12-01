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
        
        sortMethodInfo = new TextShape(centerX, centerY,
                "by " + song.getArtist());
        window.addShape(sortMethodInfo);
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
        window.removeShape(sortMethodInfo);
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
        int blueWeight;
        int pinkWeight;
        int yellowWeight;
        int greenWeight;
        
        if (song.read.total == 0) {
            pinkWeight = 0;
        }
        else {
            pinkWeight = WEIGHT * song.read.listens / song.read.total;
        }

        pinkListen = new Shape(centerX, centerY + 20,
                pinkWeight, 15, new Color(255, 20, 147));
        pinkListen.setX(pinkListen.getX() - pinkListen.getWidth());
        window.addShape(pinkListen);
        

        if (song.art.total == 0) {
            blueWeight = 0;
        }
        else {
            blueWeight = WEIGHT * song.art.listens / song.art.total;
        }
        blueListen = new Shape(centerX, centerY + 35,
                blueWeight, 15, Color.BLUE);
        blueListen.setX(blueListen.getX() - blueListen.getWidth());
        window.addShape(blueListen);
        
        if (song.sports.total == 0) {
            yellowWeight = 0;
        }
        else {
            yellowWeight = WEIGHT * song.sports.listens / song.sports.total;
        }
        yellowListen = new Shape(centerX, centerY + 50,
                yellowWeight, 15, Color.YELLOW.darker());
        yellowListen.setX(yellowListen.getX() - yellowListen.getWidth());
        window.addShape(yellowListen);
        
        if (song.music.total == 0) {
            greenWeight = 0;
        }
        else {
            greenWeight = WEIGHT * song.music.listens / song.music.total;
        }
        greenListen = new Shape(centerX, centerY + 65,
                greenWeight, 15, Color.GREEN.darker());
        greenListen.setX(greenListen.getX() - greenListen.getWidth());
        window.addShape(greenListen);
    }
    
    /**
     * redefines each pink, blue, yellow, and green
     * like shape for hobbies
     */
    private void setUpHobbyLikes() {
        int blueWeight;
        int pinkWeight;
        int yellowWeight;
        int greenWeight;
        
        if (song.read.totalLikes == 0) {
            pinkWeight = 0;
        }
        else {
            pinkWeight = WEIGHT * song.read.likes / song.read.totalLikes;
        }
        pinkLike = new Shape(centerX, centerY + 20,
                pinkWeight, 15, new Color(255, 20, 147));
        window.addShape(pinkLike);
        
        if (song.art.totalLikes == 0) {
            blueWeight = 0;
        }
        else {
            blueWeight = WEIGHT * song.art.likes / song.art.totalLikes;
        }
        blueLike = new Shape(centerX, centerY + 35,
                blueWeight, 15, Color.BLUE);
        window.addShape(blueLike);
        
        if (song.sports.totalLikes == 0) {
            yellowWeight = 0;
        }
        else {
            yellowWeight = WEIGHT * song.sports.likes / song.sports.totalLikes;
        }
        yellowLike = new Shape(centerX, centerY + 50,
                yellowWeight, 15, Color.YELLOW.darker());
        window.addShape(yellowLike);
        
        if (song.music.totalLikes == 0) {
            greenWeight = 0;
        }
        else {
            greenWeight = WEIGHT * song.music.likes / song.music.totalLikes;
        }
        greenLike = new Shape(centerX, centerY + 65,
                greenWeight, 15, Color.GREEN.darker());
        window.addShape(greenLike);
    }
    
    /**
     * redefines each pink, blue, yellow, and green
     * listen shape for majors
     */
    private void setUpMajorListens() {
        int blueWeight;
        int pinkWeight;
        int yellowWeight;
        int greenWeight;
        
        if (song.compSci.total == 0) {
            pinkWeight = 0;
        }
        else {
            pinkWeight = WEIGHT * song.compSci.listens / song.compSci.total;
        }

        pinkListen = new Shape(centerX, centerY + 20,
                pinkWeight, 15, new Color(255, 20, 147));
        pinkListen.setX(pinkListen.getX() - pinkListen.getWidth());
        window.addShape(pinkListen);
        

        if (song.enge.total == 0) {
            blueWeight = 0;
        }
        else {
            blueWeight = WEIGHT * song.enge.listens / song.enge.total;
        }
        blueListen = new Shape(centerX, centerY + 35,
                blueWeight, 15, Color.BLUE);
        blueListen.setX(blueListen.getX() - blueListen.getWidth());
        window.addShape(blueListen);
        
        if (song.math.total == 0) {
            yellowWeight = 0;
        }
        else {
            yellowWeight = WEIGHT * song.math.listens / song.math.total;
        }
        yellowListen = new Shape(centerX, centerY + 50,
                yellowWeight, 15, Color.YELLOW.darker());
        yellowListen.setX(yellowListen.getX() - yellowListen.getWidth());
        window.addShape(yellowListen);
        
        if (song.other.total == 0) {
            greenWeight = 0;
        }
        else {
            greenWeight = WEIGHT * song.other.listens / song.other.total;
        }
        greenListen = new Shape(centerX, centerY + 65,
                greenWeight, 15, Color.GREEN.darker());
        greenListen.setX(greenListen.getX() - greenListen.getWidth());
        window.addShape(greenListen);
    }
    
    /**
     * redefines each pink, blue, yellow, and green
     * like shape for major
     */
    private void setUpMajorLikes() {
        int blueWeight;
        int pinkWeight;
        int yellowWeight;
        int greenWeight;
        
        if (song.compSci.totalLikes == 0) {
            pinkWeight = 0;
        }
        else {
            pinkWeight = WEIGHT * song.compSci.likes / song.compSci.totalLikes;
        }
        pinkLike = new Shape(centerX, centerY + 20,
                pinkWeight, 15, new Color(255, 20, 147));
        window.addShape(pinkLike);
        
        if (song.enge.totalLikes == 0) {
            blueWeight = 0;
        }
        else {
            blueWeight = WEIGHT * song.enge.likes / song.enge.totalLikes;
        }
        blueLike = new Shape(centerX, centerY + 35,
                blueWeight, 15, Color.BLUE);
        window.addShape(blueLike);
        
        if (song.math.totalLikes == 0) {
            yellowWeight = 0;
        }
        else {
            yellowWeight = WEIGHT * song.math.likes / song.math.totalLikes;
        }
        yellowLike = new Shape(centerX, centerY + 50,
                yellowWeight, 15, Color.YELLOW.darker());
        window.addShape(yellowLike);
        
        if (song.other.totalLikes == 0) {
            greenWeight = 0;
        }
        else {
            greenWeight = WEIGHT * song.other.likes / song.other.totalLikes;
        }
        greenLike = new Shape(centerX, centerY + 65,
                greenWeight, 15, Color.GREEN.darker());
        window.addShape(greenLike);
    }
    
    /**
     * redefines each pink, blue, yellow, and green
     * listen shape for region
     */
    private void setUpRegionListens() {
        int blueWeight;
        int pinkWeight;
        int yellowWeight;
        int greenWeight;
        
        if (song.sEast.total == 0) {
            pinkWeight = 0;
        }
        else {
            pinkWeight = WEIGHT * song.sEast.listens / song.sEast.total;
        }

        pinkListen = new Shape(centerX, centerY + 20,
                pinkWeight, 15, new Color(255, 20, 147));
        pinkListen.setX(pinkListen.getX() - pinkListen.getWidth());
        window.addShape(pinkListen);
        

        if (song.nEast.total == 0) {
            blueWeight = 0;
        }
        else {
            blueWeight = WEIGHT * song.nEast.listens / song.nEast.total;
        }
        blueListen = new Shape(centerX, centerY + 35,
                blueWeight, 15, Color.BLUE);
        blueListen.setX(blueListen.getX() - blueListen.getWidth());
        window.addShape(blueListen);
        
        if (song.otherStates.total == 0) {
            yellowWeight = 0;
        }
        else {
            yellowWeight = WEIGHT * song.otherStates.listens / song.otherStates.total;
        }
        yellowListen = new Shape(centerX, centerY + 50,
                yellowWeight, 15, Color.YELLOW.darker());
        yellowListen.setX(yellowListen.getX() - yellowListen.getWidth());
        window.addShape(yellowListen);
        
        if (song.foreign.total == 0) {
            greenWeight = 0;
        }
        else {
            greenWeight = WEIGHT * song.foreign.listens / song.foreign.total;
        }
        greenListen = new Shape(centerX, centerY + 65,
                greenWeight, 15, Color.GREEN.darker());
        greenListen.setX(greenListen.getX() - greenListen.getWidth());
        window.addShape(greenListen);
    }
    
    /**
     * redefines each pink, blue, yellow, and green
     * like shape for region
     */
    private void setUpRegionLikes() {
        
        int blueWeight;
        int pinkWeight;
        int yellowWeight;
        int greenWeight;
        
        if (song.sEast.totalLikes == 0) {
            pinkWeight = 0;
        }
        else {
            pinkWeight = WEIGHT * song.sEast.likes / song.sEast.totalLikes;
        }
        pinkLike = new Shape(centerX, centerY + 20,
                pinkWeight, 15, new Color(255, 20, 147));
        window.addShape(pinkLike);
        
        if (song.nEast.totalLikes == 0) {
            blueWeight = 0;
        }
        else {
            blueWeight = WEIGHT * song.nEast.likes / song.nEast.totalLikes;
        }
        blueLike = new Shape(centerX, centerY + 35,
                blueWeight, 15, Color.BLUE);
        window.addShape(blueLike);
        
        if (song.otherStates.totalLikes == 0) {
            yellowWeight = 0;
        }
        else {
            yellowWeight = WEIGHT * song.otherStates.likes / song.otherStates.totalLikes;
        }
        yellowLike = new Shape(centerX, centerY + 50,
                yellowWeight, 15, Color.YELLOW.darker());
        window.addShape(yellowLike);
        
        if (song.foreign.totalLikes == 0) {
            greenWeight = 0;
        }
        else {
            greenWeight = WEIGHT * song.foreign.likes / song.foreign.totalLikes;
        }
        greenLike = new Shape(centerX, centerY + 65,
                greenWeight, 15, Color.GREEN.darker());
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
     * Removes all the subcomponents that make up the shape
     */
    public void removeShape() {
        window.removeShape(divider);
        window.removeShape(sortMethodInfo);
        window.removeShape(title);
        window.removeShape(blueListen);
        window.removeShape(blueLike);
        window.removeShape(yellowListen);
        window.removeShape(yellowLike);
        window.removeShape(greenListen);
        window.removeShape(greenLike);
        window.removeShape(pinkListen);
        window.removeShape(pinkLike);
    }
    
    /**
     * strictly for webcat purposes
     */
    public void webCatPurp() {
        title = new TextShape(0, 0, "title");
        divider = new Shape(0, 0, 1, 1);
    }
    

}
