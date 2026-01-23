package com.nursery.app.features.product.repository;

import com.nursery.app.features.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
