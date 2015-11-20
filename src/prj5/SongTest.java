package prj5;

import student.TestCase;

/**
 * Test the methods in Song
 * @author Chris Dare cdare77
 * @version 11/20/2015
 */
public class SongTest extends TestCase {

    private Song mySong;
    private Song otherSong;
    
    @Override
    public void setUp() {
        mySong = new Song("22", "Taylor Swift", "pop", 2012);
        otherSong = new Song("I've Got "
                + "You Under My Skin", "Frank Sinatra", "Jazz", 1956);
    }
    
    /**
     * tests the setHobbyData and how it affects
     * protected variables
     */
    @SuppressWarnings("deprecation")
    public void testSetHobbyData() {
        mySong.setHobbyData(new SongData(1, 1),
                new SongData(2, 2), new SongData(3, 3),
                new SongData(4, 4));
        
        assertEquals(mySong.art.likes, mySong.art.listens);
    }
    
    /**
     * tests the setMajorData and how it affects protected
     * varialbes
     */
    @SuppressWarnings("deprecation")
    public void testSetMajorData() {
        mySong.setMajorData(new SongData(1, 1),
                new SongData(2, 2), new SongData(3, 3),
                new SongData(4, 4));
        
        assertEquals(mySong.compSci.likes, mySong.compSci.listens);
    }
    
    /**
     * tests the setRegionData and how it affects
     * protected variables
     */
    @SuppressWarnings("deprecation")
    public void testSetRegionData() {
        mySong.setRegionData(new SongData(1, 1),
                new SongData(2, 2), new SongData(3, 3),
                new SongData(4, 4));
        assertEquals(mySong.nEast.likes, mySong.nEast.listens);
    }
    
    /**
     * tests the totalLikes method
     */
    @SuppressWarnings("deprecation")
    public void testTotalLikes() {
        mySong.setHobbyData(new SongData(1, 1),
                new SongData(2, 2), new SongData(3, 3),
                new SongData(4, 4));
        
        assertEquals(mySong.totalLikes(), 10);
    }
    
    /**
     * tests the totalListens method
     */
    @SuppressWarnings("deprecation")
    public void testTotalListens() {
        mySong.setHobbyData(new SongData(1, 1),
                new SongData(2, 2), new SongData(3, 3),
                new SongData(4, 4));
        assertEquals(mySong.totalListens(), 10);
    }
    
    /**
     * tests compareByArtist method
     */
    public void testCompareByArtist() {
        assertTrue(mySong.compareByArtist(otherSong) > 0);
    }
    
    /**
     * tests compareByTitle method
     */
    public void testCompareByTitle() {
        assertTrue(mySong.compareByTitle(otherSong) < 0);
    }
    
    /**
     * tests compareByGenre method
     */
    public void testCompareByGenre() {
        assertTrue(mySong.compareByGenre(otherSong) > 0);
    }
    
    /**
     * test compareByReleaseYear method
     */
    public void testCompareByReleaseYear() {
        assertTrue(mySong.compareByReleaseYear(otherSong) > 0);
    }
    
    /**
     * tests representHobbiesMethod
     */
    public void testRepresentHobbies() {
        mySong.setHobbyData(new SongData(1, 1),
                new SongData(2, 2), new SongData(3, 3),
                new SongData(4, 4));
        mySong.setRegionData(new SongData(1, 1),
                new SongData(2, 2), new SongData(3, 3),
                new SongData(4, 4));
        mySong.setMajorData(new SongData(1, 1),
                new SongData(2, 2), new SongData(3, 3),
                new SongData(4, 4));
        assertEquals(mySong.representHobbies(), "Heard\nreading:1"
                + " art:2 sports:3 music:4\nLikes\nreading:1 art:2 "
                + "sports:3 music:4");
    }
}
