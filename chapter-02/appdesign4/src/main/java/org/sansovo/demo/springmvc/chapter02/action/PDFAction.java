package org.sansovo.demo.springmvc.chapter02.action;

import org.sansovo.demo.springmvc.chapter02.service.PDFService;

public class PDFAction {
    private PDFService pdfService;
    public void setPDFService(PDFService pdfService) {
        this.pdfService = pdfService;
    }
    public void createPDF(String path, String input) {
        pdfService.createPDF(path, input);
    }
}
