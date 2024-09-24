package com.mini.iterator;

public interface Iterator<E> {
    boolean hasNext();
    E currentItem();
    void next();
}
