package com.mini.core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.net.URL;
import java.util.Iterator;

public class ClassPathXmlResource implements Resource{
    Document document;
    Element rootElement;
    Iterator<Element> iterator;

    public ClassPathXmlResource(String path) {
        SAXReader saxReader = new SAXReader();
        URL resource = this.getClass().getClassLoader().getResource(path);
        try {
            this.document = saxReader.read(resource);
            rootElement = this.document.getRootElement();
            iterator = this.rootElement.elementIterator();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public Object next() {
        return this.iterator.next();
    }
}
