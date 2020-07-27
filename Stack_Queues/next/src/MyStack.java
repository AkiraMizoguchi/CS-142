/*
MyStack<E>()   Constructs a new stack with elements of type E
push(val)      Places val on top of the stack
pop()          Removes top value from the stack and returns it; throws NoSuchElementException if stack is empty
peek()         Returns top value from the stack without removing it; throws NoSuchElementException if stack is empty
isEmpty()      Returns true if the stack has no elements
size()         Returns the number of elements in the stack
*/

import java.util.*;

public class MyStack<E> {
    ArrayList<E> elements;

    public MyStack() {
        elements=new ArrayList<>();
    }

    public void push(E val) {
        elements.add(val);
    }

    public E pop() {
        if(elements.isEmpty()){
            throw new NoSuchElementException();
        }
        E ele=elements.get(elements.size()-1);
        elements.remove(elements.size()-1);
        return ele;
    }

    public E peek() {
        if(elements.isEmpty()){
            throw new NoSuchElementException();
        }
        return elements.get(elements.size()-1);
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