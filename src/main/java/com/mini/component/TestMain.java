package com.mini.component;

public class TestMain {

    public static void main(String[] args) {
        Directory fileTree = new Directory("/");
        Directory node_x = new Directory("/nodex/");
        Directory node_y = new Directory("/nodey/");

        fileTree.addFile(node_y);
        fileTree.addFile(node_x);

        File f1 = new File("/nodex/f1");
        File f2 = new File("/nodex/f2");

        fileTree.addFile(f1);
        fileTree.addFile(f2);

        System.out.println("file num:"+fileTree.countNumOfFiles());
        System.out.println("file size:"+fileTree.countSizeOfFiles());
    }
}
