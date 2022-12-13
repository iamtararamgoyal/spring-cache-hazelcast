package com.lcwt.repository;

import com.lcwt.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * Author: - Tara Ram Goyal
 * Date & Time: - 13/12/2022 10:4:53 AM
 * Project: - Spring-Cache-Hazelcast
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
