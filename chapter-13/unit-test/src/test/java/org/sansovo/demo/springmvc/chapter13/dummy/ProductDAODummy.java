package org.sansovo.demo.springmvc.chapter13.dummy;

import org.sansovo.demo.springmvc.chapter13.dao.ProductDAO;

import java.math.BigDecimal;

public class ProductDAODummy implements ProductDAO {
    public BigDecimal calculateDiscount() {
        return null;
    }
    public boolean isOnSale(int productId) {
        return false;
    };
}
