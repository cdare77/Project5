package prj5;

import CS2114.Shape;
import CS2114.TextShape;

public class SongShape {
    
    private SortedList<Song> list;
    private int centerX;
    private int centerY;
    private Song song;
    private TextShape title;
    private TextShape sortMethodInfo;
    private Shape divider;
    
    public SongShape(int x, int y, Song song) {
        this.list = new SortedList<Song>();
        
        this.centerX = x;
        this.centerY = y;
        this.song = song;
        
        title = new TextShape(x, y - 20, song.getTitle());
        

        if (list.getSortMethod().equals("genre")) {
            sortMethodInfo = new TextShape(x, y - 15,
                    "genre: " + song.getGenre());
        }
        else if (list.getSortMethod().equals("releaseYear")) {
            sortMethodInfo = new TextShape(x, y - 15,
                    "year: " + song.getReleaseYear());
        }
        else {
            sortMethodInfo = new TextShape(x, y - 15,
                    "by "+ song.getArtist());
        }
        
        
        
        
    }
}
