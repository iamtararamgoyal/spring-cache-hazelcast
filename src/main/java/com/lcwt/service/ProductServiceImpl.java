package com.lcwt.service;

import com.lcwt.model.Product;
import com.lcwt.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * Author: - Tara Ram Goyal
 * Date & Time: - 13/12/2022 10:07:20 AM
 * Project: - Spring-Cache-Hazelcast
 */
@CacheConfig(cacheNames = "product")
@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository repository;

    @Override
    @CachePut(key = "#product.id")
    public Product addProduct(Product product) {
        LOGGER.info("ProductServiceImpl::addProduct saved in db");
        return repository.save(product);
    }

    @Override
    @CachePut(key = "#product.id")
    public Product updateProduct(int productId, Product product) {
        LOGGER.info("ProductServiceImpl::updateProduct update in db");
        Product existingProduct = repository.findById(productId).get();
        existingProduct.setName(product.getName());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setRating(product.getRating());
        return repository.save(existingProduct);
    }

    @Override
    @Cacheable
    public List<Product> fetchProductList() {
        LOGGER.info("ProductServiceImpl::fetchProductList from db");
        return repository.findAll();
    }

    @Override
    @Cacheable(key = "#productId")
    public Product fetchProductById(int productId) {
        LOGGER.info("ProductServiceImpl::fetchProductById from db");
        return repository.findById(productId).get();
    }

    @Override
    @CacheEvict(key = "#productId")
    public String deleteProduct(int productId) {
        LOGGER.info("ProductServiceImpl::deleteProduct from db");
        repository.deleteById(productId);
        return "Record deleted successfully";
    }
}
