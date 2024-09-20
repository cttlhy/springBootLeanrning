package com.mini.memento;

import java.util.Stack;

public class Caretaker {
    private Stack<Memento> mementoList = new Stack<>();

    public void add(Memento memento){
        mementoList.add(memento);
    }

    public void remove(){
        mementoList.pop();
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
