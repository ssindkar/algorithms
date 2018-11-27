package com.shalaka;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {

    private final Iterator<Integer> iterator;
    Integer current = null;
    Integer peek = null;
    boolean peeked = false;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(peeked){
            return peek;
        }

        if(iterator.hasNext()) {
            peek = iterator.next();
            peeked = true;
            return peek;
        } else{
            return null;
        }
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!peeked) {
            current = iterator.next();
            return current;
        } else {
            peeked = false;
            return peek;
        }
    }

    @Override
    public boolean hasNext() {
        if(!peeked){
            return iterator.hasNext();
        } else {
            return peek != null;
        }
    }

    public static void main(String[] args){
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);


//        [0,1,1,2,2,1,1,2,0,1,0,2,0]
//        ["true","1","1","1","2","3","3","3","true","4","true","4","false"]

        Iterator iterator= list.iterator();
        PeekingIterator peekingIterator = new PeekingIterator(iterator);
        System.out.println(peekingIterator.hasNext());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.hasNext());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.hasNext());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.hasNext());
    }
}
