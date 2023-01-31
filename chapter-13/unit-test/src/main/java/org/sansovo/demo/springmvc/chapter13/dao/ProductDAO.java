package org.sansovo.demo.springmvc.chapter13.dao;

import java.math.BigDecimal;

public interface ProductDAO {
    BigDecimal calculateDiscount();
    boolean isOnSale(int productId);
}
