package prj5;

public interface MusicComparable<T> {

    public int compareByArtist(T other);
    
    public int compareByTitle(T other);
    
    public int compareByGenre(T other);
    
    public int compareByReleaseYear(T other);
}
