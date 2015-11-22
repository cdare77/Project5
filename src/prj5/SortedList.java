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
    
    /**
     * default constructor
     */
    public SortedList() {
        sortMethod = "title";
    }
    
    /**
     * adds an object at the specific position
     * that keeps the order of sortMethod
     * @param obj to add
     */
    public void add(T obj) {
        if (isEmpty()) {
            super.add(obj);
        }
        
        else {
            Node<T> temp = head;
            int counter = 0;
            
            while (temp != null) {
                if (compare(temp.data, obj) > 0) {
                    super.add(counter, obj);
                    return;
                }
                temp = temp.next;
                counter++;
            }
            
            super.add(obj);
        }
    }
    
    //----------------------------------------------------------------------
    
    /**
     * mergeSort on list, uses helper methods
     * mergeSort, midpoint, merge
     */
    private void sort() {
        head = mergeSort(head, sortMethod);
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        last = temp;
    }
    
    /**
     * Helper method which splits linked list
     * in O(log2n) time
     * @param node to start at
     * @param param passes method of sorting
     * down the stack trace
     * @return temporary head of reordered sublist
     */
    private Node<T> mergeSort(Node<T> node, String param) {
        if (node == null || node.next == null) {
            return node;
        }
        Node<T> middle = midpoint(node);
        Node<T> secondHalf = middle.next;
        middle.next = null;

        return merge(mergeSort(node, param),
                mergeSort(secondHalf, param), param);
    }


    /**
     * merges the two lists in O(n) time
     * @param first head of first list
     * @param second head of second list
     * @param param method of comparison passed
     * down the call stack
     * @return head of merged list
     */
    private Node<T> merge(Node<T> first, Node<T> second, String param) {
        Node<T> currentHead;
        currentHead = new Node<T>(null, null);
        Node<T> current = currentHead;
        while (first != null && second != null) {
            int compare = compare(first.data, second.data);

            if (compare <= 0) {
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

    /**
     * helper method which returns the midpoint node
     * @param node beginning of list
     * @return midpoint node of list
     */
    private Node<T> midpoint(Node<T> node) {
        if (node == null) {
            return node;
        }
        Node<T> slow = node;
        Node<T> fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    /**
     * sets the sorting method and sorts the list
     * @param method to sort by, i.e. artist,
     * title, genre, release year
     */
    public void setSortMethod(String method) {
        if (method.equalsIgnoreCase("artist")) {
            sortMethod = "artist";
        }
        else if (method.equalsIgnoreCase("genre")) {
            sortMethod = "genre";
        }
        else if (method.equalsIgnoreCase("title")) {
            sortMethod = "title";
        }
        else if (method.equalsIgnoreCase("releaseYear")) {
            sortMethod = "releaseYear";
        }
        else {
            throw new IllegalArgumentException();
        }
        
        if (!isEmpty()) {
            sort();
        }
    }
    
    /**
     * compares the first and second parameters based
     * off of current sorting method
     * @param first object to compare
     * @param second object to compare
     * @return int of compareBy____
     */
    public int compare(T first, T second) {
        int compare;
           
        if (sortMethod.equals("artist")) {
            compare = first.compareByArtist(second);
        }
        else if (sortMethod.equals("title")) {
            compare = first.compareByTitle(second);
        }
        else if (sortMethod.equals("genre")) {
            compare = first.compareByGenre(second);
        }
        else {
            compare = first.compareByReleaseYear(second);
        }
        
        return compare;
    }
    
    /**
     * public accessor method for sortMethod
     * @return sortMethod as string
     */
    public String getSortMethod() {
        return sortMethod;
    }
}
