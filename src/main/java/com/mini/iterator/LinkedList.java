package com.mini.iterator;

public class LinkedList<E> implements List<E> {

    private int cursor;
    private java.util.LinkedList<E> linkedList;

    @Override
    public Iterator iterator() {
        return new LinkedIterator(this);
    }

    @Override
    public void add(E i) {
        linkedList.add(i);
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public E get(int cursor) {
        return linkedList.get(cursor);
    }

}
