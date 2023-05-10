package edu.kis.vh.nursery.list;

/**
 * The object that manages the linked list
 */
public class IntLinkedList {

    private static final int LIST_IS_EMPTY = -1;
    private Node last;

    /**
     * Adds new value to the list
     * @param i Value you want to add to list
     */
    public void push(int i) {
        if (last == null)
            last = new Node(i);
        else {
            last.setNext(new Node(i));
            last.getNext().setPrev(last);
            last = last.getNext();
        }
    }

    /**
     * Checks if the list is empty
     * @return Returns true if list is empty and false otherwise
     */
    private boolean isEmpty() {
        return last == null;
    }

    /**
     * Returns top value
     * @return Returns top value
     */
    public int top() {
        if (isEmpty())
            return LIST_IS_EMPTY;
        return last.getValue();
    }

    /**
     * Returns and deletes last item of the list
     * @return Retuns last element of the list
     */
    public int pop() {
        if (isEmpty())
            return LIST_IS_EMPTY;
        int ret = last.getValue();
        last = last.getPrev();
        return ret;
    }

}

class Node {

    private final int value;
    private Node prev;
    private Node next;

    public Node(int i) {
        value = i;
    }

    public int getValue() {
        return value;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}