package com.mini.iterator;

public class ArrayList<E> implements List<E> {

    private int cursor;
    private java.util.ArrayList<E> arrayList;

    @Override
    public Iterator iterator() {
        return new ArrayIterator(this);
    }

    @Override
    public void add(E i) {
        arrayList.add(i);
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public E get(int cursor) {
        return arrayList.get(cursor);
    }

}
