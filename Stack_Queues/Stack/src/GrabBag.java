/*
   This class is used to make a group of data where you can
   `grab` a random value.
*/

import java.util.*;

public class GrabBag<E> implements Iterable<E> {
    private ArrayList<E> bag;

    public GrabBag() {
        bag = new ArrayList<E>();
    }

    public void add(E data) {
        bag.add(data);
    }

    public E grab() {
        Random r = new Random();
        E removed = bag.remove(r.nextInt(bag.size()));
        return removed;
    }

    public boolean isEmpty() {
        return bag.size() == 0;
    }

    public String toString() {
        return bag.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new GrabBagIterator();
    }

    private class GrabBagIterator implements Iterator<E> {
        protected int index=0;

        @Override
        public boolean hasNext() {
            if(index<bag.size()){
                return true;
            }
            return false;
        }

        @Override
        public E next() {
            return bag.get(index++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Do not remove using the Iterator.");
        }
    }
}