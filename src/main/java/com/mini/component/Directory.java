package com.mini.component;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemNode{
    private List<FileSystemNode> subFiles = new ArrayList<>();

    public Directory(String path) {
        super(path);
    }

    @Override
    int countNumOfFiles() {
        int numOfFiles = 0;
        for (FileSystemNode f : subFiles){
            numOfFiles += f.countNumOfFiles();
        }
        return numOfFiles;
    }

    @Override
    long countSizeOfFiles() {
        long sizeOfFiles = 0;
        for (FileSystemNode f : subFiles){
            sizeOfFiles += f.countSizeOfFiles();
        }
        return sizeOfFiles;
    }

    public  void addFile(FileSystemNode fileSystem){
        subFiles.add(fileSystem);
    }

    public void removeFile(FileSystemNode fileSystem){
        subFiles.remove(fileSystem);
    }
}
