package prj5;

/**
 * Interface which provides alternative to
 * Comparable<T>, as 4 elements must be compared 
 * distinctively, i.e. one element does
 * not affect the compareTo of the other
 * (title, artist, genre, release year)
 * @author Chris Dare cdare77
 * @version 11/8/2015
 * @param <T>
 */
public interface MusicComparable<T> {

    /**
     * should call compareTo of artist
     * strings
     * @param other object compared against
     * @return integer representing 
     * comparison: 0 if equals, <0
     * if this is less than other, >0
     * otherwise
     */
    public int compareByArtist(T other);
    
    /**
     * should call compareTo of title
     * strings
     * @param other object compared against
     * @return integer representing 
     * comparison: 0 if equals, <0
     * if this is less than other, >0
     * otherwise
     */
    public int compareByTitle(T other);
    
    /**
     * should call compareTo of genre
     * strings
     * @param other object compared against
     * @return integer representing 
     * comparison: 0 if equals, <0
     * if this is less than other, >0
     * otherwise
     */
    public int compareByGenre(T other);
    
    /**
     * should call this.year - other.year
     * @param other object compared against
     * @return integer representing 
     * comparison: 0 if equals, <0 
     * if this is less than other, >0 
     * otherwise
     */
    public int compareByReleaseYear(T other);
}
