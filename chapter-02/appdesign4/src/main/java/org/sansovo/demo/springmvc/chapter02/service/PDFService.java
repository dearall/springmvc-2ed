package org.sansovo.demo.springmvc.chapter02.service;

import org.sansovo.demo.springmvc.chapter02.util.PDFUtil;

public class PDFService {
    public void createPDF(String path, String input) {
        PDFUtil.createDocument(path, input);
    }
}
