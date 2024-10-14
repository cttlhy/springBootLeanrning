package com.mini.visitor;

public class Extract implements Vistitor
{
    @Override
    public void visit(PDFFile pdfFile) {
        System.out.println("Extract pdfFile");
    }

    @Override
    public void visit(PPTFile pptFile) {
        System.out.println("Extract pdfFile");
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.println("Extract pdfFile");
    }
}
