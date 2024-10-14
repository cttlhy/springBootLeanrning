package com.mini.visitor;

import java.util.ArrayList;
import java.util.List;

public class TestApp {
    public static void main(String[] args) {

        List<ResourceFile> files = new ArrayList<>();
        files.add(new PDFFile("/dd/pdf"));
        files.add(new PPTFile("/ss/ppt"));
        files.add(new WordFile("/xx/word"));

        Vistitor extrator = new Parse();

        files.forEach(resourceFile -> {
           resourceFile.accept(extrator);
        });

        System.out.println("-------------------------");

        Vistitor extrator1 = new Compress();

        files.forEach(resourceFile -> {
            resourceFile.accept(extrator1);
        });

        System.out.println("-------------------------");

        Vistitor extrator2 = new Extract();

        files.forEach(resourceFile -> {
            resourceFile.accept(extrator2);
        });

    }
}
