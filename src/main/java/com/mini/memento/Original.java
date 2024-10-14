package com.mini.memento;

public class Original {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento(){
        System.out.println("保持快照。。。"+state);
        return new Memento(state);
    }

    public void undo(Memento memento){
        state = memento.getState();
    }
}
