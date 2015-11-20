package prj5;

/**
 * package protected class Node
 * @author Chris Dare cdare77
 * @version 11/05/2015
 * @param <E>
 */
class Node<E> {
    /**
     * package protected data variable
     */
    E data;
    /**
     * package protected nextNode variable
     */
    Node<E> next;
    
    /**
     * Constructor
     * @param data held by node
     * @param next node in sequence
     */
    Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }
}
