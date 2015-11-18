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
        
        int totalLikes = song.totalLikes();
        int totalListens = song.totalListens();
        
        pinkListen = new Shape(centerX, centerY + 20,
                WEIGHT * song.getRead().listens / totalListens,
                15, Color.PINK);
        pinkListen.setX(pinkListen.getX() - pinkListen.getWidth());
        window.addShape(pinkListen);
        
        blueListen = new Shape(centerX, centerY + 35,
                WEIGHT * song.getArt().listens / totalListens,
                15, Color.BLUE);
        blueListen.setX(blueListen.getX() - blueListen.getWidth());
        window.addShape(blueListen);
        
        yellowListen = new Shape(centerX, centerY + 50,
                WEIGHT * song.getSports().listens / totalListens,
                15, Color.YELLOW);
        yellowListen.setX(yellowListen.getX() - yellowListen.getWidth());
        window.addShape(yellowListen);
        
        greenListen = new Shape(centerX, centerY + 65,
                WEIGHT * song.getMusic().listens / totalListens,
                15, Color.GREEN);
        greenListen.setX(greenListen.getX() - greenListen.getWidth());
        window.addShape(greenListen);
        
        
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
}
