package com.mini.iterator;

public interface List<E> {
    Iterator iterator();

    void add(E i);

    int size();

    E get(int cursor);
}
