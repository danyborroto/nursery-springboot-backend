package com.nursery.app.features.cart.repository;

import com.nursery.app.features.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    //Optional<Cart> findByUserIdActiveTrue(Integer userId);
}
