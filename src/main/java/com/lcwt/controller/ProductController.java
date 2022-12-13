package com.lcwt.controller;

import com.lcwt.model.Product;
import com.lcwt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/***
 * Author: - Tara Ram Goyal
 * Date & Time: - 13/12/2022 10:10:00 AM
 * Project: - Spring-Cache-Hazelcast
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

   @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable int productId, @RequestBody Product product) {
        return service.updateProduct(productId, product);
    }

    @GetMapping
    public List<Product> fetchProductList() {
        return service.fetchProductList();
    }

    @GetMapping("/{productId}")
    public Product fetchProductById(@PathVariable int productId) {
        return service.fetchProductById(productId);
    }

    @DeleteMapping("/{product}")
    public String deleteProduct(int productId) {
        return service.deleteProduct(productId);
    }
}
