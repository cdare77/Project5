package prj5;

/**
 * Inherits all the methods of linked list but overwrites 
 * add and sort
 * @author Chris Dare cdare77
 * @version 11/6/2015
 * @param <T>
 */
public class SortedList<T extends MusicComparable<T>> extends LinkedList<T> {
    
    private String sortMethod;
    
    public SortedList() {
        sortMethod = null;
    }
    
    public void add(T obj) {
        if (isEmpty()) {
            super.add(obj);
        }
        Node<T> temp = head;
        int compare;
        if (sortMethod.equals("artist")) {
            compare = temp.next.data.compareByArtist(obj);
        }
        else if (sortMethod.equals("title")) {
            compare = temp.next.data.compareByTitle(obj);
        }
        else if (sortMethod.equals("genre")) {
            compare = temp.next.data.compareByGenre(obj);
        }
        else if (sortMethod.equals("releaseYear")) {
            compare = temp.next.data.compareByReleaseYear(obj);
        }
        else {
            throw new IllegalArgumentException("Argument not valid");
        }
        while (temp.next != null && compare <= 0) {
            if (sortMethod.equals("artist")) {
                compare = temp.next.data.compareByArtist(obj);
            }
            else if (sortMethod.equals("title")) {
                compare = temp.next.data.compareByTitle(obj);
            }
            else if (sortMethod.equals("genre")) {
                compare = temp.next.data.compareByGenre(obj);
            }
            else if (sortMethod.equals("releaseYear")) {
                compare = temp.next.data.compareByReleaseYear(obj);
            }
            else {
                throw new IllegalArgumentException();
            }
            
            temp = temp.next;
        }
        
        temp.next = new Node<T>(obj, temp.next);
    }
    
    /**
     * mergeSort on list, uses helper methods
     * mergeSort, midpoint, merge
     */
    public void sort() {
        mergeSort(head, sortMethod);
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        last = temp;
    }
    
    private Node<T> mergeSort(Node<T> node, String param) {
        if (node == null || node.next == null) {
            return node;
        }
        Node<T> middle = midpoint(node);
        Node<T> secondHalf = middle.next;
        middle.next = null;

        return merge(mergeSort(node, param),mergeSort(secondHalf, param), param);
    }

    private Node<T> merge(Node<T> first, Node<T> second, String param) {
        Node<T> currentHead;
        currentHead = new Node<T>(null, null);
        Node<T> current = currentHead;
        while (first !=null && second!= null) {
            int compare = 0;
            if (param == "artist") {
                compare = first.data.compareByArtist(second.data);
            }
            else if (param == "title") {
                compare = first.data.compareByTitle(second.data);
            }
            else if (param == "genre") {
                compare = first.data.compareByGenre(second.data);
            }
            else if (param == "releaseYear") {
                compare = first.data.compareByReleaseYear(second.data);
            }
            else {
                throw new IllegalArgumentException("Argument not valid");
            }
            if(compare <= 0) {
                current.next = first;
                first = first.next;
            }
            else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }
        current.next = (first == null) ? second : first;
        return currentHead.next;
    }

    private Node<T> midpoint(Node<T> node) {
        if(node == null) {
            return node;
        }
        Node<T> slow = node;
        Node<T> fast = node;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public void setSortMethod(String s) {
        if (s.equalsIgnoreCase("artist")) {
            sortMethod = "artist";
        }
        else if (s.equalsIgnoreCase("genre")) {
            sortMethod = "genre";
        }
        else if (s.equalsIgnoreCase("title")) {
            sortMethod = "title";
        }
        else if (s.equalsIgnoreCase("releaseYear")) {
            sortMethod = "releaseYear";
        }
        else {
            throw new IllegalArgumentException();
        }
        
        sort();
    }
}
