package org.sansovo.demo.springmvc.chapter13.stub;

import org.junit.Test;
import org.sansovo.demo.springmvc.chapter13.dao.ProductDAO;
import org.sansovo.demo.springmvc.chapter13.service.ProductService;
import org.sansovo.demo.springmvc.chapter13.service.ProductServiceImpl;

import static org.junit.Assert.assertNotNull;

public class ProductServiceImplTest {

    @Test
    public void testCalculateDiscount() {
        ProductDAO productDAO = new ProductDAOStub();
        ProductService productService = new ProductServiceImpl(productDAO);
        assertNotNull(productService);
    }

}
