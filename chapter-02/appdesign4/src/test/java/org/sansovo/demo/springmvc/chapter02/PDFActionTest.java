package org.sansovo.demo.springmvc.chapter02;

import org.junit.Test;
import org.sansovo.demo.springmvc.chapter02.action.PDFAction;
import org.sansovo.demo.springmvc.chapter02.util.DependencyInjector;

public class PDFActionTest {
    @Test
    public void testInjectPDFAction(){
        DependencyInjector injector = new DependencyInjector();
        injector.start();
        PDFAction pdfAction = (PDFAction)injector.getObject(PDFAction.class);
        pdfAction.createPDF("1.pdf", "Hello world");
        injector.shutDown();
    }
}
