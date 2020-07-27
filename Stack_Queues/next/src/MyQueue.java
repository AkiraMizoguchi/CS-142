/*
MyQueue<E>()      Constructs a new queue with elements of type E
add(E value)      Adds val to the back of the queue
remove()          Removes the first value from the queue; throws a NoSuchElementException if the queue is empty
isEmpty()         Returns true if the queue has no elements
size()            Returns the number of elements in the queue
*/

import java.util.*;

public class MyQueue <E> {
    ArrayList<E> elements;

    public MyQueue() {
        elements=new ArrayList<>();
    }

    public void add(E val) {
        elements.add(val);
    }

    public E remove() {
        if(elements.isEmpty()){
            throw new NoSuchElementException();
        }
        E ele=elements.get(0);
        elements.remove(0);
        return ele;
    }

    public E peek() {
        if(elements.isEmpty()){
            throw new NoSuchElementException();
        }
        return elements.get(0);
    }

    public boolean isEmpty() {

        return elements.isEmpty();
    }

    public int size() {
        return elements.size();

    }

    public String toString() {
        return elements.toString();
    }

}


