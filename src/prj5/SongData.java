package prj5;
/**
 * Song data class which provides simple way to access
 * data
 * @author Chris Dare 
 * @version 11/15/2015
 */
final class SongData implements Comparable<SongData> {
    /**
     * should be package protected so other
     * classes can easily access and modify 
     * without stress on the function stack 
     * from accessor and modifier methods
     */
    int listens;
    
    /**
     * should be package protected so other
     * classes can easily access and modify
     * without stree on the function stack
     * from accessor and modifier methods
     */
    int likes;
    
    /**
     * constructor which assigns values
     * to listens and likes
     * @param list -sets listens
     * @param like -sets likes
     */
    SongData(int list, int like) {
        this.listens = list;
        this.likes = like;  
    }
    
    @Override
    public int compareTo(SongData other) {
        return listens + likes - (other.listens + other.likes);
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Listens: ");
        builder.append(listens);
        builder.append(", Likes: ");
        builder.append(likes);
        return builder.toString();
    }
}
