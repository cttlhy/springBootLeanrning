package com.mini.visitor;

public class Parse implements Vistitor {
    @Override
    public void visit(PDFFile pdfFile) {
        System.out.println("Parse pdfFile");
    }

    @Override
    public void visit(PPTFile pptFile) {
        System.out.println("Parse pptFile");
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.println("Parse wordFile");
    }
}
