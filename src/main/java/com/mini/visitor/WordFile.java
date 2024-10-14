package com.mini.visitor;

public class WordFile extends ResourceFile
{
    public WordFile(String filePath) {
        super(filePath);
    }

    @Override
    void accept(Vistitor extrator) {
        extrator.visit(this);
    }
}
