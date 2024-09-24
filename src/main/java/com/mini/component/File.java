package com.mini.component;

public class File extends FileSystemNode{

    public File(String path) {
        super(path);
    }

    @Override
    int countNumOfFiles() {
        return 1;
    }

    @Override
    long countSizeOfFiles() {
        return 1;
    }
}
