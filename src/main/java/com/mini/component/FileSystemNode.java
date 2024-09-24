package com.mini.component;

public abstract class FileSystemNode {
    protected String path;

    public FileSystemNode(String path) {
        this.path = path;
    }

    abstract int countNumOfFiles();

    abstract long countSizeOfFiles();
}
