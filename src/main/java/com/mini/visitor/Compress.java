package com.mini.visitor;

public class Compress implements Vistitor
{
    @Override
    public void visit(PDFFile pdfFile) {
        System.out.println("Compress pdfFile");
    }

    @Override
    public void visit(PPTFile pptFile) {
        System.out.println("Compress pdfFile");
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.println("Compress pdfFile");
    }
}
