package com.mini.iterator;

public class LinkedIterator<E> implements Iterator<E>{

    private int cursor;
    private List<E> linkedList;

    public LinkedIterator(List<E> linkedList) {
        this.cursor = 0;
        this.linkedList = linkedList;
    }

    @Override
    public boolean hasNext() {
        return cursor != linkedList.size();
    }

    @Override
    public E currentItem() {
        return linkedList.get(cursor);
    }

    @Override
    public void next() {
        cursor++;
    }
}
