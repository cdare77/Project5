import java.util.Arrays;
import java.util.Iterator;

/**
 * Tests the methods of linkedList
 * @author Chris Dare cdare77
 * @version 11/2/2015
 */
public class LinkedListTest extends student.TestCase {
    
    private LinkedList<String> list;
    
    @Override
    public void setUp() {
        list = new LinkedList<String>();
    }
    
    @SuppressWarnings("deprecation")
    public void testAdd() {
        
        assertTrue(list.isEmpty());
        
        list.add("one");
        list.add("two");
        list.add("three");
        
        assertEquals(list.toString(), "[one, two, three]");
        
        list.add(0, "zero");
        
        assertEquals(list.toString(), "[zero, one, two, three]");
        
        list.add(4, "four");
        
        assertEquals(list.toString(), "[zero, one, two, three, four]");
        
        list.add(4, "three and a half");
        
        assertEquals(list.toString(),
                "[zero, one, two, three, three and a half, four]");
        
        assertEquals(list.size(), 6);
        
        Exception ex = null;
        
        try {
            list.add(-2, "temp");
        }
        catch (Exception e) {
            ex = e;
        }
        assertTrue(ex instanceof IndexOutOfBoundsException);
        
        try {
            list.add(20, "temp");
        }
        catch (Exception e) {
            ex = e;
        }
        assertTrue(ex instanceof IndexOutOfBoundsException);
        
        try {
            list.add(null);
        }
        catch (Exception e) {
            ex = e;
        }
        assertTrue(ex instanceof IllegalArgumentException);
        
        try {
            list.add(3, null);
        }
        catch (Exception e) {
            ex = e;
        }
        assertTrue(ex instanceof IllegalArgumentException);
    }
    
    public void testSort() {
        list.add("A");
        list.add("F");
        list.add("B");
        list.add("R");
        list.add("L");
        list.add("Q");
        list.add("H");
        list.add("I");
        list.add("Z");
        list.add("C");
        
        assertEquals(list.toString(), "[A, F, B, R, L, Q, H, I, Z, C]");
        
        list.sort();
        
        assertEquals(list.toString(), "[A, B, C, F, H, I, L, Q, R, Z]");
    }
    
    /**
     * Tests the get method in cases after
     * sort, before sort, and pos = list.size-1
     */
    public void testGet() {
        list.add("A");
        list.add("F");
        list.add("B");
        list.add("R");
        list.add("L");
        list.add("Q");
        list.add("H");
        list.add("I");
        list.add("Z");
        list.add("C");
        
        assertEquals(list.get(1), "F");
        assertEquals(list.get(0), "A");
        assertEquals(list.get(list.size() - 1), "C");
        
        list.sort();
        
        assertEquals(list.get(list.size() - 1), "Z");
        
        Exception ex = null;
        
        try {
            list.get(-2);
        }
        catch (Exception e) {
            ex = e;
        }
        assertTrue(ex instanceof IndexOutOfBoundsException);
        
        try {
            list.get(20);
        }
        catch (Exception e) {
            ex = e;
        }
        assertTrue(ex instanceof IndexOutOfBoundsException);
    }
    
    @SuppressWarnings("deprecation")
    public void testGetIndexOf() {
        list.add("A");
        list.add("F");
        list.add("B");
        list.add("R");
        list.add("L");
        list.add("Q");
        list.add("H");
        list.add("I");
        list.add("Z");
        list.add("C");
        
        assertEquals(list.getIndexOf("R"), 3);
        assertEquals(list.getIndexOf("C"), list.size() - 1);
        assertEquals(list.getIndexOf("2"), -1);
        
    }
    
    /**
     * Tests the clear method and how it affects
     * size and head
     */
    public void testClear() {
        list.add("A");
        list.add("F");
        list.add("B");
        list.add("R");
        list.add("L");
        list.add("Q");
        list.add("H");
        list.add("I");
        list.add("Z");
        list.add("C");
        
        assertEquals(list.toString(), "[A, F, B, R, L, Q, H, I, Z, C]");
        list.clear();
        assertTrue(list.isEmpty());
        
        list.add("B");
        assertEquals(list.toString(), "[B]");
    }
    
    public void testRemove() {
        list.add("A");
        list.add("F");
        list.add("B");
        list.add("R");
        list.add("L");
        list.add("Q");
        list.add("H");
        list.add("I");
        list.add("Z");
        list.add("C");
        
        assertEquals(list.toString(), "[A, F, B, R, L, Q, H, I, Z, C]");
        list.remove(0);
        assertEquals(list.toString(), "[F, B, R, L, Q, H, I, Z, C]");
        list.remove(1);
        assertEquals(list.toString(), "[F, R, L, Q, H, I, Z, C]");
        list.remove(2);
        assertEquals(list.toString(), "[F, R, Q, H, I, Z, C]");
        
        Exception ex = null;
        try {
            list.remove(-1);
        }
        catch (Exception e) {
            ex = e;
        }
        assertTrue(ex instanceof IndexOutOfBoundsException);
        
        try {
            list.remove(200);
        }
        catch (Exception e) {
            ex = e;
        }
        assertTrue(ex instanceof IndexOutOfBoundsException);
        
        assertTrue(list.remove("F"));
        assertEquals(list.toString(), "[R, Q, H, I, Z, C]");
        
        assertTrue(list.remove("Z"));
        assertEquals(list.toString(), "[R, Q, H, I, C]");
        
        assertFalse(list.remove("L"));   
    }
    
    public void testIterator() {
        list.add("A");
        list.add("F");
        list.add("B");
        list.add("R");
        list.add("L");
        list.add("Q");
        list.add("H");
        list.add("I");
        list.add("Z");
        list.add("C");
        Iterator<String> it = list.iterator();

        
        String[] strings = new String[list.size()];
        int index = 0;
        while (it.hasNext()) {
            strings[index] = it.next();
            index++;
        }
        
        String[] otherStrings = {"A","F", "B", "R", "L", "Q", "H", 
                "I","Z", "C"};
        
        assertTrue(Arrays.equals(strings, otherStrings));
    }
    
    public void testToArray() {
        list.add("A");
        list.add("B");
        list.add("C");
        
        Object[] other = {"A","B","C"};
        
        assertTrue(Arrays.equals(list.toArray(), other));
    }
    
    public void testContains() {
        list.add("A");
        list.add("B");
        list.add("C");
        
        assertTrue(list.contains("A"));
        assertFalse(list.contains("F"));
    }
    
    public void testToString() {
        list.add("A");
        list.add("B");
        list.add("C");
        
        assertEquals(list.toString(), "[A, B, C]");
        
        list.clear();
        assertEquals(list.toString(), "[]");
        
    }
}
