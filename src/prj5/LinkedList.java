package prj5;
import java.util.Iterator;

/**
 * Singly linked list with pointer to last node
 * @author Chris Dare cdare77
 * @version 11/2/2015
 * @param <T>
 */
public class LinkedList<T> implements Iterable<T> {
    protected Node<T> head;
    protected Node<T> last;
    protected int size;
    
    /**
     * Default constructor
     */
    public LinkedList() {
        head = null;
        last = null;
        size = 0;
    }
    
    /**
     * adds a certain object to the end of 
     * the linked list
     * @param obj to add 
     */
    public void add(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        if (size == 0) {
            head = new Node<T>(obj, null);
            last = head;
        }
        else {
            Node<T> newNode = new Node<T>(obj, null);
            last.next = newNode;
            last = newNode;
        }
        size++;
    }
    
    /**
     * adds a certain object to a specific position
     * in the list
     * @param pos to add object to
     * @param obj to be added
     */
    public void add(int pos, T obj) {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException();
        }
        else if (obj == null) {
            throw new IllegalArgumentException();
        }
        if (pos == size) {
            add(obj);
        }
        else if (pos == 0) {
            head = new Node<T>(obj, head);
            size++;
        }
        else {
            Node<T> temp = head;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            temp.next = new Node<T>(obj, temp.next);
            size++;
        }
    }
    
    /**
     * removes the object at a given position
     * @param pos to remove from
     */
    public void remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (pos == 0) {
            head = head.next;
            size--;
        }
        else {
            Node<T> temp = head;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
    }
    
    /**
     * removes a certain object from the list
     * and returns false if object was not found
     * @param obj to remove
     * @return true if object successfully removed,
     * false otherwise
     */
    public boolean remove(T obj) {
        if (head.data.equals(obj)) {
            head = head.next;
            size--;
            return true;
        }
        else {
            Node<T> temp = head;
            while (temp.next != null) {
                if (temp.next.data.equals(obj)) {
                    temp.next = temp.next.next;
                    size--;
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }
    }
    
    /**
     * gets the index of a given object, 
     * returns -1 otherwise
     * @param obj to find
     * @return index of obj, -1 if not found
     */
    public int getIndexOf(T obj) {
        int index = 0;
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(obj)) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        
        return -1;
    }
    
    /**
     * gets the object at a certain pos,
     * throws index out of bounds if nonexistant
     * index
     * @param pos to look at
     * @return object found
     */
    public T get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        if (pos == size - 1) {
            return last.data;
        }
        Node<T> temp = head;
        for (int i = 0; i != pos; i++) {
            temp = temp.next;
        }
        
        return temp.data;
    }
    
    /**
     * indicates whether and object is contained
     * in the given list
     * @param obj to look for
     * @return true if found, false if not found
     */
    public boolean contains(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(obj)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    /**
     * returns the size of the list
     * @return size;
     */
    public int size() {
        return size;
    }
    
    /**
     * Indicates whether list is empty
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        
        Node<T> temp = head;
        while (temp.next != null) {
            builder.append(temp.data);
            builder.append(", ");
            temp = temp.next;
        }
        builder.append(temp.data);
        builder.append("]");
        return builder.toString();
    }
    
    /**
     * clears the linked list
     */
    public void clear() {
        head = null;
        last = null;
        size = 0;
    }
    
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private Node<T> temp = head;
            
            public boolean hasNext() {
                return temp != null;
            }
            public T next() {
                T data = temp.data;
                temp = temp.next;
                return data;
            }
        };
        return it;
    }
    
    public Object[] toArray() {
        Iterator<T> it = iterator();
        Object[] objects = new Object[size];
        int index = 0;
        while (it.hasNext()) {
            objects[index] = it.next();
            index++;
        }
        return objects;
    }
    
    
}
