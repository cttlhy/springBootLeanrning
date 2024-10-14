package com.mini.visitor;

public interface Vistitor {

    public void visit(PDFFile pdfFile);

    public void visit(PPTFile pptFile);

    public void visit(WordFile wordFile);
}
