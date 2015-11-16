import java.util.Arrays;

import student.TestCase;

public class SortedListTest extends TestCase {
    private SortedList<Integer> list;
    
    @Override
    public void setUp() {
        list = new SortedList<Integer>();
    }
    
    public void testAdd() {
        list.add(1);
        assertEquals(list.toString(), "[1]");
        list.add(2);
        assertEquals(list.toString(), "[1, 2]");
        
        list.add(5);
        assertEquals(list.toString(), "[1, 2, 5]");
        
        list.add(3);
        assertEquals(list.toString(), "[1, 2, 3, 5]");
        
        list.add(4);
        //44173e98
        assertEquals(list.toString(), "[1, 2, 3, 4, 5]");
        
        
        Exception ex = null;
        try {
            list.add(null);
        }
        catch (Exception e) {
            ex = e;
        }
        assertTrue(ex instanceof IllegalArgumentException);
    }
    
    public void testToString() {
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        
        assertEquals("[2, 3, 4, 5]", list.toString());
    }
    
    @SuppressWarnings("deprecation")
    public void testSize() {
        list.add(1);
        list.add(3);
        list.add(1);
        
        assertEquals(list.size(), 3);
    }
    
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        
        list.add(-1);
        
        assertFalse(list.isEmpty());
    }
    
    public void testRemove() {
        list.add(-1);
        list.add(1);
        list.add(0);
        list.add(4);
        
        assertEquals(list.toString(), "[-1, 0, 1, 4]");
        
        list.remove(1);
        assertEquals(list.toString(), "[-1, 1, 4]");
        
        list.remove(0);
        assertEquals(list.toString(), "[1, 4]");
        
        list.remove(1);
        assertEquals(list.toString(), "[1]");
        
        SortedList<String> slist = new SortedList<String>();
        slist.add("d");
        slist.add("b");
        slist.add("a");
        slist.add("z");
        slist.add("c");
        
        assertEquals(slist.toString(), "[a, b, c, d, z]");
        assertTrue(slist.remove("c"));
        assertFalse(slist.remove("o"));
        
        assertEquals(slist.toString(), "[a, b, d, z]");
        
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
    }
    
    @SuppressWarnings("deprecation")
    public void testGet() {
        list.add(3);
        list.add(-1);
        list.add(100);
        list.add(34);
        list.add(12);
        list.add(0);
        list.add(0);
        
        assertEquals(0, (int) list.get(2));
        assertEquals(-1, (int) list.get(0));
        assertEquals(100, (int) list.get(6));
        
        Exception ex = null;
        try {
            list.get(-1);
        }
        catch (Exception e) {
            ex = e;
        }
        assertTrue(ex instanceof IndexOutOfBoundsException);
        
        try {
            list.get(200);
        }
        catch (Exception e) {
            ex = e;
        }
        assertTrue(ex instanceof IndexOutOfBoundsException);
    }
    
    @SuppressWarnings("deprecation")
    public void testGetIndexOf() {
        list.add(3);
        list.add(-1);
        list.add(100);
        list.add(34);
        list.add(12);
        list.add(0);
        list.add(0);
        
        assertEquals(list.getIndexOf(-1), 0);
        assertEquals(list.getIndexOf(100), 6);
        assertEquals(list.getIndexOf(99), -1);
    }
    
    public void testContains() {
        list.add(3);
        list.add(-1);
        list.add(100);
        list.add(34);
        list.add(12);
        list.add(0);
        list.add(0);
        
        assertFalse(list.contains(1));
        assertTrue(list.contains(-1));
    }
    
    public void testClear() {
        list.add(3);
        list.add(-1);
        list.add(100);
        list.add(34);
        list.add(12);
        list.add(0);
        list.add(0);
        
        assertFalse(list.isEmpty());
        
        list.clear();
        
        assertTrue(list.isEmpty());
    }
    
    public void testToArray() {
        list.add(3);
        list.add(-1);
        list.add(100);
        list.add(34);
        list.add(12);
        list.add(0);
        list.add(0);
        
        Object[] compArray = {-1, 0, 0, 3, 12, 34, 100};
        
        Object[] myArr = list.toArray();
        
        assertTrue(Arrays.equals(myArr, compArray));
    }
}
