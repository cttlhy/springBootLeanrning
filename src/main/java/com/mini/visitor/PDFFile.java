package com.mini.visitor;

public class PDFFile extends ResourceFile{

    public PDFFile(String filePath) {
        super(filePath);
    }

    @Override
    void accept(Vistitor extrator) {
        extrator.visit(this);
    }
}
