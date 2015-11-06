

/**
 * Inherits all the methods of linked list but overwrites 
 * add and sort
 * @author Chris Dare cdare77
 * @version 11/6/2015
 * @param <T>
 */
public class SortedList<T extends Comparable<T>> {
    
    private LinkedList<T> list;
    
    public SortedList() {
        list = new LinkedList<T>();
    }
    
    public void add(T obj) {
        
    }
    
}
