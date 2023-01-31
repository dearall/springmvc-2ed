package org.sansovo.demo.springmvc.chapter13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;

@Controller
public class WebAppController {
    
    // ServletContext cannot be used as a method parameter, inject instead.
    @Autowired
    private ServletContext servletContext; 
    
	@RequestMapping(value="/getWebAppDir")
    public String getWebAppDirectory(Model model) {
        model.addAttribute("webAppDir", servletContext.getRealPath("/"));
        return "success";
    }
}