package org.sansovo.demo.springmvc.chapter11.controller;

import org.sansovo.demo.springmvc.chapter11.domain.Product;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller

public class ProductController {
	
	private static final Log logger = LogFactory.getLog(ProductController.class);
	
	@RequestMapping(value="/input-product")
	public String inputProduct(Model model) {
		model.addAttribute("product", new Product());
		return "ProductForm";
	}

    @RequestMapping(value = "/save-product")
    public String saveProduct(HttpServletRequest servletRequest,
            @ModelAttribute Product product, BindingResult bindingResult,
            Model model) {

        List<MultipartFile> files = product.getImages();

        List<String> fileNames = new ArrayList<String>();

        if (null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {

                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);

                File imageFile = new File(servletRequest.getServletContext()
                        .getRealPath("/image"), fileName);
                try {
                    multipartFile.transferTo(imageFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                logger.info("imageFile: "+ imageFile.getPath());
            }
        }

        // save product here
        model.addAttribute("product", product);
        return "ProductDetails";
    }
	
}
