package com.mini.iterator;

public class ArrayIterator<E> implements Iterator<E>{

    private int cursor;
    private List<E> arrayList;

    public ArrayIterator(List<E> arrayList) {
        this.cursor = 0;
        this.arrayList = arrayList;
    }

    @Override
    public boolean hasNext() {
        return cursor != arrayList.size();
    }

    @Override
    public E currentItem() {
        return arrayList.get(cursor);
    }

    @Override
    public void next() {
        cursor++;
    }
}
