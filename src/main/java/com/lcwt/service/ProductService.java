package com.lcwt.service;

import com.lcwt.model.Product;

import java.util.List;

/***
 * Author: - Tara Ram Goyal
 * Date & Time: - 13/12/2022 10:02:53 AM
 * Project: - Spring-Cache-Hazelcast
 */

public interface ProductService {

    Product addProduct(Product product);

    Product updateProduct(int productId, Product product);

    List<Product> fetchProductList();

    Product fetchProductById(int productId);

    String deleteProduct(int productId);
}
