package org.sansovo.demo.springmvc.chapter13.stub;

import org.sansovo.demo.springmvc.chapter13.dao.ProductDAO;

import java.math.BigDecimal;

public class ProductDAOStub implements ProductDAO {
    public BigDecimal calculateDiscount() {
        return new BigDecimal(14);
    }
    public boolean isOnSale(int productId) {
        return false;
    };
}
