package prj5;
/**
 * Song which holds data about likes and listens
 * @author Chris Dare cdare77
 * @version 11/8/2105
 */
@SuppressWarnings("unused")
public class Song implements MusicComparable<Song> {
    
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
    
    /**
     * Constructor for song
     * @param title of song
     * @param artist for song
     * @param genre of song
     * @param releaseYear of song
     */
    public Song(String title, String artist, String genre,
            int releaseYear) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
    
    /**
     * sets the data for hobbies
     * @param read hobby's SongData
     * @param art hobby's SongData
     * @param sports hobby's SongData
     * @param music hobby's SongData
     */
    public void setHobbyData(SongData read, SongData art,
            SongData sports, SongData music) {
        this.read = read;
        this.art = art;
        this.sports = sports;
        this.music = music;
    }
    
    /**
     * sets the data for majors
     * @param compSci major's SongData
     * @param enge major's SongData
     * @param math major's SongData
     * @param other major's SongData
     */
    public void setMajorData(SongData compSci, SongData enge,
            SongData math, SongData other) {
        this.compSci = compSci;
        this.enge = enge;
        this.math = math;
        this.other = other;
    }
    
    /**
     * sets the regional data for students
     * @param nEast regional SongData
     * @param sEast regional SongData
     * @param otherStates regional SongData
     * @param foreign regional songData
     */
    public void setRegionData(SongData nEast, SongData sEast,
            SongData otherStates, SongData foreign) {
        this.nEast = nEast;
        this.sEast = sEast;
        this.otherStates = otherStates;
        this.foreign = foreign;
    }
    
    /**
     * Calculates total listens of a song
     * @return total listens
     */
    public int totalListens() {
        return read.listens + art.listens 
                + sports.listens + music.listens;
    }
    
    /**
     * Calculates total likes of a song
     * @return total likes
     */
    public int totalLikes() {
        return read.likes + art.likes 
                + sports.likes + music.likes;
    }
    
    /**
     * accessor method for song's title
     * @return song's title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * accessor method for song's artist
     * @return song's artist
     */
    public String getArtist() {
        return artist;
    }
    
    /**
     * accessor method for song's genre
     * @return song's genre
     */
    public String getGenre() {
        return genre;
    }
    
    /**
     * accessor method for song's release year
     * @return song's release year
     */
    public int getReleaseYear() {
        return releaseYear;
    }
    
    @Override
    public int compareByArtist(Song other) {
        return artist.compareTo(other.getArtist());
    }
    
    @Override
    public int compareByTitle(Song other) {
        return title.compareTo(other.getTitle());
    }
    
    @Override
    public int compareByGenre(Song other) {
        return genre.compareTo(other.getGenre());
    }
    
    @Override
    public int compareByReleaseYear(Song other) {
        return releaseYear - other.getReleaseYear();
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\"");
        builder.append(title);
        builder.append("\", ");
        builder.append(artist);
        builder.append(" (");
        builder.append(releaseYear);
        builder.append("), Genre: ");
        builder.append(genre);
        return builder.toString();
    }
    
    public SongData getRead() {
        return read;
    }
    
    public SongData getArt() {
        return art;
    }
    
    public SongData getSports() {
        return sports;
    }
    
    public SongData getMusic() {
        return music;
    }
    
}
