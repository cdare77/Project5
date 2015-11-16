
/**
 * 
 * @author Chris Dare cdare77
 * @version 11/8/2105
 */
@SuppressWarnings("unused")
public class Song implements Comparable<Song> {
    
    private String title;
    private String artist;
    private String genre;
    private int releaseYear;
    private SongData read;
    private SongData art;
    private SongData sports;
    private SongData music;
    private SongData compSci;
    private SongData enge;
    private SongData math;
    private SongData other;
    private SongData nEast;
    private SongData sEast;
    private SongData otherStates;
    private SongData foreign;
    
    public Song(String title, String artist, String genre,
            int releaseYear) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
    
    public void setHobbyData(SongData read, SongData art,
            SongData sports, SongData music) {
        this.read = read;
        this.art = art;
        this.sports = sports;
        this.music = music;
    }
    
    public void setMajorData(SongData compSci, SongData enge,
            SongData math, SongData other) {
        this.compSci = compSci;
        this.enge = enge;
        this.math = math;
        this.other = other;
    }
    
    public void setRegionData(SongData nEast, SongData sEast,
            SongData otherStates, SongData foreign) {
        this.nEast = nEast;
        this.sEast = sEast;
        this.otherStates = otherStates;
        this.foreign = foreign;
    }
    
    public int totalListens() {
        return read.listens + art.listens 
                + sports.listens + music.listens;
    }
    
    public int totalLikes() {
        return read.likes + art.likes 
                + sports.likes + music.likes;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public int compareTo(Song other) {
        int compareTitle = title.compareTo(other.getTitle());
        
        if (compareTitle != 0) {
            return compareTitle;
        }
        
        int compareArtist = artist.compareTo(other.getArtist());
        
        if (compareArtist != 0) {
            return compareArtist;
        }
        
        int compareGenre = genre.compareTo(other.getGenre());
        
        if (compareGenre != 0) {
            return compareGenre;
        }
        
        int compareYear = releaseYear - other.releaseYear;
        
        if (compareYear != 0) {
            return compareYear;
        }
        
        return 0;
    }
    
}
