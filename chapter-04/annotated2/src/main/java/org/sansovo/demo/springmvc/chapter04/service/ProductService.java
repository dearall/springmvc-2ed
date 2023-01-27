package org.sansovo.demo.springmvc.chapter04.service;

import org.sansovo.demo.springmvc.chapter04.domain.Product;

public interface ProductService {
	Product add(Product product);
	Product get(long id);
}
