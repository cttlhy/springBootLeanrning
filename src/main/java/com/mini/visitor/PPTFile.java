package com.mini.visitor;

public class PPTFile extends ResourceFile{

    public PPTFile(String filePath) {
        super(filePath);
    }

    @Override
    void accept(Vistitor extrator) {
        extrator.visit(this);
    }
}
