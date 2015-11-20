package prj5;

import java.awt.Color;

import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

public class SongShape {
    
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
    
    private Representation rep;
    
    private static final int WEIGHT = 100;
    
    public SongShape(Window window, int x, int y, SortedList<Song> list, Song song) {
        
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
        
        rep = Representation.HOBBY;
        setRepShapes(rep);
    }
    
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
                    "by "+ song.getArtist());
        }
        sortMethodInfo.setX(sortMethodInfo.getX() 
                - sortMethodInfo.getWidth() / 2);
        sortMethodInfo.setBackgroundColor(Color.WHITE);
        window.addShape(sortMethodInfo);
    }
    
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
    
    private void setRepShapes(Representation rep) {
        if (rep == Representation.HOBBY) {
            setUpHobbyListens();
            setUpHobbyLikes();
        }
        else if (rep == Representation.MAJOR) {
            setUpMajorListens();
            setUpMajorLikes();
        }
        else {
            setUpRegionListens();
            setUpRegionLikes();
        }
        window.repaint();
    }
    
    public void setRepresentation(Representation represent) {
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
}
