package com.mini.component;

import java.io.File;
import java.util.List;

public class FileSystem {
    private String path;
    private boolean isFile;
    private List<FileSystem> subFiles;

    public FileSystem(String path, boolean isFile) {
        this.path = path;
        this.isFile = isFile;
    }

    public int countNumOfFiles(){
        if (isFile){
            return 1;
        }
        int numOfFiles = 0;
        for (FileSystem f : subFiles){
            numOfFiles += f.countNumOfFiles();
        }
        return numOfFiles;
    }

    public long countSizeOfFiles(){
        if (isFile){
            File f = new File(path);
            if (!f.exists()) return 0;
            return f.length();
        }

        long sizeOfFiles = 0;
        for (FileSystem f : subFiles){
            sizeOfFiles += f.countSizeOfFiles();
        }
        return sizeOfFiles;
    }

    public void addFile(FileSystem fileSystem){
        subFiles.add(fileSystem);
    }

    public void removeFile(FileSystem fileSystem){
        subFiles.remove(fileSystem);
    }
}
