package com.mini.memento;

public class TestMemento {

    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Original originator = new Original();

        originator.setState("State #1");
        originator.setState("State #2");

        caretaker.add(originator.createMemento());

        originator.setState("State #3");
        caretaker.add(originator.createMemento());

        System.out.println("\nCurrent State: " + originator.getState());
        originator.restoreFromMemento(caretaker.get(1));
        System.out.println("Restored State: " + originator.getState());

        originator.restoreFromMemento(caretaker.get(0));
        System.out.println("Restored State: " + originator.getState());
    }
}
