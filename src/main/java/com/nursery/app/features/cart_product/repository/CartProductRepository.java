package com.nursery.app.features.cart_product.repository;

import com.nursery.app.features.cart_product.entity.CartProduct;
import com.nursery.app.features.cart_product.entity.CartProductId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartProductRepository extends JpaRepository<CartProduct, CartProductId> {
    Optional<CartProduct> findByCart_CartIdAndProduct_ProductId( Integer cartId, Integer productId);

    List<CartProduct> findByCart_CartId(Integer cartId);
}
