// Akira mizoguchi
// CS 143
// HW Core Topics: Building DoublyLinkedList
import java.util.Iterator;

public class DoublyLinkedList<E> implements Comparable<DoublyLinkedList<E>>, Iterable<E>, List<E> {
    private ListNode<E> front;
    private int size;

    // creates an empty/null list
    public DoublyLinkedList() {
        front = null;
        size = 0;
    }

    // creates a new `front` node without a prev or next
    public DoublyLinkedList(E val) {
        front = new ListNode<>(val, null, null);
        size = 1;
    }

    // Utilized add at index to add a new node at the end of the list
    public void add(E val) {
        add(size, val);
    }

    // Adds a new node at the specified index with the data `val`
    // throws IndexOutOfBounds if the index is invalid (not 0 to size-1)
    public void add(int index, E val) {
        if(index > size || index < 0) {
            throw new IndexOutOfBoundsException("Cannot add at Index " + index);
        }
        size++;
        if(index == 0) {
            front = new ListNode<>(val, front, null);
        } else {
            ListNode<E> cur = front;
            for(int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            ListNode<E> after = cur.next;
            ListNode<E> insert = new ListNode<>(val, after, cur);
            cur.next = insert;
            if(after != null)
                after.prev = insert;
        }
    }

    // Returns the data at a given "virtual" index
    // throws IndexOutOfBounds if the index is invalid (not 0 to size)
    public E get(int index) {
        if(index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " does not exist.");
        }
        ListNode<E> cur = front;
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    // TODO: return the "virtual" index of val, or -1 if not found
    public int indexOf(E val) {
        if(size==0){
            return -1;
        }
        for(int i=0;i<size;i++){
            if(get(i)==val){
                return i;
            }
        }
        return -1;
    }

    // TODO: return the data of the node at the index provided
    public E remove(int index) {
        if(index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " does not exist.");
        }
        size--;
        if(index == 0) {
            E data=front.data;
            front=front.next;
            if(front!=null) {
                front.prev = null;
            }
            return data;
        } else {
            ListNode<E> current=front;
            for(int i=0;i<index;i++){
               current=current.next;
            }
            E data=current.data;
            current.prev.next=current.next;
            if(current.next!=null){
                current.next.prev=current.prev;
            }
            return data;
        }
    }

    // TOGETHER: Allows DoublyLinkedLists to be compared/sorted
    // this method will compered this DoublyLinkedList and other DoublyLinkedList based on the size. if the size of this DoublyLinkedList is
    // less than the other,this will return -1. if the size is the same as the other, this will return 0. If the size is bigger than the other,
    // this will return 1
    public int compareTo(DoublyLinkedList other) {
        if(size>other.size){
            return 1;
        }else if( size<other.size){
            return -1;
        }else{
            return 0;
        }
    }

    // TOGETHER: Allows DoublyLinkedLists to be checked for equality
    //this method will compere other DoublyLinkedList and this DoublyLinkedList.if both of them have same elements, this method will return true. Otherwise,
    //this will return false
    public boolean equals(DoublyLinkedList<E> other) {
        if(this.size!=other.size){
            return false;
        }
        ListNode<E> current1=front;
        ListNode<E> current2=other.front;
        while(this.front!=null){
            if(current1.data!=current2.data)
            {
                return false;
            }
            this.front=front.next;
            other.front=other.front.next;
        }
        return true;
    }

    // Returns the number of nodes in the list
    // O(1) because continuously tracked during construct/add/remove
    public int size() {
        return size;
    }

    // Returns a String representation of this data
    public String toString() {
        if(size() == 0) {
            return "[]"; }

        StringBuilder build = new StringBuilder();
        ListNode<E> cur = front;
        while(cur.next != null) {
            build.append(cur.data + ", ");
            cur = cur.next;
        }
        build.append(cur.data);
        return "[" + build.toString() + "] size=" + size();
    }

    // Returns an iterator to this DoublyLinkedList
    public Iterator<E> iterator() {
        return new DLLIterator();
    }

    // TOGETHER: Create an iterator for this DoublyLinkedList
    // this is Iterator.
    private class DLLIterator implements Iterator<E> {
        // TOGETHER: field to track the linked list node we have currently iterated to
        private int index=0;

        // TOGETHER: is there another node?
        public boolean hasNext() {
            return index<size;
        }

        // TOGETHER: return the next piece of data in the DoublyLinkedList
        public E next() {
            return get(index++);
        }

        public void remove() {
            throw new UnsupportedOperationException("You should not remove using the Iterator.");
        }
    }

}