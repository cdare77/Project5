package prj5;
/**
 * Song which holds data about likes and listens
 * @author Chris Dare cdare77
 * @version 11/8/2105
 */
public class Song implements MusicComparable<Song> {
 
    
//-------------VARIABLES-------------
    private String title;
    private String artist;
    private String genre;
    private int releaseYear;
    /**
     * package protected for readibility 
     * and protection of call stack
     */
    SongData read;
    /**
     * package protected for readibility 
     * and protection of call stack
     */
    SongData art;
    /**
     * package protected for readibility 
     * and protection of call stack
     */
    SongData sports;
    /**
     * package protected for readibility 
     * and protection of call stack
     */
    SongData music;
    /**
     * package protected for readibility 
     * and protection of call stack
     */
    SongData compSci;
    /**
     * package protected for readibility 
     * and protection of call stack
     */
    SongData enge;
    /**
     * package protected for readibility 
     * and protection of call stack
     */
    SongData math;
    /**
     * package protected for readibility 
     * and protection of call stack
     */
    SongData other;
    /**
     * package protected for readibility 
     * and protection of call stack
     */
    SongData nEast;
    /**
     * package protected for readibility 
     * and protection of call stack
     */
    SongData sEast;
    /**
     * package protected for readibility 
     * and protection of call stack
     */
    SongData otherStates;
    /**
     * package protected for readibility 
     * and protection of call stack
     */
    SongData foreign;

    
//-------------METHODS-----------------------------
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
     * @param readV hobby's SongData
     * @param artV hobby's SongData
     * @param sportsV hobby's SongData
     * @param musicV hobby's SongData
     */
    public void setHobbyData(SongData readV, SongData artV,
            SongData sportsV, SongData musicV) {
        this.read = readV;
        this.art = artV;
        this.sports = sportsV;
        this.music = musicV;
    }
    
    /**
     * sets the data for majors
     * @param compSciV major's SongData
     * @param engeV major's SongData
     * @param mathV major's SongData
     * @param otherV major's SongData
     */
    public void setMajorData(SongData compSciV, SongData engeV,
            SongData mathV, SongData otherV) {
        this.compSci = compSciV;
        this.enge = engeV;
        this.math = mathV;
        this.other = otherV;
    }
    
    /**
     * sets the regional data for students
     * @param nEastV regional SongData
     * @param sEastV regional SongData
     * @param otherStatesV regional SongData
     * @param foreignV regional songData
     */
    public void setRegionData(SongData nEastV, SongData sEastV,
            SongData otherStatesV, SongData foreignV) {
        this.nEast = nEastV;
        this.sEast = sEastV;
        this.otherStates = otherStatesV;
        this.foreign = foreignV;
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
    public int compareByArtist(Song otherSong) {
        return artist.compareTo(otherSong.getArtist());
    }
    
    @Override
    public int compareByTitle(Song otherSong) {
        return title.compareTo(otherSong.getTitle());
    }
    
    @Override
    public int compareByGenre(Song otherSong) {
        return genre.compareTo(otherSong.getGenre());
    }
    
    @Override
    public int compareByReleaseYear(Song otherSong) {
        return releaseYear - otherSong.getReleaseYear();
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
    
    /**
     * provides a helper method to access
     * data for SurveyData of specifically
     * hobbies
     * @return String representing song
     */
    public String representHobbies() {
        StringBuilder builder = new StringBuilder();
        builder.append("Heard\n");
        builder.append("reading:");
        builder.append(read.listens);
        builder.append(" art:");
        builder.append(art.listens);
        builder.append(" sports:");
        builder.append(sports.listens);
        builder.append(" music:");
        builder.append(music.listens);
        builder.append("\nLikes\n");
        builder.append("reading:");
        builder.append(read.likes);
        builder.append(" art:");
        builder.append(art.likes);
        builder.append(" sports:");
        builder.append(sports.likes);
        builder.append(" music:");
        builder.append(music.likes);
        return builder.toString();
    }
    
}
