/**
 * 
 */
package prj5;
import student.TestCase;
/**
 * @author Brandon Cobbs (btcobbs)
 * @version 11/20/2015
 *
 */
public class SongDataTest extends TestCase {

    private SongData data1;
    
    /**
     * This runs at the start of every test
     */
    public void setUp() {
        data1 = new SongData(1, 1);
    }
    
    /**
     * This tests compareTo in multiple cases
     */
    public void testCompareTo() {
        SongData data2 = new SongData(0, 2);
        SongData data3 = new SongData(0, 0);
        SongData data4 = new SongData(2, 2);
        SongData data5 = new SongData(2, 0);
        assertEquals(0, data1.compareTo(data2));
        assertEquals(2, data1.compareTo(data3));
        assertEquals(4, data4.compareTo(data3));
        assertEquals(-2, data3.compareTo(data1));
        assertEquals(0, data1.compareTo(data5));
        assertEquals(0, data5.compareTo(data2));
        assertEquals(0, data5.compareTo(data5));
    }
    
    /**
     * This tests toString
     */
    public void testToString() {
        assertEquals(data1.toString(), "Listens: 1, Likes: 1");
    }
}
