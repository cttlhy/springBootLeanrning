package com.mini.visitor;

public abstract class ResourceFile {
    protected String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    abstract void accept(Vistitor extrator);
}
