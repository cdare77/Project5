package prj5;

import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import java.awt.Color;

/**
 * GUI Legend Shape class with composition
 * relation to the contained pink, blue, etc.
 * shapes
 * @author Chris Dare cdare77
 * @version 11/30/2015
 */
public class GUILegendShape {
    
    private Window window;
    private int centerX;
    private int centerY;
    private TextShape pink;
    private TextShape blue;
    private TextShape yellow;
    private TextShape green;
    private TextShape hobbyLegend;
    private TextShape songTitle;
    private TextShape heard;
    private TextShape likes;
    private Shape divider;
    private Shape background;
    private Shape foreground;
    
    /**
     * Constructor for GUILegendShape with x, y coordinates
     * of top left corner
     * @param window -container window
     * @param x - x coordinate of top left corner
     * @param y - y coordinate of top left corner
     */
    public GUILegendShape(Window window, int x, int y) {
        this.window = window;
        this.centerX = x;
        this.centerY = y;
        
        background = new Shape(x, y, 140, 210, Color.BLACK);
        foreground = new Shape(x + 4, y + 4, 132, 202, Color.WHITE);
        
        hobbyLegend = new TextShape(x + 10, y + 10, "Hobby Legend");
        hobbyLegend.setBackgroundColor(Color.WHITE);
        window.addShape(hobbyLegend);
        
        pink = new TextShape(x + 10, y + 30, null);
        pink.setBackgroundColor(Color.WHITE);
        pink.setForegroundColor(new Color(255, 20, 147));
        window.addShape(pink);
        
        blue = new TextShape(x + 10, y + 45, null);
        blue.setBackgroundColor(Color.WHITE);
        blue.setForegroundColor(Color.BLUE);
        window.addShape(blue);

        yellow = new TextShape(x + 10, y + 60, null);
        yellow.setBackgroundColor(Color.WHITE);
        yellow.setForegroundColor(Color.YELLOW.darker());
        window.addShape(yellow);
        
        green = new TextShape(x + 10, y + 75, null);
        green.setBackgroundColor(Color.WHITE);
        green.setForegroundColor(Color.GREEN.darker());
        window.addShape(green);
        
        setUpColorTitles(GUIRepresentation.HOBBY);
        
        songTitle = new TextShape(x + 35, y + 105, "Song Title");
        songTitle.setBackgroundColor(Color.WHITE);
        window.addShape(songTitle);
        
        divider = new Shape(x + 70, y + 125, 5, 50, Color.BLACK);
        window.addShape(divider);
        
        heard = new TextShape(x + 15, y + 140, "Heard");
        heard.setBackgroundColor(Color.WHITE);
        window.addShape(heard);
        
        likes = new TextShape(x + 85, y + 140, "Likes");
        likes.setBackgroundColor(Color.WHITE);
        window.addShape(likes);
        
        window.addShape(foreground);
        window.addShape(background);
        window.moveToBack(foreground);
        window.moveToBack(background);
    }
    
    /**
     * Allows text within Legend to change based
     * off the representation
     * @param rep Representation (HOBBY, MAJOR, REGION)
     */
    public void setUpColorTitles(GUIRepresentation rep) {
        
        if (rep == GUIRepresentation.HOBBY) {
            pink.setText("Read");
            blue.setText("Art");
            yellow.setText("Sports");
            green.setText("Music");
        }
        else if (rep == GUIRepresentation.MAJOR) {
            pink.setText("Computer Science");
            blue.setText("Other Engineering");
            yellow.setText("Math / CMDA");
            green.setText("Other");
        }
        else {
            pink.setText("Southeast");
            blue.setText("Northeast");
            yellow.setText("US (Other)");
            green.setText("non-US");
        }
        
        window.repaint();
    }
}
