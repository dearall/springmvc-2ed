package org.sansovo.demo.springmvc.chapter13.service;

import java.math.BigDecimal;

public interface ProductService {
    BigDecimal calculateDiscount();
    boolean isOnSale(int productId);

}
