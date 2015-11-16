package prj5;
/**
 * Song data class which provides simple way to access
 * data
 * @author Chris Dare 
 * @version 11/15/2015
 */
final class SongData implements Comparable<SongData> {
    int listens;
    int likes;
        
    SongData(int list, int like) {
        this.listens = list;
        this.likes = like;  
    }
    
    public int compareTo(SongData other) {
        return listens + likes - (other.listens + other.likes);
    }
}
