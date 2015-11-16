import java.util.Iterator;

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
    
    public void add(T obj) throws IllegalArgumentException {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            list.add(obj);
        }
        else {
            int index = 0;
            Iterator<T> it = list.iterator();
        
            while (it.hasNext() && it.next().compareTo(obj) < 0) {
                index++;
            }
        
            list.add(index, obj);
        }
    }
    
    @Override
    public String toString() {
        return list.toString();
    }
    
    public int size() {
        return list.size();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public void remove(int i) {
        list.remove(i);
    }
    
    public boolean remove(T obj) {
        return list.remove(obj);
    }
    
    public T get(int index) {
        return list.get(index);
    }
    
    public int getIndexOf(T obj) {
        return list.getIndexOf(obj);
    }
    
    public boolean contains(T obj) {
        return list.contains(obj);
    }
    
    public void clear() {
        list.clear();
    }
    
    public Object[] toArray() {
        return list.toArray();
    }
}
